package Project2.server;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import Project2.common.Constants;


public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private String name;
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    private boolean isRunning = false;


    private List<String> mutedUsers = new ArrayList<String>(); // List to store muted usernames

    private static final String MUTED_USERS_FILE = "muted_users.txt";


    // Commands
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";


    private final static String ROLL = "roll";
    private final static String FLIP = "flip";


    private final static String MUTE = "mute";
    private final static String UNMUTE = "unmute";


    private static Logger logger = Logger.getLogger(Room.class.getName());


    public Room(String name) {
        this.name = name;
        isRunning = true;
        loadMutedUsers();
    }


    public String getName() {
        return name;
    }


    public boolean isRunning() {
        return isRunning;
    }


    protected synchronized void addClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }


    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }


    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }


    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }


    /***
     * Helper function to process messages to trigger different functionality.
     *
     * @param message The original message being sent
     * @param client  The sender of the message (since they'll be the ones
     *                triggering the actions)
     */
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
    private boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                wasCommand = true;
                switch (command) {
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;


                        case "mute":
                        String targetUsername = comm2[1];
                        muteUser(client, targetUsername);
                        break;


                    case "unmute":
                        targetUsername = comm2[1];
                        unmuteUser(client, targetUsername);
                        break;
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }


    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }


    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }


    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     *
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }


    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }
    // end command helper methods


    /***
     * Takes a sender and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     *
     * @param sender  The client sending the message
     * @param message The message to broadcast inside the room
     */
    protected synchronized void sendMessage(ServerThread sender, String message) {
        if (!isRunning) {
            return;
        }
   
        if (sender != null && processCommands(message, sender)) {
            // If it was a command, don't broadcast
            return;
        }
   
        if (sender != null && mutedUsers.contains(sender.getClientName())) {
            sender.sendMessage(Constants.DEFAULT_CLIENT_ID, "You are muted");
            return;
        }
   
        String formattedMessage = processFormatting(message);
   
        // Iterate through clients and send the message
        for (ServerThread client : clients) {
            if (!mutedUsers.contains(client.getClientName())) {
                boolean messageSent = client.sendMessage(sender.getClientId(), formattedMessage);
                if(!messageSent){
                    //handleDisconnect(client);
                }
            }
        }
   
        // Additional logic for handling special cases
        if (sender != null && message.startsWith(COMMAND_TRIGGER)) {
            // Process message commands
            processMessageCommand(message, sender);
        }
   
        if (message.startsWith("@")) {
            sendPrivateMessage(sender, message);
        }
    }
    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }


    private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        iter.remove();
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }


    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
private void processMessageCommand(String message, ServerThread sender) {
        try {
            String[] commandParts = message.split(" ");
            String command = commandParts[0].substring(1);
           
            switch (command) {
                case ROLL:
                    handleRollCommand(commandParts, sender);
                    break;
                case FLIP:
                    handleFlipCommand(sender);
                    break;




                default:
                    // Handle other commands if needed
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    private void handleRollCommand(String[] commandParts, ServerThread sender) {
        try {
            int result;
   
            if (commandParts.length == 2) {
                // /roll #d#
                String[] diceParams = commandParts[1].split("d");
                if (diceParams.length == 2) {
                    int numDice = Integer.parseInt(diceParams[0]);
                    int numSides = Integer.parseInt(diceParams[1]);
   
                    Random random = new Random();
                    int total = 0;
                    for (int i = 0; i < numDice; i++) {
                        int roll = random.nextInt(numSides) + 1;
                        total += roll;
                    }
   
                    // Send total roll to client
                    sendMessage(sender, "*rolled a " + total + "*");
                } else {
                    // Check for single die roll
                    int numSides = Integer.parseInt(commandParts[1]);
                    int roll = new Random().nextInt(numSides) + 1;
   
                    // Send single die roll to client
                    sendMessage(sender, "*rolled a " + roll + "*");
                }
            } else {
                // Invalid roll command format
                sendMessage(sender, "Invalid /roll command format. Use 'roll #d#' or 'roll #'");
            }
        } catch (NumberFormatException e) {
            sendMessage(sender, "Invalid /roll command format. Use 'roll #d#' or 'roll #'");
        }
    }
   
    private void handleFlipCommand(ServerThread sender) {
        // Coin toss (0 heads 1 tails)
        int result = (int) (Math.random() * 2);
   
        // converts 0 and 1 to heads and tails
        String flipResult = (result == 0) ? "heads" : "tails";
   
        // sends result to client
        sendMessage(sender, "*flipped a coin and got " + flipResult + "*");
    }




   
    private String processFormatting(String message) {
        // regex for styles
        Pattern boldPattern = Pattern.compile("\\*(.*?)\\*");
        Pattern italicPattern = Pattern.compile("\\-(.*?)\\-");
        Pattern underlinePattern = Pattern.compile("\\_(.*?)\\_");
        Pattern redPattern = Pattern.compile("\\[r (.*?) r\\]");
        Pattern greenPattern = Pattern.compile("\\[g (.*?) g\\]");
        Pattern bluePattern = Pattern.compile("\\[b (.*?) b\\]");
   
        // Replace with HTML tags
        message = replacePattern(message, boldPattern, "<b>$1</b>");
        message = replacePattern(message, italicPattern, "<i>$1</i>");
        message = replacePattern(message, underlinePattern, "<u>$1</u>");
        message = replacePattern(message, redPattern, "<font color=red>$1</font>");
        message = replacePattern(message, greenPattern, "<font color=green>$1</font>");
        message = replacePattern(message, bluePattern, "<font color=blue>$1</font>");
   
        return message;
    }
   
    private String replacePattern(String input, Pattern pattern, String replacement) {
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        return result.toString();
    }
    private void sendPrivateMessage(ServerThread sender, String message) {
       
        String[] parts = message.split(" ", 2);
        if (parts.length == 2) {
            String username = parts[0].substring(1);
            String privateMessage = parts[1];


           
            ServerThread receiver = findClientByUsername(username);


           
            if (receiver != null) {
               
                sender.sendMessage(sender.getClientId(), "[Private] to @" + username + ": " + privateMessage);
                receiver.sendMessage(sender.getClientId(), "[Private] from @" + sender.getClientName() + ": " + privateMessage);
            } else {
               
                sender.sendMessage(Constants.DEFAULT_CLIENT_ID, "User @" + username + " not found.");
            }
        }
    }


    private ServerThread findClientByUsername(String username) {
        for (ServerThread client : clients) {
            if (client.getClientName().equalsIgnoreCase(username)) {
                return client;
            }
        }
        return null;
    }
//JMA85 12/13/23 Muted/Unmuted Messages
    private void muteUser(ServerThread sender, String targetUsername) {
        ServerThread targetUser = findClientByUsername(targetUsername);
        if (targetUser != null) {
            mutedUsers.add(targetUsername);
            saveMutedUsers();  
            sender.sendMessage(Constants.DEFAULT_CLIENT_ID, "You have muted @" + targetUsername);
            targetUser.sendMessage(sender.getClientId(), "You have been muted by @" + sender.getClientName());
        } else {
            sender.sendMessage(Constants.DEFAULT_CLIENT_ID, "User @" + targetUsername + " not found.");
        }
    }

    private void unmuteUser(ServerThread sender, String targetUsername) {
        ServerThread targetUser = findClientByUsername(targetUsername);
        if (targetUser != null) {
            mutedUsers.remove(targetUsername);
            saveMutedUsers();  
            sender.sendMessage(Constants.DEFAULT_CLIENT_ID, "You have unmuted @" + targetUsername);
            targetUser.sendMessage(sender.getClientId(), "You have been unmuted by @" + sender.getClientName());
        } else {
            sender.sendMessage(Constants.DEFAULT_CLIENT_ID, "User @" + targetUsername + " not found.");
        }
    }

    
    private void saveMutedUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(MUTED_USERS_FILE))) {
            for (String mutedUser : mutedUsers) {
                writer.println(mutedUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMutedUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(MUTED_USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mutedUsers.add(line);
            }
        } catch (IOException e) {
            
        }
    }

}


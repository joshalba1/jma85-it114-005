package Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Room implements AutoCloseable{
	protected static Server server;// used to refer to accessible server functions
	private String name;
	private List<ServerThread> clients = new ArrayList<ServerThread>();
	private boolean isRunning = false;
	// Commands
	private final static String COMMAND_TRIGGER = "/";
	private final static String CREATE_ROOM = "createroom";
	private final static String JOIN_ROOM = "joinroom";
	private final static String DISCONNECT = "disconnect";
	private final static String ROLL = "roll";
	private final static String FLIP = "flip";
	private final static String LOGOUT = "logout";
	private final static String LOGOFF = "logoff";

	public Room(String name) {
		this.name = name;
		isRunning = true;
	}

	private void info(String message) {
		System.out.println(String.format("Room[%s]: %s", name, message));
	}

	public String getName() {
		return name;
	}

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			new Thread() {
				@Override
				public void run() {
					// slight delay to let potentially new client to finish
					// binding input/output streams
					// comment out the Thread.sleep to see what happens
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//sendMessage(client, "joined the room " + getName());
					sendConnectionStatus(client, true);
				}
			}.start();

		}
	}

	protected synchronized void removeClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		clients.remove(client);
		// we don't need to broadcast it to the server
		// only to our own Room
		if (clients.size() > 0) {
			//sendMessage(client, "left the room");
			sendConnectionStatus(client, false);
		}
		checkClients();
	}

	/***
	 * Checks the number of clients.
	 * If zero, begins the cleanup process to dispose of the room
	 */
	private void checkClients() {
		// Cleanup if room is empty and not lobby
		if (!name.equalsIgnoreCase("lobby") && clients.size() == 0) {
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
	protected static void createRoom(String roomName, ServerThread client) {
		if (server.createNewRoom(roomName)) {
			//server.joinRoom(roomName, client);
			Room.joinRoom(roomName, client);
		} else {
			client.sendMessage("Server", String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!server.joinRoom(roomName, client)) {
			client.sendMessage("Server", String.format("Room %s doesn't exist", roomName));
		}
	}

	protected static void disconnectClient(ServerThread client, Room room) {
		client.setCurrentRoom(null);
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
		info("Sending message to " + clients.size() + " clients");
		if (sender != null && processCommands(message, sender)) {
			// it was a command, don't broadcast
			return;
		}
		if (sender != null && message.startsWith(COMMAND_TRIGGER)) {
			// Process message commands
			processMessageCommand(message, sender);
		} else {
			String from = (sender == null ? "Room" : sender.getClientName());
			String formattedMessage = processFormatting(message);
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				boolean messageSent = client.sendMessage(from, formattedMessage);
				if (!messageSent) {
					handleDisconnect(iter, client);
				}
			}
		}
	}
	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected){
		Iterator<ServerThread> iter = clients.iterator();
		while (iter.hasNext()) {
			ServerThread client = iter.next();
			boolean messageSent = client.sendConnectionStatus(sender.getClientName(), isConnected);
			if (!messageSent) {
				handleDisconnect(iter, client);
			}
		}
	}
	private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client){
		iter.remove();
		info("Removed client " + client.getClientName());
		checkClients();
		sendMessage(null, client.getClientName() + " disconnected");
	}
	public void close() {
		server.removeRoom(this);
		server = null;
		isRunning = false;
		clients = null;
	}

	//JMA85 11/10/23
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
					sendMessage(sender, "rolled a " + total);
				} else {
					// Check for single die roll
					int numSides = Integer.parseInt(commandParts[1]);
					int roll = new Random().nextInt(numSides) + 1;
	
					// Send single die roll to client
					sendMessage(sender, "rolled a " + roll);
				}
			} else {
				// Invalid roll command format
				sender.sendMessage("Server", "Invalid /roll command format. Use 'roll #d#' or 'roll #'");
			}
		} catch (NumberFormatException e) {
			sender.sendMessage("Server", "Invalid /roll command format. Use 'roll #d#' or 'roll #'");
		}
	}
	
	private void handleFlipCommand(ServerThread sender) {
		// Coin toss (0 heads 1 tails)
		int result = (int) (Math.random() * 2);
	
		// converts 0 and 1 to heads and tails
		String flipResult = (result == 0) ? "heads" : "tails";
	
		// sends result to client
		sendMessage(sender, "flipped a coin and got " + flipResult);
	}


	//JMA85 1
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
	
	

}


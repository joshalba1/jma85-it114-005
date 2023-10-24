<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Joshua Alba (jma85)</td></tr>
<tr><td> <em>Generated: </em> 10/23/2023 10:12:35 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-milestone1/grade/jma85" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project if one doesn't exist yet</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github (yes it'll be blank for now)</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet, just have it in open status)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Fix the package references at the top of each file (these are the only edits you should do at this point)</li><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><ol><li>Note: The client commands likely are different in part 5 with the /name and /connect options instead of just connect</li></ol><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-22T20.27.04m1ss1.PNG.webp?alt=media&token=5e9a578d-bdd8-48d7-9b41-f056b677cee7"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot shows server in the terminal, server is listening to port 3000.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-22T20.29.11m1ss3.PNG.webp?alt=media&token=5441619b-06a5-4912-b2bd-a8a3baf2934e"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot shows that when the client is run it waits for input and<br>client can connect to the server<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>The server side connection works by first listening for client connections on port<br>3000. When someone tries to connect, the server accepts the connection and creates<br>a Socket for connection to the client. For the client side connection the<br>connection works by taking the users IP and port number. When the client<br>is connected a socket is created connecting to the port. The server socket<br>listens for connections, when a client tries to connect a socket is created<br>on the server and client, when the socket connection is created the server<br>waits for messages from the client.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-22T20.43.03ss.PNG.webp?alt=media&token=a622c022-2dbe-4abe-ab73-db578432386e"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot shows clients connecting to server, Josh and Bob, clients can send messages<br>to the server, everyone in the server gets the messages, when one client<br>joins a room the other client cant see the messages.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted (sent to all connected clients), and received</td></tr>
<tr><td> <em>Response:</em> <p>When the client sends a message a payload is created with the message<br>and client information and is sent to the server. The server thread handles<br>the communications with the specific client. The server thread listens for the payload<br>when it is received the message is processed based on the payload type.<br>The server thread sends messages to the clients with a payload object. The<br>room sends messages to all clients within the room. It runs over the<br>server thread and uses the sendMessage to broadcast messages to all the clients<br>in the room.The client is continuously listening for incoming messages from the server.<br>It reads payload objects from the server. When a payload is received it<br>processes the message<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-22T20.47.18ss3.PNG.webp?alt=media&token=8635bef5-fd3b-4281-8cd6-0012d94c2ddc"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows that client can leave with /disconnect and server still runs<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-22T23.19.37mm.PNG.webp?alt=media&token=a290bc7e-40f3-44f4-8917-5194642db860"/></td></tr>
<tr><td> <em>Caption:</em> <p>When server is terminates client is disconnected and client cannot send messages to<br>server.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>A client gets disconnected by closing the socket on the clients end. A<br>client program doesn&#39;t crash when the server disconnects because the client handles exceptions<br>for any issues. When the client disconnects the server thread detects for disconnections,<br>allowing the server to stay up even when multiple clients disconnect.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/joshalba1/jma85-it114-005/pull/10">https://github.com/joshalba1/jma85-it114-005/pull/10</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p>I learned how to set up a server that can connect multiple clients<br>that can separate into different rooms. I also learned how to set up<br>names for the clients. <br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-milestone1/grade/jma85" target="_blank">Grading</a></td></tr></table>
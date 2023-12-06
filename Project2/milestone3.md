<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Joshua Alba (jma85)</td></tr>
<tr><td> <em>Generated: </em> 12/6/2023 6:10:22 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone3/grade/jma85" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-05T19.40.051234.PNG.webp?alt=media&token=245c276f-d536-41d6-b4c7-372ba1c14aa3"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot showing host, port, and username<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p>In order to connect there is a panel for the host, port, and<br>username. When the user enters these they are able to connect and their<br>info is taken.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-05T19.46.2545.PNG.webp?alt=media&token=5de9de57-cee8-4d6c-8b08-3ac4d06b9b6c"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot showing users, chat history, and area is create messages with a send<br>button.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-05T19.48.40enterCode.PNG.webp?alt=media&token=a9708ee8-9f96-4a74-a764-e1f7d45f20c3"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code for using enter key to send messages<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-05T19.53.24commandsCode.PNG.webp?alt=media&token=462eb8ba-712b-4f8d-a469-b559d86bd5d3"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot showing /flip, /roll, output is in bold<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-05T19.58.14rollflip.PNG.webp?alt=media&token=f040d34f-ee83-490e-9bf3-c086bde261c3"/></td></tr>
<tr><td> <em>Caption:</em> <p>/flip and /roll code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-05T19.58.21textFormat.PNG.webp?alt=media&token=d41da9e8-bf43-45ca-99dd-c0ed890ba952"/></td></tr>
<tr><td> <em>Caption:</em> <p>Text format logic code<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <div>/roll works by first checking if the user entered /roll # or /roll<br>#d#. If the command has only one parameter and the split using "d"<br>results in an array of length not equal to 2, it means the<br>command is in the format of /roll #, otherwise its /roll #d#.&nbsp; If<br>it is /roll # a random int is generated less than or equal<br>to the number of sides that the user entered. If it /roll #d#<br>there is a for loop that runs based on the amount of dice<br>and a random number is found for each of the dice based on<br>the number of sides and each of the numbers are added together. Formatting<br>works by using the regex pattern for the specific style that the user<br>enclosed the text in. It uses the regex to replace it with the<br>html tag equivalent. The <br></div><div><br></div><div>The server can manage multiple clients. Clients can join<br>different rooms to communicate with each other. Payload is used as a means<br>of communication between the server and clients. It acts as a container for<br>information that needs to be transmitted over the network.<br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-05T20.13.57customtext.PNG.webp?alt=media&token=f0985806-329a-4a55-bd4a-8892d1cbc535"/></td></tr>
<tr><td> <em>Caption:</em> <p>text saying bold, italic, red, green, and underline shows those styles, the text<br>saying combination in red shows all of them working together on one piece<br>of text.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>I got the UI side to render the text by changing the JEditorPane<br>to display HTML formatted text. <br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-06T02.39.27whisper.PNG.webp?alt=media&token=d89bba7e-326a-4d46-848c-4e728e1a5cae"/></td></tr>
<tr><td> <em>Caption:</em> <p>3 Clients using whisper command<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-06T02.40.16whisperCommand.PNG.webp?alt=media&token=09a57b4e-9742-4731-b8c9-534d381faf43"/></td></tr>
<tr><td> <em>Caption:</em> <p>Whisper Code<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <div data-message-author-role="assistant" data-message-id="517e973c-7108-4a27-b468-3277c6b9bb49" class="min-h-[20px] text-message flex flex-col items-start gap-3 whitespace-pre-wrap break-words [.text-message+&amp;]:mt-5 overflow-x-auto"><div<br>class="markdown prose w-full break-words dark:prose-invert dark"><p>The whisper command is started by messages starting<br>with @. The sendPrivateMessage method goes through the whisper message, finds the username<br>and then finds the ServerThread object associated with the target user. If the<br>target user is found, two private messages are sent one to the sender<br>saying that their message was sent and another to the target user including<br>the sender's username and the private message. If the target user is not<br>found, a message is sent to the sender telling them that the specified<br>user was not found. <br></p></div></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-06T22.30.22mute.PNG.webp?alt=media&token=ecb532c9-2974-4d20-a319-11a6dcd4f831"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot showing 3 clients with mute command being used<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-06T22.31.36muteCode.PNG.webp?alt=media&token=cd0d4378-08e6-45d0-98a3-1ee96ec303b8"/></td></tr>
<tr><td> <em>Caption:</em> <p>Mute code screenshot<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>First, there is a list that contains all the usernames of the muted<br>users. If the /mute command is called and the username is found their<br>name is added to the muted users list. Then, the muted user isn&#39;t<br>allowed to send messages to the user that muted them. When the /unmute<br>command is called it removes their name from the muted users list and<br>they are able to type to the muted user again.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/joshalba1/jma85-it114-005/pull/13">https://github.com/joshalba1/jma85-it114-005/pull/13</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone3/grade/jma85" target="_blank">Grading</a></td></tr></table>
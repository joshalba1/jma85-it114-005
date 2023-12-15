<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Joshua Alba (jma85)</td></tr>
<tr><td> <em>Generated: </em> 12/13/2023 11:59:11 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone4/grade/jma85" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-13T17.54.35exportUI.PNG.webp?alt=media&token=66ecdf64-77f8-4149-bc74-4744e6d4049e"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows client UI with an export button<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-13T17.57.29export.PNG.webp?alt=media&token=2c453292-d7d7-46fb-9c90-efcb0bbd2b79"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows chat_export.txt file updating when export button is clicked<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>First I added a button that says Export History, when this button is<br>clicked a file named chat_export.txt is created. It then goes through each of<br>the components of the chatArea, where all the chat messages are shown. It<br>takes all the messages and writes them into the chat_export.txt file. <br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-13T18.26.36muteFile.PNG.webp?alt=media&token=82d5212e-e2fb-4d52-b62b-b47230c3234e"/></td></tr>
<tr><td> <em>Caption:</em> <p>Mute list stored in a txt file<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-13T18.29.26Mute2.PNG.webp?alt=media&token=06f8a5ec-eb87-44fd-9c7a-32357de71492"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows code where mute list writes to text file<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I created a method called saveMutedUsers that is called when a user is<br>either muted or unmuted. In the saveMutedUsers method a PrintWriter is created, it<br>then goes through the list of muted users and for each muted user<br>it writes their username to the mutedUsers.txt file. If a user is muted<br>their name is added to the muted user list which writes their name<br>to the text file, if they are unmuted their name is removed from<br>the muted users list and are removed from the text file. <br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-13T18.05.54mutee.PNG.webp?alt=media&token=abf08fc4-ae8c-4408-b38a-92cbf407ef23"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows messages to inform muted or unmuted person<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-12-13T19.03.58muteUnmuteMessageCode2.PNG.webp?alt=media&token=57cbfa45-e5f1-4f66-bc1d-ca9baa4fe5de"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows code for muted/unmuted messages<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>When a user is muted a message is sent to the user that<br>send the mute command that they muted someone else, a message is also<br>sent to the person that was muted saying they have been muted by<br>them. The same thing is done when they unmute them. <br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>There is a payload for muted and unmuted users. There is also a<br>method in UserListPanel that goes through components in a user list area, and<br>changes the text color of associated components to yellow if they represent the<br>specific user, and black otherwise.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone4/grade/jma85" target="_blank">Grading</a></td></tr></table>
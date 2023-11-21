<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Joshua Alba (jma85)</td></tr>
<tr><td> <em>Generated: </em> 11/20/2023 10:26:22 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone-2/grade/jma85" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-11-20T16.57.17payloadcode.png.webp?alt=media&token=e8cb9639-ab7b-4d04-8c85-0d09594bbce1"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of Payload code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-11-20T16.57.23payloadterminal.png.webp?alt=media&token=a46dc750-1791-4d60-8fdc-f34f38bdb905"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of terminal<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-11-21T02.56.47rollcode2.png.webp?alt=media&token=8a66253e-c74d-4282-8d05-f259768ab37f"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code for /flip and /roll<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <div>For the /roll to determine which format is used it checks if the<br>command has only one parameter and the split using "d" results in an<br>array of length not equal to 2, it means the command is in<br>the format of /roll #, otherwise its /roll #d#. If it is /roll<br># a random int is generated less than or equal to the number<br>of sides. If it /roll #d# there is a for loop that runs<br>based on the amount of dice and a random number is found for<br>each of the dice based on the number of sides and each of<br>the numbers are added together.</div><div><br></div><div>/flip works by generating a random number, 0 or<br>1, when the number is created it is converted to heads or tails,<br>0 for head and 1 for tails. <br> </div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-11-20T17.06.45stylecode.png.webp?alt=media&token=390dbf3c-4544-4b33-9c42-160fdc52736e"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code for style handling<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-11-20T17.10.06styleterminal.png.webp?alt=media&token=cf06205d-230e-4625-b52b-2c95975c139e"/></td></tr>
<tr><td> <em>Caption:</em> <p>Result of styling in terminal<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>For bold, the regex \<em>(.</em>?)\* matches text wrapped with asterisks, the method replaces<br>the matched pattern with HTML bold tags (&lt;b&gt; and &lt;/b&gt;). For italics, the<br>regex \-(.<em>?)\- matches text wrapped in hyphens, the method replaces the matched pattern<br>with HTML italic tags (&lt;i&gt; and &lt;/i&gt;). For underline, the regex \_(.</em>?)\_ matches<br>text wrapped in underscores, the method replaces the matched pattern with HTML underline<br>tags (&lt;u&gt; and &lt;/u&gt;). For color, the pattern \[r (.*?) r\] matches text<br>wrapped in [r ] tags, the method replaces the matched pattern with HTML<br>font tags specifying red color (&lt;font color=red&gt; and &lt;/font&gt;).<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/joshalba1/jma85-it114-005/pull/11">https://github.com/joshalba1/jma85-it114-005/pull/11</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-chatroom-milestone-2/grade/jma85" target="_blank">Grading</a></td></tr></table>
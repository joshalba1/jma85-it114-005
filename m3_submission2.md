<table><tr><td> <em>Assignment: </em> IT114 - Number Guesser</td></tr>
<tr><td> <em>Student: </em> Joshua Alba (jma85)</td></tr>
<tr><td> <em>Generated: </em> 10/2/2023 10:57:00 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-number-guesser/grade/jma85" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create the below branch name</li><li>Implement the NumberGuess4 example from the lesson/slides</li><ol><li><a href="https://gist.github.com/MattToegel/aced06400c812f13ad030db9518b399f">https://gist.github.com/MattToegel/aced06400c812f13ad030db9518b399f</a><br></li></ol><li>Add/commit the files as-is from the lesson material (this is the base template)</li><li>Pick two (2) of the following options to implement</li><ol><li>Display higher or lower as a hint after a wrong guess</li><li>Implement anti-data tampering of the save file data (reject user direct edits)</li><li>Add a difficulty selector that adjusts the max strikes per level</li><li>Display a cold, warm, hot indicator based on how close to the correct value the guess is (example, 10 numbers away is cold, 5 numbers away is warm, 2 numbers away is hot; adjust these per your preference)</li><li>Add a hint command that can be used once per level and only after 2 strikes have been used that reduces the range around the correct number (i.e., number is 5 and range is initially 1-15, new range could be 3-8 as a hint)</li><li>Implement separate save files based on a "What's your name?" prompt at the start of the game</li></ol><li>Fill in the below deliverables</li><li>Create an m3_submission.md file and fill in the markdown from this tool when you're done</li><li>Git add/commit/push your changes to the HW branch</li><li>Create a pull request to main</li><li>Complete the pull request</li><li>Grab the link to the m3_submission.md from the main branch and submit that direct link to github</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Implementation 1 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-03T01.24.36hwscreenshot.PNG.webp?alt=media&token=b2af9144-fcf7-434a-b80e-0cf477db8b13"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows the implementation of a cold, warm, and hot indicator based on how<br>close the guess is to the correct answer on lines 138-144<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-03T01.25.43outputscreenshot.PNG.webp?alt=media&token=26e14413-da3d-4d27-9d99-73f0f4eae3a2"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the the code correctly runs<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>First, I created a variable called difference that is the guess minus the<br>number. Then, there are three if statements to find if the guess is<br>cold, warm, or hot. If the difference is greater than or equal to<br>ten, a message is printed saying the guess is cold. If the difference<br>is greater than five and less than ten, a message is printed saying<br>the guess is warm. When the guess is less than five, a message<br>is printed saying the guess is hot.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Implementation 2 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-03T01.26.15hwscreenshot.PNG.webp?alt=media&token=9c94732d-cb44-4e1d-87ac-9247806d2fd1"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows that the option to show a higher or lower hint after a<br>wrong guess is implemented on lines 146-150.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fjma85%2F2023-10-03T01.26.50outputscreenshot.PNG.webp?alt=media&token=cbfb8ac1-e4cd-45db-a2cb-3fff935042de"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows that the code runs<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>First, I created an if statement that prints &quot;Your guess is higher than<br>the correct number&quot; when the guess entered is greater than the correct number.<br>Then, I created an else statement that prints &quot;Your guess is lower than<br>the correct number&quot;.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a link to the related pull request of this hw</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/joshalba1/jma85-it114-005/pull/6">https://github.com/joshalba1/jma85-it114-005/pull/6</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Discuss anything you learned during this lesson/hw or any struggles you had</td></tr>
<tr><td> <em>Response:</em> <p>One thing that I learned was file I/O and how it works. File<br>I/O stand for input/output, input is what the program receives from the user<br>and output is the response of the program. It also lets us store<br>data.<br><br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-005-F23/it114-number-guesser/grade/jma85" target="_blank">Grading</a></td></tr></table>

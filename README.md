# Automated QA Testing of the Website Trivia

<h3>Description of the web application Trivia.</h3>
Application is intended for the creation of tests and their execution.</br>
It works on Chrome and Firefox browsers.</br>
When site opened can be created 3 questions and 4 option answers for each one of them.</br> 
Each question is up to 50 characters long (not including a question mark).</br>
Can be added a question mark (if you do not add the application itself will add it separately).</br>
Questions can only be created in English.</br>
For each question, 4 types of answers are created, also in English only.</br> 
Answers can be no more than 30 characters.</br>
When the answer page first appears on the screen, none of the answers are selected.</br>
Can be selected only one answer to the question asked. After the answer marked, can  be marked another answer.</br> 
The selected radio button will disappear from the previously marked answer and move to the newly selected answer.</br>
Back button used to return to the previous screen showing the previous answer or question and they can be edited again.</br>
Next buttom used to move to the next screen.</br>

When Next button clicked on the answer page of the last(third) question,</br> 
a screen with the Play and Quit buttons will be shown.</br>
When the Quit button clicked, the application closes.</br>
When the Play button clicked, the test will begin, questions will appear randomly.</br>
A question and 4 answers to it will appear on the screen.</br>
Can't move to another screen without marking one of the answers.</br>
Can be selected only one answer to the question asked. After the answer marked, can  be marked another answer.</br> 
The selected radio button will disappear from the previously marked answer and move to the newly selected answer.</br>
Unable to select more than one answer. Can be changed the answer after marking.</br>
Clicking Next will bring up the following question with answer options.</br>
After we answered the last (third) question and clicked Next,</br> 
a screen appears informing whether the test passed successfully (Success !! / Failed)</br>
If all the answers are correct, then the word - Success !!</br>
If one of the answers is incorrect, then the word - Failed !!</br>
By clicking on the Share on Facebook button, the result will be published on Facebook.</br>
When you try Try again, the test starts again.</br>
When you click the Quit button, the application closes.</br>

<h3>STD</h3>
The following types of tests were done:</br>
<b>Sanity</b> in order to verify that the critical functional parts of the application work as expected.</br>
<b>Functionality</b> to check all available features.</br>
<b>Error Handling</b> in order to check how the application handles errors.</br>
<b>Integration</b> to check how the application interacts with third-party resources.</br>
<b>Compatability</b> in order to check how the application works on different browsers.</br>

<h3>Automated QA Testing</h3>
Automated QA Testing process was written in Java using Junit and the Selenium.</br>
The <b>TriviaSanityTest.java</b> and <b>Sanity.java</b> classes were created in which Sanity tests were performed using Junit and Selenium to verify that the critical functional parts of the application work as expected </br>
<b>Functionality</b> classes checked all possible features such as Back and Next buttons,</br> 
Play and Quit, Try again, Success !! / Failed.</br>
<b>IntegrationpressFacebookButton.java</b> class tested interactions with Facebook.</br>
In the classes <b>Answer.java, Question.java, TriviaSanityTest.java</b>, objects for answers, questions, and tests were created.

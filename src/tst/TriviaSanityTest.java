package tst;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TriviaSanityTest {

    private TriviaTest triviaTest = null;

	
	public TriviaSanityTest() {
		Question quest1 = new Question(1, "a");
		Answer answer1 = new Answer(10, "a");
		Answer answer2 = new Answer(11, "b");
		Answer answer3 = new Answer(12, "c");
		Answer answer4 = new Answer(13, "d");
		quest1.addAnswersOnQuestion(answer1);
		quest1.addAnswersOnQuestion(answer2);
		quest1.addAnswersOnQuestion(answer3);
		quest1.addAnswersOnQuestion(answer4);
		quest1.setCorrectAnswer(answer1);
		quest1.setTestatorAnswer(answer1);
		
		Question quest2 = new Question(2, "b");
		answer1 = new Answer(20, "b");
		answer2 = new Answer(21, "f");
		answer3 = new Answer(22, "g");
		answer4 = new Answer(23, "h");
		quest2.addAnswersOnQuestion(answer1);
		quest2.addAnswersOnQuestion(answer2);
		quest2.addAnswersOnQuestion(answer3);
		quest2.addAnswersOnQuestion(answer4);
		quest2.setCorrectAnswer(answer1);
		quest2.setTestatorAnswer(answer1);
		
		Question quest3 = new Question(3, "c");
		answer1 = new Answer(30, "c");
		answer2 = new Answer(31, "i");
		answer3 = new Answer(32, "j");
		answer4 = new Answer(33, "k");
		quest3.addAnswersOnQuestion(answer1);
		quest3.addAnswersOnQuestion(answer2);
		quest3.addAnswersOnQuestion(answer3);
		quest3.addAnswersOnQuestion(answer4);
		quest3.setCorrectAnswer(answer1);
		quest3.setTestatorAnswer(answer1);
		
		triviaTest = new TriviaTest(1);
		triviaTest.addQuestionToQuestionsArray(quest1);
		triviaTest.addQuestionToQuestionsArray(quest2);
		triviaTest.addQuestionToQuestionsArray(quest3);
	}


	//steps needed for functionality tests
	private static float startStep = 0f;
	private static float stopStep = 13f;

	@BeforeAll
	static public void initEach(){
		Sanity.setChromeDriver();

	}
	
	
	@Test
	void SanityTest() throws InterruptedException {
		int divID = -1;
		Question quest = null;
		
		if(startStep <= 1f && stopStep >= 1f) {
			//Sanity step 1
			Sanity.sanityStep1setURLForDriver();
		}
		

		if(startStep <= 2f && stopStep >= 2f) {
			//Sanity step 2
			//Clicking on start button
			assertTrue(Sanity.sanityStep2PressStartButton());
		}
		
		if(startStep <= 3.1f && stopStep >= 3.1f) {
			//Sanity step 3.1
			//filling Question
			
			Sanity.fillingQuestion(triviaTest.getQuestionsArray().get(0).getQuestion());
		}
		
		if(startStep <= 3.2f && stopStep >= 3.2f) {
			//Sanity step 3.2
			//number 1 is for checking question number
			//clicking next and checking is the next page is correct

			assertTrue(Sanity.pressNextButtonAferfillingQuestion(triviaTest.getQuestionsArray().get(0).getQuestionID()));
		}
		
		if(startStep <= 4.1f && stopStep >= 4.1f) {
			//Sanity step 4.1
			//filling first answer
			Sanity.fillingAnswer1(triviaTest.getQuestionsArray().get(0).getAnswersOnQuestion().get(0).getAnswer());
		}
		
		if(startStep <= 4.2f && stopStep >= 4.2f) {
			
			//Sanity step 4.2
			//filling first answer
			Sanity.fillingAnswer2(triviaTest.getQuestionsArray().get(0).getAnswersOnQuestion().get(1).getAnswer());
		}
		
		if(startStep <= 4.3f && stopStep >= 4.3f) {
			//Sanity step 4.3
			//filling first answer
			Sanity.fillingAnswer3(triviaTest.getQuestionsArray().get(0).getAnswersOnQuestion().get(2).getAnswer());
	    }
		
		if(startStep <= 4.4f && stopStep >= 4.4f) {
			
			//Sanity step 4.4
			//filling first answer
			Sanity.fillingAnswer4(triviaTest.getQuestionsArray().get(0).getAnswersOnQuestion().get(3).getAnswer());
		}
		
			
		if(startStep <= 4.5f && stopStep >= 4.5f) {
			
			//Sanity step 4.5
			//the first answer position
			Sanity.markPositionOfTheRightAnswer(triviaTest.getQuestionsArray().get(0).
					getAnswerPosition(triviaTest.getQuestionsArray().get(0).getCorrectAnswer()));
		}
		
		if(startStep <= 4.6f && stopStep >= 4.6f) {
			//Sanity step 4.6
			//questionNumber is for checking next question number
			//checking if the next page is correct
			assertTrue(Sanity.pressNextButtonAfterfillingAnswers(triviaTest.getQuestionsArray().get(1).getQuestionID()));
		}
		
		if(startStep <= 5.1f && stopStep >= 5.1f) {
			//Sanity step 5.1
			//filling Question
			Sanity.fillingQuestion(triviaTest.getQuestionsArray().get(1).getQuestion());
		}
		
		if(startStep <= 5.2f && stopStep >= 5.2f) {
			//Sanity step 5.2
			//clicking next and checking is the next page is right
			//questionNumber is for checking question number
			assertTrue(Sanity.pressNextButtonAferfillingQuestion(triviaTest.getQuestionsArray().get(1).getQuestionID()));
		}
		
		if(startStep <= 6.1f && stopStep >= 6.1f) {
			//Sanity step 6.1
			//filling first answer
			Sanity.fillingAnswer1(triviaTest.getQuestionsArray().get(1).getAnswersOnQuestion().get(0).getAnswer());
		}
		
		if(startStep <= 6.2f && stopStep >= 6.2f) {
			//Sanity step 6.2
			//filling first answer
			Sanity.fillingAnswer2(triviaTest.getQuestionsArray().get(1).getAnswersOnQuestion().get(1).getAnswer());
		}
		
		if(startStep <= 6.3f && stopStep >= 6.3f) {
			//Sanity step 6.3
			//filling first answer
			Sanity.fillingAnswer3(triviaTest.getQuestionsArray().get(1).getAnswersOnQuestion().get(2).getAnswer());
		}
		
		if(startStep <= 6.4f && stopStep >= 6.4f) {
			//Sanity step 6.4
			//filling first answer
			Sanity.fillingAnswer4(triviaTest.getQuestionsArray().get(1).getAnswersOnQuestion().get(3).getAnswer());
		}
		
		if(startStep <= 6.5f && stopStep >= 6.5f) {
			//Sanity step 6.5
			//the first answer position
			Sanity.markPositionOfTheRightAnswer(triviaTest.getQuestionsArray().get(1).
					getAnswerPosition(triviaTest.getQuestionsArray().get(1).getCorrectAnswer()));
		}
		
		if(startStep <= 6.6f && stopStep >= 6.6f) {
			//Sanity step 6.6
			//checking if the next page is correct
			assertTrue(Sanity.pressNextButtonAfterfillingAnswers(triviaTest.getQuestionsArray().get(2).getQuestionID()));
		}
		
		if(startStep <= 7.1f && stopStep >= 7.1f) {
			//Sanity step 7.1
			//filling Question
			Sanity.fillingQuestion(triviaTest.getQuestionsArray().get(2).getQuestion());
		}
		
		if(startStep <= 7.2f && stopStep >= 7.2f) {
			//Sanity step 7.2
			//clicking next and checking is the next page is right
			//questionNumber is for checking question number
			assertTrue(Sanity.pressNextButtonAferfillingQuestion(triviaTest.getQuestionsArray().get(2).getQuestionID()));
		}
		
		if(startStep <= 8.1f && stopStep >= 8.1f) {
			//Sanity step 8.1
			//filling first answer
			Sanity.fillingAnswer1(triviaTest.getQuestionsArray().get(2).getAnswersOnQuestion().get(0).getAnswer());
		}
		
		if(startStep <= 8.2f && stopStep >= 8.2f) {
			//Sanity step 8.2
			//filling first answer
			Sanity.fillingAnswer2(triviaTest.getQuestionsArray().get(2).getAnswersOnQuestion().get(1).getAnswer());
		}
		
		if(startStep <= 8.3f && stopStep >= 8.3f) {
			//Sanity step 8.3
			//filling first answer
			Sanity.fillingAnswer3(triviaTest.getQuestionsArray().get(2).getAnswersOnQuestion().get(2).getAnswer());
		}
		
		if(startStep <= 8.4f && stopStep >= 8.4f) {
			
			//Sanity step 8.4
			//filling first answer
			Sanity.fillingAnswer4(triviaTest.getQuestionsArray().get(2).getAnswersOnQuestion().get(3).getAnswer());
		}
		
		if(startStep <= 8.5f && stopStep >= 8.5f) {
			//Sanity step 8.5
			//the first answer position
			Sanity.markPositionOfTheRightAnswer(triviaTest.getQuestionsArray().get(2).
					getAnswerPosition(triviaTest.getQuestionsArray().get(2).getCorrectAnswer()));
		}
		
		if(startStep <= 8.6f && stopStep >= 8.6f) {
			//Sanity step 8.6
			//number 0 is sign that finish build the test
			//checking if the next page is correct
			assertTrue(Sanity.pressNextButtonAfterfillingAnswers(0));
		}
		
		if(startStep <= 9f && stopStep >= 9f) {
			//Sanity step 9
			//number divID for checking if correct div displayed
			divID = 2;
			assertTrue(Sanity.pushPlayButton(divID));
		}
		
		if(startStep <= 10.1f && stopStep >= 10.1f) {
			//Sanity step 10.1
			//markRightAnswer = 1
			//divID for xpath containing radio button
			//
			divID = 2;
			String question = Sanity.getTestQuestionString(divID);
			quest = triviaTest.findQuestionByString(question);

			Sanity.selectAnswer(quest.getAnswerPosition(quest.getTestatorAnswer()), 
					divID, quest.getCorrectAnswer().getAnswer(), quest.getAnswerPosition(quest.getCorrectAnswer()));
		}
		
		if(startStep <= 10.2f && stopStep >= 10.2f) {
			//Sanity step 10.2
			//number divID for checking if correct div displayed
			divID = 1;
			assertTrue(Sanity.pressNextButtonAfterSelectionAnswer(divID));
		}
		
		if(startStep <= 11.1f && stopStep >= 11.1f) {
			//Sanity step 11.1
			//markRightAnswer = 1
			//divID for xpath containing radio button
			
			divID = 1;
			String question = Sanity.getTestQuestionString(divID);
			quest = triviaTest.findQuestionByString(question);
			
			Sanity.selectAnswer(quest.getAnswerPosition(quest.getTestatorAnswer()), divID, 
					quest.getCorrectAnswer().getAnswer(), quest.getAnswerPosition(quest.getCorrectAnswer()));
		}
		
		if(startStep <= 11.2f && stopStep >= 11.2f) {
			//Sanity step 11.2
			//number divID for checking if correct div displayed
			divID = 0;
			assertTrue(Sanity.pressNextButtonAfterSelectionAnswer(divID));
		}
		
		if(startStep <= 12.1f && stopStep >= 12.1f) {
			
			//Sanity step 12.1
			//markRightAnswer = 1
			//divID for xpath containing radio button
			divID = 0;
			String question = Sanity.getTestQuestionString(divID);
			quest = triviaTest.findQuestionByString(question);
			
			Sanity.selectAnswer(quest.getAnswerPosition(quest.getTestatorAnswer()), divID, 
					quest.getCorrectAnswer().getAnswer(), quest.getAnswerPosition(quest.getCorrectAnswer()));
		}
		if(startStep <= 12.2f && stopStep >= 12.2f) {
			//Sanity step 12.2
			//number divID for checking if correct div displayed
			//div id -1 mean that this is finish page of the test to check
			divID = -1;
			assertTrue(Sanity.pressNextButtonAfterSelectionAnswer(divID));
			assertTrue(Sanity.checkSuccessFail());
		}
		if(stopStep == 13f) {
			Sanity.driver.close();
		}
		
		
	}


	public TriviaTest getTriviaTest() {
		return triviaTest;
	}
	
	
	public void setTriviaTest(TriviaTest triviaTest) {
		this.triviaTest = triviaTest;
	}

	public static float getStartStep() {
		return startStep;
	}


	public static float getStopStep() {
		return stopStep;
	}


	public static void setStartStep(float startStep) {
		TriviaSanityTest.startStep = startStep;
	}


	public static void setStopStep(float stopStep) {
		TriviaSanityTest.stopStep = stopStep;
	}


	
//	@Test
//	void FunctionalityBackTest() throws InterruptedException {
//		//*[@id="backquest"]
//		SanityTest();
//		driver.findElement(By.xpath("//*[@id=\"backquest\"]")).click();
//		assertTrue(compareStrings(driver.findElement(By.xpath("//*[@id=\"answers\"]/legend")).getText(), QUESTION_NUMBER_ANSWERS_TITLE + " 1"));
//		
//	}
	



}

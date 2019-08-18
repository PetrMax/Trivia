package tst;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class FunctionalityPlayBackButtonTest {

	static float [] backToThebeginningPlayStopStep = {11.1f, 12.1f};
	float startStep = 10.1f;
	int backSteps = 0;
	int divID = 0;
								
	static int i = -1;
	
	@BeforeEach
	public void initEach(){
		i++;
		
	}
	
	@RepeatedTest(value = 1)
	void test() throws InterruptedException {
		
		
		//launch initEach in Trivia Sanity test
		TriviaSanityTest.initEach();
		
		//create sanity test object to launch Sanity test
		TriviaSanityTest santest = new TriviaSanityTest();
		
		TriviaTest triviaTest = santest.getTriviaTest();
		
		//set start step in Trivia Sanity test to zero each repetition
		TriviaSanityTest.setStartStep(0);
		
		//set stop step from where we want to back
		TriviaSanityTest.setStopStep(backToThebeginningPlayStopStep[i]);
		
		Question quest1 = triviaTest.getQuestionsArray().get(0);
		quest1.setTestatorAnswer(quest1.getAnswersOnQuestion().get(3));
		
		Question quest2 = triviaTest.getQuestionsArray().get(1);
		quest2.setTestatorAnswer(quest2.getAnswersOnQuestion().get(3));
		
		Question quest3 = triviaTest.getQuestionsArray().get(2);
		quest3.setTestatorAnswer(quest3.getAnswersOnQuestion().get(3));

		triviaTest.setQuestionsArray(0, quest1);
		triviaTest.setQuestionsArray(1, quest2);
		triviaTest.setQuestionsArray(2, quest3);
		
		santest.setTriviaTest(triviaTest);
		
		
		//launch sanity test
		santest.SanityTest();
		
		//setting for functionality driver
		Functionality.driver = Sanity.driver;
		
		
		
		if(backToThebeginningPlayStopStep[i] >= 11.1f && backToThebeginningPlayStopStep[i] <= 11.1f)
		{
			backSteps = 1;
			divID = 2;
			
			while(backSteps > 0) {
				
				assertTrue(pressBackButton(santest));
			}
			
			
			quest1 = triviaTest.getQuestionsArray().get(0);
			quest1.setTestatorAnswer(quest1.getAnswersOnQuestion().get(1));
			
			quest2 = triviaTest.getQuestionsArray().get(1);
			quest2.setTestatorAnswer(quest2.getAnswersOnQuestion().get(1));
			
			quest3 = triviaTest.getQuestionsArray().get(2);
			quest3.setTestatorAnswer(quest3.getAnswersOnQuestion().get(1));

			triviaTest.setQuestionsArray(0, quest1);
			triviaTest.setQuestionsArray(1, quest2);
			triviaTest.setQuestionsArray(2, quest3);
			
			santest.setTriviaTest(triviaTest);
		}
		else if (backToThebeginningPlayStopStep[i] >= 12.1f) {

			backSteps = 2;
			divID = 1;
			
			while(backSteps > 0) {
				
				assertTrue(pressBackButton(santest));
			}
			
			quest1 = triviaTest.getQuestionsArray().get(0);
			quest1.setTestatorAnswer(quest1.getAnswersOnQuestion().get(0));
			
			quest2 = triviaTest.getQuestionsArray().get(1);
			quest2.setTestatorAnswer(quest2.getAnswersOnQuestion().get(0));
			
			quest3 = triviaTest.getQuestionsArray().get(2);
			quest3.setTestatorAnswer(quest3.getAnswersOnQuestion().get(0));

			triviaTest.setQuestionsArray(0, quest1);
			triviaTest.setQuestionsArray(1, quest2);
			triviaTest.setQuestionsArray(2, quest3);
			
			santest.setTriviaTest(triviaTest);
		}
//		
//		assertTrue(Functionality.pressBackButtonFillingAnswers(questionNumber, question));
//		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(TestConstants.CLOSE_STOP_STEP);
		santest.SanityTest();
	}

	private boolean pressBackButton(TriviaSanityTest santest) throws InterruptedException {
//		String question = TriviaSanityTest.getQuestion2();
		Boolean checkBackButton = false;

		//*[@id="1"]/h3'
		Functionality.pressBackButtonPlayTest();
		
		String question = Sanity.getTestQuestionString(divID);
		Question quest = santest.getTriviaTest().findQuestionByString(question);
		
		checkBackButton = Functionality.checkingBackButtonPlayTestWorking(divID, quest.getAnswerPosition(quest.getTestatorAnswer()));
		backSteps--;
		divID++;
		return checkBackButton;
	}

}

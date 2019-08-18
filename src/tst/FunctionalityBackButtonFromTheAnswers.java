package tst;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class FunctionalityBackButtonFromTheAnswers {
	
	//stop step from where we back
	static float [] stopStep = {4.1f, 4.2f, 4.3f, 4.4f, 4.5f, 6.1f, 6.2f, 6.3f, 6.4f, 6.5f, 8.1f, 8.2f, 8.3f, 8.4f, 8.5f};
	static float startStep = 3.2f;
	//index of the stop steps array							
	static int i = -1;
	
	@BeforeEach
	public void initEach(){
		//index of the stop steps array	increase by one each repeated test
		i++;
		

	}
	
	@RepeatedTest(value = 1)
	void test() throws InterruptedException {
		
		//launch initEach in Trivia Sanity test
		TriviaSanityTest.initEach();
		
		//create sanity test object to launch Sanity test
		TriviaSanityTest santest = new TriviaSanityTest();
		
		//set start step in Trivia Sanity test to zero each repetition
		TriviaSanityTest.setStartStep(0);
		
		//set stop step from where we want to back
		TriviaSanityTest.setStopStep(stopStep[i]);
		
		//launch sanity test
		santest.SanityTest();
		
		//checking question index
		int questionIndex = -1;
		
		//get question for checking
		
		//setting for functionality driver
		Functionality.driver = Sanity.driver;
		
		int questionID = 0;
		
		String question = null;
		
		//setting startStep for checking sanity steps after pressing back button
		float startStep = (float)Math.floor(stopStep[i]) - 0.8f;
		
		
		questionIndex = santest.getTriviaTest().getQuestionIndexByStopStep(stopStep[i]);
		
		questionID = santest.getTriviaTest().getQuestionsArray().get(questionIndex).getQuestionID();
		question = santest.getTriviaTest().getQuestionsArray().get(questionIndex).getQuestion();
		assertTrue(Functionality.pressBackButtonFillingAnswers(questionID, question));
		
		//set start step for sanity to check all steps after pressing back button
		TriviaSanityTest.setStartStep(startStep);
		//set stop step for sanity to check all steps after pressing back button
		TriviaSanityTest.setStopStep(TestConstants.CLOSE_STOP_STEP);
		
		//checking sanity steps after pressing back button
		santest.SanityTest();
	}

}

package tst;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ErrorHandlingBoundaryValues {
	
	
	float stopStep = 2f;
	float startStep = 3.1f;
		
	
	@RepeatedTest(value = 1)
	void test() throws InterruptedException {
		
		
		//launch initEach in Trivia Sanity test
		TriviaSanityTest.initEach();
		
		//create sanity test object to launch Sanity test
		TriviaSanityTest santest = new TriviaSanityTest();
		
		//set start step in Trivia Sanity test to zero each repetition
		TriviaSanityTest.setStartStep(0);
		
		//set stop step from where we want to back
		TriviaSanityTest.setStopStep(stopStep);
		
		//launch sanity test
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAferfillingQuestion(santest.getTriviaTest().getQuestionsArray().get(1).getQuestionID()));
		
		startStep = 3.1f;
		stopStep = 3.2f;

		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(1).getQuestionID()));

		startStep = 4.1f;
		stopStep = 4.2f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(1).getQuestionID()));
		
		startStep = 4.1f;
		stopStep = 4.3f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(1).getQuestionID()));
		
		startStep = 4.1f;
		stopStep = 4.4f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(1).getQuestionID()));
		
		startStep = 4.1f;
		stopStep = 4.6f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAferfillingQuestion(santest.getTriviaTest().getQuestionsArray().get(1).getQuestionID()));
//		
		startStep = 5.1f;
		stopStep = 5.2f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(2).getQuestionID()));
		
		startStep = 6.1f;
		stopStep = 6.2f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(2).getQuestionID()));
		
		startStep = 6.1f;
		stopStep = 6.3f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(2).getQuestionID()));
		
		
		startStep = 6.1f;
		stopStep = 6.4f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(santest.getTriviaTest().getQuestionsArray().get(2).getQuestionID()));
		
		startStep = 6.1f;
		stopStep = 6.6f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		assertFalse(Sanity.pressNextButtonAferfillingQuestion(santest.getTriviaTest().getQuestionsArray().get(2).getQuestionID()));
		
		startStep = 7.1f;
		stopStep = 7.2f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		
		
		santest.SanityTest();
		//number 0 is sign that finish build the test
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(0));
		
		startStep = 8.1f;
		stopStep = 8.2f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(0));
		
		startStep = 8.1f;
		stopStep = 8.3f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(0));
		
		startStep = 8.1f;
		stopStep = 8.4f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		assertFalse(Sanity.pressNextButtonAfterfillingAnswers(0));
		
		startStep = 8.1f;
		stopStep = 8.5f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		assertTrue(Sanity.pressNextButtonAfterfillingAnswers(0));
		
		
		startStep = 9f;
		stopStep = 9f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		int divID = 1;
		assertFalse(Sanity.pressNextButtonAfterSelectionAnswer(divID));
		
		startStep = 10.1f;
		stopStep = 10.2f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		divID = 0;
		assertFalse(Sanity.pressNextButtonAfterSelectionAnswer(divID));
		
		startStep = 11.1f;
		stopStep = 11.2f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
		
		divID = -1;
		assertFalse(Sanity.pressNextButtonAfterSelectionAnswer(divID));
		
		startStep = 12.1f;
		stopStep = 13f;
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(stopStep);
		
		santest.SanityTest();
	}
}

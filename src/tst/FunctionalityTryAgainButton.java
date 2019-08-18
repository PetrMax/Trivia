package tst;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class FunctionalityTryAgainButton {

	static float stopStep = 12.2f;
	float startStep = 10.1f;
	int backSteps = 0;
	int indexOFDivIDAndMark = 0;
	
			
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
		
		//set start step in Trivia Sanity test to zero each repetition
		TriviaSanityTest.setStartStep(0);
		
		//set stop step from where we want to back
		TriviaSanityTest.setStopStep(stopStep);
		
		//launch sanity test
		santest.SanityTest();
		
		//setting for functionality driver
		Functionality.driver = Sanity.driver;
		
		for(int i = 0; i < 4; i++) {
			
			for(int m = 0; m < 4; m++) {
				
				for(int n = 0; n < 4; n++) {
					assertTrue(Functionality.tryAgainButtonTest());
					
					TriviaSanityTest.setStartStep(startStep);
					TriviaSanityTest.setStopStep(stopStep);
					TriviaTest triviaTest = santest.getTriviaTest();
					Question quest1 = triviaTest.getQuestionsArray().get(0);
					quest1.setTestatorAnswer(quest1.getAnswersOnQuestion().get(i));
					
					Question quest2 = triviaTest.getQuestionsArray().get(1);
					quest2.setTestatorAnswer(quest2.getAnswersOnQuestion().get(m));
					
					Question quest3 = triviaTest.getQuestionsArray().get(2);
					quest3.setTestatorAnswer(quest3.getAnswersOnQuestion().get(n));
					triviaTest.clearQuestionsArray();
					triviaTest.addQuestionToQuestionsArray(quest1);
					triviaTest.addQuestionToQuestionsArray(quest2);
					triviaTest.addQuestionToQuestionsArray(quest3);
					
					santest.setTriviaTest(triviaTest);

					santest.SanityTest();
				}
			}
			
			
			
		}
		
		

//		
//		assertTrue(Functionality.pressBackButtonFillingAnswers(questionNumber, question));
//		
	}

}

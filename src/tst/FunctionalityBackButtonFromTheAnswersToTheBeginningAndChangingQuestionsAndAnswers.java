package tst;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class FunctionalityBackButtonFromTheAnswersToTheBeginningAndChangingQuestionsAndAnswers {
	//stop step where from where we back to the beginning
	float [] backToThebeginningStopStep = {6.1f, 6.2f, 6.3f, 6.4f, 6.5f, 8.1f, 8.2f, 8.3f, 8.4f, 8.5f};
//	float [] backToThebeginningStopStep = {6.1f, 6.2f, 6.3f, 6.4f, 6.5f, 6.1f, 6.2f, 6.3f, 6.4f, 6.5f};
	float startStep = 3.1f;
	int backSteps = 0;
	int questionIndex = 0;
	String q1 = "kuku";
	String q2 = "hello";
	String answ1 = "he y";
	String answ2 = "h e l l o";
	String answ3 = "g o o d b y e";
			

								
	static int i = -1;
	
	@BeforeEach
	public void initEach(){
		i++;

	}
	
	@RepeatedTest(value = 4)
	void test() throws InterruptedException {
		

		//launch initEach in Trivia Sanity test
		TriviaSanityTest.initEach();
		
		//create sanity test object to launch Sanity test
		TriviaSanityTest santest = new TriviaSanityTest();
		
		//set start step in Trivia Sanity test to zero each repetition
		TriviaSanityTest.setStartStep(0);
		
		//set stop step from where we want to back
		TriviaSanityTest.setStopStep(backToThebeginningStopStep[i]);
		
		//launch sanity test
		santest.SanityTest();
		
		//setting for functionality driver
		Functionality.driver = Sanity.driver;
		
		questionIndex = santest.getTriviaTest().getQuestionIndexByStopStep(backToThebeginningStopStep[i]);
		backSteps = questionIndex*2;
		while(backSteps >= 0) {
			
			assertTrue(pressBackButton(santest));
		}
//		
//		assertTrue(Functionality.pressBackButtonFillingAnswers(questionNumber, question));
//		
		
		TriviaSanityTest.setStartStep(startStep);
		TriviaSanityTest.setStopStep(TestConstants.CLOSE_STOP_STEP);
		
		TriviaTest triviaTest = santest.getTriviaTest();
		

		
		StringBuffer stringBuff = new StringBuffer("a");
		
		//boundary value of the question = 50
		//creating 50 characters string buffer
		for(int m = 0; m < 48; m++) {
			stringBuff.append("a");
		}
		String quest = stringBuff.toString();
		

		String [][] questArray = {   {quest, q1, q2},
				 { q1, quest, q2},
				 { q1, q2, quest},
				 {quest, q1, q2},
				 { q1, quest, q2},
				 {quest, q1, q2},
				 { q1, quest, q2},
				 { q1, q2, quest},
				 {quest, q1, q2}
		};
		
		
		stringBuff = new StringBuffer("a");
		
		//boundary value of the answer = 30
		//creating 50 characters string buffer
		for(int m = 0; m < 29; m++) {
			stringBuff.append("a");
		}
		String answer = stringBuff.toString();
		

		String [][] answerArray = { 
				 { answer, answ1, answ1, answ3},
				 { answ1, answer, answ2, answ3},
				 {answ1, answ2, answ3, answer},
				 {answ1, answ3, answer, answ2}
		};
		
		

		//checking boundary values
		Question quest1 = new Question(1, questArray[i][0]);
		Answer answer1 = new Answer(10, answerArray[i][0]);
		Answer answer2 = new Answer(11, answerArray[i][1]);
		Answer answer3 = new Answer(12, answerArray[i][2]);
		Answer answer4 = new Answer(13, answerArray[i][3]);
		quest1.addAnswersOnQuestion(answer1);
		quest1.addAnswersOnQuestion(answer2);
		quest1.addAnswersOnQuestion(answer3);
		quest1.addAnswersOnQuestion(answer4);
		quest1.setCorrectAnswer(answer1);
		quest1.setTestatorAnswer(answer4);
		
		//checking boundary values
		Question quest2 = new Question(2, questArray[i][1]);
		answer1 = new Answer(20, answerArray[i][0]);
		answer2 = new Answer(21, answerArray[i][1]);
		answer3 = new Answer(22, answerArray[i][2]);
		answer4 = new Answer(23, answerArray[i][3]);
		quest2.addAnswersOnQuestion(answer1);
		quest2.addAnswersOnQuestion(answer2);
		quest2.addAnswersOnQuestion(answer3);
		quest2.addAnswersOnQuestion(answer4);
		quest2.setCorrectAnswer(answer2);
		quest2.setTestatorAnswer(answer1);
		
		//checking boundary values
		Question quest3 = new Question(3, questArray[i][2]);
		answer1 = new Answer(30, answerArray[i][0]);
		answer2 = new Answer(31, answerArray[i][1]);
		answer3 = new Answer(32, answerArray[i][2]);
		answer4 = new Answer(33, answerArray[i][3]);
		quest3.addAnswersOnQuestion(answer1);
		quest3.addAnswersOnQuestion(answer2);
		quest3.addAnswersOnQuestion(answer3);
		quest3.addAnswersOnQuestion(answer4);
		quest3.setCorrectAnswer(answer1);
		quest3.setTestatorAnswer(answer3);
		
		triviaTest.setQuestionsArray(0, quest1);
		triviaTest.setQuestionsArray(1, quest2);
		triviaTest.setQuestionsArray(2, quest3);
		
		santest.setTriviaTest(triviaTest);
		

		santest.SanityTest();
	}

	private boolean pressBackButton(TriviaSanityTest santest) throws InterruptedException {
//		String question = TriviaSanityTest.getQuestion2();
		int questionID = 0;
		Question quest = santest.getTriviaTest().getQuestionsArray().get(questionIndex);
		String question = null;
		String firstAnswer = null;
		String secondAnswer = null;
		String thirdAnswer = null;
		String fourthAnswer = null;
		Boolean checkBackButton = false;
		int correctAnswerPosition = 0;
		if(backSteps%2 == 0) {
			questionID = quest.getQuestionID();
			question = quest.getQuestion();
			
			checkBackButton = Functionality.pressBackButtonFillingAnswers(questionID, question);
			backSteps--;
			questionIndex--;
		}
		else {
			questionID = quest.getQuestionID();
			firstAnswer = quest.getAnswersOnQuestion().get(0).getAnswer();
			secondAnswer = quest.getAnswersOnQuestion().get(1).getAnswer();
			thirdAnswer = quest.getAnswersOnQuestion().get(2).getAnswer();
			fourthAnswer = quest.getAnswersOnQuestion().get(3).getAnswer();
			correctAnswerPosition = quest.getAnswerPosition(quest.getCorrectAnswer());
			checkBackButton = Functionality.pressBackButtonFillingQuestion(firstAnswer, secondAnswer,
															   thirdAnswer, fourthAnswer,
															   correctAnswerPosition, questionID);
			backSteps--;
		}
		return checkBackButton;
	}
}

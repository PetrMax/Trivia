package tst;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class FunctionalitySuccessFailedTest {

	static float stopStep = 12.2f;
	float startStep = 10.1f;
	int backSteps = 0;
	int indexOFDivIDAndMark = 0;
	int answerMark1 = 1;
	int answerMark2 = 2;
	int answerMark3 = 3;

	int [][] markAnswers = new int[][]{
		  { 1, 2, 3},
		  { 0, 0, 1},
		  { 0, 0, 3},
		  { 0, 2, 3},
		  { 3, 2, 1}
	};				
				
	static int length = 1;
	static int j = 0;
	
	@AfterEach
	public void initEach(){
		length++;
		j++;
	}
	
	@RepeatedTest(value = 4)
	void test() throws InterruptedException {
//	
		//launch initEach in Trivia Sanity test
		TriviaSanityTest.initEach();
		
		//create sanity test object to launch Sanity test
		TriviaSanityTest santest = new TriviaSanityTest();
		
		//set start step in Trivia Sanity test to zero each repetition
		TriviaSanityTest.setStartStep(0);
		
		
		StringBuffer question1 = new StringBuffer(length);
		StringBuffer question2 = new StringBuffer(length);
		StringBuffer question3 = new StringBuffer(length);
		
		question1.append("a");
		question2.append("b");
		question3.append("c");
		
//		for(int m = 0; m < 49; m++) {
//			quest1.append("a");
//			quest2.append("b");
//			quest3.append("c");
//		}
//		
//		
//		for (int i = 0; i < length; i++){
//			quest1.append("a");
//			quest2.append("b");
//			quest3.append("c");
//		}
		
		StringBuffer answ1 = new StringBuffer(length);
		StringBuffer answ2 = new StringBuffer(length);
		StringBuffer answ3 = new StringBuffer(length);
		StringBuffer answ4 = new StringBuffer(length);
		answ1.append("a");
		answ2.append("b");
		answ3.append("c");
		answ4.append("d");
		
		
//		for (int i = 0; i < length; i++){
//			answ1.append("a");
//			answ2.append("b");
//			answ3.append("c");
//			answ4.append("d");
//		}
		
		System.out.println(answ1.length());
		
		TriviaTest triviaTest = new TriviaTest(1);
		
		Question quest1 = new Question(1, question1.toString());
		Answer answer1 = new Answer(10, answ1.toString());
		Answer answer2 = new Answer(11, answ2.toString());
		Answer answer3 = new Answer(12, answ3.toString());
		Answer answer4 = new Answer(13, answ4.toString());
		quest1.addAnswersOnQuestion(answer1);
		quest1.addAnswersOnQuestion(answer2);
		quest1.addAnswersOnQuestion(answer3);
		quest1.addAnswersOnQuestion(answer4);
		quest1.setCorrectAnswer(quest1.getAnswersOnQuestion().get(markAnswers[j][0]));
		quest1.setTestatorAnswer(quest1.getAnswersOnQuestion().get(markAnswers[j][0]));
		
		Question quest2 = new Question(2, question2.toString());
		answer1 = new Answer(20, answ1.toString());
		answer2 = new Answer(21, answ2.toString());
		answer3 = new Answer(22, answ4.toString());
		answer4 = new Answer(23, answ4.toString());
		quest2.addAnswersOnQuestion(answer1);
		quest2.addAnswersOnQuestion(answer2);
		quest2.addAnswersOnQuestion(answer3);
		quest2.addAnswersOnQuestion(answer4);
		quest2.setCorrectAnswer(quest2.getAnswersOnQuestion().get(markAnswers[j][1]));
		quest2.setTestatorAnswer(quest2.getAnswersOnQuestion().get(markAnswers[j][1]));
		
		Question quest3 = new Question(3, question3.toString());
		answer1 = new Answer(30, answ1.toString());
		answer2 = new Answer(31, answ2.toString());
		answer3 = new Answer(32, answ3.toString());
		answer4 = new Answer(33, answ4.toString());
		quest3.addAnswersOnQuestion(answer1);
		quest3.addAnswersOnQuestion(answer2);
		quest3.addAnswersOnQuestion(answer3);
		quest3.addAnswersOnQuestion(answer4);
		quest3.setCorrectAnswer(quest3.getAnswersOnQuestion().get(markAnswers[j][2]));
		quest3.setTestatorAnswer(quest3.getAnswersOnQuestion().get(markAnswers[j][2]));
		
		triviaTest.addQuestionToQuestionsArray(quest1);
		triviaTest.addQuestionToQuestionsArray(quest2);
		triviaTest.addQuestionToQuestionsArray(quest3);
		
		santest.setTriviaTest(triviaTest);
		//launch sanity test
		santest.SanityTest();

//		
//		assertTrue(Functionality.pressBackButtonFillingAnswers(questionNumber, question));
//		
	}

}

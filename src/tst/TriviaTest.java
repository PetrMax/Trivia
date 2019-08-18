package tst;

import java.util.ArrayList;
import java.util.List;

public class TriviaTest {
	private int TestID = 0;
	private ArrayList<Question> questionsArray = new ArrayList<Question>();

	public TriviaTest(int testID) {
		TestID = testID;
	}

	public int getTestID() {
		return TestID;
	}

	public ArrayList<Question> getQuestionsArray() {
		return questionsArray;
	}

	public void setQuestionsArray(int index, Question question) {
		questionsArray.set(index, question);
	}
	
	public void clearQuestionsArray() {
		questionsArray.clear();
	}

	public void addQuestionToQuestionsArray(Question question) {
		questionsArray.add(question);
	}


	public Question findQuestionByString(String question) {
		Question quest = null;
		
		for(int i = 0; i < questionsArray.size(); i++) {
			if(Comparator.compareStrings(question, questionsArray.get(i).getQuestion())){
				quest = questionsArray.get(i);
			}
		}
		return quest;
	}

	public int getQuestionIndexByStopStep(float stopStep) {
		int questionIndex = (int) (Math.floor(stopStep)/TestConstants.DIFFERENCE_BETWEEN_STOP_STEPS - 2);
		return questionIndex;
	}
	
	
	
	
}

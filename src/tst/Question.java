package tst;

import java.util.ArrayList;

public class Question {
	private int questionID = 0;
	private String question = null;
	private ArrayList<Answer> answersOnQuestion = new ArrayList<Answer>();
	private Answer correctAnswer = null;
	private Answer testatorAnswer = null;

	public Question(int questionID, String question) {

		this.questionID = questionID;
		this.question = question;
	}

	public int getQuestionID() {
		return questionID;
	}

	public Answer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<Answer> getAnswersOnQuestion() {
		return answersOnQuestion;
	}

	public void setAnswersOnQuestion(int index, Answer answer) {
		answersOnQuestion.set(index, answer);
	}
	
	public void addAnswersOnQuestion(Answer answer) {
		answersOnQuestion.add(answer);
	}

	public Answer getTestatorAnswer() {
		return testatorAnswer;
	}

	public void setTestatorAnswer(Answer testatorAnswer) {
		this.testatorAnswer = testatorAnswer;
	}
	
	
	public int getAnswerPosition(Answer answer) {
		int position = -1;
		for(int i = 0; i < answersOnQuestion.size(); i++) {
			if(answersOnQuestion.get(i).getAnswerID() == answer.getAnswerID()) {
				position = i + 1;
				break;
			}
		}
		return position;
	}
	
	
}

package tst;

public class Answer {
	private int answerID = 0;
	private String answer = null;
	
	public Answer(int answerID, String answer) {
		this.answerID = answerID;
		this.answer = answer;
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
}

package tst;

public class Comparator {
	
	public static Boolean compareStrings(String text, String questionNumber1AnswersTitle) {
		//removing line break from string to compare
		text = text.replace("\n", " ").replace("\r", "");
		if(text.compareTo(questionNumber1AnswersTitle) == 0) {
			return true;
		}
		return false;
	}
}

package tst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sanity{
	
	
	public static WebDriver driver = null;
//	private static String question1 = null;
//	private static String question2 = null;
//	private static String question3 = null;
//	private static String question1_first_answer = null;
//	private static String question1_second_answer = null;
//	private static String question1_third_answer = null;
//	private static String question1_fourth_answer = null;
//	private static String question2_first_answer = null;
//	private static String question2_second_answer = null;
//	private static String question2_third_answer = null;
//	private static String question2_fourth_answer = null;
//	private static String question3_first_answer = null;
//	private static String question3_second_answer = null;
//	private static String question3_third_answer = null;
//	private static String question3_fourth_answer = null;
	public static String startButtonXpath = "//*[@id=\"startB\"]";
	public static String nextButtonXpath = "//*[@id=\"nextquest\"]";
	public static String questionTitleXpath = "//*[@id=\"myform1\"]/div/legend";
	public static String questionXpath = "//*[@id=\"myform1\"]/div/div/div/input"; 
	public static String answer1Xpath = "//*[@id=\"answers\"]/div[1]/div[2]/input";
	public static String answer2Xpath = "//*[@id=\"answers\"]/div[2]/div[2]/input";
	public static String answer3Xpath = "//*[@id=\"answers\"]/div[3]/div[2]/input";
	public static String answer4Xpath = "//*[@id=\"answers\"]/div[4]/div[2]/input";
	public static String markPositionXpath1 = "//*[@id=\"answers\"]/div[";
	public static String markPositionXpath2 = "]/div[1]/input";
	public static String questionAnswersTitleXpath = "//*[@id=\"answers\"]/legend";
	public static String finishBuildTheTestXpath = "//*[@id=\"needBackGround\"]";
	public static String playButtonXpath = "//*[@id=\"secondepage\"]/center/button[1]";
	public static String testXpath = "//*[@id=\"testpage\"]/center/h1/u";
	public static String tesDivDisplayedPart1 = "//*[@id=\"";
	public static String tesDivDisplayedPart2 = "\"]/h3";
	public static String nextButtonTestXpath = "//*[@id=\"btnnext\"]";
	
	public static int correctAnswersCounter = 0;
//	
	public static void setChromeDriver() {
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
	}
	
	public static void sanityStep1setURLForDriver() throws InterruptedException {
		TimeUnit.SECONDS.sleep(4);
		driver.get(TestConstants.URL);
	}
	
	public static Boolean sanityStep2PressStartButton() {
		driver.findElement(By.xpath(startButtonXpath)).click();
		//comparing strings the right string should be "Please type here your question : question number: 1" return true or false
		return Comparator.compareStrings(driver.findElement(By.xpath(questionTitleXpath)).getText(), TestConstants.QUESTION_NUMBER_TITLE + " 1");
	}
	
	public static void fillingQuestion(String question) throws InterruptedException {
		clearField(driver.findElement(By.xpath(questionXpath)));
		//fill question
		driver.findElement(By.xpath(questionXpath)).sendKeys(question);
	}
	
	public static Boolean pressNextButtonAferfillingQuestion(int questionNumber) throws InterruptedException {
		Boolean testCheck = false;
		//sleep to view what happening
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		//clicking next
		driver.findElement(By.xpath(nextButtonXpath)).click();
		String question = driver.findElement(By.xpath(questionAnswersTitleXpath)).getText();
		testCheck = Comparator.compareStrings(question, TestConstants.QUESTION_NUMBER_ANSWERS_TITLE + " " + questionNumber);
		//comparing strings the right string should be "Please enter 4 possible answers and Mark the right one! question number: questionNumber" return true or false
		return testCheck;
	}
	
	public static void fillingAnswer1(String answer1) throws InterruptedException {
		
		clearField(driver.findElement(By.xpath(answer1Xpath)));
		//fill answer 1
		driver.findElement(By.xpath(answer1Xpath)).sendKeys(answer1);
	}
	
	public static void fillingAnswer2(String answer2) throws InterruptedException {
		
		clearField(driver.findElement(By.xpath(answer2Xpath)));
		//fill answer 2
		driver.findElement(By.xpath(answer2Xpath)).sendKeys(answer2);
	}


	public static void fillingAnswer3(String answer3) throws InterruptedException {
		clearField(driver.findElement(By.xpath(answer3Xpath)));
		//fill answer 3
		driver.findElement(By.xpath(answer3Xpath)).sendKeys(answer3);
	}
	
	public static void fillingAnswer4(String answer4) throws InterruptedException {
		clearField(driver.findElement(By.xpath(answer4Xpath)));
		//fill answer 4
		driver.findElement(By.xpath(answer4Xpath)).sendKeys(answer4);
	}
	
	public static void markPositionOfTheRightAnswer(int markPosition) throws InterruptedException {
		//marking the right answer radio button
		if(markPosition != 0) {
			driver.findElement(By.xpath(markPositionXpath1 + markPosition + markPositionXpath2)).click();
		}
	}
	
	public static Boolean pressNextButtonAfterfillingAnswers(int questionNumber) throws InterruptedException {
		Boolean testCheck = false;

		
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath("//*[@id=\"nextquest\"]")).click();
		//clicking next
		
		if(questionNumber != 0) 
		{
			try {
				testCheck = Comparator.compareStrings(driver.findElement(By.xpath(questionTitleXpath)).getText(), TestConstants.QUESTION_NUMBER_TITLE + " " + questionNumber);
			}
			catch(UnhandledAlertException e) {
				TimeUnit.SECONDS.sleep(TestConstants.DELAY);
				driver.switchTo().alert().accept();
				testCheck = Comparator.compareStrings(driver.findElement(By.xpath(questionTitleXpath)).getText(), TestConstants.QUESTION_NUMBER_TITLE + " " + questionNumber);
			}
		}
		else {
			try {
				testCheck = Comparator.compareStrings(driver.findElement(By.xpath(finishBuildTheTestXpath)).getText(), TestConstants.FINISHED_BUILD_THE_TEST);
			}
			catch(UnhandledAlertException e) {
				TimeUnit.SECONDS.sleep(TestConstants.DELAY);
				driver.switchTo().alert().accept();
				driver.switchTo().alert().accept();
				testCheck = Comparator.compareStrings(driver.findElement(By.xpath(finishBuildTheTestXpath)).getText(), TestConstants.FINISHED_BUILD_THE_TEST);
				
			}
		}
		
		
		
		
		////comparing strings the right string should be "Please type here your question : question number: questionNumber" return true or false
		return testCheck;
	}


	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		Sanity.driver = driver;
	}

	public static Boolean pushPlayButton(int divID) throws InterruptedException {
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath(playButtonXpath)).click();
		
		return driver.findElement(By.xpath(tesDivDisplayedPart1 + divID + tesDivDisplayedPart2)).isDisplayed();
	}

	public static void selectAnswer(int markQuestion, int divID, String correctAnswer, int indexOfCorrectAnswers) throws InterruptedException {
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		
		
//		int markpos = markedRightAnswersPosition.get(divID);
//		if(markpos == markQuestion) {
//			correctAnswersCounter++;
//		}
		driver.findElement(By.xpath("//*[@id=\"" + divID + "\"]/input[" + markQuestion + "]")).click();
		
		String answer = driver.findElement(By.xpath("//*[@id=\"" + divID + "\"]/span[" + markQuestion + "]")).getText();
		if(Comparator.compareStrings(answer, correctAnswer)) {
			correctAnswersCounter++;
		}
		
		//*[@id="2"]/span[1]
		//*[@id="2"]/span[2]
		//*[@id="2"]/span[3]

	}
	
	public static Boolean pressNextButtonAfterSelectionAnswer(int divID) throws InterruptedException {
		Boolean testCheck = false;
		
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath(nextButtonTestXpath)).click();
		if(divID != -1) {
			try {
				TimeUnit.SECONDS.sleep(TestConstants.DELAY);
				testCheck = driver.findElement(By.xpath(tesDivDisplayedPart1 + divID + tesDivDisplayedPart2)).isDisplayed();
			}
			catch(UnhandledAlertException e) {
				TimeUnit.SECONDS.sleep(TestConstants.DELAY);
				driver.switchTo().alert().accept();
				testCheck = driver.findElement(By.xpath(tesDivDisplayedPart1 + divID + tesDivDisplayedPart2)).isDisplayed();
			}
		}
		else {
			try {
				TimeUnit.SECONDS.sleep(TestConstants.DELAY);
				testCheck = driver.findElement(By.xpath("//*[@id=\"markpage\"]")).isDisplayed();
			}
			catch(UnhandledAlertException e) {
				TimeUnit.SECONDS.sleep(TestConstants.DELAY);
				driver.switchTo().alert().accept();
				testCheck = driver.findElement(By.xpath("//*[@id=\"markpage\"]")).isDisplayed();
			}
		}
		
		return testCheck;
	}
	
	
	public static void clearField(WebElement element) {
		element.clear();
	}

	public static Boolean checkSuccessFail() {
		Boolean testCheck = false;
		
		if(correctAnswersCounter == 3) {
			testCheck = Comparator.compareStrings(driver.findElement(By.xpath("//*[@id=\"mark\"]")).getText(), 
					TestConstants.SUCCESS);
		}
		else {
			testCheck = Comparator.compareStrings(driver.findElement(By.xpath("//*[@id=\"mark\"]")).getText(), 
					TestConstants.FAIL);
		}
		
		correctAnswersCounter = 0;
		return testCheck;
	}

	public static String getTestQuestionString(int divID) {
		// TODO Auto-generated method stub
		//*[@id="1"]/h3
		return driver.findElement(By.xpath("//*[@id=\"" + divID + "\"]/h3")).getText();
	}

	public static void pressQuestionField() {
		
		driver.findElement(By.xpath(questionXpath)).click();
	}

	public static void alertAccept() throws InterruptedException {
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.switchTo().alert().accept();
		
	}


}

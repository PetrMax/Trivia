package tst;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functionality {
	//*[@id="backquest"]
	public static WebDriver driver = null;
	public static String backButtonFillingAnswersXpath = "//*[@id=\"firstpage\"]/main/div/center/div//*[@id=\"backquest\"]";
	public static String tesDivDisplayedPart1 = "//*[@id=\"";
	public static String tesDivDisplayedPart2 = "\"]/h3";
	public static String backButtonPlayTestXpath = "//*[@id=\"btnback\"]";
	public static String tryAgainButtonXpath = "//*[@id=\"markpage\"]/center/button[1]";
	
	public static Boolean pressBackButtonFillingAnswers(int questionNumber, String question) throws InterruptedException {
		Boolean testCheck = false;
		
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		//clicking back
		driver.findElement(By.xpath(backButtonFillingAnswersXpath)).click();
//		driver.findElement(By.cssSelector("#backquest")).click();
		if(questionNumber != 0) {

			testCheck = Comparator.compareStrings(driver.findElement(By.xpath(Sanity.questionTitleXpath)).getText(), 
					TestConstants.QUESTION_NUMBER_TITLE + " " + questionNumber);
			if(testCheck) {
				testCheck = Comparator.compareStrings(driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input")).getAttribute("value"), 
						question);
			}
		}
		////comparing strings the right string should be "Please type here your question : question number: questionNumber" return true or false
		return testCheck;
	}



	public static boolean pressBackButtonFillingQuestion(String answer1, String answer2, String answer3, String answer4,
			Integer mark, int questionNumber) throws InterruptedException {
		Boolean testCheck = false;
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath(backButtonFillingAnswersXpath)).click();
		testCheck = Comparator.compareStrings(driver.findElement(By.xpath(Sanity.questionAnswersTitleXpath)).getText(), 
				TestConstants.QUESTION_NUMBER_ANSWERS_TITLE + " " + questionNumber);
		if(testCheck) {
			testCheck = Comparator.compareStrings(driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).getAttribute("value"), 
					answer1);
			if(testCheck) {
				testCheck = Comparator.compareStrings(driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).getAttribute("value"), 
						answer2);
				if(testCheck) {
					testCheck = Comparator.compareStrings(driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).getAttribute("value"), 
							answer3);
					if(testCheck) {
						testCheck = Comparator.compareStrings(driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).getAttribute("value"), 
								answer4);
						if(testCheck) {
							testCheck = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[" + mark + "]/div[1]/input")).isSelected();
						}
					}
				}
			}
		}
		return testCheck;
	}



	public static void pressBackButtonPlayTest() throws InterruptedException {
		// TODO Auto-generated method stub
		Sanity.correctAnswersCounter = 0;
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath(backButtonPlayTestXpath)).click();

	}
	
	public static Boolean checkingBackButtonPlayTestWorking(Integer divID, Integer testatorAnswerPosition) throws InterruptedException {
		// TODO Auto-generated method stub
		Boolean testCheck = false;
		testCheck = driver.findElement(By.xpath(tesDivDisplayedPart1 + divID + tesDivDisplayedPart2)).isDisplayed();
		if(testCheck) {
			testCheck = driver.findElement(By.xpath("//*[@id=\"" + divID + "\"]/input[" + testatorAnswerPosition + "]")).isSelected();
			
			//*[@id="2"]/input[1]

			
		}
		return testCheck;
	}



	public static Boolean tryAgainButtonTest() throws InterruptedException {
		Boolean testCheck = false;
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath(tryAgainButtonXpath)).click();
		return driver.findElement(By.xpath(tesDivDisplayedPart1 + 2 + tesDivDisplayedPart2)).isDisplayed();
	}
	
	
	public static Boolean pressQuitButtonTest() throws InterruptedException {
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath("//*[@id=\"markpage\"]/center/button[2]")).click();
		return driver.getTitle().isEmpty();
	}



	public static Boolean pressFacebookButton() throws InterruptedException {
		TimeUnit.SECONDS.sleep(TestConstants.DELAY);
		driver.findElement(By.xpath("//*[@id=\"fackBook2\"]/img")).click();

		driver.switchTo().alert().accept();

		return driver.getCurrentUrl().toString().contains("www.facebook.com");
	}
}

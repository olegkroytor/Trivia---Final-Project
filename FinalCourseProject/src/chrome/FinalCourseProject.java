package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FinalCourseProject {

	static WebDriver driver;

	public static void createBrowser(){
		driver = new ChromeDriver();
		//		driver = new FirefoxDriver();
	}

	public static boolean openTriviaSite() {
		driver.navigate().to("https://svcollegetest.000webhostapp.com/");  
		driver.manage().window().maximize();
		WebElement btnStart = driver.findElement(By.id("startB"));
		boolean bool = btnStart.isEnabled() ? true : false;
		btnStart.click();
		return bool;
	}

	//	public static void question_fill(String value) {
	//		WebElement questionInput = driver.findElement(By.xpath("//*[@id=\"myform1\"]/div/div/div/input"));
	//		questionInput.clear();
	//		questionInput.sendKeys(value);
	//	}

	public static boolean question_fill_(String value) {
		WebElement questionInput = driver.findElement(By.name("question"));
		questionInput.clear();
		questionInput.sendKeys(value);
		String questionInputText = driver.findElement(By.name("question")).getAttribute("value");
		return questionInputText.length() > 0 ? true : false;
	}

	public static boolean answer_fill(
			String answer1, 
			String answer2,
			String answer3,
			String answer4) {
		WebElement answerWel1 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input"));
		answerWel1.clear();
		answerWel1.sendKeys(answer1);
		WebElement answerWel2 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input"));
		answerWel2.clear();
		answerWel2.sendKeys(answer2);
		WebElement answerWel3 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input"));
		answerWel3.clear();
		answerWel3.sendKeys(answer3);
		WebElement answerWel4 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input"));
		answerWel4.clear();
		answerWel4.sendKeys(answer4);
		String inputTextanswerWel1 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).getAttribute("value");
		String inputTextanswerWel2 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).getAttribute("value");
		String inputTextanswerWel3 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).getAttribute("value");
		String inputTextanswerWel4 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).getAttribute("value");
		System.out.println("length a1 = " + inputTextanswerWel1.length());
		System.out.println("length a2 = " + inputTextanswerWel2.length());
		System.out.println("length a3 = " + inputTextanswerWel3.length());
		System.out.println("length a4 = " + inputTextanswerWel4.length());
		if(inputTextanswerWel1.length() > 0 && 
				inputTextanswerWel2.length() > 0 && 
				inputTextanswerWel3.length() > 0 && 
				inputTextanswerWel4.length() > 0)
			return true;
		else 
			return false;
	}

	public static boolean answer_option_1_select() {
		WebElement selectAnswer1 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input"));
		selectAnswer1.click();
		return selectAnswer1.isSelected() ? true : false;
	}

	public static boolean answer_option_2_select() {
		WebElement selectAnswer2 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]/input"));
		selectAnswer2.click();
		return selectAnswer2.isSelected() ? true : false;
	}

	public static boolean answer_option_3_select() {
		WebElement selectAnswer3 = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[1]/input"));
		selectAnswer3.click();
		return selectAnswer3.isSelected() ? true : false;
	}

	public static boolean quiz_answer_select() {
		WebElement selectAnswer1 = null, selectAnswer2 = null, selectAnswer3 = null, selectAnswer4 = null;
		WebElement headQuestion = driver.findElement(By.xpath("document.querySelector(\"#\\\\32  > h3\")"));
		String headQuestionStr = driver.findElement(By.className("userdata")).getAttribute("value");
		String[] headQuestionStr1 = headQuestionStr.split("the");
		switch (headQuestionStr) {
		case "first":
			selectAnswer1 = driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]"));
			selectAnswer2 = driver.findElement(By.xpath("//*[@id=\"0\"]/input[2]"));
			selectAnswer3 = driver.findElement(By.xpath("//*[@id=\"0\"]/input[3]"));
			selectAnswer4 = driver.findElement(By.xpath("//*[@id=\"0\"]/input[4]"));
			break;
		case "second":
			selectAnswer1 = driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]"));
			selectAnswer2 = driver.findElement(By.xpath("//*[@id=\"1\"]/input[2]"));
			selectAnswer3 = driver.findElement(By.xpath("//*[@id=\"1\"]/input[3]"));
			selectAnswer4 = driver.findElement(By.xpath("//*[@id=\"1\"]/input[4]"));
			break;
		case "third":
			selectAnswer1 = driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]"));
			selectAnswer2 = driver.findElement(By.xpath("//*[@id=\"2\"]/input[2]"));
			selectAnswer3 = driver.findElement(By.xpath("//*[@id=\"2\"]/input[3]"));
			selectAnswer4 = driver.findElement(By.xpath("//*[@id=\"2\"]/input[4]"));
			break;
		default:
			break;
		}

		WebElement[] webElAr = new WebElement[] {selectAnswer1, selectAnswer2, selectAnswer3, selectAnswer4};
		WebElement btnNext = driver.findElement(By.id("btnnext"));
		int lenRan = 4;
		while(btnNext.isEnabled() == false) {
			int random = (int)(Math.random() * lenRan + 1);
			webElAr[random].click();
			//			lenRan --;
		}
		return btnNext.isEnabled() ? true : false;
	}

	public static void clickBtnPlay() {
		WebElement btnNext = driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]"));
		btnNext.click();
	}

	public static void clickBtnNext() {
		WebElement btnNext = driver.findElement(By.id("nextquest"));
		btnNext.click();
	}

	public static void clickBtnTestNext() {
		WebElement btnNext = driver.findElement(By.id("btnnext"));
		btnNext.click();
	}

	public static void question_1_full_process(
			String question1, 
			String answer1, 
			String answer2, 
			String answer3, 
			String answer4) {
		openTriviaSite();
		boolean bool = question_fill_(question1);
		if(bool) {
			clickBtnNext();
			answer_fill(answer1, answer2, answer3, answer4);
			answer_option_1_select();
			clickBtnNext();
		}
	}

	public static void question_2_full_process(
			String question2, 
			String answer1, 
			String answer2, 
			String answer3, 
			String answer4) {
		question_fill_(question2);
		clickBtnNext();
		answer_fill(answer1, answer2, answer3, answer4);
		answer_option_2_select();
		clickBtnNext();
	}

	public static void question_3_full_process(
			String question3, 
			String answer1, 
			String answer2, 
			String answer3, 
			String answer4) {
		question_fill_(question3);
		clickBtnNext();
		answer_fill(answer1, answer2, answer3, answer4);
		answer_option_3_select();
		clickBtnNext();
	}

	public static void closeBrowser(){
		driver.quit();
		driver.close();
	}
}

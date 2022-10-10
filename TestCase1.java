package marathon2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 extends CommonMethodSales {
	@BeforeTest
	public void setup() {
		filename = "Salesforce";
	}

	@Test(dataProvider = "testData")

	public void salesq(String Question, String Details) throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__control slds-grow')]//input[1]"))
				.sendKeys("Content");
		driver.findElement(By.xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//mark"))
				.click();
		Thread.sleep(8000);
		driver.findElement(
				By.xpath("(//nav[@class='slds-context-bar__secondary navCenter']//one-app-nav-bar-item-root)[2]"))
				.click();
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equalsIgnoreCase("Chatter Home | Salesforce")) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is wrong");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//ul[@class='tabs__nav']/li)[3]")).click();
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(Question);
		driver.findElement(By.xpath(
				"//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']"))
				.sendKeys(Details);
		driver.findElement(By.xpath(
				"//button[@class='slds-button slds-button_brand cuf-publisherShareButton qe-questionPostDesktop MEDIUM']"))
				.click();
		String question = driver
				.findElement(By
						.xpath("//div[@class='cuf-body cuf-questionTitle forceChatterFeedBodyQuestionWithoutAnswer']"))
				.getText();
		System.out.println(question);
		if (question.equalsIgnoreCase("What is Chatter")) {

			System.out.println("The question is correct");
		}

		else {
			System.out.println("The question is wrong");
		}

	}

}

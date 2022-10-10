package marathon2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 extends CommonMethodSales {
	@BeforeTest
	public void setup() {
		filename = "testCase2";
	}

	@Test(dataProvider = "testData")

	public void sales(String Lname) throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__control slds-grow')]//input[1]"))
				.sendKeys("Individuals");
		driver.findElement(By.xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//mark"))
				.click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("(//li[@class='uiMenuItem uiRadioMenuItem']//a)[4]")).click();
		driver.findElement(By.xpath("//input[contains(@class, 'lastName compoundBLRadius')]")).sendKeys(Lname);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-show']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Customers");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//li[@class='slds-button slds-button--neutral']//a)[1]")).click();
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input")).sendKeys(Lname);
		String text = driver.findElement(By.xpath("(//div[@title='Ramdoss']//mark)[1]")).getText();

		if (text.equalsIgnoreCase(Lname)) {

			System.out.println("Name appears");
		} else {
			System.out.println("Name doesn't appear");

		}

	}

}
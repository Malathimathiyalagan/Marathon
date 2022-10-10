package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import baseClass.CommonClassMarathon;
import io.github.sukgu.Shadow;

public class ViewIncidentPage extends CommonClassMarathon{
	
	public ViewIncidentPage(ChromeDriver driver, Shadow shadow) {
		this.driver=driver;
		this.shadow=shadow;
	}
	public ViewIncidentPage viewIncident(String text2) {
		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();
		
		//// Confirm incident exists !
		driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text);
      return this;
	}
	

}

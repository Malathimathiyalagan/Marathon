package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.CommonClassMarathon;
import io.github.sukgu.Shadow;

public class CreateIncidentPage extends CommonClassMarathon {
	
		
		public CreateIncidentPage(ChromeDriver driver, Shadow shadow) {
			this.driver=driver;
			this.shadow=shadow;
		}
		public ViewIncidentPage clickNew() {
			WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
			driver.switchTo().frame(eleFrame);
			driver.findElement(By.xpath("//button[text()='New']")).click();
			String text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

			System.out.println("Incident Number"+text2);
			driver.findElement(By.id("incident.short_description")).sendKeys("Created via Automation");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			driver.switchTo().defaultContent();
	        return new ViewIncidentPage(driver,shadow);
		}
		
		
	}


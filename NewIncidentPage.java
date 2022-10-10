package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.CommonClassMarathon;
import io.github.sukgu.Shadow;

public class NewIncidentPage extends CommonClassMarathon {
	

	public NewIncidentPage(ChromeDriver driver,Shadow shadow) {
		this.driver = driver;
		this.shadow=shadow;

	}

	public NewIncidentPage clickall() {
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[@id='all']").click();
		return this;
	}

	// 4.Click Incidents in Filter navigator
	public CreateIncidentPage clickFilter() {
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		return new CreateIncidentPage(driver,shadow);
	}

}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.CommonClassMarathon;
import io.github.sukgu.Shadow;


public class LoginIncidentPage extends CommonClassMarathon {
	public LoginIncidentPage(ChromeDriver driver, Shadow shadow) {
		this.driver=driver;
		this.shadow=shadow;
	
	}
	
	
//element/action
	public LoginIncidentPage enterUsername(String uname) {
		
		driver.findElement(By.id("user_name")).sendKeys(uname);
		System.out.println(driver);
		return this;
	}
    public LoginIncidentPage enterPassword(String pwd) {
    	driver.findElement(By.id("user_password")).sendKeys(pwd);
    	return this;
	}
    public NewIncidentPage clickLogin() {
    	 driver.findElement(By.id("sysverb_login")).click();
    	 return new NewIncidentPage(driver,shadow);
}
}
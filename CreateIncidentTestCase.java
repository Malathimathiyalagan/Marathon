package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.CommonClassMarathon;
import pages.LoginIncidentPage;

public class CreateIncidentTestCase extends CommonClassMarathon{
	
	@BeforeTest 
	public void setFile() {
	
		filename="LoginIncident";
		testName="CreateIncident";
		testDescription="CreateIncident in ServiceNow application";
		testCategory="smoke";
		testAuthor="Malathi";
	}
	
	@Test(dataProvider="testData")
	public void runCreateIncident(String uname, String pwd) {
		new LoginIncidentPage(driver,shadow).enterUsername(uname)
		.enterPassword(pwd).clickLogin().clickall().clickFilter()
		.clickNew();
		}
}


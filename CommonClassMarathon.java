package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import utils.ReadExcelFile;

public class CommonClassMarathon {
	public ChromeDriver driver;
	public String filename;
	public Shadow shadow;

	public  static ExtentReports extent;// keep extent global
	public ExtentTest test,node;// keep ExtentTest global
	public String testName, testDescription, testCategory, testAuthor;
	
	@BeforeSuite
	public void startReport() throws IOException, InterruptedException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reporter/createIncident.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void setTestCasedetail() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);

	}
	
	public void reportStep(String status, String message) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			node.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(message);
		}
	}
	
	
	public int takeSnap() throws IOException {	
		int random = (int)(Math.random() *(9999999));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destn = new File("./snap/img"+random+".png");
		FileUtils.copyFile(source, destn);
		return random;
		
	}
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	@BeforeMethod
	public void preCondition() {
		node=test.createNode(testName,testDescription);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev87541.service-now.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		shadow = new Shadow(driver);
		// shadow.setImplicitWait(40);
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

	@DataProvider // (name="fetchData")
	public String[][] testData() throws IOException {
		String[][] readData = ReadExcelFile.readData(filename);
		return readData;
	}

}
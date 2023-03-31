package salesforcebase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public  ChromeDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testcase,testDescription,authorName,testType,testName;
	
	
	
	@BeforeSuite
    public void startReport() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Report/result.html");
        reporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }
	@AfterSuite
	public void endReport() {
		extent.flush();
		
	}
	@BeforeClass
	public void testcaseDetails() {
	    test = extent.createTest(testcase,testDescription);
		 
		test.assignAuthor(authorName);
		test.assignCategory(testType);	
		node = test.createNode(testName);
		
	}
	

	
	@BeforeMethod
	public void launchUrl() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");

	     driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	public void reportStep(String stepDesc, String status) throws IOException {
        if (status.equalsIgnoreCase("Pass")) {
            node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
        } else if (status.equalsIgnoreCase("fail")) {
            node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
            throw new RuntimeException("Please look into report for failure details");
        }
    }
	public int takeSnap() throws IOException {
		int random=(int)( Math.random()*99999999);
		
		File sec = driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./snap/img"+random+".png");
		FileUtils.copyFile(sec, des);
		return random;
		
		
	}
	

}

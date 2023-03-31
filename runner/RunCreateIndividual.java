package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SalesLoginPage;
import salesforcebase.BaseClass;

public class RunCreateIndividual extends BaseClass {
	@BeforeTest
	public void setData() {
		testcase="login page";
		testDescription="using extentreport we see the output";
		authorName="TestLeaf";
		testType="sanity";
		testName = "loginPagetest";
				
	}
	
     @Test
	public void runCreateIndividualpage() throws IOException {
		SalesLoginPage slp =new SalesLoginPage(driver);
		
		slp.enterUsername().enterPassword().clickOnLoginButton();
	}
	
	

}

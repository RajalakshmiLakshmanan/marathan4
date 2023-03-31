package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.BaseClass;

public class SalesLoginPage extends BaseClass{
	
	public SalesLoginPage(ChromeDriver driver) {
		
		this.driver = driver;
		
	}
	
	public SalesLoginPage enterUsername() throws IOException {
		
		try {
			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
			reportStep("username enterd successfully","pass");
		} catch (Exception e) {
			reportStep("entered wrong usename","fail");
			e.printStackTrace();
		}
		
		return this;
		
		
	}
	
	public SalesLoginPage enterPassword() throws IOException {
		
		try {
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			reportStep("password enterd successfully","pass");
		} catch (Exception e) {
			reportStep("entered wrong password","fail");
			e.printStackTrace();
		}
		
		return this;
		
	}
	
	public SalesHomePage clickOnLoginButton() throws IOException {
		
		try {
			driver.findElement(By.id("Login")).click();
			reportStep("login successful","pass");
		} catch (Exception e) {
			reportStep("login failed","fail");
			e.printStackTrace();
		}
		 return new SalesHomePage(driver);
		
	}
	

}

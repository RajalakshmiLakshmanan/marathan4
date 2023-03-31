package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.BaseClass;

public class SalesHomePage extends BaseClass{
	
public SalesHomePage(ChromeDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public SalesHomePage clickToggleButton() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
		
	}
	
	public SalesHomePage clickViewallButton() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
		
	}
	
	public CilckIndividual clickIndividualLink() {
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		return new CilckIndividual(driver);
		
		
	}
	
	

}

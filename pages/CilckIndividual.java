package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.BaseClass;

public class CilckIndividual extends BaseClass{
	
public CilckIndividual(ChromeDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public CilckIndividual clickNewbutton() {
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		return this;
		
	}
	
	public CilckIndividual enterLastName() {
		
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys("Kumars");
		return this;
		
	}
	
	public verifyindividual clickSaveButton() {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return new verifyindividual(driver);
		
	}
	
	
	

}

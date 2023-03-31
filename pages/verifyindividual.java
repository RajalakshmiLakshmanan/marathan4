package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.BaseClass;

public class verifyindividual extends BaseClass {

public verifyindividual(ChromeDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public verifyindividual verifyIndividaualName() {
		
		String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
	
		System.out.println(message);
		
		return this;
	}
	
}

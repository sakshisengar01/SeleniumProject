package day3;

import org.openqa.selenium.By;

public interface I {

	String base_url = "https://devgbptool.glocal360.ai/"; 	
	
	//variable 
	String inputbox_email_address =  "poonam.kapoor@adglobal360.com";
	String inputbox_password = "AGL2913";
		
	//locators
	By inputbox_email_address_xpath = By.xpath("//input[@type='email']");
	By inputbox_password_xpath = By.xpath("//input[@type='password']");
	By button_submit_xpath = By.xpath("//button[@type='submit']");
	
}

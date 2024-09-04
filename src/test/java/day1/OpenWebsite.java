package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenWebsite {
	
	@Test
	void Openpage()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	
}

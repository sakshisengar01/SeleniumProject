package day3;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MasterPage implements I {	
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	void Open_Browser(String x)
	{
		if(x.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}		 
		else if(x.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(x.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Select your browser");
		}		
		driver.get(base_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	void Login_Page()
	{
		driver.findElement(inputbox_email_address_xpath).sendKeys(inputbox_email_address);
		driver.findElement(inputbox_password_xpath).sendKeys(inputbox_password);
		driver.findElement(button_submit_xpath).click();
	}
	@AfterTest
	void Close_Page()
	{
		driver.close();
	}
}

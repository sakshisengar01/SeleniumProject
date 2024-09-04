package day1;

import org.testng.annotations.Test;

public class Amazon {
	
	@Test(priority = 1 , description = "this is my first method")
	void openurl()
	{
		System.out.println("open url");
	}
	
	@Test(priority = 2 , enabled = false)
	void click()
	{
		System.out.println("click");
	
	}

}

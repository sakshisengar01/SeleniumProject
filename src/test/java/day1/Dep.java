package day1;

import org.testng.annotations.Test;

public class Dep {
	
	@Test(dependsOnMethods = "Register")
	void Login()
	{
		System.out.println("login");
	}
	@Test
	void Register()
	{
		System.out.println("Register");
	}
	
}

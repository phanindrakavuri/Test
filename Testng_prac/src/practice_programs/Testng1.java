package practice_programs;

import org.testng.annotations.Test;

public class Testng1 {
	@Test(priority=3, description= "add functionality")
	public void add()
	{
		System.out.println("first test");
	}
	
	@Test(priority=1,description ="this case will verify the login functionality")
	public void login()
	{
		System.out.println("first test");
	}
	
	@Test(priority=2 ,description="click functionality")
	public void click()
	{
		System.out.println("first test");
	}
	
}

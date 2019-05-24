package practice_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 
{
	public WebDriver driver;
	@Test(priority=0)
	@Parameters({"browser"})
	public void launch(String x)
	{
		if(x.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver","E:\\shiva\\drivers\\chromedriver.exe");
			   driver=new ChromeDriver();
    	}
		else if(x.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver","E:\\shiva\\drivers\\Firefoxdriver.exe");
			   driver=new FirefoxDriver();
   	}
		driver.get("http://www.way2sms.com/");
	}
	@Test(priority=1,dependsOnMethods= {"launch"})
	@Parameters({"mobileno","password"})
	public void fill(String mobileno,String password)
	{
		driver.findElement(By.name("mobileNo")).sendKeys(mobileno);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	@Test(priority=2,dependsOnMethods= {"fill"})
	public void login()
	{
		driver.findElement(By.xpath("(//*[contains(text(),'Login')])[2]")).click();
	}
	@Test(priority=3,dependsOnMethods= {"login"})
	public void logout()
	{
		driver.findElement(By.xpath("//*[@class='logout']")).click();
	}
	@Test(dependsOnMethods= {"logout"})
	public void close()
	{
		driver.close();
	}

}

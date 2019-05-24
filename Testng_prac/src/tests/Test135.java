package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.Homepage;
import pages.Sendsmspage;

public class Test135 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Homepage hp;
	public Sendsmspage sp;
	
	@Test(priority=1)
	public void launch()
	{
		//open browser	//launch browser
		System.setProperty("webdriver.chrome.driver", "D:\\shiva\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//create objects to page classes
		hp=new Homepage(driver);
		sp=new Sendsmspage(driver);
	
		//launch site
		driver.get("http://www.way2sms.com");
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hp.mbno));
		
	}
	
	@Test(priority=2)
	@Parameters({"m","p"})
	public void login(String m,String p) throws Exception
	{
		hp.fillmbno(m);
		wait.until(ExpectedConditions.visibilityOf(hp.pwd));
		hp.fillpwd(p);
		wait.until(ExpectedConditions.elementToBeClickable(hp.loginbtn));
		hp.clickloginbtn();
		Thread.sleep(5000);//mandatory wait for outcome
	}
	
	@Test(priority=3)
	@Parameters({"m","mc","p","pc"})
	public void validations(String m, String mc, String p, String pc)
	{
		try
		{
			if(m.length()==0 && hp.blankmbnoerr.isDisplayed())
			{
				Reporter.log("Blank mobile test passed");
				Assert.assertTrue(true);
			}
			else if(m.length()<10 && hp.wrongsizembnoerr.isDisplayed())
			{
				Reporter.log("Wrong size mobile number test passed");
				Assert.assertTrue(true);
			}
			
			else if(p.length()==0 && hp.blankpwderr.isDisplayed())
			{
				Reporter.log("Blank password test passed");
				Assert.assertTrue(true);
			}
			
			else if(mc.equalsIgnoreCase("invalid") && pc.equalsIgnoreCase("valid") && hp.invalidmbnoerr.isDisplayed())
			{
				Reporter.log("Invalid mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(mc.equalsIgnoreCase("valid") &&  pc.equalsIgnoreCase("invalid") && hp.invalidpwderr.isDisplayed())
			{
				Reporter.log("Invalid password test passed");
				Assert.assertTrue(true);
			}			
			else if(mc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("valid") && sp.sendsmsmsg.isDisplayed())
			{
				Reporter.log("Valid data test passed");
				Assert.assertTrue(true);
			}
			else
			{
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
				Date d=new Date();
				String fname=sf.format(d)+".png";
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dest=new File(fname);
				FileHandler.copy(src, dest);
				Reporter.log("Login test failed");
				String path="E:\\SeleTest\\SelePrograms\\w2smstesting\\"+fname;
				String code="<img src=\"file:///"+path+"/\" alt=\"\"/>";
				Reporter.log("test fail");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage());
			Assert.assertTrue(false);
		}
	}
	@Test(priority=4)
	public void closesite()
	{
		driver.close();
		
	}
		
}

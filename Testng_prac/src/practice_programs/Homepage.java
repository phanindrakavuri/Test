package practice_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homepage 
{
	public static ChromeDriver driver;
	public WebDriverWait wait;
	
	@DataProvider(name="inputcredentials")
	public static Object[][] testdata(){
		return new Object[][]
				{
					{"9642774747","phani019"},{"9642774747","phani019"}
				};
	}
	
	/*@DataProvider(name="password")
	public Object[][] testdata1(){
		return new Object[][]
				{
				{"phani019"}
				};
	}*/
   @Test()
   public void launch()
   {
	   System.setProperty("webdriver.chrome.driver","E:\\shiva\\drivers\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.get("http://www.way2sms.com/");
   }
   @Test(dataProvider = "inputcredentials")
   public void fill(String x,String p)
   {
	   wait=new WebDriverWait(driver,20);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
	   driver.findElement(By.name("mobileNo")).sendKeys(x);
	   driver.findElement(By.name("password")).sendKeys(p);
	   
   }
   /*@Test(priority=2,dataProvider="password",dataProviderClass=Homepage.class,dependsOnMethods= {"fill"})
   public void fillpwd(String p)
   {
	   driver.findElement(By.name("password")).sendKeys(p);
   }*/
	@Test()
	public void close()
	{
		driver.close();
	}
	
}

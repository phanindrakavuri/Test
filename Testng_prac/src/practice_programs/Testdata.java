package practice_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testdata {
    public ChromeDriver driver;
    @BeforeMethod
    public void launch()
    {
    	System.setProperty("webdriver.chrome.driver","E:\\shiva\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/");
    }
    @Test(dataProvider="inputdata",dataProviderClass=Dataprovider.class)
    public void fill(String c , String v)
    {
    	driver.findElement(By.name("mobileNo")).sendKeys(c);
    	driver.findElement(By.name("password")).sendKeys(v);
    	
    }
   
    @Test()
    public void login()
    {
    	driver.findElement(By.xpath("(//*[contains(text(),'Login')])[2]")).click();
    }
    @AfterMethod
    public void close()
    {
    	driver.close();
    }
}

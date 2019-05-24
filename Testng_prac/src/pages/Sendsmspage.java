package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sendsmspage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[text()='SendSMS']")
	public WebElement sendsmsmsg;
	
	//constructor method
	public Sendsmspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

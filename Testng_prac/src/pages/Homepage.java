package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	public WebDriver driver;
	
	@FindBy(name="mobileNo")
	public WebElement mbno;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="(//button[contains(text(),'Login')])[1]")
	public WebElement loginbtn;
	
	@FindBy(xpath="//*[text()='Enter your mobile number']")
	public WebElement blankmbnoerr;
	
	@FindBy(xpath="//*[text()='Enter valid mobile number']")
	public WebElement wrongsizembnoerr;
	
	@FindBy(xpath="(//*[contains(text(),'mobile number is not register with')])[1]")
	public WebElement invalidmbnoerr;
	
	@FindBy(xpath="//*[text()='Enter password']")
	public WebElement blankpwderr;
	
	@FindBy(xpath="//*[contains(text(),'Try Again')]")
	public WebElement invalidpwderr;
	
	//constructor method
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void fillmbno(String x)
	{
		mbno.sendKeys(x);
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void clickloginbtn()
	{
		loginbtn.click();
	}
}

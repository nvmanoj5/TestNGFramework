package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {
	
	WebDriver driverFB;
	
	
	public Signup(WebDriver driverFB) {
		this.driverFB=driverFB;
		
		PageFactory.initElements(driverFB, this);
	}
	@FindBy(xpath="//tbody/tr[3]/td[3]/input[1]")
	WebElement frstName;
	
	@FindBy(xpath="//tbody/tr[7]/td[3]/input[1]")
	WebElement surName;
	
	@FindBy(xpath="//tbody/tr[9]/td[3]/input[1]")
	WebElement mobileno;
	
	@FindBy(xpath="//tbody/tr[11]/td[3]/input[1]")
	WebElement pwd;
	
	
	
	public WebElement FirstName()
	{
		return frstName;
	}
	public WebElement SurName()
	{
		return surName;
	}
	public WebElement MobileNo()
	{
		return mobileno;
	}
	public WebElement PassWord()
	{
		return pwd;
	}

}

package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPF {
	
	WebDriver driverFB;
	
	
	public LoginPF(WebDriver driverFB) {
		this.driverFB=driverFB;
		PageFactory.initElements(driverFB, this);
	}
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	
	@FindBy(css="#pass")
	WebElement pwd;
	
	@FindBy(name="login")
	WebElement login;
	
	
	
	public WebElement EmailId()
	{
		return username;
	}
	public WebElement Password()
	{
		return pwd;
	}
	public WebElement Login()
	{
		return login;
	}

}

package MVNSample.MVNFacebook;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtilities.Facebookdata;
import ObjectRepository.LoginPF;
import ObjectRepository.Signup;

import junit.framework.Assert;


public class Facebooklogin extends Baseproperty {
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void BeforeTest() throws IOException
	{
		System.out.println("Before Test");
		
	}
	@BeforeClass
	public void bfcls() throws IOException
	{
		System.out.println("Before Class");

		driverFB = initializeDriver();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws IOException
	{
		System.out.println("Before Method");
	}
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider="FBcredentials",dataProviderClass=Facebookdata.class)
public void fblogin(String username,String password) throws IOException, InterruptedException
{
	System.out.println("---  Facebook Login ---");
	
	driverFB.get(url);
			
	LoginPF lpf =new LoginPF(driverFB);
			
	lpf.EmailId().sendKeys(username);
	lpf.Password().sendKeys(password);
	lpf.Login().click();
	waitForPageLoad();Thread.sleep(2000);
	
	
	WebElement home = driverFB.findElement(By.xpath("//span[contains(text(),'Manoj Nv')]"));
	
	Assert.assertEquals(true, home.isDisplayed());

	
	System.out.println("Logged in successfully - home");
}
	
	@Test(dataProvider="FBsignupcredentials",dataProviderClass=Facebookdata.class)
public void RediffmailSignup(String fName,String sName,String MBno,String pwd) throws IOException, InterruptedException
{
		System.out.println("---  Create a Rediffmail account  ---");
		
		driverFB.get(signupurl);
		waitForPageLoad();Thread.sleep(2000);
		
		System.out.println("FirstName"+fName);
		System.out.println("surName"+sName);
		System.out.println("MobileNo"+MBno);
		System.out.println("password"+pwd);
	
		Signup sp = new Signup(driverFB);
			
		sp.FirstName().sendKeys(fName);
		sp.SurName().sendKeys(sName);
		sp.MobileNo().sendKeys(MBno);
		sp.PassWord().sendKeys(pwd);
			
		WebElement home = driverFB.findElement(By.xpath("//input[@id='Register']"));
		
		Assert.assertEquals(true, home.isDisplayed());
			
		System.out.println("Pass- Rediff");
		
}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After Method");
	}
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After Class");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test");
		driverFB.close();
		driverFB.quit();
	}
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("After Suite");
		

	}
	
	

}

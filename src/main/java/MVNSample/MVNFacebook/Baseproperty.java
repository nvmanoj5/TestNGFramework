package MVNSample.MVNFacebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseproperty {
	
	public WebDriver driverFB;
	public WebDriverWait wait;
	public String url;
	public String signupurl;
	String path ="";
	String path2 ="";
	String path3 ="";
	
	
	public WebDriver initializeDriver() throws IOException
	{
		path =System.getProperty("user.dir")+"\\resources\\Base.properties";
		path2 =System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(path);
		pro.load(fis);
		String browserName = pro.getProperty("browser");
		url = pro.getProperty("url");
		signupurl= pro.getProperty("signupurl");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			 String exePath = path2;
			  System.setProperty("webdriver.chrome.driver", exePath);
			  driverFB = new ChromeDriver();
			  driverFB.manage().window().maximize();
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\LatestProject\\Firefox\\geckodriver.exe");
			 driverFB = new FirefoxDriver();
		}
		
		driverFB.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //It will wait for 10 sec beforw testcase fails
		return driverFB; //returing webdriver
	}
	
	public void getscreenshot(String testcaseName,WebDriver driverFB) throws IOException
	{
		path3 =System.getProperty("user.dir")+"\\Screenshots\\";
		TakesScreenshot ts = (TakesScreenshot) driverFB;
		File source = ts.getScreenshotAs(OutputType.FILE);
	//	String ds1 = System.getProperty("user.dir")+"";
		String ds = ""+path3+""+testcaseName+".png";
		FileUtils.copyFile(source, new File(ds));
		
	}
	
	 public void waitForPageLoad(){
		 
		 wait = new WebDriverWait(driverFB, 350);
		 ExpectedCondition<Boolean> pageLoaded = new ExpectedCondition<Boolean>()
		 {
			 public Boolean apply(WebDriver driverFB)
			 {
			  // System.out.println("Page is loading...");
				 if(isAlertPresent())
				 {
					 Alert alert = driverFB.switchTo().alert();
					 alert.accept();
				 }
				 return ((JavascriptExecutor) driverFB).executeScript("return document.readyState").equals("complete");
			 }
		 };
		 wait.until(pageLoaded);
		 System.out.println("Page loaded completely");
	 }

	  @SuppressWarnings("unused")
	  public boolean assertTrue(boolean matches)
	  {
	      return false;
	  }

	  @SuppressWarnings("unused")
	  public String closeAlertAndGetItsText()
	  {
	      return null;
	  }

	  public boolean isAlertPresent()
	  {
	      try
	      {
	    	  driverFB.switchTo().alert();
	          return true;
	         
	      }
	      catch(NoAlertPresentException ex)
	      {
	          return false;
	      }
	  }
	

}

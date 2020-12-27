package MVNSample.MVNFacebook;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Baseproperty implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtendReportNG.getReportObject();
	public void onTestStart(ITestResult result) {
		
		test= extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("--PASS--");
		test.log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		System.out.println("--Fail--");
		test.fail(result.getThrowable());
		/*WebDriver driverFB=null;
		String methodname=result.getMethod().getMethodName();
		
		try {
			driverFB = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driverFB").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			getscreenshot(methodname,driverFB);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}

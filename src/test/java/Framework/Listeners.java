package Framework;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtendReporterNG;

public class Listeners extends Base implements ITestListener{
	ExtentReports extent=ExtendReporterNG.report();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest =new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		  test = extent.createTest(result.getMethod().getMethodName());
			extenttest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "test passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		String testcasename = result.getMethod().getMethodName();
		 try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extenttest.get().addScreenCaptureFromPath(takeScreenshot(testcasename, driver), result.getMethod().getMethodName());
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();		
	}

}

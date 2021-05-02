package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
static ExtentReports extent;
	public static ExtentReports report() {
		String path = System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter  reporter=new ExtentSparkReporter(path);
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	
	}
}

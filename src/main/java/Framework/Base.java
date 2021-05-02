package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class Base {
	public WebDriver driver;
	Properties prop;
public WebDriver intializeDriver() throws IOException {
	
	 prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Data.properties");
	prop.load(fis);
	//String browsername = System.getProperty("browser");
	
	String browsername = prop.getProperty("browser");
	System.out.println(browsername);

if(browsername.contains("chrome")) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\browsers\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	if(browsername.contains("headless")) {
		options.addArguments("headless");
	}
	driver=new ChromeDriver(options);
	
}
else if(browsername.equals("firefox")) {
	System.setProperty("WebDriver.gecko.driver", System.getProperty("user.dir")+"\\browsers\\geckodriver-v0.29.1-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
}
else if(browsername.equals("IE")) {
	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\browsers\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
	 driver=new InternetExplorerDriver();
}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
}
public String takeScreenshot(String testcasename, WebDriver driver) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	 String dest = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
	//System.getProperty("user.dir")+"\\reports\\testcasename"+".png"
	FileUtils.copyFile(source, new File(dest));
	return dest;
}
}

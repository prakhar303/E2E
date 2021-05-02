package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class VerifyTextTest extends Base {
	WebDriver driver;
	
	@BeforeTest
	public void intialize() throws IOException {
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
		System.out.println("before Test");
	}
	@Test
	
	public void verifyText() throws IOException {
		
		LandingPage lp=new LandingPage(driver);
		String actualText = lp.verifyText().getText();
		Assert.assertEquals(actualText, "An Academy to Learn Earn & Shine  in your QA Caree");
		Assert.assertTrue(lp.courseslink().isDisplayed());
		System.out.println(actualText);
		
	}
	
	
}

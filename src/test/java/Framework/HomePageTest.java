package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassPage;
import pageObjects.LandingPage;
import pageObjects.Loginpage;

public class HomePageTest extends Base{
	WebDriver driver;

	@BeforeMethod
	public void initialize() throws IOException {
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getData")
	public void basePagenavigation(String username, String Password, String text) throws IOException, InterruptedException {
		
		LandingPage lp=new LandingPage(driver);
		Loginpage login = lp.loginbtn();
		login.Usrname().sendKeys(username);
		login.urnpass().sendKeys(Password);
		System.out.println(text);
		login.lginbtn().click();
		ForgotPassPage forgotpass = login.forgotPass();
Thread.sleep(2000);
forgotpass.emailtxtbx().sendKeys("ccc");
		forgotpass.sendmeinstr().click();
		String actual = forgotpass.textcheck().getText();
		Assert.assertEquals("We couldn't find an account with that email address", actual );
	}
		@DataProvider
		public Object[][] getData()
		{
			
			//row num gives the no. of test you want to do
			// col represents how many values are sent in the every test
			Object[][] data=new Object[2][3];
			//row 1 or test 1
			data[0][0]="456";
			data[0][1]="Investment_123";
			data[0][2]="non-restricted-user";
			//row 2 or test 2
			
			data[1][0]="123.com";
			data[1][1]="Investment_123";
			data[1][2]="restricted-user";
			return data;
		}
		@AfterTest
		
		public void afterTest() {
			driver.close();
			
		}
	
}

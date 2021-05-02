package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
 public Loginpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user_email")
	private WebElement untbox;
	
	@FindBy(id="user_password")
	private WebElement usrpass;
	
	@FindBy(css="input[class*='btn-md login-button']")
	private WebElement lginbtn;
	
	@FindBy(className="link-below-button")
	private WebElement forgotpass;
	
	public WebElement Usrname() {
		return untbox;
	}
	
	
	public WebElement urnpass() {
		return usrpass;
	}
	

	public WebElement lginbtn() {
		return lginbtn;
	}
	public ForgotPassPage forgotPass() {
		ForgotPassPage forgot=new ForgotPassPage(driver);
		forgotpass.click();
		return forgot;
		
		
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassPage {
	WebDriver driver;
 public ForgotPassPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user_email")
	private WebElement emailtxtbx;
	
	@FindBy(css="input[type='submit']")
	private WebElement sendmeinstr;
	
	@FindBy(className="help-block")
	private WebElement textcheck;
	
	
	
	
	
	public WebElement emailtxtbx() {
		return emailtxtbx;
	}
	
	
	public WebElement sendmeinstr() {
		return sendmeinstr;
	}
	
	public WebElement textcheck() {
		return textcheck;
	}
	

	
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;	
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="a[class='theme-btn register-btn']")
	private WebElement loginbtn;

	@FindBy(xpath="//div[@class='col-md-6 text-left']//span")
	private WebElement verifytext;
	
	@FindBy(linkText="Courses")
	private WebElement courseslink;
	
public Loginpage loginbtn() {
	Loginpage lp1=new Loginpage(driver);
	loginbtn.click();
	return  lp1;
}

public WebElement verifyText() {
		return  verifytext;
	}

public WebElement courseslink() {
	return courseslink;
}
}


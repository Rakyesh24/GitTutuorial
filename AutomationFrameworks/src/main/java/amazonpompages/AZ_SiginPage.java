package amazonpompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class AZ_SiginPage {

	WebDriver driver;
	public AZ_SiginPage(WebDriver idriver) {
		this.driver=idriver;
		PageFactory.initElements(idriver, this);
	}

	@FindBy(xpath="//input[@id='ap_email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signbtn;
	
	public void verifyTitle() {
		try {
			Assert.assertEquals("Amazon Sign In", driver.getTitle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void doLoginAs(String user,String pass) {
		try {
			username.sendKeys(user);
			continuebtn.click();
			Thread.sleep(5000);
			password.sendKeys(pass);
			signbtn.click();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

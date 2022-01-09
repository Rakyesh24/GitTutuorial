package bhanepompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BH_HomePage {
	
	//class instance 
	WebDriver driver;
	public String url="https://www.bhaane.com/"; 
	public BH_HomePage(WebDriver idriver) {
		this.driver=idriver;
		PageFactory.initElements(idriver, this);
		
	}
	
	
	@FindBy(xpath="//header/div[1]/div[1]/div[4]/ul[1]/li[1]/form[1]/span[1]/span[1]/span[1]/span[2]")
	WebElement countryDropDown;
	
	@FindBy(xpath="//body/span[1]/span[1]/span[2]/ul[1]/li[2]/span[1]/img[1]")
	WebElement countryUSA;
	
	@FindBy(xpath="//body/span[1]/span[1]/span[2]/ul[1]/li[1]/span[1]/img[1]")
	WebElement countryINDIA;
	
	@FindBy(xpath="//li[contains(text(),'account')]")
	WebElement account;
	
	@FindBy(xpath="//div[contains(text(),'sign up >')]")
	WebElement signup;
	
	@FindBy(xpath="//*[@id='mdiv']/div")
	WebElement dissmiss;
	
	
	
	public void openApp() {
		driver.get(url);
	}
	
	
	public void clickCountryUSA() {
		try {
			if(dissmiss.isDisplayed()) {
				dissmiss.click();
			}
			
			countryDropDown.click();
			countryUSA.click();
			account.click();
			signup.click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void clickCountryINDIA() {
		try {
			countryDropDown.click();
			countryINDIA.click();
			account.click();
			signup.click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void loginInApp() {
		try {
			if(dissmiss.isDisplayed()) {
				dissmiss.click();
			}
			
			countryDropDown.click();
			countryUSA.click();
			account.click();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}

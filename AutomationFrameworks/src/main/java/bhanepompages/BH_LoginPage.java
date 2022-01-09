package bhanepompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BH_LoginPage {
	
	//class instance 
		WebDriver driver;
		 
		public BH_LoginPage(WebDriver idriver) {
			this.driver=idriver;
			PageFactory.initElements(idriver, this);
			
		}
		
		
		
		@FindBy(xpath="//body/div[@id='modal-login']/div[1]/form[1]/div[1]/input[1]")
		WebElement emailid;
		
		
		
		@FindBy(xpath="//body/div[@id='modal-login']/div[1]/form[1]/div[2]/input[1]")
		WebElement password;
		
		@FindBy(xpath="//*[@id='modal-login']/div/form/div[4]/button")
		WebElement submit;
		
		
		
		
		public void doLoginAs(String email,String pass) {
			try {
				Thread.sleep(5000);
				
				emailid.sendKeys(email);
				
				password.sendKeys(pass);
				submit.click();
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	

}

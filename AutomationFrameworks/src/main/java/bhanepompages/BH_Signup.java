package bhanepompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BH_Signup {
	
	//class instance 
		WebDriver driver;
		 
		public BH_Signup(WebDriver idriver) {
			this.driver=idriver;
			PageFactory.initElements(idriver, this);
			
		}
		
		@FindBy(xpath="//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
		WebElement firstname;
		
		@FindBy(xpath="//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
		WebElement lastname;
		
		@FindBy(xpath="//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
		WebElement emailid;
		
		@FindBy(xpath="//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/input[1]")
		WebElement phonenumber;
		
		@FindBy(xpath="//body/div[@id='modal-register']/div[1]/form[1]/div[1]/div[5]/div[1]/input[1]")
		WebElement password;
		
		@FindBy(xpath="//body/div[@id='modal-register']/div[1]/form[1]/div[2]/button[1]")
		WebElement submit;
		
		
		
		public void doRegisterAs(String first,String last,String email,String phone,String pass) {
			try {
				Thread.sleep(5000);
				firstname.sendKeys(first);
				lastname.sendKeys(last);
				emailid.sendKeys(email);
				phonenumber.sendKeys(phone);
				password.sendKeys(pass);
				submit.click();
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	

}

package rediffpompages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver idriver){
		this.driver=idriver;
	}
	
	public void compareTitle(String expectedTitle) {
		try {
			Assert.assertEquals(expectedTitle, driver.getTitle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void doLoginAs(String user,String pass) {
		try {
			driver.findElement(By.xpath("//input[@id='login1']")).sendKeys(user);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

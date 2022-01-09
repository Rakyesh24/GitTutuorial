package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HookTest {
	WebDriver driver;
	
	@Before 
	public void setup() { 
		 WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		  
	}
	@After
	public void quit() {
		driver.close();
	}
	@Given("Rediffmail application is opened")
	public void rediffmail_application_is_opened() {
	    driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}

	@When("user try to login with invalid credentails")
	public void user_try_to_login_with_invalid_credentails() {
		driver.findElement(By.id("login1")).sendKeys("Selenium");
		driver.findElement(By.id("password")).sendKeys("Selenium321");
		driver.findElement(By.name("proceed")).click();
	}

	@Then("validate the result of rediffmail")
	public void validate_the_result_of_rediffmail() {
		  if(driver.findElement(By.xpath("//div[@id='div_login_error']")).isDisplayed()) {
			   System.out.println("Passed");
		   }
		   else {
			   System.out.println("Failed");
		   }
	}

	@Given("Login application is opened")
	public void login_application_is_opened() {
		driver.get("https://www.bhaane.com/");
		try {
			Thread.sleep(5000);
			if(driver.findElement(By.xpath("//*[@id='mdiv']/div")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id='mdiv']/div")).click();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

	@When("user try to login with valid credentails")
	public void user_try_to_login_with_valid_credentails() {
		 driver.findElement(By.xpath("//li[contains(text(),'account')]")).click();
			driver.findElement(By.xpath("//*[@id='modal-login']/div/form/div[1]/input")).sendKeys("qatest12345@gmail.com");
		   driver.findElement(By.xpath("//*[@id='modal-login']/div/form/div[2]/input")).sendKeys("tester12");
		   driver.findElement(By.xpath("//*[@id='modal-login']/div/form/div[4]/button")).click();
	}

	@Then("validate the result of Bhane")
	public void validate_the_result_of_bhane() {
		try {
			Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@class='col lower hidden-xs']/a")).click();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
	}

}

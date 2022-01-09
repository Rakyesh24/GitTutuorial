package bhanedefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BhaneLogin {
	WebDriver driver;
	@Given("user open chrome browser")
	public void user_open_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver =new ChromeDriver();
	    
	}

	@Given("open bhane application")
	public void open_bhane_application() {
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

	@When("user enter username and password and click login button")
	public void user_enter_username_and_password_and_click_login_button() {
		  driver.findElement(By.xpath("//li[contains(text(),'account')]")).click();
		driver.findElement(By.xpath("//*[@id='modal-login']/div/form/div[1]/input")).sendKeys("qatest12345@gmail.com");
	   driver.findElement(By.xpath("//*[@id='modal-login']/div/form/div[2]/input")).sendKeys("tester12");
	   driver.findElement(By.xpath("//*[@id='modal-login']/div/form/div[4]/button")).click();
	}

	@Then("validate message")
	public void validate_message() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//li[@class='col lower hidden-xs']/a")).click();
		
	}


}

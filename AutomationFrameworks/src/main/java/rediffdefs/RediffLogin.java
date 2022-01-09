package rediffdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RediffLogin {

	WebDriver driver;
	@When("Login page is open {string}")
	public void login_page_is_open(String string) {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.get(string);
	}

	@Given("I want to write a step with {string}")
	public void i_want_to_write_a_step_with(String username) {
		driver.findElement(By.id("login1")).sendKeys(username);
	   
	}

	@When("I check for the {string} in step")
	public void i_check_for_the_in_step(String pass) {
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.name("proceed")).click();
	}

	@Then("I verify the {string} in step")
	public void i_verify_the_in_step(String string) {
	   if(driver.findElement(By.xpath("//div[@id='div_login_error']")).isDisplayed()) {
		   System.out.println(string);
	   }
	   else {
		   System.out.println(string);
	   }
	}

}

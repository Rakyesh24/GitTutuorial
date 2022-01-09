package bhanepomtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bhanepompages.BH_HomePage;
import bhanepompages.BH_Signup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BH_TC_1 {
	WebDriver driver;
  @Test
  public void home() {
	  BH_HomePage hm=new BH_HomePage(driver); 
	  hm.openApp();
	  hm.clickCountryUSA();
	  
	  
  }
  
  @Test(dependsOnMethods="home")
  public void login() {
	  BH_Signup lp=new BH_Signup(driver); 
	  lp.doRegisterAs("Tester", "QA", "qatest1234@gmail.com", "9087654321", "tester12");
	  
	  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }
}

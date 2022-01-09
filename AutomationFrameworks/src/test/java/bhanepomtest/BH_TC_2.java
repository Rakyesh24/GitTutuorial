package bhanepomtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bhanepompages.BH_HomePage;
import bhanepompages.BH_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BH_TC_2 {
	WebDriver driver;
  @Test
  public void home() {
	  BH_HomePage hm=new BH_HomePage(driver); 
	  hm.openApp();
	  hm.loginInApp();
	  
	  
  }
  
  @Test(dependsOnMethods="home")
  public void login() {
	  BH_LoginPage lp=new BH_LoginPage(driver); 
	  lp.doLoginAs("qatest1234@gmail.com","tester12");
	  
	  
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

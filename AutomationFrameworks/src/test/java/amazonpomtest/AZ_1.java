package amazonpomtest;

import org.testng.annotations.Test;

import amazonpompages.AZ_HomePage;
import amazonpompages.AZ_SiginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class AZ_1 {
	WebDriver driver;
  @Test
  public void home() {
	  AZ_HomePage hp=new AZ_HomePage(driver);
	  hp.openApp();
	  hp.verifyCountry("Amazon.in");
	  hp.navigatetoLogin();
  }
  @Test(dependsOnMethods="home")
  public void login() {
	  AZ_SiginPage sp=new AZ_SiginPage(driver);
	  sp.verifyTitle();
	  sp.doLoginAs("qa@gmail.com", "tester");
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}

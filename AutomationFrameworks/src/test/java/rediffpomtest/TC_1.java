package rediffpomtest;

import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import rediffpompages.HomePage;
import rediffpompages.LoginPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC_1 {
	WebDriver driver;

	@Test(priority=1)
	public void openhomepage() {
		HomePage hp = new HomePage(driver);
		hp.openUrl();
		hp.compareTitle("Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		hp.gotoLoginPage();

	}
	
	@Test(dependsOnMethods="openhomepage")
	public void login() {
		LoginPage lp=new LoginPage(driver);
		lp.compareTitle("Rediffmail");
		lp.doLoginAs("Selenium", "Selenium321");
	}

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterTest
	public void quit() {
		driver.close();
	}

}

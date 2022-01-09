package rediffpompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

	public final static String url = "https://www.rediff.com/";
	WebDriver driver;
	private static By sign = By.xpath("//a[contains(text(),'Sign in')]");
	private static By register = By.xpath("//a[contains(text(),'Create Account')]");

	public HomePage(WebDriver idriver) {
		this.driver = idriver;
	}

	public void openUrl() {
		driver.get(url);
	}

	public void compareTitle(String expectedTitle) {
		try {
			Assert.assertEquals(expectedTitle, driver.getTitle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void gotoLoginPage() {
		try {
			driver.findElement(sign).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void gotoCreateAccountPage() {
		try {
			driver.findElement(register).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

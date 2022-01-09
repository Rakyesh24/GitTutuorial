package amazonpompages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AZ_HomePage {
	WebDriver driver;
	public AZ_HomePage(WebDriver idriver) {
		this.driver=idriver;
		PageFactory.initElements(idriver, this);
	}
	private String url="https://www.amazon.in/";
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement accountSign;
	
	@FindBy(tagName="a")
	List<WebElement> allink;
	
	@FindBy(how = How.XPATH, using = "//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[1]/span[1]/span[2]/span[1]")
	WebElement country;
	
	@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-icp']/div[2]/span[2]/span[1]")
	WebElement countryText;
	
	@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]")
	WebElement loginBtn;
	
	public void openApp() {
		driver.get(url);
	}
	public void verifyCountry(String text) {
		try {
			Actions act=new Actions(driver);
			act.moveToElement(country).perform();
			Thread.sleep(3000);
			
			if(countryText.getText().contains(text)) {
				System.out.println(text);
			}
			else {
				System.out.println(text);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void navigatetoLogin() {
		try {
			Actions act=new Actions(driver);
			act.moveToElement(accountSign).perform();
			Thread.sleep(3000);
			
			loginBtn.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

package datadrivendevelopment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import bhanepompages.BH_HomePage;
import bhanepompages.BH_Signup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IDD_TC_1 {
	WebDriver driver; 
  @Test(dataProvider="data")
  public void login(String first,String last,String email,String mobno,String pass) {
	  
	  BH_HomePage hm=new BH_HomePage(driver); 
	  hm.openApp();
	  hm.clickCountryUSA();
	  
	  BH_Signup lp=new BH_Signup(driver); 
	  lp.doRegisterAs(first,last,email,mobno,pass);
	  
	  
  }
  
  @DataProvider
  public Object[][] data(){
	  
	  
	  
	  Object[][] obj= new Object[5][5];
	  
	  obj[0][0]="Tester";
	  obj[0][1]="QA";
	  obj[0][2]="qatest12345@gmail.com";
	  obj[0][3]="9087654323";
	  obj[0][4]="tester12";
	  
	  obj[1][0]="Tester";
	  obj[1][1]="QA";
	  obj[1][2]="qatest12346@gmail.com";
	  obj[1][3]="9087654324";
	  obj[1][4]="tester12";
	  
	  obj[2][0]="Tester";
	  obj[2][1]="QA";
	  obj[2][2]="qatest12347@gmail.com";
	  obj[2][3]="9087654325";
	  obj[2][4]="tester12";
	  
	  
	  obj[3][0]="Tester";
	  obj[3][1]="QA";
	  obj[3][2]="qatest12346@gmail.com";
	  obj[3][3]="9087654326";
	  obj[3][4]="tester12";
	  
	  
	  obj[4][0]="Tester";
	  obj[4][1]="QA";
	  obj[4][2]="qatest12347@gmail.com";
	  obj[4][3]="9087654327";
	  obj[4][4]="tester12";
	  
	  
	  
	  return obj;
  }
  
  
  @BeforeMethod
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize(); 
  }

  @AfterMethod
  public void afterTest() {
	 driver.close();
  }
}

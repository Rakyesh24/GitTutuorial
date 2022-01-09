package datadrivendevelopment;

import org.testng.annotations.Test;

import bhanepompages.BH_HomePage;
import bhanepompages.BH_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class HMapTest {
	WebDriver driver;
	@Test(dataProvider = "dp")
	public void login(HashMap<String, String> hmap) {
		BH_HomePage hm=new BH_HomePage(driver); 
		  hm.openApp();
		  hm.loginInApp();
		  BH_LoginPage lp=new BH_LoginPage(driver); 
		  lp.doLoginAs(hmap.get("Email"),hmap.get("Password"));
	}

	@DataProvider
	public Object[][] dp() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(".//src//test//resources//Data//BhaneTestData.xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int allRows = sheet.getLastRowNum();
		int allCells = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[allRows][1];

		for (int i = 0; i < allRows; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			String key = "";
			String value = "";
			for (int j = 0; j < allCells; j++) {
				key = sheet.getRow(0).getCell(j).getStringCellValue();
				if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.STRING)) {

					value = sheet.getRow(i + 1).getCell(j).getStringCellValue();

				} else if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.NUMERIC)) {
					value = String.valueOf(sheet.getRow(i + 1).getCell(j).getNumericCellValue());
				} else if (sheet.getRow(i + 1).getCell(j).getCellType().equals(CellType.FORMULA)) {
					value = String.valueOf(sheet.getRow(i + 1).getCell(j).getCellFormula());
				}
				map.put(key, value);

			}
			obj[i][0] = map;

		}
		wb.close();

		return obj;
	}


	 @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize(); 
	  }

	  @AfterMethod
	  public void afterMethod() {
		  //driver.close();
	  }

}

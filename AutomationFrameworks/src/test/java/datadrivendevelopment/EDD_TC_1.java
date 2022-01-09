package datadrivendevelopment;

import org.testng.annotations.Test;

import bhanepompages.BH_HomePage;
import bhanepompages.BH_Signup;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class EDD_TC_1 {
	WebDriver driver; 
  @Test(dataProvider = "dp")
  public void f(String first,String last,String email,String mobno,String pass) {
	  BH_HomePage hm=new BH_HomePage(driver); 
	  hm.openApp();
	  hm.clickCountryUSA();
	  
	  BH_Signup lp=new BH_Signup(driver); 
	  lp.doRegisterAs(first,last,email,mobno,pass);
	 
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize(); 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
   
	  
	  XSSFWorkbook wb=new XSSFWorkbook(".//src//test//resources//Data//BhaneTestData.xlsx"); 
	  //XSSFWorkbook is class which open spreadsheet file in background
	 
	  XSSFSheet sheet=wb.getSheetAt(0);
	  //this will open sheet at index or first
	  
	  //wb.getSheet("Signup");
	  
	  
	  
	  int allRows=sheet.getLastRowNum()+1;
	  
	  int allCells=sheet.getRow(0).getLastCellNum();
	 
	  Object[][] obj=new Object[allRows][allCells];
	 
	 
	  for (int i = 0; i < allRows; i++) {
		
		  for (int j = 0; j < allCells; j++) {
			  
			  
			  if(sheet.getRow(i).getCell(j).getCellType().equals(CellType.NUMERIC)) {
				 long num=(long)sheet.getRow(i).getCell(j).getNumericCellValue();
				 obj[i][j]=Long.toString(num);
			  }
			  
			  else if(sheet.getRow(i).getCell(j).getCellType().equals(CellType.STRING)) {
				  obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			  }
			  
			  else if(sheet.getRow(i).getCell(j).getCellType().equals(CellType.FORMULA)) {
				  obj[i][j]=String.valueOf(sheet.getRow(i).getCell(j).getCellFormula());
			  }
			
			
		}
	}
	  
	  
	  wb.close();
	  
	  
	  
	  
	  return obj;
  }
}

package pe.edu.galaxy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pe.edu.galaxy.objectrepositity.*;

public class ExcelDataProvider {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() {
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider="DataLogin")
	public void TestWithExcelData(String UserName, String Password) throws InterruptedException {
		System.out.println(UserName + " | " + Password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(UserName);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		//driver.findElement(By.name("Submit"));
		//Assert.assertEquals("Test completed", "OrangeHRM", driver.getTitle());
		Thread.sleep(2000);	
	}
	
	@DataProvider(name="DataLogin")
	public Object[][] getData() {
		
		String excelPath = "/Users/lruiz/Desktop/selenium-testng/session_7/data/data.xlsx";
		Object data = (Object) testData(excelPath, "hoja1");
	
		return (Object[][]) data;
		
	}
	
	public Object testData(String excelPath, String sheetName) {
		
		ExcelFile excel  = new ExcelFile(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				
				String CellData = excel.getCellDataString(i,j);
				System.out.println(CellData + " | ");
				data[i-1][j] = CellData;
				
			}
			System.out.println();
		}
		return data;
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}

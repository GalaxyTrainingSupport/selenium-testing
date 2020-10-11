package pe.edu.galaxy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pe.edu.galaxy.objectrepositity.ExcelFile;

public class ExcelDataProvider {

	WebDriver driver = null;

	@BeforeTest
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@Test(dataProvider="DataLogin")
	public void doLogin(String userName, String password ) throws InterruptedException {
		System.out.println(userName + "--" + password );
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		//driver.findElement(By.name("Submit"));
		//Assert.assertEquals("Test completed", "OrangeHRM", driver.getTitle());

		Thread.sleep(2000);
	}
	

	@DataProvider(name = "DataLogin")
	  public Object[][] getData() {

		String excelPath = "/Users/lruiz/Desktop/selenium-testng/session_7/data/data.xlsx";
		String sheetName = "Hoja1";
		Object data = testData(excelPath, sheetName);
		return (Object[][]) data;	
	}
	
	public Object testData(String excelPath, String sheetName) {
		ExcelFile excel = new ExcelFile(excelPath, sheetName);
		int RowCount = excel.getColCount();
		int ColCount = excel.getColCount();

		Object data[][] = new Object[RowCount - 1][ColCount];

		for (int i = 1; i < RowCount; i++) {
			for (int j = 0; j < ColCount; j++) {
				String CellData = excel.getCellDataString(i, j);
				data[i - 1][j] = CellData;
			}
		}
		
		return data;

	}
	
	@AfterSuite
	public void tearDonw() {
		driver.quit();
	}
}

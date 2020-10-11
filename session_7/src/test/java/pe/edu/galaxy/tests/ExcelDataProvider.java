package pe.edu.galaxy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	WebDriver driver = null;

	@BeforeTest
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@Test
	public void f() {
	}

	
	public Object testData(String excelPath, String sheetName ) {
		
		
		ExcelFile excel = new ExcelFile(excelPath,sheetName);
		
		return driver;
		
	}
}

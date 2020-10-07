package pe.edu.galaxy.util;


import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class Base {

	protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void setup() {
		driver.set(new ChromeDriver());
	}

	@AfterSuite
	public void tearDown() {
		getDriver().quit();
	}

}

package pe.edu.galaxy.util;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	@BeforeMethod
	public void setup() {
		driver.set(new ChromeDriver());
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}

package pe.edu.galaxy.properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertyBrowser {

	WebDriver driver = null;
	public static String WebBrowser = null;

	@BeforeSuite
	public void setup() {
		System.out.println("setup system properties");
	}

	@BeforeTest
	public void launchBrowser() {

	}

	@Test
	public void test() {
		System.out.println(driver.getTitle());
		System.out.println("Test Completed");
		//
	}

	@BeforeClass
	public void tearDown() {
		driver.quit();
	}
}
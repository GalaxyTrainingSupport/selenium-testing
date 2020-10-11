package pe.edu.galaxy.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pe.edu.galaxy.objectrepository.PropertiesFile;

public class PropertyBrowser {

	WebDriver driver = null;
	public static String WebBrowser = null;

	@BeforeSuite
	public void setup() {
		System.out.println("setup system properties");
	}

	@BeforeTest
	public void launchBrowser() {
		PropertiesFile.getProperties();
		if (WebBrowser.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else if (WebBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (WebBrowser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (WebBrowser.equalsIgnoreCase("operA")) {
			driver = new OperaDriver();
		}

	}

	@BeforeClass
	public void getURL() {
		driver.get("http://google.com.pe/");
	}

	@Test
	public void showTitle() {
		System.out.println(driver.getTitle());
		System.out.println("Test Completed");
		PropertiesFile.setProperties();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
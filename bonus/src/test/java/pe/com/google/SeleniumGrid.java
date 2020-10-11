package pe.com.google;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {

	WebDriver driver;
	String baseURL, nodeURL;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		baseURL = "https://www.google.com.pe/";
		nodeURL = "http://10.0.1.10:41311/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.MAC);
		driver = new RemoteWebDriver(new URL(nodeURL), capability);
	}

	@AfterTest
	public void afterTest() {	
		driver.quit();
	}

	@Test
	public void googleSearch() {
		driver.get(baseURL);
		if (driver.getPageSource().contains("Google")) {
			Assert.assertTrue(true, "Test successfully completed");
		} else {
			Assert.assertTrue(false, "Test Failed");
		}

	}

}
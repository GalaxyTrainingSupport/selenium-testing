package pe.edu.galaxy.browser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
	WebDriver driver = null;

	@Parameters("BrowserName")
	@BeforeTest
	public void setup(String BrowserName) {
		
		System.out.println("Thread Id" + Thread.currentThread().getId());

		if (BrowserName.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (BrowserName.equalsIgnoreCase("operA")) {
			driver = new OperaDriver();
		}
	}


	@Test
	public void google() throws InterruptedException {
		driver.get("http://google.com.pe/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterMethod
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}

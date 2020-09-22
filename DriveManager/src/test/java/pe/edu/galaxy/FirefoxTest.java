package pe.edu.galaxy;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.firefoxdriver().setup();
	}

	@Before
	public void setupTest() {
		driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/");
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() throws InterruptedException {
		
		WebElement search = driver.findElement(By.name("search"));
		
		search.sendKeys("Webdriver");
		
		search.sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
		driver.quit();
	}

}
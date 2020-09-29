package pe.edu.galaxy.bonus;


import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class TestWebinar {

	static private WebDriver driver;
	static private String url = "https://smartbear.com/resources/webinars/selenium-academy-101/";

	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.gecko.driver",
				"/Users/lruiz/eclipse-workspace/Sesion_1/Selenium/src/test/resources/browser/geckodriver");
	}

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test()
	public void register() throws InterruptedException, IOException {
		
		// fill out form
		driver.findElement(By.id("Email")).sendKeys("larm609@hotmail.com");
		driver.findElement(By.id("FirstName")).sendKeys("Carlos");
		driver.findElement(By.id("LastName")).sendKeys("Cabrera");
		driver.findElement(By.id("Company")).sendKeys("MyPimes S.R.L.");

		// set value of dropdown with selectByVisibleText
		Select role = new Select(driver.findElement(By.id("Position_Role__c")));
		role.selectByVisibleText("Software QA");

		// set value of dropdown with selectByValue
		Select country = new Select(driver.findElement(By.id("Country")));
		country.selectByValue("Peru");

		driver.findElement(By.id("Phone")).sendKeys("987654321");
		
		// find button submit
		WebElement button = driver.findElement(By.xpath("//*[@id=\"mktoForm_3401\"]/div[16]/span/button"));

		Thread.sleep(2000);
		// move to button [ Watch Webinar ]
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,420)");
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
		
		//click to register
		button.submit();
		Thread.sleep(5000);
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}

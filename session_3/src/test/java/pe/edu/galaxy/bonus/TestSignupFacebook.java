package pe.edu.galaxy.bonus;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSignupFacebook {
	
	private WebDriver driver;
	  
	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.gecko.driver",
				"/Users/lruiz/eclipse-workspace/Sesion_1/Selenium/src/test/resources/browser/geckodriver");
	}
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
	}
	
	@Test()
	public void register() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
		Thread.sleep(4000);
		//change focus to frame
		//driver.switchTo().frame(driver.findElement(By.id("frameId")));
		driver.switchTo().defaultContent();
		//fill out form
		driver.findElement(By.name("firstname")).sendKeys("Cleodomiro");
		driver.findElement(By.name("lastname")).sendKeys("Pancracio Chirstofeneel");
		
		driver.findElement(By.name("reg_email__")).sendKeys("942637283");
		//driver.findElement(By.name("reg_email_confirmation__")).sendKeys("lruiz_selenium@fastmail.com");
		
		driver.findElement(By.id("password_step_input")).sendKeys("My5Up3RP4ssW0RD");
		driver.findElement(By.id("day")).sendKeys("22");
		driver.findElement(By.id("month")).sendKeys("May");
		driver.findElement(By.id("year")).sendKeys("1984");
		
		List<WebElement> elements = driver.findElements(By.name("sex"));
			System.out.println(elements);
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input")).click();
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(20000);
		
		driver.findElement(By.name("code")).sendKeys("32454");
		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

}

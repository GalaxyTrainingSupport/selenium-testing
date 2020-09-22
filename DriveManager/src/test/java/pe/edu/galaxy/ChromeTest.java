package pe.edu.galaxy;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {

    private WebDriver driver;
    

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    	//WebDriverManager.operadriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        //driver = new OperaDriver();
        driver.get("https://www.google.com.pe/");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
    	
    	WebElement  element = driver.findElement(By.name("q"));
    	
    	element.clear();
    	
    	element.sendKeys("coldplay");
    	
    	element.sendKeys(Keys.ENTER);
    	
    	Thread.sleep(4000);

    }

}

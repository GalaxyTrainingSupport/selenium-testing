package pe.edu.galaxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

static String path = "";
	
	public static void main(String[] args) throws InterruptedException {
		
		path = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/browser/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://facebook.com");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}

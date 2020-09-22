package pe.edu.galaxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {

	static String path = "";
	
	public static void main(String[] args) throws InterruptedException {
		
		path = System.getProperty("user.dir");
		
		System.out.println(path);
		
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/browser/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mvnrepository.com/");
		
		//driver.close();
		
		Thread.sleep(6000);
		
		//best practice
		driver.quit(); 
		
	}

}

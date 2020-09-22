package pe.edu.galaxy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "/Users/lruiz/eclipse-workspace/Selenium_2/src/test/resources/browser/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3.org/TR/webdriver1/#locator-strategies");
		
		List<WebElement> elements = driver.findElements(By.tagName("table"));
		
		for(WebElement element  : elements) {
		
			System.out.println("Parrafo Texto:" + element.getText());
		}
		
		System.out.println(elements);
		
		Thread.sleep(4000);
		
		driver.quit();

	}

}

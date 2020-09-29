package pe.edu.galaxy;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selected {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver","/Users/lruiz/eclipse-workspace/Sesion_1/Selenium/src/test/resources/browser/geckodriver");

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().setPosition(new Point(20, 220));

		// navigates to url
		driver.get("https://the-internet.herokuapp.com/checkboxes");

		// returns true if element is checked else returns false
		boolean value = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type")).isSelected();

		//print value
		System.out.println(value);

		driver.close();

	}

}

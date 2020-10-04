package pe.edu.galaxy.synchronizing;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;

public class testFluentWait extends BaseTest {

	@Test
	public void ExplicitWait() {
		// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
		// https://www.selenium.dev/documentation/en/webdriver/waits/
		getDriver().get("https://www.google.com.pe/");

		try {
			
			WebElement query = getDriver().findElement(By.name("q"));
			query.sendKeys("selenium");
			query.sendKeys(Keys.ESCAPE);
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);

			WebElement message = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.name("btnI"));
				}
			});

			Assert.assertFalse(message.getText().contains("Feeling"));

		} finally {
			getDriver().quit();
		}
	}
}

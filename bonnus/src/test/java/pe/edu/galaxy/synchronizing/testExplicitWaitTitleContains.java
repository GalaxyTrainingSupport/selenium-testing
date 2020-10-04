package pe.edu.galaxy.synchronizing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;

public class testExplicitWaitTitleContains extends BaseTest {

	@Test
	public void ExplicitWait() {
		
		//https://www.selenium.dev/documentation/en/webdriver/waits/

		getDriver().get("https://www.google.com");

		// Enter a term to search and submit
		WebElement query = getDriver().findElement(By.name("q"));
		query.sendKeys("selenium");
		query.sendKeys(Keys.ENTER);

		// Create Wait using WebDriverWait.
		// This will wait for 10 seconds for timeout before title is updated with search term
		// If title is updated in specified time limit test will move to the text step
		// instead of waiting for 10 seconds
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.titleContains("selenium"));

		// Verify Title
		Assert.assertTrue(getDriver().getTitle().toLowerCase().startsWith("selenium"));
		
		// driver close
		getDriver().quit();

	}
}

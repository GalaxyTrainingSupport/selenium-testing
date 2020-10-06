package pe.edu.galaxy.synchronizing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;

public class testWithImplicitWait extends BaseTest {

	@Test
	public void ImplicitWait() {

		// Launch the sample Ajax application
		getDriver().get("http://cookbook.seleniumacademy.com/AjaxDemo.html");

		// Set the implicit wait time out to 10 Seconds
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			// Get link for Page 4 and click on it
			getDriver().findElement(By.linkText("Page 4")).click();

			// Get an element with id page4 and verify it's text
			WebElement message = getDriver().findElement(By.id("page4"));

			Assert.assertTrue(message.getText().contains("Nunc nibh tortor"));
			
		} finally {
			getDriver().quit();
		}

	}
}

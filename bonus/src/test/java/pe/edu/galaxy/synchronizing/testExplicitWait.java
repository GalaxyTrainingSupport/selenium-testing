package pe.edu.galaxy.synchronizing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;

public class testExplicitWait extends BaseTest {

	@Test
	public void ExplicitWait() {
		
		//https://www.selenium.dev/documentation/en/webdriver/waits/#explicit-wait
		// Launch the sample Ajax application
		getDriver().get("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		
		try {
			
			getDriver().findElement(By.linkText("Page 4")).click();
			
			WebElement message = new WebDriverWait(getDriver(), 5)
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("page4"));
						}
			});
			
			Assert.assertTrue(message.getText().contains("Nunc nibh tortor"));
			
		} finally {
			
			getDriver().quit();
			
		}
	}
}

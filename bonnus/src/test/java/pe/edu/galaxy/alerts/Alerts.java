package pe.edu.galaxy.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;

public class Alerts extends BaseTest {

	@Test
	public void SimpleAlert() {
		getDriver().get("http://cookbook.seleniumacademy.com/Alerts.html");
		getDriver().manage().window().maximize();

		// Click Simple button to show an Alert box
		getDriver().findElement(By.id("simple")).click();

		// Optionally we can also wait for an Alert box using the
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.alertIsPresent());

		// Get the Alert
		Alert alert = getDriver().switchTo().alert();

		// Get the text displayed on Alert
		String textOnAlert = alert.getText();

		// Check correct message is displayed to the user on Alert box
		Assert.assertEquals("Hello! I am an alert box!", textOnAlert);

		// Click OK button, by calling accept method
		alert.accept();
	}

}

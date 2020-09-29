package com.discountdance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageObject {

private static WebDriver driver;
	
	private By show_popup = By.xpath("//*[@id=\"cartSummary\"]/tbody/tr[1]/td/div[2]/a[2]/strong");
	
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void showPaymentPopup() {
		driver.findElement(show_popup).click();
	}
}

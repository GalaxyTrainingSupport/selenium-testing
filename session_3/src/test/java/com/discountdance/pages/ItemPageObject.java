package com.discountdance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPageObject {

private static WebDriver driver;
	
	private By quantity = By.id("qty1");
	private By add_to_bag = By.linkText("ADD TO BAG");
	private By link_checkout = By.id("miniBagTrigger");
	
	public ItemPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setQuantity(int qty) {
		driver.findElement(quantity).sendKeys(Integer.toString(qty));
	}

	public void addToCart() {
		driver.findElement(add_to_bag).click();
	}
	
	public void goToCheckoutCart() {
		driver.findElement(link_checkout).click();
	}
	
}

package com.discountdance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingPageObject {

	protected static WebDriver driver;
	
	private By billing_email = By.id("emailSearching");
	private By billing_name = By.id("billingName");
	private By billing_address1 = By.id("billingAddress1");
	private By billing_address2 = By.id("billingAddress2");
	private By billing_country = By.id("billingCountry");
	private By billing_city = By.id("billingCity");
	private By billing_zip = By.id("billingZip");
	private By billing_state = By.id("billingState");
	private By billing_next = By.id("FCB_UiNext");
	
	
	public BillingPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillOutBilling(String email, String name, String address1, String address2, String country, String city, String zip, String state) throws InterruptedException {
		
		driver.findElement(billing_email).sendKeys(email);
		driver.findElement(billing_name).sendKeys(name);
		driver.findElement(billing_address1).sendKeys(address1);
		driver.findElement(billing_address2).sendKeys(address2);
		driver.findElement(billing_country).sendKeys(country);
		driver.findElement(billing_city).sendKeys(city);
		driver.findElement(billing_zip).sendKeys(zip);
		driver.findElement(billing_state).sendKeys(state);	
	}

	public void moveToShipping() throws InterruptedException {

		driver.findElement(billing_next).click();	
	}
	
}

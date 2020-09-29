package com.discountdance.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.discountdance.pages.BillingPageObject;
import com.discountdance.pages.CheckoutPageObject;
import com.discountdance.pages.HomePageObject;
import com.discountdance.pages.ItemPageObject;

public class TestSearchItem {

	private static WebDriver driver;
	private static String url = "https://www.discountdance.com/";

	public static void main(String[] args) throws InterruptedException {
		
		TestSearchItemToBuy();

	}

	public static void TestSearchItemToBuy() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"/Users/lruiz/eclipse-workspace/Sesion_1/Selenium/src/test/resources/browser/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePageObject homePage = new HomePageObject(driver);
		ItemPageObject itemPage = new ItemPageObject(driver);
		CheckoutPageObject checkoutPage = new CheckoutPageObject(driver);
		BillingPageObject billPage = new BillingPageObject(driver);
		
		//set value to search input
		Thread.sleep(3000);
		homePage.setSearchValue("Spiky Massage Ball Small");
		
		//click on search button
		Thread.sleep(3000);
		homePage.clickSearch();
		
		//Set qty
		Thread.sleep(3000);
		itemPage.setQuantity(3);
		
		//add item to cart
		Thread.sleep(5000);
		itemPage.addToCart();
		
		
		//go to shopping cart
		Thread.sleep(3000);
		itemPage.goToCheckoutCart();
		
		//show payment popup
		Thread.sleep(5000);
		checkoutPage.showPaymentPopup();
		
		//fill out billing form
		billPage.fillOutBilling("lruizajax@gmail.com", "Luis Ruiz", "Av. Lima 123", "Covida", "Peru", "Lima", "15107", "Lima");
		
		Thread.sleep(10000);
		driver.quit();
		
	}
	
	//Spiky Massage Ball Small
	
}

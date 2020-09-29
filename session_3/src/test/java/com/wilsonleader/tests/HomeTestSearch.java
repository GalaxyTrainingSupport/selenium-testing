package com.wilsonleader.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wilsonleadet.pages.HomeSearchObjects;

public class HomeTestSearch {
	
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		HomeSearch();
	}

	public static void HomeSearch() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"/Users/lruiz/eclipse-workspace/Sesion_1/Selenium/src/test/resources/browser/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wilsonsleather.com/");

		// enter search value
		Thread.sleep(5000);
		HomeSearchObjects.setSearchValue(driver).sendKeys("James Crackle Leather Backpack");

		// click to search
		Thread.sleep(5000);
		HomeSearchObjects.clickSearch(driver).submit();

		// kill process
		Thread.sleep(5000);
		driver.quit();

		System.out.println("Test completed sucessfully");

	}

}

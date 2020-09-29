package com.wilsonleader.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeTest {

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
		driver.findElement(By.id("navsearchbox")).sendKeys("James Crackle Leather Backpack");

		// click to search
		Thread.sleep(5000);
		driver.findElement(By.id("searchBtn")).submit();

		// kill process
		Thread.sleep(5000);
		driver.quit();

		System.out.println("Test completed sucessfully");

	}
}

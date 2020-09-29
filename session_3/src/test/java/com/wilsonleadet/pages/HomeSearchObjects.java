package com.wilsonleadet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeSearchObjects {

	public static WebElement setSearchValue(WebDriver driver) {
		return driver.findElement(By.id("navsearchbox"));
	}
	
	public static WebElement clickSearch(WebDriver driver) {
		return driver.findElement(By.id("searchBtn"));
	}
	
}

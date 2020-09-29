package com.discountdance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject {
	
	private static WebDriver driver;
	
	private By input_search = By.name("skey");
	private By input_button = By.name("submit");
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setSearchValue(String item) {
		driver.findElement(input_search).sendKeys(item);
	}

	public void clickSearch() {
		driver.findElement(input_button).submit();
	}
	
}

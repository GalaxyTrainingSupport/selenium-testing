package com.ohrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects {

	private static WebDriver driver;

	private By input_username = By.id("txtUsername");
	private By input_password = By.id("txtPassword");
	private By input_submit = By.id("btnLogin");

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.findElement(input_username).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.findElement(input_password).sendKeys(password);
	}

	public void dosubmit() {
		driver.findElement(input_submit).submit();
	}

}

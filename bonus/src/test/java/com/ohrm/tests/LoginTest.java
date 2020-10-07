package com.ohrm.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ohrm.pages.LoginPageObjects;

import pe.edu.galaxy.util.Base;

public class LoginTest extends Base {

	LoginPageObjects loginPage = new LoginPageObjects(getDriver());

	@BeforeTest
	public void runBrowser() {
		getDriver().get("https://opensource-demo.orangehrmlive.com/");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
	}

	@Test(description = "login on orange hrmlive")
	public void Login() {
		try {
			loginPage.setUsername("Admin");
			loginPage.setPassword("admin123");
			loginPage.dosubmit();
		} catch (Exception e) {
			System.out.println("Message -->" + e.getMessage());
			System.out.println("Cause -->" + e.getCause());
			e.getStackTrace();
		} finally {
			Assert.assertEquals("OrangeHRM", getDriver().getTitle());
		}
	}

}

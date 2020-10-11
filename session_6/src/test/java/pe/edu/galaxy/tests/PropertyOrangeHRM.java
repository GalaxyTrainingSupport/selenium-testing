package pe.edu.galaxy.tests;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PropertyOrangeHRM {

	static WebDriver driver = null;
	static Properties obj = new Properties();
	static String path = System.getProperty("user.dir");


	// pre-conditions before run test
	@BeforeSuite
	public void Setup() throws Exception {
		System.out.println("Setup system properties for chrome");	
		InputStream input = new FileInputStream(path +"/data/orangehrm.properties");
		obj.load(input);		
	}

	@BeforeTest
	public void lauchBrowser() {
		driver = new FirefoxDriver();
	}

	@BeforeClass
	public void setURL() {
		driver.get(obj.getProperty("url"));
	}

	// running test
	@Test
	public void doLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys(obj.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(obj.getProperty("password"));
		driver.findElement(By.name("Submit"));
		Assert.assertEquals("Test completed", "OrangeHRM", driver.getTitle());
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}

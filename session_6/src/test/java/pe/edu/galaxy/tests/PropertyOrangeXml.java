package pe.edu.galaxy.tests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PropertyOrangeXml {

	static WebDriver driver = null;
	static SAXReader saxReader = new SAXReader();
	static String path = System.getProperty("user.dir");
	static Document document = null;


	// pre-conditions before run test
	@BeforeSuite
	public void Setup() throws Exception {
		System.out.println("Setup system properties for chrome");	
		File inputFile = new File(System.getProperty("user.dir") +"/data/properties.xml");
        document = saxReader.read(inputFile);	
	}

	@BeforeTest
	public void lauchBrowser() {
		driver = new FirefoxDriver();
	}

	@BeforeClass
	public void setURL() {
		String url = document.selectSingleNode("//login/url").getText();
		System.out.println(url);
		driver.get(document.selectSingleNode("//login/url").getText());
	}

	// running test
	@Test
	public void doLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys(document.selectSingleNode("//login/user").getText());
		driver.findElement(By.id("txtPassword")).sendKeys(document.selectSingleNode("//login/pass").getText());
		driver.findElement(By.name("Submit"));
		Assert.assertEquals("Test completed", "OrangeHRM", driver.getTitle());
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}

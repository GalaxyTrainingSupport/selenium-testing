package pe.edu.galaxy;

import org.testng.annotations.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FullAnnotations {

//pre-conditions before run test
	@BeforeSuite
	public void Setup() {
		System.out.println("Setup system properties for chrome");
	}

	@BeforeTest
	public void lauchBrowser() {
		System.out.println("Launch the browser");
	}

	@BeforeClass
	public void setURL() {
		System.out.println("enter URL application");
	}

//running test
	@Test
	public void signUp() {
		System.out.println("login to app");
	}

	@Test(enabled = false)
	public void twoFactorAuth() {
		System.out.println("send code");
	}

	@Test(description = "Take screen of profile photo")
	public void takeScreen() {
		System.out.println("taking screen ....");
	}

	@Test(description = "Take screen of profile photo")
	public void skip_Ignore_Test() {
		String a = "hello";
		if (a.equals("hello")) {
			System.out.println("Pass");
			throw new SkipException("script no ready to test");
		} else {
			System.out.println("else condition ....");
		}
	}

	@Test(description = "update email....", priority = 1, dependsOnMethods = "signUp")
	public void updateEmail() {
		System.out.println("update email....");
	}

	@Test(dependsOnMethods = "skip_Ignore_Test")
	public void updateFullname() {
		System.out.println("update email....");
	}

	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}

//pos condition after run tests
	@AfterClass
	public void deleteCookies() {
		System.out.println("delete cookies");
	}

	@AfterTest
	public void makeReports() {
		System.out.println("make/generate report");
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("close browser");
	}

}

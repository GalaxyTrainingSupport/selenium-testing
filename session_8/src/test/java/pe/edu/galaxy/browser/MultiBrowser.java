package pe.edu.galaxy.browser;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class MultiBrowser {
	WebDriver driver = null;

	@Parameters("BrowserName")
	@BeforeClass
	public void setup(String BrowserName) {

		System.out.println("Thread Id" + Thread.currentThread().getId());
		if (BrowserName.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (BrowserName.equalsIgnoreCase("operA")) {
			driver = new OperaDriver();
		}
	}

	@DataProvider(name = "dp")
	public String[] readJson() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("/Users/lruiz/Desktop/selenium-testng/session_8/data/users.json");

		Object obj = jsonParser.parse(reader);

		JSONObject UsersJsonObj = (JSONObject) obj;
		JSONArray UsersjsonArr = (JSONArray) UsersJsonObj.get("users");

		String datausers[] = new String[UsersjsonArr.size()];

		for (int i = 0; i < UsersjsonArr.size(); i++) {
			JSONObject users = (JSONObject) UsersjsonArr.get(i);
			String username = (String) users.get("username");
			String password = (String) users.get("password");

			datausers[i] = username + "," + password;
		}
		return datausers;
	}

	@Test(dataProvider = "dp")
	public void doLogin(String data) throws InterruptedException {
		String users[] = data.split(",");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(users[0]);
		driver.findElement(By.id("txtPassword")).sendKeys(users[1]);
		driver.findElement(By.id("btnLogin")).submit();

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}

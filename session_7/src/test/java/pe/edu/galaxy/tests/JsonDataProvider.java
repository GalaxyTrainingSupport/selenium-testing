package pe.edu.galaxy.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class JsonDataProvider {

	WebDriver driver = null;

	@DataProvider(name = "dp")
	public String[] readJson() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("/Users/lruiz/Desktop/selenium-testng/session_7/data/users.json");

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

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}

	@Test(dataProvider="dp")
	public void doLogin(String data) throws InterruptedException {
		String users[] = data.split(",");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(users[0]);
		driver.findElement(By.id("txtPassword")).sendKeys(users[1]);
		driver.findElement(By.id("btnLogin")).submit();

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}

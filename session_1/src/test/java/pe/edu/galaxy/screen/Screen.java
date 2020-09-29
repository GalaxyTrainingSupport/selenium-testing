package pe.edu.galaxy.screen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screen {

	public static void main(String[] args) throws InterruptedException, IOException {

		String path = System.getProperty("user.dir");
		
		String url = "https://online.galaxy.edu.pe/";

		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/browser/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		
		driver.navigate().to(url);
		
		WebElement element = driver.findElement(By.id("carousel"));
		
		System.out.println(element);
		
		//full screen 
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//for  specific element screen
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File( path + "/src/test/resources/screen/element.png"));

		driver.quit();

	}

	
}

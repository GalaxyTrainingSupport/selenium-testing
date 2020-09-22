package pe.edu.galaxy;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Opera {

	public static void main(String[] args) throws InterruptedException, IOException {

		String path = System.getProperty("user.dir");
		
		String url = "https://online.galaxy.edu.pe/";

		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/browser/operadriver");

		WebDriver driver = new OperaDriver();

		driver.manage().window().maximize();

		//delete cookies
		driver.manage().deleteAllCookies(); 
		
		driver.navigate().to(url);
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File( path + "/src/test/resources/screen/imagen.png"));

		driver.quit();

	}

}

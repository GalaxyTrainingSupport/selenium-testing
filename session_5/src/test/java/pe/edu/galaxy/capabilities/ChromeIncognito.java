package pe.edu.galaxy.capabilities;

import java.awt.desktop.QuitEvent;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeIncognito {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-minimized");
		options.addArguments("window-size=800,480");
		
		options.merge(capabilities);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://cacert.com/");
	
		
	}

}

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

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "Catalina");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "latest");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.selenium_version", "3.141.59");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-minimized");
		options.addArguments("window-size=800,480");
		
		options.merge(caps);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://cacert.com/");
	
		
	}

}

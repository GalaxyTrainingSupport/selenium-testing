package pe.edu.galaxy.capabilities;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;


public class Chrome {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		options.addArguments("--incognito"); //browser runs mode incognite
		options.addArguments("--headless"); //browser runs in the background
		
		options.merge(capabilities);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://chromedriver.chromium.org/capabilities");
		
		System.out.println("Title: "  + driver.getTitle());
	
		driver.quit();
		
	}

}

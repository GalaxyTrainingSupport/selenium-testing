package pe.edu.galaxy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendMail {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "/Users/lruiz/eclipse-workspace/Selenium_2/src/test/resources/browser/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://konta-srl.odoo.com/contactus");
		 
	
		driver.findElement(By.name("Name")).sendKeys("Galaxy");
		driver.findElement(By.name("Phone")).sendKeys("987654321");
		
		driver.findElement(By.name("email_from")).sendKeys("lruizajax@gmail.com");
		driver.findElement(By.name("Partner Name")).sendKeys("KONTA S.R.L.");
		driver.findElement(By.name("subject")).sendKeys("Selenium WebElements");
		driver.findElement(By.name("Description")).sendKeys("probandoooo");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div/div[1]/form/div[8]/div/a")).click();
				
		driver.quit();

	}

}

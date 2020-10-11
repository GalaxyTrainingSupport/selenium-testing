package pe.com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;


public class captcha extends BaseTest {

	@Test
	public void Captcha() throws InterruptedException {
		
		getDriver().get("https://e-menu.sunat.gob.pe/cl-ti-itmenu/MenuInternet.htm");
		
		getDriver().manage().window().maximize();

		getDriver().findElement(By.id("txtDni")).sendKeys("42296494");

		getDriver().findElement(By.id("txtContrasena")).sendKeys("42296494");
		
		Thread.sleep(2000);
		
		//get number of iframes in page
		int size = getDriver().findElements(By.tagName("iframe")).size();
		System.out.println("Nº Iframes in page "+ size);
		
		//get iframe
		WebElement  iframe = getDriver().findElement(By.xpath("//*[@id=\"divcaptcha\"]/div/div/iframe"));
		
		//switch to iframe
		getDriver().switchTo().frame(iframe);
		
		//get value id='recaptcha-token
		String value = getDriver().findElement(By.xpath("/html/body/input[@id='recaptcha-token']")).getAttribute("value");
		System.out.println("sout -->"+value);
		
		//find span checkbox
		WebElement check = getDriver().findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span"));
		check.click();
		System.out.println(check);
		

		//switch to new popup
		getDriver().switchTo().defaultContent();
		WebElement iframeaudio = getDriver().findElement(By.xpath(""));
		
		Thread.sleep(5000);
		
		getDriver().quit();
		
	}

}

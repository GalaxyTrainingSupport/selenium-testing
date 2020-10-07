package pe.edu.galaxy.cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class Cookies {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/browser/chromedriver");
        
		WebDriver driver = new ChromeDriver();
        
        try {
        	
            driver.get("https://online.galaxy.edu.pe");
            
            //create cookie
            Cookie cookie1 = new Cookie("selenium", "session 1");
            Cookie cookie2 = new Cookie("pom", "session 2");

            //add cookies
            driver.manage().addCookie(cookie1);
            driver.manage().addCookie(cookie2);

            //get cookies
            Set<Cookie> cookies = driver.manage().getCookies();
            
            //show all cookies
            System.out.println("First Time");
            System.out.print(cookies);
            
            //delete cookies
            driver.manage().deleteCookie(cookie1);
            driver.manage().deleteCookie(cookie2);

            //show again
            Set<Cookie> cookies2 = driver.manage().getCookies();
            System.out.println("Second Time");
            System.out.print(cookies2);
        
        } finally {
          
        	driver.quit();
        }
    }

}

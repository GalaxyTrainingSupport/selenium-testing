package pe.edu.galaxy.table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tables {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();

		WebElement table = driver.findElement(By.id("customers"));
		List<WebElement> rowsList = table.findElements(By.tagName("tr"));

		List<WebElement> columnsList = null;

		for (WebElement row : rowsList) {
			System.out.println(" ");
			columnsList = row.findElements(By.tagName("td"));

			for (WebElement column : columnsList) {
				System.out.print(column.getText() + ",");
			}

		}

		driver.quit();
	}
}

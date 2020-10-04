package pe.edu.galaxy.paralell;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;

public class Annotations extends BaseTest {

	@Test(threadPoolSize = 2, invocationCount = 4)
	public void peruano() {
		getDriver().get("https://elperuano.pe/");
		//System.out.println("Test Peruano thread Id is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle() + "Nº " + Thread.currentThread().getId() );
		//System.out.println("Test Peruano has been completed");
	}

}

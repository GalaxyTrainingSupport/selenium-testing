package pe.edu.galaxy.paralell;

import org.testng.annotations.Test;

import pe.edu.galaxy.util.BaseTest;

public class Testing extends BaseTest {

	@Test
	public void google() {
		getDriver().get("https://www.google.com.pe/");
		System.out.println("Test Google thread Id is: " + Thread.currentThread().getId());
		System.out.println("Title is: " + getDriver().getTitle());
		System.out.println("Test Google has been completed");
	}

	@Test
	public void yahoo() {
		getDriver().get("https://www.yahoo.com/");
		System.out.println("Test Yahoo thread Id is: " + Thread.currentThread().getId());
		System.out.println("Title is: " + getDriver().getTitle());
		System.out.println("Test Yahoo has been completed");
	}
	
	@Test
	public void facebook() {
		getDriver().get("https://www.facebook.com/");
		System.out.println("Test Facebook thread Id is: " + Thread.currentThread().getId());
		System.out.println("Title is: " + getDriver().getTitle());
		System.out.println("Test Facebook has been completed");
	}
	
	@Test
	public void elcomercio() {
		getDriver().get("https://elcomercio.pe/");
		System.out.println("Test Comercio thread Id is: " + Thread.currentThread().getId());
		System.out.println("Title is: " + getDriver().getTitle());
		System.out.println("Test Comercio has been completed");
	}
	
	@Test
	public void peruano() {
		getDriver().get("https://elperuano.pe/");
		System.out.println("Test Peruano thread Id is: " + Thread.currentThread().getId());
		System.out.println("Title is: " + getDriver().getTitle());
		System.out.println("Test Peruano has been completed");
	}
}

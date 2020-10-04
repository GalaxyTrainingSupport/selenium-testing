package pe.edu.galaxy.extend;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pe.edu.galaxy.util.BaseTest;

public class HtmlExtend extends BaseTest {

	int int_random = ThreadLocalRandom.current().nextInt();
	
	ExtentHtmlReporter report = new ExtentHtmlReporter("./reports/ejemplo"+ int_random +".html");
	ExtentReports extent = new ExtentReports();
	String path = System.getProperty("user.dir");

	
	
	@Test (description = "Search on Google ...")
	public void testGoogle() throws IOException {
		extent.attachReporter(report);
		ExtentTest logger = extent.createTest("Test Google!");
		
		/*LOGIC TEST {
		 * 
		 * 
		 * 
		 * } */
		
		logger.log(Status.PASS, getDriver().getTitle());
		logger.addScreenCaptureFromPath(path + "/screenshot/google.png");
		logger.assignCategory("Regression Test","End2End Test");
		logger.assignAuthor("Milena Melo");
		extent.flush();	
	}
	
	@Test (description = "Search on Yahoo ...")
	public void testYahoo() throws IOException {
		extent.attachReporter(report);
		ExtentTest logger2 = extent.createTest("Test Yahoo?");
		
		/*LOGIC TEST {
		 * 
		 * 
		 * 
		 * } */
		
		logger2.log(Status.FAIL, "verify title");
		logger2.addScreenCaptureFromPath("/Users/lruiz/Desktop/selenium-testng/session_5/screenshot/errors/404.png");
		extent.flush();	
	}
}

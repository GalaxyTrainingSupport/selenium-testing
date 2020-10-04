package pe.edu.galaxy.extend;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport {

	ExtentHtmlReporter report = new ExtentHtmlReporter("./reports/ejemplo1.html");
	ExtentReports extent = new ExtentReports();

	@Test (description = "Search on Google ...")
	public void testGoogle() {
		extent.attachReporter(report);
		ExtentTest logger = extent.createTest("Test Google!");
		
		/*LOGIC TEST {
		 * 
		 * 
		 * 
		 * } */
		
		logger.log(Status.PASS, "verify title");
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

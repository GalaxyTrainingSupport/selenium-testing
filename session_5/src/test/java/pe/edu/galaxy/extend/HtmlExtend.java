package pe.edu.galaxy.extend;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pe.edu.galaxy.util.BaseTest;

public class HtmlExtend extends BaseTest {

int int_random = ThreadLocalRandom.current().nextInt();
	
	ExtentHtmlReporter report = new ExtentHtmlReporter("./reports/HtmlReport_"+ int_random +".html");
	ExtentReports extend = new ExtentReports();
	String path = System.getProperty("user.dir");

	@Test (description="Search on Peruano")
	public void TestGoogle() throws IOException {
		extend.attachReporter(report);
		ExtentTest logger =  extend.createTest("El Peruano Test");
		getDriver().get("https://elperuano.pe/");
		logger.log(Status.PASS, getDriver().getTitle());
		logger.addScreenCaptureFromPath(path + "/screenshot/google.jpg");
		logger.assignCategory("Regrestion Test");
		logger.assignAuthor("Luis Ruiz", "Milena Melo");
		extend.flush();
	}
	
	@Test (description="Breaking news")
	public void TestYahoo() throws IOException {
		ExtentTest logger2 =  extend.createTest("Breaking News","Verify the breaking news have been published");
		getDriver().get("https://elcomercio.com.pe/");
		logger2.log(Status.FAIL, getDriver().getTitle());
		logger2.fail("because url not found on server", MediaEntityBuilder.createScreenCaptureFromPath(path + "/screenshot/errors/404-error.png").build());
		logger2.assignCategory("End to End");
		logger2.assignAuthor("Luis Ruiz", "Liz Ayuque");
		extend.flush();
		
	}
	
	@Test (description="Search on Selenium")
	public void TestSelenium() throws IOException {
		ExtentTest logger3 =  extend.createTest("Selenium Test");
		getDriver().get("http://selenium.dev/");
		logger3.log(Status.PASS, getDriver().getTitle());
		logger3.pass("evidences from website responsive", MediaEntityBuilder.createScreenCaptureFromPath(path + "/screenshot/selenium.png").build());
		logger3.assignCategory("Integration Test");
		logger3.assignAuthor("Milena Melo", "Liz Ayuque");
		extend.flush();
		
	}
	
	
	@Test
	public void TestExtendReports() throws IOException {
		ExtentTest parentTest = extend.createTest("MyFirstTest");
		ExtentTest childTest = parentTest.createNode("MyFirstChildTest","Node Description");
		childTest.pass("details");
		
		getDriver().get("http://www.extentreports.com/");
		
		parentTest.log(Status.PASS, getDriver().getTitle());
		parentTest.assignCategory("Integration Test");
		extend.flush();
		
	}
}

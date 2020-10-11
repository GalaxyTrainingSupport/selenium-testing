package pe.edu.galaxy.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestNG implements ITestListener {

	public void onStar(ITestContext context) {
		System.out.println("--onStar -->" + context.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("--onTestStart -->" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("--onTestSuccess -->" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("--onTestFailure -->" + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("--onTestSkipped -->" + result.getName());

	}

	public void onFinish(ITestContext context) {
		System.out.println("--onFinish -->" + context.getName());
	}

}

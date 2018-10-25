package tests;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.TestBase;

public class Listeners implements ITestListener {
	
	TestBase base = new TestBase();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Fill out if necessary
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Fill out if necessary		
	}

	/**
	 * Take screenshot of screen when test fails
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			base.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Fill out if necessary		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Fill out if necessary		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Fill out if necessary		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Fill out if necessary

	}

}

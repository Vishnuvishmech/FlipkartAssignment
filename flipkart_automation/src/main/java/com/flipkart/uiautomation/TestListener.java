package com.flipkart.uiautomation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

	public static String screenShotPath;
	

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String sDate = sdf.format(date);
		String testOutputDir = System.getProperty("user.dir") + "/test-output";
		screenShotPath = System.getProperty("user.dir") + "/Screenshots" + "/Run-" + sDate;

		// Setting ScreenShot Report Location
		File file3 = new File(screenShotPath);
		if (!(file3.exists())) {
			file3.mkdirs();
			System.out.println("--scrrenshot folder created");
		}

		// Setting test-output folder location
		File testOutputFile = new File(testOutputDir);

		if (!testOutputFile.exists()) {
			System.out.println(testOutputFile + " does not exist");
			return;
		}
		// deletes the test output folder
		if (testOutputFile.isDirectory()) {
			try {
				testOutputFile.delete();
				System.out.println("------test output dir deleted--------");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		String imagePath = null;
		try {
			imagePath = ActionUtils.captureScreenshot(screenShotPath, new TestSession().driver );
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("<a href=" + imagePath + "> <img width='100' height='100' src=" + imagePath + "> </a>");
		System.out.println("--> " + result.getName() + " test case has been failed ");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("--> " + result.getName() + " test case has been skipped");

	}

	public void onTestStart(ITestResult result) {
		System.out.println("--> " + result.getName() + " test case started ");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("--> " + result.getName() + " test case has been passed");

	}
}

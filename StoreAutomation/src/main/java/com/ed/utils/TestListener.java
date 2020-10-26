package com.ed.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ed.utils.ExtentManager;
import com.ed.utils.ExtentTestManager;

public class TestListener implements ITestListener{
	public void onTestStart(ITestResult result) {
		System.out.println("Running Test Case" + "" + result.getMethod().getMethodName());
		System.out.println(result.getName() + " test case started");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Executed" + " " + result.getMethod().getMethodName() + " " + "successfully");
		System.out.println("The name of the testcase passed is :" + result.getName());
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		String targetLocation = null;

		// String testClassName = getTestClassName(result.getInstanceName()).trim();
		String testClassName = result.getTestClass().getName();
		// String timeStamp = Util.getCurrentTimeStamp();

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + dateFormat.format(new Date()) + ".png";
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
				+ "screenshots";
		System.out.println("Screen shots reports path - " + reportsPath);

		try

		{
			File file = new File(reportsPath + fileSeperator + testClassName);

			if (!file.exists())

			{
				if (file.mkdirs()) {

					System.out.println("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					System.out.println("Failed to create directory: " + file.getAbsolutePath());
				}

			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;

			File targetFile = new File(targetLocation);
			// FileUtils.copyFile(screenshotFile, targetFile);
			FileHandler.copy(screenshotFile, targetFile);

		} catch (FileNotFoundException e) {
			// log.info("File not found exception occurred while taking screenshot " +
			// e.getMessage());

			System.out.println("File not found exception occurred while taking screenshot " + e.getMessage());

		} catch (Exception e) {
			// log.info("An exception occurred while taking screenshot " + e.getCause());

			System.out.println("An exception occurred while taking screenshot" + e.getCause());
			e.printStackTrace();
		}

		// attach screenshots to report

		try {
			ExtentTestManager.getTest().fail("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			// log.info("An exception occured while taking screenshot " + e.getCause());
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			e.printStackTrace();
		}

		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :" + result.getName());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());

	}

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");

	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();

	}

}

package com.seleniume2e.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.seleniume2e.base.Base;
import com.seleniume2e.utilities.ExtentReportManager;
import com.seleniume2e.utilities.ScreenshotUtility;

public class TestListeners implements ITestListener{
	private ExtentTest extentTest;
	private ExtentReports reports = ExtentReportManager.getReportObject();
	
	WebDriver driver = null;
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = reports.createTest(result.getMethod().getMethodName());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			extentTest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getScreenshot(driver)).build());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			extentTest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getScreenshot(driver)).build());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		extentTest.log(Status.PASS, "The Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			extentTest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getScreenshot(driver)).build());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		extentTest.log(Status.FAIL, "The Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

}

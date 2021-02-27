package com.seleniume2e.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.seleniume2e.base.Base;
import com.seleniume2e.utilities.ExtentReportManager;
import com.seleniume2e.utilities.ScreenshotUtility;

public class TestListeners extends Base implements ITestListener{
	private ExtentTest extentTest;
	private ExtentReports reports = ExtentReportManager.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = reports.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.PASS, "The Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		
		extentTest.log(Status.FAIL, "The Test Failed");
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		extentTest.addScreenCaptureFromBase64String(ScreenshotUtility.getScreenshot(driver), result.getMethod().getMethodName());
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

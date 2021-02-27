package com.seleniume2e.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

	static ExtentReports report;
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"//target//reports//extentReport.html";
		ExtentSparkReporter extentReporter = new ExtentSparkReporter(path);
		
		extentReporter.config().setDocumentTitle("Automation Report");
		extentReporter.config().setReportName("Selenium E2E Automation Test");
		
		report = new ExtentReports();
		
		report.attachReporter(extentReporter);
		report.setSystemInfo("Tester","Anuplab Chatterjee");
		report.setSystemInfo("System","Windows");
		
		return report;
	}
}

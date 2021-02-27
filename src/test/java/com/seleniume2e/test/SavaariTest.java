package com.seleniume2e.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniume2e.base.Base;
import com.seleniume2e.pageobject.SavaariPage;
import com.seleniume2e.utilities.ConfigReader;

public class SavaariTest {

	WebDriver driver = null;
	ConfigReader configReader = null;
	Base base = null;
	SavaariPage savaariPage = null;
	@BeforeMethod
	public void initialize() {
		configReader = new ConfigReader();
		base = new Base();
		
		driver = base.getDriver();
		driver.get(configReader.readConfig().getProperty("savaariUrl"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void enterUserDetails() {
		savaariPage = new SavaariPage(driver);
		savaariPage.enterTravelDetails(configReader.readConfig().getProperty("fromCity"), configReader.readConfig().getProperty("toCity"));
		
		savaariPage.selectDate(configReader.readConfig().getProperty("date"));
		savaariPage.selectTime();
	}
}

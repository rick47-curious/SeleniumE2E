package com.seleniume2e.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniume2e.base.Base;
import com.seleniume2e.pageobject.GreenKartPage;
import com.seleniume2e.utilities.ConfigReader;
import com.seleniume2e.utilities.ReadInputData;

public class GreenKartTest {

	Base base = null;
	GreenKartPage greenKartPage = null;
	ConfigReader configReader = null;
	WebDriver driver = null;
	
	@BeforeMethod
	public void initialization() {
		base = new Base();
		configReader = new ConfigReader();
		
		driver = base.getDriver();
		driver.get(configReader.readConfig().getProperty("baseUrl"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getVegetables(){
		return ReadInputData.getExcelData();
	}
	
	@Test(dataProvider = "getVegetables")
	public void getItemNames(String data) {
		greenKartPage = new GreenKartPage(driver);
		
		greenKartPage.getItem(data);
	}
}

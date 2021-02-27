package com.seleniume2e.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniume2e.base.Base;
import com.seleniume2e.pageobject.LoginPage;
import com.seleniume2e.utilities.ConfigReader;
import com.seleniume2e.utilities.ReadLoginExcel;

public class LoginTest {

	private WebDriver driver;
	
	Base base = null;
	ConfigReader configReader = null;
	LoginPage loginPage = null;
	@BeforeMethod
	public void initialize() {
		base = new Base();
		configReader = new ConfigReader();
		
		String baseurl = configReader.readConfig().getProperty("url");
		
		driver = base.getDriver();
		//Hit the url
		driver.get(baseurl);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		//System.out.println();
		return ReadLoginExcel.getLoginData();
	}
	@Test(dataProvider = "getData")
	public void loginUser(String email,String pwd) {
		loginPage = new LoginPage(driver);
		//Hard assertion
		Assert.assertEquals(loginPage.getTitle(),"Log In to WebServices Testing using SoapUI");
		loginPage.enterEmail(email);
		loginPage.enterPassword(pwd);
		loginPage.clickLogin();
		
	}
}

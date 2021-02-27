package com.seleniume2e.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	private String email = "user_email";
	private String password = "user_password";
	private String loginBtn = "//form//div[3]//input[1]";
	
	public void enterEmail(String emailId) {
		
		driver.findElement(By.id(email)).sendKeys(emailId);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(By.id(password)).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(By.xpath(loginBtn)).click();
	}
	
	public String getTitle() {
		
		return driver.findElement(By.tagName("h1")).getText();
	}
}

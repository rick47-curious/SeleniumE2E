package com.seleniume2e.pageobject;

import java.util.concurrent.SubmissionPublisher;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavaariPage {

	private WebDriver driver;
	
	public SavaariPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private String fromCity = "input[id='fromCityList']";
	private String toCity = "div[class='col-10 col tocityHolder']>input";
	private String calenderInput = "span[class='ng-tns-c16-1 ui-calendar']>input";
	private String monthName = "span[class='ng-tns-c16-1 ui-calendar']>div div[class='ui-datepicker-title']>span:nth-child(1)";
	private String yearName = "span[class='ng-tns-c16-1 ui-calendar']>div div[class='ui-datepicker-title']>span:nth-child(2)";
	private String nextBtn = "span[class='ng-tns-c16-1 ui-calendar']>div>div>a:nth-child(2)";
	private String timeList = "select[id='pickUpTime']";
	private String button = "button[class='book-button btn']";
	private String carDetails = "div[class='col-12 col carListHolder']";
	public void enterTravelDetails(String from, String to) {
		
		driver.findElement(By.cssSelector(fromCity)).sendKeys(from);
		waitForElement(driver.findElement(By.cssSelector("ngb-typeahead-window[class='dropdown-menu']")));
		driver.findElement(By.cssSelector(fromCity)).sendKeys(Keys.ENTER);
		
		driver.findElement(By.cssSelector(toCity)).sendKeys(to);
		waitForElement(driver.findElement(By.cssSelector("ngb-typeahead-window[class='dropdown-menu']")));
		driver.findElement(By.cssSelector(toCity)).sendKeys(Keys.ENTER);
	}
	
	public void selectDate(String date) {
		
		driver.findElement(By.cssSelector(calenderInput)).click();
		waitForElement(driver.findElement(By.cssSelector("span[class='ng-tns-c16-1 ui-calendar']>div")));
		
		String extractDate = date.substring(2);
		//Getting the calender title with year and month name
		
		
		while (true) {
			String getUiMonth = driver.findElement(By.cssSelector(monthName)).getText().trim();
			String getUiYear = driver.findElement(By.cssSelector(yearName)).getText().trim();
			
			String uiDate = getUiMonth + getUiYear;
			
			if (uiDate.equalsIgnoreCase(extractDate)) {
				driver.findElement(By.xpath("//*[text()='"+date.substring(0,2)+"']")).click();
				break;
			}else {
				driver.findElement(By.cssSelector(nextBtn)).click();
			}
		}
	}
	
	public void selectTime() {
		driver.findElement(By.cssSelector(timeList)).click();
		Select select = new Select(driver.findElement(By.cssSelector(timeList)));
		select.selectByVisibleText("10:00 AM ");
		driver.findElement(By.cssSelector(button)).click();
		waitExplicitly();
	}
	
	
	public void waitForElement(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitExplicitly() {
		int i=0;
		while(i<5) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
	
	
}

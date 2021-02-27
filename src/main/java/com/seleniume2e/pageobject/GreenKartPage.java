package com.seleniume2e.pageobject;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreenKartPage {

	private WebDriver driver;
	
	public GreenKartPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private String listItems = "//table[@class='table table-bordered']//tbody//tr//td[1]";
	private String nextBtn = "//ul//li[7]";
	
	List<WebElement> elementSearched;
	
	
	public void getItem(String vegetable) {
		
//		int flag = 0;
		do {
		List<WebElement> items = driver.findElements(By.xpath(listItems));
		elementSearched = items.stream().filter(s-> s.getText().contains(vegetable)).collect(Collectors.toList());
		if(elementSearched.size()<1) {
			driver.findElement(By.xpath(nextBtn)).click();
		}
		}while(elementSearched.size()<1);
		
//		while (true) {
//			
//			List<WebElement> items = driver.findElements(By.xpath(listItems));	
//		for (WebElement element : items) {
//			if (element.getText().contains("Brinjal")){
//				flag = 1;
//				break;
//			}
//		}
//		
//		if (flag==0) {
//			driver.findElement(By.xpath(nextBtn)).click();
//		}else if (flag==1) {
//			break;
//		}
//		
//		}
	}
}

package com.seleniume2e.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static String getScreenshot(WebDriver driver) {
		
		String sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		
		return sourcePath;
	}
}

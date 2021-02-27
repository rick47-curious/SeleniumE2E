package com.seleniume2e.base;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.seleniume2e.utilities.ConfigReader;

public class Base {

	protected WebDriver driver;
	ConfigReader configReader = null;
	public void DriverFactory(String browserType) {

		if (browserType.equalsIgnoreCase("chrome")) {
			// Check for latest
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver_v88.exe");
			ChromeOptions options = new ChromeOptions();
			// disable notifications
			options.addArguments("--disable-notifications");
			// accept ssl certificates
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(options);

		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//return driver;
	}
	
	public WebDriver getDriver() {
		configReader = new ConfigReader();
		DriverFactory(configReader.readConfig().getProperty("browser"));
		return driver;
	}

}

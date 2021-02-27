package com.seleniume2e.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	
	
	public Properties readConfig() {
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config//config.properties");
			
			prop = new Properties();
			
			prop.load(fis);
			
			return prop;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}

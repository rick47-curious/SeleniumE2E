package com.seleniume2e.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadLoginExcel {

	
	public static String[][] getLoginData() {
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//LoginData.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			//First sheet
			XSSFSheet sheet = wb.getSheet("Sheet1");
			String [][]	data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for (int i=0;i<sheet.getLastRowNum();i++) {
				Row row = sheet.getRow(i+1);
				
				for (int j=0;j<row.getLastCellNum();j++) {
					
					data[i][j] = row.getCell(j).toString();
				}
			}
			wb.close();
			fis.close();
			
			return data;
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}

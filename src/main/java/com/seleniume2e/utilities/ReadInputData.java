package com.seleniume2e.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadInputData {

	public static String[][] getExcelData() {
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//InputData.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			
			String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
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
		
			e.printStackTrace();
		}
		return null;
	}
	
}

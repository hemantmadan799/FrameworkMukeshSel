package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA.DATA_CONVERSION;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	XSSFSheet sht;
	public ExcelDataProvider() 
	{
		File src=new File("./TestData/Data.xlsx");
		try {
		FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read Excel file"+e.getMessage());
		}
		
	}
	
	public String getStringData(String sheetName, int row, int col) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}

}

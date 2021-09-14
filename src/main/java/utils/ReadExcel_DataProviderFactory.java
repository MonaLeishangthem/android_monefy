package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Factory;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;

public class ReadExcel_DataProviderFactory{
	static Workbook book;
	static Sheet sheet;
	
	private final static Logger LOGGER = Logger.getLogger(ReadExcel_DataProviderFactory.class);
	
	public static Object[][] getData(String sheetName) throws IOException {	      
		  
		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
		
		final String TESTDATA_SHEET = filePath + "/src/main/resources/" + Android_Constants.FILE_NAME;	
	//	System.out.println("File Name : " + TESTDATA_SHEET);
		FileInputStream file = null;
	    try {
	    	file =  new FileInputStream(TESTDATA_SHEET);
	    }catch (FileNotFoundException e ) {
	    	e.printStackTrace();
	    }
	    try {
	    	book = WorkbookFactory.create(file);
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	    sheet =  book.getSheet(sheetName);
	    	
	    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  //  System.out.println(sheet.getLastRowNum());
	    int rowcount = sheet.getLastRowNum();
	   // int rowcount = 1;
	    for(int i=0;i< rowcount;i++) {
	    	for(int y=0; y< sheet.getRow(i).getLastCellNum();y++) {
	    		data[i][y] = sheet.getRow(i+1).getCell(y).toString();
	    	//	System.out.println("Data Provider read from excel " + data[i][y]);
	    	}
	    }
	   // System.out.println("Over");
	    	return data;
	}
	/*
	public static void main(String[] args) throws Exception {
		getData("basic");
    }*/
}

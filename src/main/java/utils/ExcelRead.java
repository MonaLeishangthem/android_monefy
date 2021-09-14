package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

/**
 * @author Moneshwori Leishangthem on 23/09/2018.
 */
public class ExcelRead {
	static Workbook book;
	static Sheet sheet;

	private final static Logger LOGGER = Logger.getLogger(ExcelRead.class);
    /*
    * getExcel() - will load and return the excel sheet.
    * */
    public static Sheet getExcel(String filePath, String fileName, String sheetName) throws IOException {
    	//Create an object of File class to open xlsx file
        File file = new File(filePath + fileName);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook Workbook = null;
        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        //Check condition if the file is xlsx file
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            Workbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        else if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of XSSFWorkbook class
            Workbook = new HSSFWorkbook(inputStream);
        }
        //Read sheet inside the workbook by its name
        Sheet excel_Sheet = Workbook.getSheet(sheetName);
        return excel_Sheet;
    }

    /*
    * readData_Excel() - will read and return the data from excel file.
    * */
    public String readData_Excel(String filePath, String fileName, String sheetName, int RowNum, int CellNum) throws IOException {
    	//System.out.println("readData_Excel()");
    	Sheet excel_Sheet = getExcel(filePath, fileName, sheetName);
    	
        Row excel_row = excel_Sheet.getRow(RowNum);
        String Cell_value = excel_row.getCell(CellNum).getStringCellValue();
        return Cell_value;
    }
    /*
    //data provider
    public static Object[][] getDataProvider(String sheetName) throws IOException {
    	//System.out.println("readData_Excel()");
    	
    	FileInputStream file = null;
    	String TESTData_SHEET_PATH = "/Users/mona/Documents/DataProvider.xlsx";
    	try {
    		file =  new FileInputStream(TESTData_SHEET_PATH);
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
    	for(int i=0;i< sheet.getLastRowNum();i++) {
    		for(int y=0; y< sheet.getRow(0).getLastCellNum();y++) {
    			data[i][y] = sheet.getRow(i+1).getCell(y).toString();
    		}
    	}
    	return data;
    }*/
}

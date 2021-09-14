package utils;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class GetDataFromExcel {
	private final static Logger LOGGER = Logger.getLogger(GetDataFromExcel.class);
	
	protected static String retrieveDataFromExcel(String sheetName, int RowNum, int CellNum) {
        String filePath = System.getProperty("user.dir") + "/";
        String fileName = Android_Constants.FILE_NAME;
        String data_value = null;
        ExcelRead excelRead = new ExcelRead();
        try {
            data_value = excelRead.readData_Excel(filePath, fileName, sheetName, RowNum, CellNum);
            return data_value;
        } catch (IOException e) {
            e.printStackTrace();
            return "NULL";
        }
        
    }
    /*
    * enter_data() - enters the text in webpage elements.
    * */
    public static String  enter_data(int row, int cell) throws InterruptedException {
        String Copyexcel_value = retrieveDataFromExcel(Android_Constants.SHEETNAME_STATIC, row, cell);
        return Copyexcel_value;
    }
}

package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.google.common.base.Splitter;


public class GetTestdata_ForSuite {

    // one instance, reuse
	static Workbook book;
	static Sheet sheet;
    static ArrayList<Object> data = new ArrayList<Object>();
    static ArrayList<Object> data1 = new ArrayList<Object>();
    static Object[][] suite_data = null;

    public static Object[][] getUserInputData(String suite) throws Exception {
    	switch(suite) {
	    	case "basicFlow":
	    		suite_data = ReadExcel_DataProviderFactory.getData("basic");
	    		
	    		for (int row = 0; row < suite_data.length; row++)//Cycles through rows
	    		{
	    		  for (int col = 0; col < suite_data[row].length; col++)//Cycles through columns
	    		  {
	    		 //   System.out.println( suite_data[row][col]); 
	    		  }
	    		 // System.out.println(); 
	    		}
	    		break;
	    	default:
	    		break;
    	}

       //  get data from excel
         return suite_data;
    }
    
    /*
    public static void main(String[] args) throws Exception {
    	getUserInputData("basicFlow");
    }*/
 
}
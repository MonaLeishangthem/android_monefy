package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

import utils.GetTestdata_ForSuite;

public class DataProviderClass {
	
	private final static Logger LOGGER = Logger.getLogger(DataProviderClass.class);
	 
	 //Androids
	 @DataProvider(name = "basicE2E") 
		public Object[][] basicE2E() throws Exception{
		 	String suite = "basicFlow"; 
		 	return GetTestdata_ForSuite.getUserInputData(suite);// E2E
		}
	 
}

package utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Android_Constants {
	 

	private final static Logger LOGGER = Logger.getLogger(Android_Constants.class);
	
	static File f = new File("src/main/resources");  
	static File fs = new File(f, "com.monefy.app.lite_2021-08-21.apk"); 
	
	 public static final String CAP_APPIUM_ANDROID_URL = "http://127.0.0.1:4723/wd/hub"; 
	
    //Capabilities for Appium
    public static final String CAP_APP_PACKAGE =  "com.monefy.app.lite";
    public static final String CAP_APP_ACTIVITY = "com.monefy.activities.main.MainActivity_";
    public static final String CAP_APP =  fs.getAbsolutePath();
  
    public static final String CAP_APP_DEVICENAME =  "device"; 
    public static final String CAP_APP_PLATFORMVERSION = "9";
    public static final String CAP_APP_PLATFORMNAME = "Android";
    public static final String CAP_APP_UDID = "FA69W0302834";
    
    public static final String FILE_NAME = "DataProvider1.xlsx";
    public static final String FILE_NOT_FOUND_ERR = "File NOT found";
    public static final String SHEETNAME_STATIC = "StaticText";
    public static final String SHEETNAME_FACTORY = "Sheet2"; 
    public static final String PATH_LOGS = "/test-output/Logs/";
    public static final String PATH_LOGS_SCREENSHOTS = "/test-output/Logs/Screenshots/";
    

 
}

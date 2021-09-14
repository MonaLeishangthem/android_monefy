package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.log4testng.Logger;

import com.testinium.deviceinformation.exception.DeviceNotFoundException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import tests.Android_DriverSetUp;;

public class TakeScreenShot {

	private final static Logger LOGGER = Logger.getLogger(TakeScreenShot.class);
	public TakeScreenShot() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getScreenshot(AppiumDriver driver, String filename ) throws IOException {
		LOGGER.debug("Capturing Screenshot : getScreenshot");
		File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot image location at " + filename);
		FileUtils.copyFileToDirectory(srcFiler, new File(filename));
	}
	
	public static void getScreenshot_Android(AndroidDriver driver, String outputlocation, String asset_name) throws Exception, Exception {
		
		File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String filename=Android_DriverSetUp.getUDID().toString();   //UUID.randomUUID().toString(); 
	    File targetFile=new File(outputlocation + asset_name +".jpg");
	    FileUtils.copyFile(srcFiler,targetFile);
	    System.out.println("Capturing Screenshot : getScreenshot" + targetFile);
		 
	}	
	
	

}

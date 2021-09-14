package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormat.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TakeScreenShotListener_Android implements ITestListener {
	private final static Logger LOGGER = Logger.getLogger(TakeScreenShotListener_Android.class);

//	String filePath = "/Users/mona/Documents/ScreenShots/Logs/iOS-ErrorScreenshot/";
	String filePath = System.getProperty("user.dir");
   	String fileName = filePath + "/test-output/Logs/Screenshots/";
	
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
    
	public TakeScreenShotListener_Android() {
		// TODO Auto-generated constructor stub
	}

    java.lang.reflect.Field field = null;
    AndroidDriver driver = null;
	
	public void onTestFailure(ITestResult iTestResult) {
		Class clazz = iTestResult.getTestClass().getRealClass();
		try {
			field = clazz.getDeclaredField("driver");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	        
	    field.setAccessible(true);

		try {
			AndroidDriver driver =  (AndroidDriver) field.get(iTestResult.getInstance());
			LOGGER.debug("***** Error :"+iTestResult.getName()+" Failed- Instance "+ iTestResult.getInstance().toString());
		    String methodName=iTestResult.getInstance().toString().trim();
		    ITestContext context = iTestResult.getTestContext();

		 //   captureScreenShot(iTestResult, "fail");
		    takeScreenShot(methodName, driver);
		    
        	/*TakesScreenshot scrShot =((TakesScreenshot)driver);
        	System.out.println("1" );
        	//File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        	File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


        	System.out.println("2");
        	File DestFile=new File("/Users/mona/Documents/GitHub/V3Automation/v3Optimize/qa-uat-playersdk/test-output/Logs/Screenshots/");
        	System.out.println("3");
        	FileUtils.copyFile(SrcFile, DestFile);
        	System.out.println("4");*/
		    
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
	} catch (ScreenshotException e) {
		e.printStackTrace();
	}
	   
	}
	
	public void onTestSkipped1(ITestResult iTestResult) throws NoSuchFieldException, SecurityException, Throwable, IllegalAccessException {
		Class clazz = iTestResult.getTestClass().getRealClass();
		String methodName=iTestResult.getInstance().toString().trim();
		System.out.println(methodName + " : is skipped");
		/*field = clazz.getDeclaredField("driver");
		driver = (AndroidDriver) field.get(iTestResult.getInstance());
		String methodName=iTestResult.getInstance().toString().trim();
        ITestContext context = iTestResult.getTestContext(); 
		takeScreenShot(methodName, (AndroidDriver) driver);*/
	}
    
	public void takeScreenShot(String methodName, AndroidDriver driver) {
   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name 
   	 LOGGER.debug("***Placed screen shot in "+filePath+" ***");
	//	 System.out.println("Error screen shot name: "+ methodName +" ***");
           try {
				FileUtils.copyFile(scrFile, new File(fileName+methodName+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
   }

}  
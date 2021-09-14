package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat.Field;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TakeScreenShotListener implements ITestListener {
	private final static Logger LOGGER = Logger.getLogger(TakeScreenShotListener.class);

//	String filePath = "/Users/mona/Documents/ScreenShots/Logs/iOS-ErrorScreenshot/";
	String filePath = System.getProperty("user.dir");
   	String fileName = filePath + "/test-output/Logs/Screenshots/";
	
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
    
	public TakeScreenShotListener() {
		// TODO Auto-generated constructor stub
	}

    java.lang.reflect.Field field = null;
    AppiumDriver<MobileElement> driver = null;
	
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
			driver = (AppiumDriver<MobileElement>) field.get(iTestResult.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	    
	  //  System.out.println("***** Error "+iTestResult.getName()+" test has failed *****");
	  //  LOGGER.debug("***** Error :"+iTestResult.getName()+" Failed- Instance "+ iTestResult.getInstance().toString());
    	String methodName=iTestResult.getInstance().toString().trim();
        ITestContext context = iTestResult.getTestContext();
		System.out.println("Error screen shot name: "+ methodName +" ***");
        takeScreenShot(methodName, driver);
        
	}
	
	public void onTestSkipped1(ITestResult iTestResult) throws NoSuchFieldException, SecurityException, Throwable, IllegalAccessException {
		Class clazz = iTestResult.getTestClass().getRealClass();
		
		field = clazz.getDeclaredField("driver");
		driver = (AppiumDriver<MobileElement>) field.get(iTestResult.getInstance());
		String methodName=iTestResult.getInstance().toString().trim();
        ITestContext context = iTestResult.getTestContext(); 
		takeScreenShot(methodName, driver);
	}
    
    public void takeScreenShot(String methodName, WebDriver driver) {
    	try {
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
    	 LOGGER.debug("***Placed screen shot in "+filePath+" ***");
	//	 System.out.println("Error screen shot name: "+ methodName +" ***");
		 FileUtils.copyFile(scrFile, new File(fileName+methodName+".png"));
		} catch (IOException e) {
				e.printStackTrace();
			}
    }
}  
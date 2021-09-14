/*
 * TO DO
 * This is not being used. It waswritten to try to have the fcatory annottaion separately
 */


package tests;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.log4testng.Logger;

import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Android;
import com.testinium.deviceinformation.model.Device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.Android_Constants;


public class Android_DriverSetUp {
			
	  //Class variables
		
		static AndroidDriver<MobileElement> driver;
		static DesiredCapabilities cap ;
		private final static Logger LOGGER = Logger.getLogger(Android_DriverSetUp.class);
		public static String asset_Name = null, suite_Name = null;
		private static Android_DriverSetUp instance = new Android_DriverSetUp();
		public static String CAP_UDID = null;
		public  static String CAP_APP = null;
		
		public static AndroidDriver<MobileElement> driverSetUp() throws Exception {	  	   
			URL url = new URL(Android_Constants.CAP_APPIUM_ANDROID_URL);
			
		/*
			DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);
			Device device = null;
			if (deviceInfo.anyDeviceConnected()) {
				Device device = deviceInfo.getFirstDevice();
				// If for parallel the comment above line and store all device udids in a list
	
				cap = new DesiredCapabilities();
			
				cap.setCapability("udid", device.getUniqueDeviceID());
				cap.setCapability("platformName", device.getDeviceProductName());
				cap.setCapability("deviceName", device.getDeviceProductName());
				cap.setCapability("platformVersion", device.getProductVersion());
				
				CAP_UDID = device.getUniqueDeviceID();
			}*/
	
			cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", Android_Constants.CAP_APP_DEVICENAME);
			cap.setCapability("udid", Android_Constants.CAP_APP_UDID);
			cap.setCapability("platformName", Android_Constants.CAP_APP_PLATFORMNAME);
			cap.setCapability("platformVersion", Android_Constants.CAP_APP_PLATFORMVERSION);
			cap.setCapability("platform", "Android");			
			CAP_UDID = Android_Constants.CAP_APP_UDID;
			
			//for parallel run
			//cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
			
			cap.setCapability("automationName", "uiautomator2");
			cap.setCapability("allowTestPackages", true);
			
			cap.setCapability("fullReset", "true"); 
			cap.setCapability("adbExecTimeout", 10000);
			 
			//for application
			cap.setCapability("appActivity", Android_Constants.CAP_APP_ACTIVITY);
			cap.setCapability("app", Android_Constants.CAP_APP);
			cap.setCapability("appPackage", Android_Constants.CAP_APP_PACKAGE);
			cap.setCapability("buildToolsVersion", "30.0");
			
			//Screenshot
			cap.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
			cap.setCapability("takesScreenshot", true);
			
			cap.setCapability("newCommandTimeout", 60000);  // driver needs time for Windows license waits
			cap.setCapability("wdaLocalPort", 8200); //8200 to 8299
			//driver 
			driver = new AndroidDriver<MobileElement>(url,cap);
			System.out.println("Application Start...");
			Thread.sleep(1000);
			//driver.manage().window().setSize(new Dimension(10, 10));
			return (AndroidDriver<MobileElement>) driver;
		}
		
		public static Android_DriverSetUp getInstance() {
	        return instance;
	    }

	    // Get the only object available
	    public void setDriver(AndroidDriver<MobileElement> driver1) {
	        driver = driver1;
	    }

	    public AndroidDriver<MobileElement> getAppiumDriver() {
	        return (AndroidDriver<MobileElement>) driver;
	    }  
		public static String getUDID() throws Exception, DeviceNotFoundException {
			//System.out.println(CAP_UDID + ": getUDID");
			return CAP_UDID;
		}
		  

		  
}

package screenshots;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdditionalOptionScreen {
	static AppiumDriver<MobileElement> driver;
	
	public AdditionalOptionScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static MobileElement accountMenu(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/accounts_panel");
	}
	
	public static MobileElement addAccountMenu(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/imageButtonAddCategory");
	}
	
	public static MobileElement addNameField(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/editTextCategoryName");
	}
	public static MobileElement addSave(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/save");
	}
	
	
	public static List<MobileElement> listAccountImagee(AppiumDriver<MobileElement> driver) { //index-1
		return driver.findElementsById("com.monefy.app.lite:id/imageView");
	}
	public static MobileElement settingsMenu(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/settings_button");
	}
	
	public static MobileElement clearData(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/clear_database_button");
	}
	public static MobileElement clearDataYes(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("android:id/button1");
	}
	public static void scrollToText(AppiumDriver<MobileElement> driver, String textValue, String className) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.monefy.app.lite:id/snackbar_action"))); 
		Thread.sleep(500);
		
		Dimension size = driver.manage().window().getSize();
	    int anchor = (int) ((size.width/2)-50 );
	    int startPoint = (int) (size.height - 150);
	    int endPoint = 50;
	    
	    System.out.println(anchor+" "+startPoint +" "+endPoint);  //490 1644 50
		 new TouchAction(driver)
         .press(PointOption.point(700, 1730))
         .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
         .moveTo(PointOption.point(700, 100))
         .release()
         .perform();
		Thread.sleep(1000);
		 
		clearData(driver).click();
		Thread.sleep(500);
		clearDataYes(driver).click();
	}

	
}

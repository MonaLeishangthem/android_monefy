package screenshots;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.List;

public class NavigationScreen {
	static AppiumDriver<MobileElement> driver;
	
	public NavigationScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static List<MobileElement> listAccountName(AppiumDriver<MobileElement> driver) { //text 
		return driver.findElementsById("com.monefy.app.lite:id/title");
	}

	
}

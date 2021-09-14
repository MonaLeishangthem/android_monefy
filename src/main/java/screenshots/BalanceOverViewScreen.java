package screenshots;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.List;

public class BalanceOverViewScreen {
	static AppiumDriver<MobileElement> driver;
	
	public BalanceOverViewScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static List<MobileElement> listCategortWholeAmount(AppiumDriver<MobileElement> driver) {
		return driver.findElementsById("com.monefy.app.lite:id/textViewWholeAmount"); //text
	}
	public static List<MobileElement> listCategoryName(AppiumDriver<MobileElement> driver) { //text
		return driver.findElementsById("com.monefy.app.lite:id/textViewCategoryName");
	}

	
}

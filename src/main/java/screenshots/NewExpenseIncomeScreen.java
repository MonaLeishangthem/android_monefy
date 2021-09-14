package screenshots;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.ArrayList;
import java.util.List;

public class NewExpenseIncomeScreen {
	static AppiumDriver<MobileElement> driver;
	
	public NewExpenseIncomeScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static MobileElement chooseCategory(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/keyboard_action_button");
	}
	
	public static List<MobileElement> listCategory(AppiumDriver<MobileElement> driver) { //text 
		return driver.findElementsById("com.monefy.app.lite:id/textCategoryName");
	}

	
}

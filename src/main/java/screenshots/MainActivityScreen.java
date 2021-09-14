package screenshots;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MainActivityScreen {
	static AppiumDriver<MobileElement> driver;
	
	public MainActivityScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static MobileElement navigationButton(AppiumDriver<MobileElement> driver) {
		return driver.findElementByAccessibilityId("Open navigation");
		}
	public static MobileElement addExpenseIcon(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/expense_button_title");
		}
	public static MobileElement addIncomeIcon(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/income_button_title");
		}
	public static MobileElement newTransfer(AppiumDriver<MobileElement> driver) {
		return driver.findElementByAccessibilityId("Transfer");
		}
	public static MobileElement additionalOptionsMenu(AppiumDriver<MobileElement> driver) {
		return driver.findElementByAccessibilityId("Settings");
		}
	public static MobileElement totalIncome(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/income_amount_text"); //text
		}
	public static MobileElement totalExpense(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/expense_amount_text");
	}
	public static MobileElement balanceOverView(AppiumDriver<MobileElement> driver) {
		return driver.findElementById("com.monefy.app.lite:id/leftLinesImageView");
	}
	
	
}

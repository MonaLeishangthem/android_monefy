package module;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import screenshots.AdditionalOptionScreen;
import screenshots.MainActivityScreen;


public class AdditionalOptionsMenu {
	private final static Logger LOGGER = Logger.getLogger(AdditionalOptionsMenu.class);
	static AppiumDriver<MobileElement> driver;

	public static boolean sdkerror = false;
	
	public AdditionalOptionsMenu(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static void createAccount(AppiumDriver<MobileElement> driver, String name) throws Exception {
		MainActivityScreen.additionalOptionsMenu(driver).click();
		AdditionalOptionScreen.accountMenu(driver).click();
		AdditionalOptionScreen.addAccountMenu(driver).click();
		List<MobileElement> elements = AdditionalOptionScreen.listAccountImagee(driver);
		elements.get(0).click();
		AdditionalOptionScreen.addNameField(driver).sendKeys(name);
		AdditionalOptionScreen.addSave(driver).click();
		Thread.sleep(400);
	}

	
}

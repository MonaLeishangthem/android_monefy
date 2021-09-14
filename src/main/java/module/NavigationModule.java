package module;

import java.io.IOException;
import java.util.ArrayList;
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
import screenshots.NavigationScreen;


public class NavigationModule {
	private final static Logger LOGGER = Logger.getLogger(NavigationModule.class);
	static AppiumDriver<MobileElement> driver;

	public static boolean sdkerror = false;
	
	public NavigationModule(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static void selectAccount(AppiumDriver<MobileElement> driver, int index) throws Exception {
	//	MainActivityScreen.navigationButton(driver).click();
		NavigationScreen.listAccountName(driver).get(0).click();;
		Thread.sleep(400);
		List<MobileElement> elements = NavigationScreen.listAccountName(driver);
		elements.get(index).click(); 
		Thread.sleep(400);
	}
	
	public static void validateAccount(AppiumDriver<MobileElement> driver, String name) throws Exception {
		NavigationScreen.listAccountName(driver).get(0).click();;
		Thread.sleep(400);
		List<MobileElement> elements = NavigationScreen.listAccountName(driver);
		ArrayList<String> accountNames = new ArrayList<String>();
		for (int index = 0; index<elements.size(); index++ ) {
			String accountName = elements.get(index).getAttribute("text");
			accountNames.add(accountName);
		}
		if(accountNames.contains(name)) {
		    System.out.println(name +" found");
		}else{
		    System.out.println(name+" Not found");
		    throw new Exception(name+" Not found");
		}
		NavigationScreen.listAccountName(driver).get(0).click();;
	}
}
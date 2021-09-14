package module;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
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
import screenshots.BalanceOverViewScreen;
import screenshots.MainActivityScreen;


public class BalanceOverViewModule {
	private final static Logger LOGGER = Logger.getLogger(BalanceOverViewModule.class);
	static AppiumDriver<MobileElement> driver;

	public static boolean sdkerror = false;
	
	public BalanceOverViewModule(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static void ValidateCategory(AppiumDriver<MobileElement> driver, ArrayList<String> expectedCategory) throws Exception {
		List<MobileElement> elements = BalanceOverViewScreen.listCategoryName(driver);
		ArrayList<String> data = new ArrayList<String>();
		for(int i=0;i<elements.size();i++) {
			data.add(elements.get(i).getAttribute("text"));
		}
		System.out.println("Assert Category");
		Assert.assertEquals( expectedCategory, data);
	}
	
	public static HashMap<String, String> createKeyValue(AppiumDriver<MobileElement> driver) throws Exception {
		List<MobileElement> elements = BalanceOverViewScreen.listCategoryName(driver);
		ArrayList<String> data = new ArrayList<String>();
		for(int i=0;i<elements.size();i++) {
			data.add(elements.get(i).getAttribute("text"));
		}
		
		List<MobileElement> elementsAmount = BalanceOverViewScreen.listCategortWholeAmount(driver);
		ArrayList<String> dataAmount = new ArrayList<String>();
		for(int i=0;i<elementsAmount.size();i++) {
			dataAmount.add(elementsAmount.get(i).getAttribute("text"));
		}
		
		//create a key value
		HashMap<String, String> actualMap = new HashMap<>();
		for(int i = 0; i < data.size(); i++) {
			actualMap.put(data.get(i), dataAmount.get(i));
		}
		return actualMap;	
	}

	
	
}

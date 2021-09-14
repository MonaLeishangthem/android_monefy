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
import screenshots.NewExpenseIncomeScreen;
import utils.GetInputs;


public class MainActivityModule {
	private final static Logger LOGGER = Logger.getLogger(MainActivityModule.class);
	static AppiumDriver<MobileElement> driver;

	public static boolean sdkerror = false;
	
	public MainActivityModule(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static void addIncome(AppiumDriver<MobileElement> driver, String income, String category) throws Exception {
		Thread.sleep(500);
		MainActivityScreen.addIncomeIcon(driver).click();;
		Thread.sleep(500);
		clickDigits(driver, income);
		
		NewExpenseIncomeScreen.chooseCategory(driver).click();
		selectCategory(driver, category);
	}
	
	public static void addExpense(AppiumDriver<MobileElement> driver, String expense, String category) throws Exception {
		Thread.sleep(500);
		MainActivityScreen.addExpenseIcon(driver).click();
		Thread.sleep(500);
		clickDigits(driver, expense);
		
		NewExpenseIncomeScreen.chooseCategory(driver).click();
		selectCategory(driver, category);
		Thread.sleep(500);
	}
	
	public static void clickDigits(AppiumDriver<MobileElement> driver, String income) throws Exception {
		System.out.println("Price "+ income);
		ArrayList<String> list = GetInputs.splitData(income);
		
		for(int i = 0;i<list.size();i++) {
			String idElement = "com.monefy.app.lite:id/buttonKeyboard" + list.get(i) ;
			driver.findElementById(idElement).click();
		}
	}
	
	public static void selectCategory(AppiumDriver<MobileElement> driver, String category) throws Exception {
		List<MobileElement> elements = NewExpenseIncomeScreen.listCategory(driver);
		
		for(int i = 0;i<elements.size();i++) {
			if(elements.get(i).getAttribute("text").equalsIgnoreCase(category)) {
				//System.out.println("Click at " + elements.get(i).getAttribute("text"));
				elements.get(i).click();
				break;
			}
		}
		
	}
}
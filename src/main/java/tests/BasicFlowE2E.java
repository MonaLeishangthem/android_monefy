//************************
// This class is the suite for Basic PLayback Suite Android.
// 
//************************

package tests;

import static org.hamcrest.CoreMatchers.containsString;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import module.AdditionalOptionsMenu;
import module.BalanceOverViewModule;
import module.MainActivityModule;
import module.NavigationModule;
import screenshots.AdditionalOptionScreen;
import screenshots.MainActivityScreen;
import utils.GetDataFromExcel;
import utils.GetInputs;
import utils.ReadExcel_DataProviderFactory;
import utils.TakeScreenShot;
import utils.TakeScreenShotListener_Android;
import utils.TakeScreenShotListener;

import org.testng.log4testng.Logger;

@Listeners(TakeScreenShotListener_Android.class) 
public class BasicFlowE2E {
	
    @Factory(dataProviderClass=DataProviderClass.class,dataProvider="basicE2E")
    public static Object[] factoryMethod(String home,String car, String income, String food, String savings, String account1, String account2, String category1,String category2,String category3, String houseValue) {

    	BasicFlowE2E instance = new BasicFlowE2E(home,car,income,expense,savings,account1,account2,category1,category2,category3, houseValue);
        return new Object[] { instance };
    }
    
    public BasicFlowE2E(String home,String car, String income, String expense, String savings, String account1, String account2, String category1, String category2, String category3, String houseValue) {
		this.home = home;
		this.car = car;
		this.income = income;
		this.expense = expense;
		this.savings = savings;
		this.account1 = account1;
		this.account2 = account2;
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
		this.houseValue = houseValue;
}
	
  //Class variables
	
	AndroidDriver<MobileElement> driver;
	DesiredCapabilities cap ;
	ReadExcel_DataProviderFactory ilogs ;
	
	GetDataFromExcel data_provider = new GetDataFromExcel();
	private final static Logger LOGGER = Logger.getLogger(BasicFlowE2E.class);
	static String home, car,  income, expense,  savings,  account1,  account2,  category1, category2,category3, houseValue = null;

	//Data provider variables

	
	@BeforeClass
	public void classSetUp() throws Exception {
		Android_DriverSetUp driverInstance = Android_DriverSetUp.getInstance();
		if(driverInstance.getAppiumDriver() == null) {
			//if in future we want to reuse previous instance of driver then we can execute the else part
			driver = Android_DriverSetUp.driverSetUp();      
		}
	}
	
	@Test(priority = 1)	
	public void addAccounts() throws Exception {
		AdditionalOptionsMenu.createAccount(driver, account1);
		AdditionalOptionsMenu.createAccount(driver, account2);
		
		//driver.navigate().back();
		MainActivityScreen.additionalOptionsMenu(driver).click();
		System.out.println("addAccounts end");
	}
	@Test(priority = 2)	
	public void ValidateAccounts() throws Exception {
		System.out.println("ValidateAccounts starts");
		Thread.sleep(2000);
		MainActivityScreen.navigationButton(driver).click();
		Thread.sleep(1000);
		NavigationModule.validateAccount(driver, account1);
		NavigationModule.validateAccount(driver, account2);
		
		NavigationModule.selectAccount(driver, 2);
	}

	@Test(priority = 3)	
	public void AddIncome() throws Exception {
		Thread.sleep(2000);
		MainActivityModule.addIncome(driver, savings, category1);
	}

	@Test(priority = 4)	
	public void AddExpense() throws Exception {
		MainActivityModule.addExpense(driver, home, category2);
		MainActivityModule.addExpense(driver, car, category3);
		Thread.sleep(1000);
	}
	
	@Test(priority = 5)	
	public void ValidateTotal() throws Exception {
		Thread.sleep(2000);
		String incomeActual = MainActivityScreen.totalIncome(driver).getAttribute("text");
		Thread.sleep(2000);
		String expenseActual = MainActivityScreen.totalExpense(driver).getAttribute("text");
		System.out.println(incomeActual);
		System.out.println(expenseActual); 
		expense = "$1,050.00";
		System.out.println(expense); 
		Assert.assertEquals(incomeActual, income);
		Assert.assertEquals(expenseActual, expense);
		// TO DO assert code
	}
	
	@Test(priority = 6)	
	public void AssertCategoryList() throws Exception {
		MainActivityScreen.balanceOverView(driver).click();
		
		ArrayList<String> expectedCategory = new ArrayList<String>();
		expectedCategory.add(category1);
		expectedCategory.add(category2);
		expectedCategory.add(category3);
		BalanceOverViewModule.ValidateCategory(driver, expectedCategory);
	}

	@Test(priority = 7)	
	public void AssertCategoryAndValue() throws Exception {
		HashMap<String, String> actualMap = BalanceOverViewModule.createKeyValue(driver);
		GetInputs.assertKeyValue(actualMap, category2, houseValue);
	}
	
	@Test(priority = 8)	
	public void clearData() throws Exception {	
		MainActivityScreen.additionalOptionsMenu(driver).click();
		AdditionalOptionScreen.settingsMenu(driver).click();
		
		AdditionalOptionScreen.scrollToText(driver, "Clear data", "android.widget.Button");
	}
	
	@AfterClass
	public void afterclass()throws Exception  {
		System.out.println("ENTER After Class");
	}

	@AfterSuite
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		LOGGER.debug("Teardown Complete");
	}
	
}
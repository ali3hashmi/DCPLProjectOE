package com.dcpl.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.OrderExecutionDataProvider;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderExecutionHomePage;
import com.dcpl.pageobjects.ReceiveParcelPage;
import com.dcpl.pageobjects.ReleaseOrderPage;
import com.dcpl.utility.Log;

public class ReceiveParcelTest extends BaseClass{

	private LoginPage loginPage;
	private OrderExecutionHomePage orderExecutionHomePage;
	private ReceiveParcelPage receiveParcelPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}
	
	//For Finished Goods
	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "createReceiveParcel",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create receive parcel process")
	public void createReceiveParcelForMaterialTypeGold(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		receiveParcelPage =new ReceiveParcelPage();
		
		
		Log.startTestCase("Receive Parcel Create For Material Type Gold");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		
		receiveParcelPage=orderExecutionHomePage.ReceiveParcel(receiveParcelPage);
		receiveParcelPage.createReceiveParcelData(hashMapValue.get("vendor"),
				hashMapValue.get("deliverymode"),
				hashMapValue.get("materialtype"),
				hashMapValue.get("insuredamount"),
				hashMapValue.get("noofboxes"),
				hashMapValue.get("courieragencyname"),
				hashMapValue.get("courierreceiptnumber"),
				hashMapValue.get("couriercharges"),
				hashMapValue.get("borneby"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("sentby"));
		
		String growlMsg=receiveParcelPage.clickOnSaveBtn();
		String expGrowlMsg ="Success";
		boolean flag=true;
		
		if(expGrowlMsg.equals(growlMsg)) {
			
			flag=true;
			Assert.assertEquals(flag, flag);
			//Assert.assertEquals(growlMsg, expGrowlMsg);
			Log.info("Test case passed");
		}else {
			
			Assert.assertEquals(false, flag);
			Log.info("Test case failed");
		}
		
		Log.endTestCase("Receive Parcel Create For Material Type Gold");
	}
	
	@Test(priority = 1,groups = {"Sanity","Regression"},dataProvider = "createReceiveParcel",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create receive parcel process")
	public void createReceiveParcelForMaterialTypePlatinum(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		receiveParcelPage =new ReceiveParcelPage();
		
		
		Log.startTestCase("Receive Parcel Create For Material Type Platinum");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		
		receiveParcelPage=orderExecutionHomePage.ReceiveParcel(receiveParcelPage);
		receiveParcelPage.createReceiveParcelData(hashMapValue.getOrDefault(hashMapValue, "KMS"),
				hashMapValue.get("deliverymode"),
				hashMapValue.getOrDefault(hashMapValue, "P"),
				hashMapValue.get("insuredamount"),
				hashMapValue.get("noofboxes"),
				hashMapValue.get("courieragencyname"),
				hashMapValue.get("courierreceiptnumber"),
				hashMapValue.get("couriercharges"),
				hashMapValue.get("borneby"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("sentby"));
		
		String growlMsg=receiveParcelPage.clickOnSaveBtn();
		String expGrowlMsg ="Success";
		boolean flag=true;
		
		if(expGrowlMsg.equals(growlMsg)) {
			
			flag=true;
			Assert.assertEquals(flag, flag);
			//Assert.assertEquals(growlMsg, expGrowlMsg);
			Log.info("Test case passed");
		}else {
			
			Assert.assertEquals(false, flag);
			Log.info("Test case failed");
		}
		
		Log.endTestCase("Receive Parcel Create For Material Type Platinum");
	}
	@Test(priority = 2,groups = {"Sanity","Regression"},dataProvider = "createReceiveParcel",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create receive parcel process")
	public void createReceiveParcelForMaterialTypeSilver(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		receiveParcelPage =new ReceiveParcelPage();
		
		
		Log.startTestCase("Receive Parcel Create For Material Type Silver");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		
		receiveParcelPage=orderExecutionHomePage.ReceiveParcel(receiveParcelPage);
		receiveParcelPage.createReceiveParcelData(hashMapValue.getOrDefault(hashMapValue, "MGD"),
				hashMapValue.get("deliverymode"),
				hashMapValue.getOrDefault(hashMapValue, "S"),
				hashMapValue.get("insuredamount"),
				hashMapValue.get("noofboxes"),
				hashMapValue.get("courieragencyname"),
				hashMapValue.get("courierreceiptnumber"),
				hashMapValue.get("couriercharges"),
				hashMapValue.get("borneby"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("sentby"));
		
		String growlMsg=receiveParcelPage.clickOnSaveBtn();
		String expGrowlMsg ="Success";
		boolean flag=true;
		
		if(expGrowlMsg.equals(growlMsg)) {
			
			flag=true;
			Assert.assertEquals(flag, flag);
			//Assert.assertEquals(growlMsg, expGrowlMsg);
			Log.info("Test case passed");
		}else {
			
			Assert.assertEquals(false, flag);
			Log.info("Test case failed");
		}
		
		Log.endTestCase("Receive Parcel Create For Material Type Silver");
	}
	@Test(priority = 3,groups = {"Sanity","Regression"},dataProvider = "createReceiveParcel",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create receive parcel process")
	public void createReceiveParcelForMaterialTypeDiamond(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		receiveParcelPage =new ReceiveParcelPage();
		
		
		Log.startTestCase("Receive Parcel Create For Material Type Diamond");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		
		receiveParcelPage=orderExecutionHomePage.ReceiveParcel(receiveParcelPage);
		receiveParcelPage.createReceiveParcelData(hashMapValue.getOrDefault(hashMapValue, "DIC"),
				hashMapValue.get("deliverymode"),
				hashMapValue.getOrDefault(hashMapValue, "D"),
				hashMapValue.get("insuredamount"),
				hashMapValue.get("noofboxes"),
				hashMapValue.get("courieragencyname"),
				hashMapValue.get("courierreceiptnumber"),
				hashMapValue.get("couriercharges"),
				hashMapValue.get("borneby"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("sentby"));
		
		String growlMsg=receiveParcelPage.clickOnSaveBtn();
		String expGrowlMsg ="Success";
		boolean flag=true;
		
		if(expGrowlMsg.equals(growlMsg)) {
			
			flag=true;
			Assert.assertEquals(flag, flag);
			//Assert.assertEquals(growlMsg, expGrowlMsg);
			Log.info("Test case passed");
		}else {
			
			Assert.assertEquals(false, flag);
			Log.info("Test case failed");
		}
		
		Log.endTestCase("Receive Parcel Create For Material Type Diamond");
	}
	
	//For Loose stone
	@Test(priority = 4,groups = {"Sanity","Regression"},dataProvider = "createReceiveParcel",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create receive parcel process")
	public void createReceiveParcelForMaterialTypeLooseStones(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		receiveParcelPage =new ReceiveParcelPage();
		
		
		Log.startTestCase("Receive Parcel Create For Material Type LS");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		
		receiveParcelPage=orderExecutionHomePage.ReceiveParcel(receiveParcelPage);
		receiveParcelPage.createReceiveParcelData(hashMapValue.getOrDefault(hashMapValue, "MUK - MUKHI SONS"),
				hashMapValue.get("deliverymode"),
				hashMapValue.getOrDefault(hashMapValue, "LS"),
				hashMapValue.get("insuredamount"),
				hashMapValue.get("noofboxes"),
				hashMapValue.get("courieragencyname"),
				hashMapValue.get("courierreceiptnumber"),
				hashMapValue.get("couriercharges"),
				hashMapValue.get("borneby"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("sentby"));
		
		String growlMsg=receiveParcelPage.clickOnSaveBtn();
		String expGrowlMsg ="Success";
		boolean flag=true;
		
		if(expGrowlMsg.equals(growlMsg)) {
			
			flag=true;
			Assert.assertEquals(flag, flag);
			//Assert.assertEquals(growlMsg, expGrowlMsg);
			Log.info("Test case passed");
		}else {
			
			Assert.assertEquals(false, flag);
			Log.info("Test case failed");
		}
		
		Log.endTestCase("Receive Parcel Create For Material Type LS");
	}
	//For Accessory
	@Test(priority = 5,groups = {"Sanity","Regression"},dataProvider = "createReceiveParcel",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create receive parcel process")
	public void createReceiveParcelForMaterialTypeAccessory(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		receiveParcelPage =new ReceiveParcelPage();
		
		
		Log.startTestCase("Receive Parcel Create For Material Type Accessory");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		
		receiveParcelPage=orderExecutionHomePage.ReceiveParcel(receiveParcelPage);
		receiveParcelPage.createReceiveParcelData(hashMapValue.getOrDefault(hashMapValue, "MOM - MOMENTS"),
				hashMapValue.get("deliverymode"),
				hashMapValue.getOrDefault(hashMapValue, "A"),
				hashMapValue.get("insuredamount"),
				hashMapValue.get("noofboxes"),
				hashMapValue.get("courieragencyname"),
				hashMapValue.get("courierreceiptnumber"),
				hashMapValue.get("couriercharges"),
				hashMapValue.get("borneby"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("sentby"));
		
		String growlMsg=receiveParcelPage.clickOnSaveBtn();
		String expGrowlMsg ="Success";
		boolean flag=true;
		
		if(expGrowlMsg.equals(growlMsg)) {
			
			flag=true;
			Assert.assertEquals(flag, flag);
			//Assert.assertEquals(growlMsg, expGrowlMsg);
			Log.info("Test case passed");
		}else {
			
			Assert.assertEquals(false, flag);
			Log.info("Test case failed");
		}
		
		Log.endTestCase("Receive Parcel Create For Material Type Accessory");
	}
	//For Others
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}
}

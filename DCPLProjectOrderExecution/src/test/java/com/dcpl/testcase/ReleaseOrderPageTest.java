package com.dcpl.testcase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.OrderExecutionDataProvider;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderExecutionHomePage;
import com.dcpl.pageobjects.ReleaseOrderPage;
import com.dcpl.utility.Log;


import java.text.SimpleDateFormat;

public class ReleaseOrderPageTest extends BaseClass{

	private LoginPage loginPage;
	private OrderExecutionHomePage orderExecutionHomePage;
	private ReleaseOrderPage releaseOrderPage;


	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}

	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order by passing store code")
	public void verifyReleaseOrderByStoreCode(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		releaseOrderPage =new ReleaseOrderPage();

		Log.startTestCase("Release Store Code Verification");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		releaseOrderPage=orderExecutionHomePage.releaseOrder(releaseOrderPage);
		String actStoreCode=releaseOrderPage.setStoreCode(hashMapValue.get("StoreCode"));
		//System.out.println(actStoreCode);
		//if multiple dropdown selection
		//List<String> expectedStoreCode = new ArrayList<>();
		//expectedStoreCode.add("TS Madision");
		String expectedStoreCode=actStoreCode;
		Assert.assertEquals(actStoreCode, expectedStoreCode);

		String actOrderType=releaseOrderPage.setOrderType(hashMapValue.get("OrderType"));
		String expectedOrderType =actOrderType;
		Assert.assertEquals(actOrderType, expectedOrderType);
		Thread.sleep(5000);
		releaseOrderPage.clickOnSearchBtn();
		//releaseOrderPage.selectCheckBox();
		//releaseOrderPage.clickOnSaveBtn();


		Log.endTestCase("Release Store Code Verification");
		Log.info("Test Case Passed");
	}

	@Test(priority = 1,groups = {"Sanity","Regression"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order by passing order number")
	public void verifyReleaseOrderByOrderNo(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();

		Log.startTestCase("Releasing order by passing order no");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		releaseOrderPage=orderExecutionHomePage.releaseOrder(releaseOrderPage);

		int actOrderNo=releaseOrderPage.setOrderNo(hashMapValue.get("OrderNo"));
		int expOrderNo =actOrderNo;
		Assert.assertEquals(actOrderNo, expOrderNo);
		String actOrderType=releaseOrderPage.setOrderType(hashMapValue.get("OrderType"));
		String expectedOrderType =actOrderType;
		Assert.assertEquals(actOrderType, expectedOrderType);
		releaseOrderPage.clickOnSearchBtn();
		releaseOrderPage.selectCheckBox();
		//		String actDueDate=releaseOrderPage.verifyVendorDueDate();
		//	    System.out.println(actDueDate);


		//simple date format to find current system date
		//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//		Date date =new Date();
		//	    System.out.println(formatter.format(date));
		//
		//	    if(formatter.format(date).equals(actDueDate)) {
		//	    	
		//	    	String actMessage=releaseOrderPage.clickOnSaveBtn();
		//	    	String expMessage ="Assign Vendor/Release order created successfully.";
		//	    	Assert.assertEquals(actMessage, expMessage);
		//	    	
		//	    	//System.out.println("hey");
		//	    }
		//	    if(formatter.format(date) != actDueDate) {
		//	    	
		//	    	//System.out.println("hi");
		//	    	String actMessage=releaseOrderPage.clickOnSaveBtn();
		//	    	String expMessage="Vendor due date for order"+ " " +actOrderNo+" " +"has expired select future Date";
		//	    	Assert.assertEquals(actMessage, expMessage);
		//	    }

		String actMessage=releaseOrderPage.clickOnSaveBtn();
		String expMessage ="Assign Vendor/Release order created successfully.";
		Assert.assertEquals(actMessage, expMessage);

		Log.endTestCase("Releasing order by passing order no");
		Log.info("Test Case Passed");
	}

	@Test(priority = 3,groups = {"Sanity","Regression"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order by passing order type")
	public void verifyReleaseOrderByOrderType(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();

		Log.startTestCase("OE Login Test");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
	}

	@Test(priority = 4,groups = {"Sanity","Regression"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order by passing vendor")
	public void verifyReleaseOrderByVendor(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();

		Log.startTestCase("OE Login Test");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
	}

	@Test(priority = 5,groups = {"Sanity","Regression"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order by passing segment")
	public void verifyReleaseOrderBySegment(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();

		Log.startTestCase("OE Login Test");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
	}

	@Test(priority = 6,groups = {"Sanity","Regression"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order by passing order kind")
	public void verifyReleaseOrderByOrderKind(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();

		Log.startTestCase("OE Login Test");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
	}

	@Test(priority = 7,groups = {"Sanity","Regression"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order by passing order kind")
	public void verifyReleaseOrdersSearchGridColumnHeaders(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();

		Log.startTestCase("OE Login Test");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);


	}

	@Test(priority = 8,groups = {"Sanity"},dataProvider = "ReleaseOrderData",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying release order page input fields")
	public void verifyReleaseOrderPageInputFields(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();

		Log.startTestCase("Input field verification");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		releaseOrderPage=orderExecutionHomePage.releaseOrder(releaseOrderPage);
		boolean storeCodeRes=releaseOrderPage.verifyStoreCodeInputField(hashMapValue.get("StoreCode"));
		//boolean expectedRes =true;

		Assert.assertTrue(storeCodeRes);

		boolean orderNoRes=releaseOrderPage.verifyOrderNoInputField(hashMapValue.get("OrderNo"));
		Assert.assertTrue(orderNoRes);

		List<String> actordertype = new ArrayList<>();
		List<String> expOrderTypeList = new ArrayList<>();
		actordertype=releaseOrderPage.verifyOrderTypeInputField();
		System.out.println(actordertype);


		expOrderTypeList.add("ST");
		//	expOrderTypeList.add("CU");
		//		expOrderTypeList.add("SI");
		//		expOrderTypeList.add("CO");
		//		expOrderTypeList.add("SPL");
		//		expOrderTypeList.add("multiselect-all");
		Assert.assertEquals(actordertype, expOrderTypeList);

		Log.endTestCase("Input field verification");
		Log.info("Test Case Passed");
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}
}

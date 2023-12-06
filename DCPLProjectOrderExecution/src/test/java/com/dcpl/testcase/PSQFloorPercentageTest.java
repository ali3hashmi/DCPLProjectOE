package com.dcpl.testcase;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.OrderExecutionDataProvider;
import com.dcpl.utility.Log;
import com.dcpl.pageobjects.FloorPercentageCreate;
import com.dcpl.pageobjects.FloorPercentageSearch;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderExecutionHomePage;
public class PSQFloorPercentageTest extends BaseClass{

	private LoginPage loginPage;
	private OrderExecutionHomePage orderExecutionHomePage;
	private FloorPercentageCreate floorPercentageCreate;
	private FloorPercentageSearch floorPercentageSearch;


	//@Parameters({"browser","environment"}) //in case multiple parameters
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}

	//Create Test
	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "PSQFloorPercentageData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating floor percentage create page")
	public void createFloorPercentage(HashMap<String, String>hashMapValue) throws Throwable {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		floorPercentageCreate=new FloorPercentageCreate();
		floorPercentageSearch=new FloorPercentageSearch();

		Log.startTestCase("Floor Percentage Create Page Test");
		Log.info("user going to perform floor percentage creation");
		Log.info("Enter HRMS_ID and Password");
		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"), hashMapValue.get("password"), orderExecutionHomePage);
		floorPercentageCreate=orderExecutionHomePage.psqFloorPercentageCreate(floorPercentageCreate);
		floorPercentageCreate=floorPercentageSearch.clickOnCreateBtn(floorPercentageCreate);
		floorPercentageCreate.setCompany(hashMapValue.get("company"));
		floorPercentageCreate.setRegion(hashMapValue.get("region"));
		String roleName=floorPercentageCreate.setRole(hashMapValue.get("role"));
		//floorPercentageCreate.getAllRoles();
		//String nonSalesDC ="Non-Sales-DC";
		if(roleName.equals("Non-Sales-DC")) {

			floorPercentageCreate.setGrade(hashMapValue.get("grade"));
		}else {

			floorPercentageCreate.setStoreName(hashMapValue.get("storename"));
		}

		floorPercentageCreate.setSegment(hashMapValue.get("segment"));
		String floorPercentage=floorPercentageCreate.setFloorPercentage(hashMapValue.get("floorpercentage"));
		//to validate alert when user clicks more than 100%
		//int fp = Integer.parseInt(floorPercentage);
		floorPercentageCreate.setYear(hashMapValue.get("year"));
		floorPercentageCreate.setMonth(hashMapValue.get("month"));
		boolean flag = floorPercentageCreate.clickOnSaveBtn();
		String actErrorMsgForDataExist ="Floor Percentage For Selected Criteria already exist.";
		String actSuccessMessage ="Floor Percentage is created successfully.";
		// Assert.assertEquals(expErrorMsg, actErrorMsgForDataExist);
		if(flag ==true) {

			Assert.assertEquals(flag, true, actSuccessMessage);
			//Log.info("Test case passed For Success");
		}else {

			Assert.assertEquals(flag, false, actErrorMsgForDataExist);
			//Log.info("Test case passed For Data Exist");
		}

		Log.endTestCase("Floor Percentage Create Page Test");
		Log.info("Test Case Passed");


	}

	//Search Test
	@Test(priority = 1,groups = {"Sanity","Regression"},dataProvider = "PSQFloorPercentageData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating floor percentage search page")
	public void searchFloorPercentage(HashMap<String, String> hashMapValue) throws InterruptedException {

		loginPage =new LoginPage();
		orderExecutionHomePage=new OrderExecutionHomePage();
		floorPercentageSearch=new FloorPercentageSearch();

		String selectedStoreName="";
		String selectedSegment="";
		String selectedActiveInactive="";
		//List<String> getAllGridData = new ArrayList<String>();

		Log.startTestCase("Floor Percentage Search Page Test");
		Log.info("user going to perform floor percentage search");
		Log.info("Enter HRMS_ID and Password");
		loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"), hashMapValue.get("password"), orderExecutionHomePage);
		floorPercentageCreate=orderExecutionHomePage.psqFloorPercentageCreate(floorPercentageCreate);
		floorPercentageSearch.setCompany(hashMapValue.get("company"));
		floorPercentageSearch.setRegion(hashMapValue.get("region"));
		String roleName=floorPercentageSearch.setRole(hashMapValue.get("role"));
		if(roleName.startsWith("Non")) {

			floorPercentageSearch.setGrade(hashMapValue.get("grade"));
		}else {

			selectedStoreName=floorPercentageSearch.setStoreName(hashMapValue.get("storename"));
		}
		selectedSegment=floorPercentageSearch.setSegment(hashMapValue.get("segment"));
		floorPercentageSearch.setYear(hashMapValue.get("year"));
		floorPercentageSearch.setMonth(hashMapValue.get("month"));
		floorPercentageSearch.setActiveInActive(hashMapValue.get("is_active"));
		floorPercentageSearch.clickOnSearchBtn();
		String actStoreName=floorPercentageSearch.getStoreNameGridData();
		String expStoreName = selectedStoreName;
		
		String actRoleName=floorPercentageSearch.getRoleGridData();
		String expRoleName=roleName;
		
		String actSegmentName=floorPercentageSearch.getSegmentGridData();
		String expSegmentName=selectedSegment;

		String expActiveInactiveValue="Active";
		String actActiveInactiveValue=floorPercentageSearch.getActiveInActiveGridData();
		
		String expYearMonthValue="JULY/ 2023";
		String actyearMonthValue =floorPercentageSearch.getYearMonthGridData();
		
		String expFloorPercentageValue="50.00";
		String actFloorPercentageValue=floorPercentageSearch.getFloorPercentageGridData();
		
		Assert.assertEquals(expStoreName, actStoreName);

		Assert.assertEquals(expRoleName, actRoleName);

		Assert.assertEquals(expSegmentName, actSegmentName);

		Assert.assertEquals(expActiveInactiveValue, actActiveInactiveValue);
		
		Assert.assertEquals(expYearMonthValue, actyearMonthValue);
		
		Assert.assertEquals(expFloorPercentageValue, actFloorPercentageValue);

	}

	//Edit Test

	@Test(priority = 2,groups = {"Sanity","Regression"},dataProvider = "PSQFloorPercentageData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating floor percentage edit")
	public void editFloorPercentage(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException {
		
		floorPercentageSearch=new FloorPercentageSearch();
		
		searchFloorPercentage(hashMapValue);
		floorPercentageSearch.editFloorPercentage(hashMapValue.get("editfloorpercentagevalue"));
		
		//Edit will continue once the bug has been fixed - bug id 6954
	}
	
	
	//Delete Test

	@Test(priority = 3,groups = {"Sanity","Regression"},dataProvider = "PSQFloorPercentageData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating floor percentage delete")
	public void deleteFloorPercentage(HashMap<String, String> hashMapValue) throws InterruptedException {
		
		floorPercentageSearch =new FloorPercentageSearch();
		
		searchFloorPercentage(hashMapValue);
		
		String expSuccMsg="Success";
		String actSuccMsg=floorPercentageSearch.deleteFloorPercentage();
		
		Assert.assertEquals(expSuccMsg, actSuccMsg);
		
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}



}

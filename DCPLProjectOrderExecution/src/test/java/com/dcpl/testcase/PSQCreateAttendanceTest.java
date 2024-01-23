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
import com.dcpl.pageobjects.PSQCreateAttendance;
import com.dcpl.pageobjects.PSQSearchAttendance;
import com.dcpl.utility.Log;



public class PSQCreateAttendanceTest extends BaseClass{


	private LoginPage loginPage;
	private OrderExecutionHomePage orderExecutionHomePage;
	private PSQCreateAttendance psqCreateAttendance;
	private PSQSearchAttendance psqSearchAttendance;
	
	
	//@Parameters({"browser","environment"}) //in case multiple parameters
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}
	
	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "PSQCreateAttendanceData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating psq create attendance")
	public void createPSQAttendance(HashMap<String, String> hashMapValue) throws InterruptedException {
		
		loginPage=new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		psqCreateAttendance=new PSQCreateAttendance();
		psqSearchAttendance=new PSQSearchAttendance();
		
		Log.startTestCase("PSQ Attendance Create Page Test");
		Log.info("user going to perform psq target creation");
		Log.info("Enter HRMS_ID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"), hashMapValue.get("password"), orderExecutionHomePage);
		psqSearchAttendance=orderExecutionHomePage.psqCreateAttendance(psqSearchAttendance);
		psqCreateAttendance=psqSearchAttendance.clickOnCreateAttendanceBtn(psqCreateAttendance);
		psqCreateAttendance.setInputFieldCompany(hashMapValue.get("company"));
		psqCreateAttendance.setInputFieldRegion(hashMapValue.get("region"));
		psqCreateAttendance.setInputFieldDC(hashMapValue.get("dcname"));
		psqCreateAttendance.setInputFieldStore(hashMapValue.get("storename"));
		psqCreateAttendance.setInputFieldRole(hashMapValue.get("role"));
		psqCreateAttendance.setInputFieldYears(hashMapValue.get("years"));
		psqCreateAttendance.setInputFieldMonth(hashMapValue.get("month"));
		psqCreateAttendance.setInputFieldName(hashMapValue.get("name"));
		psqCreateAttendance.setInputFieldDaysPresent(hashMapValue.get("noofdayspresent"));
		String expSuccessMsg="Records Created/Uploaded Successfully";
		String actSuccessMsg=psqCreateAttendance.clickOnSaveBtn();
		System.out.println(actSuccessMsg);
		
		Assert.assertEquals(expSuccessMsg, actSuccessMsg);
		Log.endTestCase("PSQ Attendance Create Page Test");
		Log.info("Test Case Passed");
		
		
	}
	
	@Test(priority = 1,groups = {"Sanity","Regression"},dataProvider = "PSQCreateAttendanceData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating psq download attendance template")
	public void downloadPSQAttendanceTemplate(HashMap<String, String> hashMapValue) throws InterruptedException {
	
		loginPage=new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		psqCreateAttendance=new PSQCreateAttendance();
		psqSearchAttendance=new PSQSearchAttendance();
		
		Log.startTestCase("PSQ Attendance Create Page Test For Downloading Template");
		Log.info("user going to perform psq target creation");
		Log.info("Enter HRMS_ID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"), hashMapValue.get("password"), orderExecutionHomePage);
		psqSearchAttendance=orderExecutionHomePage.psqCreateAttendance(psqSearchAttendance);
		psqCreateAttendance=psqSearchAttendance.clickOnCreateAttendanceBtn(psqCreateAttendance);
		psqCreateAttendance.clickOnDownloadTemplate();

		
		Log.endTestCase("PSQ Attendance Create Page Test For Downloading Template");
		Log.info("Test Case Passed");
	}

	@Test(priority = 2,groups = {"Sanity","Regression"},dataProvider = "PSQCreateAttendanceData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating psq download attendance template")
	public void uploadPSQAttendance(HashMap<String, String> hashMapValue) throws InterruptedException {
		
		loginPage=new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		psqCreateAttendance=new PSQCreateAttendance();
		psqSearchAttendance=new PSQSearchAttendance();
		
		Log.startTestCase("PSQ Attendance Create Page Test For Uploading PSQ Attendance");
		Log.info("user going to perform psq target creation");
		Log.info("Enter HRMS_ID and Password");
		
		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"), hashMapValue.get("password"), orderExecutionHomePage);
		psqSearchAttendance=orderExecutionHomePage.psqCreateAttendance(psqSearchAttendance);
		psqCreateAttendance=psqSearchAttendance.clickOnCreateAttendanceBtn(psqCreateAttendance);
		

		
		Log.endTestCase("PSQ Attendance Create Page Test For Uploading PSQ Attendance");
		Log.info("Test Case Passed");
		

		
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}
}

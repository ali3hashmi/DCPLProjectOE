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
import com.dcpl.utility.Log;

public class OELoginPageTest extends BaseClass{

	private LoginPage loginPage;
	private OrderExecutionHomePage orderExecutionHomePage;

	//@Parameters({"browser","environment"}) //in case multiple parameters
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}
	
	@Test(priority = 0,groups = {"Smoke","Sanity"},dataProvider = "OELoginCredentials",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Performing user login for order execution portal")
		public void OELoginTest(HashMap<String,String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		
		Log.startTestCase("OE Login Test");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");
		
		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);
		
		String actualOEHomePageText = orderExecutionHomePage.getOEHomeText();
		//System.out.println(actualSalesHomePageText);
		String expectedOEHomePageText ="Home - Order Execution";
		Assert.assertEquals(actualOEHomePageText, expectedOEHomePageText);
		Log.info("OE Login Success");
		Log.endTestCase("OE Login Test");
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}

}

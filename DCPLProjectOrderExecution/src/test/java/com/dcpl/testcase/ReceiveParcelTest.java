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
	
	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "createReceiveParcel",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create receive parcel process")
	public void createReceiveParcel(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		receiveParcelPage =new ReceiveParcelPage();
		
		
		Log.startTestCase("Receive Parcel Create");
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
		
		Log.endTestCase("Receive Parcel Create");
	}
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}
}

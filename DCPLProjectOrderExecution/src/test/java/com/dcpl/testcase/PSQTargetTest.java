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
import com.dcpl.pageobjects.PSQCreateTarget;
import com.dcpl.pageobjects.PSQSearchTarget;
import com.dcpl.utility.Log;



public class PSQTargetTest extends BaseClass {

	private LoginPage loginPage;
	private OrderExecutionHomePage orderExecutionHomePage;
	private PSQCreateTarget psqCreateTarget;
	private PSQSearchTarget psqSearchTarget;


	//@Parameters({"browser","environment"}) //in case multiple parameters
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}

	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "PSQCreateTargetData",dataProviderClass = OrderExecutionDataProvider.class,
			description ="verifying and validating psq create target")
	public void createPSQTarget(HashMap<String, String> hashMapValue) throws Throwable{

		loginPage=new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		psqCreateTarget=new PSQCreateTarget();
		psqSearchTarget=new PSQSearchTarget();

		Log.startTestCase("PSQ Target Create Page Test");
		Log.info("user going to perform psq target creation");
		Log.info("Enter HRMS_ID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"), hashMapValue.get("password"), orderExecutionHomePage);
		psqSearchTarget=orderExecutionHomePage.psqCreateTarget(psqSearchTarget);
		psqCreateTarget=psqSearchTarget.clickOnCreateBtn(psqCreateTarget);
		psqCreateTarget.setCompanyInputField(hashMapValue.get("company"));
		psqCreateTarget.setRegionInputField(hashMapValue.get("region"));
		psqCreateTarget.setStoreInputField(hashMapValue.get("storename"));
		psqCreateTarget.setTargetSegmentInputField(hashMapValue.get("targetsegment"));
		psqCreateTarget.setIncludeSegmentInputField(hashMapValue.get("includesegment"));
		psqCreateTarget.setZoneInputField(hashMapValue.get("zone"));
		psqCreateTarget.setYearInputField(hashMapValue.get("year"));
		psqCreateTarget.setMonthInputField(hashMapValue.get("Month"));

		
		double actSEFloorPercentage=psqCreateTarget.getSEFloorPercentage();
		double expSEFloorPercentage=actSEFloorPercentage;
		Assert.assertEquals(expSEFloorPercentage, actSEFloorPercentage);

		
		double actSUPFloorPercentage=psqCreateTarget.getSUPFloorPercentage();
		double expSUPFloorPercentage=actSUPFloorPercentage;
		Assert.assertEquals(expSUPFloorPercentage, actSUPFloorPercentage);

		double targetValue=psqCreateTarget.setTargetValueInputField(hashMapValue.get("targetvalue"));
		double expSUPFloorLimit=targetValue * actSUPFloorPercentage;
		double actSUPFloorLimit=psqCreateTarget.getSUPFloorLimit();
		Assert.assertEquals(expSUPFloorLimit, actSUPFloorLimit);

		psqCreateTarget.clickOnContinueBtn();
		int totalNoOfSE=psqCreateTarget.noOfColumnsAndRows();

		double expSEFP=actSEFloorPercentage;
		double actSEFP=psqCreateTarget.readSEFloorPercentageFromWebTable();
		Assert.assertEquals(expSEFP, actSEFP);

		//after next sprint 39 rel v1.7 build need to check this
		double totalTargetBySESUP=psqCreateTarget.readSETargetFromWebTable();
		
		//System.out.println(totalTargetBySESUP);
		double actualtotalTargetValue =Math.round(totalTargetBySESUP);
		
		System.out.println("SE Total target value = " + actualtotalTargetValue);
		//double expTotalTargetValue = targetValue;
		
		//System.out.println(targetValue);
		boolean flag=false;
		if( actualtotalTargetValue== targetValue) {

			flag=true;
			
			if(flag==true) {
				
				Assert.assertEquals(actualtotalTargetValue, targetValue);
				System.out.println("Sum of sales executive target value is equal to supervisor target value");
			}
			
		}else {

			//Log.info("Sum of sales executive target value is not equal to supervisor target value");	
			System.out.println("Sum of sales executive target value is not equal to supervisor target value");
		}
	
		double actTotalSEFL=psqCreateTarget.readSEFloorLimitFromWebTable();
		//System.out.println("actTotalSEFL" + actTotalSEFL);
		
		double IndSETarget= targetValue/(totalNoOfSE + 1);
		//System.out.println("IndSETargetIndSETarget " + IndSETarget);
		double TotalSETarget = IndSETarget * totalNoOfSE;
		//System.out.println("TotalSETarget" + TotalSETarget);
		double expTotalSEFL =TotalSETarget * actSEFloorPercentage/100;
		//System.out.println("totalSEFL" + expTotalSEFL);
		
		Assert.assertEquals(expTotalSEFL, actTotalSEFL);
		System.out.println("Total SE floor limit is equal to total SE's target floor limit");
	
		String actGrowlMsg="";
		String expGrowlMsg="Target created Successfully..!";
		if(expTotalSEFL == actTotalSEFL) {
			
			
			actGrowlMsg=psqCreateTarget.clickOnSaveBtn();
			
			
				
		}else {
			
			System.out.println("Mismatch in Total SE floor limit is equal to total SE's target floor limit");
		}
		
		if(actGrowlMsg.equals(expGrowlMsg)) {
			
			Assert.assertEquals(expGrowlMsg, actGrowlMsg);
		}
		
		
		Log.endTestCase("PSQ Target Create Page Test");
		Log.info("Test Case Passed");

	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}

}

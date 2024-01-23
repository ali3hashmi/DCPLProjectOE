package com.dcpl.testcase;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.OrderExecutionDataProvider;
import com.dcpl.pageobjects.GoodsReceiptVoucherPage;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderExecutionHomePage;
import com.dcpl.utility.Log;

public class GoodsReceiptVocuherTest extends BaseClass {

	public LoginPage loginPage;
	public OrderExecutionHomePage orderExecutionHomePage;
	public GoodsReceiptVoucherPage goodsReceiptVoucherPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}


	//Sub-Contractor-FG-Gold
	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForSubContractVendorRefTypeFinishedGoodSegmentGold(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment gold");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "S"));//S-SubContractor		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "BKK"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.get("parcelid"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "S"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Gold"),
				hashMapValue.get("hsnsaccode"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "92"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="Success";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for sub-contract vendor ref type FG for segment gold is scuccessful");
		Log.endTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment gold");
	}

	//Sub-Contractor-FG-Silver
	@Test(priority = 1,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForSubContractVendorRefTypeFinishedGoodSegmentSilver(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment silver");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "S"));//S-SubContractor		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "MGD"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "7040"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "S"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Silver"),
				hashMapValue.getOrDefault(hashMapValue, "71131130"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "92.5"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("met"
						+ "	alrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="Success";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for sub-contract vendor ref type FG for segment silver is scuccessful");
		Log.endTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment silver");
	}

	//Sub-Contractor-FG-Platinum
	@Test(priority = 2,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForSubContractVendorRefTypeFinishedGoodSegmentPlatinum(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment platinum");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "S"));//S-SubContractor		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "KMS"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "5466"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "S"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Platinum"),
				hashMapValue.getOrDefault(hashMapValue, "71131950"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "95"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="Success";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for sub-contract vendor ref type FG for segment platinum is scuccessful");
		Log.endTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment platinum");
	}

	//Sub-Contractor-FG-Diamond
	@Test(priority = 3,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForSubContractVendorRefTypeFinishedGoodSegmentDiamond(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();
		
				Log.startTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment diamond");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "S"));//S-SubContractor		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "DIC"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "7043"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "S"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Diamond"),
				hashMapValue.getOrDefault(hashMapValue, "71131930"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "76"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="Success";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for sub-contract vendor ref type FG for segment diamond is scuccessful");
		Log.endTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment diamond");
	}

	//Dealer-FG-Gold
	@Test(priority =4,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForDealerVendorRefTypeFinishedGoodSegmentGold(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for dealer vendor where ref type finished goods for segment gold");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "D"));//D-Dealer				
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "BKK"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "2178"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "D"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Gold"),
				hashMapValue.get("hsnsaccode"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "92"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for dealer vendor ref type FG for segment gold is successful");
		Log.endTestCase("Create GRV for dealer vendor where ref type finished goods for segment gold");
	}

	//Dealer-FG-Silver
	@Test(priority = 5,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForDealerVendorRefTypeFinishedGoodSegmentSilver(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for dealer vendor where ref type finished goods for segment silver");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "D"));//D-Dealer				
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "MGD"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "7040"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "D"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Silver"),
				hashMapValue.getOrDefault(hashMapValue, "71131130"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "92.5"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for dealer vendor ref type FG for segment silver is scuccessful");
		Log.endTestCase("Create GRV for dealer vendor where ref type finished goods for segment silver");
	}

	//Dealer-FG-Platinum
	@Test(priority = 6,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForDealerVendorRefTypeFinishedGoodSegmentPlatinum(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for dealer vendor where ref type finished goods for segment platinum");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "D"));//D-Dealer				
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "KMS"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "5462"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "D"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Platinum"),
				hashMapValue.getOrDefault(hashMapValue, "71131950"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "95"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for dealer vendor ref type FG for segment platinum is scuccessful");
		Log.endTestCase("Create GRV for dealer vendor where ref type finished goods for segment platinum");
	}

	//Dealer-FG-Diamond
	@Test(priority = 7,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForDealertVendorRefTypeFinishedGoodSegmentDiamond(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for dealer vendor where ref type finished goods for segment diamond");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "D"));//D-Dealer		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "DIC"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "7044"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "D"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Diamond"),
				hashMapValue.getOrDefault(hashMapValue, "71131930"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "76"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for dealer vendor ref type FG for segment diamond is scuccessful");
		Log.endTestCase("Create GRV for dealer vendor where ref type finished goods for segment diamond");
	}

	//Consignment-FG-Gold
	@Test(priority = 8,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForConsignmentVendorRefTypeFinishedGoodSegmentGold(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for Consignment vendor where ref type finished goods for segment gold");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "C"));//C-Consignment		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "BKK"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "2180"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "C"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Gold"),
				hashMapValue.get("hsnsaccode"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "92"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for Consignment vendor ref type FG for segment gold is scuccessful");
		Log.endTestCase("Create GRV for Consignment vendor where ref type finished goods for segment gold");
	}

	//Consignment-FG-Silver
	@Test(priority = 9,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForConsignmentVendorRefTypeFinishedGoodSegmentSilver(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for Consignment vendor where ref type finished goods for segment silver");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "C"));//C-Consignment	
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "MGD"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "7071"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "C"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Silver"),
				hashMapValue.getOrDefault(hashMapValue, "71131130"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "92.5"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for Consignment vendor ref type FG for segment silver is scuccessful");
		Log.endTestCase("Create GRV for Consignment vendor where ref type finished goods for segment silver");
	}

	//Consignment-FG-Platinum
	@Test(priority = 10,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForConsignmentVendorRefTypeFinishedGoodSegmentPlatinum(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for Consignment vendor where ref type finished goods for segment platinum");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "C"));//C-Consignment		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "KMS"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "5462"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "C"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Platinum"),
				hashMapValue.getOrDefault(hashMapValue, "71131950"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "95"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for Consignment vendor ref type FG for segment platinum is scuccessful");
		Log.endTestCase("Create GRV for sub-contract vendor where ref type finished goods for segment platinum");
	}

	//Consignment-FG-Diamond
	@Test(priority = 11,groups = {"Sanity","Regression"},dataProvider = "GoodReceiptVoucher",dataProviderClass = OrderExecutionDataProvider.class,
			description = "Verifying create grv process")
	public void createGRVForConsignmentVendorRefTypeFinishedGoodSegmentDiamond(HashMap<String, String> hashMapValue) throws InterruptedException, AWTException, FileNotFoundException {

		loginPage = new LoginPage();
		orderExecutionHomePage =new OrderExecutionHomePage();
		goodsReceiptVoucherPage =new GoodsReceiptVoucherPage();

		Log.startTestCase("Create GRV for Consignment vendor where ref type finished goods for segment diamond");
		Log.info("User going to perform order execution login test");
		Log.info("Enter HRMSID and Password");

		orderExecutionHomePage=loginPage.OrderExecutionLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), orderExecutionHomePage);

		goodsReceiptVoucherPage=orderExecutionHomePage.createGRV(goodsReceiptVoucherPage);

		goodsReceiptVoucherPage.clickOnGRV();
		goodsReceiptVoucherPage.setGRVType(hashMapValue.getOrDefault(hashMapValue, "C"));//C-Consignment		
		goodsReceiptVoucherPage.setVendorName(hashMapValue.getOrDefault(hashMapValue, "DIC"));
		goodsReceiptVoucherPage.setParcelId(hashMapValue.getOrDefault(hashMapValue, "7072"));
		goodsReceiptVoucherPage.setTaxAmount(hashMapValue.get("cgstamount"),
				hashMapValue.get("sgstamount"),
				hashMapValue.get("igstamount"),
				hashMapValue.get("cessamount"));
		goodsReceiptVoucherPage.setVendorRegUnReg(hashMapValue.get("regunreg"),
				hashMapValue.get("gstinno"),
				hashMapValue.get("sourcestate"));
		goodsReceiptVoucherPage.setInvoiceAmount(hashMapValue.get("invoiceamount"));
		goodsReceiptVoucherPage.clickOnAddRow();
		String actGRVSuccMsg=goodsReceiptVoucherPage.setGridData(
				hashMapValue.getOrDefault(hashMapValue, "C"),
				hashMapValue.get("materialtype"),
				hashMapValue.getOrDefault(hashMapValue, "Diamond"),
				hashMapValue.getOrDefault(hashMapValue, "71131930"),
				hashMapValue.get("cgstPerc"),
				hashMapValue.get("sgstPerc"),
				hashMapValue.get("igstPerc"),
				hashMapValue.get("cessPerc"),
				hashMapValue.get("partybillno"),
				hashMapValue.get("partybillMonthYear"),
				hashMapValue.get("partybillDay"),
				hashMapValue.getOrDefault(hashMapValue, "76"),
				hashMapValue.get("pcs"),
				hashMapValue.get("grosswt"),
				hashMapValue.get("netwt"),
				hashMapValue.get("wast.wt"),
				hashMapValue.get("metalrate"),
				hashMapValue.get("diamondwt"),
				hashMapValue.get("labourcharge"),
				hashMapValue.get("valueinrs"),
				hashMapValue.get("remarks"));

		String expGRVSuccMsg="";
		Assert.assertEquals(actGRVSuccMsg, expGRVSuccMsg);
		Log.info("Creation of GRV for Consignment vendor ref type FG for segment diamond is scuccessful");
		Log.endTestCase("Create GRV for Consignment vendor where ref type finished goods for segment diamond");
	}



	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}
}

package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;
import com.dcpl.utility.Log;

public class OrderExecutionHomePage extends Action{


	public OrderExecutionHomePage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h1[1]")
	private WebElement OEHomeText;

	@FindBy(xpath = "//a[normalize-space()='Release']")
	private WebElement releaseMainMenu;

	@FindBy(linkText = "Release Order")
	private WebElement releaseOrderSubMenu;

	@FindBy(xpath = "(//a[@role='button'][normalize-space()='PSQ'])[1]")
	private WebElement psqMainMenu;

	@FindBy(xpath = "(//a[@role='button'][normalize-space()='PSQ'])[2]")
	private WebElement psqSubMenu;

	@FindBy(css = "a[funcid='342']")
	private WebElement floorPercentageMenu;

	@FindBy(xpath = "//a[contains(text(),'Create Target')]")
	private WebElement createTargetMenu;

	@FindBy(partialLinkText = "Attendance For P")
	private WebElement createAttendancePSQ;

	@FindBy(xpath = "//a[normalize-space()='Parcel']")
	private WebElement parcelMainMenu;

	@FindBy(linkText = "Receive Parcel")
	private WebElement receiveParcel;

	@FindBy(xpath = "//a[normalize-space()='Voucher']")
	private WebElement voucherMainMenu;

	@FindBy(linkText = "Goods Receipt Voucher")
	private WebElement GRV;


	public String getOEHomeText() {

		String oePageHomeText = OEHomeText.getText();
		return oePageHomeText;
	}

	public ReleaseOrderPage releaseOrder(ReleaseOrderPage releaseOrderPage) {

		super.click(getDriver(), releaseMainMenu);
		super.click(getDriver(), releaseOrderSubMenu);

		return new ReleaseOrderPage();
	}

	public FloorPercentageCreate psqFloorPercentageCreate(FloorPercentageCreate floorPercentageCreate) {

		super.click(getDriver(), psqMainMenu);
		super.click(getDriver(), psqSubMenu);
		super.click(getDriver(), floorPercentageMenu);

		return new FloorPercentageCreate();

	}

	public PSQSearchTarget psqCreateTarget(PSQSearchTarget searchTargetPage) throws InterruptedException {

		super.click(getDriver(), psqMainMenu);
		super.click(getDriver(), psqSubMenu);		
		super.click(getDriver(), createTargetMenu);


		return new PSQSearchTarget();
	}

	public PSQSearchAttendance psqCreateAttendance(PSQSearchAttendance psqSearchAttendance) {

		super.click(getDriver(), psqMainMenu);
		super.click(getDriver(), psqSubMenu);	
		super.click(getDriver(), createAttendancePSQ);

		return new PSQSearchAttendance();
	}


	public ReceiveParcelPage ReceiveParcel(ReceiveParcelPage receiveParcelPage) {

		super.click(getDriver(), parcelMainMenu);
		super.click(getDriver(), receiveParcel);
		super.pageLoadTimeOut(getDriver(), 15);
		return new ReceiveParcelPage();
	}

	public GoodsReceiptVoucherPage createGRV(GoodsReceiptVoucherPage goodsReceiptVoucherPage) {
		
		super.click(getDriver(), voucherMainMenu);
		super.click(getDriver(), GRV);
		
		return new GoodsReceiptVoucherPage();


	}


}

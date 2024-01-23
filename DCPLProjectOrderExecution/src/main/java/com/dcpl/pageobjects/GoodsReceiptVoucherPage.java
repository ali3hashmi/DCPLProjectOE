package com.dcpl.pageobjects;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class GoodsReceiptVoucherPage extends Action{

	public GoodsReceiptVoucherPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	//Input field elements path 

	@FindBy(xpath = "//button[@id='indentListing']")
	private WebElement createGRVBtn;

	@FindBy(id = "mrvNo")
	private WebElement grvNo;
	
	@FindBy(id="sysDate")
	private WebElement grvDate;
	
	@FindBy(xpath = "//select[@id='mrvType']")
	private WebElement grvVendorType;

	@FindBy(xpath = "//input[@id='vendorCode']")
	private WebElement grvVendorName;

	@FindBy(xpath = "//select[@id='parcelId']")
	private WebElement grvParcelId;

	@FindBy(xpath = "//input[@id='cgstAmtC']")
	private WebElement grvCgstAmount;

	@FindBy(xpath = "//input[@id='sgstAmtC']")
	private WebElement grvSgstAmount;

	@FindBy(xpath = "//input[@id='igstAmtC']")
	private WebElement grvIgstAmount;

	@FindBy(xpath = "//input[@id='cessAmtC']")
	private WebElement grvCessAmount;

	@FindBy(xpath = "//select[@id='vendRegisteredC']")
	private WebElement 	grvVendRegisteredC;

	//dynamic elements
	@FindBy(xpath = "//select[@id='gstinNO']")
	private WebElement grvGstInNo;

	@FindBy(xpath = "//select[@id='stateC']")
	private WebElement grvSourceState;

	@FindBy(xpath = "//input[@id='invAmtC']")
	private WebElement 	grvInvoiceAmount;

	@FindBy(xpath = "//button[@id='addMRV']")
	private WebElement grvAddGRVRow;

	//Grid elements
	@FindBy(xpath = "//div[contains(text(),'Finished Goods')]")
	private WebElement grvMaterialType;

	@FindBy(xpath = "//div[@id='dropdownlistContentcomboboxeditorjqxgridstoneType']")
	private WebElement grvStoneType;

	@FindBy(xpath = "//div[@id='row0jqxgrid']/div[11]")
	private WebElement grvSacCodeColumn;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridhsnSacCode']")
	private WebElement grvSacCode;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridcgstperc']")
	private WebElement grvCgstPerc;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridsgstperc']")
	private WebElement grvSgstPerc;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridigstperc']")
	private WebElement grvIgstPerc;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridcessperc']")
	private WebElement grvCessPerc;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridpartyBillNo']")
	private WebElement grvPartyBillNo;

	@FindBy(xpath = "//div[@class='jqx-max-size jqx-position-relative']/child::div")
	private WebElement grvPartyBillDate;

	@FindBy(xpath = "//div[@id='dropdownlistWrapperdropdownlisteditorjqxgridskinPurity']")
	private WebElement grvskinPurity;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridpcs']")
	private WebElement grvPcs;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridgrossWeight']")
	private WebElement grvGrossWt;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridnetWeight']")
	private WebElement grvNetWt;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridwastageWeight']")
	private WebElement grvWastWt;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridmetalRate']")
	private WebElement grvMetalRate;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgriddiamondWeight']")
	private WebElement grvDiamondWt;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridlabourCharges']")
	private WebElement grvLabourCharges;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridvalueInRs']")
	private WebElement grvValueInRs;

	@FindBy(xpath = "//input[@id='textboxeditorjqxgridremarks']")
	private WebElement grvRemarks;
	
	@FindBy(id = "saveMRV")
	private WebElement grvSaveBtn;
	
	@FindBy(className = "growl-title")
	private WebElement grvSuccessMsg;
	
	@FindBy(className = "growl-message")
	private WebElement grvGrowlSuccessMsg;
	
	


	//set GRV input for create page
	public void clickOnGRV() {

		Assert.assertTrue(createGRVBtn.isEnabled());
		super.click(getDriver(), createGRVBtn);
	}


	public void setGRVType(String grvType) {

		//System.out.println("GRV Type = " + grvType);
		Assert.assertTrue(this.grvVendorType.isDisplayed());
		super.selectByValue(this.grvVendorType, grvType);

	}

	public void setVendorName(String vendorName) throws AWTException, InterruptedException {

		Robot robot =new Robot();

		Assert.assertTrue(this.grvVendorName.isDisplayed());
		super.click(getDriver(), this.grvVendorName);
		super.type(this.grvVendorName, vendorName);
		//		WebDriverWait wait =new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vendorCode-value']")));
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
	}

	public void setParcelId(String parcelId) throws InterruptedException {


		Assert.assertTrue(this.grvParcelId.isDisplayed());
		super.click(getDriver(), this.grvParcelId);
		super.fluentWait(getDriver(), this.grvParcelId, 20);
		//WebDriverWait wait =new WebDriverWait(getDriver(), Duration.ofDays(20));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='parcelId']")));

		Select parcel=new Select(getDriver().findElement(By.xpath("//select[@id='parcelId']")));

		List<WebElement> allParcelList=parcel.getOptions();


		for(WebElement ele: allParcelList) {


			String listParcel = ele.getText();
			//System.out.println(listParcel);
			if(listParcel.contains(parcelId)) {

				parcel.selectByValue(parcelId);
				//ele.click();
			}

		}	

	}

	public void setTaxAmount(String cgstAmount,
			String sgstAmount,
			String igstAmount,
			String cessAmount) {

		Assert.assertTrue(this.grvCgstAmount.isDisplayed());
		super.type(this.grvCgstAmount, cgstAmount);
		Assert.assertTrue(this.grvSgstAmount.isDisplayed());
		super.type(this.grvSgstAmount, sgstAmount);
		Assert.assertTrue(this.grvIgstAmount.isDisplayed());
		super.type(this.grvIgstAmount, igstAmount);
		Assert.assertTrue(this.grvCessAmount.isDisplayed());
		super.type(this.grvCessAmount, cessAmount);

	}

	public void setVendorRegUnReg(String vendRegisteredC,String gstinNo,String sourceState) throws AWTException, InterruptedException {

		Robot robot=new Robot();
		Assert.assertTrue(this.grvVendRegisteredC.isDisplayed());
		super.click(getDriver(), this.grvVendRegisteredC);
		Select vendorRegUnReg=new Select(this.grvVendRegisteredC);

		List<WebElement> options=vendorRegUnReg.getOptions();

		for(WebElement ele:options) {

			String listVendorRegUnReg=ele.getText();

			//System.out.println(listVendorReg);
			vendorRegUnReg.selectByVisibleText(vendRegisteredC);		
			robot.keyPress(KeyEvent.VK_TAB);
		}
		if(vendRegisteredC.equals("Registered")) {

			//super.fluentWait(getDriver(), this.gstinNo, 20);

			WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='gstinNO']")));
			Assert.assertTrue(this.grvGstInNo.isDisplayed());
			Thread.sleep(500);
			super.selectByValue(this.grvGstInNo, gstinNo);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_TAB);

		}else if(vendRegisteredC.equals("UnRegistered")) {


			Assert.assertTrue(this.grvSourceState.isDisplayed());
			super.click(getDriver(), this.grvSourceState);
			super.fluentWait(getDriver(), this.grvSourceState, 20);
			Select sourceOptions=new Select(getDriver().findElement(By.xpath("//select[@id='stateC']")));
			List<WebElement> sourceList=sourceOptions.getOptions();

			for(WebElement ele:sourceList) {

				String getAllSourceStates = ele.getText();

				//System.out.println(getAllSourceStates);

				if(getAllSourceStates.contains(sourceState)) {

					//Thread.sleep(500);
					super.fluentWait(getDriver(), this.grvSourceState, 20);
					ele.click();
				}
			}
		}


	}
	public void setInvoiceAmount(String invoiceAmount) {

		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(this.grvInvoiceAmount.isDisplayed());
		super.type(this.grvInvoiceAmount,invoiceAmount);
	}

	public void clickOnAddRow() {

		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(this.grvAddGRVRow));
		Assert.assertTrue(this.grvAddGRVRow.isEnabled());
		super.click(getDriver(), this.grvAddGRVRow);
	}

	//Code for GRV Grid
	public String setGridData(String grvType,String materialTypesValues,String segment,String sacCode,String cgstPerc,
			String sgstPerc,
			String igstPerc,
			String cessPerc,
			String partyBillNo,
			String partyBillMonthYear,
			String partyBillDay,
			String skinPurity,
			String Pcs,
			String grossWt,String netWt,String wastWt,String metalRate,String diamondWt,
			String labourCharge,
			String valueInRs,String remarks) throws InterruptedException, AWTException {

		HashMap<String, String> materialTypes =new HashMap<>();
		materialTypes.put("F", "Finished Goods");
		materialTypes.put("A", "Accessory");
		materialTypes.put("R", "Raw Material");
		materialTypes.put("LS","Stones");
		materialTypes.put("S", "Services");
		materialTypes.put("O", "Others");

		String succMsg="";
		Robot robot=new Robot();
		Actions action=new Actions(getDriver());
		action.doubleClick(grvMaterialType).perform();

		List<WebElement> listMaterialTypes =getDriver().findElements(By.xpath("//div[@class='jqx-listitem-element']/child::span"));
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(listMaterialTypes));
		for(WebElement eleMT:listMaterialTypes) {

			String getMaterialTypes =eleMT.getText();
			//System.out.println(getMaterialTypes);

			if(getMaterialTypes.equals(materialTypes.get(materialTypesValues))){

				eleMT.click();
				robot.keyPress(KeyEvent.VK_TAB);

				//F=Finished Goods, S=Sub-Contract
				if(materialTypesValues.equalsIgnoreCase("F") && grvType.equalsIgnoreCase("S")) {

					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_ENTER);	
					getDriver().findElement(By.xpath("//div[@id='dropdownlistArrowcomboboxeditorjqxgridsegment']")).click();
					List<WebElement> listSegments =getDriver().findElements(By.xpath("//div[@class='jqx-listitem-element']/child::span"));
					for(WebElement eleSeg:listSegments) {

						String getSegments =eleSeg.getText();

						System.out.println("segments ="  +getSegments);
						if(getSegments.equals(segment)) {
							eleSeg.click();
							break;
						}
						continue;	
					}

					robot.keyPress(KeyEvent.VK_TAB);
					super.click(getDriver(), this.grvSacCodeColumn);
					Assert.assertTrue(this.grvSacCode.isEnabled());
					super.type(this.grvSacCode, sacCode);
					robot.keyPress(KeyEvent.VK_TAB);
					Assert.assertTrue(this.grvCgstPerc.isEnabled());
					super.type(this.grvCgstPerc, cgstPerc);
					robot.keyPress(KeyEvent.VK_TAB);
					Assert.assertTrue(this.grvSgstPerc.isEnabled());
					super.type(this.grvSgstPerc, sgstPerc);
					robot.keyPress(KeyEvent.VK_TAB)	;
					Assert.assertTrue(this.grvIgstPerc.isEnabled());
					super.type(this.grvIgstPerc, igstPerc);
					robot.keyPress(KeyEvent.VK_TAB);
					Assert.assertTrue(this.grvCessPerc.isEnabled());
					super.type(this.grvCessPerc, cessPerc);
					robot.keyPress(KeyEvent.VK_TAB);
					Assert.assertTrue(this.grvPartyBillNo.isEnabled());
					super.type(this.grvPartyBillNo, partyBillNo);
					robot.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(1000);
					super.click(getDriver(), this.grvPartyBillDate);

					//selecting party bill date
					Thread.sleep(1000);
					while(true) {
						String monthYear =getDriver().findElement(By.xpath("//div[@class='jqx-calendar-title-content jqx-calendar-title-content-energyblue']")).getText();
						String expectedDate =monthYear;
						//System.out.println(expectedDate);
						//System.out.println("party bill month = " + partyBillMonthYear);
						if(expectedDate.equals(partyBillMonthYear)) {

							break;
						}else {

							getDriver().findElement(By.xpath("//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-energyblue jqx-icon-arrow-right jqx-icon-arrow-right-energyblue']")).click();
						}


						//WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(20));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='jqx-calendar-month jqx-calendar-month-energyblue']")));
						List<WebElement> days=getDriver().findElements(By.xpath("//table[starts-with(@id,'cellTable')]/tbody//tr//td"));

						for(WebElement ele: days) {


							String calDays=ele.getText();

							if(partyBillDay.equals(calDays)) {

								ele.click();
								break;

							}
						}continue;
					}

					robot.keyPress(KeyEvent.VK_TAB);
					wait.until(ExpectedConditions.elementToBeClickable(this.grvskinPurity));
					Assert.assertTrue(this.grvskinPurity.isDisplayed());
					super.click(getDriver(), this.grvskinPurity);
					List<WebElement> listSkinPurity =getDriver().findElements(By.xpath("//div[@class='jqx-listitem-element']/child::span"));
					for(WebElement eleSP: listSkinPurity) {

						String getSkinPurityList = eleSP.getText();

						if(getSkinPurityList.equals(skinPurity)) {

							eleSP.click();
							break;
						}
						continue;
					}
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvPcs, Pcs);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvGrossWt, grossWt);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvNetWt, netWt);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvWastWt, wastWt);
					robot.keyPress(KeyEvent.VK_TAB);
					WebElement materialTypeField=getDriver().findElement(By.xpath("//div[@id='row0jqxgrid']/div[23]"));
					Assert.assertTrue(materialTypeField.isEnabled());
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					getDriver().findElement(By.xpath("//div[@id='row0jqxgrid']/div[24]")).click();
					super.type(this.grvDiamondWt, diamondWt);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvLabourCharges, labourCharge);
					robot.keyPress(KeyEvent.VK_TAB);
					WebElement valueInRSField=getDriver().findElement(By.xpath("//div[@id='row0jqxgrid']/div[26]"));
					Assert.assertTrue(valueInRSField.isEnabled());
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					getDriver().findElement(By.xpath("//div[@id='row0jqxgrid']/div[27]")).click();
					super.type(this.grvRemarks, remarks);
				//	super.scrollDown(getDriver(), grvSaveBtn);
					JavascriptExecutor js=(JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,350)", "");
					super.click(getDriver(), grvSaveBtn);
					//WebElement grvSuccessMsg=getDriver().findElement(By.className("growl-title"));
					succMsg =grvSuccessMsg.getText();
					
				}
				//F=Finished Goods, Dealer/Consignment
				else if (materialTypesValues.equalsIgnoreCase("F") && grvType.equalsIgnoreCase("D") || grvType.equalsIgnoreCase("C") ) {
					
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_ENTER);	
					getDriver().findElement(By.xpath("//div[@id='dropdownlistArrowcomboboxeditorjqxgridsegment']")).click();
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='jqx-listitem-element']/child::span")));
					List<WebElement> listSegments =getDriver().findElements(By.xpath("//div[@class='jqx-listitem-element']/child::span"));
					for(WebElement eleSeg:listSegments) {

						String getSegments =eleSeg.getText();

						if(getSegments.equals(segment)) {
							eleSeg.click();
							break;
						}
						continue;	
					}

					robot.keyPress(KeyEvent.VK_TAB);
					super.click(getDriver(), this.grvSacCodeColumn);
					Assert.assertTrue(this.grvSacCode.isEnabled());
					super.type(this.grvSacCode, sacCode);
					robot.keyPress(KeyEvent.VK_TAB);
					WebElement hsnValText=getDriver().findElement(By.className("growl-title"));
					String hsnCodeValidateMsg =hsnValText.getText();
					String expHsnCodeValidateMsg="HSN Code Validated Successfully";
					Assert.assertEquals(hsnCodeValidateMsg, expHsnCodeValidateMsg);
					Assert.assertTrue(this.grvCgstPerc.isEnabled());
					super.type(this.grvCgstPerc, cgstPerc);
					robot.keyPress(KeyEvent.VK_TAB);
					Assert.assertTrue(this.grvSgstPerc.isEnabled());
					super.type(this.grvSgstPerc, sgstPerc);
					robot.keyPress(KeyEvent.VK_TAB)	;
					Assert.assertTrue(this.grvIgstPerc.isEnabled());
					super.type(this.grvIgstPerc, igstPerc);
					robot.keyPress(KeyEvent.VK_TAB);
					Assert.assertTrue(this.grvCessPerc.isEnabled());
					super.type(this.grvCessPerc, cessPerc);
					robot.keyPress(KeyEvent.VK_TAB);
					Assert.assertTrue(this.grvPartyBillNo.isEnabled());
					super.type(this.grvPartyBillNo, partyBillNo);
					robot.keyPress(KeyEvent.VK_TAB);
					Thread.sleep(1000);
					super.click(getDriver(), this.grvPartyBillDate);
					//selecting party bill date
					Thread.sleep(1000);
					while(true) {
						String monthYear =getDriver().findElement(By.xpath("//div[@class='jqx-calendar-title-content jqx-calendar-title-content-energyblue']")).getText();
						String expectedDate =monthYear;
						//System.out.println(expectedDate);
						//System.out.println("party bill month = " + partyBillMonthYear);
						if(expectedDate.equals(partyBillMonthYear)) {

							break;
						}else {

							getDriver().findElement(By.xpath("//div[@class='jqx-calendar-title-navigation jqx-calendar-title-navigation-energyblue jqx-icon-arrow-right jqx-icon-arrow-right-energyblue']")).click();
						}


						//WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(20));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='jqx-calendar-month jqx-calendar-month-energyblue']")));
						List<WebElement> days=getDriver().findElements(By.xpath("//table[starts-with(@id,'cellTable')]/tbody//tr//td"));

						for(WebElement ele: days) {


							String calDays=ele.getText();

							if(partyBillDay.equals(calDays)) {

								ele.click();
								break;

							}
						}continue;
					}

					robot.keyPress(KeyEvent.VK_TAB);
					wait.until(ExpectedConditions.elementToBeClickable(this.grvskinPurity));
					Assert.assertTrue(this.grvskinPurity.isDisplayed());
					super.click(getDriver(), this.grvskinPurity);
					List<WebElement> listSkinPurity =getDriver().findElements(By.xpath("//div[@class='jqx-listitem-element']/child::span"));
					for(WebElement eleSP: listSkinPurity) {

						String getSkinPurityList = eleSP.getText();

						if(getSkinPurityList.equals(skinPurity)) {

							eleSP.click();
							break;
						}
						continue;
					}
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvPcs, Pcs);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvGrossWt, grossWt);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvNetWt, netWt);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvWastWt, wastWt);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvMetalRate, metalRate);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvDiamondWt, diamondWt);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvLabourCharges, labourCharge);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvValueInRs, valueInRs);
					robot.keyPress(KeyEvent.VK_TAB);
					super.type(this.grvRemarks, remarks);
					JavascriptExecutor js=(JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,350)", "");
					super.click(getDriver(), grvSaveBtn);
					//WebElement grvSuccessMsg=getDriver().findElement(By.className("growl-title"));
					succMsg =grvGrowlSuccessMsg.getText();		
				}


			}		
		}
		return succMsg;
	}

}


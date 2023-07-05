package com.dcpl.pageobjects;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

import net.bytebuddy.asm.Advice.This;

public class ReleaseOrderPage extends Action{

	public ReleaseOrderPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@id='storeCodes']")
	private WebElement inputStoreCode;

	@FindBy(xpath = "//input[@id='orderNo']")
	private WebElement inputOrderNo;

	@FindBy(xpath = "//div[@id='orderTypeCon']//button[@class='multiselect dropdown-toggle col-md-12 form-control text-left']")
	private WebElement inputOrderType;

	@FindBy(xpath = "//input[@id='vendorsCon']")
	private WebElement inputVendor;

	@FindBy(xpath = "//div[@class='btn-group open']//span[@class='multiselect-selected-text'][normalize-space()='None selected']")
	private WebElement inputSegment;

	@FindBy(xpath = "//div[@class='btn-group open']//button[@title='None selected']")
	private WebElement inputOrderKind;

	@FindBy(xpath = "//label[@class='checkbox']")
	private WebElement dropdownOptions;

	@FindBy(xpath = "//i[@class='fa fa-search fa-lg']")
	private WebElement btnSearch;

	@FindBy(xpath = "//button[@id='removeAllRelease']")
	private WebElement btnClear;

	@FindBy(xpath = "//button[@id='Save']")
	private WebElement btnSave;

	@FindBy(xpath = "//div[@class='jqx-checkbox-default jqx-fill-state-normal jqx-rc-all']")
	private WebElement checkBox;



	public String setStoreCode(String inputStoreCode) {

		super.type(this.inputStoreCode, inputStoreCode);

		List<WebElement> storeCodelist = getDriver().findElements(By.xpath("//li[@class='ui-menu-item']"));

		for(WebElement ele:storeCodelist) {

			String storeCode = ele.getText();
			System.out.println("Selected store code is = " + storeCode);

			if(storeCode.equalsIgnoreCase(inputStoreCode)) {

				//super.click(getDriver(), inputStoreCodeList);
				ele.click();
				break;
			}
		}

		return inputStoreCode;

	}

	public int setOrderNo(String inputOrderNo) {

		super.type(this.inputOrderNo, inputOrderNo);
		int OrderNo = Integer.parseInt(inputOrderNo);

		return OrderNo;
	}

	public String setOrderType(String inputOrderType) {

		//super.selectByVisibleText(inputOrderType, this.inputOrderType);
		super.click(getDriver(), this.inputOrderType);

		List<WebElement> orderTypeList = getDriver().findElements(By.xpath("//label[@class='checkbox']"));

		for(WebElement ele : orderTypeList) {

			String orderTypes = ele.getText();

			//System.out.println(orderTypes);

			if(orderTypes.equals(inputOrderType)) {

				ele.click();
				super.click(getDriver(), this.inputOrderType);
				//super.click(getDriver(), btnSearch);
				break;
			}
			
		}

		return inputOrderType;

	}

	public void setVendor(String inputVendor) {

		super.type(this.inputVendor, inputVendor);

	}

	/*public void setSegment(String inputSegment) {

		super.selectByVisibleText(inputSegment, this.inputSegment);

	}*/
	/*public void setOrderKind(String inputOrderKind) {

		super.selectByVisibleText(inputOrderKind, this.inputOrderKind);

	}*/


	public void selectOptionFromDropdown(String dropDownValues) {


		Select s =new Select(dropdownOptions);

		super.click(getDriver(), this.inputOrderType);

		List<WebElement> allOptions = s.getOptions();

		for(WebElement ele:allOptions) {

			String options = ele.getText();
			System.out.println(options);

			if(options.equals(dropDownValues)) {

				ele.click();
				break;
			}
		}
	}

	public void verifyingSearchGridColumnHeaders() {



	}

	public void verifyNoOfPages() {


	}
	public void clickOnSearchBtn() {

		super.click(getDriver(), btnSearch);
	}

	public void selectCheckBox() {

		super.click(getDriver(), checkBox);
	}

	public void clickOnClearBtn() {

		super.click(getDriver(), btnClear);
	}
	public String clickOnSaveBtn() {

		super.click(getDriver(), btnSave);
		
		WebElement growlMsg = getDriver().findElement(By.xpath("//div[@class='growl-message']"));
		
		super.fluentWait(getDriver(), growlMsg, 50);
		String message=growlMsg.getText();
		System.out.println(message);
		
		return message;
	}


	public boolean verifyStoreCodeInputField(String input) {
		boolean flag =false;

		inputStoreCode.isEnabled();
		inputStoreCode.sendKeys(input);

		flag =true;
		return flag;
	}

	public boolean verifyOrderNoInputField(String orderNo) {
		boolean flag =false;

		inputOrderNo.isEnabled();
		inputOrderNo.sendKeys(orderNo);

		flag =true;
		return flag;
	}

	public List<String> verifyOrderTypeInputField() {


		List<String> list =new ArrayList<>();


		String orderTypes="";

		super.click(getDriver(), inputOrderType);
		List<WebElement> orderTypeList =getDriver().findElements(By.xpath("//ul//li//a//label/input[@type='checkbox']"));
		WebElement e =getDriver().findElement(By.xpath("//ul[@class='multiselect-container dropdown-menu']"));
		int i;
		for(WebElement ele: orderTypeList) {


			orderTypes=ele.getAttribute("value");
			//Arrays.asList(orderTypes);
			//System.out.println(orderTypes);
			super.click(getDriver(), ele);
			break;

		}


		return Arrays.asList(orderTypes);

	}
	
	public String verifyVendorDueDate() {
		
		
		WebElement vendorDueDate =getDriver().findElement(By.xpath("//div[@class='jqx-grid-cell-middle-align' and text()='23/02/2023']"));
		 
		String dueDate=vendorDueDate.getText();
		//System.out.println(dueDate);
		//long vDueDate = Long.parseLong(dueDate);
		//Date date =new Date(vDueDate);
		System.out.println(dueDate);
		
		return dueDate;
	}



}

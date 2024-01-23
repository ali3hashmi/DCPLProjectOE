package com.dcpl.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class PSQCreateAttendance extends Action {


	public PSQCreateAttendance() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//select[@id='companyC']")
	private WebElement inputFieldCompany;

	@FindBy(xpath = "//select[@id='regionC']")
	private WebElement inputFieldRegion;

	@FindBy(xpath = "//select[@id='dcC']")
	private WebElement inputFieldDC;

	@FindBy(xpath = "//select[@id='storeC']")
	private WebElement inputFieldStore;

	@FindBy(xpath = "//select[@id='roleC']")
	private WebElement inputFieldRole;

	@FindBy(xpath = "//select[@id='yearC']")
	private WebElement inputFieldYears;

	@FindBy(xpath = "//select[@id='monthC']")
	private WebElement inputFieldMonth;

	@FindBy(xpath = "//select[@id='nameC']")
	private WebElement inputFieldName;

	@FindBy(xpath = "//input[@id='noOfDaysPresentC']")
	private WebElement inputFieldNoOfDaysPresent;

	@FindBy(xpath = "//input[@id='noOfDaysAbsentC']")
	private WebElement inputFieldNoOfDaysAbsent;

	@FindBy(xpath = "//button[@id='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='growl-message']")
	private WebElement successMsg;

	@FindBy(xpath = "//button[@id='downloadTemplate']")
	private WebElement downloadTempBtn;
	
	
	
	public void setInputFieldCompany(String company) {

		super.selectByVisibleText(company, inputFieldCompany);
	}

	public void setInputFieldRegion(String region) {

		super.selectByVisibleText(region, inputFieldRegion);
	}

	public void setInputFieldDC(String dc) {

		super.fluentWait(getDriver(), inputFieldDC, 10);
		//super.selectByVisibleText(dc, inputFieldDC);
		super.selectByValue(inputFieldDC, dc);
	}

	public void setInputFieldStore(String store) {

		super.selectByVisibleText(store, inputFieldStore);
	}

	public void setInputFieldRole(String role) {

		super.selectByVisibleText(role, inputFieldRole);
	}

	public void setInputFieldYears(String years) {

		//checking year drop down values sorted or not.

		ArrayList<String> yearsList =new ArrayList<String>();
		ArrayList<String> tempYearsList =new ArrayList<String >();

		Select se=new Select(inputFieldYears);
		for(WebElement ele : se.getOptions()) {

			yearsList.add(ele.getText());
		}

		tempYearsList.addAll(yearsList);
		//System.out.println("before Original" + yearsList);
		//System.out.println("before Temp" + tempYearsList);
		//
		Collections.sort(tempYearsList);

		//System.out.println("after Original" + yearsList);
		//System.out.println("after Temp" + tempYearsList);

		if(yearsList.equals(tempYearsList)) {

			System.out.println("Year dropdown is sorted");

		}else {

			System.out.println("Year dropdown is not sorted");
		}

		super.selectByVisibleText(years, inputFieldYears);
	}

	public void setInputFieldMonth(String month) {

		ArrayList<String> monthList =new ArrayList<String>();
		ArrayList<String> tempMonthList =new ArrayList<String>();

		Select se =new Select(inputFieldMonth);

		for(WebElement ele : se.getOptions()) {

			monthList.add(ele.getText());
		}

		tempMonthList.addAll(monthList);

		Collections.sort(tempMonthList);

		if(monthList.equals(tempMonthList)) {

			System.out.println("Month dropdown is sorted");

		}else {

			System.out.println("Month dropdown is not sorted");
		}


		super.selectByVisibleText(month, inputFieldMonth);
	}

	public void setInputFieldName(String empName) {

		super.fluentWait(getDriver(), inputFieldName, 20);
		//super.selectByVisibleText(empName, inputFieldName);
		super.selectByValue(inputFieldName, empName);
	}

	public void setInputFieldDaysPresent(String days) {


		super.type(inputFieldNoOfDaysPresent, days);
		super.fluentWait(getDriver(), inputFieldNoOfDaysAbsent, 10);

	}
	
	public String clickOnSaveBtn() {
		
		super.click(getDriver(), saveBtn);
		
		String actSuccessMsg=successMsg.getText();
		//System.out.println(actSuccessMsg);
		return actSuccessMsg;
	}
	
	public void clickOnDownloadTemplate() {
		
		try {
			super.click(getDriver(), downloadTempBtn);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	



//	





}

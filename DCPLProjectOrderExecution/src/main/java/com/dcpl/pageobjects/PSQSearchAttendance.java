package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class PSQSearchAttendance extends Action{

	public PSQSearchAttendance() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@id='attdCreate']")
	private WebElement createAttendanceBtn;
	
	
	
	public PSQCreateAttendance clickOnCreateAttendanceBtn(PSQCreateAttendance psqCreateAttendance) {
	
		super.click(getDriver(), createAttendanceBtn);
		
		return new PSQCreateAttendance();
	}
}

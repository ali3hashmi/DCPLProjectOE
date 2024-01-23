package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class PSQSearchTarget extends Action{

	
	public PSQSearchTarget() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@id='SearchPageCreateId']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//select[@id='companyS']")
	private WebElement company;
	
	
	
	public PSQCreateTarget clickOnCreateBtn(PSQCreateTarget psqCreateTarget) {
		
		super.click(getDriver(), createBtn);
		
		return new PSQCreateTarget();
	}
	
}

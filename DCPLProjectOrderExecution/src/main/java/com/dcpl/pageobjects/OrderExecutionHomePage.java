package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class OrderExecutionHomePage extends Action{


	public OrderExecutionHomePage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//h1[1]")
	private WebElement OEHomeText;
	



	public String getOEHomeText() {

		String oePageHomeText = OEHomeText.getText();
		return oePageHomeText;
	}
}

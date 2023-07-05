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
	
}

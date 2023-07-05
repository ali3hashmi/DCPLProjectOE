package com.dcpl.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class FloorPercentageCreate extends Action {

	
	public FloorPercentageCreate() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//select[@id='companyC']")
	private WebElement companyInputField;
	
	@FindBy(xpath = "//select[@id='regionC']")
	private WebElement regionInputField;
	
	@FindBy(xpath = "//select[@id='roleC']")
	private WebElement roleInputField;
	
	@FindBy(xpath = "//select[@id='gradeC']")
	private WebElement gradeInputField;
	
	@FindBy(xpath = "//select[@id='storeC']")
	private WebElement storeNameInputField;
	
	@FindBy(xpath = "//select[@id='SegmentC']")
	private WebElement segmentInputField;
	
	@FindBy(xpath = "//input[@id='percentageC']")
	private WebElement floorPercentageInputField;
	
	@FindBy(xpath = "//select[@id='yearC']")
	private WebElement yearInputField;
	
	@FindBy(xpath = "//select[@id='monthC']")
	private WebElement monthInputField;
	
	@FindBy(xpath = "//button[@id='SaveC']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//button[@id='clearallC']")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//div[@class='growl-message']")
	private WebElement growlMessage;
	
	
	
	
	public void setCompany(String companyInputField) throws InterruptedException {
		
		
		super.selectByVisibleText(companyInputField, this.companyInputField);
		super.fluentWait(getDriver(), this.regionInputField, 10);
	}
	
	public void setRegion(String regionInputField) {
		
		super.selectByVisibleText(regionInputField, this.regionInputField);
		super.fluentWait(getDriver(), this.roleInputField, 10);
	}
	
	public String setRole(String roleInputField) {
		
		super.selectByVisibleText(roleInputField, this.roleInputField);
		
		return roleInputField;
		
	}
	public void getAllRoles() {
		
		List<WebElement> allRoles = getDriver().findElements(By.xpath("//select[@id='roleC']"));
		
		for(WebElement ele:allRoles) {
			
			String roles = ele.getText();
			System.out.println(roles);
		}
		
	}
	
	public void setGrade(String gradeInputField) {
		
		if(this.gradeInputField.isEnabled()) {
			
			super.selectByVisibleText(gradeInputField, this.gradeInputField);
		}
		
	}
	
	public void setStoreName(String storeNameInputField)  {
		
		if(this.storeNameInputField.isEnabled()) {
			
			super.selectByVisibleText(storeNameInputField, this.storeNameInputField);
			
		}
	}
	
	public void setSegment(String segmentInputField) {
		
		super.selectByVisibleText(segmentInputField, this.segmentInputField);
	}
	
	public String setFloorPercentage(String floorPercentageInputField) {
		
		//String fp = String.valueOf(floorPercentageInputField);
		super.type(this.floorPercentageInputField, floorPercentageInputField);
		
		return floorPercentageInputField;
	}
	
	public void setYear(String yearInputField) {
		
		super.selectByVisibleText(yearInputField, this.yearInputField);
	}
	
	public void setMonth(String monthInputField) throws InterruptedException {
		
		super.selectByVisibleText(monthInputField, this.monthInputField);
		
	}
	
	public boolean clickOnSaveBtn() {
		
		boolean flag=false;
		super.click(getDriver(), this.saveBtn);
		//String errorMsgForDataExist = growlMessage.getText();
		String successMessage ="Floor Percentage is created successfully.";
		String growlessage = growlMessage.getText();
		if(growlessage.equals(successMessage)) {
			
			flag =true;
		}
		//System.out.println(errorMsgForDataExist);
		//System.out.println(successMessage);
		
		return flag;
	}
	
	public void clickOnCancelBtn() {
		
		super.click(getDriver(), this.cancelBtn);
	}
}

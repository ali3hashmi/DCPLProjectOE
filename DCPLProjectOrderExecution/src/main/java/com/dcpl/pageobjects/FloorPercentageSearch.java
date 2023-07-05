package com.dcpl.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class FloorPercentageSearch extends Action{

	public FloorPercentageSearch() {

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//button[@id='SearchPageCreateId']")
	private WebElement createFPBtn;

	@FindBy(xpath = "//select[@id='companyS']")
	private WebElement companySearchInputField;

	@FindBy(xpath = "//select[@id='regionS']")
	private WebElement regionSearchInputField;

	@FindBy(xpath = "//select[@id='role']")
	private WebElement roleSearchInputField;

	@FindBy(xpath = "//select[@id='grade']")
	private WebElement gradeSearchInputField;

	@FindBy(xpath = "//select[@id='storeName']")
	private WebElement storeNameSearchInputField;

	@FindBy(xpath = "//select[@id='Segment']")
	private WebElement segmentSearchInputField;

	@FindBy(xpath = "//select[@id='yearS']")
	private WebElement yearSearchInputField;

	@FindBy(xpath = "//select[@id='monthS']")
	private WebElement monthSearchInputField;

	@FindBy(xpath = "//select[@id='activeS']")
	private WebElement activeInactiveSearchInputField;

	@FindBy(xpath = "//button[@id='search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[@id='clearall']")
	private WebElement clearBtn;

	@FindBy(xpath = "//button[@id='editBtn_113']")
	private WebElement clickOnEditBtn;
	
	@FindBy(xpath = "//input[@type='textarea']")
	private WebElement fpEditText;
	
	@FindBy(xpath ="//div[contains(text(),'50.00')]" )
	private WebElement floorPercentageValue;
	
	@FindBy(xpath = "//button[@id='0']")
	private WebElement clickOnDeleteBtn;
	
	@FindBy(xpath = "//div[@class='growl-title']")
	private WebElement deleteSuccessMessage;
	
	//WebElement fpValue=getDriver().findElement(By.xpath("//div[contains(text(),'50.00')]"));
	//String storeName=getDriver().findElement(By.xpath("//div[contains(text(),'TS Madision')]")).getText();
	//System.out.println(storeName);

	public FloorPercentageCreate clickOnCreateBtn(FloorPercentageCreate floorPercentageCreate) {

		super.click(getDriver(), createFPBtn);

		return new FloorPercentageCreate();
	}

	public void setCompany(String companySearchInputField) {

		super.selectByVisibleText(companySearchInputField, this.companySearchInputField);
	}

	public void setRegion(String regionSearchInputField) {

		super.selectByVisibleText(regionSearchInputField,this.regionSearchInputField);
	}

	public String setRole(String roleSearchInputField) {

		super.selectByVisibleText(roleSearchInputField, this.roleSearchInputField);

		return roleSearchInputField;
	}

	public void setGrade(String gradeSearchInputField) {

		if(this.gradeSearchInputField.isEnabled()) {

			super.selectByVisibleText(gradeSearchInputField, this.gradeSearchInputField);
		}

	}

	public String setStoreName(String storeNameSearchInputField) {

		if(this.storeNameSearchInputField.isEnabled()) {

			super.selectByVisibleText(storeNameSearchInputField, this.storeNameSearchInputField);
		}
		return storeNameSearchInputField;
	}
	public String setSegment(String segmentSearchInputField) {

		super.selectByVisibleText(segmentSearchInputField, this.segmentSearchInputField);
		return segmentSearchInputField;
	}
	public void setYear(String yearSearchInputField) {

		super.selectByVisibleText(yearSearchInputField, this.yearSearchInputField);
	}
	public void setMonth(String monthSearchInputField) {

		super.selectByVisibleText(monthSearchInputField, this.monthSearchInputField);
		super.fluentWait(getDriver(), this.activeInactiveSearchInputField, 10);
	}

	public void setActiveInActive(String activeInactiveSearchInputField) {


	    super.selectByValue(this.activeInactiveSearchInputField, activeInactiveSearchInputField);
		//super.selectByVisibleText(activeInactiveSearchInputField, this.activeInactiveSearchInputField);
		//return activeInactiveSearchInputField;
	}
	
	public void clickOnSearchBtn() {

		super.click(getDriver(), this.searchBtn);


	}

	//	public List<String> getAllGridData() {
	//		
	//		String gridData="";
	//		List<String> all=new ArrayList<>();
	//		List<String> allGridData=new ArrayList<>();
	//		List<WebElement> getAllData=getDriver().findElements(By.xpath("//div[contains(@class,'jqx-grid-cell-middle-align')]"));
	//		for(WebElement ele: getAllData) {
	//			
	//			gridData= ele.getText();
	//			//System.out.println(gridData.length());
	//			
	//			//String to arrayList conversion
	//			allGridData = new ArrayList<>(Arrays.asList(gridData));
	//			all=allGridData;
	//		}
	//		
	//		return all;
	//	}

	public String getStoreNameGridData() {

		WebElement storeNameEle=getDriver().findElement(By.xpath("//div[contains(text(),'TS Madision')]"));
		String storeName = storeNameEle.getText();
		return storeName;
	}

	public String getRoleGridData() {

		String roleName=getDriver().findElement(By.xpath("//div[contains(text(),'Valuator')]")).getText();
		return roleName;
	}
	public String getGradeGridData() {

		String gradeName=getDriver().findElement(By.xpath("//div[contains(text(),'A')]")).getText();
		return gradeName;
	}
	public String getSegmentGridData() {

		String segmentName=getDriver().findElement(By.xpath("//div[contains(text(),'Gold')]")).getText();
		return segmentName;
	}


	public String getActiveInActiveGridData()  {


		//String value="Active";
		String activeInactiveName=getDriver().findElement(By.xpath("//div[contains(text(),'Active')]")).getText();

		return activeInactiveName;
	}
	
	public String getYearMonthGridData() {
		
		String yearMonthValue=getDriver().findElement(By.xpath("//div[contains(text(),'JULY/ 2023')]")).getText();
		return yearMonthValue;
	}
	
	public String getFloorPercentageGridData() {
		
		String floorPercentageValue=getDriver().findElement(By.xpath("//div[contains(text(),'50.00')]")).getText();
		return floorPercentageValue;
	}
	
	public void editFloorPercentage(String fpValue) throws InterruptedException, AWTException {
		
		Robot robot=new Robot();
		Actions action=new Actions(getDriver());
		super.click(getDriver(), this.clickOnEditBtn);
		action.doubleClick(this.floorPercentageValue).build().perform();
		//fpEditText.clear();
		Thread.sleep(3000);
		super.fluentWait(getDriver(), this.fpEditText, 20);
		super.type(this.fpEditText, fpValue);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		
	}
	
	public String deleteFloorPercentage() {
		
	   super.click(getDriver(), this.clickOnDeleteBtn);
	   String dSuccMsg=deleteSuccessMessage.getText();
	   
	   return dSuccMsg;
		
	}
	public void clickOnClearBtn() {

		super.click(getDriver(), this.clearBtn);
	}

}

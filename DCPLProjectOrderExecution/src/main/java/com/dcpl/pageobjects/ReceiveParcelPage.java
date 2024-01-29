package com.dcpl.pageobjects;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class ReceiveParcelPage extends Action {
	
	public ReceiveParcelPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@id='create']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//input[@id='vendors']")
	private WebElement recParcelVendor;
	
	@FindBy(xpath = "//select[@id='parcelDelMode']")
	private WebElement recParcelMode;
	
	@FindBy(xpath = "//select[@id='materialTYpe']")
	private WebElement recParcelMaterialType;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/input[1]")
	private WebElement recParcelInsuredAmount;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[3]/input[1]")
	private WebElement recParcelNoOfBoxes;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/input[1]")
	private WebElement recParcelCourierAgencyName;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[2]/input[1]")
	private WebElement recParcelCourierReceiptNumber;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[3]/input[1]")
	private WebElement recParcelCourierCharges;
	
	@FindBy(xpath = "//select[@id='costBy']")
	private WebElement recParcelCourierChargesBorneBy;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[5]/div[1]/input[1]")
	private WebElement recParcelGrossWt;
	
	@FindBy(xpath = "//input[@id='parcelRecBy']")
	private WebElement recParcelReceivedBy;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[5]/div[3]/input[1]")
	private WebElement recParcelSentThrough;
	
	@FindBy(xpath = "//button[@id='save']")
	private WebElement recParcelSaveBtn;;
	
	@FindBy(xpath = "//button[@class='btn btn-warning']")
	private WebElement recParcelCloseBtn;
	
	@FindBy(xpath = "//div[@class='growl-title']")
	private WebElement growlMessage;
	//class="growl-title"
	//growl-message
	//Successfully created parcel: 6637
	
	
	
	public void createReceiveParcelData(String recParcelVendor,String recParcelMode,String recParcelMaterialType,
			String recParcelInsuredAmount,
			String recParcelNoOfBoxes,
			String recParcelCourierAgencyName,
			String recParcelCourierReceiptNumber,
			String recParcelCourierCharges,
			String recParcelCourierChargesBorneBy,
			String recParcelGrossWt,
			String recParcelSentThrough) throws InterruptedException   {
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.click(getDriver(), createBtn);
		super.fluentWait(getDriver(), this.recParcelVendor, 10);
	
		super.click(getDriver(), this.recParcelVendor);
		super.type(this.recParcelVendor, recParcelVendor);
		Thread.sleep(1000);
		//recParcelVendor.sendKeys(Keys.ARROW_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		//this.recParcelVendor.sendKeys(Keys.ENTER);
	    super.selectByValue(this.recParcelMode, recParcelMode);
	    robot.keyPress(KeyEvent.VK_TAB);
	    super.explicitWait(getDriver(), this.recParcelReceivedBy, Duration.ofSeconds(30));
		//System.out.println("mode =" + mode);
		super.selectByValue(this.recParcelMaterialType, recParcelMaterialType);
		robot.keyPress(KeyEvent.VK_TAB);
		super.type(this.recParcelInsuredAmount, recParcelInsuredAmount);
		robot.keyPress(KeyEvent.VK_TAB);
		super.type(this.recParcelNoOfBoxes, recParcelNoOfBoxes);
		robot.keyPress(KeyEvent.VK_TAB);		
		super.type(this.recParcelCourierAgencyName, recParcelCourierAgencyName);
		robot.keyPress(KeyEvent.VK_TAB);	
		super.type(this.recParcelCourierReceiptNumber, recParcelCourierReceiptNumber);
		robot.keyPress(KeyEvent.VK_TAB);		
		super.type(this.recParcelCourierCharges, recParcelCourierCharges);
		robot.keyPress(KeyEvent.VK_TAB);		
		super.selectByValue(this.recParcelCourierChargesBorneBy, recParcelCourierChargesBorneBy);
		robot.keyPress(KeyEvent.VK_TAB);		
		super.type(this.recParcelGrossWt, recParcelGrossWt);
		robot.keyPress(KeyEvent.VK_TAB);		
		//super.fluentWait(getDriver(), this.recParcelReceivedBy, 10);
		super.type(this.recParcelSentThrough, recParcelSentThrough);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
			
	}
	
	public String clickOnSaveBtn() throws InterruptedException {
		
		super.click(getDriver(), recParcelSaveBtn);
		Thread.sleep(3000);
		String message=growlMessage.getText();
		//System.out.println(message);
		
		return message;
	}//Success
}

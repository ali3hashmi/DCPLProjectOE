package com.dcpl.pageobjects;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class PSQCreateTarget extends Action {

	public PSQCreateTarget() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	public double supFloorPercentage;
	public double targValue;
	public double supFloorLimitCalc;
	public double seFloorPercentage;
	public String singleSEFloorPercentage;
	public double singleSEFP;
	public double seIndividualTargetValue;
	public double seIndividualTargetValueExp;
	public double seIndividualFloorLimit;
	public double totalTargetSESUP;
	public double seTotalTarget;
	public double supIndTarget;
	public double seIndFloorLimit;
	public String seIndTarget;
	public int noOfSalesExecutives;
	public double sumOfAllSEIndTarget=0.0;
	public double sumOfSEIndTarget=0;

	@FindBy(xpath = "//select[@id='companyC']")
	private WebElement companyInputField;

	@FindBy(xpath = "//select[@id='regionC']")
	private WebElement regionInputField;

	@FindBy(xpath = "//select[@id='storeC']")
	private WebElement storeInputField;

	@FindBy(xpath = "//select[@id='SegmentC']")
	private WebElement targetSegmentInputField;

	@FindBy(xpath = "//select[@id='ISegmentC']")
	private WebElement includeSegmentInputField;

	@FindBy(xpath = "//select[@id='zoneC']")
	private WebElement zoneInputField;

	@FindBy(xpath = "//select[@id='yearC']")
	private WebElement yearInputField;

	@FindBy(xpath = "//select[@id='monthC']")
	private WebElement monthInputField;

	@FindBy(xpath = "//input[@id='percentageSE']")
	private WebElement seFPInputField;

	@FindBy(xpath = "//input[@id='percentageSup']")
	private WebElement supFPInputField;

	@FindBy(xpath = "//input[@id='targetC']")
	private WebElement targetValueInputField;

	@FindBy(xpath = "//input[@id='floorlSup']")
	private WebElement supFloorLimitInputField;

	@FindBy(xpath = "//button[@id='ContinueC']")
	private WebElement continueBtn;

	@FindBy(xpath = "//a[@id='backFromCreate']")
	private WebElement backBtn;

	@FindBy(xpath = "//button[@id='clearC']")
	private WebElement clearBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[*]")
	List<WebElement> noOfColumns;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[10]/div[1]/div[3]") 
	private WebElement noOfRowsText;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[*]/div[7]/div[1]")
	List<WebElement> seFloorPercentageWebTable;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[*]/div[8]/div[1]")
	List<WebElement>  seTargetWebTable;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[*]/div[9]/div[1]")
	List<WebElement> seFloorLimitWebTable;
	
	@FindBy(xpath = "//button[@id='saveC']")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[@id='clearallC']")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//div[@class='growl-message']")
	private WebElement growlMessage;

	public String setCompanyInputField(String companyInputField) {

		super.selectByVisibleText(companyInputField, this.companyInputField);

		return companyInputField;
	}

	public String setRegionInputField(String regionInputField) {

		super.selectByVisibleText(regionInputField, this.regionInputField);

		return regionInputField;
	}

	public String setStoreInputField(String storeInputField) {

		super.selectByVisibleText(storeInputField, this.storeInputField);

		return storeInputField;
	}

	private String tarSeg="";
	public String setTargetSegmentInputField(String targetSegmentInputField) {


		super.selectByVisibleText(targetSegmentInputField, this.targetSegmentInputField);
		super.fluentWait(getDriver(), this.includeSegmentInputField, 20);
		tarSeg=targetSegmentInputField;
		//System.out.println(targetSegmentInputField);
		return targetSegmentInputField;

	}

	public String  setIncludeSegmentInputField(String includeSegmentInputField) {


		boolean flag=false;
		if(tarSeg.equals("Gold") || tarSeg.equals("Diamond")) {

			if(this.includeSegmentInputField.isEnabled()) {

				super.fluentWait(getDriver(), this.includeSegmentInputField, 10);
				super.selectByVisibleText(includeSegmentInputField, this.includeSegmentInputField);
				flag=true;
			}


		}else {

			System.out.println("Target Segment Selected Other Than Gold Or Diamond Segment");
			flag=false;
		}

		//super.selectByIndex(this.includeSegmentInputField, 0);
		//super.selectByValue(this.includeSegmentInputField, includeSegmentInputField);



		return includeSegmentInputField;
	}

	public String setZoneInputField(String zoneInputField) {

		super.selectByVisibleText(zoneInputField, this.zoneInputField);

		return zoneInputField;
	}

	public String setYearInputField(String yearInputField) {

		super.selectByVisibleText(yearInputField, this.yearInputField);

		return yearInputField;
	}

	public String setMonthInputField(String monthInputField) {

		super.selectByVisibleText(monthInputField, this.monthInputField);

		return monthInputField;
	}

	public Double getSEFloorPercentage() {
		super.fluentWait(getDriver(), this.seFPInputField, 15);
		String seFP=seFPInputField.getAttribute("value");
		//System.out.println(seFP);
		seFloorPercentage=Double.parseDouble(seFP);
		return seFloorPercentage;
	}

	public Double getSUPFloorPercentage() {

		super.fluentWait(getDriver(), this.supFPInputField, 15);
		String supFP=supFPInputField.getAttribute("value");
		//System.out.println(supFP);
		supFloorPercentage=Double.parseDouble(supFP);
		return supFloorPercentage;
	}

	public Double setTargetValueInputField(String targetValueInputField) {

		super.type(this.targetValueInputField, targetValueInputField);

		targValue= Double.parseDouble(targetValueInputField);

		return targValue;

	}

	public Double getSUPFloorLimit() {

		super.fluentWait(getDriver(), this.supFloorLimitInputField, 15);
		String supFL=supFloorLimitInputField.getAttribute("value");

		//System.out.println(supFL);
		//sup Floor Limit=TargetValue *sup floor percentage
		double supFloorLimit =Double.parseDouble(supFL);

		supFloorLimitCalc = targValue * supFloorPercentage;

		return supFloorLimitCalc;
	}

	public void clickOnContinueBtn() throws InterruptedException {

		//Thread.sleep(5000);
		super.click(getDriver(), this.continueBtn);
	}

	public int noOfColumnsAndRows() {

		int totalColumns = noOfColumns.size();
		System.out.println("Total No of Columns =" + totalColumns);

		String getRows=noOfRowsText.getText();
		//System.out.println(getRows);
		//System.out.println(getRows.substring(2,3));
		int totalRows=Integer.valueOf(getRows.substring(7,8));
		System.out.println("Total no of rows = " + totalRows);

		return totalRows;
	}


	public double readSEFloorPercentageFromWebTable() {



		for(WebElement ele:seFloorPercentageWebTable) {

			String seFP = ele.getText();

			double seFloorPer=Double.parseDouble(seFP);


			if(seFloorPer == seFloorPercentage) {

				singleSEFloorPercentage = getDriver().
						findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[7]/div[1]"))
						.getText();
				//System.out.println(singleSEFloorPercentage);
				singleSEFP = Double.parseDouble(singleSEFloorPercentage);


			}else {

				System.out.println("Mismatch in SE floor percentage");
			}


		}
		return singleSEFP;

	}

	public double readSETargetFromWebTable() {

		//se target value calculation formula

		//se target value =sup target value/ no of se + 1

		List<WebElement> listOfSENames = 
				getDriver()
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[*]/div[2]/div[1]"));

		noOfSalesExecutives = listOfSENames.size();
		//System.out.println(noOfSalesExecutives);
		seIndividualTargetValue =targValue /(noOfSalesExecutives +1);

		DecimalFormat df_obj = new DecimalFormat("#.##");


		seIndividualTargetValueExp =Double.parseDouble(df_obj.format(seIndividualTargetValue));
		System.out.println("SE individual target expected =" + seIndividualTargetValueExp);  // as per the calculation

		//get all the se target value


		double[] sumOfSEIndTargetArr =new double[noOfSalesExecutives];

		//reading all the values of target from the grid
		for(WebElement ele : seTargetWebTable) {

			seIndTarget = ele.getText();
			sumOfSEIndTarget = Double.parseDouble(seIndTarget);

			//System.out.println(sumOfSEIndTarget);
			//int length = sumOfSEIndTargetArr.length;
			//System.out.println("Length " +length);

		}	 
		//converting double to double array
		for(int i=0;i< sumOfSEIndTargetArr.length;i++) {

			sumOfSEIndTargetArr[i]=sumOfSEIndTarget;
			sumOfAllSEIndTarget=sumOfAllSEIndTarget+sumOfSEIndTargetArr[i];

		}
		//System.out.println(sum);
		supIndTarget=sumOfAllSEIndTarget/noOfSalesExecutives;
		//System.out.println("sup ind target " +supIndTarget );
		totalTargetSESUP = sumOfAllSEIndTarget + supIndTarget;
		//System.out.println("Total target value by se and sup " + totalTargetSESUP);
		return totalTargetSESUP;
	}

	public double readSEFloorLimitFromWebTable() {

		//		String seIndFL=getDriver()
		//				.findElement
		//				(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[9]/div[1]"))
		//				.getText();
		//find sales executive individual floor limit
		//formula sefloorlimit = seTarget * sefloorpercentage /100
		DecimalFormat df_obj = new DecimalFormat("#.##");

		double expSEIndFloorLimit = seIndividualTargetValueExp * singleSEFP /100;
		//System.out.println("expected floor limit: " + expSEIndFloorLimit);

		System.out.println("SE individual floor limit expected =" + df_obj.format(expSEIndFloorLimit));

		//system generate individual se floor limit

		String sysGenSEIndTargetPath=getDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[8]"))
				.getText();

		String sysGenSEIndFPPath=getDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[7]/div[1]"))
				.getText();

		double sysGenSEIndTarget= Double.parseDouble(sysGenSEIndTargetPath);
		double sysGenSEIndFP = Double.parseDouble(sysGenSEIndFPPath);

		double sysGenIndSEFloorLimit = sysGenSEIndTarget * sysGenSEIndFP /100;
		//System.out.println("sys generated floor limit " + sysGenIndSEFloorLimit);

		System.out.println("SE individual floor limit system generated = " + df_obj.format(sysGenIndSEFloorLimit));


		//read all se floor limit
		double[] sumOfIndFloorLimitArr=new double[noOfSalesExecutives];
		System.out.println("length = " + sumOfIndFloorLimitArr.length);
		double sumOfAllSEIndFL=0.0;
		for(WebElement ele : seFloorLimitWebTable) {

			String getAllIndSEFloorLmit = ele.getText();

			//System.out.println(getAllIndSEFloorLmit);

			seIndFloorLimit = Double.parseDouble(getAllIndSEFloorLmit);
			//System.out.println(getAllIndSEFloorLmit);
		}
		//		if(df_obj.format(expSEIndFloorLimit)  == df_obj.format(sysGenIndSEFloorLimit) ) {

		//convert double to double array
		for(int i=0;i< sumOfIndFloorLimitArr.length;i++) {

			sumOfIndFloorLimitArr[i]=seIndFloorLimit;
			sumOfAllSEIndFL=sumOfAllSEIndFL+sumOfIndFloorLimitArr[i];
		}
		double seIndFloorlimit =sysGenIndSEFloorLimit;
		System.out.println("se individual floor limit = " + df_obj.format(seIndFloorlimit));

		//expected total se floor limit

		//formula is
		// expectedSETotalFL = soOfSETarget * seFP /100;

		double expSETotalFL = (targValue- sumOfSEIndTarget ) * seFloorPercentage /100;
		System.out.println("SE expected total floor limit = " + df_obj.format(expSETotalFL));
		
		System.out.println("Sum of all se's floor limit =" + sumOfAllSEIndFL);

		
//		if(df_obj.format(expSEIndFloorLimit) == df_obj.format(sysGenIndSEFloorLimit)) {
//			
//			
//			
//		}

		return sumOfAllSEIndFL;

	}
	
	public String clickOnSaveBtn() {
		
		super.click(getDriver(), saveBtn);
		
		String growlMsg= growlMessage.getText();
		System.out.println(growlMsg);
		
		return growlMsg;
	}
}

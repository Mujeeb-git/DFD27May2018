package digitalFrontDoor_POM;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitiesFunctionLibrary.Utility;

public class NewSARequestPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div[1]/div/div[1]/h4")
	public WebElement pageHeader;

	// ----------------1st step--------------------------
	@FindBy(xpath = "//*[@id='txtSAPID']") // Enter MMS ID of the Opportunity
	public WebElement mmsIDTxtBx;

	@FindBy(xpath = "//*[@id='MainContent_rdFederal_yes']") // This is a "Federal" opportunity
	public WebElement fedOppChkBx;

	@FindBy(xpath = "//*[@id='MainContent_rdFederal_nolnk']") // MMS ID not available yet
	public WebElement noMMSidChkBx;

	@FindBy(xpath = "//*[@id='btnfirstStep']") // Continue Button
	public WebElement step1ContinueBtn;

	// ----------------2nd step--------------------------

	@FindBy(xpath = "//*[@id='txtOppor']") // Opportunity Name*
	public WebElement oppNameTxtBx;

	@FindBy(xpath = "//*[@id='txtClientName']") // Client Name*
	public WebElement clientNameTxtBx;

	@FindBy(xpath = "//*[@id='MainContent_ddlCurrSales']") // Sales Stage*
	public WebElement salesStgDrpdwn;

	@FindBy(xpath = "//*[@id='txtDealSize']") // Overall Deal Size($K)*
	public WebElement overallDLSizeTxtBx;

	@FindBy(xpath = "//*[@id='txtMobileRevenue']") // Digital Allocation (%)*
	public WebElement digiAllocPercentTxtBx;

	@FindBy(xpath = "//*[@id='lbldealVal']") // Digital Deal Size($K)*
	public WebElement digiDLsizeVal;

	@FindBy(xpath = "//*[@id='btnstep2prev']") // Previous Button
	public WebElement step2PrevBtn;

	@FindBy(xpath = "//*[@id='btnstep2']") // Continue Button
	public WebElement step2ContinueBtn;

	// ----------------3rd step---------------------------

	@FindBy(xpath = "//*[@id='MainContent_ddlOriginGeo']") // Geographic Area*
	public WebElement geoAreaDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlSellingRegion']") // Geographic Unit*
	public WebElement geoUnitDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlRegion']") // Region
	public WebElement regionDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_lstServiceGroup']") // Service Group* Multi-Select Drpdwn
	public WebElement serviceGrpMultiDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_lstServiceGroup_ms']") // Service Group* Multi-Select Drpdwn Button
	public WebElement serviceGrpBtn;

	@FindBy(xpath = "/html/body/div[1]/div/ul/li[1]/a/span[2]") // Service Group* Drop down - Check All button
	public WebElement serviceGrpChkAllBtn;

	@FindBy(xpath = "/html/body/div[1]/div/ul/li[2]/a/span[2]") // Service Group* Drop down - Uncheck All button
	public WebElement serviceGrpUnchkAllBtn;

	@FindBy(xpath = "//*[@id='MainContent_ddOG']") // Operation Group* - Drop down
	public WebElement OpGrpDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_rdExtDeal_yes']") // Extension Deal* - Yes
	public WebElement extDealYesRadBtn;

	@FindBy(xpath = "//*[@id='MainContent_rdExtDeal_no']") // Extension Deal* - No
	public WebElement extDealNoRadBtn;

	@FindBy(xpath = "//*[@id='MainContent_rdtagdigital_yes']") // Tagged to Digital* - Yes
	public WebElement tag2DigiYesRadBtn;

	@FindBy(xpath = "//*[@id='MainContent_rdtagdigital_no']") // Tagged to Digital* - No
	public WebElement tag2DigiNoRadBtn;

	@FindBy(xpath = "//*[@id='btnstep3prev']") // Previous Button
	public WebElement step3PrevBtn;

	@FindBy(xpath = "//*[@id='btnstep3']") // Continue Button
	public WebElement step3ContinueBtn;

	// ----------------4th step---------------------------

	@FindBy(xpath = "//*[@id='txtEndDate']") // Submission date Text Box
	public WebElement SubmitDateTxtBx;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_title']") // Calendar title - Month, Year (May, 2018)
	public WebElement calTitle;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_prevArrow']") // Calendar Previous Arrow
	public WebElement calPrevArrow;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_nextArrow']") // Calendar Next Arrow
	public WebElement calNextArrow;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_day_1_0']") // Calendar 2nd row, 1st column
	public WebElement calDateBtn;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_today']") // Calendar Today Button
	public WebElement calDateTodayBtn;

	@FindBy(xpath = "//*[@id='MainContent_ddlAMSOffering']") // Speciality Drop down
	public WebElement specialityDrpdwn;

	@FindBy(xpath = "//*[@id='txtTechPlatform']") // Technology Text Area
	public WebElement techTextArea;

	@FindBy(xpath = "//*[@id='txtOppLongDesc']") // Opportunity description Text Area
	public WebElement oppDescTextArea;

	@FindBy(xpath = "//*[@id='step-4']/div[3]/button[2]") // Previous Button
	public WebElement step4PrevBtn;

	@FindBy(xpath = "//*[@id='btnstep4']") // Continue Button
	public WebElement step4ContinueBtn;

	// ----------------5th step---------------------------

	@FindBy(xpath = "//*[@id='MainContent_SI']") // SI (System Integration) Solution Architect for development services
	public WebElement siChkBx;

	@FindBy(xpath = "//*[@id='MainContent_AO']") // AO (Application Operations) Solution Architect for Application
													// Maintenance services
	public WebElement aoChkBx;

	@FindBy(xpath = "//*[@id='MainContent_IO']") // IO (Infrastructure Operations) Solution Architect for Infrastructure
													// related service
	public WebElement ioChkBx;

	@FindBy(xpath = "//*[@id='MainContent_rdRateCard_yes']") // Rate Card team support to create/update Accenture Rate
																// Card related to this opportunity
	public WebElement rateCardChkBx;

	@FindBy(xpath = "//*[@id='MainContent_rdIncludesIO_yes']") // Infrastructure or Cloud Design
	public WebElement infraCloudChkBx;

	@FindBy(xpath = "//*[@id='step-5']/div/div/div[2]/button[2]") // Previous Button
	public WebElement step5PrevBtn;

	@FindBy(xpath = "//*[@id='btnsupporttype']") // Continue Button
	public WebElement step5ContinueBtn;

	// ----------------6th step---------------------------

	@FindBy(xpath = "//*[@id='MainContent_ddlDelLoc']") // GDN (Global Delivery Network) involvement required
	public WebElement gdnInvolvDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_txtContactDetailsEmail']") // Client Account Lead
	public WebElement clientAccLeadTxtBx;

	@FindBy(xpath = "//*[@id='MainContent_txtAMSContactDetailsEmail']") // Digital Sales Lead
	public WebElement digiSalesLeadTxtBx;

	@FindBy(xpath = "//*[@id='MainContent_txtWBS']") // WBSe
	public WebElement wbseTxtBx;

	@FindBy(xpath = "//*[@id='MainContent_chkSendMail']") // Disable Sending Mail
	public WebElement disableEmailChkBx;

	@FindBy(xpath = "//*[@id='step-6']/div[3]/button") // Previous Button
	public WebElement step6PrevBtn;

	@FindBy(xpath = "//*[@id='MainContent_btnCancel']") // Cancel Button
	public WebElement step6CancelBtn;

	@FindBy(xpath = "//*[@id='btnreview']") // Review Button
	public WebElement reviewBtn;

	@FindBy(xpath = "//*[@id='MainContent_btnSubmit']") // Submit Button
	public WebElement submitBtn;

	// --------Opportunity Details

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div[1]/div/div[2]/div[1]/div/div/h4") // Opportunity Details Label
	public WebElement oppDetailsLbl;

	@FindBy(xpath = "//*[@id='spnopprname']") // Opportunity Name
	public WebElement oppNameMMS;

	@FindBy(xpath = "//*[@id='spclientname']") // Client Name
	public WebElement clientNameMMS;

	@FindBy(xpath = "//*[@id='spstage']") // Sales Stage
	public WebElement salesStgMMS;

	@FindBy(xpath = "//*[@id='spDealSize']") // Deal Size($K) (Overall)
	public WebElement overallDlSizeMMS;

	@FindBy(xpath = "//*[@id='spdealsize']") // Deal Size($K) (Digital)
	public WebElement digiDlSizeMMS;

	@FindBy(xpath = "//*[@id='spgeoarea']") // Geographic Area
	public WebElement geoAreaMMS;

	@FindBy(xpath = "//*[@id='spgeounit']") // Geographic Unit
	public WebElement geoUnitMMS;

	@FindBy(xpath = "//*[@id='spregion']") // Geographic Region
	public WebElement regionMMS;

	@FindBy(xpath = "//*[@id='spsg']") // Service Group
	public WebElement serviceGrpMMS;

	@FindBy(xpath = "//*[@id='spog']") // Operation Group
	public WebElement oppGrpMMS;

	@FindBy(xpath = "//*[@id='sptgdig']") // Tagged to Digital
	public WebElement tag2DigiMMS;

	@FindBy(xpath = "//*[@id='sprbe']") // RBE
	public WebElement rbeMMS;

	@FindBy(xpath = "//*[@id='sprbeoverride']") // RBE Override
	public WebElement rbeOverrideMMS;

	public NewSARequestPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all public WebElements
		PageFactory.initElements(driver, this);

	}

	// Choose geoUnit type
	public void chooseGeoUnit() {

		Select selectGU = new Select(geoUnitDrpdwn);
		selectGU.selectByIndex(2);

	}

	// Choose geoArea type
	public void chooseGeoArea(int i) {

		Select selectGU = new Select(geoAreaDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose Region type
	public void chooseRegion() {

		Select selectR = new Select(regionDrpdwn);
		selectR.selectByIndex(2);

	}

	// get sales Stage value
	public String getSalesStageOption(int i) {

		Select selectSS = new Select(salesStgDrpdwn);

		// Get all options
		List<WebElement> options = selectSS.getOptions();
		return options.get(i).getText();

	}

	// get Geo Area Values
	public String getGeoAreaOption(int i) {

		Select selectGA = new Select(geoAreaDrpdwn);

		// Get all options
		List<WebElement> options = selectGA.getOptions();
		return options.get(i).getText();
	}

	// Choose Speciality type
	public void chooseSpeciality() {

		Select selectS = new Select(specialityDrpdwn);
		selectS.selectByIndex(12);

	}

	// Choose Speciality type value
	public void chooseSpecialityValue(String spl) {

		Select selectS = new Select(specialityDrpdwn);
		selectS.selectByVisibleText(spl);

	}

	// Choose gdn value
	public void chooseGDNValue(String spl) {

		Select selectS = new Select(gdnInvolvDrpdwn);
		selectS.selectByVisibleText(spl);

	}

	public String getGeoUnitOption(int i) {

		Select selectSS = new Select(geoUnitDrpdwn);

		// Get all options
		List<WebElement> options = selectSS.getOptions();
		return options.get(i).getText();

	}

	public void fillSARqstWithMMSid(WebDriver driver) throws Exception {
		Utility objUtility = new Utility();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		mmsIDTxtBx.sendKeys(objUtility.getDFDData(2, "SARequest"));
		step1ContinueBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(oppNameMMS, objUtility.getDFDData(3, "SARequest")));
		step1ContinueBtn.click();
		SubmitDateTxtBx.click();
		calDateTodayBtn.click();
		Thread.sleep(3000);
		chooseSpecialityValue(objUtility.getDFDData(4, "SARequest"));
		techTextArea.sendKeys(objUtility.getDFDData(5, "SARequest"));
		oppDescTextArea.sendKeys(objUtility.getDFDData(6, "SARequest"));
		step4ContinueBtn.click();
		if (objUtility.getDFDData(7, "SARequest").contains("SI"))
			siChkBx.click();
		if (objUtility.getDFDData(7, "SARequest").contains("AO"))
			aoChkBx.click();
		if (objUtility.getDFDData(7, "SARequest").contains("IO"))
			ioChkBx.click();
		if (objUtility.getDFDData(7, "SARequest").contains("RC"))
			rateCardChkBx.click();
		if (objUtility.getDFDData(7, "SARequest").contains("IC"))
			infraCloudChkBx.click();
		step5ContinueBtn.click();
		chooseGDNValue(objUtility.getDFDData(8, "SARequest"));
		clientAccLeadTxtBx.sendKeys(objUtility.getDFDData(9, "SARequest"));
		digiSalesLeadTxtBx.sendKeys(objUtility.getDFDData(10, "SARequest"));
		wbseTxtBx.sendKeys(objUtility.getDFDData(11, "SARequest"));
	}

}

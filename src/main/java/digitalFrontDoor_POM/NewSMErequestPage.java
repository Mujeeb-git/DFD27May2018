package digitalFrontDoor_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewSMErequestPage {

	WebDriver driver;

	public NewSMErequestPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Header and title of the page
	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[1]/h4")
	public WebElement pageHeader;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[1]/h4/img")
	public WebElement pageHeaderImage;

	// Field labels elements
	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[1]/div[1]/label")
	public WebElement fedOpportFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[1]/div[2]/label")
	public WebElement opportIDFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[1]/label")
	public WebElement opportNameFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[2]/label")
	public WebElement clientNameFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[3]/label")
	public WebElement salesStgFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[4]/label")
	public WebElement overallDealSizeFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[5]/label")
	public WebElement digiAllocFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[6]/label")
	public WebElement digiDealSizeFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[7]/label")
	public WebElement operatGrpLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[2]/label")
	public WebElement typeOfSupprtFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[3]/label")
	public WebElement specialityDrpdwnLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[4]/label")
	public WebElement subSpltyFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[6]/label")
	public WebElement smeRqdDateFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[7]/label")
	public WebElement smeLocationFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[8]/label")
	public WebElement wbsFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[9]/label")
	public WebElement primaryCntctLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[10]/label")
	public WebElement addContactFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[11]/label")
	public WebElement technologyLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[12]/label")
	public WebElement opportDescLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[4]/div[1]/div[2]/label")
	public WebElement disableSndMailLbl;

	// Field elements

	@FindBy(xpath = "//*[@id='rdFederal_yeslnk']")
	public WebElement fedOpportYesLnk;

	@FindBy(xpath = "//*[@id='rdFederal_nolnk']")
	public WebElement fedOpportNoLnk;

	@FindBy(xpath = "//*[@id='txtSAPID']")
	public WebElement opportIDField;

	@FindBy(xpath = "//*[@id='txtOppor']")
	public WebElement opportNameField;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[1]/div[2]/div/img[1]")
	public WebElement fedOpportSearchBtn;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[1]/div[2]/div/img[2]")
	public WebElement fedOpportCancelBtn;

	@FindBy(xpath = "//*[@id='txtClientName']")
	public WebElement clientNameField;

	@FindBy(xpath = "//*[@id='MainContent_ddlCurrSales']")
	public WebElement salesStgField;

	@FindBy(xpath = "//*[@id='txtDealSize']")
	public WebElement overallDealSizeField;

	@FindBy(xpath = "//*[@id='txtMobileRevenue']")
	public WebElement digiAllocField;

	@FindBy(xpath = "//*[@id='lbldealVal']")
	public WebElement digiDealSizeField;

	@FindBy(xpath = "//*[@id='MainContent_ddOG']")
	public WebElement operatGrpDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlTypeofSupport']")
	public WebElement typeOfSupprtDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlAMSOffering']")
	public WebElement specialityDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlSubSpec']")
	public WebElement subSpecialityDrpdwn;

	@FindBy(xpath = "//*[@id='txtSMERequiredDate']")
	public WebElement smeRqdByDateField;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[6]/div/span")
	public WebElement smeRqdByCalenderImg;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender1_nextArrow']")
	public WebElement calenderNxtMnthArrow;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender1_day_1_0']")
	public WebElement calenderNxtMnthDate;

	@FindBy(xpath = "//*[@id='MainContent_ddlSellingRegion']")
	public WebElement smeLocationDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlRegion']")
	public WebElement smeRegionDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_txtWBS']")
	public WebElement wbsField;

	@FindBy(xpath = "//*[@id='MainContent_txtAMSContactDetailsEmail']")
	public WebElement primaryCntctField;

	@FindBy(xpath = "//*[@id='people-picker-container_MainContent_txtAMSContactDetailsEmail']/div[1]")
	public WebElement primaryCntctList1;

	@FindBy(xpath = "//*[@id='MainContent_txtDigitalResource']")
	public WebElement addCntctField;

	@FindBy(xpath = "//*[@id='people-picker-container_MainContent_txtDigitalResource']/div[1]")
	public WebElement addCntctList1;

	@FindBy(xpath = "//*[@id='txtTechnology']")
	public WebElement technologyTxtArea;

	@FindBy(xpath = "//*[@id='txtrequestDet']")
	public WebElement opportTxtArea;

	@FindBy(xpath = "//*[@id='MainContent_chkSendMail']")
	public WebElement disablesndMailChkBx;

	@FindBy(xpath = "//*[@id='MainContent_btnSubmit']")
	public WebElement submitBtn;

	@FindBy(xpath = "//*[@id='MainContent_btnCancel']")
	public WebElement cancelBtn;
	
	//pop text (no alert, pop msg is appeared in the same page
	@FindBy(xpath = "//*[@id='Poptext']")
	public WebElement popTxt;
	
	@FindBy(xpath = "/html/body/div[5]/div[3]/div/button[2]/span")
	public WebElement popNoBtn;
	
	
	

	// Choose sales stage
	public void choosesalesStage(int i) {

		Select selectGU = new Select(salesStgField);
		selectGU.selectByIndex(i);

	}

	// Choose SME region
	public void chooseSMERegion(int i) {

		Select selectGU = new Select(smeRegionDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose Operating group
	public void chooseOperatingGrp(int i) {

		Select selectGU = new Select(operatGrpDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose type of support
	public void chooseTypeOfSupprt(int i) {

		Select selectGU = new Select(typeOfSupprtDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose speciality
	public void chooseSpeciality(int i) {

		Select selectGU = new Select(specialityDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose sub-speciality
	public void chooseSubSpeciality(int i) {

		Select selectGU = new Select(subSpecialityDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose SME Location
	public void chooseSMELocation(int i) {

		Select selectGU = new Select(smeLocationDrpdwn);
		selectGU.selectByIndex(i);

	}

	// get sales Stage value
	// Choose sales stage value
	public String getSalesStageValue(int i) {

		Select selectGU = new Select(salesStgField);
		// Get all options
		List<WebElement> options = selectGU.getOptions();
		return options.get(i).getText();

	}

	// Choose Operating group value
	public String getOperatingGrpValue(int i) {

		Select selectGU = new Select(operatGrpDrpdwn);
		// Get all options
		List<WebElement> options = selectGU.getOptions();
		return options.get(i).getText();

	}

	// Choose type of support value
	public String getTypeOfSupprtValue(int i) {

		Select selectGU = new Select(typeOfSupprtDrpdwn);
		// Get all options
		List<WebElement> options = selectGU.getOptions();
		return options.get(i).getText();

	}

	// Choose speciality value
	public String getSpecialityValue(int i) {

		Select selectGU = new Select(specialityDrpdwn);
		// Get all options
		List<WebElement> options = selectGU.getOptions();
		return options.get(i).getText();

	}

	// Choose sub-speciality value
	public String getSubSpecialityValue(int i) {

		Select selectGU = new Select(subSpecialityDrpdwn);
		// Get all options
		List<WebElement> options = selectGU.getOptions();
		return options.get(i).getText();

	}

	// Choose SME Location value
	public String getSMELocationValue(int i) {

		Select selectGU = new Select(smeLocationDrpdwn);
		// Get all options
		List<WebElement> options = selectGU.getOptions();
		return options.get(i).getText();

	}

}

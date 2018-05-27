package digitalFrontDoor_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewPropSplstRqstPage {

	WebDriver driver;
	// Header and title of the page
	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[1]/h4")
	public WebElement pageHeader;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[1]/h4/img")
	public WebElement pageHeaderImage;
	
	//estimator
	@FindBy(xpath = "//*[@id='lblTotalHrs']")
	public WebElement estimatorHrs;
	
	@FindBy(xpath = "//*[@id='lblTotalDays']")
	public WebElement estimatorDays;
	

	// Field labels elements
	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[1]/label")
	public WebElement fedOpportFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[2]/label")
	public WebElement opportIDFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[1]/label")
	public WebElement opportNameFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[2]/label")
	public WebElement clientNameFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[3]/label")
	public WebElement salesStgFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[7]/label")
	public WebElement overallDealSizeFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[4]/label")
	public WebElement geoAreaDrpdwnLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[5]/label")
	public WebElement geoUnitDrpdwnLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[3]/div[6]/label")
	public WebElement operatGrpLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[4]/div[2]/label")
	public WebElement specialityDrpdwnLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[4]/div[1]/label")
	public WebElement supportRqdByLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[4]/div[3]/label")
	public WebElement wbsFieldLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[4]/div[4]/label")
	public WebElement primaryCntctLbl;

	@FindBy(xpath = "//*[@id=\"MainContent_pnlUpdate\"]/div/div/div[2]/div[4]/div[6]/label")
	public WebElement technologyLbl;

	@FindBy(xpath = "//*[@id=\"MainContent_pnlUpdate\"]/div/div/div[2]/div[4]/div[7]/label")
	public WebElement opportDescLbl;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[5]/div[1]/div[2]/label")
	public WebElement disableSndMailLbl;

	// Field elements
	@FindBy(xpath = "//*[@id='showDPCEst']/img")
	public WebElement getWorkEstimatesImg;

	@FindBy(xpath = "//*[@id='showDPCEst']")
	public WebElement getWorkEstimatesLnk;
	
	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[1]/div[1]")
	public WebElement getWorkEstimatesLine;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[1]/div[2]/a/img")
	public WebElement recentExamplesImg;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[1]/div[2]/a")
	public WebElement recentExamplesLnk;

	@FindBy(xpath = "//*[@id='lnkrdFederal_yes']")
	public WebElement fedOpportYesLnk;

	@FindBy(xpath = "//*[@id='lnkrdFederal_no']")
	public WebElement fedOpportNoLnk;

	@FindBy(xpath = "//*[@id='txtSAPID']")
	public WebElement opportIDField;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[2]/div/img[1]")
	public WebElement fedOpportSearchBtn;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[2]/div[2]/div/img[2]")
	public WebElement fedOpportCancelBtn;

	@FindBy(xpath = "//*[@id='txtOppor']")
	public WebElement opportNameField;

	@FindBy(xpath = "//*[@id='txtClientName']")
	public WebElement clientNameField;

	@FindBy(xpath = "//*[@id='MainContent_ddlCurrSales']")
	public WebElement salesStgField;

	@FindBy(xpath = "//*[@id='txtDealSize']")
	public WebElement overallDealSizeField;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div[2]/div[4]/div[1]/div/span[2]")
	public WebElement calenderImg;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_nextArrow']")
	public WebElement nextMonthArrw;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_day_1_0']")
	public WebElement nextMonthDate;

	@FindBy(xpath = "//*[@id='MainContent_ddlOriginGeo']")
	public WebElement geoAreaDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlSellingRegion']")
	public WebElement geoUnitDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddOG']")
	public WebElement operatGrpDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_ddlAMSOffering']")
	public WebElement specialityDrpdwn;

	@FindBy(xpath = "//*[@id='txtEndDate']")
	public WebElement supportRqdByDateField;

	@FindBy(xpath = "//*[@id='MainContent_txtWBS']")
	public WebElement wbsField;

	@FindBy(xpath = "//*[@id='MainContent_txtAMSContactDetailsEmail']")
	public WebElement primaryCntctField;

	@FindBy(xpath = "//*[@id='people-picker-container_MainContent_txtAMSContactDetailsEmail']/div[1]/div/div[1]")
	public WebElement primaryCntctFieldValue1;

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

	// Choose geoArea type
	public void chooseGeoArea(int i) {

		Select selectGU = new Select(geoAreaDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose speciality
	public void chooseSpeciality(int i) {

		Select selectGU = new Select(specialityDrpdwn);
		selectGU.selectByIndex(i);

	}

	// Choose geo unit
	public void chooseGeoUnit(int i) {

		Select selectGU = new Select(geoUnitDrpdwn);
		selectGU.selectByIndex(i);

	}

	// get sales Stage value
	public String salesStageOptions(int i) {

		Select selectSS = new Select(salesStgField);

		// Get all options
		List<WebElement> options = selectSS.getOptions();
		return options.get(i).getText();

	}

	public String geoUnitOptions(int i) {

		Select selectSS = new Select(geoUnitDrpdwn);

		// Get all options
		List<WebElement> options = selectSS.getOptions();
		return options.get(i).getText();

	}

	// get Geo Area Values
	public String geoAreaOptions(int i) {

		Select selectGA = new Select(geoAreaDrpdwn);

		// Get all options
		List<WebElement> options = selectGA.getOptions();
		return options.get(i).getText();
	}

	// get Operating group Values
	public String operatingGrpOptions(int i) {

		Select selectGA = new Select(operatGrpDrpdwn);

		// Get all options
		List<WebElement> options = selectGA.getOptions();
		return options.get(i).getText();
	}

	// get speciality Values
	public String specialityOptions(int i) {

		Select selectGA = new Select(specialityDrpdwn);

		// Get all options
		List<WebElement> options = selectGA.getOptions();
		return options.get(i).getText();
	}

	public NewPropSplstRqstPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

}

package digitalFrontDoor_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SolutionDetails {

	WebDriver driver;
	WebDriverWait wait;

	// Solution Team
	@FindBy(xpath = "//*[@id='cont_cancelbtn']")
	public WebElement solTeamCancelBtn;

	@FindBy(xpath = "//*[@id='txtSupSAName']")
	public WebElement solTeamSolDesignerField;

	@FindBy(xpath = "//*[@id='peoplePickerID']/div/div[1]")
	public WebElement solTeamSolDesignerFieldList1;

	@FindBy(xpath = "//*[@id='onshoresabtn']")
	public WebElement digiOnshoreSABtn;
	
	@FindBy(xpath = "//*[@id='gdnsabtn']")
	public WebElement digiGDNBtn;

	@FindBy(xpath = "//*[@id='MainContent_cont_rptOnshoreSAs_closebtn_0']")
	public WebElement digiOnshoreSARemoveBtn;

	@FindBy(xpath = "//*[@id='savebtn']")
	public WebElement saveBtn;

	// Sol tracking tab
	@FindBy(xpath = "//*[@id='MainContent_LinkButtonSI']")
	public WebElement SolTrackingTab;

	@FindBy(xpath = "//*[@id='btnTopSave']")
	public WebElement solTrackingSaveBtn;

	@FindBy(xpath = "//*[@id='btnTopCancel']")
	public WebElement solTrackingCancelBtn;

	// sol Tracking GDN
	@FindBy(xpath = "//*[@id='MainContent_LinkButtonGDN']")
	public WebElement SolTrackingGDNTab;

	@FindBy(xpath = "//*[@id='btnGDNTopSave']")
	public WebElement solTrackingGDNSaveBtn;

	@FindBy(xpath = "//*[@id='btnGDNTopCancel']")
	public WebElement solTrackingGNDCancelBtn;

	// DRA Tab
	@FindBy(xpath = "//*[@id='MainContent_LinkButtonDRA']")
	public WebElement DRATab;

	@FindBy(xpath = "//*[@id='drasendemailbtn']")
	public WebElement DRASubmitBtn;

	@FindBy(xpath = "//*[@id='dracancelbtn']")
	public WebElement DRACancelBtn;

	// DSA Tab
	@FindBy(xpath = "//*[@id='MainContent_LinkButtonDSA']")
	public WebElement DSATab;

	@FindBy(xpath = "//*[@id='DSATopSave']")
	public WebElement DSASaveBtn;

	@FindBy(xpath = "//*[@id='DSATopCancel']")
	public WebElement DSACancelBtn;
	
	

	public SolutionDetails(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all public WebElements

		PageFactory.initElements(driver, this);

	}

}

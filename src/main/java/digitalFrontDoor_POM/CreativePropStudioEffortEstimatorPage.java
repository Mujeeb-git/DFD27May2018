package digitalFrontDoor_POM;
/**
 * @author mujeeb.mohammed
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreativePropStudioEffortEstimatorPage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id='pnlEstimator']/div/div/h4")
	public WebElement pageHeading;

	@FindBy(xpath = "//*[@id='DPCEstIndentWrap']/h6[1]")
	public WebElement totalEstiEffortLbl;
	
	@FindBy(xpath = "//*[@id='lblmainParentHrs']")
	public WebElement totalEstiEffortHrs;
	
	@FindBy(xpath = "//*[@id='lblmainParentDays']")
	public WebElement totalEstiEffortDays;

	@FindBy(xpath = "//*[@id='DPCEstIndentWrap']/h6[2]")
	public WebElement indiCompletionDateLbl;
	
	@FindBy(xpath = "//*[@id='lblCompletionDate']")
	public WebElement indiCompletionDate;

	@FindBy(xpath = "//*[@id='mainExpAll']")
	public WebElement expandAllLnk;

	@FindBy(xpath = "//*[@id='MainClearAll']")
	public WebElement resetAllLnk;

	@FindBy(xpath = "//*[@id='PropAutMan']/h5")
	public WebElement propAuthnContentSec;

	@FindBy(xpath = "//*[@id='PropAutMan']/span[1]/a")
	public WebElement propAuthnContentToolTip;

	@FindBy(xpath = "//*[@id='qtip-14-content']/div/ul")
	public WebElement propAuthnContentToolTipTxt;

	@FindBy(xpath = "//*[@id='PropAutMan']/div/div[1]/h6")
	public WebElement propAuthoringSec;

	// Proposal Authoring
	@FindBy(xpath = "//*[@id='PropAutMan']/div/div[1]/span/a/span")
	public WebElement propAuthoringToolTip;

	@FindBy(xpath = "//*[@id='qtip-15-content']/div/ul")
	public WebElement propAuthoringToolTipTxt;

	@FindBy(xpath = "//*[@id='CustContent']/div[1]/label")
	public WebElement propAuthQues1Lbl;

	@FindBy(xpath = "//*[@id='CustContent']/div[2]/label")
	public WebElement propAuthQues2Lbl;

	@FindBy(xpath = "//*[@id='CustContent']/div[3]/label")
	public WebElement propAuthQues3Lbl;

	@FindBy(xpath = "//*[@id='ddlCCNoPropArt']")
	public WebElement propAuthNoOfQuesDrpdwn;

	@FindBy(xpath = "//*[@id='txtCCEsthrs']")
	public WebElement propAuthEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtCCEstdys']")
	public WebElement propAuthIndiDurDays;

	// Repository Content
	@FindBy(xpath = "//*[@id='PropAutMan']/div/div[2]/h6")
	public WebElement repContentSec;

	@FindBy(xpath = "//*[@id='PropAutMan']/div/div[2]/span/a/span")
	public WebElement repContentToolTip;

	@FindBy(xpath = "//*[@id='qtip-16-content']/div/ul")
	public WebElement repContentToolTipTxt;

	@FindBy(xpath = "//*[@id='ReposContent']/div[1]/label")
	public WebElement repContentQues1Lbl;

	@FindBy(xpath = "//*[@id='ReposContent']/div[2]/label")
	public WebElement repContentQues2Lbl;

	@FindBy(xpath = "//*[@id='ReposContent']/div[3]/label")
	public WebElement repContentQues3Lbl;

	@FindBy(xpath = "//*[@id='ddlRCNoPropArt']")
	public WebElement repContentNoOfPropsDrpdwn;

	@FindBy(xpath = "//*[@id='txtRCEsthrs']")
	public WebElement repContentEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtRCEstdys']")
	public WebElement repContentDurationDays;

	// -----------------------------------------------
	// main

	@FindBy(xpath = "//*[@id='PropAutMan']/span[2]")
	public WebElement propAuthnContentResetBtn;

	@FindBy(xpath = "//*[@id='DigiProp']/h5")
	public WebElement digiPropsSec;

	// Creative design section
	@FindBy(xpath = "//*[@id='CreatDesi']/h5")
	public WebElement creativeDesignSec;

	@FindBy(xpath = "//*[@id='CreatDesi']/span[1]/a/span")
	public WebElement creativeDsgnToolTip;

	@FindBy(xpath = "//*[@id='CreatDesi']/span[2]")
	public WebElement creativeDsgnResetBtn;

	@FindBy(xpath = "//*[@id='qtip-17-content']/div/ul")
	public WebElement creativeDsgnToolTipTxt;

	/*
	 * Creative design section- Proposal Story board and Visualization
	 */

	@FindBy(xpath = "//*[@id='CreatDesi']/div/div[1]/h6")
	public WebElement psvToolHeading;

	@FindBy(xpath = "//*[@id='CreatDesi']/div/div[1]/span/a/span")
	public WebElement psvToolTip;

	@FindBy(xpath = "//*[@id='qtip-18-content']/div/ul")
	public WebElement psvToolTipTxt;

	@FindBy(xpath = "//*[@id='CreativeDesign']/div[1]/label")
	public WebElement psvQues1Lbl;

	@FindBy(xpath = "//*[@id='CreativeDesign']/div[2]/label")
	public WebElement psvQues2Lbl;

	@FindBy(xpath = "//*[@id='CreativeDesign']/div[3]/label")
	public WebElement psvQues3Lbl;

	@FindBy(xpath = "//*[@id='ddlCDSlides']")
	public WebElement psvNoOfSldsDrpdwn;

	@FindBy(xpath = "//*[@id='txtCDEsthrs']")
	public WebElement psvEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtCDEstdays']")
	public WebElement psvIndiDurDays;

	// Visual Quality Enhancement
	@FindBy(xpath = "//*[@id='CreatDesi']/div/div[2]/h6")
	public WebElement viQltyEnhToolHeading;

	@FindBy(xpath = "//*[@id='CreatDesi']/div/div[2]/span/a/span")
	public WebElement viQltyEnhToolTip;

	@FindBy(xpath = "//*[@id='qtip-19-content']/div/ul")
	public WebElement viQltyEnhToolTipTxt;

	@FindBy(xpath = "//*[@id='VisQualEnh']/div[1]/label")
	public WebElement viQltyEnhQues1Lbl;

	@FindBy(xpath = "//*[@id='VisQualEnh']/div[2]/label")
	public WebElement viQltyEnhQues2Lbl;

	@FindBy(xpath = "//*[@id='VisQualEnh']/div[3]/label")
	public WebElement viQltyEnhQues3Lbl;

	@FindBy(xpath = "//*[@id='ddlVQESlides']")
	public WebElement viQltyEnhNoOfSldsDrpdwn;

	@FindBy(xpath = "//*[@id='txtVQEEsthrs']")
	public WebElement viQltyEnhEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtVQEEstdays']")
	public WebElement viQltyEnhIndiDurDays;

	// Solution Illustration
	@FindBy(xpath = "//*[@id='SolIllustration']/h5")
	public WebElement solIllustrationSec;

	@FindBy(xpath = "//*[@id='SolIllustration']/span[1]/a/span")
	public WebElement solIllustrationToolTip;

	@FindBy(xpath = "//*[@id='SolIllustration']/span[2]")
	public WebElement solIllustrationResetBtn;

	@FindBy(xpath = "//*[@id='qtip-20-content']/div/ul")
	public WebElement solIllustrationToolTipTxt;

	/*
	 * Solution Illustration - Interactive Wire frames
	 */
	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[1]/h6")
	public WebElement intWireFrameHeading;

	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[1]/span/a/span")
	public WebElement intWireFrameTip;

	@FindBy(xpath = "//*[@id='qtip-21-content']/div/ul")
	public WebElement intWireFrameTipTxt;

	@FindBy(xpath = "//*[@id='InterWire']/div[1]/label")
	public WebElement intWireFrameQues1Lbl;

	@FindBy(xpath = "//*[@id='InterWire']/div[2]/label")
	public WebElement intWireFrameQues2Lbl;

	@FindBy(xpath = "//*[@id='InterWire']/div[3]/label")
	public WebElement intWireFrameQues3Lbl;

	@FindBy(xpath = "//*[@id='InterWire']/div[4]/label")
	public WebElement intWireFrameQues4Lbl;

	@FindBy(xpath = "//*[@id='ddlIWnoUseCases']")
	public WebElement intWireFrameNoOfWFsDrpdwn;

	@FindBy(xpath = "//*[@id='ddlIWnoScreens']")
	public WebElement intWireFrameNoOfScrnsDrpdwn2;

	@FindBy(xpath = "//*[@id='txtIWDurationHours']")
	public WebElement intWireFrameEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtIWDurationDays']")
	public WebElement intWireFrameIndiDurDays;

	/*
	 * Solution Illustration - Rapid Prototype
	 */
	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[2]/h6")
	public WebElement rpdProtoHeading;

	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[2]/span/a/span")
	public WebElement rpdProtoTip;

	@FindBy(xpath = "//*[@id='qtip-22-content']/div/ul")
	public WebElement rpdProtoTipTxt;

	@FindBy(xpath = "//*[@id='RapidPro']/div[1]/label")
	public WebElement rpdProtoQues1Lbl;

	@FindBy(xpath = "//*[@id='RapidPro']/div[2]/label")
	public WebElement rpdProtoQues2Lbl;

	@FindBy(xpath = "//*[@id='RapidPro']/div[3]/label")
	public WebElement rpdProtoQues3Lbl;

	@FindBy(xpath = "//*[@id='RapidPro']/div[4]/label")
	public WebElement rpdProtoQues4Lbl;

	@FindBy(xpath = "//*[@id='ddlRPnoUseCases']")
	public WebElement rpdProtoNoOfProtosDrpdwn;

	@FindBy(xpath = "//*[@id='ddlRPnoScreens']")
	public WebElement rpdProtoNoOfScrnsDrpdwn2;

	@FindBy(xpath = "//*[@id='txtRPDurationHours']")
	public WebElement rpdProtoEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtRPDurationDays']")
	public WebElement rpdProtoIndiDurDays;

	/*
	 * Solution Illustration - Mock-up Screens
	 */
	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[3]/h6")
	public WebElement mockupScrnsHeading;

	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[3]/span/a/span")
	public WebElement mockupScrnsTip;

	@FindBy(xpath = "//*[@id='qtip-23-content']/div/ul")
	public WebElement mockupScrnsTipTxt;

	@FindBy(xpath = "//*[@id='Mockupsrcs']/div[1]/label")
	public WebElement mockupScrnsQues1Lbl;

	@FindBy(xpath = "//*[@id='Mockupsrcs']/div[2]/label")
	public WebElement mockupScrnsQues2Lbl;

	@FindBy(xpath = "//*[@id='Mockupsrcs']/div[3]/label")
	public WebElement mockupScrnsQues3Lbl;

	@FindBy(xpath = "//*[@id='Mockupsrcs']/div[4]/label")
	public WebElement mockupScrnsQues4Lbl;

	@FindBy(xpath = "//*[@id='ddlMSnoUseCases']")
	public WebElement mockupScrnsNoOfScrnsDrpdwn;

	@FindBy(xpath = "//*[@id='ddlMSnoScreens']")
	public WebElement mockupScrnsExpScrnsDrpdwn2;

	@FindBy(xpath = "//*[@id='txtMSDurationHours']")
	public WebElement mockupScrnsEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtMSDurationDays']")
	public WebElement mockupScrnsIndiDurDays;

	/*
	 * Solution Illustration - User Journey Visualizations
	 */
	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[4]/h6")
	public WebElement usrJrnyVisHeading;

	@FindBy(xpath = "//*[@id='SolIllustration']/div/div[4]/span/a/span")
	public WebElement usrJrnyVisTip;

	@FindBy(xpath = "//*[@id='qtip-24-content']/div/ul")
	public WebElement usrJrnyVisTipTxt;

	@FindBy(xpath = "//*[@id='Usrjrnyvsul']/div[1]/label")
	public WebElement usrJrnyVisQues1Lbl;

	@FindBy(xpath = "//*[@id='Usrjrnyvsul']/div[2]/label")
	public WebElement usrJrnyVisQues2Lbl;

	@FindBy(xpath = "//*[@id='Usrjrnyvsul']/div[3]/label")
	public WebElement usrJrnyVisQues3Lbl;

	@FindBy(xpath = "//*[@id='Usrjrnyvsul']/div[4]/label")
	public WebElement usrJrnyVisQues4Lbl;

	@FindBy(xpath = "//*[@id='ddlUJVnoUseCases']")
	public WebElement usrJrnyVisNoOfScrnsDrpdwn;

	@FindBy(xpath = "//*[@id='ddlUJVnoScreens']")
	public WebElement usrJrnyVisExpScrnsDrpdwn2;

	@FindBy(xpath = "//*[@id='txtUJVDurationHours']")
	public WebElement usrJrnyVisEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtUJVDurationDays']")
	public WebElement usrJrnyVisIndiDurDays;

	// Digitized Proposals
	@FindBy(xpath = "//*[@id='DigiProp']/h5")
	public WebElement digiPropSec;

	@FindBy(xpath = "//*[@id='DigiProp']/span[1]/a/span")
	public WebElement digiPropToolTip;

	@FindBy(xpath = "//*[@id='DigiProp']/span[2]")
	public WebElement digiPropResetBtn;

	@FindBy(xpath = "//*[@id='qtip-25-content']/div/ul")
	public WebElement digiPropToolTipTxt;

	/*
	 * Digitized Proposals - Accenture Secure Proposal Viewer
	 */
	@FindBy(xpath = "//*[@id='DigiProp']/div/div[1]/h6")
	public WebElement aspViewerHeading;

	@FindBy(xpath = "//*[@id='DigiProp']/div/div[1]/span/a/span")
	public WebElement aspViewerTip;

	@FindBy(xpath = "//*[@id='qtip-26-content']/div/ul")
	public WebElement aspViewerTipTxt;

	@FindBy(xpath = "//*[@id='ASPViewer']/div[1]/label")
	public WebElement aspViewerQues1Lbl;

	@FindBy(xpath = "//*[@id='ASPViewer']/div[2]/label")
	public WebElement aspViewerQues2Lbl;

	@FindBy(xpath = "//*[@id='ASPViewer']/div[3]/label")
	public WebElement aspViewerQues3Lbl;

	@FindBy(xpath = "//*[@id='ASPViewer']/div[4]/label")
	public WebElement aspViewerQues4Lbl;

	@FindBy(xpath = "//*[@id='ddlASPVMMCtoDev']")
	public WebElement aspViewerNoOfScrnsDrpdwn;

	@FindBy(xpath = "//*[@id='ddlASPVPropArt']")
	public WebElement aspViewerExpScrnsDrpdwn2;

	@FindBy(xpath = "//*[@id='txtASPVEstihours']")
	public WebElement aspViewerEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtASPVEstidays']")
	public WebElement aspViewerIndiDurDays;

	/*
	 * Digitized Proposals - Proposal as Web-App Package
	 */
	@FindBy(xpath = "//*[@id='DigiProp']/div/div[2]/h6")
	public WebElement PWAPackageHeading;

	@FindBy(xpath = "//*[@id='DigiProp']/div/div[2]/span/a/span")
	public WebElement PWAPackageTip;

	@FindBy(xpath = "//*[@id='qtip-27-content']/div/ul")
	public WebElement PWAPackageTipTxt;

	@FindBy(xpath = "//*[@id='PWAPackage']/div[1]/label")
	public WebElement PWAPackageQues1Lbl;

	@FindBy(xpath = "//*[@id='PWAPackage']/div[2]/label")
	public WebElement PWAPackageQues2Lbl;

	@FindBy(xpath = "//*[@id='PWAPackage']/div[3]/label")
	public WebElement PWAPackageQues3Lbl;

	@FindBy(xpath = "//*[@id='PWAPackage']/div[4]/label")
	public WebElement PWAPackageQues4Lbl;

	@FindBy(xpath = "//*[@id='ddlPWAPMMCtoDev']")
	public WebElement PWAPackageNoOfScrnsDrpdwn;

	@FindBy(xpath = "//*[@id='ddlPWAPPropArt']")
	public WebElement PWAPackageExpScrnsDrpdwn2;

	@FindBy(xpath = "//*[@id='txtPWAPEstihours']")
	public WebElement PWAPackageEstimatesHrs;

	@FindBy(xpath = "//*[@id='txtPWAPEstidays']")
	public WebElement PWAPackageIndiDurDays;

	// Buttons
	@FindBy(xpath = "//*[@id='btnSave']")
	public WebElement saveBtnBottm;

	@FindBy(xpath = "//*[@id='btnBottomCancel']")
	public WebElement cancelBtnBottm;

	@FindBy(xpath = "//*[@id='btnTopSave']")
	public WebElement saveBtnTop;

	@FindBy(xpath = "//*[@id='btnTopCancel']")
	public WebElement cancelBtnTop;
	
	//estimate values for each section
	@FindBy(xpath = "//*[@id='lblPropParentHrs']")
	public WebElement pacEstiHrs;
	
	@FindBy(xpath = "//*[@id='lblPropparentDays']")
	public WebElement pacEstiDays;
	
	@FindBy(xpath = "//*[@id='lblCreParentHrs']")
	public WebElement cdEstiHrs;
	
	@FindBy(xpath = "//*[@id='lblCreparentDays']")
	public WebElement cdEstiDays;
	
	@FindBy(xpath = "//*[@id='lblSolParentHrs']")
	public WebElement siEstiHrs;
	
	@FindBy(xpath = "//*[@id='lblSolparentDays']")
	public WebElement siEstiDays;
	
	@FindBy(xpath = "//*[@id='lblDigParentHrs']")
	public WebElement dpEstiHrs;
	
	@FindBy(xpath = "//*[@id='lblDigparentDays']")
	public WebElement dpEstiDays;
	

	// Choose Proposal Authoring No. of question
	public void choosePropAuthNoOfQues(int i) {
		Select selectGU = new Select(propAuthNoOfQuesDrpdwn);
		selectGU.selectByIndex(i);
	}

	// Choose Repository Content
	public void chooserepContentNoOfProps(int i) {
		Select selectGU = new Select(repContentNoOfPropsDrpdwn);
		selectGU.selectByIndex(i);
	}

	// Choose Proposal Storyboard and Visualization
	public void choosePSVNoOfSlides(int i) {
		Select selectGU = new Select(psvNoOfSldsDrpdwn);
		selectGU.selectByIndex(i);
	}

	// Choose Visual Quality Enhancement
	public void chooseVQENoOfSlides(int i) {
		Select selectGU = new Select(viQltyEnhNoOfSldsDrpdwn);
		selectGU.selectByIndex(i);
	}
	
	// Choose Interactive Wireframes
	public void chooseIntWireFrameNoOfWFs(int i) {
		Select selectGU = new Select(intWireFrameNoOfWFsDrpdwn);
		selectGU.selectByIndex(i);
	}
	
	// Choose Rapid Prototype
	public void chooseRpdProtoNoOfProtos(int i) {
		Select selectGU = new Select(rpdProtoNoOfProtosDrpdwn);
		selectGU.selectByIndex(i);
	}
	
	// Choose Mock-up screens
	public void chooseMockupScrnsNoOfScrns(int i) {
		Select selectGU = new Select(mockupScrnsNoOfScrnsDrpdwn);
		selectGU.selectByIndex(i);
	}
	
	// Choose User journey Visualizations
	public void chooseUsrJrnyVisNoOfScrns(int i) {
		Select selectGU = new Select(usrJrnyVisNoOfScrnsDrpdwn);
		selectGU.selectByIndex(i);
	}
	
	// Choose Accenture Secure Proposal Viewer
	public void chooseASPViewerNoOfScrns(int i) {
		Select selectGU = new Select(aspViewerNoOfScrnsDrpdwn);
		selectGU.selectByIndex(i);
	}
	
	// Choose Proposal as Web-App Package
	public void choosePWAPackageNoOfScrns(int i) {
		Select selectGU = new Select(PWAPackageNoOfScrnsDrpdwn);
		selectGU.selectByIndex(i);
	}

	// Choose intWireFrameNoOfScrnsDrpdwn2
	public void chooseIntWireFrameNoOfScrns(int i) {
		Select selectGU = new Select(intWireFrameNoOfScrnsDrpdwn2);
		selectGU.selectByIndex(i);
	}

	// Choose rpdProtoNoOfScrnsDrpdwn2
	public void chooseRpdProtoNoOfScrns(int i) {
		Select selectGU = new Select(rpdProtoNoOfScrnsDrpdwn2);
		selectGU.selectByIndex(i);
	}

	// Choose mockupScrnsExpScrnsDrpdwn2
	public void chooseMockupScrnsExpScrns(int i) {
		Select selectGU = new Select(mockupScrnsExpScrnsDrpdwn2);
		selectGU.selectByIndex(i);
	}

	// Choose usrJrnyVisExpScrnsDrpdwn2
	public void chooseUsrJrnyVisExpScrns(int i) {
		Select selectGU = new Select(usrJrnyVisExpScrnsDrpdwn2);
		selectGU.selectByIndex(i);
	}

	// Choose aspViewerExpScrnsDrpdwn2
	public void chooseAspViewerExpScrns(int i) {
		Select selectGU = new Select(aspViewerExpScrnsDrpdwn2);
		selectGU.selectByIndex(i);
	}

	// Choose PWAPackageExpScrnsDrpdwn2
	public void choosePWAPackageExpScrns(int i) {
		Select selectGU = new Select(PWAPackageExpScrnsDrpdwn2);
		selectGU.selectByIndex(i);
	}
		

	public CreativePropStudioEffortEstimatorPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all public WebElements

		PageFactory.initElements(driver, this);

	}
	
	//calculating sum of estimated effort hours of all the 4 categories
	public Double sumOfCPScatEstiEffortHrs(WebDriver driver) {
		
		return (Double.parseDouble(pacEstiHrs.getText())+
		Double.parseDouble(cdEstiHrs.getText())+
		Double.parseDouble(siEstiHrs.getText())+
		Double.parseDouble(dpEstiHrs.getText()))		
		;
			
	}
	
	//returns the list of sub-categories estimated days from the fields
	public List<Double> subCatEstiDaysList(WebDriver driver){
		
		List<Double> subCategoryEstiDaysList = new ArrayList<Double>(10);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
		subCategoryEstiDaysList.add(Double.parseDouble(propAuthIndiDurDays.getAttribute("value")));
		subCategoryEstiDaysList.add(Double.parseDouble(repContentDurationDays.getAttribute("value")));
		subCategoryEstiDaysList.add(Double.parseDouble(psvIndiDurDays.getAttribute("value")));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight*0.6)");
		subCategoryEstiDaysList.add(Double.parseDouble(viQltyEnhIndiDurDays.getAttribute("value")));
		subCategoryEstiDaysList.add(Double.parseDouble(intWireFrameIndiDurDays.getAttribute("value")));
		subCategoryEstiDaysList.add(Double.parseDouble(rpdProtoIndiDurDays.getAttribute("value")));
		subCategoryEstiDaysList.add(Double.parseDouble(mockupScrnsIndiDurDays.getAttribute("value")));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		subCategoryEstiDaysList.add(Double.parseDouble(usrJrnyVisIndiDurDays.getAttribute("value")));
		subCategoryEstiDaysList.add(Double.parseDouble(aspViewerIndiDurDays.getAttribute("value")));
		subCategoryEstiDaysList.add(Double.parseDouble(PWAPackageIndiDurDays.getAttribute("value")));
		return subCategoryEstiDaysList;
	}

}

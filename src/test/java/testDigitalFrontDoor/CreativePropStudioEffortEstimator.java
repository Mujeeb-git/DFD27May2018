package testDigitalFrontDoor;
/**
 * @author mujeeb.mohammed
 *
 */
import java.util.ArrayList;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import digitalFrontDoor_POM.CreativePropStudioEffortEstimatorPage;
import digitalFrontDoor_POM.DFDHomePage;
import digitalFrontDoor_POM.EditSolutionTeamPage;
import digitalFrontDoor_POM.LoginPage;
import digitalFrontDoor_POM.NewPropSplstRqstPage;
import digitalFrontDoor_POM.NewSARequestPage;
import digitalFrontDoor_POM.SolutionIntegratorAllocationPage;
import utilitiesFunctionLibrary.DFDFunctionLibrary;
import utilitiesFunctionLibrary.Utility;

public class CreativePropStudioEffortEstimator  {

	WebDriver driver;
	WebDriverWait wait;
	DFDHomePage objDFDHomePage;
	LoginPage objLoginPage;
	NewSARequestPage objNewSARequestPage;
	SolutionIntegratorAllocationPage objSIAllocationPage;
	EditSolutionTeamPage objEditSolTeamPage;
	NewPropSplstRqstPage objNewPropSplstRqstPage;
	CreativePropStudioEffortEstimatorPage objCPSEffortEstimatorPage;
	DFDFunctionLibrary objDFDFunctionLibrary;
	Utility objUtility;
	StopWatch stopWatch;
	Actions actions;
	double cpsTotalEstimates,cpsPACestiHrs,cpsCDestiHrs,cpsSIestiHrs,cpsDPestiHrs
	,cpsTotalEstiEffortDays;
	int largestSubCatDuration;
	JavascriptExecutor jse;
	String decryptedPassword, encryptedPassword, userName, dateStr, siMessage, requestNumberMsg, requestNumber, value,
			totalEstiEffortHrs, totalEstiEffortDays;
	ArrayList<String> tabs2;
	long pageLoadTime_ms;
	float pageLoadTime_sec;

	@BeforeClass
	public void setUp() throws Exception {

		// Launch the Browser
		objUtility = new Utility();
		driver = objUtility.OpenApp(objUtility.getDFDData(1, "Login"), objUtility.getDFDData(2, "Login"));
		Thread.sleep(10000);
		// log into the portal
		if (("Sign In").equalsIgnoreCase(driver.getTitle())) {
			driver = objUtility.dfdLogin(objUtility.getDFDData(3, "Login"));
			Thread.sleep(10000);
		}
		Reporter.log("Entering into the test execution", true);
		Thread.sleep(10000); // to be removed for test portal
		objDFDHomePage = new DFDHomePage(driver);
		objNewSARequestPage = new NewSARequestPage(driver);
		objSIAllocationPage = new SolutionIntegratorAllocationPage(driver);
		objEditSolTeamPage = new EditSolutionTeamPage(driver);
		jse = (JavascriptExecutor) driver;
		stopWatch = new StopWatch();
		actions = new Actions(driver);
		objEditSolTeamPage = new EditSolutionTeamPage(driver);
		wait = new WebDriverWait(driver, 360);
		objNewPropSplstRqstPage = new NewPropSplstRqstPage(driver);
		objCPSEffortEstimatorPage = new CreativePropStudioEffortEstimatorPage(driver);
		objDFDFunctionLibrary = new DFDFunctionLibrary();

	}

	// Open 'Creative Proposal Studio Effort Estimator' from 'New proposal
	// Specialist Request' Page

	@Test(priority = 1, description = "Verification of 'work estimates' link in New Proposal Specialist Request Page")
	public void testCase1() throws Exception {

		
		// Open New Proposal Specialist page
		jse.executeScript("arguments[0].click();", objDFDHomePage.menuLnk);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objDFDHomePage.submitRequestLnk);
		Thread.sleep(1000);
		objDFDHomePage.mpSpecialistLnkn.click();
		Thread.sleep(2000);

		// verify the link for work estimates
		Assert.assertTrue(objNewPropSplstRqstPage.getWorkEstimatesImg.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.getWorkEstimatesLnk.isDisplayed());

		Assert.assertEquals(objNewPropSplstRqstPage.getWorkEstimatesLine.getText(),
				objUtility.getDFDData(1, "CPSEffortEstimator"));
		

	}

	@Test(priority = 2, description = "Verification of 'Creative Proposal Studio Effort Estimator' Page")
	public void testCase2() throws Exception {
		objNewPropSplstRqstPage.getWorkEstimatesLnk.click();
		Thread.sleep(2000);
		// verifying the title of the page

		driver.switchTo().frame(0); // OR driver.switchTo().frame("PCRDynIFrame");
		Assert.assertEquals(objCPSEffortEstimatorPage.pageHeading.getText(),
				objUtility.getDFDData(2, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.totalEstiEffortLbl.getText(),
				objUtility.getDFDData(3, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.indiCompletionDateLbl.getText()
				.contains(objUtility.getDFDData(4, "CPSEffortEstimator")));

		Assert.assertEquals(objCPSEffortEstimatorPage.expandAllLnk.getText(),
				objUtility.getDFDData(5, "CPSEffortEstimator"));

		Assert.assertEquals(objCPSEffortEstimatorPage.resetAllLnk.getText(),
				objUtility.getDFDData(6, "CPSEffortEstimator"));

		Assert.assertEquals(objCPSEffortEstimatorPage.propAuthnContentSec.getText(),
				objUtility.getDFDData(7, "CPSEffortEstimator"));

		Assert.assertEquals(objCPSEffortEstimatorPage.creativeDesignSec.getText(),
				objUtility.getDFDData(8, "CPSEffortEstimator"));

		Assert.assertEquals(objCPSEffortEstimatorPage.solIllustrationSec.getText(),
				objUtility.getDFDData(9, "CPSEffortEstimator"));

		Assert.assertEquals(objCPSEffortEstimatorPage.digiPropsSec.getText(),
				objUtility.getDFDData(10, "CPSEffortEstimator"));

		

	}

	@Test(priority = 3, description = "Verification of 'Proposal Authoring and Content' in Creative Proposal Studio Effort Estimator Page")
	public void testCase3() throws Exception {
		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthnContentSec.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthnContentToolTip.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthnContentResetBtn.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.propAuthnContentToolTip).click().build().perform();
		Thread.sleep(1000);
		Assert.assertEquals(objCPSEffortEstimatorPage.propAuthnContentToolTipTxt.getText(),
				objUtility.getDFDData(11, "CPSEffortEstimator"));

		// Proposal Authoring
		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthoringSec.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.repContentSec.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthoringToolTip.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.propAuthoringToolTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.propAuthoringToolTipTxt.getText(),
				objUtility.getDFDData(12, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.propAuthQues1Lbl.getText(),
				objUtility.getDFDData(13, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.propAuthQues2Lbl.getText(),
				objUtility.getDFDData(14, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.propAuthQues3Lbl.getText(),
				objUtility.getDFDData(15, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthNoOfQuesDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.propAuthIndiDurDays.isDisplayed());

		// Repository Content
		objCPSEffortEstimatorPage.repContentSec.click();
		actions.moveToElement(objCPSEffortEstimatorPage.repContentToolTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.repContentToolTipTxt.getText(),
				objUtility.getDFDData(16, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.repContentQues1Lbl.getText(),
				objUtility.getDFDData(17, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.repContentQues2Lbl.getText(),
				objUtility.getDFDData(18, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.repContentQues3Lbl.getText(),
				objUtility.getDFDData(19, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.repContentNoOfPropsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.repContentEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.repContentDurationDays.isDisplayed());

		

	}

	@Test(priority = 4, description = "Verification of 'Creative Design' in Creative Proposal Studio Effort Estimator Page")
	public void testCase4() throws Exception {
		Assert.assertTrue(objCPSEffortEstimatorPage.creativeDesignSec.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.creativeDsgnToolTip.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.creativeDsgnResetBtn.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.creativeDsgnToolTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.creativeDsgnToolTipTxt.getText(),
				objUtility.getDFDData(20, "CPSEffortEstimator"));
		objCPSEffortEstimatorPage.creativeDesignSec.click();
		Thread.sleep(1000);

		Assert.assertTrue(objCPSEffortEstimatorPage.psvToolHeading.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.viQltyEnhToolHeading.isDisplayed());

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Proposal Story board and Visualization
		Assert.assertTrue(objCPSEffortEstimatorPage.psvToolTip.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.psvToolTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.psvToolTipTxt.getText(),
				objUtility.getDFDData(21, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.psvQues1Lbl.getText(),
				objUtility.getDFDData(22, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.psvQues2Lbl.getText(),
				objUtility.getDFDData(23, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.psvQues3Lbl.getText(),
				objUtility.getDFDData(24, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.psvNoOfSldsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.psvEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.psvIndiDurDays.isDisplayed());

		// Visual Quality Enhancement
		Assert.assertTrue(objCPSEffortEstimatorPage.viQltyEnhToolTip.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.viQltyEnhToolTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.viQltyEnhToolTipTxt.getText(),
				objUtility.getDFDData(25, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.viQltyEnhQues1Lbl.getText(),
				objUtility.getDFDData(26, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.viQltyEnhQues2Lbl.getText(),
				objUtility.getDFDData(27, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.viQltyEnhQues3Lbl.getText(),
				objUtility.getDFDData(28, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.viQltyEnhNoOfSldsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.viQltyEnhEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.viQltyEnhIndiDurDays.isDisplayed());

		

	}

	@Test(priority = 5, description = "Verification of 'Solution Illustration' in Creative Proposal Studio Effort Estimator Page")
	public void testCase5() throws Exception {
		Assert.assertTrue(objCPSEffortEstimatorPage.solIllustrationSec.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.solIllustrationToolTip.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.solIllustrationResetBtn.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.solIllustrationToolTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.solIllustrationToolTipTxt.getText(),
				objUtility.getDFDData(29, "CPSEffortEstimator"));
		objCPSEffortEstimatorPage.solIllustrationSec.click();
		Thread.sleep(1000);

		// Interactive Wireframes
		Assert.assertTrue(objCPSEffortEstimatorPage.intWireFrameHeading.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.intWireFrameTip.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.intWireFrameTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.intWireFrameTipTxt.getText(),
				objUtility.getDFDData(30, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.intWireFrameQues1Lbl.getText(),
				objUtility.getDFDData(31, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.intWireFrameQues2Lbl.getText(),
				objUtility.getDFDData(32, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.intWireFrameQues3Lbl.getText(),
				objUtility.getDFDData(33, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.intWireFrameQues4Lbl.getText(),
				objUtility.getDFDData(34, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.intWireFrameNoOfWFsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.intWireFrameNoOfScrnsDrpdwn2.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.intWireFrameEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.intWireFrameIndiDurDays.isDisplayed());

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Rapid Prototype
		Assert.assertTrue(objCPSEffortEstimatorPage.rpdProtoHeading.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.rpdProtoTip.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.rpdProtoTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.rpdProtoTipTxt.getText(),
				objUtility.getDFDData(35, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.rpdProtoQues1Lbl.getText(),
				objUtility.getDFDData(36, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.rpdProtoQues2Lbl.getText(),
				objUtility.getDFDData(37, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.rpdProtoQues3Lbl.getText(),
				objUtility.getDFDData(38, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.rpdProtoQues4Lbl.getText(),
				objUtility.getDFDData(39, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.rpdProtoNoOfProtosDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.rpdProtoNoOfScrnsDrpdwn2.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.rpdProtoEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.rpdProtoIndiDurDays.isDisplayed());

		// Mock-up Screens
		Assert.assertTrue(objCPSEffortEstimatorPage.mockupScrnsHeading.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.mockupScrnsTip.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.mockupScrnsTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.mockupScrnsTipTxt.getText(),
				objUtility.getDFDData(40, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.mockupScrnsQues1Lbl.getText(),
				objUtility.getDFDData(41, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.mockupScrnsQues2Lbl.getText(),
				objUtility.getDFDData(42, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.mockupScrnsQues3Lbl.getText(),
				objUtility.getDFDData(43, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.mockupScrnsQues4Lbl.getText(),
				objUtility.getDFDData(44, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.mockupScrnsNoOfScrnsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.mockupScrnsExpScrnsDrpdwn2.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.mockupScrnsEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.mockupScrnsIndiDurDays.isDisplayed());

		// User Journey Visualizations
		Assert.assertTrue(objCPSEffortEstimatorPage.usrJrnyVisHeading.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.usrJrnyVisTip.isDisplayed());
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		actions.moveToElement(objCPSEffortEstimatorPage.usrJrnyVisTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.usrJrnyVisTipTxt.getText(),
				objUtility.getDFDData(45, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.usrJrnyVisQues1Lbl.getText(),
				objUtility.getDFDData(46, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.usrJrnyVisQues2Lbl.getText(),
				objUtility.getDFDData(47, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.usrJrnyVisQues3Lbl.getText(),
				objUtility.getDFDData(48, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.usrJrnyVisQues4Lbl.getText(),
				objUtility.getDFDData(49, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.usrJrnyVisNoOfScrnsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.usrJrnyVisExpScrnsDrpdwn2.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.usrJrnyVisEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.usrJrnyVisIndiDurDays.isDisplayed());

		

	}

	@Test(priority = 6, description = "Verification of 'Digitized Proposals' in Creative Proposal Studio Effort Estimator Page")
	public void testCase6() throws Exception {
		Assert.assertTrue(objCPSEffortEstimatorPage.digiPropSec.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.digiPropToolTip.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.digiPropResetBtn.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.digiPropToolTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.digiPropToolTipTxt.getText(),
				objUtility.getDFDData(50, "CPSEffortEstimator"));
		objCPSEffortEstimatorPage.digiPropSec.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Accenture Secure Proposal Viewer
		Assert.assertTrue(objCPSEffortEstimatorPage.aspViewerHeading.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.aspViewerTip.isDisplayed());

		actions.moveToElement(objCPSEffortEstimatorPage.aspViewerTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.aspViewerTipTxt.getText(),
				objUtility.getDFDData(51, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.aspViewerQues1Lbl.getText(),
				objUtility.getDFDData(52, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.aspViewerQues2Lbl.getText(),
				objUtility.getDFDData(53, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.aspViewerQues3Lbl.getText(),
				objUtility.getDFDData(54, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.aspViewerQues4Lbl.getText(),
				objUtility.getDFDData(55, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.aspViewerNoOfScrnsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.aspViewerExpScrnsDrpdwn2.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.aspViewerEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.aspViewerIndiDurDays.isDisplayed());

		// Proposal as Web-App Package
		Assert.assertTrue(objCPSEffortEstimatorPage.PWAPackageHeading.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.PWAPackageTip.isDisplayed());
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		actions.moveToElement(objCPSEffortEstimatorPage.PWAPackageTip).click().build().perform();
		Assert.assertEquals(objCPSEffortEstimatorPage.PWAPackageTipTxt.getText(),
				objUtility.getDFDData(56, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.PWAPackageQues1Lbl.getText(),
				objUtility.getDFDData(57, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.PWAPackageQues2Lbl.getText(),
				objUtility.getDFDData(58, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.PWAPackageQues3Lbl.getText(),
				objUtility.getDFDData(59, "CPSEffortEstimator"));
		Assert.assertEquals(objCPSEffortEstimatorPage.PWAPackageQues4Lbl.getText(),
				objUtility.getDFDData(60, "CPSEffortEstimator"));

		Assert.assertTrue(objCPSEffortEstimatorPage.PWAPackageNoOfScrnsDrpdwn.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.PWAPackageExpScrnsDrpdwn2.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.PWAPackageEstimatesHrs.isDisplayed());
		Assert.assertTrue(objCPSEffortEstimatorPage.PWAPackageIndiDurDays.isDisplayed());

		objCPSEffortEstimatorPage.cancelBtnBottm.click();

		driver.switchTo().defaultContent();

		

	}

	@Test(priority = 7, description = "Verification of Saving estimates in Creative Proposal Studio Effort Estimator Page")
	public void testCase7() throws Exception {

		objDFDFunctionLibrary.fillEffortEstimator(driver, 2); // fill the Estimator for with appropriate values

		Assert.assertTrue(objCPSEffortEstimatorPage.saveBtnBottm.isDisplayed());

		objCPSEffortEstimatorPage.saveBtnBottm.click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.switchTo().alert().getText(), objUtility.getDFDData(61, "CPSEffortEstimator"));

		driver.switchTo().alert().accept();

		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

		totalEstiEffortHrs = objCPSEffortEstimatorPage.totalEstiEffortHrs.getText();

		totalEstiEffortDays = objCPSEffortEstimatorPage.totalEstiEffortDays.getText();

		objCPSEffortEstimatorPage.cancelBtnTop.click();

		driver.switchTo().defaultContent();

		// verifying the estimated hours and days calculated in CPS estimator page with
		// that of Proposal Request Page
		Assert.assertEquals(objNewPropSplstRqstPage.estimatorHrs.getText(), totalEstiEffortHrs);

		Assert.assertEquals(objNewPropSplstRqstPage.estimatorDays.getText(), totalEstiEffortDays);

		

	}

	@Test(priority = 8, description = "Verification of 'Proposal Specialist Request' Submission with Creative Proposal Studio Effort Estimator")
	public void testCase8() throws Exception {
		// fill the Effort Estimator form
		objDFDFunctionLibrary.fillEffortEstimator(driver, 2); // fill the Estimator for with appropriate values
		objCPSEffortEstimatorPage.saveBtnBottm.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		objCPSEffortEstimatorPage.cancelBtnTop.click();
		driver.switchTo().defaultContent();

		// fill the New Proposal Request form
		objDFDFunctionLibrary.fillNewPropSplRqst2(driver, true);

		Thread.sleep(1000);
		objNewPropSplstRqstPage.submitBtn.click();

		Thread.sleep(50000);
		Assert.assertTrue(objUtility.isAlertPresents(driver));
		Reporter.log("The Message:" + driver.switchTo().alert().getText() + " ", true);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		// verify if the estimates Hrs and Days should be reset
		Assert.assertEquals(objNewPropSplstRqstPage.estimatorHrs.getText(), "0");
		Assert.assertEquals(objNewPropSplstRqstPage.estimatorDays.getText(), "0");

		// Again fill the form and check the estimates without submitting
		// fill the Effort Estimator form again
		objDFDFunctionLibrary.fillEffortEstimator(driver, 1); // fill the Estimator for with appropriate values
		objCPSEffortEstimatorPage.saveBtnBottm.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		objCPSEffortEstimatorPage.cancelBtnTop.click();
		driver.switchTo().defaultContent();

		// Navigate to the Proposal page again and check if the estimate Hrs and Days reset
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.submitRequestLnk.click();
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objDFDHomePage.mpSpecialistLnkn);
		Thread.sleep(2000);

		// verify if the estimates Hrs and Days should be reset
		Assert.assertEquals(objNewPropSplstRqstPage.estimatorHrs.getText(), "0");
		Assert.assertEquals(objNewPropSplstRqstPage.estimatorDays.getText(), "0");

	}
	
	@Test(priority = 9, description = "Verification of Overall Total effort in Creative Proposal Studio Effort Estimator")
	public void testCase9() throws Exception {
		//verify that Overall Total effort should be 1.5 times Sum of total effort 
		
		// fill the Effort Estimator form
		objDFDFunctionLibrary.fillEffortEstimator(driver, 2); // fill the Estimator for with appropriate values
		Reporter.log("Filled the Effort Estimator form", true);
		objCPSEffortEstimatorPage.saveBtnBottm.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
	
		Reporter.log("Total Estimates in CPS page: "+Double.parseDouble(objCPSEffortEstimatorPage.totalEstiEffortHrs.getText()),true);
		Reporter.log("Sum of Estimates cpsTotalEstimates of 4 sections in CPS page: "+(1.5*(objCPSEffortEstimatorPage.sumOfCPScatEstiEffortHrs(driver))),true);
		Assert.assertEquals(1.5*(objCPSEffortEstimatorPage.sumOfCPScatEstiEffortHrs(driver)), Double.parseDouble(objCPSEffortEstimatorPage.totalEstiEffortHrs.getText()));
		
		objCPSEffortEstimatorPage.cancelBtnTop.click();
		driver.switchTo().defaultContent();
		
	}
	
	@Test(priority = 10, description = "Verification of Overall Total Duration in Creative Proposal Studio Effort Estimator")
	public void testCase10() throws Exception {
		//Overall Total Duration (Days) should be 1.3 times the longest single duration among all Categories and sub-categories.
		
		// fill the Effort Estimator form
		objDFDFunctionLibrary.fillEffortEstimator(driver, 2); // fill the Estimator for with appropriate values
		Reporter.log("Filled the Effort Estimator form", true);
		objCPSEffortEstimatorPage.saveBtnBottm.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		
		//getting the list of estimation days from all the sub-categories
		Reporter.log("The highest single duration among the sub categories is : "+objUtility.findLargestNumber(objCPSEffortEstimatorPage.subCatEstiDaysList(driver)),true);
		Reporter.log("The total duration of all the categories is : "+Double.parseDouble(objCPSEffortEstimatorPage.totalEstiEffortDays.getText()),true);
		Assert.assertEquals(1.3*(objUtility.findLargestNumber(objCPSEffortEstimatorPage.subCatEstiDaysList(driver))), Double.parseDouble(objCPSEffortEstimatorPage.totalEstiEffortDays.getText()));
		
		objCPSEffortEstimatorPage.cancelBtnTop.click();
		driver.switchTo().defaultContent();
		
	}
	
	@Test(priority = 11, description = "Verification of Indicative date of completion in Creative Proposal Studio Effort Estimator")
	public void testCase11() throws Exception {
		//Indicative date of completion should be calculated with the start date as the next day of the requested date excluding Saturdays & Sundays.
		
		// fill the Effort Estimator form
		objDFDFunctionLibrary.fillEffortEstimator(driver, 2); // fill the Estimator for with appropriate values
		Reporter.log("Filled the Effort Estimator form", true);
		objCPSEffortEstimatorPage.saveBtnBottm.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
		
		Reporter.log("The Indication completion date is shown as :"+objCPSEffortEstimatorPage.indiCompletionDate.getText(),true);
		Reporter.log("The largest duration among the sub-categories is :"+objUtility.findLargestNumber(objCPSEffortEstimatorPage.subCatEstiDaysList(driver))*1.3,true);
		//since, Overall Total Duration should be 1.3 times the longest single duration among all Categories and sub-categories.
		
		if((objUtility.findLargestNumber(objCPSEffortEstimatorPage.subCatEstiDaysList(driver))*1.3%1)!=0) {
			largestSubCatDuration = (int) (objUtility.findLargestNumber(objCPSEffortEstimatorPage.subCatEstiDaysList(driver))*1.3+1);
		} else {
			largestSubCatDuration = (int) (objUtility.findLargestNumber(objCPSEffortEstimatorPage.subCatEstiDaysList(driver))*1.3+0);
		}
		Reporter.log("The calculated Indication completion date is :"+objUtility.addWorkingDays(largestSubCatDuration),true);
		
		Assert.assertEquals(objCPSEffortEstimatorPage.indiCompletionDate.getText(),objUtility.addWorkingDays(largestSubCatDuration));
		
		objCPSEffortEstimatorPage.cancelBtnTop.click();
		driver.switchTo().defaultContent();
		
	}
	
	
	

}

package testDigitalFrontDoor;

import java.awt.Robot;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import digitalFrontDoor_POM.DFDHomePage;
import digitalFrontDoor_POM.DSDCostEstimatorPage;
import digitalFrontDoor_POM.EditSolutionTeamPage;
import digitalFrontDoor_POM.LoginPage;
import digitalFrontDoor_POM.NewPropSplstRqstPage;
import digitalFrontDoor_POM.NewSARequestPage;
import digitalFrontDoor_POM.NewSMErequestPage;
import digitalFrontDoor_POM.SolutionIntegratorAllocationPage;
import utilitiesFunctionLibrary.Utility;

public class DigitalEstimator {
	
	WebDriver driver;
	WebDriverWait wait;
	DFDHomePage objDFDHomePage;
	LoginPage objLoginPage;
	NewSARequestPage objNewSARequestPage;
	NewSMErequestPage objNewSMErequestPage;
	NewPropSplstRqstPage objNewPropSplstRqstPage;
	SolutionIntegratorAllocationPage objSIAllocationPage;
	EditSolutionTeamPage objEditSolTeamPage;
	DSDCostEstimatorPage objDSDCostEstimatorPage;
	Utility objUtility;
	Actions actions;
	Robot robot;
	JavascriptExecutor jse;
	String decryptedPassword, encryptedPassword, userName, dateStr, siMessage, requestNumberMsg, requestNumber, value;
	ArrayList<String> tabs2;

	@BeforeClass
	public void setUp() throws Exception {
		// Launch the Browser
		objUtility = new Utility();
		objUtility.OpenApp("chrome", "https://dfdtest.accenture.com");
		Thread.sleep(20000);
		// log into the portal
		driver = objUtility.dfdLogin("TEST");
		Reporter.log("Entering into the test execution", true);
		Thread.sleep(20000); // to be removed for test portal
		objDFDHomePage = new DFDHomePage(driver);
		objNewSARequestPage = new NewSARequestPage(driver);
		objNewSMErequestPage = new NewSMErequestPage(driver);
		objNewPropSplstRqstPage = new NewPropSplstRqstPage(driver);
		objSIAllocationPage = new SolutionIntegratorAllocationPage(driver);
		objEditSolTeamPage = new EditSolutionTeamPage(driver);
		objDSDCostEstimatorPage = new DSDCostEstimatorPage(driver);
		robot = new Robot();
		jse = (JavascriptExecutor) driver;
	}
	
	@Test(description = "Verification of Page Title in DSD Cost Estimator Page", priority = 1)
	public void testCase1() throws Exception {
		jse.executeScript("arguments[0].scrollIntoView(true);", objDFDHomePage.digiSolDesignToolsExpand);
		jse.executeScript("arguments[0].click();", objDFDHomePage.digiSolDesignToolsExpand);

		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", objDFDHomePage.digiEstimatorsQL);
		jse.executeScript("arguments[0].click();", objDFDHomePage.digiEstimatorsQL);

		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Assert.assertEquals(driver.getTitle(), "DFD-DSD Cost Estimator");
		/*
		 * driver.close(); driver.switchTo().window(tabs2.get(0));
		 */

	}

	@Test(description = "Verification of DSD Cost Estimator Page", priority = 2)
	public void testCase2() throws Exception {

		Assert.assertEquals(objDSDCostEstimatorPage.dsdCostEstimatorDesc.getText(),
				"Digital Solution Design (DSD) is in the process of standardizing the cost estimators used for Digital work. This page lists the recognized and recommended estimators for Digital Projects. Please seek approval from either DSD Tower Leads or the DSD Leadership Team to use any other estimators for Digital projects. In addition, we are developing Resource Planner training & templates to improve consistency and efficiency. Further details and Usage Notes can be found in the supporting Tower pages which will be coming soon.");

		Assert.assertEquals(objDSDCostEstimatorPage.tableColumn1Heading.getText(), "Tower");
		Assert.assertEquals(objDSDCostEstimatorPage.tableColumn2Heading.getText(), "Digital Offering");
		Assert.assertEquals(objDSDCostEstimatorPage.tableColumn3Heading.getText(), "Category");
		Assert.assertEquals(objDSDCostEstimatorPage.tableColumn4Heading.getText(), "Estimator");
		Assert.assertEquals(objDSDCostEstimatorPage.tableColumn5Heading.getText(), "Specialty / Technology");

		Assert.assertEquals(objDSDCostEstimatorPage.tower1Heading.getText(), "Interactive");
		Assert.assertEquals(objDSDCostEstimatorPage.tower2Heading.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.tower3Heading.getText(), "Mobility");

		Assert.assertTrue(objDSDCostEstimatorPage.admEstiInventQL.isDisplayed());
		Assert.assertTrue(objDSDCostEstimatorPage.admEstiRulesThumbQL.isDisplayed());
		Assert.assertTrue(objDSDCostEstimatorPage.faq4AdmEstiQL.isDisplayed());
		Assert.assertTrue(objDSDCostEstimatorPage.admResourcePlnrQL.isDisplayed());

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Assert.assertEquals(objDSDCostEstimatorPage.thankYouNote.getText(),
				"Many thanks to the Tower Leads and the many contributors who provided these recommended standards.");

	}

	@Test(description = "Verification of Interactive Tower in DSD Cost Estimator Page", priority = 3)
	public void testCase3() throws Exception {

		// Digital Offering Column values (Tower - Interactive)
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow1.getText(), "Digital Marketing");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow2.getText(), "Digital Marketing");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow3.getText(), "Digital Marketing");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow4.getText(), "Digital Content Management");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow5.getText(), "Digital Content Management");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow6.getText(), "Digital Content Management");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow7.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow8.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow9.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow10.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow11.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntDigiOfferingRow12.getText(),
				"Digital Customer Experience (Design & Innovation)");

		// Category Column values (Tower - Interactive)
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow1.getText(), "Digital Marketing");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow2.getText(), "Digital Marketing");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow3.getText(), "Digital Marketing");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow4.getText(), "Digital Content Management");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow5.getText(), "Digital Content Management");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow6.getText(), "Digital Content Migration");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow7.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow8.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow9.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow10.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow11.getText(), "Digital Commerce");
		Assert.assertEquals(objDSDCostEstimatorPage.IntCategoryRow12.getText(),
				"Front End Development (FED)\n" + "\n" + "- Includes Responsive Design -");

		// Estimator column data (Tower - Interactive)

		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow1.getText(),
				"Digital Marketing and Campaign Management ROM estimating model - Rough Order of Magnitude model that runs on top of the ROM Estimating Platform with enabled version controlled repository. Currently supports SI aspects only.");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow2.getText(),
				"Content Management (WCM) ROM estimating model - Rough Order of Magnitude model for Content Management that runs on top of the ROM Estimating Platform with enabled version controlled repository.");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow3.getText(),
				"(pre-customised) ADM Packaged Development v3.1.0 - Campaign Management (all except software installations which are estimated in one off Excel)");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow4.getText(),
				"A web-based Content Management V3.1.0 (WCM) BU model – a simplified and streamlined version of the Bottom-up Excel-based ADM Content Management (WCM) estimator (see next item).");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow5.getText(),
				"ADM for Content Management V3.0.0 (WCM) - requires SME input when there are additional components not covered in the inventory");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow6.getText(),
				"Content Migration Estimator DRAFT for V1.0 - Bespoke estimator in the process of being refined");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow7.getText(),
				"ADM Estimator for eCommerce v1.2 - Hybris: a simplified and streamlined web-based version of the existing Excel-based model (see next item).");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow8.getText(),
				"ADM Estimator for eCommerce v1.1.0 - eCommerce - is new as of Nov-2014");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow9.getText(),
				"Digital ROM eCommerce v1.0 - a tool for creating a Rough Order Magnitude estimate for applications based on Hybris eCommerce package. The guidelines for using this estimator can be found here. Please provide feedback on usage and enhancement of this estimator to igor.gordon");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow10.getText(),
				"Digital ROM eCommerce – Magento v1.0 - a Rough Order of Magnitude (ROM) model for estimating projects using Magento packaged software.");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow11.getText(),
				"Emerging Digital eCommerce Estimators - Cloud Craze, DemandWare, and Elastic Path.");
		Assert.assertEquals(objDSDCostEstimatorPage.IntEstimatorRow12.getText(),
				"ADM Estimator for Front End Development v1.0.0 - this estimator is based on the V5.6.0 estimator and is awaiting calibration. It should be used for Acquity & AOWP estimates.\n"
						+ "\n"
						+ "Acquity Group FED Estimation Tool - Acquity solution using this estimator for FED Custom\n"
						+ "\n" + "(pre-customised) ADM Custom Development Estimator V5.6.0 - AOWP\n" + "\n"
						+ "FED estimates are not calculated in the eCommerce or Content Management estimators above, so one of these estimators must be used to estimate the incremental FED effort");

		// checking the link in Estimator column, if they are opening in the new tab

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow1Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow2Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow3Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow4Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow5Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow6Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow7Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow8Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow9Lnk1) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow9Lnk2) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow10Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow11Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow12Lnk1) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow12Lnk2) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.IntEstimatorRow12Lnk3) == 3);

	}

	@Test(description = "Verification of Analytics Tower in DSD Cost Estimator Page", priority = 4)
	public void testCase4() throws Exception {

		// Digital Offering Column values (Tower - Analytics)
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow1.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow2.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow3.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow4.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow5.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow6.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow7.getText(), "Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyDigiOfferingRow8.getText(), "Analytics");

		// Category Column values (Tower - Analytics)
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow1.getText(), "Big Data");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow2.getText(), "Business Intelligence");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow3.getText(), "Business Intelligence");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow4.getText(), "Advanced Analytics");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow5.getText(), "Data Migration");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow6.getText(), "Data Management");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow7.getText(), "Data Management");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyCategoryRow8.getText(),
				"Marketing Analytics – Marketing Mix Modeling");

		// Estimator column data (Tower - Analytics)
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow1.getText(),
				"ADM Big Data Estimator v1.0.0 - a beta version of the estimator that is available on KX. Use guidelines provided along with the estimator to help with the estimating process. Note the guidelines contain a Hadoop setup calculator");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow2.getText(),
				"A web-based Business Intelligence IM BI v2.6.0 BU model – a simplified and streamlined version of the ADM Bottom-up Excel-based Estimator (see next item).");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow3.getText(),
				"IM Business Intelligence Estimator V2.5.0 - For SAP & Oracle use the SAP & Oracle BI Estimators");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow4.getText(),
				"Advanced Analytics Estimation Models used by MC/Business Analytics. Please coordinate with an Advanced Analytics resource for estimation support");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow5.getText(),
				"IM Business Intelligence Estimator V2.5.0");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow6.getText(),
				"For general Data Management, use either bottom-up IM Business Intelligence v2.5.0 (also web-based model – see above) or top-down Data Management Estimator v1.0.0 Early Adopter");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow7.getText(),
				"MDM Estimator and MDM Estimating guidelines – customized AMD Estimator for MDM. The Estimating Guidelines include: MDM architectural patterns, factor definitions, and work item inventory guidelines.");
		Assert.assertEquals(objDSDCostEstimatorPage.AnalyEstimatorRow8.getText(),
				"Marketing Mix Modeling ROM v1.0– a Rough Order of Magnitude (ROM) model for estimating Marketing Mix Modeling projects.");

		// checking the link in Estimator column, if they are opening in the new tab
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow1Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow2Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow3Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow5Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow6Lnk1) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow6Lnk2) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow7Lnk) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.AnalyEstimatorRow8Lnk) == 3);

	}

	@Test(description = "Verification of Mobility Tower in DSD Cost Estimator Page", priority = 5)
	public void testCase5() throws Exception {

		// Digital Offering Column values (Tower - Mobility)
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow1.getText(), "Digital Applications");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow2.getText(), "Digital Applications");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow3.getText(), "Digital Applications");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow4.getText(), "Digital Applications");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow5.getText(), "Digital Applications");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow6.getText(), "Digital Connected Products");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow7.getText(), "Digital Connected Devices");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow8.getText(), "Digital Connected Products");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityDigiOfferingRow9.getText(), "Digital Connected Devices");

		// Category Column values (Tower - Mobility)
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow1.getText(),
				"Digital Applications (Native Mobile)");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow2.getText(),
				"Digital Applications (Native Mobile)");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow3.getText(),
				"Digital Applications (Native and Multi-platform Mobile)");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow4.getText(), "Digital Field Services");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow5.getText(), "Mobile Device Management (MDM)");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow6.getText(), "Digital Connected Products");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow7.getText(), "Embedded Software (Digital)");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow8.getText(), "Fleet Management");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityCategoryRow9.getText(), "Testing & Certification");

		// Estimator column data (Tower - Mobility)
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow1.getText(),
				"Rough Order of Magnitude (ROM) estimating model for Mobile Applications. The model runs on top of the ROM Estimating Platform with enabled version controlled repository.");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow2.getText(),
				"(pre-customised) Distributed Agile Mobility - IDC Customisation V2.1 - This is based on Distributed Agile Sprint Estimator - Mobile V3.1.0 calibrated for Mobility projects. For additional information please contact Alain Arnaud.");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow3.getText(),
				"Mobility Applications t-shirt/ROM v1.0 - a tool for creating a Rough Order Magnitude estimate for Mobility Applications. Both the estimator and the guidelines for using this estimator can be found here. For questions regarding the usage and feedback please contact Jack Stevenson.");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow4.getText(),
				"(pre-customised) Custom Development Estimator V5.6.0 - Has been configured for Click installations - intend to extend it to other areas as work arises. Access is restricted to Field Services SMEs (POC peter.j.daley)");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow5.getText(),
				"One off excel - MDM Managed Service Pricing Tool V19 - Kept in line with CDTS guidance (Q'ly update). Access is restricted to 4 users globally (POC nisha.sharma)");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow6.getText(),
				"ADM Custom Development Estimator V5.6.0 - has been configured to support Embedded Software, DCPP FM SOA-BPM Estimator template v2.3 - has been configured for CPAS (formerly known as DCCP). Access is restricted to members of CPAS team. (POC Gabriele.Andronico). For all other components of the solution refer to the relevant Categories and Specialties in this table.");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow7.getText(),
				"One off excel – Estimators are tailored to each sub-offering. The more mature ones have customised estimators");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow8.getText(),
				"CPaaS - Fleet Management ROM v1.0 - a Rough Order of Magnitude (ROM) model for estimating fleet management operations engagements that are using CPaaS Accenture platform.");
		Assert.assertEquals(objDSDCostEstimatorPage.MobilityEstimatorRow9.getText(),
				"Solution in a Box (SIB) - There are different SIB estimators for each specialty. Access is restricted to Digital Test SMEs (POC anand.vijendra)");

		// checking the link in Estimator column, if they are opening in the new tab
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow1Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow2Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow3Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow4Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow5Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow6Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow8Lnk) == 3);
		Assert.assertTrue(
				objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.MobilityEstimatorRow9Lnk) == 3);

	}

	@Test(description = "Verification of Estimator Quick Links in DSD Cost Estimator Page", priority = 6)
	public void testCase6() throws Exception {
		// Estimator Quick Links text
		Assert.assertEquals(objDSDCostEstimatorPage.admEstiInventryQL.getText(), "ADM Estimator Inventory");
		Assert.assertEquals(objDSDCostEstimatorPage.admEstiRulesThumQL.getText(), "ADM Estimator - Rules of Thumb");
		Assert.assertEquals(objDSDCostEstimatorPage.faq4ADMEstimatorQL.getText(), "FAQ for ADM Estimator");
		Assert.assertEquals(objDSDCostEstimatorPage.admResourcPlnrQL.getText(), "ADM Resource Planner");

		// Estimator Quick Links hyper links
		Assert.assertEquals(objDSDCostEstimatorPage.admEstiInventryQL.getAttribute("href"),
				"https://ads.accenture.com/TopicPages/Estimators/Estimators");
		Assert.assertEquals(objDSDCostEstimatorPage.admEstiRulesThumQL.getAttribute("href"),
				"https://kx.accenture.com/Repositories/ContributionForm.aspx?path=C24/37/68&mode=Read");
		Assert.assertEquals(objDSDCostEstimatorPage.faq4ADMEstimatorQL.getAttribute("href"),
				"https://ads.accenture.com/TopicPages/About/FAQs");
		Assert.assertEquals(objDSDCostEstimatorPage.admResourcPlnrQL.getAttribute("href"),
				"https://software.accenture.com/display.asp?id=2471");

		// checking the link in Estimator column, if they are opening in the new tab
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.admEstiInventryQL) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.admEstiRulesThumQL) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.faq4ADMEstimatorQL) == 3);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDSDCostEstimatorPage.admResourcPlnrQL) == 3);
	}

}

package testDigitalFrontDoor;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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

public class DigitalFrontDoorHome {

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
		objUtility.OpenApp(objUtility.getDFDData(1, "Login"), objUtility.getDFDData(2, "Login"));
		Thread.sleep(20000);
		// log into the portal
		driver = objUtility.dfdLogin(objUtility.getDFDData(3, "Login"));
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

	@Test(description = "Verification of Home page welcome text in Home Page", priority = 1)
	public void testCase1() throws IOException {
		// verifying welcome header and description text
		Assert.assertEquals(objDFDHomePage.welcomeHeader.getText(), objUtility.getDFDData(1, "HomePage"));
		Assert.assertEquals(objDFDHomePage.dfdHeader.getText(), objUtility.getDFDData(2, "HomePage"));
		Assert.assertEquals(objDFDHomePage.dfdPara1.getText(), objUtility.getDFDData(3, "HomePage"));
		Assert.assertEquals(objDFDHomePage.dfdPara2.getText(), objUtility.getDFDData(4, "HomePage"));

	}

	@Test(description = "Verification of Solution Architect in Home Page", priority = 2)
	public void testCase2() throws Exception {
		// verifying the presence of Solution Architect button and it's title
		Assert.assertTrue(objDFDHomePage.solArchBtn.isDisplayed());
		Assert.assertEquals(objDFDHomePage.solArchBtn1.getAttribute("title"), objUtility.getDFDData(5, "HomePage"));
		objDFDHomePage.solArchBtn.click();
		Thread.sleep(5000);

		// Switch to the other tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(1000);
		// verifying the Page header of SA Request page
		Assert.assertEquals(objNewSARequestPage.pageHeader.getText(), objUtility.getDFDData(1, "SARequest"));
		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}

	@Test(description = "Verification of Subject Matter Expert in Home Page", priority = 3)
	public void testCase3() throws Exception {
		// verifying the presence of SME Request button and it's title
		Assert.assertTrue(objDFDHomePage.SMEBtn.isDisplayed());
		Assert.assertEquals(objDFDHomePage.SMEBtn1.getAttribute("title"), objUtility.getDFDData(6, "HomePage"));
		objDFDHomePage.SMEBtn.click();
		Thread.sleep(5000);

		// Switch to the other tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		// verifying the page header of SME Request page
		Assert.assertEquals(objNewSMErequestPage.pageHeader.getText(), objUtility.getDFDData(1, "SMERequest"));
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(1000);

	}

	@Test(description = "Verification of Proposal Request in Home Page", priority = 4)
	public void testCase4() throws Exception {
		// verify the presence of the proposal specialist button and its title
		Assert.assertTrue(objDFDHomePage.pSpecialistBtn.isDisplayed());
		Assert.assertEquals(objDFDHomePage.pSpecialistBtn1.getAttribute("title"), objUtility.getDFDData(7, "HomePage"));
		objDFDHomePage.pSpecialistBtn.click();
		Thread.sleep(5000);

		// Switch to the other tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		// verify the page header of the proposal specialist request page
		Assert.assertEquals(objNewPropSplstRqstPage.pageHeader.getText(), objUtility.getDFDData(1, "PropSplstRequet"));
		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}

	@Test(description = "Verification of Quick Links in Home Page", priority = 5)
	public void testCase5() throws Exception {

		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		Assert.assertEquals(objDFDHomePage.opModelnMethodologyQL.getText(), "Operating Model & Methodology\n"
				+ "DSD Operating Model - for Digital and non-Digital audiences, ADM Digital Solution Design Methodology and LiquidLean ProveIt experimental Prototype to Business Case Methodology.");
		Assert.assertEquals(objDFDHomePage.propSuppnTemplateQL.getText(), "Proposal Support & Templates\n"
				+ "The latest differentiated and reusable Digital proposal content and templates.");
		Assert.assertEquals(objDFDHomePage.digiSolDesignToolsQL.getText(),
				"Digital Solution Design Tools\n" + "Templates and tools used during Solution Design.");

		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		Assert.assertEquals(objDFDHomePage.nonDiginSalesRefMaterQL.getText(), "Non Digital & Sales Reference Material\n"
				+ "Non Digital Offerings, references and templates for Sales Support and Contracting.");
		Assert.assertEquals(objDFDHomePage.newITnSecurityQL.getText(),
				"New IT & Security\n" + "Agile Playbooks, DevOps & Security.");
		Assert.assertEquals(objDFDHomePage.trainingnDevQL.getText(),
				"Training & Development\n" + "DSD Training and DFD Training.");
		Assert.assertEquals(objDFDHomePage.collToolsQL.getText(),
				"Collaboration Tools\n" + "Stay in touch, discuss and find the latest news and material for DSD.");
		Assert.assertEquals(objDFDHomePage.contactsQL.getText(),
				"Contacts\n" + "Teams which may be of use during Solution Design.");

	}

	@Test(description = "Verification of Operating Model & Methodology Quick Links in Home Page", priority = 6)
	public void testCase6() throws Exception {
		// Operating Model & Methodology
		Assert.assertEquals(objDFDHomePage.opModelnMethodologyQLDesc.getText(),
				"DSD Operating Model - for Digital and non-Digital audiences, ADM Digital Solution Design Methodology and LiquidLean ProveIt experimental Prototype to Business Case Methodology.");

		// sub Quick links
		Assert.assertEquals(objDFDHomePage.dsdOpModelOverviewQL.getText(), "DSD Operating Model - Overview");
		Assert.assertEquals(objDFDHomePage.dsdOpModelSolQL.getText(), "DSD Operating Model - Solutioning");
		Assert.assertEquals(objDFDHomePage.adm4DigiSolDesingQL.getText(), "ADM for Digital Solution Design");
		Assert.assertEquals(objDFDHomePage.swivelAlphaMethodQL.getText(), "Swivel Alpha Methodology");
		Assert.assertEquals(objDFDHomePage.accDigiOfferingsQL.getText(), "Accenture Digital Offerings");
		Assert.assertEquals(objDFDHomePage.dsdInnoServicesQL.getText(), "DSD Innovation Services");

		// sub Quick links Description
		Assert.assertEquals(objDFDHomePage.dsdOpModelOverviewDescQL.getText(),
				"Overview of the Digital Solution Design process - intended for Digital and non-Digital audiences.");
		Assert.assertEquals(objDFDHomePage.dsdOpModelSolDescQL.getText(),
				"Detailed Digital Solution Design process primarily for DSD use. It is designed to be read and many of the slides have addition notes.");
		Assert.assertEquals(objDFDHomePage.adm4DigiSolDesingDescQL.getText(),
				"ADM Digital Solution Design Methodology - our core methodology.");
		Assert.assertEquals(objDFDHomePage.swivelAlphaMethodDescQL.getText(),
				"Swivel uses lean startup and experimental prototypes to gather client relevant data and generate a strong value case.");
		Assert.assertEquals(objDFDHomePage.accDigiOfferingsDescQL.getText(),
				"DSD Operating Model - for Digital and non-Digital audiences, ADM Digital Solution Design Methodology, Swivel experimental prototype to Value Case methodology and Accenture Offerings.");
		Assert.assertEquals(objDFDHomePage.dsdInnoServicesDescQL.getText(),
				"Learn about our 4 stages of Innovation Services: Digital Compass, Workshop, ShowMe, ProveIt. Utilizes the Swivel framework.");

		// click on each link and check if its open in a new tab
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.dsdOpModelOverviewQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.dsdOpModelSolQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.adm4DigiSolDesingQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.swivelAlphaMethodQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.accDigiOfferingsQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.dsdInnoServicesQL) == 2);

	}

	@Test(description = "Verification of Proposal Support & Templates Quick Links in Home Page", priority = 7)
	public void testCase7() throws Exception {
		// Proposal Support & Templates
		objDFDHomePage.propSuppnTemplateExpand.click();
		Thread.sleep(1000);

		Assert.assertEquals(objDFDHomePage.propSuppnTemplatesQLDesc.getText(),
				"The latest differentiated and reusable Digital proposal content and templates.");
		// sub Quick links
		Assert.assertEquals(objDFDHomePage.creatPropStudKXQL.getText(), "Creative Proposal Studio KX");
		Assert.assertEquals(objDFDHomePage.clientWinsnSuccessQL.getText(), "Client Wins and Success");
		Assert.assertEquals(objDFDHomePage.digiPropCenRepoQL.getText(), "Digital Proposal Center Repository");
		Assert.assertEquals(objDFDHomePage.accDigiSecPropVwrQL.getText(), "Accenture Digital Secure Proposal Viewer");
		Assert.assertEquals(objDFDHomePage.oneStpShp4PropSprtResQL.getText(),
				"One-Stop-Shop for Proposal Support Resources");
		Assert.assertEquals(objDFDHomePage.accDigiPreTempsQL.getText(), "Accenture Digital Presentation Templates");
		Assert.assertEquals(objDFDHomePage.accDigiBrandWdTmpQL.getText(),
				"Accenture Digital branding in word template");
		Assert.assertEquals(objDFDHomePage.swivelDemoSiteQL.getText(), "Swivel Demonstration Site");
		Assert.assertEquals(objDFDHomePage.dsdInnoCredsQL.getText(), "DSD Innovation Credentials");

		// sub Quick links Description

		Assert.assertEquals(objDFDHomePage.creatPropStudKXDescQL.getText(),
				"Locate the latest differentiated innovative and reusable proposal content.");
		Assert.assertEquals(objDFDHomePage.clientWinsnSuccessDescQL.getText(), "Digital winning stories.");
		Assert.assertEquals(objDFDHomePage.digiPropCenRepoDescQL.getText(),
				"Find the latest DPC materials to support your solution: reusable assets, proposals, training, key contacts and much more.");
		Assert.assertEquals(objDFDHomePage.accDigiSecPropVwrDescQL.getText(),
				"The Accenture Secure Proposal Viewer is a secure digital channel to distribute proposals and responses.");
		Assert.assertEquals(objDFDHomePage.oneStpShp4PropSprtResDescQL.getText(),
				"A one-stop-shop for proposal support. Find links to more than 10 Proposal Teams around Accenture both Geographical (e.g. NA Proposal Response Center) and Functional (e.g. Digital, SAP).");
		Assert.assertEquals(objDFDHomePage.accDigiPreTempsDescQL.getText(),
				"Digital templates for your presentations.");
		Assert.assertEquals(objDFDHomePage.accDigiBrandWdTmpDescQL.getText(),
				"Word Digital template for use in external documents.");
		Assert.assertEquals(objDFDHomePage.swivelDemoSiteDescQL.getText(), "Swivel Demonstration repository.");
		Assert.assertEquals(objDFDHomePage.dsdInnoCredsDescQL.getText(),
				"Find the latest credentials and case studies provided by our DSD Innovation Team. These assets can be used to support future solutions.");

		// click on each link and check if its open in a new tab
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.creatPropStudKXQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.clientWinsnSuccessQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.accDigiSecPropVwrQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.oneStpShp4PropSprtResQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.accDigiPreTempsQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.swivelDemoSiteQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.dsdInnoCredsQL) == 2);

		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", objDFDHomePage.accDigiBrandWdTmpQL);
		jse.executeScript("arguments[0].click();", objDFDHomePage.accDigiBrandWdTmpQL);
		Thread.sleep(2000);

	}

	@Test(description = "Verification of Digital Solution Design Tools Quick Links in Home Page", priority = 8)
	public void testCase8() throws Exception {
		// Proposal Support & Templates
		objDFDHomePage.digiSolDesignToolsQL.click();
		Thread.sleep(1000);

		Assert.assertEquals(objDFDHomePage.digiSolDesignToolsQLDesc.getText(),
				"Templates and tools used during Solution Design.");
		// sub Quick links
		Assert.assertEquals(objDFDHomePage.digiSolPlanTempQL.getText(), "Digital Solution Plan Template");
		Assert.assertEquals(objDFDHomePage.digiRegArchQL.getText(), "Digital Reference Architecture");
		Assert.assertEquals(objDFDHomePage.digiResPlanrsQL.getText(), "Digital Resource Planners");
		Assert.assertEquals(objDFDHomePage.digiEstimatorsQL.getText(), "Digital Estimators");
		Assert.assertEquals(objDFDHomePage.solContiGuidelinesQL.getText(), "Solution Contingency Guidelines");
		Assert.assertEquals(objDFDHomePage.digiShopQL.getText(), "Digital Shop");

		// sub Quick links Description

		Assert.assertEquals(objDFDHomePage.digiSolPlanTempDescQL.getText(),
				"Digital Solution Design templates for DSD solution plans.");
		Assert.assertEquals(objDFDHomePage.digiRegArchDescQL.getText(),
				"Digital Reference Architecture diagrams across multiple Digital capabilities and towers.");
		Assert.assertEquals(objDFDHomePage.digiResPlanrsDescQL.getText(),
				"Sample Digital Resource Planners and associated links.");
		Assert.assertEquals(objDFDHomePage.digiEstimatorsDescQL.getText(),
				"Digital recommended Cost Estimators and Usage Notes.");
		Assert.assertEquals(objDFDHomePage.solContiGuidelinesDescQL.getText(),
				"Standard Solution Contingency Percentage Guidelines (file).");
		Assert.assertEquals(objDFDHomePage.digiShopDescQL.getText(), "Digital Shop.");

		// click on each link and check if its open in a new tab
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiSolPlanTempQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiRegArchQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiResPlanrsQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiEstimatorsQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.solContiGuidelinesQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiShopQL) == 2);

	}

	@Test(description = "Verification of Non Digital & Sales Reference Material Quick Links in Home Page", priority = 9)
	public void testCase9() throws Exception {
		// Non Digital & Sales Reference Material
		objDFDHomePage.nonDiginSalesRefMaterQL.click();
		Thread.sleep(1000);

		Assert.assertEquals(objDFDHomePage.nonDiginSlsRefMatQLDesc.getText(),
				"Non Digital Offerings, references and templates for Sales Support and Contracting.");
		// sub Quick links
		Assert.assertEquals(objDFDHomePage.salesEffectivenessQL.getText(), "Sales Effectiveness");
		Assert.assertEquals(objDFDHomePage.slsNpricingSuppHmeQL.getText(), "Sales and Pricing Support Home");
		Assert.assertEquals(objDFDHomePage.gCFMCtrtDocMgmntQL.getText(), "Global CFM Contract Document Management");
		Assert.assertEquals(objDFDHomePage.solContingencyQL.getText(), "Solution Contingency");
		Assert.assertEquals(objDFDHomePage.slsProfCommQL.getText(), "Sales Professional Community");
		Assert.assertEquals(objDFDHomePage.accDelSuiteQL.getText(), "Accenture Delivery Suite (ADS)");
		Assert.assertEquals(objDFDHomePage.ctdsRq4PriBigDlsQL.getText(), "CTDS Request for Pricing Big Deals");
		Assert.assertEquals(objDFDHomePage.accDelMethdsQL.getText(), "Accenture Delivery Methods");

		// sub Quick links Description
		Assert.assertEquals(objDFDHomePage.salesEffectivenessDescQL.getText(),
				"Key resource to understand Sales Topics, Sales Applications and locate related Sales sites.");
		Assert.assertEquals(objDFDHomePage.slsNpricingSuppHmeDescQL.getText(),
				"This site contains job aids and other materials for Global Pricing System, Manage mySales, and Sales Reporting.");
		Assert.assertEquals(objDFDHomePage.gCFMCtrtDocMgmntDescQL.getText(), "Global CFM contacts and materials.");
		Assert.assertEquals(objDFDHomePage.solContingencyDescQL.getText(), "Solution Contingency Training & Job Aids.");
		Assert.assertEquals(objDFDHomePage.slsProfCommDescQL.getText(), "Support for How we sell at Accenture.");
		Assert.assertEquals(objDFDHomePage.accDelSuiteDescQL.getText(),
				"ADS distils Accenture’s collective experience into an integrated set of components to industrialize both systems and service delivery high performance. Policy 11 mandates the use of Accenture Delivery Methods (ADM).");
		Assert.assertEquals(objDFDHomePage.ctdsRq4PriBigDlsDescQL.getText(),
				"Provides financial leadership and resources focused on the development and approval of large, complex deals.");
		Assert.assertEquals(objDFDHomePage.accDelMethdsDescQL.getText(),
				"Find the appropriate method and tools to guide global teams through tasks and activities to deliver value to our clients.");

		// click on each link and check if its open in a new tab
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.salesEffectivenessQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.slsNpricingSuppHmeQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.gCFMCtrtDocMgmntQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.solContingencyQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.slsProfCommQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.accDelSuiteQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.ctdsRq4PriBigDlsQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.accDelMethdsQL) == 2);

	}

	@Test(description = "Verification of New IT & Security Quick Links in Home Page", priority = 10)
	public void testCase10() throws Exception {
		// New IT & Security
		objDFDHomePage.newITnSecurityQL.click();
		Thread.sleep(1000);

		Assert.assertEquals(objDFDHomePage.newITnSecDesc.getText(), "Agile Playbooks, DevOps & Security.");
		// sub Quick links
		Assert.assertEquals(objDFDHomePage.agilePlayBooksQL.getText(), "Agile Playbooks");
		Assert.assertEquals(objDFDHomePage.protectingAccQL.getText(), "Protecting Accenture");
		Assert.assertEquals(objDFDHomePage.dsdSecTeamQL.getText(), "DSD Security Team");
		Assert.assertEquals(objDFDHomePage.digiArchDesnDelQL.getText(), "Digital Architecture Design and Delivery");
		Assert.assertEquals(objDFDHomePage.digiArchDesnDelEmailQL.getText(),
				"Digital Architecture Design and Delivery email");
		Assert.assertEquals(objDFDHomePage.accDevOpsPlatformQL.getText(), "Accenture DevOps Platform");
		Assert.assertEquals(objDFDHomePage.accDevOpsEmailQL.getText(), "Accenture DevOps email");

		// sub Quick links Description
		Assert.assertEquals(objDFDHomePage.agilePlayBooksDescQL.getText(), "Agile Playbook Collection site.");
		Assert.assertEquals(objDFDHomePage.protectingAccDescQL.getText(),
				"Security news, quick links, resources, information and contacts.");
		Assert.assertEquals(objDFDHomePage.dsdSecTeamDescQL.getText(), "Contact our DSD Security team.");
		Assert.assertEquals(objDFDHomePage.digiArchDesnDelDescQL.getText(),
				"Accenture Digital collaboration, project management and code management services.");
		Assert.assertEquals(objDFDHomePage.digiArchDesnDelEmailDescQL.getText(), "Contact ADD.");
		Assert.assertEquals(objDFDHomePage.accDevOpsPlatformDescQL.getText(),
				"Accenture DevOps Platform and the DevOps Control Services Centre.");
		Assert.assertEquals(objDFDHomePage.accDevOpsEmailDescQL.getText(), "Contact the Accenture DevOps team.");

		// click on each link and check if its open in a new tab

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.agilePlayBooksQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.protectingAccQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiArchDesnDelQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiArchDesnDelEmailQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.accDevOpsPlatformQL) == 2);

		Thread.sleep(1000);
		Assert.assertEquals(objDFDHomePage.dsdSecTeamQL.getAttribute("href"), "mailto:DSD.Security@accenture.com");

		Thread.sleep(1000);
		Assert.assertEquals(objDFDHomePage.accDevOpsEmailQL.getAttribute("href"), "mailto:Digital.ADLM@accenture.com");

	}

	@Test(description = "Verification of Training & Development Quick Links in Home Page", priority = 11)
	public void testCase11() throws Exception {
		// Training & Development
		objDFDHomePage.trainingnDevQL.click();
		Thread.sleep(1000);

		Assert.assertEquals(objDFDHomePage.trainNdevelopDesc.getText(), "DSD Training and DFD Training.");
		// sub Quick links
		Assert.assertEquals(objDFDHomePage.digiAcademyQL.getText(), "Digital Academy");
		Assert.assertEquals(objDFDHomePage.dfdFrntDoorTrainingQL.getText(), "DFD Front Door Training");
		Assert.assertEquals(objDFDHomePage.leadrshpCareersQL.getText(), "Leadership Careers");
		Assert.assertEquals(objDFDHomePage.digiSolDesignAcaQL.getText(), "Digital Solution Designer Academy(A87282)");
		Assert.assertEquals(objDFDHomePage.advDigiSolVirSessQL.getText(),
				"Advanced Digital Solutioning Virtual Session (A11021)");

		// sub Quick links Description
		Assert.assertEquals(objDFDHomePage.digiAcademyDescQL.getText(),
				"Learn more about the Digital training on offer.");
		Assert.assertEquals(objDFDHomePage.dfdFrntDoorTrainingDescQL.getText(),
				"How to use the DFD - useful guide and training material.");
		Assert.assertEquals(objDFDHomePage.leadrshpCareersDescQL.getText(),
				"Accenture Leadership Careers Explorer - provides a clearer sense of career choices, career trajectory and career expectations.");

		// click on each link and check if its open in a new tab

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiAcademyQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.dfdFrntDoorTrainingQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.leadrshpCareersQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiSolDesignAcaQL) == 2);
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.advDigiSolVirSessQL) == 2);

	}

	@Test(description = "Verification of Collaboration Tools Quick Links in Home Page", priority = 12)
	public void testCase12() throws Exception {
		// Collaboration Tools
		objDFDHomePage.collToolsQL.click();
		Thread.sleep(1000);

		Assert.assertEquals(objDFDHomePage.collabToolsDesc.getText(),
				"Stay in touch, discuss and find the latest news and material for DSD.");
		// sub Quick links
		Assert.assertEquals(objDFDHomePage.digiDialogQL.getText(), "Digital Dialogue");
		Assert.assertEquals(objDFDHomePage.dsdYammerQL.getText(), "DSD Yammer");
		Assert.assertEquals(objDFDHomePage.ealaAIcollabFWQL.getText(), "EALA AI Collaboration Framework");
		Assert.assertEquals(objDFDHomePage.strmDesktopAppQL.getText(), "Stream Desktop app");
		Assert.assertEquals(objDFDHomePage.dsdCircleQL.getText(), "DSD Circle");

		// sub Quick links Description
		Assert.assertEquals(objDFDHomePage.digiDialogDescQL.getText(), "Accenture Digital news and updates.");
		Assert.assertEquals(objDFDHomePage.dsdYammerDescQL.getText(),
				"Our discussion forum for exchanging thoughts on specific DSD topics.");
		Assert.assertEquals(objDFDHomePage.ealaAIcollabFWDescQL.getText(),
				"Details and guidance for our teams on the EALA AI Interaction Model and Governance.");
		Assert.assertEquals(objDFDHomePage.strmDesktopAppDescQL.getText(),
				"Click here to install the Stream desktop app.");
		Assert.assertEquals(objDFDHomePage.dsdCircleDescQL.getText(),
				"Our DSD community & people site to Learn, Network, Find.");

		// click on each link and check if its open in a new tab
		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiDialogQL) == 2);

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.dsdYammerQL) == 2);

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.ealaAIcollabFWQL) == 2);

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.strmDesktopAppQL) == 2);

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.dsdCircleQL) == 2);

	}

	@Test(description = "Verification of Contacts Quick Links in Home Page", priority = 13)
	public void testCase13() throws Exception {
		// Contacts
		objDFDHomePage.contactsQL.click();
		Thread.sleep(1000);

		Assert.assertEquals(objDFDHomePage.contactDesc.getText(), "Teams which may be of use during Solution Design.");
		// sub Quick links
		Assert.assertEquals(objDFDHomePage.dsdSecuTeamQL.getText(), "DSD Security Team");
		Assert.assertEquals(objDFDHomePage.rateCardTeamQL.getText(), "Ratecard Team");
		Assert.assertEquals(objDFDHomePage.digiArchDesgnDelEmailQL.getText(),
				"Digital Architecture Design and Delivery email");
		Assert.assertEquals(objDFDHomePage.accDevOpsEmailcQL.getText(), "Accenture DevOps e-mail");
		Assert.assertEquals(objDFDHomePage.ctdsReq4PriBigDlsQL.getText(), "CTDS Request for Pricing Big Deals");
		Assert.assertEquals(objDFDHomePage.digiOrgChrtcQL.getText(), "Digital Organisation Charts");

		// sub Quick links Description
		Assert.assertEquals(objDFDHomePage.dsdSecuTeamDescQL.getText(), "Contact our DSD Security team.");
		Assert.assertEquals(objDFDHomePage.rateCardTeamDescQL.getText(),
				"Request support from the Digital Rate Card support team.");
		Assert.assertEquals(objDFDHomePage.digiArchDesgnDelEmailDescQL.getText(), "Contact ADD.");
		Assert.assertEquals(objDFDHomePage.accDevOpsEmailcDescQL.getText(), "Contact the Accenture DevOps team.");
		Assert.assertEquals(objDFDHomePage.ctdsReq4PriBigDlDescsQL.getText(),
				"Provides financial leadership and resources focused on the development and approval of large, complex deals.");
		Assert.assertEquals(objDFDHomePage.digiOrgChrtcDescQL.getText(),
				"These are some of our organisation charts – others can be found at the DSD Circle.");

		// click on each link and check if its open in a new tab
		Thread.sleep(1000);
		Assert.assertEquals(objDFDHomePage.dsdSecuTeamQL.getAttribute("href"), "mailto:DSD.Security@accenture.com");

		Assert.assertEquals(objDFDHomePage.rateCardTeamQL.getAttribute("href"),
				"mailto:Digital.GlobalRateCardTeam@accenture.com?subject=Rate%20Card%20support%20request%20for:");

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiArchDesgnDelEmailQL) == 2);

		Assert.assertEquals(objDFDHomePage.accDevOpsEmailcQL.getAttribute("href"), "mailto:Digital.ADLM@accenture.com");

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.ctdsReq4PriBigDlsQL) == 2);

		Assert.assertTrue(objUtility.check4NewTabnNavigate(driver, objDFDHomePage.digiOrgChrtcQL) == 2);

	}

	@Test(description = "Verification of Menu in Home Page", priority = 14)
	public void testCase14() throws Exception {
		// Menu
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0, 0)");
		Assert.assertTrue(objDFDHomePage.menuLnk.isDisplayed(), "Menu is displayed");
		objDFDHomePage.menuLnk.click();
		Thread.sleep(1000);
		Assert.assertTrue(objDFDHomePage.mSearchBox.isDisplayed(), "Search box is displayed in Menu");

	}

	@Test(description = "Verification of Home Page link and title in Home Page", priority = 15)
	public void testCase15() throws Exception {
		// Home Page link and title
		if (!(objDFDHomePage.mSearchBox.isDisplayed())) {
			jse.executeScript("window.scrollTo(0, 0)");
			jse.executeScript("arguments[0].scrollIntoView();", objDFDHomePage.menuLnk);
			objDFDHomePage.menuLnk.click();
		}
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "Welcome to the Digital Front Door");

	}

	@Test(description = "Verification of User Name in Home Page", priority = 16)
	public void testCase16() throws Exception {
		// User name
		jse.executeScript("window.scrollTo(0, 0)");
		Assert.assertEquals(objDFDHomePage.userNameLnk.getText(), "Mujeeb Mohammed");
		objDFDHomePage.userNameLnk.click();
		Thread.sleep(1000);
		Assert.assertEquals(objDFDHomePage.logOutLnk.getText(), "Log Out");

	}

	@Test(description = "Verification of Environment Label in Home Page", priority = 17)
	public void testCase17() throws Exception {
		// environment label (This is only for the test environment)
		Assert.assertEquals(objDFDHomePage.envLabel.getText(), "TEST");

	}

	@Test(description = "Verification of Escalations and Feedback in Home Page", priority = 18)
	public void testCase18() throws Exception {
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		Assert.assertTrue(objDFDHomePage.ealaLnk.isDisplayed(), "EALA link is displayed");
		Assert.assertTrue(objDFDHomePage.apacLnk.isDisplayed(), "EALA link is displayed");
		Assert.assertTrue(objDFDHomePage.northAmericaLnk.isDisplayed(), "EALA link is displayed");
		Assert.assertTrue(objDFDHomePage.latinAmericaLnk.isDisplayed(), "EALA link is displayed");
		Assert.assertTrue(objDFDHomePage.gdnLnk.isDisplayed(), "EALA link is displayed");
		Assert.assertTrue(objDFDHomePage.globalLnk.isDisplayed(), "EALA link is displayed");

		Assert.assertEquals(objDFDHomePage.ealaLnk.getAttribute("href"), "mailto:DSD.Operations.EALA@accenture.com");
		Assert.assertEquals(objDFDHomePage.apacLnk.getAttribute("href"), "mailto:DSD.Operations.APAC@accenture.com");
		Assert.assertEquals(objDFDHomePage.northAmericaLnk.getAttribute("href"),
				"mailto:DSD.Operations.NA@accenture.com");
		Assert.assertEquals(objDFDHomePage.latinAmericaLnk.getAttribute("href"),
				"mailto:DSD.Operations.LATAM@accenture.com");
		Assert.assertEquals(objDFDHomePage.gdnLnk.getAttribute("href"), "mailto:DSD.Operations.APAC@accenture.com");
		Assert.assertEquals(objDFDHomePage.globalLnk.getAttribute("href"),
				"mailto:Digital.DFD.TechIssues@accenture.com");

	}

}

package testDigitalFrontDoor;

import java.awt.Robot;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import digitalFrontDoor_POM.DFDHomePage;
import digitalFrontDoor_POM.NewSMErequestPage;
import utilitiesFunctionLibrary.DFDFunctionLibrary;
import utilitiesFunctionLibrary.Utility;

public class SubjectMatterExpertRequest {

	WebDriver driver;
	WebDriverWait wait;
	DFDHomePage objDFDHomePage;
	NewSMErequestPage objNewSMErequestPage;
	DFDFunctionLibrary objDFDFunctionLibrary;
	Utility objUtility;
	Actions actions;
	Robot robot;
	JavascriptExecutor jse;
	String decryptedPassword, encryptedPassword, userName, dateStr, siMessage, requestNumberMsg, requestNumber, value,
			dateSupportRqdBy, selectedDate, cancelMsg;
	int digitalDealSize, calValue;
	ArrayList<String> tabs2;

	@BeforeClass
	public void setUp() throws Exception {

		// Launch the Browser
		objUtility = new Utility();
		objUtility.OpenApp("chrome", "https://dfdtest.accenture.com");
		Thread.sleep(20000);
		// log into the portal
		driver = objUtility.dfdLogin("TEST"); // parameter value as false, since the device is not recognized as
												// registered using automation
		Reporter.log("Entering into the test execution", true);
		Thread.sleep(10000); // to be removed for test portal
		objDFDHomePage = new DFDHomePage(driver);
		objNewSMErequestPage = new NewSMErequestPage(driver);
		objDFDFunctionLibrary = new DFDFunctionLibrary();
		robot = new Robot();
		jse = (JavascriptExecutor) driver;
		wait =  new WebDriverWait(driver, 360);
	}

	@Test(description = "Verification of New Subject Matter Expert (SME) Request", priority = 1)
	public void testCase1() throws Exception {

		jse.executeScript("arguments[0].click();", objDFDHomePage.menuLnk);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objDFDHomePage.submitRequestLnk);
		Thread.sleep(1000);
		objDFDHomePage.mSMELnk.click();
		Thread.sleep(2000);

		// verify title and header of the page
		Assert.assertEquals(objNewSMErequestPage.pageHeader.getText(), "New Subject Matter Expert (SME) Request");
		Assert.assertEquals(driver.getTitle(), "DFD-SME Request");
		Assert.assertEquals(objNewSMErequestPage.pageHeaderImage.getAttribute("width"), "28");
		Assert.assertEquals(objNewSMErequestPage.pageHeaderImage.getAttribute("height"), "28");

		// verify the fieldLabels in the page
		Assert.assertEquals(objNewSMErequestPage.fedOpportFieldLbl.getText(), "Federal Opportunity");
		Assert.assertEquals(objNewSMErequestPage.opportIDFieldLbl.getText(), "Opportunity ID");
		Assert.assertEquals(objNewSMErequestPage.opportNameFieldLbl.getText(), "Opportunity Name *");
		Assert.assertEquals(objNewSMErequestPage.clientNameFieldLbl.getText(), "Client Name *");
		Assert.assertEquals(objNewSMErequestPage.salesStgFieldLbl.getText(), "Sales Stage *");
		Assert.assertEquals(objNewSMErequestPage.overallDealSizeFieldLbl.getText(), "Overall Deal Size($K) *");
		Assert.assertEquals(objNewSMErequestPage.digiAllocFieldLbl.getText(), "Digital Allocation (%) *");
		Assert.assertEquals(objNewSMErequestPage.digiDealSizeFieldLbl.getText(), "Digital Deal Size($K) *");
		Assert.assertEquals(objNewSMErequestPage.operatGrpLbl.getText(), "Operating Group *");
		Assert.assertEquals(objNewSMErequestPage.typeOfSupprtFieldLbl.getText(), "Type of Support *");
		Assert.assertEquals(objNewSMErequestPage.specialityDrpdwnLbl.getText(), "Speciality *");
		Assert.assertEquals(objNewSMErequestPage.subSpltyFieldLbl.getText(), "Sub-Speciality *");
		Assert.assertEquals(objNewSMErequestPage.smeRqdDateFieldLbl.getText(), "SME Required Date *");
		Assert.assertEquals(objNewSMErequestPage.smeLocationFieldLbl.getText(), "SME Location *");
		Assert.assertEquals(objNewSMErequestPage.wbsFieldLbl.getText(), "WBS");
		Assert.assertEquals(objNewSMErequestPage.primaryCntctLbl.getText(), "Primary Contact *");
		Assert.assertEquals(objNewSMErequestPage.addContactFieldLbl.getText(), "Additional Contact");
		Assert.assertEquals(objNewSMErequestPage.technologyLbl.getText(), "Technology *");
		Assert.assertEquals(objNewSMErequestPage.opportDescLbl.getText(), "Opportunity Description *");

		// verify presence of the field elements and check for the display
		Assert.assertTrue(objNewSMErequestPage.fedOpportYesLnk.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.fedOpportNoLnk.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.opportIDField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.fedOpportSearchBtn.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.opportNameField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.clientNameField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.salesStgField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.overallDealSizeField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.digiAllocField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.operatGrpDrpdwn.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.typeOfSupprtDrpdwn.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.specialityDrpdwn.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.subSpecialityDrpdwn.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.smeRqdByDateField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.smeLocationDrpdwn.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.wbsField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.primaryCntctField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.addCntctField.isDisplayed());
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Assert.assertTrue(objNewSMErequestPage.technologyTxtArea.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.opportTxtArea.isDisplayed());

	}

	@Test(description = "Verification of Disable Sending Mail check box in 'New Subject Matter Expert (SME) Request' Page", priority = 2)
	public void testCase2() throws Exception {
		// verifying disable sending Mail check box
		Assert.assertEquals(objNewSMErequestPage.disableSndMailLbl.getText(), "Disable Sending Mail");
		Assert.assertTrue(objNewSMErequestPage.disablesndMailChkBx.isDisplayed());

	}

	@Test(description = "Verification of Submit and Cancel buttons in 'New Subject Matter Expert (SME) Request' Page", priority = 3)
	public void testCase3() throws Exception {
		// Verification of Submit and Cancel buttons
		Assert.assertTrue(objNewSMErequestPage.submitBtn.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.cancelBtn.isDisplayed());

	}

	@Test(description = "Verification of Federal opportunity in 'New Subject Matter Expert (SME) Request' Page", priority = 4)
	public void testCase4() throws Exception {
		// Verification of Federal opportunity
		Assert.assertEquals(objNewSMErequestPage.fedOpportNoLnk.getAttribute("class"), "OFFButtonSel");
		Assert.assertFalse(objNewSMErequestPage.fedOpportYesLnk.getAttribute("class") == "ONButtonSel");
	}

	@Test(description = "Verification of Opportunity ID in 'New Subject Matter Expert (SME) Request' Page", priority = 5)
	public void testCase5() throws Exception {
		// Verification of Opportunity ID
		Assert.assertTrue(objNewSMErequestPage.opportIDField.isDisplayed());
		Assert.assertTrue(objNewSMErequestPage.fedOpportSearchBtn.isDisplayed());
		objNewSMErequestPage.opportIDField.sendKeys("OpportunityID650650");
		objNewSMErequestPage.fedOpportSearchBtn.click();
		Thread.sleep(5000);
		Assert.assertEquals(objNewSMErequestPage.opportIDField.getAttribute("value"), "650650");

		jse.executeScript("arguments[0].click();", objNewSMErequestPage.fedOpportCancelBtn);

		// Entering invalid Opportunity
		objNewSMErequestPage.opportIDField.sendKeys("123456");
		objNewSMErequestPage.fedOpportSearchBtn.click();
		Thread.sleep(5000);

		// Navigating to pop-up to verify the message for invalid Opportunity ID
		Assert.assertEquals(driver.switchTo().alert().getText(),
				"Provided Opportunity id is not found in Digital Front Door database. Please fill other details manually.");
		driver.switchTo().alert().accept();

	}

	@Test(description = "Verification of Opportunity Name in 'New Subject Matter Expert (SME) Request' Page", priority = 6)
	public void testCase6() throws Exception {
		// Verification of Opportunity Name
		Assert.assertTrue(objNewSMErequestPage.opportNameFieldLbl.getText().contains("*"));
		objNewSMErequestPage.opportNameField.sendKeys("abcd1234");
		Assert.assertFalse(objUtility.isAlertPresents(driver)); // to check if there is any alert for using
																// alpha-numeric values
		objNewSMErequestPage.opportNameField.clear();

	}

	@Test(description = "Verification of Client Name in 'New Subject Matter Expert (SME) Request' Page", priority = 7)
	public void testCase7() throws Exception {
		// Verification of Client Name
		Assert.assertTrue(objNewSMErequestPage.clientNameFieldLbl.getText().contains("*"));
		objNewSMErequestPage.clientNameField.sendKeys("abcd1234");
		Assert.assertFalse(objUtility.isAlertPresents(driver)); // to check if there is any alert for using
																// alpha-numeric values
		objNewSMErequestPage.clientNameField.clear();

	}

	@Test(description = "Verification of Sales Stage in 'New Subject Matter Expert (SME) Request' Page", priority = 8)
	public void testCase8() throws Exception {
		// Verification of Sales Stage
		Assert.assertTrue(objNewSMErequestPage.salesStgFieldLbl.getText().contains("*"));
		Assert.assertEquals(objNewSMErequestPage.getSalesStageValue(0), "Not Available");
		Assert.assertEquals(objNewSMErequestPage.getSalesStageValue(1), "0A");
		Assert.assertEquals(objNewSMErequestPage.getSalesStageValue(2), "1");
		Assert.assertEquals(objNewSMErequestPage.getSalesStageValue(3), "2A");
		Assert.assertEquals(objNewSMErequestPage.getSalesStageValue(4), "2B");
		Assert.assertEquals(objNewSMErequestPage.getSalesStageValue(5), "3A");
		Assert.assertEquals(objNewSMErequestPage.getSalesStageValue(6), "3B");

	}

	@Test(description = "Verification of Overall Deal Size in 'New Subject Matter Expert (SME) Request' Page", priority = 9)
	public void testCase9() throws Exception {
		// Verification of Overall Deal Size($k)
		Assert.assertTrue(objNewSMErequestPage.overallDealSizeFieldLbl.getText().contains("*"));
		objNewSMErequestPage.overallDealSizeField.sendKeys("abcd1234");
		Assert.assertEquals(objNewSMErequestPage.overallDealSizeField.getAttribute("value"), "1234");
		Assert.assertFalse(objUtility.isAlertPresents(driver)); // to check if there is any alert for using
																// alpha-numeric values
		objNewSMErequestPage.overallDealSizeField.clear();

	}

	@Test(description = "Verification of Digital Allocation in 'New Subject Matter Expert (SME) Request' Page", priority = 10)
	public void testCase10() throws Exception {
		// Verification of Overall Deal Size($k)
		Assert.assertTrue(objNewSMErequestPage.digiAllocFieldLbl.getText().contains("*"));
		objNewSMErequestPage.digiAllocField.sendKeys("abcd99");
		Assert.assertEquals(objNewSMErequestPage.digiAllocField.getAttribute("value"), "99");
		Thread.sleep(1000);
		objNewSMErequestPage.digiAllocField.clear();
		objNewSMErequestPage.digiAllocField.sendKeys("1000");
		Assert.assertEquals(objNewSMErequestPage.digiAllocField.getAttribute("value"), "100");
		objNewSMErequestPage.digiAllocField.clear();

	}

	@Test(description = "Verification of Digital Deal Size in 'New Subject Matter Expert (SME) Request' Page", priority = 11)
	public void testCase11() throws Exception {
		// Verification of Digital Deal Size($k)

		Assert.assertTrue(objNewSMErequestPage.digiDealSizeFieldLbl.getText().contains("*"));
		objNewSMErequestPage.overallDealSizeField.sendKeys("abcd99");
		Assert.assertEquals(objNewSMErequestPage.overallDealSizeField.getAttribute("value"), "99");
		Thread.sleep(1000);

		driver.navigate().refresh();
		Thread.sleep(1000);

		// enter values in overall deal size and digi allocation %
		objNewSMErequestPage.overallDealSizeField.sendKeys(Integer.toString(objUtility.generateRandomNumber(50, 9999)));
		objNewSMErequestPage.digiAllocField.sendKeys(Integer.toString(objUtility.generateRandomNumber(1, 100)));
		objNewSMErequestPage.wbsField.click();
		Thread.sleep(5000);

		// verifying verifying digital deal size is product of overall allocation and
		// digital allocation
		if (Integer.parseInt(objNewSMErequestPage.overallDealSizeField.getAttribute("value"))
				* Integer.parseInt(objNewSMErequestPage.digiAllocField.getAttribute("value")) >= 50) {

			digitalDealSize = Integer.parseInt(objNewSMErequestPage.digiDealSizeField.getText().substring(5,
					(objNewSMErequestPage.digiDealSizeField.getText().indexOf("K") - 1)));
			// Reporter.log("digitalDealSize :" + digitalDealSize, true);
			calValue = (Integer.parseInt(objNewSMErequestPage.overallDealSizeField.getAttribute("value"))
					* Integer.parseInt(objNewSMErequestPage.digiAllocField.getAttribute("value")));

			if (calValue % 100 < 50) {
				Assert.assertEquals(digitalDealSize, calValue / 100);
			} else if (calValue % 100 >= 50) {
				Assert.assertEquals(digitalDealSize, (calValue / 100) + 1);

			}

		}

	}

	@Test(description = "Verification of Operating Group in 'New Subject Matter Expert (SME) Request' Page", priority = 12)
	public void testCase12() throws Exception {
		// Verification of Operating Group
		Assert.assertEquals(objUtility.defaultSelectValue(objNewSMErequestPage.operatGrpDrpdwn), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getOperatingGrpValue(0), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getOperatingGrpValue(1), "CMT                 ");
		Assert.assertEquals(objNewSMErequestPage.getOperatingGrpValue(2), "FS                  ");
		Assert.assertEquals(objNewSMErequestPage.getOperatingGrpValue(3), "H&PS                ");
		Assert.assertEquals(objNewSMErequestPage.getOperatingGrpValue(4), "PRODUCTS            ");
		Assert.assertEquals(objNewSMErequestPage.getOperatingGrpValue(5), "RES                 ");

	}

	@Test(description = "Verification of  Type of Support in 'New Subject Matter Expert (SME) Request' Page", priority = 13)
	public void testCase13() throws Exception {
		// Verification of Type of Support
		Assert.assertEquals(objUtility.defaultSelectValue(objNewSMErequestPage.typeOfSupprtDrpdwn), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getTypeOfSupprtValue(0), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getTypeOfSupprtValue(1), "Client Meeting/Workshop");
		Assert.assertEquals(objNewSMErequestPage.getTypeOfSupprtValue(2), "PoV/Recommendation");
		Assert.assertEquals(objNewSMErequestPage.getTypeOfSupprtValue(3), "ROM Estimating");
		Assert.assertEquals(objNewSMErequestPage.getTypeOfSupprtValue(4), "Technology Architecture");
		Assert.assertEquals(objNewSMErequestPage.getTypeOfSupprtValue(5), "Others");

	}

	@Test(description = "Verification of Speciality in 'New Subject Matter Expert (SME) Request' Page", priority = 14)
	public void testCase14() throws Exception {
		// Verification of Speciality
		Assert.assertEquals(objUtility.defaultSelectValue(objNewSMErequestPage.specialityDrpdwn), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(0), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(1),
				"(Strategy) Mobility Business Strategy & Consulting                                                                                                                                                      ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(2),
				"Agile Coach                                                                                                                                                                                             ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(3),
				"AIP Platform as a Service                                                                                                                                                                               ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(4),
				"Analytics - Analytics Strategy and Transformation                                                                                                                                                       ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(5),
				"Analytics - Business Intelligence                                                                                                                                                                       ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(6),
				"Analytics - Content Analytics                                                                                                                                                                           ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(7),
				"Analytics - Customer, Marketing and Sales Analytics                                                                                                                                                     ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(8),
				"Analytics - Data Management and Integration                                                                                                                                                             ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(9),
				"Analytics - Enterprise (Finance and Human Capital)                                                                                                                                                      ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(10),
				"Analytics - Fraud and Risk                                                                                                                                                                              ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(11),
				"Analytics - Supply Chain and Operations                                                                                                                                                                 ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(12),
				"Artificial Intelligence - Intelligent Automation                                                                                                                                                        ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(13),
				"Big Data Analytics                                                                                                                                                                                      ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(14),
				"Digital Applications - Enterprise Apps (Field Service, Sales, Industry; Device/App Mgmt)                                                                                                                ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(15),
				"Digital Commerce - B2B and B2C                                                                                                                                                                          ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(16),
				"Digital Content                                                                                                                                                                                         ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(17),
				"Digital Customer Experience (Design & Innovation)                                                                                                                                                       ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(18),
				"Digital Customer Experience (Design & Innovation) - Fjord D&I                                                                                                                                           ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(19),
				"Digital Marketing - Personalization (incl Social and Media)                                                                                                                                             ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(20),
				"Digital Marketing Consulting & Services (Strategy, Brand, Creative, Op Model, Campaign, Enablement)                                                                                                     ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(21),
				"Digital Strategy - Digital Sales, Marketing and Customer Strategy                                                                                                                                       ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(22),
				"Digital Testing - App, Device, and IoT Testing                                                                                                                                                          ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(23),
				"Enterprise Mobility Management                                                                                                                                                                          ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(24),
				"Front End / Custom Web Application Development                                                                                                                                                          ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(25),
				"IX.0 Digital Transactions (Connected Commerce, Blockchain)                                                                                                                                              ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(26),
				"IX.0 IoT Services and Platforms                                                                                                                                                                         ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(27),
				"IX.0 Smart Products and Embedded Solutions                                                                                                                                                              ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(28),
				"Media Management                                                                                                                                                                                        ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(29),
				"Mobile Apps, APIs and Microservices                                                                                                                                                                     ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(30),
				"Mobile Learning                                                                                                                                                                                         ");
		Assert.assertEquals(objNewSMErequestPage.getSpecialityValue(31),
				"Swivel                                                                                                                                                                                                  ");

	}

	@Test(description = "Verification of Sub-Speciality in 'New Subject Matter Expert (SME) Request' Page", priority = 15)
	public void testCase15() throws Exception {
		//Verification of Sub-Speciality	
		//verify if the sub-speciality is disabled if nothing is selected in speciality
		if(objNewSMErequestPage.getSpecialityValue(0)== "--SELECT--" ) {
		Assert.assertFalse(objNewSMErequestPage.specialityDrpdwn.isEnabled());
		}
		
		objNewSMErequestPage.chooseSpeciality(1);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1), "Enterprise Mobile Strategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2), "General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3), "Mobile App Strategy-Enterprise");

		objNewSMErequestPage.chooseSpeciality(2);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Agile Coach");
		
		
		objNewSMErequestPage.chooseSpeciality(3);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General (Includes AIP and AAAP)");
		
		objNewSMErequestPage.chooseSpeciality(4);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(5);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Business Intelligence - General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Cognos");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Data Visualization - General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Data Warehouse & Mart Architecture");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"MicroStrategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Oracle Analytics (includes OBIEE and OAC)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Qlikview");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"SAP Business Objects");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"SAP BW");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"SAP HANA for Analytics");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"SAP Lumira");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(12),"SAS BI/Analytics");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(13),"Spotfire");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(14),"Tableau");
		
		
		objNewSMErequestPage.chooseSpeciality(6);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"A/B and Multivariate Testing ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Adobe Analytics/DTM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Adobe Target");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Customer and Digital Analytics ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Data Management Platforms");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"General / Technology TBD");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Next Best Offer");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"Personalized and Targeted Content");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"Tag Management");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"Test & Learn Strategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"Web Analytics");
		
		objNewSMErequestPage.chooseSpeciality(7);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Causal Forecasting");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"MROI Optimization");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Multi-Channel Attribution");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Pricing and Promotion");
		
		objNewSMErequestPage.chooseSpeciality(8);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Ab Initio");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Data Architecture");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Data Governance");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Data Integration - General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Data Management - General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Data Modeling");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Data Quality");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"IBM Infosphere");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"IBM MDM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"IBM Netezza");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"Informatica");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(12),"Informatica MDM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(13),"MDM (Master Data Management)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(14),"Oracle - Database/Data Services/Engineered Systems");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(15),"Oracle (ODI)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(16),"SAP Data Management (ex: MDG, Data Profiling, Data Migration, EIM)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(17),"Talend");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(18),"Teradata");
		
		objNewSMErequestPage.chooseSpeciality(9);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(10);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(11);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(12);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Advanced Analytics");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Deep Learning");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Deep Learning/Machine Learning");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"IBM Watson");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Image Analytics");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Natural Language Processing");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"Video Analytics");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"Virtual Agent");
		
		objNewSMErequestPage.chooseSpeciality(13);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General (Includes Hadoop, noSQL, etc)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Oracle Big Data");
		
		objNewSMErequestPage.chooseSpeciality(14);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Sales Force Automation");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Workforce Management - ClickSoftware, TOA");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Workforce Management - Custom");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Workforce Management - Oracle MWM / Oracle Realtime Scheduler");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Workforce Management - SAP Syclo");
		
		objNewSMErequestPage.chooseSpeciality(15);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"B2B Commerce Offering Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Cloud Craze");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Custom Digital Commerce Development");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Demandware");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"eCommerce Strategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"General Platorm / Technology Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"IBM WebSphere Commerce (WCS)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"Magento");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"NetSuite");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"Omni Channel eCommerce Offering Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"Oracle Commerce (ATG, Endeca, Web Center Sites)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(12),"Order Management Systems (OMS)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(13),"SAP Hybris");
				
		objNewSMErequestPage.chooseSpeciality(16);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Adam Software");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Adobe AEM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Content / Text Analytics");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Content Migration / Conversion");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Content Production Services and Operations ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Content Strategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"CrownPeak");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"Digital Asset Management");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"Drupal");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"EMC Documentum");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"Enterprise Content Management Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(12),"Enterprise Search & Taxonomy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(13),"Experience Management Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(14),"FileNet");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(15),"General Platform / Technology Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(16),"HP Interwoven");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(17),"Knowledge Management");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(18),"Microsoft Sharepoint/CM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(19),"Oracle Web Center Sites (Fatwire)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(20),"Oracle/Stellent");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(21),"SDL Tridion");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(22),"Sitecore");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(23),"Taxonomy / Information Architecture (unstructured)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(24),"Vignette (OpenText)");
	
		
		objNewSMErequestPage.chooseSpeciality(17);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(18);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(19);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Adobe Social");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Attivio Enterprise Search ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Clarabridge ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Collaboration & Knowledge Management");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"General Platform / Technology Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Jive");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Salesforce Radian6 ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"Social");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"Social Solutions");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"Sprinklr");
		
		objNewSMErequestPage.chooseSpeciality(20);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Adobe Campaign");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Aprimo");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"General Offering Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"General Platform / Technology Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"IBM (Unica)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Loyalty and Rewards Mgmt");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Marketing Op Model / Marketing Resource Management (MRM)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"Marketo");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"Oracle Marketing Cloud (Eloqua)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"Salesforce Marketing Cloud (ExactTarget)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"Workfront");
		
		objNewSMErequestPage.chooseSpeciality(21);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(22);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Connected Device Engineering Testing");
		
		objNewSMErequestPage.chooseSpeciality(23);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Device management");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"General");
		
		objNewSMErequestPage.chooseSpeciality(24);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Development Operations (DevOps)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"General Platform / Technology Support");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Modern Web Develeopment (Angular / Backbone)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Traditional Web Development (Java)");
		
		objNewSMErequestPage.chooseSpeciality(25);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Mobility Managed Services - Connected Vehicle/Telematics");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Mobility Managed Services - Mobile Device Management");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Mobility Managed Services - mTicketing/Transportation Solutions");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Mobility Managed Services - mWallet");
		
		objNewSMErequestPage.chooseSpeciality(26);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(27);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Connected Device Engineering Services");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"Connected Devices - Microsoft IOT");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Connected Home");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Embedded Systems");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Industrial Project Services - Automation");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"Industrial Project Services – Connected Industrial Worker");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Industrial Project Services - MES/MOM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"Industrial Project Services – PLM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"Industrial Software Development");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"Industrial Solutions – Baggage Handling");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"Industrial Solutions – Connected Asset Management");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(12),"Industrial Solutions – Connected Rail");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(13),"Industrial Solutions – Smart Manufacturing");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(14),"Industrial Solutions-IIOT");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(15),"Industrial Testing");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(16),"Service Operations & Optimisation");
		
		
		objNewSMErequestPage.chooseSpeciality(28);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
		objNewSMErequestPage.chooseSpeciality(29);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"Android");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(2),"API Strategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(3),"Apigee & API integration");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(4),"Apigee/API Development");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(5),"Appcelerator");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(6),"ClickSoftware");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(7),"Consumer Mobility Strategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(8),"General / Technology TBD ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(9),"HTML5");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(10),"HTML5 - PhoneGap, Apache Cordova");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(11),"HTML5 - Sencha");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(12),"IBM Worklight");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(13),"iOS");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(14),"Kony ");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(15),"Microsoft Windows  (Tablet & Phone)");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(16),"Mobile App Strategy");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(17),"Oracle MAF");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(18),"SAP Syclo, SMP, Sybase, Fiori UI5");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(19),"SFDC/CRM");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(20),"Testing");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(21),"Wearables");
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(22),"Xamarin");
		
		objNewSMErequestPage.chooseSpeciality(30);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General Mobile Learning");
		
		objNewSMErequestPage.chooseSpeciality(31);
		Thread.sleep(3000);
		Assert.assertEquals(objNewSMErequestPage.getSubSpecialityValue(1),"General");
		
	}
	
	
	@Test(description = "Verification of Verification of SME Required Date  in 'New Subject Matter Expert (SME) Request' Page", priority = 16)
	public void testCase16() throws Exception {
		//Verification of Verification of SME Required Date 
		Assert.assertTrue(objNewSMErequestPage.smeRqdByCalenderImg.isDisplayed());
		objNewSMErequestPage.smeRqdByCalenderImg.click();
		//Verify the Date should be displayed in mm/dd/yyyy format in the field
		Thread.sleep(2000);
		Assert.assertTrue(objNewSMErequestPage.calenderNxtMnthArrow.isDisplayed());
		Thread.sleep(1000);
		objNewSMErequestPage.calenderNxtMnthArrow.click();
		Thread.sleep(1000);
		objNewSMErequestPage.calenderNxtMnthDate.click();
		selectedDate = objNewSMErequestPage.calenderNxtMnthDate.getAttribute("title"); //getting the date from the selection
		Thread.sleep(1000);
		objNewSMErequestPage.primaryCntctField.click();
		dateSupportRqdBy = objNewSMErequestPage.smeRqdByDateField.getAttribute("value"); //getting the date from the field
		Assert.assertEquals(dateSupportRqdBy,objUtility.getmmDDyyDate(selectedDate)); //converting the date from the selection into mmDDyy format and comparing with the field value
		
	}
	
	@Test(description = "Verification of SME Location in 'New Subject Matter Expert (SME) Request' Page", priority = 17)
	public void testCase17() throws Exception {
		// Verification of SME Location
		Assert.assertEquals(objUtility.defaultSelectValue(objNewSMErequestPage.smeLocationDrpdwn), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(0), "--SELECT--");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(1), "Africa");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(2), "ANZ");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(3), "ASEAN");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(4), "ASGR");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(5), "Canada");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(6), "Gallia");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(7), "Greater China");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(8), "Iberia");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(9), "ICEG");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(10), "India");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(11), "Japan");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(12), "Latin America");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(13), "MET");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(14), "Nordic");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(15), "South Korea");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(16), "UK/Ireland");
		Assert.assertEquals(objNewSMErequestPage.getSMELocationValue(17), "USA");

	}
	
	@Test(description = "Verification of 'Primary Contact' in 'New Subject Matter Expert (SME) Request' Page", priority = 18)
	public void testCase18() throws Exception {
		// Primary Contact
		Assert.assertTrue(objNewSMErequestPage.primaryCntctLbl.getText().contains("*"));
		//entering invalid enterprise id with alphabets, numbers, dot and hyphen
		objNewSMErequestPage.primaryCntctField.sendKeys("abcd1234.abcd-");
		Assert.assertEquals(objNewSMErequestPage.primaryCntctField.getAttribute("value"),"abcd.abcd-");
		objNewSMErequestPage.primaryCntctField.clear();
		
		//verifying with the valid enterprise id
		objNewSMErequestPage.primaryCntctField.sendKeys("mujeeb.mohammed");
		Thread.sleep(10000);
		Assert.assertTrue(objNewSMErequestPage.primaryCntctList1.isDisplayed());
		
		objNewSMErequestPage.primaryCntctField.clear();
		Thread.sleep(1000);
		
	}
	
	@Test(description = "Verification of 'Additional Contact' in 'New Subject Matter Expert (SME) Request' Page", priority = 19)
	public void testCase19() throws Exception {
		// Additional Contact
		//entering invalid enterprise id with alphabets, numbers, dot and hyphen
		objNewSMErequestPage.addCntctField.sendKeys("abcd1234.abcd-");
		//Assert.assertEquals(objNewSMErequestPage.addCntctField.getAttribute("value"),"abcd.abcd-");
		objNewSMErequestPage.addCntctField.clear();
		Thread.sleep(1000);
		
		//verifying with the valid enterprise id
		objNewSMErequestPage.addCntctField.sendKeys("mujeeb.mohammed");
		Thread.sleep(10000);
		Assert.assertTrue(objNewSMErequestPage.addCntctList1.isDisplayed());
		
		objNewSMErequestPage.addCntctField.clear();
		
	}
	
	@Test(description = "Verification of 'Technology' in 'New Subject Matter Expert (SME) Request' Page", priority = 20)
	public void testCase20() throws Exception {
		// New Subject Matter Expert (SME) Request
		Assert.assertTrue(objNewSMErequestPage.technologyLbl.getText().contains("*"));
		//verifying the default values
		Assert.assertEquals(objNewSMErequestPage.technologyTxtArea.getAttribute("placeholder"),"If you are not sure on the technology area, please enter it as 'Not Applicable'");
		Assert.assertEquals(objNewSMErequestPage.technologyTxtArea.getAttribute("title"),"If you are not sure on the technology area, please enter it as 'Not Applicable'");
		objNewSMErequestPage.technologyTxtArea.sendKeys("Not Applicable");
		Assert.assertEquals(objNewSMErequestPage.technologyTxtArea.getAttribute("value"),"Not Applicable");
		objNewSMErequestPage.technologyTxtArea.clear();
		objNewSMErequestPage.technologyTxtArea.sendKeys("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		Assert.assertEquals(objNewSMErequestPage.technologyTxtArea.getAttribute("class"), "bordercolor");
		Thread.sleep(1000);
		objNewSMErequestPage.technologyTxtArea.clear();
		objNewSMErequestPage.technologyTxtArea.sendKeys("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		Assert.assertEquals(objNewSMErequestPage.technologyTxtArea.getAttribute("class"), "");
		Thread.sleep(1000);
		objNewSMErequestPage.technologyTxtArea.clear();
		
	}
	
	@Test(description = "Verification of 'Opportunity Description' in 'New Subject Matter Expert (SME) Request' Page", priority = 21)
	public void testCase21() throws Exception {
		// Opportunity Description text area
		Assert.assertTrue(objNewSMErequestPage.opportDescLbl.getText().contains("*"));
		//verifying the default values
		Assert.assertEquals(objNewSMErequestPage.opportTxtArea.getAttribute("placeholder"),"Enter opportunity description and describe the responsibility of the Subject Matter Expert");
		Assert.assertEquals(objNewSMErequestPage.opportTxtArea.getAttribute("title"),"Enter opportunity description and describe the responsibility of the Subject Matter Expert");
		objNewSMErequestPage.opportTxtArea.sendKeys("opportunity description");
		Assert.assertEquals(objNewSMErequestPage.opportTxtArea.getAttribute("value"),"opportunity description");
		Thread.sleep(1000);
		objNewSMErequestPage.opportTxtArea.clear();
		objNewSMErequestPage.opportTxtArea.sendKeys("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		Assert.assertEquals(objNewSMErequestPage.opportTxtArea.getAttribute("class"), "bordercolor");
		objNewSMErequestPage.opportTxtArea.clear();
		Thread.sleep(1000);
		objNewSMErequestPage.opportTxtArea.sendKeys("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		Assert.assertEquals(objNewSMErequestPage.opportTxtArea.getAttribute("class"), "");
		
		objNewSMErequestPage.opportTxtArea.clear();
		
	}	
	
	@Test(description = "Verification of Submit with enable Mail in 'New Subject Matter Expert (SME) Request' Page", priority = 22)
	public void testCase22() throws Exception {
		// Verification of Submit with enable Mail
		objDFDFunctionLibrary.fillNewSMERqst(driver,true);
		Thread.sleep(1000);
		objNewSMErequestPage.submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(objNewSMErequestPage.popTxt));
		requestNumberMsg = objNewSMErequestPage.popTxt.getText();
		
		Reporter.log("The Message:" + requestNumberMsg + " ", true);
		objNewSMErequestPage.popNoBtn.click();
		Thread.sleep(1000);
		requestNumber = requestNumberMsg.substring(54, 65);
		Reporter.log("The Request number is: "+requestNumber,true);
		Assert.assertEquals(requestNumberMsg.substring(0,54),"Request successfully submitted. Your Request number is");
		Assert.assertEquals(requestNumberMsg.substring(69,116),"You will receive communication within 24 hours.");
		
	}

	@Test(description = "Verification of cancel Alert message in 'New Subject Matter Expert (SME) Request' Page", priority = 23)
	public void testCase23() throws Exception {
		// Verification of cancel Alert message
		objDFDFunctionLibrary.fillNewSMERqst(driver,true);
		Thread.sleep(1000);
		
		objNewSMErequestPage.cancelBtn.click();
		//Switching to alert and verifying the text message
		Thread.sleep(1000);
		cancelMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(cancelMsg, "Do you want to cancel?");
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
	}
	
	@Test(description = "Verification of Submit with disable Mail in 'New Subject Matter Expert (SME) Request' Page", priority = 24)
	public void testCase24() throws Exception {
		// Verification of Submit with disable Mail
		objDFDFunctionLibrary.fillNewSMERqst(driver,false);
		Thread.sleep(1000);
		objNewSMErequestPage.submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(objNewSMErequestPage.popTxt));
		requestNumberMsg = objNewSMErequestPage.popTxt.getText();
		
		Reporter.log("The Message:" + requestNumberMsg + " ", true);
		objNewSMErequestPage.popNoBtn.click();
		Thread.sleep(1000);
		requestNumber = requestNumberMsg.substring(54, 65);
		Reporter.log("The Request number is: "+requestNumber,true);
		Assert.assertEquals(requestNumberMsg.substring(0,54),"Request successfully submitted. Your Request number is");
		Assert.assertEquals(requestNumberMsg.substring(69,116),"You will receive communication within 24 hours.");
		
	}
	
}

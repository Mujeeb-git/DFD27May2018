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
import digitalFrontDoor_POM.NewPropSplstRqstPage;
import utilitiesFunctionLibrary.DFDFunctionLibrary;
import utilitiesFunctionLibrary.Utility;

public class ProposalSpecialistRequest {

	WebDriver driver;
	WebDriverWait wait;
	DFDHomePage objDFDHomePage;
	NewPropSplstRqstPage objNewPropSplstRqstPage;
	DFDFunctionLibrary objDFDFunctionLibrary;
	Utility objUtility;
	Actions actions;
	Robot robot;
	JavascriptExecutor jse;
	String decryptedPassword, encryptedPassword, userName, dateStr, siMessage, requestNumberMsg, requestNumber, value, dateSupportRqdBy,selectedDate,cancelMsg;
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
		Thread.sleep(10000); // to be removed for test portal
		objDFDHomePage = new DFDHomePage(driver);
		objNewPropSplstRqstPage = new NewPropSplstRqstPage(driver);
		objDFDFunctionLibrary =new DFDFunctionLibrary(); 
		robot = new Robot();
		jse = (JavascriptExecutor) driver;
	}

	@Test(description = "Verification of New Proposal Specialist Request Page", priority = 1)
	public void testCase1() throws Exception {

		jse.executeScript("arguments[0].click();", objDFDHomePage.menuLnk);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objDFDHomePage.submitRequestLnk);
		Thread.sleep(1000);
		objDFDHomePage.mpSpecialistLnkn.click();
		Thread.sleep(2000);

		// verify title and header of the page
		Assert.assertEquals(objNewPropSplstRqstPage.pageHeader.getText(), "New Proposal Specialist Request");
		Assert.assertEquals(driver.getTitle(), "DFD-Proposal Specialist Request");
		Assert.assertEquals(objNewPropSplstRqstPage.pageHeaderImage.getAttribute("width"), "28");
		Assert.assertEquals(objNewPropSplstRqstPage.pageHeaderImage.getAttribute("height"), "28");

		// verify the fieldLabels in the page
		Assert.assertEquals(objNewPropSplstRqstPage.fedOpportFieldLbl.getText(), "Federal Opportunity");
		Assert.assertEquals(objNewPropSplstRqstPage.opportIDFieldLbl.getText(), "Opportunity ID");
		Assert.assertEquals(objNewPropSplstRqstPage.opportNameFieldLbl.getText(), "Opportunity Name *");
		Assert.assertEquals(objNewPropSplstRqstPage.clientNameFieldLbl.getText(), "Client Name *");
		Assert.assertEquals(objNewPropSplstRqstPage.salesStgFieldLbl.getText(), "Sales Stage *");
		Assert.assertEquals(objNewPropSplstRqstPage.overallDealSizeFieldLbl.getText(), "Overall Deal size ($K) *");
		Assert.assertEquals(objNewPropSplstRqstPage.geoAreaDrpdwnLbl.getText(), "Geographic Area *");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitDrpdwnLbl.getText(), "Geographic Unit *");
		Assert.assertEquals(objNewPropSplstRqstPage.operatGrpLbl.getText(), "Operating Group *");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityDrpdwnLbl.getText(), "Speciality *");
		Assert.assertEquals(objNewPropSplstRqstPage.wbsFieldLbl.getText(), "WBS");
		Assert.assertEquals(objNewPropSplstRqstPage.supportRqdByLbl.getText(), "Support Required by *");
		Assert.assertEquals(objNewPropSplstRqstPage.primaryCntctLbl.getText(), "Primary Contact *");
		Assert.assertEquals(objNewPropSplstRqstPage.technologyLbl.getText(), "Technology *");
		Assert.assertEquals(objNewPropSplstRqstPage.opportDescLbl.getText(), "Opportunity Description *");

		// verify presence of the field elements and check for the display
		Assert.assertTrue(objNewPropSplstRqstPage.getWorkEstimatesImg.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.getWorkEstimatesLnk.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.recentExamplesImg.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.recentExamplesLnk.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.fedOpportYesLnk.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.fedOpportNoLnk.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.opportIDField.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.fedOpportSearchBtn.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.opportNameField.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.clientNameField.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.geoAreaDrpdwn.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.geoUnitDrpdwn.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.operatGrpDrpdwn.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.overallDealSizeField.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.supportRqdByDateField.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.supportRqdByDateField.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.specialityDrpdwn.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.wbsField.isDisplayed());
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Assert.assertTrue(objNewPropSplstRqstPage.technologyTxtArea.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.opportTxtArea.isDisplayed());

	}

	@Test(description = "Verification of Disable Sending Mail check box in 'New Proposal Specialist Request' Page", priority = 2)
	public void testCase2() throws Exception {
		// verifying disable sending Mail check box
		Assert.assertEquals(objNewPropSplstRqstPage.disableSndMailLbl.getText(), "Disable Sending Mail");
		Assert.assertTrue(objNewPropSplstRqstPage.disablesndMailChkBx.isDisplayed());

	}

	@Test(description = "Verification of Submit and Cancel buttons in 'New Proposal Specialist Request' Page", priority = 3)
	public void testCase3() throws Exception {
		// Verification of Submit and Cancel buttons
		Assert.assertTrue(objNewPropSplstRqstPage.submitBtn.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.cancelBtn.isDisplayed());

	}

	@Test(description = "Verification of Federal opportunity in 'New Proposal Specialist Request' Page", priority = 4)
	public void testCase4() throws Exception {
		// Verification of Federal opportunity
		Assert.assertEquals(objNewPropSplstRqstPage.fedOpportNoLnk.getAttribute("class"), "OFFButtonSel");
		Assert.assertFalse(objNewPropSplstRqstPage.fedOpportYesLnk.getAttribute("class") == "ONButtonSel");
	}

	@Test(description = "Verification of Opportunity ID in 'New Proposal Specialist Request' Page", priority = 5)
	public void testCase5() throws Exception {
		// Verification of Opportunity ID
		Assert.assertTrue(objNewPropSplstRqstPage.opportIDField.isDisplayed());
		Assert.assertTrue(objNewPropSplstRqstPage.fedOpportSearchBtn.isDisplayed());
		objNewPropSplstRqstPage.opportIDField.sendKeys("OpportunityID650650");
		objNewPropSplstRqstPage.fedOpportSearchBtn.click();
		Thread.sleep(5000);
		Assert.assertEquals(objNewPropSplstRqstPage.opportIDField.getAttribute("value"), "650650");

		jse.executeScript("arguments[0].click();", objNewPropSplstRqstPage.fedOpportCancelBtn);

		// Entering invalid Opportunity
		objNewPropSplstRqstPage.opportIDField.sendKeys("123456");
		objNewPropSplstRqstPage.fedOpportSearchBtn.click();
		Thread.sleep(5000);

		// Navigating to pop-up to verify the message for invalid Opportunity ID
		Assert.assertEquals(driver.switchTo().alert().getText(),
				"Provided Opportunity id is not found in Digital Front Door database. Please fill other details manually.");
		driver.switchTo().alert().accept();

	}

	@Test(description = "Verification of Opportunity Name in 'New Proposal Specialist Request' Page", priority = 6)
	public void testCase6() throws Exception {
		// Verification of Opportunity Name
		Assert.assertTrue(objNewPropSplstRqstPage.opportNameFieldLbl.getText().contains("*"));
		objNewPropSplstRqstPage.opportNameField.sendKeys("abcd1234");
		Assert.assertFalse(objUtility.isAlertPresents(driver)); // to check if there is any alert for using
																// alpha-numeric values
		objNewPropSplstRqstPage.opportNameField.clear();

	}

	@Test(description = "Verification of Client Name in 'New Proposal Specialist Request' Page", priority = 7)
	public void testCase7() throws Exception {
		// Verification of Client Name
		Assert.assertTrue(objNewPropSplstRqstPage.clientNameFieldLbl.getText().contains("*"));
		objNewPropSplstRqstPage.clientNameField.sendKeys("abcd1234");
		Assert.assertFalse(objUtility.isAlertPresents(driver)); // to check if there is any alert for using
																// alpha-numeric values
		objNewPropSplstRqstPage.clientNameField.clear();

	}
	
	@Test(description = "Verification of Sales Stage in 'New Proposal Specialist Request' Page", priority = 8)
	public void testCase8() throws Exception {
		// Verification of Sales Stage
		Assert.assertTrue(objNewPropSplstRqstPage.salesStgFieldLbl.getText().contains("*"));
		Assert.assertEquals(objNewPropSplstRqstPage.salesStageOptions(0), "Not Available");
		Assert.assertEquals(objNewPropSplstRqstPage.salesStageOptions(1), "0A");
		Assert.assertEquals(objNewPropSplstRqstPage.salesStageOptions(2), "1");
		Assert.assertEquals(objNewPropSplstRqstPage.salesStageOptions(3), "2A");
		Assert.assertEquals(objNewPropSplstRqstPage.salesStageOptions(4), "2B");
		Assert.assertEquals(objNewPropSplstRqstPage.salesStageOptions(5), "3A");
		Assert.assertEquals(objNewPropSplstRqstPage.salesStageOptions(6), "3B");

	}
	
	@Test(description = "Verification of Geographic Area in 'New Proposal Specialist Request' Page", priority = 9)
	public void testCase9() throws Exception {
		// Verification of Geographic Area Options
		Assert.assertEquals(objUtility.defaultSelectValue(objNewPropSplstRqstPage.geoAreaDrpdwn), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.geoAreaOptions(0), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.geoAreaOptions(1), "AAPAC");
		Assert.assertEquals(objNewPropSplstRqstPage.geoAreaOptions(2), "Europe");
		Assert.assertEquals(objNewPropSplstRqstPage.geoAreaOptions(3), "Latin America");
		Assert.assertEquals(objNewPropSplstRqstPage.geoAreaOptions(4), "North America");

	}
	
	@Test(description = "Verification of Geographic Unit in 'New Proposal Specialist Request' Page", priority = 10)
	public void testCase10() throws Exception {
		// Verification of Geographic Unit
		driver.navigate().refresh();
		Thread.sleep(5000);
		Assert.assertFalse(objNewPropSplstRqstPage.geoUnitDrpdwn.isEnabled());
		Assert.assertEquals(objUtility.defaultSelectValue(objNewPropSplstRqstPage.geoUnitDrpdwn), "--SELECT--");

		objNewPropSplstRqstPage.chooseGeoArea(1);// APAC
		Thread.sleep(3000);
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(0), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(1), "Africa");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(2), "ANZ");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(3), "ASEAN");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(4), "Greater China");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(5), "India");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(6), "Japan");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(7), "MET");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(8), "South Korea");

		objNewPropSplstRqstPage.chooseGeoArea(2);// Europe
		Thread.sleep(3000);
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(0), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(1), "ASGR");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(2), "Gallia");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(3), "Iberia");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(4), "ICEG");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(5), "Nordic");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(6), "UK/Ireland");

		objNewPropSplstRqstPage.chooseGeoArea(3);// Latin America
		Thread.sleep(3000);
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(0), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(1), "Latin America");

		objNewPropSplstRqstPage.chooseGeoArea(4);// North America
		Thread.sleep(3000);
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(0), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(1), "Canada");
		Assert.assertEquals(objNewPropSplstRqstPage.geoUnitOptions(2), "USA");

	}
	
	@Test(description = "Verification of Operating Group in 'New Proposal Specialist Request' Page", priority = 11)
	public void testCase11() throws Exception {
		// Verification of Operating Group
		Assert.assertEquals(objUtility.defaultSelectValue(objNewPropSplstRqstPage.operatGrpDrpdwn), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.operatingGrpOptions(0), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.operatingGrpOptions(1), "CMT                 ");
		Assert.assertEquals(objNewPropSplstRqstPage.operatingGrpOptions(2), "FS                  ");
		Assert.assertEquals(objNewPropSplstRqstPage.operatingGrpOptions(3), "H&PS                ");
		Assert.assertEquals(objNewPropSplstRqstPage.operatingGrpOptions(4), "PRODUCTS            ");
		Assert.assertEquals(objNewPropSplstRqstPage.operatingGrpOptions(5), "RES                 ");

	}
	
	@Test(description = "Verification of Overall Deal Size in 'New Proposal Specialist Request' Page", priority = 12)
	public void testCase12() throws Exception {
		// Verification of Overall Deal Size($k)
		Assert.assertTrue(objNewPropSplstRqstPage.overallDealSizeFieldLbl.getText().contains("*"));
		objNewPropSplstRqstPage.overallDealSizeField.sendKeys("abcd1234");
		Assert.assertFalse(objUtility.isAlertPresents(driver)); // to check if there is any alert for using
																// alpha-numeric values
		objNewPropSplstRqstPage.overallDealSizeField.clear();

	}
	
	@Test(description = "Verification of 'Support Required by' in 'New Proposal Specialist Request' Page", priority = 13)
	public void testCase13() throws Exception {
		// Support Required by - Date
		Assert.assertTrue(objNewPropSplstRqstPage.calenderImg.isDisplayed());
		objNewPropSplstRqstPage.calenderImg.click();
		Thread.sleep(1000);
		Assert.assertTrue(objNewPropSplstRqstPage.nextMonthArrw.isDisplayed());
		Thread.sleep(1000);
		objNewPropSplstRqstPage.nextMonthArrw.click();
		Thread.sleep(1000);
		objNewPropSplstRqstPage.nextMonthDate.click();
		selectedDate = objNewPropSplstRqstPage.nextMonthDate.getAttribute("title"); //getting the date from the selection
		Thread.sleep(1000);
		objNewPropSplstRqstPage.primaryCntctField.click();
		dateSupportRqdBy = objNewPropSplstRqstPage.supportRqdByDateField.getAttribute("value"); //getting the date from the field
		Assert.assertEquals(dateSupportRqdBy,objUtility.getmmDDyyDate(selectedDate)); //converting the date from the selection into mmDDyy format and comparing with the field value
		
	}
	
	@Test(description = "Verification of Speciality in 'New Proposal Specialist Request' Page", priority = 14)
	public void testCase14() throws Exception {
		// Verification of Speciality
		Assert.assertEquals(objUtility.defaultSelectValue(objNewPropSplstRqstPage.specialityDrpdwn), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(0), "--SELECT--");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(1), "AIP Platform as a Service                                                                                                                                                                               ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(2), "Analytics - Business Intelligence                                                                                                                                                                       ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(3), "Analytics - Data Management and Integration                                                                                                                                                             ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(4), "Artificial Intelligence - Intelligent Automation                                                                                                                                                        ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(5), "Big Data Analytics                                                                                                                                                                                      ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(6), "Digital Applications - Enterprise Apps (Field Service, Sales, Industry; Device/App Mgmt)                                                                                                                ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(7), "Digital Commerce - B2B and B2C                                                                                                                                                                          ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(8), "Digital Content                                                                                                                                                                                         ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(9), "Digital Customer Experience (Design & Innovation)                                                                                                                                                       ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(10), "Digital Customer Experience (Design & Innovation) - Fjord D&I                                                                                                                                           ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(11), "Digital Marketing - Personalization (incl Social and Media)                                                                                                                                             ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(12), "Digital Marketing Consulting & Services (Strategy, Brand, Creative, Op Model, Campaign, Enablement)                                                                                                     ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(13), "Digital Testing - App, Device, and IoT Testing                                                                                                                                                          ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(14), "Enterprise Mobility Management                                                                                                                                                                          ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(15), "IX.0 Digital Transactions (Connected Commerce, Blockchain)                                                                                                                                              ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(16), "IX.0 IoT Services and Platforms                                                                                                                                                                         ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(17), "IX.0 Smart Products and Embedded Solutions                                                                                                                                                              ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(18), "Mobile Apps, APIs and Microservices                                                                                                                                                                     ");
		Assert.assertEquals(objNewPropSplstRqstPage.specialityOptions(19), "Mobile Learning                                                                                                                                                                                         ");

	}
	
	@Test(description = "Verification of 'Primary Contact' in 'New Proposal Specialist Request' Page", priority = 15)
	public void testCase15() throws Exception {
		// Primary Contact
		Assert.assertTrue(objNewPropSplstRqstPage.primaryCntctLbl.getText().contains("*"));
		//entering invalid enterprise id with alphabets, numbers, dot and hyphen
		objNewPropSplstRqstPage.primaryCntctField.sendKeys("abcd1234.abcd-");
		Assert.assertEquals(objNewPropSplstRqstPage.primaryCntctField.getAttribute("value"),"abcd.abcd-");
		objNewPropSplstRqstPage.primaryCntctField.clear();
		
		//verifying with the valid enterprise id
		objNewPropSplstRqstPage.primaryCntctField.sendKeys("mujeeb.mohammed");
		Thread.sleep(10000);
		Assert.assertTrue(objNewPropSplstRqstPage.primaryCntctFieldValue1.isDisplayed());
		
		objNewPropSplstRqstPage.primaryCntctField.clear();
		
	}
	
	@Test(description = "Verification of 'Technology' in 'New Proposal Specialist Request' Page", priority = 16)
	public void testCase16() throws Exception {
		// Technology text area
		Assert.assertTrue(objNewPropSplstRqstPage.technologyLbl.getText().contains("*"));
		//verifying the default values
		Assert.assertEquals(objNewPropSplstRqstPage.technologyTxtArea.getAttribute("placeholder"),"If you are not sure on the technology area, please enter it as 'Not Applicable'");
		Assert.assertEquals(objNewPropSplstRqstPage.technologyTxtArea.getAttribute("title"),"If you are not sure on the technology area, please enter it as 'Not Applicable'");
		objNewPropSplstRqstPage.technologyTxtArea.sendKeys("Not Applicable");
		Assert.assertEquals(objNewPropSplstRqstPage.technologyTxtArea.getAttribute("value"),"Not Applicable");
		objNewPropSplstRqstPage.technologyTxtArea.clear();
		objNewPropSplstRqstPage.technologyTxtArea.sendKeys("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		Assert.assertEquals(objNewPropSplstRqstPage.technologyTxtArea.getAttribute("class"), "bordercolor");
		Thread.sleep(1000);
		objNewPropSplstRqstPage.technologyTxtArea.clear();
		objNewPropSplstRqstPage.technologyTxtArea.sendKeys("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		Assert.assertEquals(objNewPropSplstRqstPage.technologyTxtArea.getAttribute("class"), "");
		Thread.sleep(1000);
		objNewPropSplstRqstPage.technologyTxtArea.clear();
		
	}
	
	@Test(description = "Verification of 'Opportunity Description' in 'New Proposal Specialist Request' Page", priority = 17)
	public void testCase17() throws Exception {
		// Opportunity Description text area
		Assert.assertTrue(objNewPropSplstRqstPage.opportDescLbl.getText().contains("*"));
		//verifying the default values
		Assert.assertEquals(objNewPropSplstRqstPage.opportTxtArea.getAttribute("placeholder"),"Enter opportunity description and describe the responsibility of Proposal Specialist");
		Assert.assertEquals(objNewPropSplstRqstPage.opportTxtArea.getAttribute("title"),"Enter opportunity description and describe the responsibility of Proposal Specialist");
		objNewPropSplstRqstPage.opportTxtArea.sendKeys("opportunity description");
		Assert.assertEquals(objNewPropSplstRqstPage.opportTxtArea.getAttribute("value"),"opportunity description");
		Thread.sleep(1000);
		objNewPropSplstRqstPage.opportTxtArea.clear();
		objNewPropSplstRqstPage.opportTxtArea.sendKeys("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		Assert.assertEquals(objNewPropSplstRqstPage.opportTxtArea.getAttribute("class"), "bordercolor");
		objNewPropSplstRqstPage.opportTxtArea.clear();
		Thread.sleep(1000);
		objNewPropSplstRqstPage.opportTxtArea.sendKeys("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		Assert.assertEquals(objNewPropSplstRqstPage.opportTxtArea.getAttribute("class"), "");
		
		objNewPropSplstRqstPage.opportTxtArea.clear();
		
	}
	
	@Test(description = "Verification of Submit with enable Mail in 'New Proposal Specialist Request' Page", priority = 18)
	public void testCase18() throws Exception {
		// Verification of Submit with enable Mail
		objDFDFunctionLibrary.fillNewPropSplRqst(driver,true);
		Thread.sleep(1000);
		objNewPropSplstRqstPage.submitBtn.click();
		
		Thread.sleep(50000);
		Assert.assertTrue(objUtility.isAlertPresents(driver));
		requestNumberMsg = driver.switchTo().alert().getText();
		Reporter.log("The Message:" + requestNumberMsg + " ", true);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		requestNumber = requestNumberMsg.substring(54, 65);
		Reporter.log("The Request number is: "+requestNumber,true);
		Assert.assertEquals(requestNumberMsg.substring(0,53),"Request Successfully submitted.Your Request Number is");
		Assert.assertEquals(requestNumberMsg.substring(66),". You will receive communication within 24 hours.");
		
	}

	@Test(description = "Verification of cancel Alert message in 'New Proposal Specialist Request' Page", priority = 19)
	public void testCase19() throws Exception {
		// Verification of cancel Alert message
		objDFDFunctionLibrary.fillNewPropSplRqst(driver,true);
		Thread.sleep(1000);
		
		objNewPropSplstRqstPage.cancelBtn.click();
		//Switching to alert and verifying the text message
		Thread.sleep(1000);
		cancelMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(cancelMsg, "Do you want to cancel?");
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
	}
	
	@Test(description = "Verification of Submit with disable Mail in 'New Proposal Specialist Request' Page", priority = 20)
	public void testCase20() throws Exception {
		// Verification of Submit with disable Mail
		objDFDFunctionLibrary.fillNewPropSplRqst(driver,false);
		Thread.sleep(1000);
		objNewPropSplstRqstPage.submitBtn.click();
		
		Thread.sleep(50000);
		Assert.assertTrue(objUtility.isAlertPresents(driver));
		requestNumberMsg = driver.switchTo().alert().getText();
		Reporter.log("The Message:" + requestNumberMsg + " ", true);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		requestNumber = requestNumberMsg.substring(54, 65);
		Reporter.log("The Request number is: "+requestNumber,true);
		Assert.assertEquals(requestNumberMsg.substring(0,53),"Request Successfully submitted.Your Request Number is");
		Assert.assertEquals(requestNumberMsg.substring(66),". You will receive communication within 24 hours.");
		
	}
		

}

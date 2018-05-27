/**
 * 
 */
package testDigitalFrontDoor;

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

/**
 * @author mujeeb.mohammed
 *
 */
public class SolutionIntegratorAllocationRequest {

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
	SolutionIntegratorAllocationPage objSolutionIntegratorAllocationPage;
	Utility objUtility;
	StopWatch stopWatch;
	Actions actions;
	double cpsTotalEstimates, cpsPACestiHrs, cpsCDestiHrs, cpsSIestiHrs, cpsDPestiHrs, cpsTotalEstiEffortDays;
	int largestSubCatDuration;
	JavascriptExecutor jse;
	String decryptedPassword, encryptedPassword, userName, dateStr, siMessage, requestNumberMsg, requestNumber, value,
			totalEstiEffortHrs, totalEstiEffortDays,selectedFromDate,selectedToDate;
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
		objSolutionIntegratorAllocationPage = new SolutionIntegratorAllocationPage(driver);

	}

	// Open 'Creative Proposal Studio Effort Estimator' from 'New proposal
	// Specialist Request' Page

	@Test(priority = 1, description = "Verification of 'Solution Integrator Allocation' Page")
	public void testCase1() throws Exception {

		// Open 'Solution Integrator Allocation' page
		objDFDHomePage.openSIAllocationPage(driver);

		// Title and header of the page
		Assert.assertEquals(objSIAllocationPage.siAllocHeader.getText(), objUtility.getDFDData(1, "SIAllocation"));
		Assert.assertEquals(driver.getTitle(), objUtility.getDFDData(2, "SIAllocation"));

		// all the filter text boxes/fields, search and clear button
		Assert.assertTrue(objSIAllocationPage.oppIDField.isDisplayed());
		objSIAllocationPage.requestNoBtn.click();
		Thread.sleep(1000);
		Assert.assertTrue(objSIAllocationPage.requestNoField.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.clientNameField.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.specialityFieldBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.geoAreaDrpdwn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.geoUnitDrpdwn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.rqstCreationDateFromFieldBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.rqstCreationDateToFieldBtn.isDisplayed());
		//Assert.assertTrue(objSIAllocationPage.gdnInvolvFieldBtn.isDisplayed()); This is removed as part of this release - May 2018
		Assert.assertTrue(objSIAllocationPage.mainPodNameDrpdwnBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.typeOfSADrpdwnBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.reqStatusFieldBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.roleDrpdwn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.searchBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.clearBtn.isDisplayed());

		// search result grid column labels
		Assert.assertEquals(objSIAllocationPage.requestIDColLbl.getText(), objUtility.getDFDData(3, "SIAllocation"));
		Assert.assertEquals(objSIAllocationPage.oppIDColLbl.getText(), objUtility.getDFDData(4, "SIAllocation"));
		Assert.assertEquals(objSIAllocationPage.clientNameColLbl.getText(), objUtility.getDFDData(5, "SIAllocation"));
		Assert.assertEquals(objSIAllocationPage.oppNameColLbl.getText(), objUtility.getDFDData(6, "SIAllocation"));
		Assert.assertEquals(objSIAllocationPage.specialityColLbl.getText(), objUtility.getDFDData(7, "SIAllocation"));
		//Assert.assertEquals(objSIAllocationPage.mainPodColLbl.getText(), objUtility.getDFDData(8, "SIAllocation")); //to be uncommented after the defect fix
		Assert.assertEquals(objSIAllocationPage.geoAreaUntColLbl.getText(), objUtility.getDFDData(9, "SIAllocation"));
		Assert.assertEquals(objSIAllocationPage.submsnDateColLbl.getText(), objUtility.getDFDData(10, "SIAllocation"));
		Assert.assertEquals(objSIAllocationPage.rqstStatusColLbl.getText(), objUtility.getDFDData(11, "SIAllocation"));

		Assert.assertTrue(objSIAllocationPage.pagination.isDisplayed());

		// SI Allocation pop-up window
		Assert.assertTrue(objSIAllocationPage.editBtn.isDisplayed());
		objSIAllocationPage.editBtn.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Assert.assertTrue(objSIAllocationPage.solIntegratorField.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.gdnLeadSDField.isDisplayed());
		objSIAllocationPage.closeBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

	}

	@Test(priority = 2, description = "Verification of Opp ID/ Request No in 'Solution Integrator Allocation' Page")
	public void testCase2() throws Exception {
		// Open 'Solution Integrator Allocation' page
		if (!driver.getTitle().equalsIgnoreCase(objUtility.getDFDData(2, "SIAllocation")))
			objDFDHomePage.openSIAllocationPage(driver);

		// verifying the button and fields by default
		Assert.assertTrue(objSIAllocationPage.oppIDBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.oppIDField.isDisplayed());
		Assert.assertEquals(objSIAllocationPage.oppIDField.getAttribute("placeholder"),
				objUtility.getDFDData(12, "SIAllocation"));
		Assert.assertTrue(objSIAllocationPage.requestNoBtn.isDisplayed());
		Assert.assertFalse(objSIAllocationPage.requestNoField.isDisplayed());
		objSIAllocationPage.oppIDField.sendKeys("OpportunityID650650");
		Thread.sleep(1000);
		Assert.assertEquals(objSIAllocationPage.oppIDField.getAttribute("value"), "650650");

		jse.executeScript("arguments[0].click();", objSIAllocationPage.requestNoBtn);
		Thread.sleep(1000);

		// verifying the button and fields after clicking on request no. button
		Assert.assertTrue(objSIAllocationPage.oppIDBtn.isDisplayed());
		Assert.assertFalse(objSIAllocationPage.oppIDField.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.requestNoBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.requestNoField.isDisplayed());
		Assert.assertEquals(objSIAllocationPage.requestNoField.getAttribute("placeholder"),
				objUtility.getDFDData(13, "SIAllocation"));

		objSIAllocationPage.requestNoField.sendKeys("opportunityID65065012345");
		Thread.sleep(1000);
		Assert.assertEquals(objSIAllocationPage.requestNoField.getAttribute("value"), "65065012345");

		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objSIAllocationPage.oppIDBtn);

		// search with an Opp. ID
		objSIAllocationPage.oppIDField.sendKeys("111111");
		objSIAllocationPage.searchBtn.click();
		Thread.sleep(2000);

		while (!objSIAllocationPage.isGridPresent(driver)) {
			Assert.assertTrue(objSIAllocationPage.noDealMsg.getText()
					.equalsIgnoreCase(objUtility.getDFDData(14, "SIAllocation").toString()));
			objSIAllocationPage.oppIDField.clear();
			Thread.sleep(1000);
			objSIAllocationPage.oppIDField.sendKeys(objUtility.getDFDData(15, "SIAllocation"));// provide the Opp.ID
																								// here for the request
																								// assigned on your name
			objSIAllocationPage.searchBtn.click();
			Thread.sleep(1000);
			if (objSIAllocationPage.isGridPresent(driver))
				break;
		}

		objSIAllocationPage.clearBtn.click();
		Thread.sleep(5000);
	}

	@Test(priority = 3, description = "Verification of Client name in 'Solution Integrator Allocation' Page")
	public void testCase3() throws Exception {

		// Open 'Solution Integrator Allocation' page
		if (!driver.getTitle().equalsIgnoreCase(objUtility.getDFDData(2, "SIAllocation")))
			objDFDHomePage.openSIAllocationPage(driver);

		// Verification of Client Name
		objSIAllocationPage.clientNameField.sendKeys(objUtility.getDFDData(16, "SIAllocation"));
		Thread.sleep(1000);
		objSIAllocationPage.clientNameFieldLst1.click();
		Assert.assertEquals(objSIAllocationPage.clientNameField.getAttribute("value"),
				objUtility.getDFDData(16, "SIAllocation"));
		objSIAllocationPage.clientNameDismissBtn1.click();
		Thread.sleep(1000);

	}

	@Test(priority = 4, description = "Verification of Speciality in 'Solution Integrator Allocation' Page")
	public void testCase4() throws Exception {

		// Open 'Solution Integrator Allocation' page
		if (!driver.getTitle().equalsIgnoreCase(objUtility.getDFDData(2, "SIAllocation")))
			objDFDHomePage.openSIAllocationPage(driver);
		objSIAllocationPage.specialityFieldBtn.click();
		Thread.sleep(1000);
		Assert.assertTrue(objSIAllocationPage.specialityCheckAllBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.specialityUncheckAllBtn.isDisplayed());
		objSIAllocationPage.specialityFieldBtn.click();

		// verify the speciality options
		for (int i = 0; i < (objSIAllocationPage.noOfSpeciality()); i++) {
			Assert.assertEquals(objSIAllocationPage.getSpecialityValue(i),
					objUtility.getDFDData((17 + i), "SIAllocation"));
		}
		Thread.sleep(1000);

		// check few options
		int j = objUtility.generateRandomNumber(3, 10);
		Reporter.log("The number of specialities to be selected is : " + j, true);
		for (int k = 0; k < j; k++) {
			objSIAllocationPage.selectSpeciality(k);
		}
		Assert.assertEquals(objSIAllocationPage.specialityFieldValue.getAttribute("innerText"), j + " selected");
		Thread.sleep(1000);
		objSIAllocationPage.clientNameColLbl.click();
		objSIAllocationPage.specialityFieldBtn.click();
		Thread.sleep(1000);
		objSIAllocationPage.specialityUncheckAllBtn.click();
		Thread.sleep(5000);

		// check the selected speciality records are displayed in the result grid
		objSIAllocationPage.selectSpeciality(objUtility.getDFDData(54, "SIAllocation"));
		objSIAllocationPage.searchBtn.click();
		Thread.sleep(10000);
		for (int x = 0; x < objSIAllocationPage.resultGridNoOfRows.size() - 1; x++) {
			Assert.assertEquals(objSIAllocationPage.gridRowSpeciality(x), objUtility.getDFDData(54, "SIAllocation"));
		}

		objSIAllocationPage.specialityFieldBtn.click();
		Thread.sleep(2000);
		objSIAllocationPage.specialityCheckAllBtn.click();
		Thread.sleep(1000);
		objSIAllocationPage.searchBtn.click();
		Thread.sleep(10000);
		objSIAllocationPage.specialityUncheckAllBtn.click();

	}

	@Test(priority = 5, description = "Verification of Geographic Area in 'Solution Integrator Allocation' Page")
	public void testCase5() throws Exception {
		// Open 'Solution Integrator Allocation' page
		if (!driver.getTitle().equalsIgnoreCase(objUtility.getDFDData(2, "SIAllocation")))
			objDFDHomePage.openSIAllocationPage(driver);

		// Verification of Geographic Area Options
		Assert.assertEquals(objUtility.defaultSelectValue(objSIAllocationPage.geoAreaDrpdwn), "--Select--");
		Assert.assertEquals(objSIAllocationPage.geoAreaOptions(0), "--Select--");
		Assert.assertEquals(objSIAllocationPage.geoAreaOptions(1), (objUtility.getDFDData(55, "SIAllocation")));
		Assert.assertEquals(objSIAllocationPage.geoAreaOptions(2), (objUtility.getDFDData(56, "SIAllocation")));
		Assert.assertEquals(objSIAllocationPage.geoAreaOptions(3), (objUtility.getDFDData(57, "SIAllocation")));
		Assert.assertEquals(objSIAllocationPage.geoAreaOptions(4), (objUtility.getDFDData(58, "SIAllocation")));

	}

	@Test(priority = 6, description = "Verification of Geographic Unit in 'Solution Integrator Allocation' Page")
	public void testCase6() throws Exception {
		// Open 'Solution Integrator Allocation' page
		if (!driver.getTitle().equalsIgnoreCase(objUtility.getDFDData(2, "SIAllocation")))
			objDFDHomePage.openSIAllocationPage(driver);

		// Verification of Geographic Unit and it's options

		objSIAllocationPage.chooseGeoArea(1);// APAC
		Thread.sleep(3000);
		for (int i = 0; i < objSIAllocationPage.geoUnitNoOfOptions(); i++) {
			Assert.assertEquals(objSIAllocationPage.geoUnitOptions(i),
					(objUtility.getDFDData((59 + i), "SIAllocation")));
		}

		objSIAllocationPage.chooseGeoArea(2);// Europe
		Thread.sleep(3000);
		for (int j = 0; j < objSIAllocationPage.geoUnitNoOfOptions(); j++) {
			Assert.assertEquals(objSIAllocationPage.geoUnitOptions(j),
					(objUtility.getDFDData((67 + j), "SIAllocation")));
		}

		objSIAllocationPage.chooseGeoArea(3);// Latin America
		Thread.sleep(3000);
		Assert.assertEquals(objSIAllocationPage.geoUnitOptions(0), (objUtility.getDFDData(73, "SIAllocation")));

		objSIAllocationPage.chooseGeoArea(4);// North America
		Thread.sleep(3000);
		Assert.assertEquals(objSIAllocationPage.geoUnitOptions(0), (objUtility.getDFDData(74, "SIAllocation")));
		Assert.assertEquals(objSIAllocationPage.geoUnitOptions(1), (objUtility.getDFDData(75, "SIAllocation")));

		// check if the grid is shown by selecting a geo unit
		objSIAllocationPage.chooseGeoArea(objUtility.getDFDData(76, "SIAllocation"));
		Thread.sleep(2000);
		objSIAllocationPage.selectGeoUnit(objUtility.getDFDData(77, "SIAllocation"));
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objSIAllocationPage.searchBtn);
		Thread.sleep(10000);
		for (int x = 0; x < objSIAllocationPage.resultGridNoOfRows.size() - 1; x++) {
			Assert.assertEquals(objSIAllocationPage.gridGeoAreaUnit(x), objUtility.getDFDData(76, "SIAllocation")+" - "+objUtility.getDFDData(77, "SIAllocation"));
		}
		objSIAllocationPage.geoUnitDrpdwnBtn.click();
		Thread.sleep(1000);
		
		// verifying checkAll and Un-check all buttons
		objSIAllocationPage.geoUnitDrpdwnBtn.click();
		Thread.sleep(2000);
		objSIAllocationPage.geoUnitCheckAllBtn.click();
		Thread.sleep(1000);
		objSIAllocationPage.geoUnitUncheckAllBtn.click();
		objSIAllocationPage.chooseGeoArea(0);// set back to default
	}
	
	@Test(priority = 7, description = "Verification of Request Creation Date in 'Solution Integrator Allocation' Page")
	public void testCase7() throws Exception {
		// Open 'Solution Integrator Allocation' page
		if (!driver.getTitle().equalsIgnoreCase(objUtility.getDFDData(2, "SIAllocation")))
			objDFDHomePage.openSIAllocationPage(driver);
		
		//verify Request Creation Date (From and To) fields and images
		Assert.assertTrue(objSIAllocationPage.rqstCreationDateFromFieldBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.rqstCreationDateToFieldBtn.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.rqstCreationDateFromImg.isDisplayed());
		Assert.assertTrue(objSIAllocationPage.rqstCreationDateToImg.isDisplayed());
		
		//select date - From
		objSIAllocationPage.rqstCreationDateFromImg.click();
		Thread.sleep(1000);
		objSIAllocationPage.rqstCreationDateFromNxtMnthArrow.click();
		Thread.sleep(1000);
		selectedFromDate = objSIAllocationPage.rqstCreationDateFromMnthDate.getAttribute("title");//getting the date from the selection
		objSIAllocationPage.rqstCreationDateFromMnthDate.click();
		
		//select date - To
		objSIAllocationPage.rqstCreationDateToImg.click();
		Thread.sleep(1000);
		selectedToDate = objSIAllocationPage.rqstCreationDateToMnthDate.getAttribute("title"); //getting the date from the selection
		objSIAllocationPage.rqstCreationDateToMnthDate.click(); //selecting current month date to check for alert message
		
		//verify the selected date is in mm/dd/yyyy format, also checking the alert message
		Assert.assertEquals(objSIAllocationPage.rqstCreationDateFromFieldBtn.getAttribute("value"),objUtility.getmmDDyyDate(selectedFromDate)); //converting the date from the selection into mmDDyy format and comparing with the field value
		Assert.assertEquals(objSIAllocationPage.rqstCreationDateToFieldBtn.getAttribute("value"),objUtility.getmmDDyyDate(selectedToDate)); //converting the date from the selection into mmDDyy format and comparing with the field value
		objSIAllocationPage.searchBtn.click();
		Thread.sleep(1000);
		Assert.assertTrue(objUtility.isAlertPresents(driver));
		Assert.assertEquals(driver.switchTo().alert().getText(),objUtility.getDFDData(78, "SIAllocation"));
		driver.switchTo().alert().accept();
		objSIAllocationPage.rqstCreationDateFromClrBtn.click();
		objSIAllocationPage.rqstCreationDateToClrBtn.click();
		
		//verify the selected date results are displayed with the correct date
		Reporter.log("The selected date is "+objUtility.getDFDData(79	, "SIAllocation").toString(),true);
		objSIAllocationPage.selectRqCrDateFrom(objUtility.getDFDData(79	, "SIAllocation").toString());
		objSIAllocationPage.selectRqCrDateTo(objUtility.getDFDData(79	, "SIAllocation").toString());
		objSIAllocationPage.searchBtn.click();
		Thread.sleep(5000);
		for (int x = 0; x < objSIAllocationPage.resultGridNoOfRows.size() - 1; x++) {
			Assert.assertEquals(objSIAllocationPage.gridReqCreationDate(x), objUtility.getddMMMyyy(objUtility.getDFDData(79, "SIAllocation")));
		}
		
		
	}
	
	
	
	

}

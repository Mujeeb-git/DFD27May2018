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
import digitalFrontDoor_POM.DSDCostEstimatorPage;
import digitalFrontDoor_POM.EditSolutionTeamPage;
import digitalFrontDoor_POM.LoginPage;
import digitalFrontDoor_POM.NewPropSplstRqstPage;
import digitalFrontDoor_POM.NewSARequestPage;
import digitalFrontDoor_POM.NewSMErequestPage;
import digitalFrontDoor_POM.SolutionIntegratorAllocationPage;
import utilitiesFunctionLibrary.Utility;

public class SolutionArchitectRequest {

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
		driver = objUtility.dfdLogin("TEST"); //false, since the device is registered to Symantec
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
		wait=new WebDriverWait(driver,120);
	}

	@Test(description = "Verification of New Solution Architect (SA) Request Page", priority = 1)
	public void testCase1() throws Exception {
		// New Solution Architect (SA) Request
		objDFDHomePage.menuLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.submitRequestLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSolArchLnk.click();
		Thread.sleep(3000);
		
		objNewSARequestPage.fillSARqstWithMMSid(driver);
		objNewSARequestPage.submitBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Reporter.log("Alert Message: "+"\n"+driver.switchTo().alert().getText(),true);
		driver.switchTo().alert().accept();

	}


}

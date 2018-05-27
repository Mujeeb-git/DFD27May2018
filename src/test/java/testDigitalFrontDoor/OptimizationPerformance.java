package testDigitalFrontDoor;

import java.util.ArrayList;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import digitalFrontDoor_POM.DFDHomePage;

import digitalFrontDoor_POM.EditSolutionTeamPage;
import digitalFrontDoor_POM.LoginPage;

import digitalFrontDoor_POM.NewSARequestPage;
import digitalFrontDoor_POM.SolutionDetails;
import digitalFrontDoor_POM.SolutionIntegratorAllocationPage;
import utilitiesFunctionLibrary.Utility;

public class OptimizationPerformance {

	WebDriver driver;
	WebDriverWait wait;
	DFDHomePage objDFDHomePage;
	LoginPage objLoginPage;
	NewSARequestPage objNewSARequestPage;
	SolutionIntegratorAllocationPage objSIAllocationPage;
	EditSolutionTeamPage objEditSolTeamPage;
	SolutionDetails objSolutionDetails;
	Utility objUtility;
	StopWatch stopWatch;
	Actions actions;
	JavascriptExecutor jse;
	String decryptedPassword, encryptedPassword, userName, dateStr, siMessage, requestNumberMsg, requestNumber, value;
	ArrayList<String> tabs2;
	long pageLoadTime_ms;
	float pageLoadTime_sec;

	@BeforeClass
	public void setUp() throws Exception {

		// Launch the Browser
		objUtility = new Utility();
		driver = objUtility.OpenApp(objUtility.getDFDData(1, "Login"), objUtility.getDFDData(2, "Login"));
		Thread.sleep(20000);
		// log into the portal
		if(!("ie".equalsIgnoreCase(objUtility.getDFDData(1, "Login")))) {
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
		objSolutionDetails = new SolutionDetails(driver);

	}

	// My Solutions Page Load
	@Test(priority = 0)
	public void testMySolutionPageLoad() throws Exception {
		// My Solutions Page

		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.mMyHmeLnk.click();
		Thread.sleep(1000);

		stopWatch.start();

		objDFDHomePage.mMySolLnk.click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='s4-bodyContainer']/div/div/div[2]/div[3]")));

		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");
		System.out.println("Time taken to Load 'My Solution Page' page: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(1, Float.toString(pageLoadTime_sec));
		Thread.sleep(2000);

	}

	// Edit request Load in My Solutions Page
	@Test(priority = 1)
	public void testSolutionDetailsPageLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(1000);
		// My Solutions Page
		int rows = driver.findElements(By.xpath("//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr")).size()
				- 1;
		for (int i = 2; i < rows; i++) {

			String xpathStr = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[2]/img";
			if (driver.findElements(By.xpath(xpathStr)).size() > 1) {
				String editXpath = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[12]/a";
				stopWatch.start();
				driver.findElement(By.xpath(editXpath)).click();
				break;
			}
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='MainContent_lblSolPlan']")));

		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println(
				"Time taken to Load Solution Details page from 'My Solution Page' page: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(2, Float.toString(pageLoadTime_sec));
		Thread.sleep(2000);

	}

	// click on cancel button for Solution Team in solution details page
	@Test(priority = 2)
	public void testSolTeamCancelLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(1000);
		objSolutionDetails.solTeamCancelBtn.click();

		stopWatch.start();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='s4-bodyContainer']/div/div/div[2]/div[3]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println(
				"Time taken to Load Solution Details page after clicking cancel Button in Solution Details Page' : "
						+ pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(3, Float.toString(pageLoadTime_sec));
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void testSolDetailsSolDigiOnshoreLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);

		int rows = driver.findElements(By.xpath("//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr")).size()
				- 1;
		for (int i = 2; i < rows; i++) {

			String xpathStr = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[2]/img";
			if (driver.findElements(By.xpath(xpathStr)).size() > 1) {
				String editXpath = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[12]/a";
				driver.findElement(By.xpath(editXpath)).click();
				break;
			}
		}

		objSolutionDetails.solTeamSolDesignerField.sendKeys("d.kumar.kathuroju");
		Thread.sleep(3000);
		objSolutionDetails.solTeamSolDesignerFieldList1.click();
		objSolutionDetails.digiOnshoreSABtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='MainContent_cont_rptOnshoreSAs_lblItem1_0']")));

		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load Onshore SA field after adding in Solution Details page: "
				+ pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(4, Float.toString(pageLoadTime_sec));

		objSolutionDetails.digiOnshoreSARemoveBtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(20000);
		objSolutionDetails.saveBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}

	@Test(priority = 4)
	public void testSolDetailsSolDigiOnshoreSaveLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);
		
		objSolutionDetails.solTeamSolDesignerField.sendKeys("d.kumar.kathuroju");
		Thread.sleep(3000);
		objSolutionDetails.solTeamSolDesignerFieldList1.click();
		objSolutionDetails.digiOnshoreSABtn.click();
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='MainContent_cont_rptOnshoreSAs_lblItem1_0']")));


		objSolutionDetails.saveBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions.alertIsPresent());

		stopWatch.stop();

		driver.switchTo().alert().accept();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load testSolDetailsSolDigiOnshoreSaveLoad: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(5, Float.toString(pageLoadTime_sec));
		objSolutionDetails.digiOnshoreSARemoveBtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(20000);
		objSolutionDetails.saveBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	 

	}

	@Test(priority = 5)
	public void testSolTrackingSave() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);

		objSolutionDetails.SolTrackingTab.click();
		Thread.sleep(1000);
		objSolutionDetails.solTrackingSaveBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions.alertIsPresent());

		stopWatch.stop();

		driver.switchTo().alert().accept();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load testSolTrackingSave: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(6, Float.toString(pageLoadTime_sec));
 
	}
	
	@Test(priority = 6)
	public void testSolTrackingCancel() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);

		objSolutionDetails.SolTrackingTab.click();
		Thread.sleep(1000);
		objSolutionDetails.solTrackingCancelBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions.alertIsPresent());

		stopWatch.stop();

		driver.switchTo().alert().accept();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load testSolTrackingCancel: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(7, Float.toString(pageLoadTime_sec));
 
	}
	
	@Test(priority = 7)
	public void testSolTrackingGDNSave() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);

		int rows = driver.findElements(By.xpath("//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr")).size()
				- 1;
		for (int i = 2; i < rows; i++) {

			String xpathStr = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[2]/img";
			if (driver.findElements(By.xpath(xpathStr)).size() > 1) {
				String editXpath = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[12]/a";
				driver.findElement(By.xpath(editXpath)).click();
				break;
			}
		}
		
		objSolutionDetails.SolTrackingGDNTab.click();
		Thread.sleep(1000);
		objSolutionDetails.solTrackingGDNSaveBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions.alertIsPresent());

		stopWatch.stop();

		driver.switchTo().alert().accept();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load testSolTrackingGDNSave: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(8, Float.toString(pageLoadTime_sec));
 
	}
	
	@Test(priority = 8)
	public void testSolTrackingGDNCancel() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);

		objSolutionDetails.SolTrackingGDNTab.click();
		Thread.sleep(1000);
		objSolutionDetails.solTrackingGNDCancelBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(("//*[@id='s4-bodyContainer']/div/div/div[2]/div[3]"))));

		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load testSolTrackingGDNCancel: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(9, Float.toString(pageLoadTime_sec));
 
	}
	
	@Test(priority = 9)
	public void DRASubmit() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);
		
		int rows = driver.findElements(By.xpath("//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr")).size()
				- 1;
		for (int i = 2; i < rows; i++) {

			String xpathStr = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[2]/img";
			if (driver.findElements(By.xpath(xpathStr)).size() > 1) {
				String editXpath = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[12]/a";
				driver.findElement(By.xpath(editXpath)).click();
				break;
			}
		}
		
		
		objSolutionDetails.DRATab.click();
		Thread.sleep(1000);
		objSolutionDetails.DRASubmitBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions.alertIsPresent());

		stopWatch.stop();

		driver.switchTo().alert().accept();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load DRASubmit: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(10, Float.toString(pageLoadTime_sec));
		Thread.sleep(1000);
 
	}
	
	@Test(priority = 10)
	public void DRACancel() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);

		objSolutionDetails.DRATab.click();
		Thread.sleep(1000);
		objSolutionDetails.DRACancelBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(("//*[@id='s4-bodyContainer']/div/div/div[2]/div[3]"))));

		stopWatch.stop();


		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load DRACancel: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(11, Float.toString(pageLoadTime_sec));
 
	}
	
	@Test(priority = 11)
	public void DSASave() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);
		
		int rows = driver.findElements(By.xpath("//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr")).size()
				- 1;
		for (int i = 2; i < rows; i++) {

			String xpathStr = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[2]/img";
			if (driver.findElements(By.xpath(xpathStr)).size() > 1) {
				String editXpath = "//*[@id='s4-bodyContainer']/div/div/div[2]/table/tbody/tr[" + i + "]/td[12]/a";
				driver.findElement(By.xpath(editXpath)).click();
				break;
			}
		}
		
		
		
		objSolutionDetails.DSATab.click();
		Thread.sleep(1000);
		objSolutionDetails.DSASaveBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions.alertIsPresent());

		stopWatch.stop();

		driver.switchTo().alert().accept();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load DSASave: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(12, Float.toString(pageLoadTime_sec));
 
	}
	
	@Test(priority = 12)
	public void DSACancel() throws Exception {
		stopWatch.reset();
		Thread.sleep(5000);

		objSolutionDetails.DSATab.click();
		Thread.sleep(1000);
		objSolutionDetails.DSACancelBtn.click();

		stopWatch.start();

		wait.until(ExpectedConditions.alertIsPresent());

		stopWatch.stop();

		driver.switchTo().alert().accept();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_sec = (float) pageLoadTime_ms / 1000;

		System.out.println("Time taken to Load DSACancel: " + pageLoadTime_sec + " Sec");
		System.out.println(
				"===============================================================================================");
		objUtility.writeDataToExcel(13, Float.toString(pageLoadTime_sec));
 
	}
	
	
	
	

}

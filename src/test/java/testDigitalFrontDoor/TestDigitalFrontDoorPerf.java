package testDigitalFrontDoor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.time.StopWatch;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import digitalFrontDoor_POM.DFDHomePage;
import digitalFrontDoor_POM.EditSolutionTeamPage;
import digitalFrontDoor_POM.LoginPage;
import digitalFrontDoor_POM.NewSARequestPage;
import digitalFrontDoor_POM.SolutionIntegratorAllocationPage;
import utilitiesFunctionLibrary.Utility;

public class TestDigitalFrontDoorPerf {

	WebDriver driver;
	WebDriverWait wait;
	DFDHomePage objDFDHomePage;
	LoginPage objLoginPage;
	NewSARequestPage objNewSARequestPage;
	SolutionIntegratorAllocationPage objSIAllocationPage;
	EditSolutionTeamPage objEditSolTeamPage;
	Utility objUtility;
	StopWatch stopWatch;
	String decryptedPassword, encryptedPassword, userName, dateStr, siMessage, requestNumberMsg, requestNumber, value;
	ArrayList<String> tabs2;
	long pageLoadTime_ms;
	float pageLoadTime_SARequestPage, pageLoadTime_SMEexpertPage, pageLoadTime_PropSpecialist,
			pageLoadTime_EditSARequestPage, pageLoadTime_NewSalesSupportRecordPage, pageLoadTime_SIAllocationPage,
			pageLoadTime_PropSpecialistAllocationPage, pageLoadTime_SMEAllocationPage,
			pageLoadTime_ManageExceptionRequestPage, pageLoadTime_SDBandwithUpdateRequestPage,
			pageLoadTime_MySolRequestPage, pageLoadTime_MySolPage, pageLoadTime_SIMasterReportPage,
			pageLoadTime_SolTrackingReportPage, pageLoadTime_GDNTrackingReportPage, pageLoadTime_BandwidthReportPage,
			pageLoadTime_PropReqReportPage, pageLoadTime_SMEReportPage, pageLoadTime_TimetoSolReportPage,
			pageLoadTime_SSRReportPage, pageLoadTime_SolComplReportPage, pageLoadTime_DocSearchPage,
			pageLoadTime_EditSolTeamPage, pageLoadTime_EditSolTeamSearchPage, pageLoadTime_SolDetailPage,
			pageLoadTime_SearchNviewOpportPage,pageLoadTime_OpportDetailsPage,pageLoadTime_MngOpportListPage,
			pageLoadTime_NewSSRecordPage;
	Actions actions;
	JavascriptExecutor jse;

	@BeforeClass
	public void setUp() throws Exception {

		// Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Mujeeb\\Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Mujeeb\\Jars\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		// driver = new FirefoxDriver();
		// System.setProperty("webdriver.ie.driver",
		// "C:\\Mujeeb\\Jars\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
		// driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		// driver.get("https://dfdtest.accenture.com");
		driver.get("https://digitalfrontdoor.accenture.com");
		Thread.sleep(20000);

		// UserCreds
		userName = "mujeeb.mohammed";
		encryptedPassword = "TmV2ZXJzZXR0bGVANw=="; // "TmV3bGlmZUA3";
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		decryptedPassword = new String(decryptedPasswordBytes);

		wait = new WebDriverWait(driver, 120);
		// Login Page - Enter credentials
		objLoginPage = new LoginPage(driver);
		objLoginPage.userName.sendKeys(userName);
		objLoginPage.password.sendKeys(decryptedPassword);
		objLoginPage.submit.click();
		/*
		 * Thread.sleep(10000); objLoginPage.confirmYourIdentity(); Thread.sleep(2000);
		 * objLoginPage.enterSecurityCodeField.click(); // 30s timeout
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"BanQuickLinks\"]/div/a[1]/p")));
		 */
		objUtility = new Utility();
		Reporter.log("Entering into the test execution", true);
		Thread.sleep(10000);
		stopWatch = new StopWatch();
		actions = new Actions(driver);
		objDFDHomePage = new DFDHomePage(driver);
		objEditSolTeamPage = new EditSolutionTeamPage(driver);
		jse = (JavascriptExecutor) driver;
		Thread.sleep(20000); // to be removed for test portal
	}

	// New Solution Architect (SA) Request
	@Test(priority = 0)
	public void testSARequestPageLoad() throws Exception {
		// DFD Home Page

		stopWatch.start();

		objDFDHomePage.solArchBtn.click();

		// Switch to the other tab
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		if (tabs2.size() > 0) {
			driver.switchTo().window(tabs2.get(1));
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSubmit\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SARequestPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");
		// System.out.println("Time taken to Load 'New Solution Architect (SA) Request'
		// page: " + pageLoadTime_ms + "ms");
		System.out.println("Time taken to Load 'New Solution Architect (SA) Request' page: "
				+ pageLoadTime_SARequestPage + " Sec");
		objUtility.writeDataToExcel(1, Float.toString(pageLoadTime_SARequestPage));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
	}

	// SME Request
	@Test(priority = 1)
	public void testSMEexpertPageLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(1000);
		stopWatch.start();
		objDFDHomePage.SMEBtn.click();

		// Switch to the other tab
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		if (tabs2.size() > 0) {
			driver.switchTo().window(tabs2.get(1));
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSubmit\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SMEexpertPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");
		System.out.println("Time taken to Load 'SME Request' page:': " + pageLoadTime_SMEexpertPage + " Sec");
		objUtility.writeDataToExcel(2, Float.toString(pageLoadTime_SMEexpertPage));

		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
	}

	// New Proposal Specialist Request
	@Test(priority = 2)
	public void testPropSpecialistPageLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(1000);
		stopWatch.start();
		objDFDHomePage.pSpecialistBtn.click();

		// Switch to the other tab
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		if (tabs2.size() > 0) {
			driver.switchTo().window(tabs2.get(1));
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSubmit\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_PropSpecialist = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");
		System.out.println(
				"Time taken to Load 'New Proposal Specialist Request' page:': " + pageLoadTime_PropSpecialist + " Sec");
		objUtility.writeDataToExcel(3, Float.toString(pageLoadTime_PropSpecialist));

		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}

	// Edit SA Request
	@Test(priority = 3)
	public void testEditSARequestPageLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,0)");
		// jse.executeScript("arguments[0].scrollIntoView();", objDFDHomePage.menuLnk);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		actions.moveToElement(objDFDHomePage.submitRequestLnk).click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"homeHeader\"]/div[2]/div[1]/nav/div/ul/li[2]/ul/li[4]/a")));
		stopWatch.start();
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0," + objDFDHomePage.mEditSolArchLnk.getLocation().x + ")");
		objDFDHomePage.mEditSolArchLnk.click();

		/*
		 * wait.until(ExpectedConditions .visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"MainContent_RepEditPageDashboard_lnkEditReq_14\"]")));
		 */
		// the below code is for prod
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnEditReqSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_EditSARequestPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Edit SA Request' page:': " + pageLoadTime_EditSARequestPage + " Sec");
		objUtility.writeDataToExcel(4, Float.toString(pageLoadTime_EditSARequestPage));

		Thread.sleep(2000);

	}

	// New Sales Support Record
	@Test(priority = 4)
	public void testNewSalesSupportRecordPageLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(1000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"homeHeader\"]/div[2]/div[1]/nav/div/ul/li[3]/a")));
		stopWatch.start();
		actions.moveToElement(objDFDHomePage.mNewSalesSRecordLnk).click().perform();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbldynLock\"]/tbody/tr[16]/td[13]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_NewSalesSupportRecordPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'New Sales Support Record' page:': "
				+ pageLoadTime_NewSalesSupportRecordPage + " Sec");
		objUtility.writeDataToExcel(5, Float.toString(pageLoadTime_NewSalesSupportRecordPage));

		Thread.sleep(2000);

	}

	// Solution Integrator Allocation
	@Test(priority = 5)
	public void testSIAllocationPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.mManageAllocationLnk.click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"homeHeader\"]/div[2]/div[1]/nav/div/ul/li[4]/ul/li[1]/a")));
		stopWatch.start();
		actions.moveToElement(objDFDHomePage.mSIAllocLnk).click().perform();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_RepSAAllocation_lnkSAEdit_14\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SIAllocationPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Solution Integrator Allocation' page:': "
				+ pageLoadTime_SIAllocationPage + " Sec");
		objUtility.writeDataToExcel(6, Float.toString(pageLoadTime_SIAllocationPage));

		Thread.sleep(2000);

	}

	// Proposal Specialist Allocation
	@Test(priority = 6)
	public void testPropSpecialistAllocationPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.mManageAllocationLnk.click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"homeHeader\"]/div[2]/div[1]/nav/div/ul/li[4]/ul/li[2]/a")));
		stopWatch.start();
		actions.moveToElement(objDFDHomePage.mPropSplAllocLnk).click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"MainContent_upRepeater\"]/div[1]/table/tbody/tr[last()]/td[last()]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_PropSpecialistAllocationPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Proposal Specialist Allocation' page:': "
				+ pageLoadTime_PropSpecialistAllocationPage + " Sec");
		objUtility.writeDataToExcel(7, Float.toString(pageLoadTime_PropSpecialistAllocationPage));

		Thread.sleep(2000);

	}

	// SME Allocation
	@Test(priority = 7)
	public void testSMEAllocationPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.mManageAllocationLnk.click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"homeHeader\"]/div[2]/div[1]/nav/div/ul/li[4]/ul/li[3]/a")));
		stopWatch.start();
		actions.moveToElement(objDFDHomePage.mSMEAllocLnk).click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"MainContent_upRepeater\"]/div[1]/table/tbody/tr[last()]/td[last()]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SMEAllocationPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'SME Allocation' page:': " + pageLoadTime_SMEAllocationPage + " Sec");
		objUtility.writeDataToExcel(8, Float.toString(pageLoadTime_SMEAllocationPage));

		Thread.sleep(2000);

	}

	// Manage Exception Request
	@Test(priority = 8)
	public void testManageExceptionRequestPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.mManageAllocationLnk.click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"homeHeader\"]/div[2]/div[1]/nav/div/ul/li[4]/ul/li[4]/a")));
		stopWatch.start();
		actions.moveToElement(objDFDHomePage.mMngExcepReqLnk).click().perform();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_rptPager_lnkPage_0\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_ManageExceptionRequestPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Manage Exception Request' page:': "
				+ pageLoadTime_ManageExceptionRequestPage + " Sec");
		objUtility.writeDataToExcel(9, Float.toString(pageLoadTime_ManageExceptionRequestPage));
		Thread.sleep(2000);

	}

	// SD Bandwidth Update
	@Test(priority = 9)
	public void testSDBandwithUpdatePageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mMyHmeLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSDbwUpdateLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnAddRows\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SDBandwithUpdateRequestPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'SD Bandwidth Update' page:': "
				+ pageLoadTime_SDBandwithUpdateRequestPage + " Sec");
		objUtility.writeDataToExcel(10, Float.toString(pageLoadTime_SDBandwithUpdateRequestPage));
		Thread.sleep(2000);

	}

	// My Solutions
	@Test(priority = 10)
	public void testMySolPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mMyHmeLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mMySolLnk.click();
		stopWatch.start();
		/*
		 * wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"MainContent_rptPager_lnkPage_0\"]")));
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_newSolbtnsearch\"]"))); // this
																															// is
																															// for
																															// prod
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_MySolRequestPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'My Solutions' page:': " + pageLoadTime_MySolRequestPage + " Sec");
		objUtility.writeDataToExcel(11, Float.toString(pageLoadTime_MySolRequestPage));
		Thread.sleep(2000);

	}

	// My Sales Support Records
	@Test(priority = 11)
	public void testMySSRecordsPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mMyHmeLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mMySalesSRecLnk.click();
		stopWatch.start();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(
		// By.xpath("//*[@id=\"MainContent_MyProposalRecordsupdatepanel\"]/div[2]/div/div[8]/input[2]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"MainContent_MyProposalRecordsupdatepanel\"]/div[2]/div/div[8]/input[2]")));// for
																												// prod
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_MySolPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'My Sales Support Records' page:': " + pageLoadTime_MySolPage + " Sec");
		objUtility.writeDataToExcel(12, Float.toString(pageLoadTime_MySolPage));
		Thread.sleep(2000);

	}

	// SI Master Report Page
	@Test(priority = 12)
	public void testSIMasterReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSIMasterReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SIMasterReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'SI Master Report' page:': " + pageLoadTime_SIMasterReportPage + " Sec");
		objUtility.writeDataToExcel(13, Float.toString(pageLoadTime_SIMasterReportPage));
		Thread.sleep(2000);

	}

	// Solution Tracking Report
	@Test(priority = 13)
	public void testSolTrackingReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSolTrackReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SolTrackingReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println(
				"Time taken to Load 'Solution Tracking Report' page:': " + pageLoadTime_SolTrackingReportPage + " Sec");
		objUtility.writeDataToExcel(14, Float.toString(pageLoadTime_SolTrackingReportPage));
		Thread.sleep(2000);

	}

	// GDN Tracking Report
	@Test(priority = 14)
	public void testGDNTrackingReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mGDNTrackReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_GDNTrackingReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println(
				"Time taken to Load 'GDN Tracking Report' page:': " + pageLoadTime_GDNTrackingReportPage + " Sec");
		objUtility.writeDataToExcel(15, Float.toString(pageLoadTime_GDNTrackingReportPage));
		Thread.sleep(2000);

	}

	// Bandwidth Report
	@Test(priority = 15)
	public void testBandwidthReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mBWReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_Submit\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_BandwidthReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out
				.println("Time taken to Load 'Bandwidth Report' page:': " + pageLoadTime_BandwidthReportPage + " Sec");
		objUtility.writeDataToExcel(16, Float.toString(pageLoadTime_BandwidthReportPage));
		Thread.sleep(2000);

	}

	// Proposal Request Report
	@Test(priority = 16)
	public void testPropReqReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mPropReqReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_PropReqReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println(
				"Time taken to Load 'Proposal Request Report' page:': " + pageLoadTime_PropReqReportPage + " Sec");
		objUtility.writeDataToExcel(17, Float.toString(pageLoadTime_PropReqReportPage));
		Thread.sleep(2000);

	}

	// SME Report
	@Test(priority = 17)
	public void testSMEReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSMEReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SMEReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'SME Report' page:': " + pageLoadTime_SMEReportPage + " Sec");
		objUtility.writeDataToExcel(18, Float.toString(pageLoadTime_SMEReportPage));
		Thread.sleep(2000);

	}

	// Time to Solution Report
	@Test(priority = 18)
	public void testTimetoSolReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mTime2SolReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_TimetoSolReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println(
				"Time taken to Load 'Time to Solution Report' page:': " + pageLoadTime_TimetoSolReportPage + " Sec");
		objUtility.writeDataToExcel(19, Float.toString(pageLoadTime_TimetoSolReportPage));
		Thread.sleep(2000);

	}

	// Sales Support Record Report
	@Test(priority = 19)
	public void testSSRReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSalesSRecReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnSearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SSRReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println(
				"Time taken to Load 'Sales Support Record Report' page:': " + pageLoadTime_SSRReportPage + " Sec");
		objUtility.writeDataToExcel(20, Float.toString(pageLoadTime_SSRReportPage));
		Thread.sleep(2000);

	}

	// Solution Compliance Report
	@Test(priority = 20)
	public void testSolComplReportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mReportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSolcomplReportLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"ctl00_MainContent_ReportViewer1_ctl05_ctl04_ctl00_ButtonLink\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SolComplReportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println(
				"Time taken to Load 'Solution Compliance Report' page:': " + pageLoadTime_SolComplReportPage + " Sec");
		objUtility.writeDataToExcel(21, Float.toString(pageLoadTime_SolComplReportPage));
		Thread.sleep(2000);

	}

	// Document Search
	@Test(priority = 21)
	public void testDocSearchPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mDocSearchLnk.click();
		/*
		 * Thread.sleep(1000); objDFDHomePage.mSolcomplReportLnk.click();
		 */
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_btnsearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_DocSearchPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Document Search' page:': " + pageLoadTime_DocSearchPage + " Sec");
		objUtility.writeDataToExcel(22, Float.toString(pageLoadTime_DocSearchPage));
		Thread.sleep(2000);

	}

	// Edit Solution Team
	@Test(priority = 22)
	public void testEditSolPlanPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);

		objDFDHomePage.mUtilitiesLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mEditSolPlanLnk.click();
		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_imgsearch\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_EditSolTeamPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Edit Solution Team' page:': " + pageLoadTime_EditSolTeamPage + " Sec");
		objUtility.writeDataToExcel(23, Float.toString(pageLoadTime_EditSolTeamPage));
		Thread.sleep(2000);

	}

	// Edit Solution Team and search
	@Test(priority = 23, dependsOnMethods = { "testEditSolPlanPageLoad" })
	public void testEditSolPlanSearchPageLoad() throws Exception {
		stopWatch.reset();
		// objDFDHomePage.homeButton.click();
		// Thread.sleep(2000);
		// objDFDHomePage.menuLnk.click();
		// Thread.sleep(2000);

		// objDFDHomePage.mUtilitiesLnk.click();
		Thread.sleep(1000);
		objEditSolTeamPage.searchBtn.click();
		stopWatch.start();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_rptPager_lnkPage_0\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_EditSolTeamSearchPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Edit Solution Team' page with search results:': "
				+ pageLoadTime_EditSolTeamSearchPage + " Sec");
		objUtility.writeDataToExcel(24, Float.toString(pageLoadTime_EditSolTeamSearchPage));
		Thread.sleep(2000);

	}

	// Solution Details (select solu and clicked on the edit button)
	@Test(priority = 24, dependsOnMethods = { "testEditSolPlanSearchPageLoad" })
	public void testSolDetailsPageLoad() throws Exception {
		stopWatch.reset();
		Thread.sleep(1000);

		List<WebElement> editButtons = driver.findElements(By.xpath(
				"//*[@id=\"MainContent_Requestordbupdatepanel\"]/div/div/div[2]/div/table/tbody/tr/td[last()]/a"));
		for (WebElement editButton : editButtons) {
			if (editButton.getAttribute("disabled") == null) {
				editButton.click();
				stopWatch.start();
				break;
			}
		}

		// objEditSolTeamPage.editBtn.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"mmsheader\"][contains(text(),\"MMS Information\")]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SolDetailPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Solution Details' page:': " + pageLoadTime_SolDetailPage + " Sec");
		objUtility.writeDataToExcel(25, Float.toString(pageLoadTime_SolDetailPage));
		Thread.sleep(2000);

	}

	// Search and view Opportunities (Menu->Utilities->View Opportunity->Search and
	// view Opportunities)
	@Test(priority = 25)
	public void testSearchNviewOpportPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.mUtilitiesLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mViewOpportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mSearchNviewOpportLnk.click();

		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MainContent_ddlgeoarea\"]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_SearchNviewOpportPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Search & View Opportunities' page:': "
				+ pageLoadTime_SearchNviewOpportPage + " Sec");
		objUtility.writeDataToExcel(26, Float.toString(pageLoadTime_SearchNviewOpportPage));
		Thread.sleep(2000);

	}

	// Opportunity Details (Menu->Utilities->View Opportunity->Opportunity Details)
	@Test(priority = 26)
	public void testOpportDetailsPageLoad() throws Exception {
		stopWatch.reset();
		objDFDHomePage.homeButton.click();
		Thread.sleep(2000);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.mUtilitiesLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mViewOpportLnk.click();
		Thread.sleep(1000);
		objDFDHomePage.mOpportDetailsLnk.click();

		stopWatch.start();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ExpandButton\"][contains(text(),'Expand All')]")));
		stopWatch.stop();

		// Get the time
		pageLoadTime_ms = stopWatch.getTime();
		pageLoadTime_OpportDetailsPage = (float) pageLoadTime_ms / 1000;
		System.out.println(
				"===============================================================================================");

		System.out.println("Time taken to Load 'Opportunity Details' page:': "
				+ pageLoadTime_OpportDetailsPage + " Sec");
		objUtility.writeDataToExcel(27, Float.toString(pageLoadTime_OpportDetailsPage));
		Thread.sleep(2000);

	}
	
	
	// Opportunity Details (Menu->Utilities->View Opportunity->Manage Opportunity List)
		@Test(priority = 27)
		public void testMngOpportListPageLoad() throws Exception {
			stopWatch.reset();
			objDFDHomePage.homeButton.click();
			Thread.sleep(2000);
			objDFDHomePage.menuLnk.click();
			Thread.sleep(2000);
			objDFDHomePage.mUtilitiesLnk.click();
			Thread.sleep(1000);
			objDFDHomePage.mViewOpportLnk.click();
			Thread.sleep(1000);
			objDFDHomePage.mMngOpportListLnk.click();

			stopWatch.start();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lstbxCreatedBy_ms\"]")));
			stopWatch.stop();

			// Get the time
			pageLoadTime_ms = stopWatch.getTime();
			pageLoadTime_MngOpportListPage = (float) pageLoadTime_ms / 1000;
			System.out.println(
					"===============================================================================================");

			System.out.println("Time taken to Load 'Manage Opportunity Lists' page:': "
					+ pageLoadTime_MngOpportListPage + " Sec");
			objUtility.writeDataToExcel(28, Float.toString(pageLoadTime_MngOpportListPage));
			Thread.sleep(2000);

		}

		// Create New Sales Support Record (Menu->Utilities->Create New Sales Support Record)
				@Test(priority = 27)
				public void testNewSSRecordPageLoad() throws Exception {
					stopWatch.reset();
					objDFDHomePage.homeButton.click();
					Thread.sleep(2000);
					objDFDHomePage.menuLnk.click();
					Thread.sleep(2000);
					objDFDHomePage.mUtilitiesLnk.click();
					Thread.sleep(1000);
					objDFDHomePage.mCreateSSRecordLnk.click();


					stopWatch.start();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ddlCNRGeoArea\"]")));
					stopWatch.stop();

					// Get the time
					pageLoadTime_ms = stopWatch.getTime();
					pageLoadTime_NewSSRecordPage = (float) pageLoadTime_ms / 1000;
					System.out.println(
							"===============================================================================================");

					System.out.println("Time taken to Load 'Create New Sales Support Record' page:': "
							+ pageLoadTime_NewSSRecordPage + " Sec");
					objUtility.writeDataToExcel(28, Float.toString(pageLoadTime_NewSSRecordPage));
					Thread.sleep(2000);

				}

						
	
	
	@AfterClass
	public void tearDownClass() throws IOException, InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}

}

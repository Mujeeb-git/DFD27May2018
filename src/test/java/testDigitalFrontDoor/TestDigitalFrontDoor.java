package testDigitalFrontDoor;

import java.util.ArrayList;
import java.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import digitalFrontDoor_POM.DFDHomePage;
import digitalFrontDoor_POM.LoginPage;
import digitalFrontDoor_POM.NewSARequestPage;
import digitalFrontDoor_POM.SolutionIntegratorAllocationPage;
import utilitiesFunctionLibrary.Utility;

public class TestDigitalFrontDoor {

	WebDriver driver;
	WebDriverWait wait;
	DFDHomePage objDFDHomePage;
	LoginPage objLoginPage;
	NewSARequestPage objNewSARequestPage;
	SolutionIntegratorAllocationPage objSIAllocationPage;
	Utility objUtility;
	String decryptedPassword, encryptedPassword, userName, dateStr,siMessage,requestNumberMsg,requestNumber;


	@BeforeClass
	public void setUp() throws Exception {

		// Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Mujeeb\\Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dfdtest.accenture.com");
		Thread.sleep(20000);

		// UserCreds
		userName = "mujeeb.mohammed";
		encryptedPassword = "TmV3bGlmZUA3";
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		decryptedPassword = new String(decryptedPasswordBytes);

		wait = new WebDriverWait(driver, 120);
		// Login Page - Enter credentials
		objLoginPage = new LoginPage(driver);
		objLoginPage.userName.sendKeys(userName);
		objLoginPage.password.sendKeys(decryptedPassword);
		objLoginPage.submit.click();
		Thread.sleep(10000);
		objLoginPage.confirmYourIdentity();
		Thread.sleep(2000);
		objLoginPage.enterSecurityCodeField.click();
		// 30s timeout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BanQuickLinks\"]/div/a[1]/p")));
		objUtility = new Utility();
		Reporter.log("Entering into the test execution", true);
	}

	@Test(priority = 0)
	public void testSARequest() throws Exception {
		// DFD Home Page
		objDFDHomePage = new DFDHomePage(driver);
		objDFDHomePage.solArchBtn.click();
		Thread.sleep(20000);

		// Switch to the other tab
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

	/*	
	  //New SA Request Page
		objNewSARequestPage = new NewSARequestPage(driver);
		objNewSARequestPage.opportIDField.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
		objNewSARequestPage.searchBtn.click();
		Thread.sleep(5000);
		while(isAlertPresents()) {
			
			objNewSARequestPage.opportIDField.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
			objNewSARequestPage.searchBtn.click();
			driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);
		// If Geography Unit drop down is enable then select the value
		if (objNewSARequestPage.geoAreaDrpdwn.isEnabled()) {
			objNewSARequestPage.chooseGeoArea(2);
		}
		
		Thread.sleep(1000);
		// If Geography Unit drop down is enable then select the value
		if (objNewSARequestPage.geoUnitDrpdwn.isEnabled()) {
			objNewSARequestPage.chooseGeoUnit();
		}
		// If Region drop down is enable then select the value
		if (objNewSARequestPage.regionDrpdwn.isDisplayed() && objNewSARequestPage.regionDrpdwn.isEnabled()) {
			objNewSARequestPage.chooseRegion();
		}
		objNewSARequestPage.chooseSpeciality();
		objNewSARequestPage.calenderBtn.click();
		Thread.sleep(1000);
		objNewSARequestPage.nextMonthBtn.click();
		Thread.sleep(1000);
		objNewSARequestPage.nextMonthDateBtn.click();
		Thread.sleep(1000);
		objNewSARequestPage.wbsField.sendKeys("WBSE1234");
		objNewSARequestPage.digitalSalesLeadField.sendKeys("d.kumar.kathuroju");
		Thread.sleep(5000);
		objNewSARequestPage.digitalSalesLeadList1.click();
		objNewSARequestPage.clientTeamField.sendKeys("mujeeb.mohammed");
		Thread.sleep(5000);
		objNewSARequestPage.clientTeamList1.click();
		objNewSARequestPage.technologyArea.sendKeys("This is the Technology Area");
		objNewSARequestPage.opportDescArea.sendKeys("This is the Opportunity description Area");
		if (objNewSARequestPage.excJustifyArea.isDisplayed()) {
			objNewSARequestPage.excJustifyArea.sendKeys("This is the exception justification Area");
		}
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", objNewSARequestPage.submitBtn);
		// objNewSARequestPage.submitBtn.click();
		Thread.sleep(50000);
		requestNumberMsg = driver.switchTo().alert().getText();
		Reporter.log("The Message:" + requestNumberMsg + " ", true);
		driver.switchTo().alert().accept();
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		requestNumber = requestNumberMsg.substring(54, 65);
		Reporter.log("The Request number is: "+requestNumber,true);

	}

	// Solution Integrator allocation using request number
	@Test(priority = 1)
	public void testAllocateSI() throws Exception {
		// DFD Home Page
		objDFDHomePage = new DFDHomePage(driver);
		objDFDHomePage.menuLnk.click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", objDFDHomePage.mManageAllocationLnk);
		
		//Actions actions = new Actions(driver);
		//actions.moveToElement(objDFDHomePage.mManageAllocationLnk).click().perform();
		
		//objDFDHomePage.mManageAllocationLnk.click();;
		Thread.sleep(1000);
		objDFDHomePage.mSIAllocLnk.click();
		Thread.sleep(10000);
		
		//Solution Integrator Allocation Page
		objSIAllocationPage = new SolutionIntegratorAllocationPage(driver);
		objSIAllocationPage.requestNoBtn.click();
		objSIAllocationPage.requestNoField.sendKeys(requestNumber);
		objSIAllocationPage.searchBtn.click();
		Thread.sleep(5000);
		String parentHandle = driver.getWindowHandle();
		objSIAllocationPage.editBtn.click();
		Thread.sleep(1000);
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    objSIAllocationPage.solIntegratorField.sendKeys("d.kumar.kathuroju");
		    Thread.sleep(5000);
		    objSIAllocationPage.solIntegratorList1.click();
		    objSIAllocationPage.solIntegratorSaveBtn.click();
		    Thread.sleep(5000);
		    
		    //Switch to alert, get the message and close
		    siMessage = driver.switchTo().alert().getText();
			Reporter.log("The Message:" + siMessage + " ", true);
			driver.switchTo().alert().accept();
			
			objSIAllocationPage.gdnLeadSDField.sendKeys("d.kumar.kathuroju");
			Thread.sleep(5000);
		    objSIAllocationPage.gdnLeadSDList1.click();
		    objSIAllocationPage.gdnLeadSDSaveBtn.click();
		    
		  //Switch to alert, get the message and close
		    siMessage = driver.switchTo().alert().getText();
			Reporter.log("The Message:" + siMessage + " ", true);
			driver.switchTo().alert().accept();
			
			objSIAllocationPage.allocationNotesArea.sendKeys("This is the allocation notes");
			objSIAllocationPage.saveNotesBtn.click();
			
			//Switch to alert, get the message and close
		    siMessage = driver.switchTo().alert().getText();
			Reporter.log("The Message:" + siMessage + " ", true);
			driver.switchTo().alert().accept();
			
			objSIAllocationPage.closeBtn.click();    
		    	    	   
				
		}
		 driver.close();
		 driver.switchTo().window(parentHandle);

		
		
	}
	
	public boolean isAlertPresents() {
		try {
		driver.switchTo().alert();
		return true;
		}// try
		catch (Exception e) {
		return false;
		}// catch
		}
		*/
	
	}
}

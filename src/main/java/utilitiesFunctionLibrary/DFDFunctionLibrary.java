package utilitiesFunctionLibrary;
/**
 * @author mujeeb.mohammed
 *
 */
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import digitalFrontDoor_POM.CreativePropStudioEffortEstimatorPage;
import digitalFrontDoor_POM.DFDHomePage;
import digitalFrontDoor_POM.NewPropSplstRqstPage;
import digitalFrontDoor_POM.NewSMErequestPage;

public class DFDFunctionLibrary {

	NewPropSplstRqstPage objNewPropSplstRqstPage;
	Utility objUtility;
	DFDHomePage objDFDHomePage;
	NewSMErequestPage objNewSMErequestPage;
	JavascriptExecutor jse;
	WebDriverWait wait;
	CreativePropStudioEffortEstimatorPage objCPSEffortEstimatorPage;
	
	public void fillNewPropSplRqst2(WebDriver driver, Boolean sendingEmail) throws Exception {
		objNewPropSplstRqstPage = new NewPropSplstRqstPage(driver);
		objUtility = new Utility();

		// enter opportunity ID and search
		objNewPropSplstRqstPage.opportIDField
				.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
		objNewPropSplstRqstPage.fedOpportSearchBtn.click();
		Thread.sleep(10000);
		while (objUtility.isAlertPresents(driver)) {

			objNewPropSplstRqstPage.opportIDField
					.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
			objNewPropSplstRqstPage.fedOpportSearchBtn.click();
			driver.switchTo().alert().accept();
		}

		Thread.sleep(5000);
		// If Geography Unit drop down is enable then select the value
		if (objNewPropSplstRqstPage.geoAreaDrpdwn.isEnabled()) {
			objNewPropSplstRqstPage.chooseGeoArea(2);
		}

		Thread.sleep(1000);
		// If Geography Unit drop down is enable then select the value
		if (objNewPropSplstRqstPage.geoUnitDrpdwn.isEnabled()) {
			objNewPropSplstRqstPage.chooseGeoUnit(2);
		}

		// enter the date in the 'support required by' textbox
		Thread.sleep(1000);
		objNewPropSplstRqstPage.calenderImg.click();
		Thread.sleep(1000);
		objNewPropSplstRqstPage.nextMonthArrw.click();
		Thread.sleep(1000);
		objNewPropSplstRqstPage.nextMonthDate.click();

		// select speciality, WBSE, primary contact, technology and opport desc
		objNewPropSplstRqstPage.chooseSpeciality(2);
		objNewPropSplstRqstPage.wbsField.sendKeys("WBSE1234");
		objNewPropSplstRqstPage.primaryCntctField.sendKeys("mujeeb.mohammed");
		Thread.sleep(3000);
		objNewPropSplstRqstPage.primaryCntctFieldValue1.click();
		objNewPropSplstRqstPage.technologyTxtArea.sendKeys("technology for this is Big Data");
		objNewPropSplstRqstPage.opportTxtArea.sendKeys("This is the description of the opportunity");
		if (sendingEmail == false) {
			objNewPropSplstRqstPage.disablesndMailChkBx.click();
		}
	}
	
	public void fillNewPropSplRqst(WebDriver driver, Boolean sendingEmail) throws Exception {
		objDFDHomePage = new DFDHomePage(driver);
		jse = (JavascriptExecutor) driver;
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.submitRequestLnk.click();
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objDFDHomePage.mpSpecialistLnkn);

		objNewPropSplstRqstPage = new NewPropSplstRqstPage(driver);
		objUtility = new Utility();

		// enter opportunity ID and search
		objNewPropSplstRqstPage.opportIDField
				.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
		objNewPropSplstRqstPage.fedOpportSearchBtn.click();
		Thread.sleep(10000);
		while (objUtility.isAlertPresents(driver)) {

			objNewPropSplstRqstPage.opportIDField
					.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
			objNewPropSplstRqstPage.fedOpportSearchBtn.click();
			driver.switchTo().alert().accept();
		}

		Thread.sleep(5000);
		// If Geography Unit drop down is enable then select the value
		if (objNewPropSplstRqstPage.geoAreaDrpdwn.isEnabled()) {
			objNewPropSplstRqstPage.chooseGeoArea(2);
		}

		Thread.sleep(1000);
		// If Geography Unit drop down is enable then select the value
		if (objNewPropSplstRqstPage.geoUnitDrpdwn.isEnabled()) {
			objNewPropSplstRqstPage.chooseGeoUnit(2);
		}

		// enter the date in the 'support required by' textbox
		Thread.sleep(1000);
		objNewPropSplstRqstPage.calenderImg.click();
		Thread.sleep(1000);
		objNewPropSplstRqstPage.nextMonthArrw.click();
		Thread.sleep(1000);
		objNewPropSplstRqstPage.nextMonthDate.click();

		// select speciality, WBSE, primary contact, technology and opport desc
		objNewPropSplstRqstPage.chooseSpeciality(2);
		objNewPropSplstRqstPage.wbsField.sendKeys("WBSE1234");
		objNewPropSplstRqstPage.primaryCntctField.sendKeys("mujeeb.mohammed");
		Thread.sleep(3000);
		objNewPropSplstRqstPage.primaryCntctFieldValue1.click();
		objNewPropSplstRqstPage.technologyTxtArea.sendKeys("technology for this is Big Data");
		objNewPropSplstRqstPage.opportTxtArea.sendKeys("This is the description of the opportunity");
		if (sendingEmail == false) {
			objNewPropSplstRqstPage.disablesndMailChkBx.click();
		}
	}

	public void fillNewSMERqst(WebDriver driver, Boolean disableSendingEmail) throws Exception {
		
		objDFDHomePage = new DFDHomePage(driver);
		wait = new WebDriverWait(driver,120);
		jse = (JavascriptExecutor) driver;
		objDFDHomePage.menuLnk.click();
		Thread.sleep(2000);
		objDFDHomePage.submitRequestLnk.click();
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objDFDHomePage.mSMELnk);

		objNewSMErequestPage = new NewSMErequestPage(driver);
		objUtility = new Utility();

		// enter opportunity ID and search
		objNewSMErequestPage.opportIDField.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
		objNewSMErequestPage.fedOpportSearchBtn.click();
		Thread.sleep(10000);
		while (objUtility.isAlertPresents(driver)) {

			objNewSMErequestPage.opportIDField
					.sendKeys(Integer.toString(objUtility.generateRandomNumber(660000, 690000)));
			objNewSMErequestPage.fedOpportSearchBtn.click();
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		}

		Thread.sleep(5000);

		// select Type of Support *
		objNewSMErequestPage.chooseTypeOfSupprt(4);
		Thread.sleep(1000);

		// select Speciality *
		objNewSMErequestPage.chooseSpeciality(13);
		Thread.sleep(3000);

		// select sub-Speciality *
		objNewSMErequestPage.chooseSubSpeciality(1);
		Thread.sleep(1000);
		
		//Select SME required date
		objNewSMErequestPage.smeRqdByCalenderImg.click();
		Thread.sleep(1000);
		objNewSMErequestPage.calenderNxtMnthArrow.click();
		Thread.sleep(1000);
		objNewSMErequestPage.calenderNxtMnthDate.click();
		Thread.sleep(1000);
		
		//select SME Location
		objNewSMErequestPage.chooseSMELocation(17);
		Thread.sleep(1000);
		
		//select SME Region
		if(objNewSMErequestPage.smeRegionDrpdwn.isDisplayed()) {
			
			objNewSMErequestPage.chooseSMERegion(1);
			Thread.sleep(1000);
		}

		
		// select WBSE, primary contact, additional contact
		objNewSMErequestPage.wbsField.sendKeys("WBSE1234");
		objNewSMErequestPage.primaryCntctField.sendKeys("mujeeb.mohammed");
		Thread.sleep(4000);
		objNewSMErequestPage.primaryCntctList1.click();
		Thread.sleep(1000);
		
		objNewSMErequestPage.addCntctField.sendKeys("mujeeb.mohammed");
		Thread.sleep(4000);
		objNewSMErequestPage.addCntctList1.click();
		Thread.sleep(1000);
		
		//enter Technology and opportunity description
		objNewSMErequestPage.technologyTxtArea.sendKeys("technology for this is Big Data");
		objNewSMErequestPage.opportTxtArea.sendKeys("This is the description of the opportunity");
		if (disableSendingEmail == false) {
			objNewSMErequestPage.disablesndMailChkBx.click();
		}
		
	}

	public void fillEffortEstimator(WebDriver driver,int i) throws Exception {
		objDFDHomePage = new DFDHomePage(driver);
		objNewPropSplstRqstPage = new NewPropSplstRqstPage(driver);
		objCPSEffortEstimatorPage = new CreativePropStudioEffortEstimatorPage(driver);
		jse = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		//Opening link from the menu
		jse.executeScript("arguments[0].click();", objDFDHomePage.menuLnk);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", objDFDHomePage.submitRequestLnk);
		Thread.sleep(1000);
		objDFDHomePage.mpSpecialistLnkn.click();
		Thread.sleep(2000);
		objNewPropSplstRqstPage.getWorkEstimatesLnk.click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);		
		
		//fill the form
		objCPSEffortEstimatorPage.choosePropAuthNoOfQues(i);
		objCPSEffortEstimatorPage.repContentSec.click();
		Thread.sleep(1000);
		objCPSEffortEstimatorPage.chooserepContentNoOfProps(i);
		
		objCPSEffortEstimatorPage.creativeDesignSec.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		objCPSEffortEstimatorPage.choosePSVNoOfSlides(i);
		objCPSEffortEstimatorPage.chooseVQENoOfSlides(i);
		
		objCPSEffortEstimatorPage.solIllustrationSec.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		objCPSEffortEstimatorPage.chooseIntWireFrameNoOfWFs(i);
		objCPSEffortEstimatorPage.chooseIntWireFrameNoOfScrns(i);
		objCPSEffortEstimatorPage.chooseRpdProtoNoOfProtos(i);
		objCPSEffortEstimatorPage.chooseRpdProtoNoOfScrns(i);
		objCPSEffortEstimatorPage.chooseMockupScrnsNoOfScrns(i);
		objCPSEffortEstimatorPage.chooseMockupScrnsExpScrns(i);
		objCPSEffortEstimatorPage.chooseUsrJrnyVisNoOfScrns(i);
		objCPSEffortEstimatorPage.chooseUsrJrnyVisExpScrns(i);
		
		objCPSEffortEstimatorPage.digiPropSec.click();
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		objCPSEffortEstimatorPage.chooseASPViewerNoOfScrns(i);
		objCPSEffortEstimatorPage.chooseAspViewerExpScrns(i);
		objCPSEffortEstimatorPage.choosePWAPackageNoOfScrns(i);
		objCPSEffortEstimatorPage.choosePWAPackageExpScrns(i);
		
		
		
	}

}

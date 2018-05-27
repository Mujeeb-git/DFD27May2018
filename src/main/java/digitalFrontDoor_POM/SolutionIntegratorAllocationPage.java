package digitalFrontDoor_POM;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SolutionIntegratorAllocationPage {

	WebDriver driver;
	int noOfSpeciality, noOfGeoUnit;
	String xpathStr, xpathStr2;
	JavascriptExecutor jse;

	@FindBy(xpath = "//*[@id='MainContent_UpdatePanel2']")
	public WebElement siAllocHeader;

	@FindBy(xpath = "//*[@id='ReqDashbtnsapid']")
	public WebElement oppIDBtn;

	@FindBy(xpath = "//*[@id='MainContent_txtBxSASAPID']")
	public WebElement oppIDField;

	@FindBy(xpath = "//*[@id='ReqDashbtnreqNo']")
	public WebElement requestNoBtn;

	@FindBy(xpath = "//*[@id='MainContent_txtBxSAReqno']")
	public WebElement requestNoField;

	// @FindBy(xpath = "//*[@id='txtClientNames']")
	@FindBy(xpath = "//*[@id='txtclient']")
	public WebElement clientNameField;

	@FindBy(xpath = "//*[@id='ui-id-1']/li[1]")
	public WebElement clientNameFieldLst1;

	@FindBy(xpath = "//*[@id='txtClientNames']/li/a")
	public WebElement clientNameDismissBtn1;

	@FindBy(xpath = "//*[@id='MainContent_lstbxSASpeciality_ms']")
	public WebElement specialityFieldBtn;

	@FindBy(xpath = "//*[@id='MainContent_lstbxSASpeciality_ms']/span[2]")
	public WebElement specialityFieldValue;

	@FindBy(xpath = "//*[@id='MainContent_lstbxSASpeciality']")
	public WebElement specialityDrpdwn;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[1]/a")
	public WebElement specialityCheckAllBtn;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	public WebElement specialityUncheckAllBtn;

	@FindBy(xpath = "//*[@id='MainContent_ddlSAGeoArea']")
	public WebElement geoAreaDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_lstbxSAGeoUnit']")
	public WebElement geoUnitDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_lstbxSAGeoUnit_ms']")
	public WebElement geoUnitDrpdwnBtn;

	@FindBy(xpath = "/html/body/div[7]/div/ul/li[1]/a/span[2]")
	public WebElement geoUnitCheckAllBtn;

	@FindBy(xpath = "/html/body/div[7]/div/ul/li[2]/a/span[2]")
	public WebElement geoUnitUncheckAllBtn;

	@FindBy(xpath = "//*[@id='txtBxSAReqStartDate']")
	public WebElement rqstCreationDateFromFieldBtn;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div/div[6]/div[2]/span[1]")
	public WebElement rqstCreationDateFromImg;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender1_prevArrow']")
	public WebElement rqstCreationDateFromPreMnthArrow;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender1_nextArrow']")
	public WebElement rqstCreationDateFromNxtMnthArrow;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender1_title']")
	public WebElement rqstCreationCalender1MonthYear;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender1_day_1_0']")
	public WebElement rqstCreationDateFromMnthDate;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div/div[6]/div[2]/span[2]")
	public WebElement rqstCreationDateFromClrBtn;

	@FindBy(xpath = "//*[@id='txtBxSAReqEndDate']")
	public WebElement rqstCreationDateToFieldBtn;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div/div[6]/div[3]/span[1]")
	public WebElement rqstCreationDateToImg;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_prevArrow']")
	public WebElement rqstCreationDateToPreMnthArrow;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_nextArrow']")
	public WebElement rqstCreationDateToNxtMnthArrow;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_title']")
	public WebElement rqstCreationCalender2MonthYear;

	@FindBy(xpath = "//*[@id='MainContent_CalendarExtender2_day_1_0']")
	public WebElement rqstCreationDateToMnthDate;

	@FindBy(xpath = "//*[@id='MainContent_pnlUpdate']/div/div/div/div[6]/div[3]/span[2]")
	public WebElement rqstCreationDateToClrBtn;

	// This is removed as part of the new change in this release - May 2018
	/*
	 * @FindBy(xpath = "//*[@id='MainContent_lstbxSAGDNInvolvement_ms']") public
	 * WebElement gdnInvolvFieldBtn;
	 */

	@FindBy(xpath = "//*[@id='MainContent_lstbxPodName_ms']")
	public WebElement mainPodNameDrpdwnBtn;

	@FindBy(xpath = "//*[@id='MainContent_lstbxPodName']")
	public WebElement mainPodNameDrpdwn;

	@FindBy(xpath = "/html/body/div[5]/div/ul/li[1]/a")
	public WebElement mainPodNameCheckAll;

	@FindBy(xpath = "/html/body/div[5]/div/ul/li[2]/a")
	public WebElement mainPodNameUncheckAll;

	@FindBy(xpath = "//*[@id='MainContent_lstbxReqCreationType_ms']")
	public WebElement typeOfSADrpdwnBtn;

	@FindBy(xpath = "//*[@id='MainContent_lstbxReqCreationType']")
	public WebElement typeOfSADrpdwn;

	@FindBy(xpath = "/html/body/div[6]/div/ul/li[1]/a")
	public WebElement typeOfSACheckAll;

	@FindBy(xpath = "/html/body/div[6]/div/ul/li[2]/a")
	public WebElement typeOfSAUncheckAll;

	@FindBy(xpath = "//*[@id='MainContent_lstbxRequestStatus_ms']")
	public WebElement reqStatusFieldBtn;

	@FindBy(xpath = "//*[@id='ddlSAAllocationRole']")
	public WebElement roleDrpdwn;

	@FindBy(xpath = "//*[@id='MainContent_btnSASearch']")
	public WebElement searchBtn;

	@FindBy(xpath = "//*[@id='MainContent_btnSAClear']")
	public WebElement clearBtn;

	@FindBy(xpath = "//*[@id='MainContent_RepSAAllocation_lnkSAEdit_0']")
	public WebElement editBtn;

	@FindBy(xpath = "//*[@id='MainContent_lblnoresults']")
	public WebElement noDealMsg;

	// search result grid labels
	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[2]")
	public WebElement requestIDColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[3]")
	public WebElement oppIDColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[4]")
	public WebElement clientNameColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[5]")
	public WebElement oppNameColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[6]")
	public WebElement specialityColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[7]")
	public WebElement mainPodColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[8]")
	public WebElement geoAreaUntColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[9]")
	public WebElement submsnDateColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[10]")
	public WebElement rqstStatusColLbl;

	@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/div[3]")
	public WebElement pagination;

	@FindBys(@FindBy(xpath = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr"))
	public List<WebElement> resultGridNoOfRows;

	// Solution Integrator form window
	@FindBy(xpath = "//*[@id='txtAssignSA']")
	public WebElement solIntegratorField;

	@FindBy(xpath = "//*[@id='peoplePickerID']/div/div[1]")
	public WebElement solIntegratorList1;

	@FindBy(xpath = "//*[@id='saveOnShore']")
	public WebElement solIntegratorSaveBtn;

	@FindBy(xpath = "//*[@id='txtAssignGDNSA']")
	public WebElement gdnLeadSDField;

	@FindBy(xpath = "//*[@id='peoplePickerID']/div/div[1]")
	public WebElement gdnLeadSDList1;

	@FindBy(xpath = "//*[@id='saveGDN']")
	public WebElement gdnLeadSDSaveBtn;

	@FindBy(xpath = "//*[@id='txtSANotes']")
	public WebElement allocationNotesArea;

	@FindBy(xpath = "//*[@id='btnSaveAllocatorNotes']")
	public WebElement saveNotesBtn;

	@FindBy(xpath = "//*[@id='btnSACancel']")
	public WebElement closeBtn;

	public SolutionIntegratorAllocationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// select speciality by text
	public void selectSpeciality(String speciality) throws Exception {
		jse = (JavascriptExecutor) driver;
		WebElement element;

		specialityFieldBtn.click();
		Thread.sleep(1000);

		noOfSpeciality = driver.findElements(By.xpath("/html/body/div[3]/ul/li")).size();

		for (int i = 1; i <= noOfSpeciality; i++) {
			element = driver.findElement(By.xpath("/html/body/div[3]/ul/li[" + i + "]/label/input"));
			if (element.getAttribute("title").equalsIgnoreCase(speciality)) {

				jse.executeScript("arguments[0].click();", element);
				break;
			}

		}

	}

	// select speciality by index
	public void selectSpeciality(int index) throws Exception {
		jse = (JavascriptExecutor) driver;
		specialityFieldBtn.click();
		Thread.sleep(1000);
		xpathStr2 = "/html/body/div[3]/ul/li[" + (1 + index) + "]/label/input";
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathStr2)));
		// driver.findElement(By.xpath(xpathStr2)).click();
	}

	// select geoUnit by index
	public void selectGeoUnit(int index) throws Exception {
		jse = (JavascriptExecutor) driver;
		geoUnitDrpdwnBtn.click();
		Thread.sleep(1000);
		xpathStr2 = "//*[@id='ui-multiselect-4-MainContent_lstbxSAGeoUnit-option-" + index + "']";
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathStr2)));
		geoUnitDrpdwnBtn.click();
	}

	// select speciality by text
	public void selectGeoUnit(String geoUnitStr) throws Exception {
		jse = (JavascriptExecutor) driver;
		WebElement element;

		geoUnitDrpdwnBtn.click();
		Thread.sleep(1000);

		noOfGeoUnit = driver.findElements(By.xpath("/html/body/div[6]/ul/li")).size();

		for (int i = 0; i < noOfGeoUnit; i++) {
			element = driver
					.findElement(By.xpath("//*[@id='ui-multiselect-5-MainContent_lstbxSAGeoUnit-option-" + i + "']"));
			if (element.getAttribute("title").equalsIgnoreCase(geoUnitStr)) {

				jse.executeScript("arguments[0].click();", element);
				break;
			}

		}

	}

	// Choose speciality value
	public String getSpecialityValue(int i) {

		Select selectBox = new Select(specialityDrpdwn);
		// Get all options
		List<WebElement> options = selectBox.getOptions();
		// return options.get(i).getText();
		return options.get(i).getAttribute("innerText");

	}

	// Choose speciality
	public void chooseSpeciality(int i) {

		Select selectBox = new Select(specialityDrpdwn);
		selectBox.selectByIndex(i);

	}

	// Choose geoArea
	public void chooseGeoArea(int i) {

		Select selectBox = new Select(geoAreaDrpdwn);
		selectBox.selectByIndex(i);

	}

	// Choose geoArea by visible text
	public void chooseGeoArea(String vText) {

		Select selectBox = new Select(geoAreaDrpdwn);
		selectBox.selectByVisibleText(vText);

	}

	// Choose speciality by visibleText
	public void chooseSpeciality(String text) {

		Select selectBox = new Select(specialityDrpdwn);
		selectBox.selectByVisibleText(text);
		;

	}

	// No of speciality options
	public int noOfSpeciality() {

		Select selectBox = new Select(specialityDrpdwn);
		// Get all options
		List<WebElement> options = selectBox.getOptions();
		return options.size();

	}

	// get Geo Area Values
	public String geoAreaOptions(int i) {

		Select selectGA = new Select(geoAreaDrpdwn);

		// Get all options
		List<WebElement> options = selectGA.getOptions();
		return options.get(i).getText();
	}

	// Get geo unit values
	public String geoUnitOptions(int i) {

		Select selectSS = new Select(geoUnitDrpdwn);

		// Get all options
		List<WebElement> options = selectSS.getOptions();
		return options.get(i).getAttribute("innerText");

	}

	// Get geo unit number of values
	public int geoUnitNoOfOptions() {

		Select selectSS = new Select(geoUnitDrpdwn);

		// Get all options
		List<WebElement> options = selectSS.getOptions();
		return options.size();

	}

	// verify if the result is present in the page
	public boolean isGridPresent(WebDriver driver) {
		try {
			// if(driver.findElements(By.xpath("//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[1]/th[2]")).size()>0)
			// if
			// (driver.findElements(By.xpath("html/body/form/div/div/div/div[3]/div[1]/table/tbody/tr")).size()
			// > 0)
			if (driver.findElements(By.xpath("//*[@id='MainContent_upRepeater']")).size() > 0)
				return true;
			else
				return false;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}

	}

	// retrive the result grid speciality for a particular row
	public String gridRowSpeciality(int i) {
		xpathStr = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[" + (2 + i) + "]/td[6]";

		return driver.findElement(By.xpath(xpathStr)).getText();

	}

	// retrieve the result grid Geo Area-unit
	public String gridGeoAreaUnit(int i) {
		xpathStr = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[" + (2 + i) + "]/td[8]";

		return driver.findElement(By.xpath(xpathStr)).getText();

	}
	
	// retrieve the result Req Creation date
		public String gridReqCreationDate(int i) {
			xpathStr = "//*[@id='MainContent_upRepeater']/div[1]/table/tbody/tr[" + (2 + i) + "]/td[9]";

			return driver.findElement(By.xpath(xpathStr)).getText();

		}

	public void selectRqCrDateFrom(String rqstCreationDate) throws Exception {

		try {
			// select date (From)
			rqstCreationDateFromImg.click();
			Thread.sleep(1000);
			rqstCreationDateFromNxtMnthArrow.click();
			Thread.sleep(1000);
			do {			
				
				rqstCreationDateFromPreMnthArrow.click();
				Thread.sleep(1000);
				
				if (rqstCreationCalender1MonthYear.getText()
						.substring(0, (rqstCreationCalender1MonthYear.getText().indexOf(',')))
						.equalsIgnoreCase(rqstCreationDate.substring(0, (rqstCreationDate.indexOf(',') - 3)))
						&& rqstCreationCalender1MonthYear.getText()
								.substring(rqstCreationCalender1MonthYear.getText().length() - 4)
								.equalsIgnoreCase(rqstCreationDate.substring(rqstCreationDate.length() - 4))) {
					//Reporter.log("entered into the block of if condition",true);
					for (int i = 1; i <= 6; i++) {
						for(int j=1;j<=7;j++) {
						xpathStr = "//*[@id='MainContent_CalendarExtender1_daysBody']/tr[" + i + "]/td["+j+"]/div";
						//Reporter.log("The title of the element is :"+((driver.findElement(By.xpath(xpathStr)).getAttribute("title")).substring(driver.findElement(By.xpath(xpathStr)).getAttribute("title").indexOf(',')+2)),true);
						if ((driver.findElement(By.xpath(xpathStr)).getAttribute("title")).substring(driver.findElement(By.xpath(xpathStr)).getAttribute("title").indexOf(',')+2)
								.equalsIgnoreCase(rqstCreationDate)) {
							driver.findElement(By.xpath(xpathStr)).click();
							return;
						}
						}

					}
					
					
					
				} 
				
				
			} while (!(rqstCreationCalender1MonthYear.getText()
					.substring(0, (rqstCreationCalender1MonthYear.getText().indexOf(',')) )
					.equalsIgnoreCase(rqstCreationDate.substring(0, (rqstCreationDate.indexOf(',') - 3)))
					&& rqstCreationCalender1MonthYear.getText()
							.substring(rqstCreationCalender1MonthYear.getText().length() - 4)
							.equalsIgnoreCase(rqstCreationDate.substring(rqstCreationDate.length() - 4))));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public void selectRqCrDateTo(String rqstCreationDate2) throws Exception {

		try {
			// select date (From)
			rqstCreationDateToImg.click();
			Thread.sleep(1000);
			rqstCreationDateToNxtMnthArrow.click();
			Thread.sleep(1000);
			do {			
				
				rqstCreationDateToPreMnthArrow.click();
				Thread.sleep(1000);
								
				if (rqstCreationCalender2MonthYear.getText()
						.substring(0, (rqstCreationCalender2MonthYear.getText().indexOf(',')) )
						.equalsIgnoreCase(rqstCreationDate2.substring(0, (rqstCreationDate2.indexOf(',') - 3)))
						&& rqstCreationCalender2MonthYear.getText()
								.substring(rqstCreationCalender2MonthYear.getText().length() - 4)
								.equalsIgnoreCase(rqstCreationDate2.substring(rqstCreationDate2.length() - 4))) {
					//Reporter.log("entered into the block of if condition",true);
					for (int i = 1; i <= 6; i++) {
						for(int j=1;j<=7;j++) {
						xpathStr = "//*[@id='MainContent_CalendarExtender2_daysBody']/tr[" + i + "]/td["+j+"]/div";
						//Reporter.log("The xpath is: //*[@id='MainContent_CalendarExtender2_daysBody']/tr[" + i + "]/td["+j+"]/div",true);
						//Reporter.log("The title of the element is :"+((driver.findElement(By.xpath(xpathStr)).getAttribute("title")).substring(driver.findElement(By.xpath(xpathStr)).getAttribute("title").indexOf(',')+2)),true);
						if ((driver.findElement(By.xpath(xpathStr)).getAttribute("title")).substring(driver.findElement(By.xpath(xpathStr)).getAttribute("title").indexOf(',')+2)
								.equalsIgnoreCase(rqstCreationDate2)) {
							driver.findElement(By.xpath(xpathStr)).click();
							//Reporter.log("The 'To' date is clicked",true);
							return;
						}
						}

					}
					
					
					
				} 
				
				
			} while (!(rqstCreationCalender2MonthYear.getText()
					.substring(0, (rqstCreationCalender2MonthYear.getText().indexOf(',')) )
					.equalsIgnoreCase(rqstCreationDate2.substring(0, (rqstCreationDate2.indexOf(',') - 3)))
					&& rqstCreationCalender2MonthYear.getText()
							.substring(rqstCreationCalender2MonthYear.getText().length() - 4)
							.equalsIgnoreCase(rqstCreationDate2.substring(rqstCreationDate2.length() - 4))));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}

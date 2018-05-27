package utilitiesFunctionLibrary;
/**
 * @author mujeeb.mohammed
 *
 */
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import digitalFrontDoor_POM.LoginPage;

public class Utility {
	String d, dateMonth,xpathStr, path, userName, encryptedPassword, decryptedPassword, env, Date1, Date2, monthStr, monthNum,
			dateNum, YearNum, dateNumStr, yearNum;
	WebDriver driver;
	LoginPage objLoginPage;
	WebDriverWait wait;
	int dateNumTmp;
	Double largestNumber;
	LocalDate date;
	
	//To check if an element is located in the Page/DOM
	public boolean isElementPresent(WebDriver driver, String xpathStr){
        try{
        	if(driver.findElements(By.xpath(xpathStr)).size()>0)
            return true;
        	else return false;
        }
        catch(TimeoutException |NoSuchElementException  e){
            return false;
        }

    }

	//Add number of working days to todays date and return date in the format 'd MMM yyyy'("7 Jun 2018")
	public String addWorkingDays(int workdays) {
		date = LocalDate.now();
		if (workdays < 1) {
			Date date2 = java.sql.Date.valueOf(date);
			SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
			//System.out.println("date=========" + formatter.format(date2));
			return formatter.format(date2).toString();
		}

		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < workdays) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}

		Date date2 = java.sql.Date.valueOf(result);

		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
		//System.out.println("date=========" + formatter.format(date2));
		return formatter.format(date2).toString();

	}

	// find the largest Number (double)
	public Double findLargestNumber(List<Double> inputs) {

		largestNumber = Collections.max(inputs);
		return largestNumber;

	}

	// Add number of working days to get the day
	public Date addCalenderDays(int addDays) {

		Date currentDate = new Date();

		// convert date to calendar
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		// add days to the current data
		c.add(Calendar.DATE, addDays); // same with c.add(Calendar.DAY_OF_MONTH, 1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();

		return currentDatePlusOne;
	}

	// Read data from excel for DFD
	public String getDFDData(int rowNum, String SheetName) throws IOException {
		path = System.getProperty("user.dir") + "\\src\\DataResource\\Data Sheet.xlsx";
		return ExcelReadWrite.readExcel(path, SheetName, rowNum, 1);
	}

	// Open Web Application
	public WebDriver OpenApp(String BrowserName, String url) {
		fn_LaunchBrowser(BrowserName);
		fn_OpenURL(url);
		return driver;
	}

	public void fn_OpenURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public WebDriver fn_LaunchBrowser(String browsername) {
		if (("chrome").equalsIgnoreCase(browsername)) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (("ff").equalsIgnoreCase(browsername)) {
			driver = new FirefoxDriver();
		} else if (("ie").equalsIgnoreCase(browsername)) {
			System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver dfdLogin(String env) throws Exception {
		// UserCreds
		userName = "mujeeb.mohammed";
		encryptedPassword = "TmV2ZXJzZXR0bGVANw==";
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		decryptedPassword = new String(decryptedPasswordBytes);

		wait = new WebDriverWait(driver, 120);
		// Login Page - Enter credentials
		objLoginPage = new LoginPage(driver);
		objLoginPage.userName.sendKeys(userName);
		objLoginPage.password.sendKeys(decryptedPassword);
		objLoginPage.submit.click();
		Thread.sleep(20000);
		if (!("Welcome to the Digital Front Door").equalsIgnoreCase(driver.getTitle())) {
			objLoginPage.confirmYourIdentity();
			Thread.sleep(2000);
			objLoginPage.enterSecurityCodeField.click();
		}
		// 30s timeout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BanQuickLinks\"]/div/a[1]/p")));
		return driver;
	}

	public int check4NewTabnNavigate(WebDriver driver, WebElement element) throws Exception {
		this.driver = driver;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		int windowHandlesSize = driver.getWindowHandles().size();
		driver.switchTo().window(tabs2.get(windowHandlesSize - 1));
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(tabs2.get(windowHandlesSize - 2));
		return windowHandlesSize;
	}

	// default drop down value
	public String defaultSelectValue(WebElement ele) {

		Select selectDS = new Select(ele);

		// Get all options
		List<WebElement> options = selectDS.getOptions();
		for (WebElement option : options) {
			if (option.isSelected()) {
				return option.getText();
			}

		}
		return null;

	}

	// Retrieve current date in the yyyy_MM_dd_HH_mm_ss format
	public String dateString() {
		// Date to String
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		d = dateFormat.format(date);
		// Reporter.log("The current date is "+d,true);
		return d;

	}

	// Retrieve current date in the yyyyMMddHHmmss format
	public String dateString2() {
		// Date to String
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		d = dateFormat.format(date);
		// Reporter.log("The current date is "+d,true);
		return d;

	}

	// add days to the current system date
	public String addDays(int days) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		GregorianCalendar cal = new GregorianCalendar();
		Date date = new Date();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		d = dateFormat.format(cal.getTime());
		return d.toString();
	}

	// Take Screenshot of the web page
	public void screenshot(WebDriver driver) {
		// get current date time in string format
		d = dateString();
		dateMonth = d.substring(5, 10);
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Mujeeb\\Screenshots\\" + dateMonth + "\\Screenshot_" + d + ".png"));
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	// Generate Random number between maximum and minimum
	public int generateRandomNumber(int min, int max) {

		int diff = max - min;
		Random rn = new Random();
		int i = rn.nextInt(diff + 1);
		i += min;
		return i;
	}

	// Write data to the Excel using rowNumber and Data where column, sheetName and
	// path doesn't change
	public void writeDataToExcel(int rowNum, String dataToWrite) throws IOException {
		path = System.getProperty("user.dir") + "\\src\\DataResource\\Data Sheet.xlsx";
		// Reporter.log(System.getProperty("user.dir"),true);
		// Reporter.log(path,true);
		ExcelReadWrite.writeExcel(path, "Sheet1", rowNum, 2, dataToWrite);
	}

	// Write data to the Excel using rowNumber and Data where column, sheetName and
	// path doesn't change
	public String readDataFromExcel(int rowNum) throws IOException {
		path = System.getProperty("user.dir") + "\\src\\DataResource\\Data Sheet.xlsx";
		return ExcelReadWrite.readExcel(path, "Sheet1", rowNum, 2);
	}

	public boolean isAlertPresents(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}

	public String getmmDDyyDate(String Date1) {
		// input date should be in the format Date1 = "Sunday, August 05, 2018";
		// output should be in the format Date2 = "8/5/2018";
		monthStr = (Date1.substring(Date1.indexOf(",") + 2)).substring(0,
				(Date1.substring(Date1.indexOf(",") + 2)).indexOf(",") - 3);
		monthNum = getMonthNum(monthStr);
		dateNumStr = (Date1.substring(Date1.indexOf(",") + 2)).substring(
				(Date1.substring(Date1.indexOf(",") + 2)).indexOf(",") - 2,
				(Date1.substring(Date1.indexOf(",") + 2)).indexOf(","));
		dateNumTmp = Integer.parseInt(dateNumStr);
		dateNum = Integer.toString(dateNumTmp);
		yearNum = Date1.substring(Date1.indexOf(",") + 2)
				.substring(Date1.substring(Date1.indexOf(",") + 2).indexOf(",") + 2);
		Date2 = monthNum + "/" + dateNum + "/" + yearNum;
		return Date2;

	}
	
	public String getddMMMyyy(String dateStr) throws Exception {
		
		String deliverydate=dateStr;
		SimpleDateFormat sdf=new SimpleDateFormat("MMMM dd, yyyy");

		Date date=sdf.parse(deliverydate);

		sdf=new SimpleDateFormat("dd MMM yyyy");
		return sdf.format(date).toString();
	}

	public String getMonthNum(String month) {
		Map<String, String> monthKV = new HashMap<String, String>();
		monthKV.put("January", "1");
		monthKV.put("Febraury", "2");
		monthKV.put("March", "3");
		monthKV.put("April", "4");
		monthKV.put("May", "5");
		monthKV.put("June", "6");
		monthKV.put("July", "7");
		monthKV.put("August", "8");
		monthKV.put("September", "9");
		monthKV.put("October", "10");
		monthKV.put("November", "11");
		monthKV.put("December", "12");

		return monthKV.get(month);
	}

}

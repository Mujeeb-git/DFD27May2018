package digitalFrontDoor_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DSDCostEstimatorPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[2]/p")
	public WebElement dsdCostEstimatorDesc;

	// table column headers
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[1]/th[1]")
	public WebElement tableColumn1Heading;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[1]/th[2]")
	public WebElement tableColumn2Heading;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[1]/th[3]")
	public WebElement tableColumn3Heading;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[1]/th[4]")
	public WebElement tableColumn4Heading;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[1]/th[5]")
	public WebElement tableColumn5Heading;

	// table row Tower headers
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[2]/th")
	public WebElement tower1Heading;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[16]/th")
	public WebElement tower2Heading;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[26]/th")
	public WebElement tower3Heading;

	// Quick links
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[1]/a")
	public WebElement admEstiInventQL;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[1]/a")
	public WebElement admEstiRulesThumbQL;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[1]/a")
	public WebElement faq4AdmEstiQL;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[1]/a")
	public WebElement admResourcePlnrQL;

	// Thank you note
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[2]/p")
	public WebElement thankYouNote;

	// Digital Offering Column values (Tower - Interactive)
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[2]/td[1]")
	public WebElement IntDigiOfferingRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[3]/td[1]")
	public WebElement IntDigiOfferingRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[4]/td[1]")
	public WebElement IntDigiOfferingRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[5]/td[1]")
	public WebElement IntDigiOfferingRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[6]/td[1]")
	public WebElement IntDigiOfferingRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[7]/td[1]")
	public WebElement IntDigiOfferingRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[8]/td[1]")
	public WebElement IntDigiOfferingRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[9]/td[1]")
	public WebElement IntDigiOfferingRow8;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[10]/td[1]")
	public WebElement IntDigiOfferingRow9;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[11]/td[1]")
	public WebElement IntDigiOfferingRow10;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[12]/td[1]")
	public WebElement IntDigiOfferingRow11;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[13]/td[1]")
	public WebElement IntDigiOfferingRow12;

	// Category Column values (Tower - Interactive)
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[2]/td[2]")
	public WebElement IntCategoryRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[3]/td[2]")
	public WebElement IntCategoryRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[4]/td[2]")
	public WebElement IntCategoryRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[5]/td[2]")
	public WebElement IntCategoryRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[6]/td[2]")
	public WebElement IntCategoryRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[7]/td[2]")
	public WebElement IntCategoryRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[8]/td[2]")
	public WebElement IntCategoryRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[9]/td[2]")
	public WebElement IntCategoryRow8;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[10]/td[2]")
	public WebElement IntCategoryRow9;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[11]/td[2]")
	public WebElement IntCategoryRow10;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[12]/td[2]")
	public WebElement IntCategoryRow11;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[13]/td[2]")
	public WebElement IntCategoryRow12;

	// Estimator Column values (Tower - Interactive)
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[2]/td[3]/a")
	public WebElement IntEstimatorRow1Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[3]/td[3]/a")
	public WebElement IntEstimatorRow2Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[4]/td[3]/a")
	public WebElement IntEstimatorRow3Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[5]/td[3]/a")
	public WebElement IntEstimatorRow4Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[6]/td[3]/a")
	public WebElement IntEstimatorRow5Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[7]/td[3]/a")
	public WebElement IntEstimatorRow6Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[8]/td[3]/a")
	public WebElement IntEstimatorRow7Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[9]/td[3]/a")
	public WebElement IntEstimatorRow8Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[10]/td[3]/a[1]")
	public WebElement IntEstimatorRow9Lnk1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[10]/td[3]/a[1]")
	public WebElement IntEstimatorRow9Lnk2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[11]/td[3]/a")
	public WebElement IntEstimatorRow10Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[12]/td[3]/a")
	public WebElement IntEstimatorRow11Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[13]/td[3]/a[1]")
	public WebElement IntEstimatorRow12Lnk1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[13]/td[3]/a[2]")
	public WebElement IntEstimatorRow12Lnk2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[13]/td[3]/a[3]")
	public WebElement IntEstimatorRow12Lnk3;

	// --

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[2]/td[3]")
	public WebElement IntEstimatorRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[3]/td[3]")
	public WebElement IntEstimatorRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[4]/td[3]")
	public WebElement IntEstimatorRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[5]/td[3]")
	public WebElement IntEstimatorRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[6]/td[3]")
	public WebElement IntEstimatorRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[7]/td[3]")
	public WebElement IntEstimatorRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[8]/td[3]")
	public WebElement IntEstimatorRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[9]/td[3]")
	public WebElement IntEstimatorRow8;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[10]/td[3]")
	public WebElement IntEstimatorRow9;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[11]/td[3]")
	public WebElement IntEstimatorRow10;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[12]/td[3]")
	public WebElement IntEstimatorRow11;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[13]/td[3]")
	public WebElement IntEstimatorRow12;

	// Digital Offering Column values (Tower - Analytics)

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[16]/td[1]")
	public WebElement AnalyDigiOfferingRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[17]/td[1]")
	public WebElement AnalyDigiOfferingRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[18]/td[1]")
	public WebElement AnalyDigiOfferingRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[19]/td[1]")
	public WebElement AnalyDigiOfferingRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[20]/td[1]")
	public WebElement AnalyDigiOfferingRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[21]/td[1]")
	public WebElement AnalyDigiOfferingRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[22]/td[1]")
	public WebElement AnalyDigiOfferingRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[23]/td[1]")
	public WebElement AnalyDigiOfferingRow8;

	// Category Column values (Tower - Analytics)
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[16]/td[2]")
	public WebElement AnalyCategoryRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[17]/td[2]")
	public WebElement AnalyCategoryRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[18]/td[2]")
	public WebElement AnalyCategoryRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[19]/td[2]")
	public WebElement AnalyCategoryRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[20]/td[2]")
	public WebElement AnalyCategoryRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[21]/td[2]")
	public WebElement AnalyCategoryRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[22]/td[2]")
	public WebElement AnalyCategoryRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[23]/td[2]")
	public WebElement AnalyCategoryRow8;

	// Estimator Column values (Tower - Analytics)
	// anchor tags
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[16]/td[3]/a")
	public WebElement AnalyEstimatorRow1Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[17]/td[3]/a")
	public WebElement AnalyEstimatorRow2Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[18]/td[3]/a")
	public WebElement AnalyEstimatorRow3Lnk;

	/*
	 * @FindBy(xpath =
	 * "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[5]/td[3]/a")
	 * public WebElement AnalyEstimatorRow4Lnk;
	 */

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[20]/td[3]/a")
	public WebElement AnalyEstimatorRow5Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[21]/td[3]/a[1]")
	public WebElement AnalyEstimatorRow6Lnk1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[21]/td[3]/a[2]")
	public WebElement AnalyEstimatorRow6Lnk2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[22]/td[3]/a")
	public WebElement AnalyEstimatorRow7Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[23]/td[3]/a")
	public WebElement AnalyEstimatorRow8Lnk;

	// --column data
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[16]/td[3]")
	public WebElement AnalyEstimatorRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[17]/td[3]")
	public WebElement AnalyEstimatorRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[18]/td[3]")
	public WebElement AnalyEstimatorRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[19]/td[3]")
	public WebElement AnalyEstimatorRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[20]/td[3]")
	public WebElement AnalyEstimatorRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[21]/td[3]")
	public WebElement AnalyEstimatorRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[22]/td[3]")
	public WebElement AnalyEstimatorRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[23]/td[3]")
	public WebElement AnalyEstimatorRow8;

	// Digital Offering Column values (Tower - Mobility)

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[26]/td[1]")
	public WebElement MobilityDigiOfferingRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[27]/td[1]")
	public WebElement MobilityDigiOfferingRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[28]/td[1]")
	public WebElement MobilityDigiOfferingRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[29]/td[1]")
	public WebElement MobilityDigiOfferingRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[30]/td[1]")
	public WebElement MobilityDigiOfferingRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[31]/td[1]")
	public WebElement MobilityDigiOfferingRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[32]/td[1]")
	public WebElement MobilityDigiOfferingRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[33]/td[1]")
	public WebElement MobilityDigiOfferingRow8;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[34]/td[1]")
	public WebElement MobilityDigiOfferingRow9;
	
	// Category Column values (Tower – Mobility)
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[26]/td[2]")
	public WebElement MobilityCategoryRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[27]/td[2]")
	public WebElement MobilityCategoryRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[28]/td[2]")
	public WebElement MobilityCategoryRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[29]/td[2]")
	public WebElement MobilityCategoryRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[30]/td[2]")
	public WebElement MobilityCategoryRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[31]/td[2]")
	public WebElement MobilityCategoryRow6;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[32]/td[2]")
	public WebElement MobilityCategoryRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[33]/td[2]")
	public WebElement MobilityCategoryRow8;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[34]/td[2]")
	public WebElement MobilityCategoryRow9;
	
	// Estimator Column values (Tower - Mobility)
	//anchor tags
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[26]/td[3]/a")
	public WebElement MobilityEstimatorRow1Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[27]/td[3]/a")
	public WebElement MobilityEstimatorRow2Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[28]/td[3]/a")
	public WebElement MobilityEstimatorRow3Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[29]/td[3]/a")
	public WebElement MobilityEstimatorRow4Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[30]/td[3]/a")
	public WebElement MobilityEstimatorRow5Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[31]/td[3]/a")
	public WebElement MobilityEstimatorRow6Lnk;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[33]/td[3]/a")
	public WebElement MobilityEstimatorRow8Lnk;
	
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[34]/td[3]/a")
	public WebElement MobilityEstimatorRow9Lnk;

	//--column data
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[26]/td[3]")
	public WebElement MobilityEstimatorRow1;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[27]/td[3]")
	public WebElement MobilityEstimatorRow2;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[28]/td[3]")
	public WebElement MobilityEstimatorRow3;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[29]/td[3]")
	public WebElement MobilityEstimatorRow4;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[30]/td[3]")
	public WebElement MobilityEstimatorRow5;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[31]/td[3]")
	public WebElement MobilityEstimatorRow6;
	
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[32]/td[3]")
	public WebElement MobilityEstimatorRow7;

	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[33]/td[3]")
	public WebElement MobilityEstimatorRow8;
	
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[1]/table/tbody/tr[34]/td[3]")
	public WebElement MobilityEstimatorRow9;

	//Estimator Quick Links
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[1]/a")
	public WebElement admEstiInventryQL;
	
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[2]/a")
	public WebElement admEstiRulesThumQL;
	
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[3]/a")
	public WebElement faq4ADMEstimatorQL;
	
	@FindBy(xpath = "//*[@id='s4-bodyContainer']/div[2]/div/div[5]/div[1]/div[2]/ul/li[4]/a")
	public WebElement admResourcPlnrQL;
	
	


	public DSDCostEstimatorPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all public WebElements

		PageFactory.initElements(driver, this);

	}

}

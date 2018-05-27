package digitalFrontDoor_POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DFDHomePage {

	WebDriver driver;
	JavascriptExecutor jse;

	@FindBy(xpath = "//*[@id='above-banner']/div/div/div[2]/div[1]/h3[1]")
	public WebElement welcomeHeader;

	@FindBy(xpath = "//*[@id='above-banner']/div/div/div[2]/div[1]/h3[2]")
	public WebElement dfdHeader;

	@FindBy(xpath = "//*[@id='above-banner']/div/div/div[2]/div[2]/p[1]")
	public WebElement dfdPara1;

	@FindBy(xpath = "//*[@id='above-banner']/div/div/div[2]/div[2]/p[2]/span")
	public WebElement dfdPara2;

	@FindBy(xpath = "//*[@id='homeHeader']/div[1]/div[1]/div/div[1]/ul/li/a/img[2]")
	public WebElement homeButton; // this is inner page home button

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div/nav/div/ul/li[1]/a")
	public WebElement mHomeLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[1]/div[1]/div/div[2]/ul/li[2]/a")
	public WebElement menuLnk;
	
	@FindBy(xpath = "//*[@id='lblLogin']")
	public WebElement userNameLnk;
	
	@FindBy(xpath = "//*[@id='hlLogOut']")
	public WebElement logOutLnk;
	
	@FindBy(xpath = "//*[@id='homeHeader']/div[1]/div[1]/div/div[2]/ul/li[3]")
	public WebElement envLabel;

	//Escalation and Feedback (in the footer)
	@FindBy(xpath = "//*[@id='Contacts-footer']/div/section/div/div/div[1]/div/span[1]/a")
	public WebElement ealaLnk;
	
	@FindBy(xpath = "//*[@id='Contacts-footer']/div/section/div/div/div[1]/div/span[2]/a")
	public WebElement apacLnk;
	
	@FindBy(xpath = "//*[@id='Contacts-footer']/div/section/div/div/div[1]/div/span[3]/a")
	public WebElement northAmericaLnk;
	
	@FindBy(xpath = "//*[@id='Contacts-footer']/div/section/div/div/div[1]/div/span[4]/a")
	public WebElement latinAmericaLnk;
	
	@FindBy(xpath = "//*[@id='Contacts-footer']/div/section/div/div/div[1]/div/span[5]/a")
	public WebElement gdnLnk;
	
	@FindBy(xpath = "//*[@id='Contacts-footer']/div/section/div/div/div[1]/div/span[6]/a")
	public WebElement globalLnk;
	
	
	
	// @FindBy(xpath =
	// "//*[@id='BanQuickLinks']/div/a[1]/p[contains(text(),'SOLUTION ARCHITECT')]")
	@FindBy(xpath = "//*[@id='BanQuickLinks']/div/a[1]")
	public WebElement solArchBtn;

	@FindBy(xpath = "//*[@id='BanQuickLinks']/div/a[1]")
	public WebElement solArchBtn1;

	// FindBy(xpath = "//*[@id='BanQuickLinks']/div/a[2]/p[contains(text(),'SUBJECT
	// MATTER EXPERT')]")
	@FindBy(xpath = "//*[@id='BanQuickLinks']/div/a[2]")
	public WebElement SMEBtn;

	@FindBy(xpath = "//*[@id='BanQuickLinks']/div/a[2]")
	public WebElement SMEBtn1;

	// @FindBy(xpath =
	// "//*[@id='BanQuickLinks']/div/a[3]/p[contains(text(),'PROPOSAL
	// SPECIALIST')]")
	@FindBy(xpath = "//*[@id='BanQuickLinks']/div/a[3]")
	public WebElement pSpecialistBtn;

	@FindBy(xpath = "//*[@id='BanQuickLinks']/div/a[3]")
	public WebElement pSpecialistBtn1;

	// Menu Options
	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[2]/span")
	// @FindBy(xpath="//span[contains(text(),'Submit Request')][@class='wrapped
	// active']")
	public WebElement submitRequestLnk;

	@FindBy(xpath = "//*[@type='text'][@id='menu-search']")
	public WebElement mSearchBox;
	
	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[2]/ul/li[1]/a")
	public WebElement mSolArchLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[2]/ul/li[2]/a")
	public WebElement mpSpecialistLnkn;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[2]/ul/li[3]/a")
	public WebElement mSMELnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[2]/ul/li[4]/a")
	public WebElement mEditSolArchLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[3]/a")
	public WebElement mNewSalesSRecordLnk;

	// @FindBy(xpath = "//*[@id='siteMenu']/ul/li[4]/")
	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[4]/span")
	public WebElement mManageAllocationLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[4]/ul[1]/li[1]/a")
	public WebElement mSIAllocLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[4]/ul[1]/li[2]/a")
	public WebElement mPropSplAllocLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[4]/ul[1]/li[3]/a")
	public WebElement mSMEAllocLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div[1]/ul/li[4]/ul[1]/li[4]/a")
	public WebElement mMngExcepReqLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[5]/span")
	public WebElement mMyHmeLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[5]/ul/li[1]/a")
	public WebElement mSDbwUpdateLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[5]/ul/li[2]/a")
	public WebElement mMySolLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[5]/ul/li[3]/a")
	public WebElement mMySalesSRecLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/span")
	public WebElement mReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[1]/a")
	public WebElement mSIMasterReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[2]/a")
	public WebElement mSolTrackReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[3]/a")
	public WebElement mGDNTrackReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[4]/a")
	public WebElement mBWReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[5]/a")
	public WebElement mPropReqReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[6]/a")
	public WebElement mSMEReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[7]/a")
	public WebElement mTime2SolReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[8]/a")
	public WebElement mSalesSRecReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[6]/ul/li[9]/a")
	public WebElement mSolcomplReportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[7]/a")
	public WebElement mDocSearchLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[8]/span")
	public WebElement mUtilitiesLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[8]/ul/li[1]")
	public WebElement mEditSolPlanLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[8]/ul/li[2]/span")
	public WebElement mViewOpportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[8]/ul/li[2]/ul/li[1]/a")
	public WebElement mSearchNviewOpportLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[8]/ul/li[2]/ul/li[2]/a")
	public WebElement mOpportDetailsLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[8]/ul/li[2]/ul/li[3]/a")
	public WebElement mMngOpportListLnk;

	@FindBy(xpath = "//*[@id='homeHeader']/div[2]/div[1]/nav/div/ul/li[8]/ul/li[3]/a")
	public WebElement mCreateSSRecordLnk;

	// Quick Links

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/h4")
	public WebElement opModelnMethodologyQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/h4")
	public WebElement propSuppnTemplateQL;
	
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/h4/i")
	public WebElement propSuppnTemplateExpand;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/h4")
	public WebElement digiSolDesignToolsQL;
	
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/h4/i")
	public WebElement digiSolDesignToolsExpand;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/h4")
	public WebElement nonDiginSalesRefMaterQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/h4")
	public WebElement newITnSecurityQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/h4")
	public WebElement trainingnDevQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/h4")
	public WebElement collToolsQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/h4")
	public WebElement contactsQL;

	// sub Quick Links
	// Operating Model & Methodology
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/h4/span")
	public WebElement opModelnMethodologyQLDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[1]/h4/a")
	public WebElement dsdOpModelOverviewQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[2]/h4/a")
	public WebElement dsdOpModelSolQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[3]/h4/a")
	public WebElement adm4DigiSolDesingQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[4]/h4/a")
	public WebElement swivelAlphaMethodQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[5]/h4/a")
	public WebElement accDigiOfferingsQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[6]/h4/a")
	public WebElement dsdInnoServicesQL;

	// sublink desc

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[1]/h4/span")
	public WebElement dsdOpModelOverviewDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[2]/h4/span")
	public WebElement dsdOpModelSolDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[3]/h4/span")
	public WebElement adm4DigiSolDesingDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[4]/h4/span")
	public WebElement swivelAlphaMethodDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[5]/h4/span")
	public WebElement accDigiOfferingsDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[1]/div/div/div[6]/h4/span")
	public WebElement dsdInnoServicesDescQL;

	// sub Quick Links
	// Proposal Support & Templates
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/h4/span")
	public WebElement propSuppnTemplatesQLDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[1]/h4/a")
	public WebElement creatPropStudKXQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[2]/h4/a")
	public WebElement clientWinsnSuccessQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[3]/h4/a")
	public WebElement digiPropCenRepoQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[4]/h4/a")
	public WebElement accDigiSecPropVwrQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[5]/h4/a")
	public WebElement oneStpShp4PropSprtResQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[6]/h4/a")
	public WebElement accDigiPreTempsQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[7]/h4/a")
	public WebElement accDigiBrandWdTmpQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[8]/h4/a")
	public WebElement swivelDemoSiteQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[9]/h4/a")
	public WebElement dsdInnoCredsQL;

	// sub link description
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[1]/h4/span")
	public WebElement creatPropStudKXDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[2]/h4/span")
	public WebElement clientWinsnSuccessDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[3]/h4/span")
	public WebElement digiPropCenRepoDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[4]/h4/span")
	public WebElement accDigiSecPropVwrDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[5]/h4/span")
	public WebElement oneStpShp4PropSprtResDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[6]/h4/span")
	public WebElement accDigiPreTempsDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[7]/h4/span")
	public WebElement accDigiBrandWdTmpDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[8]/h4/span")
	public WebElement swivelDemoSiteDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[2]/div/div/div[9]/h4/span")
	public WebElement dsdInnoCredsDescQL;

	// sub Quick Links
	// Digital Solution Design Tools
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/h4/span")
	public WebElement digiSolDesignToolsQLDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[1]/h4/a")
	public WebElement digiSolPlanTempQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[2]/h4/a")
	public WebElement digiRegArchQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[3]/h4/a")
	public WebElement digiResPlanrsQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[4]/h4/a")
	public WebElement digiEstimatorsQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[5]/h4/a")
	public WebElement solContiGuidelinesQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[6]/h4/a")
	public WebElement digiShopQL;

	// sub link description
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[1]/h4/span")
	public WebElement digiSolPlanTempDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[2]/h4/span")
	public WebElement digiRegArchDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[3]/h4/span")
	public WebElement digiResPlanrsDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[4]/h4/span")
	public WebElement digiEstimatorsDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[5]/h4/span")
	public WebElement solContiGuidelinesDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[3]/div/div/div[6]/h4/span")
	public WebElement digiShopDescQL;

	// sub Quick Links
	// Non Digital & Sales Reference Material
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/h4/span")
	public WebElement nonDiginSlsRefMatQLDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[1]/h4/a")
	public WebElement salesEffectivenessQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[2]/h4/a")
	public WebElement slsNpricingSuppHmeQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[3]/h4/a")
	public WebElement gCFMCtrtDocMgmntQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[4]/h4/a")
	public WebElement solContingencyQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[5]/h4/a")
	public WebElement slsProfCommQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[6]/h4/a")
	public WebElement accDelSuiteQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[7]/h4/a")
	public WebElement ctdsRq4PriBigDlsQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[8]/h4/a")
	public WebElement accDelMethdsQL;

	// sub link description
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[1]/h4/span")
	public WebElement salesEffectivenessDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[2]/h4/span")
	public WebElement slsNpricingSuppHmeDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[3]/h4/span")
	public WebElement gCFMCtrtDocMgmntDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[4]/h4/span")
	public WebElement solContingencyDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[5]/h4/span")
	public WebElement slsProfCommDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[6]/h4/span")
	public WebElement accDelSuiteDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[7]/h4/span")
	public WebElement ctdsRq4PriBigDlsDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[4]/div/div/div[8]/h4/span")
	public WebElement accDelMethdsDescQL;

	// sub Quick Links
	// New IT & Security
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/h4/span")
	public WebElement newITnSecDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[1]/h4/a")
	public WebElement agilePlayBooksQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[2]/h4/a")
	public WebElement protectingAccQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[3]/h4/a")
	public WebElement dsdSecTeamQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[4]/h4/a")
	public WebElement digiArchDesnDelQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[5]/h4/a")
	public WebElement digiArchDesnDelEmailQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[6]/h4/a")
	public WebElement accDevOpsPlatformQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[7]/h4/a")
	public WebElement accDevOpsEmailQL;

	// sub link description
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[1]/h4/span")
	public WebElement agilePlayBooksDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[2]/h4/span")
	public WebElement protectingAccDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[3]/h4/span")
	public WebElement dsdSecTeamDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[4]/h4/span")
	public WebElement digiArchDesnDelDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[5]/h4/span")
	public WebElement digiArchDesnDelEmailDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[6]/h4/span")
	public WebElement accDevOpsPlatformDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[5]/div/div/div[7]/h4/span")
	public WebElement accDevOpsEmailDescQL;

	// sub Quick Links
	// Training & Development
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/h4/span")
	public WebElement trainNdevelopDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[1]/h4/a")
	public WebElement digiAcademyQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[2]/h4/a")
	public WebElement dfdFrntDoorTrainingQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[3]/h4/a")
	public WebElement leadrshpCareersQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[4]/h4/a")
	public WebElement digiSolDesignAcaQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[5]/h4/a")
	public WebElement advDigiSolVirSessQL;

	// sub link description (2/5-for the remaining two QLs there is no description)
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[1]/h4/span")
	public WebElement digiAcademyDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[2]/h4/span")
	public WebElement dfdFrntDoorTrainingDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[6]/div/div/div[3]/h4/span")
	public WebElement leadrshpCareersDescQL;

	// sub Quick Links
	// Collaboration Tools
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/h4/span")
	public WebElement collabToolsDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[1]/h4/a")
	public WebElement digiDialogQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[2]/h4/a")
	public WebElement dsdYammerQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[3]/h4/a")
	public WebElement ealaAIcollabFWQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[4]/h4/a")
	public WebElement strmDesktopAppQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[5]/h4/a")
	public WebElement dsdCircleQL;

	// sub link description
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[1]/h4/span")
	public WebElement digiDialogDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[2]/h4/span")
	public WebElement dsdYammerDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[3]/h4/span")
	public WebElement ealaAIcollabFWDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[4]/h4/span")
	public WebElement strmDesktopAppDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[7]/div/div/div[5]/h4/span")
	public WebElement dsdCircleDescQL;

	// sub Quick Links
	// Contacts
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/h4/span")
	public WebElement contactDesc;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[1]/h4/a")
	public WebElement dsdSecuTeamQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[2]/h4/a")
	public WebElement rateCardTeamQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[3]/h4/a")
	public WebElement digiArchDesgnDelEmailQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[4]/h4/a")
	public WebElement accDevOpsEmailcQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[5]/h4/a")
	public WebElement ctdsReq4PriBigDlsQL;
	
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[6]/h4/a")
	public WebElement digiOrgChrtcQL;

	// sub link description
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[1]/h4/span")
	public WebElement dsdSecuTeamDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[2]/h4/span")
	public WebElement rateCardTeamDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[3]/h4/span")
	public WebElement digiArchDesgnDelEmailDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[4]/h4/span")
	public WebElement accDevOpsEmailcDescQL;

	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[5]/h4/span")
	public WebElement ctdsReq4PriBigDlDescsQL;
	
	@FindBy(xpath = "//*[@id='offeringsDiv']/div/div/div/div[8]/div/div/div[6]/h4/span")
	public WebElement digiOrgChrtcDescQL;
	
	
	

	public DFDHomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all public WebElements

		PageFactory.initElements(driver, this);

	}
	
	
	public void openSIAllocationPage(WebDriver driver) throws Exception {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", menuLnk);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", mManageAllocationLnk);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", mSIAllocLnk);
		Thread.sleep(10000);
	}

}

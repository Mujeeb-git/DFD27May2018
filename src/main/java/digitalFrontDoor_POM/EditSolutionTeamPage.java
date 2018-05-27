package digitalFrontDoor_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditSolutionTeamPage {

	WebDriver driver;
	

	@FindBy(xpath = "//*[@id=\"MainContent_imgsearch\"]")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//*[@id=\"MainContent_rptRequestorDB_EditRequest_19\"]")
	public WebElement editBtn;
	
	
	
	
	public EditSolutionTeamPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	
	
	
}

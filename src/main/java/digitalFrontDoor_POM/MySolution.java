package digitalFrontDoor_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySolution {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"userNameInput\"]")
	public WebElement editButton;


	public MySolution(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all public WebElements

		PageFactory.initElements(driver, this);

	}
}

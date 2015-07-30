package homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

/*
 * @Author John Martin
 * @Summary AddCoverPhoto Test Scenario.
 * @Date 07/06/2015
 * Change Log:
 * <Date>			<Author>		<Change Made>
 * 07/06/2015		John Martin		Added btnPrivacySettings, constructor, and verifyHomepageDisplayed method.
 */

public class Homepage {

	// Instantiating a local webdriver and declaring all the
	// objects on the page below; defining the local Object Repository.

	// Instantiate a reference driver.
	private WebDriver driver;

	// Declaration of objects.
	@FindBy(id = "privacyFlyoutLabel")
	WebElement btnPrivacySettings;

	@FindBy(className = "_2dpb")
	WebElement btnProfile;

	@FindBy(id = "pageLoginAnchor")
	private WebElement drpDwnCarat;

	@FindBy(xpath = "//li[@data-gt='{\"ref\":\"async_menu\",\"logout_menu_click\":\"menu_logout\"}']")
	private WebElement drpDwnLogout;

	@FindBy(xpath = ".//*[@id='u_0_e']")
	private WebElement btnLoginConfirm;

	@FindBy(id = "u_ps_0_8_7")
	private WebElement txtStatusBox;

	@FindBy(css = "._42ft._4jy0._11b._4jy3._4jy1.selected._51sy")
	private WebElement btnPost;

	// Defining all the methods applicable to the Profile PageObject.

	// Method that accepts a driver object and initializes/applies
	// all the WebElements to the driver.
	public Homepage(WebDriver driver) {

		// Declares the driver passed in via argument
		// as the local driver to initialize all the page objects.
		this.driver = driver;

		// Initialize all the page objects via PageFactory.
		PageFactory.initElements(driver, this);
	}

	public void CaratClicks() {
		drpDwnCarat.click();
	}

	public void LogoutClicks() {
		drpDwnLogout.click();
	}

	// Verify the Homepage with verifying the Privacy Settings button.
	public boolean verifyHomepageDisplayed() {
		if (btnPrivacySettings.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	// Click the Profile button.
	public void clickProfileButton() {
		btnProfile.click();

	}

	// Click the Post button.
	public void clickPostButton() {
		btnPost.click();
	}

	// Type a status into the status text box.
	public void enterStatus() {
		txtStatusBox.sendKeys(getTimeStamp());
	}

	// Create time stamp method.
	public String getTimeStamp() {
		java.util.Date timeStamp = new java.util.Date();
		Long timeStampPrint = timeStamp.getTime();
		return timeStampPrint.toString();

	}

	public void ConfirmLogout() {
		Assert.assertTrue(btnLoginConfirm.isDisplayed(),
				"Does NOT return to the Login Page!!!<br>");
		Reporter.log("Facebook Login Page Displays<br>");
	}

	public void FacebookLogout() {
		CaratClicks();
		LogoutClicks();
		Reporter.log("User Successfully Logs Out of Facebook!<br>");
		ConfirmLogout();
	}

	public void postStatus() {
		enterStatus();
		clickPostButton();
	}
}

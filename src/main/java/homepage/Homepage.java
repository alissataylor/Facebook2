package homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

/*
 *  @Author Andy Williams, John Martin
 *  @Summary Methods Created to Successfully Logout of Facebook. This is our object Class for  for the HomePage Repository
 *  @Summary AddCoverPhoto Test Scenario.
 *  @Date
 *  Change Log
 *  <Date>				<Author>		<Change Made>
 *  06/23/2015			Andy Williams	Added Web Elements, Page Factory Constructor, CaratClicks(), LogoutClicks(), FacebookLogout()
 *  07/06/2015			John Martin		Added btnPrivacySettings, constructor, and verifyHomepageDisplayed method.
 *  07/28/2015			Andy Williams	Added homePageDisplays() 
 *	07/31/2015			Group			Code review changes.
 */

public class Homepage {

	// ----------------------------------------------------
	// Variable Declaration/Object Repository
	// ----------------------------------------------------
	WebDriver driver;

	@FindBy(id = "pageLoginAnchor")
	private WebElement drpDwnCarat;

	@FindBy(xpath = "//li[@data-gt='{\"ref\":\"async_menu\",\"logout_menu_click\":\"menu_logout\"}']")
	private WebElement drpDwnLogout;

	@FindBy(xpath = ".//*[@id='u_0_e']")
	private WebElement btnLoginConfirm;

	// ----------------------------------------------------
	// Class Constructor
	// ----------------------------------------------------

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ----------------------------------------------------
	// Methods, Actions, & Calculations
	// ----------------------------------------------------

	// Calling URL for test.
	public void GetURL() {
		driver.get("http://www.facebook.com");
	}

	// Timeout execution webdriver after 10 seconds.
	public void TimeOut() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Clicking the dropdown carat from the facebook banner.
	public void CaratClicks() {
		drpDwnCarat.click();
	}

	// Clicking the logout button.
	public void LogoutClicks() {
		drpDwnLogout.click();
	}

	// Verifying the homepage is displayed.
	public boolean homePageDisplays() {
		if (drpDwnCarat.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	// Specific method for call to test (Logout).
	public void FacebookLogout() {
		CaratClicks();
		LogoutClicks();
	}

	// Verifying that the user can logout.
	public boolean ConfirmLogout() {
		if (btnLoginConfirm.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

}

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
 *
 */

public class Homepage {

	// ----------------------------------------------------
	// 		Variable Declaration/Object Repository
	// ----------------------------------------------------
	WebDriver driver;
	

	@FindBy(id = "pageLoginAnchor")
	private WebElement drpDwnCarat;

	@FindBy(xpath = "//li[@data-gt='{\"ref\":\"async_menu\",\"logout_menu_click\":\"menu_logout\"}']")
	private WebElement drpDwnLogout;

	@FindBy(xpath = ".//*[@id='u_0_e']")
	private WebElement btnLoginConfirm;
	

	@FindBy(id = "privacyFlyoutLabel")
	private WebElement btnPrivacySettings;

	@FindBy(className = "_2dpb")
	private WebElement btnProfile;

	@FindBy(id = "u_ps_0_8_7")
	private WebElement txtStatusBox;

	@FindBy(css = "._42ft._4jy0._11b._4jy3._4jy1.selected._51sy")
	private WebElement btnPost;		


	// ----------------------------------------------------
	// 					Class Constructor
	// ----------------------------------------------------
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}			

	// ----------------------------------------------------
	// 			Methods, Actions, & Calculations
	// ----------------------------------------------------

	public void GetURL(){
		driver.get("http://www.facebook.com");
	}
	
	public void TimeOut(){
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void CaratClicks() {
		drpDwnCarat.click();
	}

	public void LogoutClicks() {
		drpDwnLogout.click();
	}
	
	
	
	
	/*
	 *  Add Home Page Verification 
	 */
	public boolean homePageDisplays(){
	if (drpDwnCarat.isDisplayed()){
		return true;
	}
	else
	{
		return false;
	}
	}

	public void FacebookLogout() {
		CaratClicks();
		LogoutClicks();
		
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

	public boolean ConfirmLogout() {
		if(btnLoginConfirm.isDisplayed()){
			return true;
		} else{
			return false;
		}
				
		
	}

	
	public void postStatus() {
		enterStatus();
		clickPostButton();

	}
}

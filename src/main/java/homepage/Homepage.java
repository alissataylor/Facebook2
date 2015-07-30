package homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

/*
 *  @Author Andy Williams
 *  @Summary Methods Created to Successfully Logout of Facebook. This is our object Class for  for the HomePage Repository
 *  @Date
 *  Change Log
 *  <Date>				<Author>		<Change Made>
 *  06/23/2015			Andy Williams	Added Web Elements, Page Factory Constructor, CaratClicks(), LogoutClicks(), FacebookLogout()
 *  07/28/2015			Andy Williams	Added homePageDisplays() 
 */

public class Homepage {

	WebDriver driver = null;

	/*
	 * Define Web Elements
	 */

	@FindBy(id = "pageLoginAnchor")
	private WebElement drpDwnCarat;

	@FindBy(xpath = "//li[@data-gt='{\"ref\":\"async_menu\",\"logout_menu_click\":\"menu_logout\"}']")
	private WebElement drpDwnLogout;

	@FindBy(xpath = ".//*[@id='u_0_e']")
	private WebElement btnLoginConfirm;

	/*
	 * Establish Methods
	 */

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	public void homePageDisplays(){
		 Assert.assertTrue(drpDwnCarat.isDisplayed(), "Home Page Doesn't Display!!!");
	}

	public void FacebookLogout() {
		CaratClicks();
		LogoutClicks();
		Reporter.log("User Successfully Logs Out of Facebook!<br>");
		Assert.assertTrue(btnLoginConfirm.isDisplayed(),
				"Does NOT return to the Login Page!!!<br>");
		Reporter.log("Facebook Login Page Displays<br>");

	}
}

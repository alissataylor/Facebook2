package homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Homepage {

	/*
	 * @author Andy Williams
	 * @Summary Methods Created to Succesfully Logout of Facebok. This is our object Class for  for the HomePage Repository
	 * @Date 06/23/2015
	 */
	
	
	WebDriver driver = null;

/*
 * Define Web Elements
 */

@FindBy (id = "pageLoginAnchor")
private WebElement  drpDwnCarat;

@FindBy (xpath = "//li[@data-gt='{\"ref\":\"async_menu\",\"logout_menu_click\":\"menu_logout\"}']")
 private WebElement  drpDwnLogout;

@FindBy (xpath = ".//*[@id='u_0_e']")
private WebElement btnLoginConfirm;

/*
 * Establish Methods
 */

public Homepage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void CaratClicks(){
	drpDwnCarat.click();
}

public void LogoutClicks(){
	drpDwnLogout.click();
}


public void ConfirmLogout(){
	Assert.assertTrue(btnLoginConfirm.isDisplayed(),"Does NOT return to the Login Page!!!<br>");
	Reporter.log("Facebook Login Page Displays<br>");
}

public void FacebookLogout(){
	CaratClicks();
	LogoutClicks();
	Reporter.log("User Successfully Logs Out of Facebook!<br>");
	ConfirmLogout();
}
}

package smoketests;

import java.util.concurrent.TimeUnit;

import login.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import homepage.Homepage;

/*
 *  @Author Andy Williams
 *  @Summary Created Log Out Test
 *  @Date
 *  Change Log
 *  <Date>				<Author>		<Change Made>
 *  06/23/2015 			Andy Williams	Initiated Logout Test
 *  07/28/2015			Andy Williams	Updated with Java Doc Format
 *  07/31/2015			Group			Code review changes.
 */

public class Logout {

	WebDriver driver = new FirefoxDriver();

	//Calling parameters for test setup.
	@BeforeTest
	public void setup() {
		Homepage homepage = new Homepage(driver);
		homepage.GetURL();
		homepage.TimeOut();
		Login loginPage = new Login(driver);
		loginPage.successfulLogin();
	}

	//Logout test scenario.
	@Test
	public void LogoutTest() {
		Homepage homepage = new Homepage(driver);
		Assert.assertTrue(homepage.ConfirmLogout(),"Does NOT return to the Login Page!!!<br>");
		Reporter.log("User Successfully Logs Out of Facebook!<br>");
		Homepage logout = new Homepage(driver);
		logout.FacebookLogout();
		Reporter.log("Facebook Login Page Displays<br>");
	}
	
	//Close browser before each new test
	@AfterTest
	public void EndTest() {
		driver.getCurrentUrl();
		driver.quit();
	}

}

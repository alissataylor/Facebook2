package smoketests;

import java.util.concurrent.TimeUnit;

import homepage.Homepage;
import login.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * @Author Alissa Taylor
 * @Summary Post a status to the homepage.
 * @Date 07/22/2015
 * Change Log:
 * <Date>			<Author>		<Change Made>
 * 07/22/2015		Alissa Taylor		Outlined the test case scenario shell.
 */

public class AddAStatus {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void testPostStatus(){
		
		//login to Facebook.
		Login loginPageObject = new Login(driver);
		loginPageObject.navigateToFacebook();
		loginPageObject.successfulLogin();
		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Homepage homepagePageObject = new Homepage(driver);
		
		//Verify that we are logged into Facebook.
		Assert.assertTrue(homepagePageObject.verifyHomepageDisplayed(),"You are NOT logged in!!!");
		Reporter.log("Facebook Homepage Displays<br>");
		
		//Type a status into the status textbox and post the status.
		homepagePageObject.postStatus();
		
		//Verify the status is posted.
		
	}
		// Logout, close driver.
		@AfterTest
		public void FacebookLogout() {
			driver.close();

	}
}

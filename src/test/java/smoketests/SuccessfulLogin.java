package smoketests;

import homepage.Homepage;
import junit.framework.Assert;
import login.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 *  @Author Andy Williams
 *  @Summary Login Test
 *  @Date
 *  Change Log
 *  <Date>				<Author>		<Change Made>
 *  
 *  07/28/2015			Andy Williams	Updated successfulLoginTest() to add Reporter capability
 *  07/30/2015			Andy Williams	Updated  @AfterTest to close out the test. 
 *  07/31/2015			Group			Updated comments and spacing.
 */
public class SuccessfulLogin {

	WebDriver driver = new FirefoxDriver();

	//Calling parameters for test setup.
	@BeforeTest
	public void setup() {
		Homepage homepage = new Homepage(driver);
		homepage.GetURL();
		homepage.TimeOut();
	}

	//Successful login test scenario and validation.
	@Test
	public void successfulLoginTest() {
		Login loginPage = new Login(driver);
		loginPage.successfulLogin();
		
		//Validating that we are successfully logged in.
		Homepage homepage = new Homepage(driver);
		Assert.assertTrue("Home Page doesn't display!",homepage.homePageDisplays());
		Reporter.log("User logged into Home Page Successfully!!!");
	}

	//Closing the driver and the browser.
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}

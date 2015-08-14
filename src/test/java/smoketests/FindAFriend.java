package smoketests;

import homepage.Homepage;
import login.Login;
import profile.Profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Searchpage.Searchpage;


/*
 * @Author Daniel Marshall
 * @Summary Find Friend Test Scenario.
 * @Date 07/14/2015
 * Change Log:
 * <Date>			<Author>		     <Change Made>
 * 	07/21/2015		Daniel Marshall		  
 */



public class FindAFriend {
	
	//Instantiate a reference driver.
	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void testFindAFriend(){
		Login loginPageObject = new Login(driver);
		
	//Navigate to the facebook URL.
	loginPageObject.navigateToFacebook();
		
		
	//Login to the webpage.
	loginPageObject.successfulLogin();
		
	//Instantiate the Homepage object.
	Homepage homepagePageObject = new Homepage(driver);
		
	//Verify we are logged in via the Homepage is displayed.
	homepagePageObject.verifyHomepageDisplayed();
	
	homepagePageObject.findFriend("Daniel Marshall");
	
	//Validating Homepage
	Homepage homepage = new Homepage(driver);
	Assert.assertTrue(homepage.verifyHomepageDisplayed(), "Home Page doesn't display!");
		Reporter.log("User logged into Home Page Successfully!!!");
	
	//Validating Searchpage
	Searchpage searchpage = new Searchpage(driver);
	Assert.assertTrue(searchpage.verifySearchpageDisplayed(), "Search Page does not display!");
	Reporter.log("User has navigated to Search Page correctly");
	
	}

	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
}
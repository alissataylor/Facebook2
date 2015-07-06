package smoketests;

import homepage.Homepage;
import login.Login;
import profile.Profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
 * @Author John Martin
 * @Summary AddCoverPhoto Test Scenario.
 * @Date 06/24/2015
 * Change Log:
 * <Date>			<Author>		<Change Made>
 * 06/25/2015		John Martin		Outlined the test case scenario shell.
 */

public class AddCoverPhoto {
	
	//Instantiate a reference driver.
	WebDriver driver = new FirefoxDriver();
	
	@Test
	//Test scenario for adding a cover photo.
	public void testAddCoverPhoto(){
		//Instantiate the Login object.
		Login loginPageObject = new Login(driver);
		
		//Navigate to the facebook URL.
		loginPageObject.navigateToFacebook();
		Assert.assertTrue(loginPageObject.verifyNavigation(), "Successfully navigated to the the following URL: https://www.facebook.com/");
		
		//Login to the webpage.
		loginPageObject.successfulLogin();
		
		//Instantiate the Homepage object.
		Homepage homepagePageObject = new Homepage(driver);
		
		//Verify we are logged in via the Homepage is displayed.
		homepagePageObject.verifyHomepageDisplayed();
		
		//Navigate to the Profile page.
		homepagePageObject.clickProfileButton();
		
		//Click the 'Update Cover Photo' button.
		Profile profilePageObject = new Profile(driver);
		profilePageObject.clickAddCoverPhotoButton();
		
		//Click the 'Choose From My Photos' button.
		
		//Click the 'Photo Albums' link.
		
		//Select the Photo Album.
		
		//Select the Photo to be added as a cover photo.
	}

	@AfterTest
	//Method to tear everything down.
	public void tearDown(){
		driver.quit();
	}
	
}

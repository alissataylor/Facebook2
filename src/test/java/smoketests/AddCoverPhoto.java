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
		
		//Navigate to the facebook URL and verify successful navigation.
		loginPageObject.navigateToFacebook();
		Assert.assertTrue(loginPageObject.verifyNavigation(), "Unable to successfully verify navigation to the Facebook login page; please investigate.");
		Reporter.log("Successfully navigated to the Facebook login page.<br><br>");
		
		//Login to the webpage.
		loginPageObject.successfulLogin();
		
		//Instantiate the Homepage object.
		Homepage homepagePageObject = new Homepage(driver);
		
		//Verify we are logged in via the Homepage is displayed.
		Assert.assertTrue(homepagePageObject.verifyHomepageDisplayed(), "Unable to verify a successful login/navigation to the Homepage page; please investigate.");
		Reporter.log("Successfully logged into Facebook.<br><br>");
		Reporter.log("Successfully navigated to the Homepage page.<br><br>");
		
		//Navigate to the Profile page.
		homepagePageObject.clickProfileButton();
		
		//Verify successful navigation to the Profile page.
		Profile profilePageObject = new Profile(driver);
		Assert.assertTrue(profilePageObject.verifyProfileDisplayed(), "Unable to verify a navigation to the Profile page; please investigate.");
		Reporter.log("Successfully navigated to the Profile page.<br><br>");
		
		//Click the 'Update Cover Photo' button.
		profilePageObject.clickAddCoverPhotoButton();
		
		//Click the 'Choose From My Photos' button.
		profilePageObject.clickChoosePhotoButton();
		
		//Click the 'Photo Albums' link.
		profilePageObject.clickPhotoAlbumsLink();
		
		//Select the Photo Album.
		profilePageObject.clickPhotoAlbumImage();
		
		//Select the Photo to be added as a cover photo.
		profilePageObject.clickCoverPhotoImage();
		
		//Select the 'Save' button.
		profilePageObject.clickSaveButton();
	}

	@AfterTest
	//Method to tear everything down.
	public void tearDown(){
		driver.close();
	}
	
}

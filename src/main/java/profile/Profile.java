package profile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @Author John Martin
 * @Summary Profile PageObject Class - contain all relevant objects and methods.
 * @Date 06/24/2015
 * Change Log:
 * <Date>			<Author>		<Change Made>
 * 06/24/2015		John Martin		Added cover photo objects and the initProfile method.
 * 					John Martin		Added the clickSaveButton and btnAddCoverPhoto methods.
 * 06/25/2015		John Martin		Added the following methods: clickChoosePhotoButton, clickPhotoAlbumsLink, and clickCoverPhotoImage.
 */

public class Profile {
	
	//Instantiating a local webdriver and declaring all the 
	//objects on the page below; defining the local Object Repository.
	
	//Instantiate a reference driver.
	private WebDriver driver;
	
	//Declaration of objects.
	@FindBy(id = "fb-timeline-cover-name")
	WebElement lblProfileName;
	
	@FindBy(className = "_30vz img sp_rkVHzsNvFLc sx_7c09b5")
	WebElement btnAddCoverPhoto;
	
	@FindBy(className = "mrs img sp_oPs6x6QGeVT sx_7498dc")
	WebElement btnChoosePhoto;
	
	@FindBy(linkText = "Photo Albums")
	WebElement lnkPhotoAlbums;
	
	@FindBy(xpath = "/html/body/div[7]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[1]/div/a")
	WebElement imgPhotoAlbum;
	
	@FindBy(xpath = "/html/body/div[7]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td/a/div/img")
	WebElement imgCoverPhoto;
	
	@FindBy(name = "save")
	WebElement btnSave;
	
	
	//Defining all the methods applicable to the Profile PageObject.
	
	//Method that accepts a driver object and initializes/applies
	//all the WebElements to the driver.
	public Profile(WebDriver driver){
		
		//Declares the driver passed in via argument
		//as the local driver to initialize all the page objects.
		this.driver = driver;
		
		//Initialize all the page objects via PageFactory.
		PageFactory.initElements(driver, this);
	}
	
	//Verify successful navigation to the Profile page by
	//verifying the name object on the Profile page is displayed.
	public boolean verifyProfileDisplayed(){
		// Variable declaration to be used in the for loop.
		boolean isLoaded = false;
		int waitCount;
		int waitCountCap = 10;

		// Loop statement to wait for navigation verification.
		for (waitCount = 0; waitCountCap > waitCount; waitCount++) {

			// Check to see if the 'Login' button is displayed, if so,
			// we can say the page has successfully loaded.
			if (lblProfileName.isDisplayed()) {
				isLoaded = true;
				break;
			} else {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}

		}
		return isLoaded;
	}
	
	//Click the 'Choose From My Photos' button in the dropdown menu.
	public void clickChoosePhotoButton(){
		btnChoosePhoto.click();
	}
	
	//Click the 'Photo Albums' link in the pop-up window.
	public void clickPhotoAlbumsLink(){
		lnkPhotoAlbums.click();
	}
	
	//Click the 'Add A Cover Photo' button.
	public void clickAddCoverPhotoButton(){
		btnAddCoverPhoto.click();
	}
	
	//Click the image for the Photo Album.
	public void clickPhotoAlbumImage(){
		imgPhotoAlbum.click();
	}
	
	//Click the image for the Photo.
	public void clickCoverPhotoImage(){
		imgCoverPhoto.click();
	}
	
	//Click the 'Save' button.
	public void clickSaveButton(){
		btnSave.click();
	}
	
}

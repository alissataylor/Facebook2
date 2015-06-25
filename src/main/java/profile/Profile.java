package profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @Author John Martin
 * @Summary The Profile PageObject Class - contain all relevant objects and methods.
 * @Date 06/24/2015
 * Change Log:
 * <Date>			<Author>		<Change Made>
 * 06/24/2015		John Martin		Added cover photo objects and the initProfile method.
 * 					John Martin		Added the clickSaveButton and btnAddCoverPhoto methods.
 */

public class Profile {
	
	//Instantiating a local webdriver and declaring all the 
	//objects on the page below; defining the local Object Repository.
	
	//Instantiate a reference driver.
	WebDriver driver = new FirefoxDriver();
	
	//Declaration of objects.
	@FindBy(className = "_30w0 _50f7")
	WebElement btnAddCoverPhoto;
	
	@FindBy(className = "mrs img sp_oPs6x6QGeVT sx_7498dc")
	WebElement btnChoosePhoto;
	
	@FindBy(linkText = "Photo Albums")
	WebElement lnkPhotoAlbums;
	
	//###Need to update this object.
	@FindBy(className = "scaledImageFitHeight img")
	WebElement imgPhotoAlbum;
	
	@FindBy(name = "save")
	WebElement btnSave;
	
	
	//Defining all the methods applicable to the Profile PageObject.
	
	//Method that accepts a driver object and initializes/applies
	//all the WebElements to the driver.
	public void initProfile(WebDriver driver){
		
		//Declares the driver passed in via argument
		//as the local driver to initialize all the page objects.
		this.driver = driver;
		
		//Initialize all the page objects via PageFactory.
		PageFactory.initElements(driver, this);
	}
	
	//Click the 'Add A Cover Photo' button.
	public void clickAddCoverPhotoButton(){
		btnAddCoverPhoto.click();
	}
	
	//Click the 'Save' button.
	public void clickSaveButton(){
		btnSave.click();
	}
	
}

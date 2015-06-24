package profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
	
	//Instantiate a reference driver.
	WebDriver driver = new FirefoxDriver();
	
	//Declaration of objects.
	@FindBy(className = "_30w0 _50f7")
	WebElement btnAddCoverPhoto;
	
	@FindBy(className = "mrs img sp_oPs6x6QGeVT sx_7498dc")
	WebElement btnChoosePhoto;
	
	@FindBy(linkText = "Photo Albums")
	WebElement lnkPhotoAlbums;
	
	//''''Need to update this object.
	@FindBy(className = "scaledImageFitHeight img")
	WebElement imgPhotoAlbum;
	
	@FindBy(name = "save")
	WebElement btnSave;
	
}

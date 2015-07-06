package homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @Author John Martin
 * @Summary AddCoverPhoto Test Scenario.
 * @Date 07/06/2015
 * Change Log:
 * <Date>			<Author>		<Change Made>
 * 07/06/2015		John Martin		Added btnPrivacySettings, constructor, and verifyHomepageDisplayed method.
 */
public class Homepage {
	
	//Instantiating a local webdriver and declaring all the 
	//objects on the page below; defining the local Object Repository.
	
	//Instantiate a reference driver.
	private WebDriver driver;
	
	//Declaration of objects.
	@FindBy(id = "privacyFlyoutLabel")
	WebElement btnPrivacySettings;
	
	@FindBy(className = "_2dpb")
	WebElement btnProfile;
	
	//Defining all the methods applicable to the Profile PageObject.
	
	//Method that accepts a driver object and initializes/applies
	//all the WebElements to the driver.
	public Homepage(WebDriver driver){
		
		//Declares the driver passed in via argument
		//as the local driver to initialize all the page objects.
		this.driver = driver;
		
		//Initialize all the page objects via PageFactory.
		PageFactory.initElements(driver, this);
	}
	
	//Verify the Homepage with verifying the Privacy Settings button.
	public boolean verifyHomepageDisplayed(){
		if(btnPrivacySettings.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
	
	//Click the Profile button.
	public void clickProfileButton(){
		btnProfile.click();
	}

}

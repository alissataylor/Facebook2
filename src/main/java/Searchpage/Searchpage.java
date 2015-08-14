package Searchpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @Author Daniel Marshall
 * @Summary FindAFriend Test Scenario.
 * @Date 08/14/2015
 * Change Log:
 * <Date>			<Author>				<Change Made>
 * 08/14/2015		Daniel Marshall		Added *********************, constructor, and verifySearchpageDisplayed method.
 */

public class Searchpage {
	
	//Instantiating a local webdriver and declaring all the 
	//objects on the page below; defining the local Object Repository.
	
	//Instantiate a reference driver.
	private WebDriver driver;
	
	//Declaration of objects.
	@FindBy(className = "_43o4")
	WebElement  eleMenuBar;
		
	//Defining all the methods applicable to the Profile PageObject.
	//Method that accepts a driver object and initializes/applies
	//all the WebElements to the driver.
	public Searchpage(WebDriver driver){
		
		//Declares the driver passed in via argument
		//as the local driver to initialize all the page objects.
		this.driver = driver;
		
		//Initialize all the page objects via PageFactory.
		PageFactory.initElements(driver, this);
	}
	
	//Verify the Search with verifying the Privacy Settings button.
	public boolean verifySearchpageDisplayed(){
		if(eleMenuBar.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
	
	

}
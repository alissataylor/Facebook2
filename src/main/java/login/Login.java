package login;

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
 * 06/25/2015		John Martin		Added basic Login functionality (objects & methods).
 */

public class Login {
	
	//Instantiating a local webdriver and declaring all the 
	//objects on the page below; defining the local Object Repository.
	
	//Instantiate a reference driver.
	private WebDriver driver;

	@FindBy(id = "email")
	WebElement txtLoginEmail;

	@FindBy(id = "pass")
	WebElement txtPassword;

	@FindBy(id = "u_0_n")
	WebElement btnLogin;
	
	
	//Defining all the methods applicable to the Profile PageObject.
	
	//Constructor for the Login PageObject; applies all the web elements and methods to the driver.
	public Login(WebDriver driver) {
		//Declares the driver passed in via argument
		// as the local driver to initialize all the page objects.
		this.driver = driver;

		// Initialize all the page objects via PageFactory.
		PageFactory.initElements(driver, this);
	}
	
	//Enter in the username value.
	public void inputUsername(){
		txtLoginEmail.sendKeys("alissa.taylor@orasi.com");
	}
	
	//Enter in the password value.
	public void inputPassword(){
		txtPassword.sendKeys("Orasi2");
	}
	
	//Click the 'Login' button.
	public void clickLoginButton(){
		btnLogin.click();
	}
	
	//Wrapper method for logging in to the Facebook webpage.
	public void loginToPage() {
		//Calling the methods for the logging in process.
		inputUsername();
		inputPassword();
		clickLoginButton();
	}
	
	//Navigate to the facebook URL.
	public void navigateToFacebook(){
		driver.get("https://www.facebook.com/");
	}
	
	//Verify successful navigation/page loaded.
	public boolean verifyNavigation(){
		
		//Variable declaration to be used in the for loop.
		boolean isLoaded = false;
		int waitCount;
		int waitCountCap = 10;
		
		//Loop statement to wait for navigation verification.
		for(waitCount = 0; waitCountCap > waitCount; waitCount++){
			
			//Check to see if the 'Login' button is displayed, if so,
			//we can say the page has successfully loaded.
			if(btnLogin.isDisplayed()){
				isLoaded = true;
				break;
			}else{
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
			
		}
		return isLoaded;
	}

}

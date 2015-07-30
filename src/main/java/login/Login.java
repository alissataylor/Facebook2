package login;

import homepage.Homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

/*
 * @Author Group
 * @Summary Login Page Object Class - all objects and methods needed for logging in.
 * @Date 06/30/2015
 * Change Log:
 * <Date>			<Author>		<Change Made>
 * 06/30/2015		Group    		Added login objects.
 * 07/28/2015		Andy Williams	Added Assertion in the form of the homePageDisplayed() Method. This is inherited from the homepage class
 */

public class Login {

	// ----------------------------------------------------
	// 		Variable Declaration/Object Repository
	// ----------------------------------------------------
	
	WebDriver driver;
	Homepage homepage;
	
	
	
	
	

	@FindBy(id = "email")
	private WebElement txtUsername;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(id = "u_0_x")
	private WebElement btnLogin;


	// ----------------------------------------------------
	// 					Class Constructor
	// ----------------------------------------------------

	// Constructor
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	// ----------------------------------------------------
	// 			Methods, Actions, & Calculations
	// ----------------------------------------------------

	// Navigating to facebook.
	public void navigateToFacebook() {
		driver.get("http://www.facebook.com");

	}

	// Entering the username into the username field.
	public void enterUsername() {
		
		txtUsername.sendKeys("alissa.taylor@orasi.com");
	}
	

	// Entering the password into the password field.
	public void enterPassword() {
		txtPassword.sendKeys("Orasi2");
	}

	// Clicking the login button.
	public void clickLogin() {
		btnLogin.click();
	}
	

	


	// Method for a successful login.
	public void successfulLogin()  {
		enterUsername();
		enterPassword();
		clickLogin();
		
		
		
		
	}

	// Method for an unsuccessful login.
	public void unsuccessfulLogin() {
		enterPassword();
		clickLogin();
	}

}

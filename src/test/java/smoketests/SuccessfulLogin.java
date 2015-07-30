package smoketests;

import login.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SuccessfulLogin {

	WebDriver shoebox = new FirefoxDriver();
			
	
	@Test
	public void successfulLoginTest(){
		Login loginPage = new Login(shoebox);
		loginPage.navigateToFacebook();
		loginPage.successfulLogin();
	}
	
	@AfterTest
	public void teardown() {
		shoebox.quit();
		
	}
}

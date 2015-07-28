package smoketests;

import login.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SuccessfulLogin {

	WebDriver driver = new FirefoxDriver();
			
	@BeforeTest
	public void setup() {
		driver.get("http://www.facebook.com");
	}
	
	@Test
	public void successfulLoginTest(){
		Login loginPage = new Login(driver);
		loginPage.successfulLogin();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}

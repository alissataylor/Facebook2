package smoketests;

import homepage.Homepage;
import junit.framework.Assert;
import login.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
 *  @Author Andy Williams
 *  @Summary Login Test
 *  @Date
 *  Change Log
 *  <Date>				<Author>		<Change Made>
 *  
 *  07/28/2015			Andy Williams	Updated successfulLoginTest() to add Reporter capability
 *  07/30/2015			Andy Williams	Updated  @AfterTest to close out the test. 
 */
public class SuccessfulLogin {

	WebDriver driver = new FirefoxDriver();
	
	
			
	@BeforeTest
	public void setup() {
		driver.get("http://www.facebook.com");
	}
	
	@Test
	public void successfulLoginTest() {
		Login loginPage = new Login(driver);
		
		 loginPage.successfulLogin();
		 Reporter.log("User logged into Home Page Successfully!!!");
	
	}
	
	@AfterTest
	public void EndTest(){
		driver.getCurrentUrl();
		driver.quit(); 
	}
}

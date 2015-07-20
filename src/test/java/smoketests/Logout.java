package smoketests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import homepage.Homepage;

public class Logout  {

	WebDriver driver;
	
	@FindBy (id = "email")
	public WebElement  strUsername;
	
	
	@FindBy (id = "pass")
	public WebElement strPassword;
	
	
	@FindBy (xpath = ".//*[@id='u_0_x']")
	public WebElement  btnLogIn;
	@BeforeTest
	public void Login(){
		
		
		 
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		 PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		strUsername.sendKeys("alissa.taylor@orasi.com");
		strPassword.sendKeys("Orasi2");
		btnLogIn.click();
		
		
		
		
		
	}
	
	@Test
	public void LogoutTest(){
	
		Homepage logout = new Homepage(driver);
		logout.FacebookLogout();
		
	}
	
	/*
	 * Close browser before each new test
	 */
	
	@AfterTest
	public void EndTest(){
		driver.getCurrentUrl();
		driver.quit(); 
	}
	
}

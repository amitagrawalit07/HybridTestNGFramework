package com.qa.testcases;

//import java.time.Duration;
import java.util.Date;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.AccountPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.Utilities;

public class LoginTest extends Base{
	
	LoginPage loginPage;
	
	public LoginTest(){
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
	    loginPage=homePage.selectLoginOption();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
    
	@Test(priority=1,dataProvider="supplyTestData")
	public void verifyLoginWithValidCredentials(String email,String password) {
		
		//LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		AccountPage accountPage=loginPage.clickOnLoginButton();

//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//AccountPage accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
		
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		}
	
	@DataProvider
	public Object[][] supplyTestData(){
//		Object[][] data = {{"amit@yopmail.com","amit"},
//				           {"amit@yopmail.com","amit"},
//				           {"amit@yopmail.com","amit"}};
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
	@Test(priority=2,enabled=true)
	public void verifyLoginWithInvalidCredentials() {

//		driver.findElement(By.id("input-email")).sendKeys("amit" + generateTimeStamp() + "@yopmail.com");
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-dismissible")).getText(), dataProp.getProperty("emailPasswordNoMatchWarningMessage"));
		
		//LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generateEmailByTimeStamp());
		loginPage.enterPassword(testdataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		String actualWarningMessage=loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage=testdataProp.getProperty("emailPasswordNoMatchWarningMessage");
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		
	}
	
	
	public String generateTimeStamp() {
		
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
}

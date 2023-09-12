package com.qa.testcases;



//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterPage;
import com.qa.pages.RegistrationSuccessPage;
import com.qa.utils.Utilities;

public class RegisterTest extends Base{
	
	public WebDriver driver;
	 RegisterPage registerPage;
	 RegistrationSuccessPage registrationSuccessPage;
	 
	 public RegisterTest() {
		 super();
	 }
	 
	 @BeforeMethod
	 public void setUp() {
		    driver=initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
		    HomePage homePage=new HomePage(driver);
		    homePage.clickOnMyAccount();
		    registerPage= homePage.selectRegisterOption();
			//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		    //driver.findElement(By.linkText("Register")).click();
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	@Test(priority=1) 
	public void verifyRegisterAnAccountWithMandatoryField() {

//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("password"));
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		
//		String actualSuccessMessageAfterRegistration=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		Assert.assertTrue(actualSuccessMessageAfterRegistration.contains(dataProp.getProperty("successfulMessageAfterRegistration")), "Registration not done successfully");
		
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(testdataProp.getProperty("firstName"));
		registerPage.enterLastName(testdataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailByTimeStamp());
		registerPage.enterTelephone(testdataProp.getProperty("telephone"));
		registerPage.enterPassword(testdataProp.getProperty("password"));
		registerPage.enterConfirmPassword(testdataProp.getProperty("password"));
		registerPage.selectPrivacyPolicy();
		registrationSuccessPage=registerPage.clickContinueButton();
		
		//RegistrationSuccessPage registrationSuccessPage=new RegistrationSuccessPage(driver);
		
		String actualSuccessMessageAfterRegistration=registrationSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertTrue(actualSuccessMessageAfterRegistration.contains(testdataProp.getProperty("successfulMessageAfterRegistration")), "Registration not done successfully");
	}
	
	@Test(priority=2) 
	public void verifyRegisterAnAccountWithAllField() {
		

//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("password"));
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		
//		String actualSuccessMessageAfterRegistration=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		Assert.assertTrue(actualSuccessMessageAfterRegistration.contains(dataProp.getProperty("successfulMessageAfterRegistration")), "Registration not done successfully");
		
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(testdataProp.getProperty("firstName"));
		registerPage.enterLastName(testdataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailByTimeStamp());
		registerPage.enterTelephone(testdataProp.getProperty("telephone"));
		registerPage.enterPassword(testdataProp.getProperty("password"));
		registerPage.enterConfirmPassword(testdataProp.getProperty("password"));
		registerPage.selectYesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		registrationSuccessPage=registerPage.clickContinueButton();
		//RegistrationSuccessPage registrationSuccessPage=new RegistrationSuccessPage(driver);
		String actualSuccessMessageAfterRegistration=registrationSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertTrue(actualSuccessMessageAfterRegistration.contains(testdataProp.getProperty("successfulMessageAfterRegistration")), "Registration not done successfully");
		
	}
	
	@Test(priority=3) 
	public void verifyRegisterAnAccountWithExistingEmailId() {
		
//     	driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys("amit@yopmail.com");
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("password"));
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		
//		String actualMessageForExistingEmail=driver.findElement(By.cssSelector(".alert-dismissible")).getText();
//		System.out.println(actualMessageForExistingEmail);
//		Assert.assertTrue(actualMessageForExistingEmail.contains(dataProp.getProperty("duplicteEmailWarningMessageWhileRegistration")), "Use different email id for registration");
		
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(testdataProp.getProperty("firstName"));
		registerPage.enterLastName(testdataProp.getProperty("lastName"));
		registerPage.enterEmail(configProp.getProperty("validEmail"));
		registerPage.enterTelephone(testdataProp.getProperty("telephone"));
		registerPage.enterPassword(testdataProp.getProperty("password"));
		registerPage.enterConfirmPassword(testdataProp.getProperty("password"));
		registerPage.selectYesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		registerPage.clickContinueButton();
		String actualMessageForExistingEmail=registerPage.retrieveDuplicateEmailAddressWarning();
		Assert.assertTrue(actualMessageForExistingEmail.contains(testdataProp.getProperty("duplicteEmailWarningMessageWhileRegistration")), "Use different email id for registration");
	}
	
	@Test(priority=4) 
	public void verifyRegisterAnAccountWithoutGivingAnyDetails() {
		
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		
//		String actualWarningMessageForNotSelectingPrivacyPolicy=driver.findElement(By.cssSelector(".alert-dismissible")).getText();
//		
//		System.out.println(actualWarningMessageForNotSelectingPrivacyPolicy);
//		Assert.assertTrue(actualWarningMessageForNotSelectingPrivacyPolicy.contains(dataProp.getProperty("privacyPolicyWarningMessage")), "Privacy Policy is not selected");
//		
//		String actualFirstNameNotFillingMessage=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
//		Assert.assertTrue(actualFirstNameNotFillingMessage.contains(dataProp.getProperty("firstNameNotEnteredErrorMessage")), "First name should not be empty");
		
		//RegisterPage registerPage=new RegisterPage(driver);
		registerPage.clickContinueButton();
		String actualWarningMessageForNotSelectingPrivacyPolicy=registerPage.retrievePrivacyPolicywarning();
		Assert.assertTrue(actualWarningMessageForNotSelectingPrivacyPolicy.contains(testdataProp.getProperty("privacyPolicyWarningMessage")), "Privacy Policy is not selected");
		String actualFirstNameNotFillingMessage=registerPage.retrieveFirstNameNotEnteredWarning();
		Assert.assertTrue(actualFirstNameNotFillingMessage.contains(testdataProp.getProperty("firstNameNotEnteredErrorMessage")), "First name should not be empty");
	
	}


}

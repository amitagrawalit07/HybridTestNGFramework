package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.SearchPage;

public class SearchTest extends Base{
	
	public WebDriver driver;
	SearchPage searchPage;
	//updated comment with more details
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
	}
	
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	
	@Test(priority=1)
	public void verifySearchWithValidProductName() {
		
//		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
//		driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "HP product is not displayed");
		
		HomePage homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(testdataProp.getProperty("validProduct"));
		searchPage=homePage.clickOnSearchButton();
		//SearchPage searchPage=new SearchPage(driver);
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(),"HP product is not displayed");
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProductName() {
//		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
//		driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();
//		String actualSearchMessage=driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
//		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductTextInSearch"),"No message in search result is displayed");
		HomePage homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(testdataProp.getProperty("invalidProduct"));
		//homePage.clickOnSearchButton();
		//SearchPage searchPage=new SearchPage(driver);
		searchPage=homePage.clickOnSearchButton();
		String actualSearchMessage=searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage,testdataProp.getProperty("noProductTextInSearch"),"No message in search result is displayed");
	}
	
	@Test(priority=3,dependsOnMethods= {"verifySearchWithInvalidProductName"})
	public void verifySearchWithoutProduct() {
//		driver.findElement(By.name("search")).sendKeys("");
//		driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();
//		String actualSearchMessage=driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
//		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductTextInSearch"),"No message in search result is displayed");

		HomePage homePage=new HomePage(driver);
		//homePage.clickOnSearchButton();
		//SearchPage searchPage=new SearchPage(driver);
		searchPage=homePage.clickOnSearchButton();
		String actualSearchMessage=searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage,testdataProp.getProperty("noProductTextInSearch"),"No message in search result is displayed");
	}

}

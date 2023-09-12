package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.Utilities;

public class Base {
	
	public WebDriver driver;
	public Properties configProp;
	public Properties testdataProp;
	
	public Base(){
	
	configProp=new Properties();
	File configData=new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties");
	
	testdataProp=new Properties();
	File testData=new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\testdata\\testdata.properties");

	try {
		FileInputStream configfis=new FileInputStream(configData);
		configProp.load(configfis);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	try {
		FileInputStream testdatafis=new FileInputStream(testData);
		testdataProp.load(testdatafis);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(configProp.getProperty("url"));
		
		
		return driver;
	}
	

}

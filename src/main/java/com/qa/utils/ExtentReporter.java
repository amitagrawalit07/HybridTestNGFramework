package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReports=new ExtentReports();
		//Extent Reports is an open-source reporting library useful for test automation. 
		//It can be easily integrated with major testing frameworks like JUnit, NUnit, TestNG, etc.
		File extentReportFile=new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(extentReportFile);
		//ExtentSparkReporter is a rich-HTML reporter available from the standard ExtentReports library
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("Test Automation Results Report");
		extentSparkReporter.config().setDocumentTitle("Automation Report");
		extentSparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReports.attachReporter(extentSparkReporter);
		
		Properties configProp=new Properties();
		File configPropFile=new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties");
		//FileInputStream fis;
		try {
			FileInputStream	fis = new FileInputStream(configPropFile);
			configProp.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReports.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentReports.setSystemInfo("Browser Name",configProp.getProperty("browser"));
		extentReports.setSystemInfo("Email",configProp.getProperty("validEmail"));
		extentReports.setSystemInfo("Password",configProp.getProperty("validPassword"));
		extentReports.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReports.setSystemInfo("Username",System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReports;
	}
}

package com.ed.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;

import com.ed.configDataProvider.ConfigFileReader;
import com.ed.utils.Log;



public class BaseClass{
	public static WebDriver driver;
	
	ConfigFileReader objconfigfilereader;
	public static final Logger logger = Log.getLogData(Log.class.getName());

	
	public void setUp()
	{
		try {
		objconfigfilereader = new ConfigFileReader();
		if(objconfigfilereader.getOS().contains("LINUX")) {
			if(objconfigfilereader.getBrowserType().contains("CHROME")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver"); 
				driver = new ChromeDriver();
			}
			else if(objconfigfilereader.getBrowserType().contains("FIREFOX")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/geckodriver"); 
			driver = new FirefoxDriver();	
			}
		}
		else if(objconfigfilereader.getOS().contains("WINDOWS")){
			if(objconfigfilereader.getBrowserType().contains("CHROME")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe"); 
				driver = new ChromeDriver();
			}
			else if(objconfigfilereader.getBrowserType().contains("FIREFOX")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/geckodriver.exe"); 
			driver = new FirefoxDriver();	
			}
		}
		
		driver.get(objconfigfilereader.getAppUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(objconfigfilereader.getImplicitWait(), TimeUnit.SECONDS);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
				  
	}
	public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
		iTestContext.setAttribute("driver", driver);
		return iTestContext;
	}

	public void tearDown(){
		driver.quit();
	}


}

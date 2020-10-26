package com.ed.test.LoginFlow;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ed.base.BaseClass;
import com.ed.configDataProvider.ConfigFileReader;
import com.ed.pages.CommonPage;
import com.ed.pages.LoginPage;


public class Login extends BaseClass
{
	LoginPage sign;
	CommonPage common;
	ConfigFileReader objconfigfilereader;
	public ITestContext context;
	@BeforeMethod
	public void init(ITestContext iTestContext)
	{	
		super.setUp(); this.context = setContext(iTestContext, driver);
		common=new CommonPage(driver);
		common.clickSubmit();
	}
	
	
	@Test
	public void loginWithValidCred()
	{
		try
		{
		logger.info("-------Login with Valid Credentials--------");
		sign=new LoginPage(driver);
		sign.loginSubmit("abc.lmn@gmail.com", "abc@123");
		Assert.assertEquals(sign.validateLoginPageTitle(), "My account - My Store");
		logger.info("Navigted to My account- My Store");
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void loginWithInValidCred()
	{
		try
		{
		logger.info("-------Login with Invalid credentials----------");
		sign=new LoginPage(driver);
		sign.loginSubmit("abc.lmn@gmail.com", "abcd@123");
		String error=sign.getAuthError();
		Assert.assertEquals(error, "Authentication failed.");
		logger.info("Validation Failed");
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

package com.ed.test.productFlow;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ed.base.BaseClass;
import com.ed.pages.CommonPage;
import com.ed.pages.LoginPage;

public class MenuDisplay extends BaseClass {
	
	private LoginPage sign;
	private CommonPage common;
	private Actions action;
	private ITestContext context;
	
	@BeforeClass
	public void init(ITestContext iTestContext){	
		super.setUp(); 
		this.context = setContext(iTestContext, driver);
		action = new Actions(driver);
		common=new CommonPage(driver);
	}
	
	
	@Test
	public void DressMenu() throws InterruptedException{
		try{
			logger.info("-------Check the items in Menu is Displayed correctly..........");
			
			Assert.assertTrue(common.getDresses().isDisplayed());
			action.moveToElement(common.getDresses()).perform();
			Assert.assertTrue(common.getSummerDresses().isDisplayed());
			Assert.assertTrue(common.getCasualDresses().isDisplayed());
			Assert.assertTrue(common.getEveningDresses().isDisplayed());
			logger.info("-------The items in menu is displayed properly.........");
		}
		catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}



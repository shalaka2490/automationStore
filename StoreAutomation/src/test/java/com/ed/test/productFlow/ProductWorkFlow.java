package com.ed.test.productFlow;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ed.base.BaseClass;
import com.ed.pages.ClothesPanel;
import com.ed.pages.CommonPage;
import com.ed.pages.LoginPage;
import com.ed.pages.ShoppingSummary;

public class ProductWorkFlow extends BaseClass {
	
	private ITestContext context;
	private LoginPage sign;
	private CommonPage common;
	private Actions action;
	private ClothesPanel clothes;
	private SoftAssert sassert=new SoftAssert();
	private ShoppingSummary summary;
	
	@BeforeClass
	public void init(ITestContext iTestContext)
	{	
		try {
			super.setUp(); 
			this.context = setContext(iTestContext, driver);
			action = new Actions(driver);
			common=new CommonPage(driver);
			sign=new LoginPage(driver);
			clothes=new ClothesPanel(driver);
			summary=new ShoppingSummary(driver);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}
	
	@Test(priority =1)
	public void login() {
  		try {
	  		logger.info("---Login---");
			common.clickSubmit();
			sign.loginSubmit("abc.lmn@gmail.com", "abc@123");
			Assert.assertEquals(sign.validateLoginPageTitle(), "My account - My Store");
  		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}
  
	@Test(priority =2)
	public void selectProduct() {
		try{
		  logger.info("---Select Product---");
		  Assert.assertTrue(common.getDresses().isDisplayed());
		  action.moveToElement(common.getDresses()).perform();
		  action.moveToElement(common.getCasualDresses()).perform();
		  common.getCasualDresses().click();
		  Assert.assertEquals(common.validatePageTitle(), "Casual Dresses - My Store");
	  	}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
  }
  
  @Test(priority=3)
  public void verifyProductCriteria(){
	  	try {
  		  List<WebElement> products=clothes.getClothes();
		  clothes.clickonProduct(products.get(0));
		  sassert.assertEquals(clothes.getClothMaterial(), "Cotton");
		  sassert.assertEquals(clothes.getPrice(), "$26.00");
		  logger.info("The material of dress is "+clothes.getClothMaterial() );
		  logger.info("The price of dress is "+clothes.getPrice() );
		  List<String> colors=clothes.getColor();
		  if(colors.contains("Orange"))
			  logger.info("Dress is available in Orange Color");
		  List<String> size=clothes.getSize();
		  if(size.contains("S"))
			  logger.info("Size has value S");
		  logger.info("All Sizes"+ size);
	  	}
		catch(Exception e)
		{
		  logger.error(e.getMessage());
		}
	  }
  
  @Test(priority=4)
  public void addtoCart() {
	  try {
		  logger.info("---Add to  cart----");
		  clothes.addtoCart();
	  }
	  catch(Exception e)
	  {
		  logger.error(e.getMessage());
	  }
  }
  
  @Test(priority=5)
  public void checkOut() throws InterruptedException {
	  try {
		  logger.info("---Checkout----");
	  	  Thread.sleep(5000);
		  clothes.proceedtoCheckout();
		  Assert.assertEquals(common.validatePageTitle(), "Order - My Store");
	  }
	  catch(Exception e)
	  {
		  logger.error(e.getMessage());
	  }
  	}
  
  @Test(priority=6)
  public void shoppingCartSummary() 
  {
	  //Check the price and proceed to checkout
	  try {
		  logger.info("---Shopping Cart Summary----");
		  Assert.assertEquals(summary.getProductPrice(), "$26.00");
		  Assert.assertEquals(summary.getShippingPrice(), "$2.00");
		  Assert.assertEquals(summary.getTotalPrice(), "$28.00");
	 	  summary.clickProceed1();
	  	}
	  	catch(Exception e)
		{
			logger.error(e.getMessage());
		}
  }
  
  @Test(priority=7)
  public void checkBillingAddress() 
  {
	  //Check Billing address is valid
	  try {
		  logger.info("---Billing Address Verification----");
		  Assert.assertEquals(summary.getName(), "ABC LMN");
		  Assert.assertEquals(summary.getAddress(),"Cleveland, OH");
		  Assert.assertEquals(summary.getState(),"Ontario, Arkansas 44113");
		  Assert.assertEquals(summary.getCountry(),"United States");
		  Assert.assertEquals(summary.getPhone(),"3434344444");
		  summary.ProceedCheckout2();
	  }
	  catch(Exception e)
	  {
		  logger.error(e.getMessage());
	  }
	  
  }
  
  @Test(priority=8)
  public void termOfService() 
  {
	  try {
		  logger.info("---Agree to Term of Service and proceed----");
		  summary.clickTerms();
		  summary.clickProceed3();
	  }
	  catch(Exception e)
	  {
		  logger.error(e.getMessage());
	  }
	  
  }
  @Test(priority=9)
  public void payAndConfirm() 
  {
	  try {
		  logger.info("---Payment and Confirmation---");
		  summary.payCheque();
		  summary.confirmOrder();
		  Assert.assertEquals(summary.getSuccessText(), "Your order on My Store is complete.");
		  Assert.assertEquals(common.validatePageTitle(), "Order confirmation - My Store");
	  }
	  catch(Exception e)
	  {
			logger.error(e.getMessage());
	  }
  }
  
  @AfterClass()
  public void tearDown()
  {
	  driver.quit();
  }
  
}

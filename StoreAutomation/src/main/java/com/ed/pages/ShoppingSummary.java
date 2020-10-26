package com.ed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ed.utils.CommonUtilities;

public class ShoppingSummary {
WebDriver driver;

//Summary
@FindBy(xpath="//td[@id=\"total_product\"]")
public WebElement totalProduct;

@FindBy(xpath="//td[@id=\"total_shipping\"]")
public WebElement totalShipping;

@FindBy(xpath="//td[@id=\"total_price_container\"]")
public WebElement totalPrice;

@FindBy(xpath="//a[@class=\"button btn btn-default standard-checkout button-medium\"]")
public WebElement btnCheckout;

//Address
@FindBy(xpath="//ul[@id=\"address_invoice\"]/li[@class=\"address_firstname address_lastname\"]")
public WebElement lblName;

@FindBy(xpath="//ul[@id=\"address_invoice\"]/li[@class=\"address_address1 address_address2\"]")
public WebElement lblAddress;

@FindBy(xpath="//ul[@id=\"address_invoice\"]/li[@class=\"address_city address_state_name address_postcode\"]")
public WebElement lblState;

@FindBy(xpath="//ul[@id=\"address_invoice\"]/li[@class=\"address_country_name\"]")
public WebElement lblCountry;

@FindBy(xpath="//ul[@id=\"address_invoice\"]/li[@class=\"address_phone_mobile\"]")
public WebElement lblPhone;

@FindBy(xpath="//button[@name=\"processAddress\"]")
public WebElement btnProceed;


//Shipping
@FindBy(xpath="//input[@id='cgv']")
public WebElement chkTerms;

@FindBy(xpath="//button[@class=\"button btn btn-default standard-checkout button-medium\"]")
public WebElement btnProceedCheckout;




//Payment
@FindBy(xpath="//a[@class=\"cheque\"]")
public WebElement btnPay;

@FindBy(xpath="//button[@class=\"button btn btn-default button-medium\"]")
public WebElement btnConfirm;

@FindBy(xpath="//p[@class=\"alert alert-success\"]")
public WebElement txtAlertSuccess;


public ShoppingSummary(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}
//Summary
public String getProductPrice()
{
	return totalProduct.getText();
}

public String getShippingPrice()
{
	return totalShipping.getText();
}

public String getTotalPrice()
{
	return totalPrice.getText();
}

public void clickProceed1()
{
	CommonUtilities.waitForElement(driver, btnCheckout, 20);
	btnCheckout.click();
}

//Address
public String getName()
{
	return lblName.getText();
}

public String getAddress()
{
	return lblAddress.getText();
}

public String getState()
{
	return lblState.getText();
}

public String getCountry()
{
	return lblCountry.getText();
}

public String getPhone()
{
	return lblPhone.getText();
}

public void ProceedCheckout2()
{
	btnProceed.click();
}

//Shipping
public void clickTerms()
{
	CommonUtilities.waitForElement(driver, chkTerms, 20);
	chkTerms.click();
}

public void clickProceed3()
{
	CommonUtilities.waitForElement(driver, btnProceedCheckout, 20);
	btnProceedCheckout.click();
}

//Payment
public void payCheque()
{
	CommonUtilities.waitForElement(driver, btnPay, 20);
	btnPay.click();
}

public void confirmOrder()
{
	CommonUtilities.waitForElement(driver, btnConfirm, 20);
	btnConfirm.click();
}

public String getSuccessText()
{
	return txtAlertSuccess.getText();
}



}

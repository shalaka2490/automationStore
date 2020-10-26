package com.ed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
WebDriver driver;
   
	
	@FindBy(xpath="//input[@id=\"customer_firstname\"]" )
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id=\"customer_lastname\"]")
	public WebElement txtLastName;
	
	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement  txtEmail;
	
	@FindBy(xpath="//input[@id=\"passwd\"]")
	WebElement  txtPassword;
	
	
	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement  txtAddFirstName;
	
	
	@FindBy(xpath="//input[@id=\"lastname\"]")
	WebElement  txtAddLastName;
	
	
	@FindBy(xpath="//input[@id=\"address1\"]")
	WebElement  txtAddress;
	
	
	@FindBy(xpath="//input[@id=\"city\"]")
	WebElement  txtCity;
	
	
	@FindBy(xpath="//select[@id=\"id_state\"]")
	WebElement  drpState;
	
	@FindBy(xpath="//select[@id=\"postcode\"]")
	WebElement  txtpostalcode;
	
	@FindBy(xpath="//select[@id=\"id_country\"]")
	WebElement  drpCountry;
	
	@FindBy(xpath="//input[@id=\"phone_mobile\"]")
	WebElement  txtmobile;

	
	
	
	public CreateAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	public void setPassword(String strpassword)
	{
		txtPassword.sendKeys(strpassword);
	}
	
	
	

	
}

package com.ed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ed.utils.CommonUtilities;
import com.ed.utils.JavaScriptTestHelper;

public class LoginPage {
WebDriver driver;
CommonUtilities common;
   
	
	@FindBy(xpath="//input[@name=\"email_create\"]" )
	WebElement txtRegEmail;
	
	@FindBy(xpath="//input[@name=\"SubmitCreate\"]")
	public WebElement btnCreateAccount;
	
	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement  txtSignEmail;
	
	@FindBy(xpath="//input[@id=\"passwd\"]")
	WebElement  txtSignPassword;
	
	@FindBy(xpath="//button[@id=\"SubmitLogin\"]")
	public WebElement btnSignIn;
	
	//Errors
	@FindBy(xpath="//li[contains(text(),'Password is required.')]")
	public WebElement errPassword;
	
	@FindBy(xpath="//div[@class='alert alert-danger']//li")
	public WebElement authError;

	

	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void setEmail(String email)
	{
		CommonUtilities.waitForElement(driver, txtSignEmail, 20);
		txtSignEmail.sendKeys(email);
	}
	
	
	public void setPassword(String strpassword)
	{
		CommonUtilities.waitForElement(driver, txtSignPassword, 20);
		txtSignPassword.sendKeys(strpassword);
	}
	
	public void clickSubmit()
	{
		CommonUtilities.waitForElement(driver, btnSignIn, 20);
		btnSignIn.click();
	}
	
	public void loginSubmit(String strLoginId,String strPassword)
	{
		this.setEmail(strLoginId);
		this.setPassword(strPassword);
		this.clickSubmit();
		
		
	}
	
	

	public String getAuthError() {
		// TODO Auto-generated method stub
		return authError.getText();
	}
	
	public String validateLoginPageTitle(){
	        return JavaScriptTestHelper.getTitleByJS(driver);
	    }

}

package com.ed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ed.utils.CommonUtilities;
import com.ed.utils.JavaScriptTestHelper;

public class CommonPage {
WebDriver driver;
   
	
	@FindBy(xpath="//a[@class=\"login\"]" )
	WebElement btnSignIn;
	
	//Clothes Menu Bar
	
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[1]" )
	WebElement menuWomen;
	
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[2]" )
	WebElement menuDresses;
	
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[3]" )
	WebElement menuTshirts;
	
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]")
	WebElement btnSummerDresses;
	
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]")
	WebElement btnEveningDresses;
	
	@FindBy(xpath="//div[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]")
	WebElement btnCasualDresses;
	
	public CommonPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public WebElement getDresses()
	{
		return menuDresses;
	}
	
	
	
	public WebElement getCasualDresses()
	{
		return btnCasualDresses;
	}
	
	public WebElement getEveningDresses()
	{
		CommonUtilities.waitForElement(driver, btnEveningDresses, 20);
		return btnEveningDresses;
	}
	
	
	public void clickSubmit()
	{
		btnSignIn.click();
	}

	public WebElement getSummerDresses() {
		// TODO Auto-generated method stub
		return btnSummerDresses;
	}
	
	public String validatePageTitle(){
        return JavaScriptTestHelper.getTitleByJS(driver);
    }

	

	

}

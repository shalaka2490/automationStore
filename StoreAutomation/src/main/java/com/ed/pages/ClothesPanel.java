package com.ed.pages;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ed.utils.CommonUtilities;

public class ClothesPanel {

WebDriver driver;

@FindBy(xpath="//div[@id=\"center_column\"]/ul/li")
List<WebElement> listClothes;

@FindBy(xpath="//table[@class=\"table-data-sheet\"]/tbody[1]/tr[1]/td[2]")
WebElement lblClothMaterial;

@FindBy(xpath="//span[@id=\"our_price_display\"]")
WebElement lblPrice;

@FindBy(xpath="//ul[@id=\"color_to_pick_list\"]/li")
List<WebElement> btnColor;

@FindBy(xpath="//button[@type=\"submit\"]/span[contains(text(),\"Add to cart\")]")
WebElement btnAddtoCart;

@FindBy(xpath="//a[@title=\"Proceed to checkout\"]")
WebElement btnCheckout;

@FindBy(xpath="//select[@id=\"group_1\"]")
WebElement drpSize;

public ClothesPanel(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}

public List<WebElement> getClothes()
{
	return listClothes;

	
}

public List<WebElement> getColors()
{
	return btnColor;

}


public String getColorText(WebElement colorBox)
{
	CommonUtilities.waitForElement(driver, colorBox, 20);
	return colorBox.getText();
	
}

public void clickonProduct(WebElement product)
{
	CommonUtilities.waitForElement(driver, product, 20);
	product.click();
}

public String getClothMaterial()
{
	CommonUtilities.waitForElement(driver, lblClothMaterial, 20);
	return lblClothMaterial.getText();
}

public String getPrice()
{
	return lblPrice.getText();
}

public void addtoCart()
{
	CommonUtilities.waitForElement(driver, btnAddtoCart, 20);
	btnAddtoCart.click();
}

public void proceedtoCheckout()
{
	btnCheckout.click();
}
public List<String> getColor()
{
	
	int s = btnColor.size();
	List<String> color = new ArrayList<String>();
    for(int i =0; i<s ; i++){
      color.add(btnColor.get(i).getText());
    }
	return color;
}
public List<String> getSize()
{
	Select size=new Select(drpSize);
	List<WebElement> totalSize=size.getOptions();
	int s = totalSize.size();
	List<String> sizes = new ArrayList<String>();
    for(int i =0; i<s ; i++){
      sizes.add(totalSize.get(i).getText());
    }
	return sizes;
}
}

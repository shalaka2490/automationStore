package com.ed.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ed.base.BaseClass;

public class CommonUtilities extends BaseClass {
	public static void waitForElement(WebDriver driver, WebElement element, int seconds) {
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(NoSuchElementException e)
		{
			logger.error(e.getMessage());
		}
	}

	// To wait for element till it's clickable using locator
	public static void waitForElement_by_locator(WebDriver driver, By locator, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
	}

	public static void waitTillElementFound(WebDriver driver, WebElement ElementTobeFound, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));

	}

	// To wait for element till it's visible in DOM using locator
	public static void waitTillElementFound_by_locator(WebDriver driver, By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

	}

	public static void waitImplicitTime(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}

	public static void waitTillPageLoad(int i) {

		driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);

	}
}

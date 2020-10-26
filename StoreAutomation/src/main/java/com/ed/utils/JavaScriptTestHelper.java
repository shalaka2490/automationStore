package com.ed.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptTestHelper {
	 // get title

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript("return document.title").toString();
    }
}

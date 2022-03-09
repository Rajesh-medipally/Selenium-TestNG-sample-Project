package com.seleniumProject.utilities;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Utils {

	public static void waitForVisibility(WebElement element , WebDriver driver){
		 new WebDriverWait(driver,Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(element));
	}
	
}

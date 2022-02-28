package com.seleniumProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
//	public static HomePage getInstance(WebDriver driver1) {
//		if(homePage==null) homePage =new HomePage(driver1);
//		return homePage;
//	}
//	

	@FindBy(how=How.CLASS_NAME,using="login")
	WebElement signInButton;
	public void clickSignInButton() {
		signInButton.click();
	}
	
	
	
}

package com.seleniumProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

public WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//Sign out Button
		@FindBy(how=How.CLASS_NAME ,using="logout")
		WebElement signOutButton;
		public void clickSignOutButton() {
			signOutButton.click();
		}
		
		
}

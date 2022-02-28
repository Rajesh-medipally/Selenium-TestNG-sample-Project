package com.seleniumProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
//	public static LoginPage getInstance(WebDriver driver1) {
//		if(loginPage==null) loginPage =new LoginPage(driver1);
//		return loginPage;
//	}
//	
	
	//email text field
	@FindBy(id="email")
	WebElement emailField;
	public void enterEmailField(String email) {
		emailField.sendKeys(email);
	}
	
	//password text field
	@FindBy(id="passwd")
	WebElement passwordField;
	public void enterPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	//SignIn Button
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	public void clickSignInButton() {
		loginButton.click();
	}

}

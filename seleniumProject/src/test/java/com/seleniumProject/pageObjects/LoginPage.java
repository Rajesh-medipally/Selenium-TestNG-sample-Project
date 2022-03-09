package com.seleniumProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumProject.utilities.Utils;


public class LoginPage {
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	//login form
	@FindBy(id="login_form")
	WebElement loginForm;
	
	//email text field
	@FindBy(id="email")
	WebElement emailField;
	
	//password text field
	@FindBy(id="passwd")
	WebElement passwordField;

	//SignIn Button
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	
	// Email format Wrong Red Cross Symbol
	@FindBy(xpath = "//div[@class=\"form-group form-error\"]//input[@id=\"email\"]")
	WebElement emailFormatWrongSymbol;
	
	//Email format right green right symbol
	@FindBy(xpath = "//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]")
	WebElement emailFormatRightSymbol;
	
	@FindBy(xpath = "//div[@class=\"alert alert-danger\"]//li[contains(text(), \"Invalid email address.\")]")
	WebElement invalidEmailErrorMessage;

	@FindBy(xpath = "//div[@class=\"alert alert-danger\"]//li[contains(text(), \"Invalid password.\")]")
	WebElement invalidPasswordErrorMessage;
	
	@FindBy(xpath = "//li[contains(text(), \"An email address required.\")]")
	WebElement emailAddressRequiredErrorMessage;
	
	@FindBy(xpath = "//li[contains(text(), \"Password is required.\")]")
	WebElement passwordRequiredErrorMessage;
	
	
	// getters ==============
	public WebElement getLoginForm() {
		return loginForm;
	}
	public WebElement getEmailField() {
		return emailField;
	}
	public WebElement getPasswordField() {
		return passwordField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getEmailFormatWrongSymbol() {
		Utils.waitForVisibility(emailFormatWrongSymbol, driver);
		return emailFormatWrongSymbol;
	}

	public WebElement getEmailFormatRightSymbol() {
		Utils.waitForVisibility(emailFormatRightSymbol, driver);
		return emailFormatRightSymbol;
	}

	public WebElement getInvalidEmailErrorMessage() {
		Utils.waitForVisibility(invalidEmailErrorMessage, driver);
		return invalidEmailErrorMessage;
	}

	public WebElement getInvalidPasswordErrorMessage() {
		Utils.waitForVisibility(invalidPasswordErrorMessage, driver);
		return invalidPasswordErrorMessage;
	}

	public WebElement getEmailAddressRequiredErrorMessage() {
		Utils.waitForVisibility(emailAddressRequiredErrorMessage, driver);
		return emailAddressRequiredErrorMessage;
	}

	public WebElement getPasswordRequiredErrorMessage() {
		Utils.waitForVisibility(passwordRequiredErrorMessage, driver);
		return passwordRequiredErrorMessage;
	}

	
	//setters=============
	public void setEmailField(String email) {
		this.emailField.sendKeys(email); 
	}
	public void setPasswordField(String password) {
		this.passwordField.sendKeys(password);
	}
	public void clickLoginButton() {
		this.loginButton.click(); 
	}

	
	
	
	// page functions
	
	
	public void doLoginProcess(String email, String password) {
	
		setEmailField(email);
		setPasswordField(password);
		clickLoginButton();
		
	}
	
	
	
	
}

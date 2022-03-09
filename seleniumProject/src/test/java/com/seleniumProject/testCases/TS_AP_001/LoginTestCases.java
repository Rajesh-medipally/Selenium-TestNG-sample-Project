package com.seleniumProject.testCases.TS_AP_001;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.seleniumProject.pageObjects.HomePage;
import com.seleniumProject.pageObjects.LoginPage;
import com.seleniumProject.pageObjects.MyAccountPage;
import com.seleniumProject.testCases.Base;
import com.seleniumProject.utilities.Utils;

// this class includes 
public class LoginTestCases extends Base {
	
	HomePage homePage ;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	String[] emailFormatTestData = {"abcd","abcd@email","abcd@email.email"};
	
	@BeforeClass
	public void elementSetup() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccountPage = new MyAccountPage(driver);

		//page navigation 

		homePage.clickSignInButton();

	}
	
	
	//this test method ensures fields are visible and accessible 
	@Test(priority = 1)
	public void areFieldsAccessible() {
		homePage.clickSignInButton();
		
		//login form display test
		logger.info("Login Form Display test");
		Assert.assertTrue(loginPage.getLoginForm().isDisplayed());
		//email field
		logger.info("Email field Display test ");
		Assert.assertTrue(loginPage.getEmailField().isDisplayed());
		// password field
		logger.info("password field display test");
		Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
		//SignIn Button
		logger.info("Sign in button enable test");
		Assert.assertTrue(loginPage.getLoginButton().isEnabled());
		
	}
	
	
	// this test is to verify red cross symbol is popping when entered wrong email formats
	@Test(priority = 3)
	public  void emailFormatTesting() {
		Actions act = new Actions(driver);
		
		for(int i=0;i<emailFormatTestData.length;i++) {
		logger.info(emailFormatTestData[i] + " is entered"); 
		loginPage.setEmailField(emailFormatTestData[i]);		
		act.sendKeys(Keys.TAB).build().perform();
		//asserting for email field showing the error
		Assert.assertTrue(loginPage.getEmailFormatWrongSymbol().isDisplayed());
		act.sendKeys(Keys.RETURN).build().perform();
		}
		
		// verifying write email format
		
		logger.info("entering right email format");
		loginPage.setEmailField("email@email.com");
		act.sendKeys(Keys.TAB).build().perform();
		Assert.assertTrue(loginPage.getEmailFormatRightSymbol().isDisplayed());
		}
	
	
	
	
//	@Test(priority = 2)
//	public void invalidCredentials() {
//		// username: email@email.com
//		// password: asddsa
//
//		signin.setEmailField("neki@email.com");
//		signin.setPasswordField("sifra");
//		signin.getSignInBtn().click();
//
//		Assert.assertTrue(signin.getAuthenticationFailedError().isDisplayed());
//
//		signin.setEmailField("email@email.email");
//		signin.setPasswordField("sifra");
//		signin.getSignInBtn().click();
//
//		Assert.assertTrue(signin.getAuthenticationFailedError().isDisplayed());
//
//		signin.setEmailField("mapkoct@gmail.com");
//		signin.setPasswordField("asddsa");
//		signin.getSignInBtn().click();
//
//		Assert.assertTrue(signin.getAuthenticationFailedError().isDisplayed());
//
//	}
//	
	

	@Test(priority = 2)
	public void credentialTesting() {
		//enter empty email and valid password
		loginPage.doLoginProcess(" ", password);
		Assert.assertTrue(loginPage.getEmailAddressRequiredErrorMessage().isDisplayed());
		
		//enter valid email empty password
		loginPage.doLoginProcess(emailId, " ");
		Assert.assertTrue(loginPage.getPasswordRequiredErrorMessage().isDisplayed());
		
		//enter empty email and empty password
		loginPage.doLoginProcess("", "");
		Assert.assertTrue(loginPage.getEmailAddressRequiredErrorMessage().isDisplayed());
		
		
		//enter invalid email and invalid password
		loginPage.doLoginProcess("abcd", "password");
		Assert.assertTrue(loginPage.getInvalidEmailErrorMessage().isDisplayed());
		
		//enter valid email and invalid password
		loginPage.doLoginProcess(emailId, "password");
		Assert.assertTrue(loginPage.getInvalidPasswordErrorMessage().isDisplayed());
		
//		//enter valid email valid password 
//		
//		loginPage.doLoginProcess(emailId, password);
//		Assert.assertEquals(driver.getTitle(), "My account - My Store");
//		myAccountPage.clickSignOutButton();
//		Utils.waitForVisibility(loginPage.getLoginForm(), driver);
//		
		
	}
	
	
}

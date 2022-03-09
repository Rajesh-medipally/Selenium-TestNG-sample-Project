package com.seleniumProject.testCases.TS_AP_001;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumProject.pageObjects.HomePage;
import com.seleniumProject.pageObjects.LoginPage;
import com.seleniumProject.testCases.Base;

public class TC_Login_001 extends Base {
	
	//verify the login functionality by entering valid email and valid password
	@Test
	public void LoginTest() {
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	
	//step -1 : launch home page
	driver.get(readConfig.getApplicationURL());
	logger.info("page loaded");
	
	//step -2 : click Sign in button 
	homePage.clickSignInButton();
	logger.info("Sign in clicked in home page");
	
	//step- 3 : enter user name 
	loginPage.setEmailField(readConfig.getEmailId());
	logger.info("email entered");
	
	//step - 4 : enter password
	loginPage.setPasswordField(readConfig.getPassword());
	logger.info("password entered");
	
	//step- 5 : click sign in
	loginPage.clickLoginButton();
	logger.info("Sign in clicked in login page");
	
	// step -6 : make sure the my account page is landed 
	//	 with title "My account - My Store"
	
	if(driver.getTitle().equals("My account - My Store")) {
		Assert.assertTrue(true);
		logger.info("login test passed");
	}else {
		Assert.assertTrue(false);
		logger.info("login test failed");
	}
	
	
	}
	

}

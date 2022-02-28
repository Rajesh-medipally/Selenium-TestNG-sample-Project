package com.seleniumProject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumProject.pageObjects.HomePage;
import com.seleniumProject.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Base {
	
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
	loginPage.enterEmailField(readConfig.getEmailId());
	logger.info("email entered");
	
	//step - 4 : enter password
	loginPage.enterPasswordField(readConfig.getPassword());
	logger.info("password entered");
	
	//step- 5 : click sign in
	loginPage.clickSignInButton();
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

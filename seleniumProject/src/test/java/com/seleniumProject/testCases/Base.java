package com.seleniumProject.testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.seleniumProject.utilities.ReadConfig;


public class Base {
	ReadConfig readConfig = new ReadConfig();
	
	
	//public String baseUrl =readConfig.getApplicationURL();
	public String emailId=readConfig.getEmailId();
	 public static WebDriver driver;
	public static Logger logger; 
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		//logger configuration
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		//browser selection
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath() );
			driver= new ChromeDriver();			
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver= new FirefoxDriver();
		}else if(br.equals("ie")){
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(readConfig.getApplicationURL());
				
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

package com.seleniumProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	public ReadConfig() {
		File src= new File("./Configurations/config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		properties =new Properties();
		properties.load(fis);
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}



	public String getApplicationURL() {return properties.getProperty("baseURL");}
	public String getEmailId() {return properties.getProperty("emailID");}
	public String getChromePath() {return properties.getProperty("chromepath");}
	public String getFirefoxPath() {return properties.getProperty("firefoxpath"); }
	public String getIEPath() {return properties.getProperty("iepath");}
	public String getUserId() {return properties.getProperty("userId");}
	public String getPassword() {return properties.getProperty("password");}	
	
	
	


}

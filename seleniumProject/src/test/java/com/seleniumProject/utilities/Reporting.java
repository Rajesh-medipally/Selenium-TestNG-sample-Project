package com.seleniumProject.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.seleniumProject.testCases.Base;


public class Reporting  extends Base implements ITestListener{
	
	public 	ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest logger;
//	
//	public void onStart(ITestContext testContext) {
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String repName = "Test-Report-"+timeStamp+".html";
//		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
////		try {
////			sparkreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
//		extent = new ExtentReports();
//		extent.attachReporter(sparkreporter);
//		extent.setSystemInfo("Host Name", "Local host");
//		extent.setSystemInfo("Environment", "QA");
//		extent.setSystemInfo("user", "rajesh");
//	
//		sparkreporter.config().setDocumentTitle("InetBanking Test Project");
//		sparkreporter.config().setReportName("Fuhnctional Test Report");
//		sparkreporter.config().setTheme(Theme.DARK);
//		
//	}
//
////	public void onTestSuccess(ITestResult testContext) {
////		logger= extent.createTest(testContext.getName());
////		logger.pass("test passed successfully");
//////		logger.log(Status.PASS,MarkupHelper.createLabel(testContext.getName(), ExtentColor.GREEN));
////		
////	}
//
//	public void onTestFailure(ITestContext testContext) {
//		logger=extent.createTest(testContext.getName());
////		logger.log(Status.FAIL, MarkupHelper.createLabel(testContext.getName(), ExtentColor.RED));
//		
//		String screenshotpath= System.getProperty("user.dir")+"\\SScreenshots\\"+testContext.getName()+".png";
//		
//		File f = new File(screenshotpath);
//		if(f.exists()) {
////			logger.fail("screenshot is below :"+logger.addScreenCaptureFromPath(screenshotpath));
//			
//		}
//
//	}
//	
//	
//	public void onTestSkipped (ITestContext testContext) {
//		logger=extent.createTest(testContext.getName());
//		logger.log(Status.SKIP, MarkupHelper.createLabel(testContext.getName(), ExtentColor.ORANGE));
//		
//	}
//
//	
//	public void onFinish(ITestResult testContext) {
//		extent.flush();	
//	}
//
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
	
		
		logger= extent.createTest(result.getName());
////	logger.pass("test passed successfully");
	logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
//	
	
	
	}
	public void onTestFailure(ITestResult result) {		
		String screenshotpath= System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";			
		logger=extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(screenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	if(file.exists()) {
		logger.fail("screenshot is below :"+logger.addScreenCaptureFromPath(screenshotpath));
		
	}
	 
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
		
		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-reports/"+repName);
////		try {
////			sparkreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Host Name", "Local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "rajesh");
	
		sparkreporter.config().setDocumentTitle("InetBanking Test Project");
		sparkreporter.config().setReportName("Fuhnctional Test Report");
		sparkreporter.config().setTheme(Theme.DARK);
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		
		extent.flush();
	}

	
	
	
	
	
	
	
//	
//	
//	public void onTestStart(ITestResult result) {
//		
//	}
//
//
//	
//	
//	public void onStart(ITestContext testContext) {
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String repName = "Test-Report-"+timeStamp+".html";
//		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
////		try {
////			sparkreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
//		extent = new ExtentReports();
//		extent.attachReporter(sparkreporter);
//		extent.setSystemInfo("Host Name", "Local host");
//		extent.setSystemInfo("Environment", "QA");
//		extent.setSystemInfo("user", "rajesh");
//	
//		sparkreporter.config().setDocumentTitle("InetBanking Test Project");
//		sparkreporter.config().setReportName("Fuhnctional Test Report");
//		sparkreporter.config().setTheme(Theme.DARK);
//	}
//	
//	
//	public void onTestSuccess(ITestResult tr) {
//	logger= extent.createTest(tr.getName());
////	logger.pass("test passed successfully");
//	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
//	}
//
//public void onTestSkipped(ITestResult tr) {
//		// TODO Auto-generated method stub
//		super.onTestSkipped(tr);
//	}
//
//	
//	
//	public void onTestFailure(ITestResult tr) {
//		logger=extent.createTest(tr.getName());
//		
////		logger.fail("test failed");
//	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
//	
//	String screenshotpath= System.getProperty("user.dir")+"\\SScreenshots\\"+tr.getName()+".png";
//	
//	File f = new File(screenshotpath);
//	if(f.exists()) {
//		logger.fail("screenshot is below :"+logger.addScreenCaptureFromPath(screenshotpath));
//		
//	}
//	}
//
//	
//	
//	public void onFinish(ITestContext testContext) {
//		extent.flush();	
//		}
//	
//
//	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

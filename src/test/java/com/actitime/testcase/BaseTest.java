package com.actitime.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.actitime.base.DriverScript;
import com.actitime.pages.LoginPage;
import com.actitime.pages.TaskMenuPage;
import com.actitime.utils.ExcelLib;
import com.actitime.utils.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/*
 * Name: BaseTest
 * Description: This is a parent script which has the set of prerequisite steps before executing actual test case
 * Author: Upama
 * Date Modified: 02/17/2022
 */


public class BaseTest extends DriverScript {
	
	LoginPage lp;
	EnterTimePage ep;
	TaskMenuPage tp;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeClass
	public void setReport() {
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./acreports/actiauto.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp() {
		initApplication();
		lp = new LoginPage();
		ep = new EnterTimePage();
		tp = new TaskMenuPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Utils.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
		quitBrowser();
	}  

	@DataProvider(name = "actiData")
	public Object[][] testData() {
		ExcelLib excel = new ExcelLib("./actestdata/actidata.xlsx");
		int rows = excel.getRowCount(0);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = excel.getCellData(0, i, 0);
			data[i][1] = excel.getCellData(0, i, 1);
		}
		return data;
	}
	
}

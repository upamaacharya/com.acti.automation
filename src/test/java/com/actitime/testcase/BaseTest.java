package com.actitime.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.actitime.base.DriverScript;
import com.actitime.pages.LoginPage;

/*
 * Name: BaseTest
 * Description: This is a parent script which has the set of prerequisite steps before executing actual test case
 * Author: Upama
 * Date Modified: 02/17/2022
 */


public class BaseTest extends DriverScript {
	

	LoginPage lp;
	EnterTimePage etp;
	
	@BeforeMethod
	public void setUp() {
		initApplication();
		lp = new LoginPage();
		etp = new EnterTimePage();
	}
	
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}

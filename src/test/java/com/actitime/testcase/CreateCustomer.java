package com.actitime.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCustomer extends BaseTest {
	
	@Test
	public void testCreateCustomer()
	{
		
		//logger.pass("m") : logger.info("m") : logger.fail - this will be taken care in the aftermethod
		//for a test case maximum 1 or 2 validation to decide status should be kept as pass
		//rest of the steps can be considered as info
		
		logger = report.createTest("Create Customer");
		lp.enterUserName("admin");
		logger.info("entered username");
		lp.enterPassword("manager");
		logger.info("entered password");
		lp.clickLoginButton();
		logger.info("clicked login button");
		ep.clickTaskMenu();
		logger.info("clicked task menu page");
		sleep(2000);
		tp.clickAddNewButton();
		logger.info("clicked add new button");
		sleep(2000);
		tp.clickAddNewCustomerDropdown();
		logger.info("clicked add new customer dropdown");
		tp.enterTextCustomerName("Test User1");
		logger.info("entered customer name");
		tp.enterTextCustomerDescription("Test Description");
		logger.info("entered customer description");
		tp.clickCreateCustomerButton();
		logger.info("clicked create cutomer button");
		String actual = tp.validateSuccessMessage();
		sleep(2000);
		Assert.assertTrue(actual.contains("created"));
		logger.pass("Customer created successfully");
	} 
	
	public void sleep(int m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

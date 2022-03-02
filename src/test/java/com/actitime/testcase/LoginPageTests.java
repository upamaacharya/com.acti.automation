package com.actitime.testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.utils.ExcelLib;

public class LoginPageTests extends BaseTest {

	@Test(enabled = true)
	public void testValidateLoginPageDisplayed() {
		String title = lp.getLoginPageTitle();
		System.out.println(title);
	}

	@Test(enabled = true)
	public void testValidateActiLogoDisplayed() {
		boolean flag = lp.verifyActiLogo();
		Assert.assertTrue(flag);
	}

	@Test(dataProvider = "actiData")
	public void testLoginFunction(String username, String password) {
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickLoginButton();
		String actual = ep.verifyUserLoggedIn();
		System.out.println(actual);
		ep.clickLogout();
	}



}

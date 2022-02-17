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
		String actual = etp.verifyUserLoggedIn();
		System.out.println(actual);
		etp.clickLogout();
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

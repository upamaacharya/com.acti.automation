package com.actitime.testcase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.base.DriverScript;

public class TaskMenuPage extends DriverScript {
	
	// Page Elements
	
//	AddNew button
	@FindBy(xpath="//div[@class='title ellipsis']") WebElement addNewButton;
//	New Customer Option
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement addNewCustomerButton;
//	Enter Customer Name
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']") WebElement enterCustomerName;
//	Enter Customer Description
	@FindBy(xpath="//input[@class='']") WebElement enterCustomerDescription;
//	Create Customer Button
	@FindBy(xpath="//div[text()='Create Customer']") WebElement createCustomerButton;
//	Success Message
	

}

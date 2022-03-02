package com.actitime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.base.DriverScript;

public class TaskMenuPage extends DriverScript {

	// Page Elements

//	AddNew button
	@FindBy(xpath = "//div[@class='downIcon']")
	WebElement addNewButton;
//	New Customer Option
	@FindBy(xpath = "//div[@class='item createNewCustomer']")
	WebElement addNewCustomerDropdown;
//	Enter Customer Name
	@FindBy(xpath = "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	WebElement enterCustomerName;
//	Enter Customer Description
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	WebElement enterCustomerDescription;
//	Create Customer Button
	@FindBy(xpath = "//div[text()='Create Customer']")
	WebElement createCustomerButton;
//	Success Message
	@FindBy(xpath = "//span[@class='innerHtml']")
	WebElement textSuccessMessage;


	// Page Initialization

	public TaskMenuPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	// Page Methods
	
	public void clickAddNewButton() {
		addNewButton.click();
	}

	public void clickAddNewCustomerDropdown() {
		addNewCustomerDropdown.click();
	}
	
	public void enterTextCustomerName(String customername) {
		enterCustomerName.sendKeys(customername);
	}
	
	public void enterTextCustomerDescription(String customerdescription) {
		enterCustomerDescription.sendKeys(customerdescription);
	}
	
	public void clickCreateCustomerButton() {
		createCustomerButton.click();
	}
	public String validateSuccessMessage() {
		return textSuccessMessage.getText();
	}

}
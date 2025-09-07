package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility {
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processAddress");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
	}
	
	public ShippmentPage goToShippmentPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShippmentPage(getDriver());
	}

}

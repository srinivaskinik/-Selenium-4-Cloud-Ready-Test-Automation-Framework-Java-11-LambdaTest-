package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility {
	private static final By AGREE_TO_TERMS_INPUT_CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LCOATOR = By.name("processCarrier");

	public ShippmentPage(WebDriver driver) {
		super(driver);
	}
	
	public PaymentPage proceedToPaymentPage() {
		clickOnCheckBox(AGREE_TO_TERMS_INPUT_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LCOATOR);
		return new PaymentPage(getDriver());
	}

}

package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	private static final By PAYMENT_BY_WIRE_BUTTON_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
	private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR = By.xpath("//p[contains(@class,'cart_navigation')]/button");
	private static final By ALERT_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[contains(@class,'alert-success')]");

	public PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String makePaymentByWire() {
		clickOn(PAYMENT_BY_WIRE_BUTTON_LOCATOR);
		clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
		String message = getVisibleText(ALERT_SUCCESS_MESSAGE_LOCATOR);
		return message;
	}

}

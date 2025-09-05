package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	public HomePage(Browser chrome, boolean isHeadless) {
		super(chrome, isHeadless);
		//goToWebsite(readProperty(DEV, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
		
	}
	
	public HomePage(WebDriver driver) {
		super(driver); //to call the parent class constructor from the child constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
		
	}


	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public LoginPage goToLoginPage() { //page Functions ---->
		logger.info("Trying to perform click to go to sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quit() {
		getDriver().quit();
	}

}

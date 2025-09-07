package com.ui.tests;

import static com.constants.Size.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;
	@BeforeMethod(description = "User logs in to the application and searches for a product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("giloyo6624@mogash.com", "password")
		.searchForAProduct(SEARCH_TERM);
		
		
	}
	
	@Test(description = "Verify if the logged in user s able to buy a dress", groups ={"e2e","smoke","sanity"})
	public void checkOutTest() {
		String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(M).clickAddToCartButton().proceedToCheckout()
		.goToConfirmAddressPage().goToShippmentPage().proceedToPaymentPage().makePaymentByWire();
		Assert.assertEquals(result, "complete");
	}

}

package com.ui.tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	
	@BeforeMethod(description = "valid first time user logs into the application")
	public void setup() {
		myAccountPage= homePage.goToLoginPage().doLoginWith("giloyo6624@mogash.com", "password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress() {
		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}

}

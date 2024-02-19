package com.stepdefinition;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends Baseclass{

	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String exploginsuccessmsg) {

		WebElement loingmsg = pom.getSearchHotelPage().getTxtloginmsg();
		String getattribute = getattribute(loingmsg);
		System.out.println(getattribute);
		Assert.assertEquals("Verify after login success msg", exploginsuccessmsg, getattribute);

	}
	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String expSearchSuccessMsg) throws InterruptedException {

		WebElement searchmsg = pom.getSelectHotelPage().getTextSelectHotelMsg();
	
		String text = getText(searchmsg);
		boolean contains = text.contains(expSearchSuccessMsg);
		System.out.println(contains);
		Assert.assertTrue("verify after search success msg", contains);
		
	}

	@Then("User should verify after select hotel success message {string}")
	public void user_should_verify_after_select_hotel_success_message(String expSelectHotelSuccessMsg) {

		WebElement txtBookHotelMsg = pom.getBookHotelPage().getTxtBookHotelMsg();
		
		String text1 = getText(txtBookHotelMsg);
		boolean contains1 = text1.contains(expSelectHotelSuccessMsg);
		System.out.println(contains1);
		Assert.assertTrue("verify after search success msg",contains1);	
	}

	@Then("User should Verify Success Message {string}")
	public void user_should_verify_success_message(String expBookingSuccessMsg) {
		
		WebElement textBookingConfirmation = pom.getBookingHotelPage().getTextBookingConfirmation();
		String text2 = getText(textBookingConfirmation);
		boolean contains2 = text2.contains(expBookingSuccessMsg);
		System.out.println(contains2);
		Assert.assertTrue("verify after search Success Msg",contains2);
		
		/*WebElement bookingConfirmation = pom.getBookingConfirmPage().getTextBookingConfirmation();
	    String text2 = getText(bookingConfirmation);
		boolean b2 = text2.contains(expBookingSuccessMsg);
		Assert.assertTrue("verify after search success Msg", b2);*/
	    
	}

	@Then("User should verify after cancel OrderId success message {string}")
	public void user_should_verify_after_cancel_order_id_success_message(String expCancelSuccessMsg) {

		WebElement CancelError = pom.getCancelBookingPage().getTxtCancelSuccessError();
		String text3 = getText(CancelError);
		System.out.println(text3);
		Assert.assertEquals("verify after Book success Msg",expCancelSuccessMsg,text3);

	}
}

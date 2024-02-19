package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_CancelBookingStep extends Baseclass{

	PageObjectManager pom = new PageObjectManager();

	@Then("User should Cancel OrderId")
	public void user_should_cancel_order_id() {

		String orderId = pom.getBookingHotelPage().getOrderId();
		pom.getCancelBookingPage().cancelOrderId(orderId);
	}

	@Then("User should Verify after booking Success Message {string}")
	public void user_should_verify_after_booking_success_message(String expSuccessCancelMsg) {
		
		
		WebElement textBookingConfirmation = pom.getBookingHotelPage().getTextBookingConfirmation();
		String text = getText(textBookingConfirmation);
		Assert.assertEquals("verify after Book success Msg", expSuccessCancelMsg,text);

	  /* WebElement txtCancelSuccess = pom.getCancelBookingPage().getTxtCancelSuccessError();
		 String txtSuccessCancelMsg = getText(txtCancelSuccess);
		 boolean contains = txtSuccessCancelMsg.contains(expSuccessCancelMsg);
		 System.out.println(contains);
		 Assert.assertTrue("verify after cancel order Id success message", contains);
		 Assert.assertEquals("verify after cancel order Id success message",expSuccessCancelMsg,txtSuccessCancelMsg);*/

	}

	@Then("User should cancel the existing {string}")
	public void user_should_cancel_the_existing(String orderId) {

		pom.getCancelBookingPage().cancelOrderId(orderId);
	}










}

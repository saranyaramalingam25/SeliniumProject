package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;


public class TC3_SelectHotelStep extends Baseclass{


	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should select hotel name and click continue")
	public void user_should_select_hotel_name_and_click_continue() {
	   
		pom.getSelectHotelPage().SelectHotel();
		
	}

	@Then("User should not select hotel radio button and click continue")
	public void user_should_not_select_hotel_radio_button_and_click_continue() {
	  
		pom.getSelectHotelPage().clickcontinue();
	}
	
	@Then("User should verify after select hotel with an error message {string}")
	public void user_should_verify_after_select_hotel_with_an_error_message(String expErrorSelectmsg) {
		
	   WebElement txtSelectErrorMsg = pom.getSelectHotelPage().getTxtSelectErrorMsg();
	   String txtErrorselectmsg = getText(txtSelectErrorMsg);
	   boolean contains = txtErrorselectmsg.contains(expErrorSelectmsg);
	   Assert.assertTrue("verify without select hotel with an error message", contains);
	   
	}

}

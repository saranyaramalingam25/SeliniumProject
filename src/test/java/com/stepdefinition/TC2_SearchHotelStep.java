package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends Baseclass{

	PageObjectManager pom = new PageObjectManager();

	@Then("User should enter valid data and click on the search hotel page {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_enter_valid_data_and_click_on_the_search_hotel_page_and(String location, String hotels, String roomType, String roomno, 
			String checkInDate, String checkoutDate, String adultroom, String childroom) throws FileNotFoundException, IOException {

		pom.getSearchHotelPage().SearchHotels(location, hotels, roomType, roomno, checkInDate, checkoutDate, adultroom, childroom);

	}

	@Then("User should enter mandatory details and click on search hotel {string},{string},{string},{string} and {string}")
	public void user_should_enter_mandatory_details_and_click_on_search_hotel_and(String location, String roomno, String checkInDate, String checkoutDate, String adultroom) throws FileNotFoundException, IOException {

		pom.getSearchHotelPage().SearchHotelsWithmMandatoryfields(location, roomno, checkInDate, checkoutDate, adultroom);
	}

	@Then("User should verify after search hotel with invalid date error message {string} and {string}")
	public void user_should_verify_after_search_hotel_with_invalid_date_error_message_and(String expDateInMsg, String expDateOutMsg) {

		WebElement txtDateInMsg = pom.getSearchHotelPage().getTxtDateInMsg();
		String text = getText(txtDateInMsg);
		boolean contains = text.contains(expDateInMsg);
		Assert.assertTrue("verify after search hotel using invalid data error msg contains", contains);

		WebElement txtDateOutMsg = pom.getSearchHotelPage().getTxtDateOutMsg();
		String text2 = getText(txtDateOutMsg);
		boolean contains2 = text2.contains(expDateOutMsg);
		Assert.assertTrue("verify after search hotel using invalid data error msg contains", contains2);

	}

	@Then("User should search hotels without field details")
	public void user_should_search_hotels_without_field_details() {

		pom.getSearchHotelPage().SearchHotelsWithoutEnterAnyFields();
		
	}
	@Then("User should verify after search hotel with an error message {string}")
	public void user_should_verify_after_search_hotel_with_an_error_message(String string) {
		
     WebElement txtLocationMsg = pom.getSearchHotelPage().getTxtLocationMsg();
     String text3 = getText(txtLocationMsg);
     boolean contains3 = text3.contains(text3);
     Assert.assertTrue(contains3);
     
	}




}




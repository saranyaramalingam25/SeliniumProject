package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;


public class TC4_BookHotelStep extends Baseclass  {

	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should enter all fields {string},{string} and {string}")
	public void user_should_enter_all_fields_and(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    
		List<List<String>> card = dataTable.asLists();
		List<String> list = card.get(1);
		String ccNum = list.get(0);
		String ccType = list.get(1);
		String ccMonth = list.get(2);
		String ccYear = list.get(3);
		String cvvNum = list.get(4);
		
		WebElement ccNo = pom.getBookHotelPage().getCcNo();
		insertvaluetextbox(ccNo, ccNum);
		
		WebElement ccType2 = pom.getBookHotelPage().getCcType();
		insertvaluetextbox(ccType2, ccType);
		
		WebElement ccMonth2 = pom.getBookHotelPage().getCcMonth();
		insertvaluetextbox(ccMonth2, ccMonth);
		
		WebElement ccYear2 = pom.getBookHotelPage().getCcYear();
		insertvaluetextbox(ccYear2, ccYear);
		
		WebElement cvvNo = pom.getBookHotelPage().getCvvNo();
		insertvaluetextbox(cvvNo, cvvNum);
		
		pom.getBookHotelPage().bookHotels(firstName, lastName, address);
		
		Thread.sleep(7000);

	}

	@Then("User should click book now button without Selecting any fields")
	public void user_should_click_book_now_button_without_selecting_any_fields() {
	    
		pom.getBookHotelPage().bookHotels();
		
	}
	
	@Then("User should Verify related Error Messages {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_related_error_messages_and(String expFirstnameError, String expLastnameError, String expAddressError, String expccNumError, String expccTypeError, String expccMonthError, String expcvvError) {
	   
		WebElement txtFirstNameError = pom.getBookHotelPage().getTxtFirstNameError();
		String text = getText(txtFirstNameError);
		boolean contains = text.contains(expFirstnameError);
		Assert.assertTrue("verify after book hotel using invalid first name error msg contains", contains);
		
		WebElement txtLastNameError = pom.getBookHotelPage().getTxtLastNameError();
		String text2 = getText(txtLastNameError);
		boolean contains2 = text.contains(expLastnameError);
		System.out.println(text2); 
		Assert.assertEquals("Please Enter you Last Name", text2);
		//Assert.assertTrue("verify after book hotel using invalid last name error msg contains", contains2);
		
		WebElement txtAddressError = pom.getBookHotelPage().getTxtAddressError();
		String text3 = getText(txtAddressError);
		boolean contains3 = text3.contains(expAddressError);
		Assert.assertTrue("verify after book hotel using invalid Address Error error msg contains", contains3);
		
		WebElement txtCCNoError = pom.getBookHotelPage().getTxtCCNoError();
		String text4 = getText(txtCCNoError);
		boolean contains4 = text4.contains(expccNumError);
		Assert.assertTrue("verify after book hotel using invalid card No error msg contains", contains4);
		
		WebElement txtCCTypeError = pom.getBookHotelPage().getTxtCCTypeError();
		String text5 = getText(txtCCTypeError);
		boolean contains5 = text5.contains(expccTypeError);
		Assert.assertTrue("verify after book hotel using invalid card type error msg contains", contains5);
		
		WebElement txtCCMonthError = pom.getBookHotelPage().getTxtCCMonthError();
		String text6 = getText(txtCCMonthError);
		boolean contains6 = text6.contains(expccMonthError);
		Assert.assertTrue("verify after book hotel using invalid expiry month error msg contains", contains6);
		
		WebElement txtCVVError = pom.getBookHotelPage().getTxtCVVError();
		String text7 = getText(txtCVVError);
		boolean contains7 = text7.contains(expcvvError);
		Assert.assertTrue("verify after book hotel using invalid cvv number error msg contains", contains7);
	}

}

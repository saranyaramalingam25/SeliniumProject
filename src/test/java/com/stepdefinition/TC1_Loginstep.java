    package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.base.Baseclass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class TC1_Loginstep extends Baseclass{

	PageObjectManager pom = new PageObjectManager();


	@Given("User is on the Adactinhotel page")
	public void user_is_on_the_adactinhotel_page() throws FileNotFoundException, IOException {
		implicitwait();
		 getBrowser(getPropertyFileValue("Browser"));
		 enterurl(getPropertyFileValue("Url"));
		
	}
	@When("User should perform login {string} and {string}")
	public void user_should_perform_login_and(String username, String pass) {
		 pom.getLoginPage().login(username, pass);
	}
	
	
	@When("User should perform login {string} and {string} with Enter key")
	public void user_should_perform_login_and_with_enter_key(String userName, String password) throws AWTException {
		 pom.getLoginPage().loginWithEnterKey(userName, password);
	}
	

	@Then("User should verify after login with invalid data error message contains {string}")
	public void user_should_verify_after_login_with_invalid_data_error_message_contains(String exploginmsg) {
		WebElement textErrorlogin = pom.getLoginPage().getGetTextErrorMsg(); 
		String actloginErrorMsg = getText(textErrorlogin); 
		  boolean contains = actloginErrorMsg.contains(exploginmsg);
		  Assert.assertTrue("verify after error message contains", contains);
	}








	
	/*
	 * @Given("User is on the Adactinhotel page") public void
	 * user_is_on_the_adactinhotel_page() throws FileNotFoundException, IOException{
	 * 
	 * getBrowser(getPropertyFileValue("Browser"));
	 * enterurl(getPropertyFileValue("Url"));
	 * 
	 * }
	 * 
	 * @When("User should perform login {string} and {string}") public void
	 * user_should_perform_login_and(String username, String pass) {
	 * 
	 * pom.getLoginPage().login(username, pass); }
	 * 
	 * @When("User should perform login {string} and {string} with Enter key")
	 * public void user_should_perform_login_and_with_enter_key(String userName,
	 * String password) throws AWTException {
	 * 
	 * pom.getLoginPage().loginWithEnterKey(userName, password); }
	 * 
	 * 
	 * @Then("User should verify after login with invalid data error message contains {string}"
	 * ) public void
	 * user_should_verify_after_login_with_invalid_data_error_message_contains(
	 * String exploginmsg) {
	 * 
	 * WebElement textErrorlogin = pom.getLoginPage().getGetTextErrorMsg(); String
	 * actloginErrorMsg = getText(textErrorlogin); boolean contains =
	 * actloginErrorMsg.contains(exploginmsg);
	 * Assert.assertTrue("verify after error message contains", contains); }
	 */

}

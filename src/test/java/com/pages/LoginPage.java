package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.Baseclass;

public class LoginPage extends Baseclass{

	public  LoginPage(){ //constructor method

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id ="login")
	private WebElement btnLogin;

	@FindBy(className="auth_error")
	private WebElement getTextErrorMsg;

	public WebElement getGetTextErrorMsg() {
		return getTextErrorMsg;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}

	//common step
	public void loginCommonStep(String userName, String password){

		insertvaluetextbox(getUserName(), userName);
		insertvaluetextbox(getPassword(), password);

	}
	//1.valid
	public void login(String userName, String password) {
		
		loginCommonStep(userName, password);
		elementclick(getBtnLogin());
	}
	//2.verify login Fun with Enterkey
	public void loginWithEnterKey(String userName, String password) throws AWTException {

		loginCommonStep(userName,password);
		//enterkey();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	//3.verify with Invalid credentials
	public void invalid(String userName, String password) {

		loginCommonStep(userName,password);
		elementclick(getBtnLogin());

	}
}

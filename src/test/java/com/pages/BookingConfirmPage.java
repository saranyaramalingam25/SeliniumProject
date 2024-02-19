package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class BookingConfirmPage extends Baseclass{
	
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "order_no")
	private WebElement txtOrderNo;
	
	@FindBy (xpath ="//td[@class='login_title']")
	private WebElement textBookingConfirmation;
	

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

	public WebElement getTextBookingConfirmation() {
		return textBookingConfirmation;
	}

//	Get the Order id and return it
	public String getOrderId()
	{
		implicitwait();	
		String getattribute = getattribute(getTxtOrderNo(), "value");
		return getattribute;
	}

}

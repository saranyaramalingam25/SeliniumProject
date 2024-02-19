package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class CancelBookingPage extends Baseclass{

	//1. Booked Itenary
	//2. Insert value into search orderId
	//3. Go
	//4. Cancel
	//5. Alert
	public CancelBookingPage() {
		PageFactory.initElements(driver,this); 
	}
	@FindBy (xpath="//a[text()='Booked Itinerary']")
	private WebElement BookItinary;		

	@FindBy (id="order_id_text")
	private WebElement OrderIdBox;

	@FindBy (id="search_hotel_id")
	private WebElement bTnGo;

	@FindBy (xpath="(//input[@type='button'])[1]")
	private WebElement bTnCancelOrder;

	@FindBy (id = "search_result_error")
	private WebElement txtCancelSuccessError;

	public WebElement getBookItinary() {
		return BookItinary;
	}

	public WebElement getOrderIdBox() {
		return OrderIdBox;
	}

	public WebElement getbTnGo() {
		return bTnGo;
	}

	public WebElement getbTnCancelOrder() {
		return bTnCancelOrder;
	}

	public WebElement getTxtCancelSuccessError() {
		return txtCancelSuccessError;
	}


	//1.Cancel existing orderId
	public void cancelOrderId(String orderId) 
	{
		
		elementclick(getBookItinary());
		insertvaluetextbox(getOrderIdBox(), orderId);
		elementclick(getbTnGo());
		elementclick(getbTnCancelOrder());
		OkInAlert();
	
	}


}

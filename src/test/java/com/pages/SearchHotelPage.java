package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchHotelPage extends Baseclass {

	public SearchHotelPage() {  //constructor method

		PageFactory.initElements(driver, this);
	}

	@FindBy(id="location")
	private WebElement location;

	@FindBy(id="hotels")
	private WebElement Hotels;

	@FindBy(id="room_type")
	private WebElement RoomType;

	@FindBy(id="room_nos")
	private  WebElement RoomNo;

	@FindBy(id="datepick_in")
	private WebElement txtcheckindate;

	@FindBy(id="datepick_out")
	private WebElement txtcheckinout;

	@FindBy(id="adult_room")
	private WebElement AdultperRoom;

	@FindBy(id="child_room")
	private WebElement ChildperRoom;

	@FindBy(id="Submit")
	private WebElement btnsearch;

	@FindBy(id="location_span")
	private WebElement txtLocationMsg;

	@FindBy(id="checkin_span")
	private WebElement txtDateInMsg;

	@FindBy(id="checkout_span")
	private WebElement txtDateOutMsg;
	
	/*@FindBy(className="input_show")
	private WebElement txtwelcomemsg;//it will show the username 
	
	/*@FindBy(xpath="//td[text()='Search Hotel ']")
	private WebElement txtloginmsg;*/
	
	@FindBy(id="username_show")
	private WebElement txtloginmsg;
	
	public WebElement getTxtloginmsg() {
		return txtloginmsg;
	}

	public WebElement getLocation() {
		return location;
	}

	/*public WebElement getTxtwelcomemsg() {
		return txtwelcomemsg;
	}*/

	public WebElement getHotels() {
		return Hotels;
	}

	public WebElement getRoomType() {
		return RoomType;
	}

	public WebElement getRoomNo() {
		return RoomNo;
	}

	public WebElement getTxtcheckindate() {
		return txtcheckindate;
	}

	public WebElement getTxtcheckinout() {
		return txtcheckinout;
	}

	public WebElement getAdultperRoom() {
		return AdultperRoom;
	}

	public WebElement getChildperRoom() {
		return ChildperRoom;
	}

	public WebElement getBtnsearch() {
		return btnsearch;
	}

	public WebElement getTxtLocationMsg() {
		return txtLocationMsg;
	}

	public WebElement getTxtDateInMsg() {
		return txtDateInMsg;
	}

	public WebElement getTxtDateOutMsg() {
		return txtDateOutMsg;
	}

	//commonstep
	public void searchHotelsCommonStep(String location, String roomno, String checkInDate, 
			String checkoutDate, String adultroom) throws FileNotFoundException, IOException {
	
		selectOptionByText(getLocation(), location);
		selectOptionByText(getRoomNo(), roomno);
		clearText(getTxtcheckindate());
		insertvaluetextbox(getTxtcheckindate(), checkInDate);
		clearText(getTxtcheckinout());
		insertvaluetextbox(getTxtcheckinout(), checkoutDate);
		selectOptionByText(getAdultperRoom(), adultroom);
       
	}

	//clickbutton
	public void searchButtonCommonStep() {	
		
	  elementclick(getBtnsearch());
	}

	//1.Select All fields
	public void SearchHotels(String location, String hotels, String roomType,  String roomno, 
			String checkInDate, String checkoutDate, String adultroom, String childroom) throws FileNotFoundException, IOException {
       
		
		searchHotelsCommonStep(location, roomno,checkInDate,checkoutDate,adultroom);
		selectOptionByText(getHotels(), hotels);
		selectOptionByText(getRoomType(), roomType);
		selectOptionByText(getChildperRoom(), childroom);
		searchButtonCommonStep();
		
	}

	//2.Enter Only mandatory fields
	public void SearchHotelsWithmMandatoryfields(String location,String roomno, String checkInDate, 
			String checkoutDate, String adultroom) throws FileNotFoundException, IOException {

		searchHotelsCommonStep(location, roomno,checkInDate,checkoutDate,adultroom);                                                                                                           
		searchButtonCommonStep();
	}

	//3.Date Checking
	public void SearchHotelWithInvalidDate(String location,String hotels, String roomType, String roomno, 
			String checkInDate, String checkoutDate, String adultroom,String childroom) throws FileNotFoundException, IOException {
		
		SearchHotels(location, hotels, roomType, roomno, checkInDate, checkoutDate, adultroom, childroom);
		/*searchHotelsCommonStep(location, roomno, checkInDate, checkoutDate, adultroom);
		selectOptionByAttribute(getHotels(), hotels);
		selectOptionByAttribute(getRoomType(), roomType);		
		selectOptionByAttribute(getChildperRoom(), childroom);
		searchButtonCommonStep();*/
	}

	//4.verify mantory fields
	public void SearchHotelsWithoutEnterAnyFields() {	
		searchButtonCommonStep();
	}

}

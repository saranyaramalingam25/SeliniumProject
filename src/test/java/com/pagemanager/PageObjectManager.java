package com.pagemanager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmPage;
import com.pages.CancelBookingPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

public class PageObjectManager {
	
	//singleton 
	
	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmPage bookingconfirmHotelPage;
	private CancelBookingPage cancelBookingPage;
	
	public LoginPage getLoginPage() {
		return (loginPage==null)?loginPage = new LoginPage():loginPage;
	}
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null)?searchHotelPage =new SearchHotelPage():searchHotelPage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null)?selectHotelPage = new SelectHotelPage():selectHotelPage;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null)?bookHotelPage = new BookHotelPage():bookHotelPage;
	}
	public BookingConfirmPage getBookingHotelPage() {
		return (bookingconfirmHotelPage == null)?bookingconfirmHotelPage = new BookingConfirmPage():bookingconfirmHotelPage;
	}
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage == null)?cancelBookingPage = new CancelBookingPage():cancelBookingPage;
	}
	
}

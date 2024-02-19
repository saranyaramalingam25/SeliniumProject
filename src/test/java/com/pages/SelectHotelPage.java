package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectHotelPage extends Baseclass{
    
public SelectHotelPage(){ //constructor method
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[@class='login_title']")
	private WebElement textSelectHotelMsg;
	
	@FindBy(id ="radiobutton_0")
	private WebElement radiobtn;
	
	@FindBy(id ="continue")
	private WebElement continuebtn;
	
	@FindBy(id="radiobutton_span")
	private WebElement txtSelectErrorMsg;
	
	public WebElement getTextSelectHotelMsg() {
		return textSelectHotelMsg;
	}
	public WebElement getRadiobtn() {
		return radiobtn;
	}
	public WebElement getContinuebtn() {
		return continuebtn;
	}
	public WebElement getTxtSelectErrorMsg() {
		return txtSelectErrorMsg;
	}
	
	// 1.Common step
	public void SelectHotelCommonStep() {
		
		elementclick(getContinuebtn());
	}
	// 1.With select a Hotel name and click continue
	public void SelectHotel() {
		
		elementclick(getRadiobtn());
		SelectHotelCommonStep();
	}	
	//2.Without Select Hotel click continue
	public void clickcontinue() {
		
		SelectHotelCommonStep();
	}
	
}

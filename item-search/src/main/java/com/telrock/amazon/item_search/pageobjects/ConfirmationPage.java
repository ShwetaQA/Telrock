package com.telrock.amazon.item_search.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ConfirmationPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//h1[@class='a-size-medium a-text-bold']")
    WebElement addedToBasket;
	
	
	public ConfirmationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public String getAddedToBasketMsg(){
		return addedToBasket.getText();
	} 
	
}

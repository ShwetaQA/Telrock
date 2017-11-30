package com.telrock.amazon.item_search.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookDetailsPage {
	
WebDriver driver;
	
@FindBy(xpath="//*[@id='productTitle']")
WebElement bookTitle;

@FindBy(xpath="//*[@id='add-to-cart-button']")
WebElement addToBasket;
	
	
	public BookDetailsPage(WebDriver driver){
        this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	public String getBookTitle(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(bookTitle));
		return this.bookTitle.getText();
	}
	
		public void addToCart(){
			addToBasket.click();
		}

}

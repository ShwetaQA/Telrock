package com.telrock.amazon.item_search.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(how=How.ID, using = "searchDropdownBox")
	public WebElement catalog;
	
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	public WebElement searchBox;
		
	
	
	public HomePage(WebDriver driver){
        this.driver = driver; 
        PageFactory.initElements(driver, this);
	}
	
	public void searchBook(String book){
		Select dropdown = new Select(catalog);
		dropdown.selectByVisibleText("Books");
		searchBox.sendKeys(book);
		searchBox.submit();
	}
	
}

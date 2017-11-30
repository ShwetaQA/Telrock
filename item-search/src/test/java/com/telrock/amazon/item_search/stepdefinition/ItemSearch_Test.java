package com.telrock.amazon.item_search.stepdefinition;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import com.telrock.amazon.item_search.pageobjects.ConfirmationPage;
import com.telrock.amazon.item_search.pageobjects.BookDetailsPage;
import com.telrock.amazon.item_search.pageobjects.HomePage;
import com.telrock.amazon.item_search.pageobjects.SearchResultPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class ItemSearch_Test {
	SoftAssert softAssert = new SoftAssert();

	WebDriver driver;
	HomePage homePage;
	SearchResultPage searchResultPage;
	BookDetailsPage bookDetailsPage;
	ConfirmationPage confirmationPage;
	
	@Before
	public void browserSetUp() {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "//BrowserDrivers//geckodriver");
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("marionette", true);
		driver = new FirefoxDriver(cap);
		
	}

	@Test
	@Given("^I am on the amazon website$")
	public void i_am_on_the_amazon_website() throws Throwable {
		driver.get("https://www.amazon.co.uk");
	}

	@Test
	@When("^I search for \"([^\"]*)\" book$")
	public void i_search_for_book(String book) throws Throwable {
		homePage = new HomePage(driver);
		homePage.searchBook(book);

	}

	@Test
	@And("^I verify book title as \"([^\"]*)\"$")
	public void i_verify(String title) throws Throwable {
		searchResultPage = new SearchResultPage(driver);
		softAssert.assertEquals(title, searchResultPage.getBookTitle());
	}
	
	@Test
	@Then("^I navigate to the book details page$")
	public void i_navigate_to_the_book_details_page() throws Throwable {
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.viewBookDetails();
	}

	@Test
	@And("^I verify again book title as \"([^\"]*)\"$")
	public void i_verify_again(String title) throws Throwable {
		bookDetailsPage = new BookDetailsPage(driver);
		
		softAssert.assertEquals(title, bookDetailsPage.getBookTitle());
	}

	@Test
	@And("^I Add the book to basket$")
	public void i_add_the_book_to_basket() throws Throwable {
		bookDetailsPage.addToCart();
	}

	@Test
	@And("^I verify item status as \"([^\"]*)\"$")
	public void i_verify_basket_notification(String status) throws Throwable {
		confirmationPage = new ConfirmationPage(driver);
		softAssert.assertEquals(status, confirmationPage.getAddedToBasketMsg());
		
	}


	@After
	public void endTest() {
		softAssert.assertAll();
		//driver.close();
	}
}

#Author: shwetaanand86@gmail.com

Feature: To Add and Edit a book in the basket
	
Scenario Outline: To Add and Edit a book in the basket
Given I am on the amazon website	
When I search for "<Book>" book
And I verify book title as "<Title>" 
Then I navigate to the book details page
And I verify again book title as "<Title>"
And I Add the book to basket
And I verify item status as "<Status>" 

Examples:
    |Book             |Title                                           		|Status         |
    |Game of Thrones  |A Game of Thrones (A Song of Ice and Fire, Book 1)	    |Added to Basket|

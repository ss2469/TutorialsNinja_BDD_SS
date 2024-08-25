package com.tutorialsninja.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.driverFactory.DriverFactory_Code;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {

	public WebDriver driver;
	public HomePage homepage;
	public ProductPage productpage;

	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = DriverFactory_Code.getDriver();
	}

	@When("User enters valid product {string}")
	public void user_enters_valid_product(String validProductText) {
		homepage = new HomePage(driver);
		productpage = homepage.navigateToProductPage(validProductText);
	}

	@When("User enters invalid product {string}")
	public void user_enters_invalid_product(String invalidProductText) {
		homepage = new HomePage(driver);
		productpage = new ProductPage(driver);
		homepage.enterProductName(invalidProductText);
		homepage.clickOnSearchButton();
	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSearchButton();
	}

	@Then("User gets valid product info display in search page")
	public void user_gets_valid_product_info_display_in_search_page() {
		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.verifyValidProductPresence());
	}

	@Then("User gets warning message no product found")
	public void user_gets_warning_message_no_product_found() {
		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.verifyInvalidProductWarningMessageDisplay());
	}
}

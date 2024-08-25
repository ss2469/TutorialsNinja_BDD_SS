package com.tutorialsninja.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.driverFactory.DriverFactory_Code;
import com.tutorialsninja.pages.AddToCartPage;
import com.tutorialsninja.pages.CheckoutPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {

	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;
	public AddToCartPage addtocartpage;
	public ProductPage productpage;
	public CheckoutPage checkoutpage;

	@Given("I am on the product page for {string}")
	public void i_am_on_the_product_page(String productText) {
		driver = DriverFactory_Code.getDriver();
		homepage = new HomePage(driver);
		homepage.navigateToProductPage(productText);
		searchpage = new SearchPage(driver);
		searchpage.clickOnProductImage();

	}

	@When("I click on the Add to Cart button")
	public void i_click_on_the_add_to_cart_button() {
		productpage = new ProductPage(driver);
		productpage.clickOnAddToCartButton();
	}

	@And("I should see a message {string}")
	public void i_should_see_a_message(String productStausMessage) {
		addtocartpage = new AddToCartPage(driver);
		Assert.assertTrue(addtocartpage.actualProductStausMessage().contains(productStausMessage));
	}

	@And("The cart icon should display the number {string}")
	public void the_cart_icon_should_display_the_number(String numberOfItemsAddedInCart) {
		addtocartpage = new AddToCartPage(driver);
		Assert.assertTrue(addtocartpage.textDispalyedOnCartButton().contains(numberOfItemsAddedInCart));
	}

	@And("I have added {string} to my cart")
	public void i_have_added_product_in_the_shopping_cart(String validProductText) {
		productpage = new ProductPage(driver);
		productpage.clickOnAddToCartButton();
	}

	@When("I navigates to the Shopping Cart")
	public void i_navigates_to_the_shopping_cart() throws Exception {
		checkoutpage = new CheckoutPage(driver);
		checkoutpage.clickOnShoppingCartLink();
	}

	@When("I remove {string} from the cart")
	public void i_remove_product_from_the_cart(String validProductText) {
		addtocartpage = new AddToCartPage(driver);
		addtocartpage.clickOnRemoveButton();
	}

	@Then("The cart should be empty")
	public void the_cart_should_be_empty() {
		addtocartpage = new AddToCartPage(driver);
		Assert.assertTrue(addtocartpage.emptyShoppingCartMessageDisplayStatus());
	}

}

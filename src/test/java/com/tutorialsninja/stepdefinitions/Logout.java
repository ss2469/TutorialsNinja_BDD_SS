package com.tutorialsninja.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.driverFactory.DriverFactory_Code;
import com.tutorialsninja.pages.AccountLogoutPage;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout {

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public AccountLogoutPage logoutpage;
	public SearchPage searchpage;

	@Given("I am logged into my account with valid email {string} and password {string}")
	public void i_am_logged_into_my_account_with_valid_email_and_password(String emailText, String passwordText) {
		driver = DriverFactory_Code.getDriver();
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage = homepage.navigateToHomePage();
		loginpage.enterEmail(emailText);
		loginpage.enterPassword(passwordText);
		accountpage = new AccountPage(driver);
		accountpage = loginpage.clickOnLoginButton();
		Assert.assertTrue(accountpage.editAccountInfoLinkDisplayStatus());
	}

	@And("I am on the Product page for {string}")
	public void i_am_on_the_product_page(String productText) {
		searchpage = new SearchPage(driver);
		homepage.navigateToProductPage(productText);
		searchpage.clickOnProductImage();
	}

	@When("I click on the Logout option present under My Account link")
	public void i_click_on_the_logout_option_present_under_my_account_link() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropdown();
		Assert.assertTrue(homepage.isLogoutOptionDisplayed());
		homepage.selectLogoutOption();
	}

	@Then("I should be redirected to the account logout page")
	public void i_should_be_redirected_to_the_account_logout_page() {
		logoutpage = new AccountLogoutPage(driver);
		logoutpage.validateAccountLogout();
	}

	@And("I should see a logout message {string}")
	public void i_should_see_a_logout_message(String logoutMessageText) {
		logoutpage = new AccountLogoutPage(driver);
		Assert.assertTrue(logoutpage.actualLogoutMessageText().contains(logoutMessageText));
	}

	@And("I should not have access to the account dashboard")
	public void i_should_not_have_access_to_the_account_dashboard() {
		logoutpage = new AccountLogoutPage(driver);
		logoutpage.clickOnAccountLink();
		// Account link on logout page should redirect to Login/Register
		loginpage = new LoginPage(driver);
		loginpage.returningCustomerHeadingDisplayStatus();
	}

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		driver = DriverFactory_Code.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnHomepageIcon();
	}

	@When("I navigates to My Account link")
	public void i_look_for_the_logout_option() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropdown();
	}

	@And("I should not see the Logout option displayed")
	public void i_should_not_see_the_logout_option_displayed() {
		homepage = new HomePage(driver);
		Assert.assertFalse(homepage.isLogoutOptionDisplayed(), "Logout option should not be displayed");
	}

	@And("I should see the Login option instead")
	public void i_should_see_the_login_option_instead() {
		Assert.assertTrue(homepage.isLoginOptionDisplayed(), "Login option should be displayed");
	}

}

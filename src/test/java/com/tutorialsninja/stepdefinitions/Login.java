package com.tutorialsninja.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.driverFactory.DriverFactory_Code;
import com.tutorialsninja.pages.AccountPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.utilities.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	public WebDriver driver;
	public LoginPage loginpage;
	public AccountPage accountpage;
	

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory_Code.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.navigateToHomePage();
	}

	@When("^User enters valid email (.+)$")
	public void user_enters_valid_email(String emailText) {
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(emailText);
	}

	@And("^User enters valid password (.+)$")
	public void user_enters_valid_password(String passwordText) {
		loginpage = new LoginPage(driver);
		loginpage.enterPassword(passwordText);
	}

	@When("User enters invalid email")
	public void user_enters_invalid_email() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(Util.emailWithDateTimeStamp());
	}

	@Then("User gets warning message about credentials mismatch")
	public void user_gets_warning_message_about_credentials_mismatch() {

		loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.retreiveLoginWarningMessageText()
				.contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@And("User enters invalid password {string}")
	public void user_enters_invalid_password(String invalidPasswordText) {
		loginpage = new LoginPage(driver);
		loginpage.enterPassword(invalidPasswordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginButton();
	}

	@Then("User is redirected to Account Page")
	public void user_is_redirected_to_account_page() {
		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.editAccountInfoLinkDisplayStatus());
	}

}

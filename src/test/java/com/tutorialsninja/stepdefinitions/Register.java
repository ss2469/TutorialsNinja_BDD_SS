package com.tutorialsninja.stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialsninja.driverFactory.DriverFactory_Code;
import com.tutorialsninja.pages.AccountSuccessPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.utilities.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {

	public WebDriver driver;
	public RegisterPage registerpage;

	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		driver = DriverFactory_Code.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.navigateToRegisterPage();
	}

	@When("User enters below mandatory fields")
	public void user_enters_below_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("firstname"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
	}

	@When("User enters below all fields")
	public void user_enters_below_all_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("firstname"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
	}

	@When("User enters below all fields with existing email")
	public void user_enters_below_all_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("firstname"));
		registerpage.enterEmail(dataMap.get("email"));
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.selectNewsLetterRadioButton();
	}

	@When("User selects Privacy Policy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.selectPrivacyPolicyCheckBox();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.clickContinueButton();
	}

	@Then("User account gets created successfully")
	public void user_account_gets_created_successfully() {
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.validateAccountSuccessCreatedMessage());

	}

	@Then("User gets warning message of duplicate email")
	public void user_gets_warning_message_of_duplicate_email() {
		RegisterPage registerpage = new RegisterPage(driver);
		Assert.assertTrue(registerpage.retrieveDuplicateEmailWarningText()
				.contains("Warning: E-Mail Address is already registered!"));
	}

	@Then("User gets warning message for every mandatory field")
	public void user_gets_warning_message_for_every_mandatory_field() {
		RegisterPage registerpage = new RegisterPage(driver);
		Assert.assertTrue(registerpage.retrieveAllWarningMessages("Warning: You must agree to the Privacy Policy!",
				"First Name must be between 1 and 32 characters!", "Last Name must be between 1 and 32 characters!",
				"E-Mail Address does not appear to be valid!", "Telephone must be between 3 and 32 characters!",
				"Password must be between 4 and 20 characters!"));
	}
}

package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstnameTextBox;

	@FindBy(id = "input-lastname")
	private WebElement lastnameTextBox;

	@FindBy(id = "input-email")
	private WebElement emailTextBox;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement newsletterRadioYesButton;

	@FindBy(xpath = "//input[@name = 'agree' and @value = '1']")
	private WebElement privacyPolicyCheckbox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;

	@FindBy(css = "input#input-firstname+div")
	private WebElement firstnameWarningMessage;

	@FindBy(css = "input#input-lastname+div")
	private WebElement lastnameWarningMessage;

	@FindBy(css = "input#input-email+div")
	private WebElement emailWarningMessage;

	@FindBy(css = "input#input-telephone+div")
	private WebElement telephoneWarningMessage;

	@FindBy(css = "input#input-password+div")
	private WebElement passwordWarningMessage;

	@FindBy(css = "input#input-confirm + div")
	private WebElement wrongConfirmPasswordWarningMessage;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstNameText) {
		firstnameTextBox.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastnameTextBox.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
	}

	public void selectNewsLetterRadioButton() {
		newsletterRadioYesButton.click();
	}

	public void selectPrivacyPolicyCheckBox() {
		privacyPolicyCheckbox.click();
	}

	public void clickContinueButton() {
		continueButton.click();
	}

	public String retrieveDuplicateEmailWarningText() {
		String dEmailMessage = duplicateEmailWarningMessage.getText();
		return dEmailMessage;
	}

	public boolean retrieveAllWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning,
			String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning,
			String expectedPasswordWarning) {

		boolean privacyPolicyWarningStatus = privacyPolicyWarningMessage.getText()
				.contains(expectedPrivacyPolicyWarning);
		boolean firstNameWaningStatus = firstnameWarningMessage.getText().contains(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastnameWarningMessage.getText().contains(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarningMessage.getText().contains(expectedEmailWarning);
		boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarningMessage.getText().contains(expectedPasswordWarning);

		return privacyPolicyWarningStatus && firstNameWaningStatus && lastNameWarningStatus && emailWarningStatus
				&& telephoneWarningStatus && passwordWarningStatus;
	}

}

package com.tutorialsninja.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;

	@FindBy(xpath = "//li[@class = 'dropdown open']/ul/li/a[text() = 'Login']")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchTextbox;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	@FindBy(xpath = "//li[@class = 'dropdown open']/ul/li/a[text() = 'Logout']")
	private WebElement logoutOption;

	@FindBy(linkText = "Qafox.com")
	private WebElement homepageIcon;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnMyAccountDropdown() {
		myAccountDropdown.click();
	}

	public void selectLoginOption() {
		loginOption.click();
	}

	public void selectRegisterOption() {
		registerOption.click();
	}

	public LoginPage navigateToHomePage() {
		myAccountDropdown.click();
		loginOption.click();
		return new LoginPage(driver);
	}

	public RegisterPage navigateToRegisterPage() {
		myAccountDropdown.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

	public void enterProductName(String validProductText) {
		searchTextbox.sendKeys(validProductText);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public ProductPage navigateToProductPage(String validProductText) {
		searchTextbox.click();
		searchTextbox.clear();
		searchTextbox.sendKeys(validProductText);
		searchButton.click();
		return new ProductPage(driver);
	}

	public boolean isLoginOptionDisplayed() {
		return loginOption.isDisplayed();

	}

	public boolean isLogoutOptionDisplayed() {
		try {
			return logoutOption.isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}

	}

	public void selectLogoutOption() {
		logoutOption.click();
	}

	public void clickOnHomepageIcon() {
		homepageIcon.click();
	}

}

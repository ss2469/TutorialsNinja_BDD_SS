package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogoutPage {

	public WebDriver driver;

	@FindBy(xpath = "//div[@id='content']/h1[contains(text(), 'Account Logout')]")
	private WebElement accountLogoutHeading;

	@FindBy(xpath = "//div[@id = 'content']/p[1]")
	private WebElement accountLogoutMessage;

	@FindBy(xpath = "//ul[@class = 'breadcrumb']/li/a[text() = 'Account']")
	private WebElement accountLink;

	public AccountLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateAccountLogout() {
		return accountLogoutHeading.isDisplayed();
	}

	public String actualLogoutMessageText() {
		return accountLogoutMessage.getText();
	}

	public void clickOnAccountLink() {
		accountLink.click();
	}
}

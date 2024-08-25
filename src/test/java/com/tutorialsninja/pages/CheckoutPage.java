package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@title = 'Shopping Cart']")
	private WebElement shoppingcartLink;

	public CheckoutPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnShoppingCartLink() {
		shoppingcartLink.click();
	}

}

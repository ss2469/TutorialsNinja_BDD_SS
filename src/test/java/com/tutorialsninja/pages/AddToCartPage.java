package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	public WebDriver driver;

	@FindBy(xpath = "//h2[text() = '$122.00']")
	private WebElement priceOfLaptop;

	@FindBy(id = "cart")
	private WebElement cartButton;

	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement cartButtonDisplayText;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement productStatusMessage;

	@FindBy(css = ".input-group-btn>.btn.btn-danger")
	private WebElement removeProductFromCartButton;

	@FindBy(xpath = "//div[@id = 'content']/p[contains(text(), 'cart is empty')]")
	private WebElement emptyShoppingCartMessage;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean displayStatusOfHPLaptopPrice() {
		boolean display = priceOfLaptop.isDisplayed();
		return display;
	}

	public String textDispalyedOnCartButton() {
		String display = cartButtonDisplayText.getText();
		return display;
	}

	public void clickOnCartButton() {
		cartButton.click();
	}

	public String actualProductStausMessage() {
		String display = productStatusMessage.getText();
		return display;
	}

	public int actualCountOfItemsAddedInCart() {
		String display = productStatusMessage.getText();
		int itemCount = Integer.parseInt(display);

		return itemCount;
	}

	public void clickOnRemoveButton() {
		removeProductFromCartButton.click();
	}

	public boolean emptyShoppingCartMessageDisplayStatus() {
		boolean display = emptyShoppingCartMessage.isDisplayed();
		return display;
	}

}

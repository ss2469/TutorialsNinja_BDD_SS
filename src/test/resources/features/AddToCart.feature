@TutorialsNinjaAddToCart
Feature: Add to Cart Functionality of TutorialsNinja Application

 @AddingProductInStock
  Scenario: Successfully adding a product to the cart
    Given I am on the product page for "HP"
    When I click on the Add to Cart button
    Then I should see a message "Success: You have added"
    And The cart icon should display the number "1"

	@AddingOutOfStockProduct
  Scenario: Adding an out-of-stock product to the cart
    Given I am on the product page for "Macbook Pro"
    And I have added "Macbook Pro" to my cart
    When I navigates to the Shopping Cart
    Then I should see a message "Products marked with *** are not available"
    
  @AddingMultipleProduct
  Scenario: Adding multiple products to the cart
    Given I am on the product page for "HP"
    When I click on the Add to Cart button
    And I am on the product page for "Macbook Pro"
    When I click on the Add to Cart button
    Then The cart icon should display the number "2"  

  @RemovingProduct
  Scenario: Removing a product from the cart
    Given I am on the product page for "Macbook Pro"
    And I have added "Macbook Pro" to my cart
    And I navigates to the Shopping Cart
    When I remove "Macbook Pro" from the cart
    Then The cart should be empty
    
    
@TutorialsNinjaLogout
Feature: Logout Functionality of TutorialsNinja Application

 @LogoutSuccessfully
  Scenario: Successfully logging out of the account
    Given I am logged into my account with valid email "seleniumsharma@gmail.com" and password "Selenium@123456"
    When I click on the Logout option present under My Account link
    Then I should be redirected to the account logout page
    And I should not see the Logout option displayed
    
 @LogoutFromAnyPage
  Scenario: Logout from any page
    Given I am logged into my account with valid email "seleniumsharma@gmail.com" and password "Selenium@123456"
    And I am on the Product page for "HP"
    When I click on the Logout option present under My Account link
    Then I should be redirected to the account logout page
    And I should see a logout message "You have been logged off your account"
    And I should not have access to the account dashboard  
     
 @SeeingAccoutWhenNotLoggedIn
  Scenario: Attempting to see account options when not logged in
    Given I am on the homepage 
    When I navigates to My Account link
    Then I should not see the Logout option displayed
    And I should see the Login option instead
  

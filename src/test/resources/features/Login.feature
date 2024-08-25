@TutorialsNinjaLogin
Feature: Login Functionality of TutorialsNinja Application

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters valid email <email>
    And User enters valid password <password>
    And User clicks on Login button
    Then User is redirected to Account Page
    Examples:
    |email										|password		    |
    |seleniumsharma1@gmail.com	|Selenium@123|
    |seleniumsharma2@gmail.com	|Selenium@123|
    |seleniumsharma3@gmail.com	|Selenium@123|
    |seleniumsharma4@gmail.com	|Selenium@123|
    |seleniumsharma5@gmail.com	|Selenium@123|
    |seleniumsharma6@gmail.com	|Selenium@123|
    |seleniumsharma7@gmail.com	|Selenium@123|
   

  @InvalidCredentials
  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters invalid email
    And User enters valid password "Selenium@1234"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch


  @ValidEmailInvalidPassword
  Scenario: Login With Valid Email Invalid Password
    Given User navigates to login page
    When User enters valid email "seleniumsharma@gmail.com"
    And User enters invalid password "Selenium@1234"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @InvalidEmailValidPassword
  Scenario: Login With invalid Email Valid Password
    Given User navigates to login page
    When User enters invalid email
    And User enters valid password "Selenium@123456"
    And User clicks on Login button
    Then User gets warning message about credentials mismatch

  @NoCredentials
  Scenario: Login Without credentials
    Given User navigates to login page
    And User clicks on Login button
    Then User gets warning message about credentials mismatch
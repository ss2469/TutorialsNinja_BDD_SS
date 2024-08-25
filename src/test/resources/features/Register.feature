 @TutorialsNinjaRegistration
Feature: Register Functionality of TutorialsNinja Application

  @MandatoryFields
  Scenario: Register With Mandatory Fields
    Given User navigates to Register page
    When User enters below mandatory fields
      | firstname       | Selenium        |
      | lastname        | Sharma          |
      | telephone       | 9876543210      |
      | password        | Selenium@123456 |
      | confirmpassword | Selenium@123456 |
    And User selects Privacy Policy checkbox
    And User clicks on Continue button
    Then User account gets created successfully

  @AllFields
  Scenario: Register With All Fields
    Given User navigates to Register page
    When User enters below all fields
      | firstname       | Selenium        |
      | lastname        | Sharma          |
      | telephone       | 9876543210      |
      | password        | Selenium@123456 |
      | confirmpassword | Selenium@123456 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy checkbox
    And User clicks on Continue button
    Then User account gets created successfully

  @DuplicateEmail
  Scenario: Register With Existing Email
    Given User navigates to Register page
    When User enters below all fields with existing email
      |firstname       |Selenium                |
      |lastname        |Sharma                  |
      |email           |seleniumsharma@gmail.com|
      |telephone       |9876543210              |
      |password        |Selenium@123456         |
      |confirmpassword |Selenium@123456         |
    And User selects Yes for Newsletter
    And User selects Privacy Policy checkbox
    And User clicks on Continue button
    Then User gets warning message of duplicate email

  @NoFields
  Scenario: Register With No Fields
    Given User navigates to Register page
    And User clicks on Continue button
    Then User gets warning message for every mandatory field
  
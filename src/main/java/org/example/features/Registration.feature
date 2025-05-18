Feature: The Register Flow test suite

  Background:
    Given The "https://www.google.com" is accessed

  Scenario: The system redirects the user to Account page after successful registration
    And Register Page is accessed from the Home Page button
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    And continueButton is clicked
    Then the new page url contains "=account/success&l" keyword

  Scenario: User remains on Register Page when continue button is clicked during the register flow
    And Register Page is accessed from Home Page menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    Then the new page url contains "route=account/register&language=en-gb" keyword

  @Regression
  Scenario: User remains on Register Page when privacy conditions are not accepted during the registration flow
    And Register Page is accessed from Home Page menu
    When the registration form is completed with valid random data
    And continueButton is clicked
    Then the new page url contains "route=account/register&language=en-gb" keyword

  Scenario Outline: Error message is displayed when registering with invalid data for register flow
    And Register Page is accessed from the Home Page button
    And the registration form is completed as following:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |
      | password  | <password>  |
    And continueButton is clicked
    And the following list of error messages is displayed:
      | Warning: You must agree to the Privacy Policy!    |
      | <errorField> must be between 1 and 12 characters! |
    Examples:
      | firstName | lastName | email  | password | errorField |
      | Ana       | Bozian   | random | random   | First Name |
      | Victor    | Rusu     | random | random   | Last Name  |
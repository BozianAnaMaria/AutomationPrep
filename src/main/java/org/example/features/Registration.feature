Feature: The Register Flow test suite

  Scenario: The system redirects the user to Account page after successful registration
    Given The Home Page is displayed
    And Register Page is accessed from the Home Page button
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    And continueButton is clicked
    Then the new page url contains "=account/success&l" keyword

  Scenario: User remains on Register Page when continue button is clicked during the register flow
    Given Home Page is accessed
    And Register Page is accessed from Home Page menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    Then the new page url contains "route=account/register&language=en-gb" keyword

  @Regression
  Scenario: User remains on Register Page when privacy conditions are not accepted during the registration flow
    Given Home Page is accessed
    And Register Page is accessed from Home Page menu
    When the registration form is completed with valid random data
    And continueButton is clicked
    Then the new page url contains "route=account/register&language=en-gb" keyword


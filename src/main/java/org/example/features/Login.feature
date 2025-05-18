Feature: Login Flow Test Suite

  @run
  Scenario Outline: An error message iss displayed when trying to log in with invalid <attribute>
    Given The "https://www.google.com" is accessed
    And the following set of credentials is entered into the login form:
      | <email>    |
      | <password> |
    When login button is clicked
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | attribute                       | email           | password       |
      | email input data (not existent) | valid@gmail.com | wrong email    |
      | password input data             | valid@gmail.com | wrong password |
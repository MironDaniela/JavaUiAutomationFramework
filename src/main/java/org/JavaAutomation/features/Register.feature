Feature: The Register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration with validate data
    Given The Home Page is displayed
    And Register page is accessed from the Home Page Buttons
    And the register form is populated with data
    And the privacy toggle bar is enabled
    When the continue Button is clicked
    Then user URL contains the following keyword "success"

@run
  Scenario: The system keeps the user on Register page when registering using valid data without accepting the privacy rules
    Given The Home Page is displayed
    And Register page is accessed from the Home Page Buttons
    And the register form is populated with data
   # And the privacy toggle bar is enabled
    When the continue Button is clicked
    Then user URL contains the following keyword "register"




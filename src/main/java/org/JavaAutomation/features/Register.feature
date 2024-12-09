Feature: The Register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration with validate data

    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register page is accessed from the Home Page Buttons
    And the register form is populated with data
    And the privacy toggle bar is enabled
    When the continue Button is clicked
    Then user URL contains the following keyword "success"

  @run
  Scenario: The system keeps the user on Register page when registering using valid data without accepting the privacy rules
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register page is accessed from the Home Page Buttons
    And the register form is populated with data
   # And the privacy toggle bar is enabled
    When the continue Button is clicked
    Then user URL contains the following keyword "register"

  @run
  Scenario Outline: Error message is displayed when registering within invalid <errorFieldName>
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register page is accessed from the Home Page Buttons
    And the register form is populated as following:
      | firstName | <firstName>      |
      | lastName  | <lastName>       |
      | email     | RANDOM@gmail.com |
      | password  | <password>       |
    And a thread sleep of 5 seconds is executed
    When the continue Button is clicked
    Then the following list of error message is displayed:
      | <errorFieldName> must be between <min> and <max> characters ! |
      | Warning:You must agree to the Privacy Policy!                 |

    Examples:
      | firstName |  | lastName                                   | password                                 | errorFieldName | min | max |
      | Random    |  | Miron                                      | 321                                      | Password       | 4   | 20  |
      | Random    |  | DD                                         | 1234567890123456783263526353563563590123 | Password       | 4   | 20  |
      | Random    |  | 864646456444444444444444444444444444444444 | 12345678901234567890123                  | Last Name      | 1   | 32  |








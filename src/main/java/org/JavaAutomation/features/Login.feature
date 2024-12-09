Feature: Login related tests
@run
  Scenario Outline: An error message is displayed when trying to log in with invalid details
    Given The "https://tekwillacademy-opencart.online/index.php?route=account/login&language=en-gb" is accessed
    And the login form is populated with the following data:
      | <email>    |
      | <password> |
  When the loginButton is clicked
    Then the following list of error message is displayed:
      | Warning : No match for E-mail Address and/or Password. |

  Examples:

    | email           | password  |
    | email@gmail.com | email123! |
    | gmail@gmail.com | 1         |

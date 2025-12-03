Feature: User login
  The user should be able to authenticate with valid credentials

  Background:
    Given the user opens the Saucedemo application

  @login-success
  Scenario Outline: Login with standard user
    When the user logs in with username "<username>" and password "<password>"
    Then the user should be redirected to the products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @login-wrong-password
  Scenario Outline: Login fails due to incorrect credentials
    When the user logs in with username "<username>" and password "<password>"
    Then the login should fail with an error containing "<errorMessage>"

    Examples:
      | username        | password     | errorMessage                     |
      | standard_user   | wrongpass123 | Epic sadface                     |
      | locked_out_user | secret_sauce | Sorry, this user has been locked |

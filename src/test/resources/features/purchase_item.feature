Feature: Purchase item
  The user should be able to complete a purchase

  Background:
    Given the user opens the Saucedemo application

  @purchase-success
  Scenario Outline: Purchase completed successfully
    When the user logs in with username "<username>" and password "<password>"
    When the user selects the product "<product>"
    And the user adds the product to the cart
    And the user proceeds to checkout with first name "<name>" last name "<lastName>" postal code "<postalCode>"
    Then the user should see the confirmation message "<message>"

    Examples:
      | username      | password     | product             | name  | lastName | postalCode | message                   |
      | standard_user | secret_sauce | Sauce Labs Backpack | Lucas | Diaz     | 111111     | Thank you for your order! |

Feature: I am on the Sauce demo page

  Scenario Outline: Randomly select items to purchase
    Given I open the URL
    When you enter your login details <data>
    And make the selection of random items to buy
    And continue with the checkout <data>
    Then I will validate that the purchase is successful <data>

    Examples:
      | data |
      | 0         |
      | 1         |
      | 2         |
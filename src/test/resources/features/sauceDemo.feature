Feature: As a test analyst I want to try the "sauce demo" website to practice test automation topics

  Background:
    Given I open the URL

  @BuySuccessful
  Scenario Outline: Successful purchase of randomly selected items
    And I enter login details <items>
    When I make the selection of random items to buy
    And I continue with the checkout <items>
    Then I will validate that the purchase is successful <items>
    And I log out

    Examples:
      | items |
      | 0     |

  @BuyFailed
  Scenario Outline: Failed purchase of randomly selected items
    And I enter login details <items>
    When I make the selection of random items to buy
    And I continue with the payment without entering all the data <items>
    Then I will validate that the error message on checkout web <items>
    And I log out

    Examples:
      | items |
      | 1     |

  @LoginFail
  Scenario Outline: Validate login with different credentials
    And I enter login details <items>
    Then I will validate the error message <items>

    Examples:
      | items |
      | 2     |
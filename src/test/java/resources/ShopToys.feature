Feature: Shop toys from Jupiter Toys
  Add items you wish to buy to the cart and verify cart details

  Background:
    Given If I wish to shop toys
    When I navigate to the jupitertoys "http://jupiter.cloud.planittesting.com" URL
    When I click Shop option
    
  Scenario: Add items to the cart and verify details
    When I add "2" stuffed frogs
    And I add "5" fluffy bunnies
    And I add "3" Valentine bear
    Then I click on cart
    And I verify the price of each product
    And I validate the subtotal of each product
    And I verify the total is correct
    And I close the browser instance
  
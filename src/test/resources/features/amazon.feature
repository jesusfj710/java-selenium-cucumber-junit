Feature: Add to Cart

  Background: User in the Amazon homepage adds "2" hats for men to Cart
    Given the user is on the Amazon homepage
    And the user searches for "white hats for men"
    And the user adds the first product appearing to Cart with quantity 2

  Scenario: Price and quantity of a product in Cart
    When the user opens the Cart
    Then the subtotal price in Cart should be correct
    And the quantity in Cart should be correct

  Scenario: Reduce quantity of a product in Cart
    When the user opens the Cart
    And the user updates the quantity to 1 in Cart
    Then the quantity in Cart should be correct
    And the subtotal price in Cart should be correct

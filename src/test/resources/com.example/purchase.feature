Feature: Purchase

  @positive
  Scenario: User adds product to the cart and makes checkout
    Given user enter login page
    When user enters valid credentials
    Then main page opens
    When user adds first product to the cart
    When user goes to the cart
    And makes checkout
    And enters personal info:
      | First name | Last name | ZIP   |
      | Max        | Kis       | 65189 |
    Then total is 32,39
    When user clicks Finish button
    Then the complete page has text "Thank you for your order!"
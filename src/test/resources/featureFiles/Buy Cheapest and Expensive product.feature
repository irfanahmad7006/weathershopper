Feature: Shop for Cheapest Moisturizers OR Sunscreens based on temperature

  Scenario: Buy cheapest product from weather shopper application
    Given User is on weather shopping home page
    And User verifies the title "Current Temperature" of the page
    And User clicks on Buy Moisturizers button OR Buy Sunscreens button based on current temperature
    And User clicks on add for cheapest the product
    And Product should add to the cart
    When User click on the cart button
    And User should navigate to checkout page
    And Verify the added product is in the checkout page
    And User clicks on Pay With Card button
    Then Verify payment popup is displayed
    And User fills the details
      | flink-assessment@gmail.com | 5555555555554444 | 1022 | 115 | 10601 |
    And User clicks on payment button
    And User gets the "PAYMENT SUCCESS" message

  Scenario: Buy expensive product from weather shopper application
    Given User is on weather shopping home page
    And User verifies the title "Current Temperature" of the page
    And User clicks on Buy Moisturizers button OR Buy Sunscreens button based on current temperature
    And User clicks on add for expensive the product
    And Product should add to the cart
    When User click on the cart button
    And User should navigate to checkout page
    And Verify the added product is in the checkout page
    And User clicks on Pay With Card button
    Then Verify payment popup is displayed
    And User fills the details
      | flink-assessment@gmail.com | 5555555555554444 | 1022 | 115 | 10601 |
    And User clicks on payment button
    And User gets the "PAYMENT SUCCESS" message
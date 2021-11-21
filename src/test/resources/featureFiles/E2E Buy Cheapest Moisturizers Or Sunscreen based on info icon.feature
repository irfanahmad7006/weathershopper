Feature: E2E Buy Cheapest Moisturizers Or Sunscreen based on info icon

  Scenario:Buy Cheapest Moisturizers Or Sunscreens based on info icon
    Given User is on weather shopping home page
    And User verifies the title "Current Temperature" of the page
    And User clicks on Buy Moisturizers button OR Buy Sunscreens button based on current temperature
    And User clicks on add for cheapest the products as per the info icon
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
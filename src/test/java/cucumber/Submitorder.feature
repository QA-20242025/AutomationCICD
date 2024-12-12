Feature: Purchase the order from Ecommerce Website

  Background:
    Given I landed on Ecommerce page
@Regression
  Scenario Outline: Positive Scenario of Submitting the order
    Given Logged in with username <name> and password   <password>
    When I add product <productname> to cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage
    Examples:
    | name               | password | productname |
    | qwerty@asd.com     | Abcd@123 | ZARA COAT 3 |



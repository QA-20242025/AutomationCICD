Feature: Purchase the order from Ecommerce Website



@errorvalidations
  Scenario Outline: Error Validation
    Given I landed on Ecommerce page
    Given Logged in with username <name> and password   <password>
    Then "Incorrect email or password." error message displayed

    Examples:
    | name                | password |
    | qwertyu@asd.com     | Abcd@123 |



Feature: Amazon Search
  Scenario: Search for product at Amazon page
    Given I am on the Amazon home page
    When I search for "Laptop"
    Then I should see result for "Laptop"

  Scenario Outline: Search for product at Amazon page
    Given I am on the Amazon home page
    When I search for "<product>"
    Then I should see result for "<product>"

    Examples:
      |product |
      |tv  |
      |mobile |
      |refrigerator|

  Scenario: Check whether Categories dropdown is selectable
    Given I am on the Amazon home page
    When I click on "Baby" in category dropdown
    Then I should see "Baby" category is selected

  Scenario: Check whether user redirects to Accounts page
    Given I am on the Amazon home page
    When I click on Your Account in Accounts dropdown
    Then I should land on Accounts page

    Scenario: Check whether user navigates to Books page


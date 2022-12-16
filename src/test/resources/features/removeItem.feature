@Testcase4
Feature: Remove item
  As an automated test user
  I want to remove item from the basket
  So that the product will disappear from the basket

  Rule: It is allowed to remove an item from the basket

    Background:
      Given open the main page
      And the page is online
      And accept cookies
      And sign in button is available
      And I am signed in
      And I search for an item
      And I add an item

    Scenario: Remove item
      When I remove an item
      Then product will disappear from the basket
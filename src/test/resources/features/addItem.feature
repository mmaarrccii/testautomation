@Testcase8
Feature: Add item
  As an automated test user
  I want to add item into the basket
  So that the added item is stored in the basket

  Rule: It is allowed to add an item into the basket

    Background:
      Given open the main page
      And the page is online
      And accept cookies
      And sign in button is available
      And I am signed in
      And I search for an item

    Scenario: Add item
      When I add an item
      Then products are displayed in the basket




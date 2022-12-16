@Testcase3
Feature: Add item
  As an automated test user
  I want to add item into the basket
  So that the added item is stored in the basket

  Rule: It is allowed to add an item into the basket

    Background:
      Given open the main page
      And accept cookies
      And I am on the login page
      And I login account with username and password
      And I am on the products page
      And I search for "PICK szeletelt eredeti téliszalámi 100 g"

    Scenario: Add item
      When I add an item
      Then item is displayed in the basket




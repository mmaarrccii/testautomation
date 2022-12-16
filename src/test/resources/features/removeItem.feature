@Testcase4
Feature: Remove item
  As an automated test user
  I want to remove item from the basket
  So that the product will disappear from the basket

  Rule: It is allowed to remove an item from the basket

    Background:
      Given open the main page
      And accept cookies
      And I am on the login page
      And I login account with username and password
      And I am on the products page
      And I search for "PICK szeletelt eredeti téliszalámi 100 g"
      And I add an item
      And item is displayed in the basket

    Scenario: Remove item
      When I remove an item
      Then product will disappear from the basket
@Testcase2
Feature: Search item
  As an automated test user
  I want to search an item
  So that I can find it in the webshop

  Rule: It is allowed to search an item

    Background:
      Given open the main page
       And accept cookies
      And I am on the login page
      And I login account with username and password
      And I am on the products page

    Scenario: Search item
      When I search for "PICK eredeti téliszalámi"
      Then I can see the "PICK eredeti téliszalámi" in results
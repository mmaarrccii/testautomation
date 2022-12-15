@Testcase7
Feature: Search item
  As an automated test user
  I want to search an item
  So that I can find it in the webshop

  Rule: It is allowed to search an item

    Background:
      Given open the main page
      And the page is online
      And accept cookies
      And sign in button is available
      And I am signed in

    Scenario: Search item
      When I search for an item
      Then results are displayed
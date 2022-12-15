@Testcase10
Feature: Sign out
  As an automated test user
  I want to sign out tesco webshop
  So that I can not reach a basket anymore

  Rule: It is allowed to logout from the webshop

    Background:
      Given open the main page
      And the page is online
      And accept cookies
      And sign in button is available
      And I am signed in

    Scenario: Sign out successful
      When I sign out
      Then basket is not available
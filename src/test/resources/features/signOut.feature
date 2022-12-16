@Testcase7
Feature: Sign out
  As an automated test user
  I want to sign out tesco webshop
  So that I can not reach a basket anymore

  Rule: It is allowed to logout from the webshop

    Background:
      Given open the main page
      And accept cookies
      And I am on the login page
      And I login account with username and password

    Scenario: Sign out successful
      Given I am on the products page
      When I sign out
      Then no basket icon available
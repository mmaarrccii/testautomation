@Testcase6
Feature: Sign in
  As an existing tesco user
  I want to sign in to tesco webshop
  So that I can reach my basket

  Rule: It is allowed to login in webshop and reach a shopping basket

    Background:
      Given open the main page
      And the page is online
      And accept cookies
      And sign in button is available

    Scenario: Sign in successful
      Given I am on the login page
      When I login account with username and password
      Then I am on the products page
      And I should see the basket icon

    Scenario: Sign in failed
      Given I am on the login page
      When I login with invalid username or password
      Then I should see the error message on the login page
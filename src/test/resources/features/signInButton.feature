@Testcase4
Feature: Sign in button
  As an automated test user
  I need to know that sign in button is available on the page
  So that I can sign in

  Rule: It is allowed push the sign in button

    Background:
      Given open the main page
      And the page is online
      And accept cookies

    Scenario: Sign in button available
      Given I am on the login page
      When I want to login
      Then sign in button is available
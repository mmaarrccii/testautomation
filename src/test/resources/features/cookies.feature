@Testcase2
Feature: Cookies
  As an automated test user
  I need to know that cookies warning is displayed on page
  So that I can accept all cookies

  Rule: It is allowed to accept cookies

    Background:
      Given open the main page
      And the page is online

    Scenario: Accept cookies
      When accept cookies
      Then the cookie panel closes
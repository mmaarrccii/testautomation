@Testcase1
Feature: Page is online
  As an automated test user
  I need to know that tesco webshop page is online
  So I can find accept cookies button

  Rule: It is allowed to login in webshop and reach a shopping basket

    Background:
      Given open main page

    Scenario: Page is online
      Then I should see the accept cookies button
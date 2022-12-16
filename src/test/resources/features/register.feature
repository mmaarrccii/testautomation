@Testcase0
Feature: Register
  As an non-existing Tesco user
  I want to register into webshop
  So that I can sign in

  Rule: It is allowed to register to the webshop

    Background:
      Given open the main page
      And the page is online
      And accept cookies

    Scenario: Change the language to english
      Given I am on the registration page
      When I register
      Then I will have a profile
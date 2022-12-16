@Testcase1.2
Feature: Sign in
  As an existing tesco user
  I want to sign in to tesco webshop with wrond datas
  So that I can't reach my basket

  Rule: It is not allowed to login in webshop and reach a shopping basket

    Background:
      Given open the main page
      And accept cookies

    Scenario: Sign in failed
      Given I am on the login page
      When I login with invalid username or password
      Then I should see the error message on the login page
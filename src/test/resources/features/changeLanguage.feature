@Testcase0.1
Feature: Change Language
  As an automated test user
  I want to be able to change language to English
  So that I can reach the page in English

  Rule: It is allowed to change the language

    Background:
      Given open the main page
      And accept cookies

    Scenario: Change the language to english
      Given language is set to "Magyar"
      When I change the language to "English"
      Then it shows elements in "English"
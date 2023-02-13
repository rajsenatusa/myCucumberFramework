#Author: Can Yavas

Feature: Login Functionality

  @regression
  Scenario: Valid Login
    Given I navigated to the spin website
    When I enter a valid username
    And I enter a valid password
    And I click on the signin button
    Then I validate that I am logged in
    And I will quit the browser

  @regression
  Scenario: Invalid Password
    Given I navigated to the spin website
    When I enter a valid username
    And I enter an invalid password
    And I click on the signin button
    Then I validate that Invalid Credentials is displayed
    Then I will quit the browser


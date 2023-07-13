#Author: Can Yavas

@smoke
Feature: Login Functionality Testing for all Test Environments

  
  Scenario: Valid Login to Model Environment
    Given User navigates to the spin model website
    When User enters a valid username
    And User enters a valid password
    And User clicks on the signin button
    Then User validates that logged in successfully
    And User quits the browser

 
 
  Scenario: Invalid Login to Model Environment
    Given User navigates to the spin model website
    When User enters a valid username
    And User enters an invalid password
    And User clicks on the signin button
    Then User validates that Invalid Credentials is displayed
    Then User quits the browser


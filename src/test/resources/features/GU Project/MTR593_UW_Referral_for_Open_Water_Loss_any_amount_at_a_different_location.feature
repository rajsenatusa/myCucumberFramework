##created on 04/02/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR593--HO3, UW Referral for Open Water Loss (any amount)at a different location
## PRECONDITIONS (IF ANY): APLUS data -Open Water Loss(any amount) at a different location than current address
## HIGH LEVEL STEPS OF TEST SCRIPT:  Create NB HO3 policy APLUS pulls in an Open Water Loss 
## EXPECTED RESULTS: Agent is not able to bind without Underwriting approval due to open water loss
## "Risks with open losses are ineligible for coverage" Validation message displays.
  
## User: AG1529
  
## Test Case in Ineffective. Needs to be updated with new water loss history address. Removed from regression. Last Steps are missing. Complete once you have correct address
## Note: Please login with gallopadmin and remove Catestropic threashold limit and add it after execution



@mtr593 
Feature: MTR593--HO3, UW Referral for Open Water Loss (any amount)at a different location

  Scenario: Validate Agent is not able to bind without Underwriting approval due to open water loss
    Given User login to Spin as Diamond Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr593>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr593>
    And User enters all required information on HO3 dwelling screen <mtr593>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr593>
    And User takes note of the application for <mtr593>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the application <mtr593>
    And User takes ownership of the application 
    And User validates losses have been displayed and attaches screenshot <mtr593>
    And User clicks Dwelling Tab and updates construction year of the building <mtr593>
    And User transfer application back to producer
    And User signs out
    And User login to Spin as Diamond Agent
    And User searches for the application <mtr593>
    And User clicks Dwelling Chevron <mtr593>
    And User navigates loss history chevron and validates loss claim status labels are visible and attaches screenshot <mtr593>
    And User clicks policy tab and validates 'Risks with open losses are ineligible for coverage' message is visible <mtr593>
    And User clicks Finalize button <mtr593>
    And User validates 'Risks with open losses are ineligible for coverage' text is visible <mtr593>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr593>
    And User approves application
    And User signs out
    And User login to Spin as Diamond Agent
    And User searches for the application <mtr593>
    And User scrolls to preview output field and attaches screenshot <mtr593>
    And User issues policy and take note of the policy number <mtr593>
    And User searches for the policy <mtr593>
    And User clicks New Quote button
    And User enters Eff Date state and starts new quote <mtr593>
    And User enters all required information on HO3 quote screen with different address <mtr593>
    And User enters all required information on HO3 dwelling screen with new address <mtr593>
    
    
    
    
    
    
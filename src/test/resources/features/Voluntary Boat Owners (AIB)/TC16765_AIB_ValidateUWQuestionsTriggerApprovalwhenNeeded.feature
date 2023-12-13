##created on 10/02/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 16765--AIB Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'
## PRECONDITIONS (IF ANY): 
## HIGH LEVEL STEPS OF TEST SCRIPT:  Selecting "Yes" for all Underwriting Questions.
  
## EXPECTED RESULTS: Selecting "Yes" to Underwriting Questions will produce the following...
##						1. Child Questions are generated 
##						2. Underwriting Approval referral is triggered
##						3. Agent cannot bind NB without Underwriting Approval 
  
## User: AG1730


@regression @tc16765 @aibregression
Feature: TC 16765--AIB Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'

  Scenario: Validate Selecting Yes to Underwriting Questions will require Underwriting Approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc16765>
		And User enters AIB product selection information and current date as effective date
    And User enters all required information on AIB quote screen for <tc16765>
    And User selects liability coverage on quote screen for <tc16765>
    And User adds operator information on quote screen <tc16765>
    And User enters all required information on AIB boat dwelling screen for <tc16765>
    And User enters all required information on AIB review screen
		And User creates AIB application
    And User checks error messages when AIB Underwriting Questions answered as Yes and validates 'Response to Underwriting question requires Underwriting approval' message for all questions
    And User sets all UW questions as Yes and validates all error messages displayed on policy chevron
    And User checks application dwelling screen and finalizes transaction
    And User validates error messages displayed on closeout Screen
    And User takes note of the application for <tc16765>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16765>
    And User validates error messages displayed on closeout screen with underwriter
    And User clicks submit for approval as underwriter
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc16765>
    And User validates error messages displayed on submitter issues tile
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc16765>
    Then User issues policy and close unnecessary tabs and completes test <tc16765>
    
##created on 10/05/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 16667--GOC Agent App Validations "Validate UW questions trigger approval when needed"
## PRECONDITIONS (IF ANY);
## HIGH LEVEL STEPS OF TEST SCRIPT:  Selecting "Yes" for all Underwriting Questions
  
## EXPECTED RESULTS: Selecting "Yes" to Underwriting Questions will produce the following...
##						1. Child Questions are generated 
##						2. Underwriting Approval referral is triggered
##						3. Agent cannot bind NB without Underwriting Approval 
  
## User: AG1730


@regression @tc16667 @gocregression
Feature: TC 16667--GOC Agent App Validations 'Validate UW questions trigger approval when needed'

  Scenario: Validate Selecting Yes to Underwriting Questions will require Underwriting Approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc16667>
		And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen <tc16667>
    And User enters all required information on GOC golfcart screen for <tc16667>
    And User enters driver information on driver screen <tc16667>
    And User enters vehicles information on vehicles screen <tc16667>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User checks error messages when Goc Underwriting Questions answered as Yes and validates particular error messages for all questions
    And User answers as Yes all UW questions
    And User checks application dwelling screen and finalizes transaction
    And User validates expected error messages displayed on closeout Screen
    And User takes note of the application for <tc16667>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16667>
    And User validates expected error messages displayed on Underwriter closeout screen
    And User clicks submit for approval as underwriter
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc16667>
    And User validates 'Risk is ineligible' message on closeout Screen
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc16667>
    Then User issues policy and close unnecessary tabs and completes test <tc16667>
    
    
    
    
    
    
    
    
    
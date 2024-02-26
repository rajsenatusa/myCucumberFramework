##created on 09/13/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR-590--HO3, Standard Agent, NB 2 or more losses, UW approval required
## PRECONDITIONS (IF ANY): APLUS Data - 2 or more losses Use Emily Watson DOB- 10/09/1989 18584 Tampa Rd Fort Myers, FL 33967
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  Create NB HO3 policy where APLUS pulls in 2 or more losses 
   
## EXPECTED RESULTS: Underwriting Approval required due to loss history 
  
## User: AG0376

## TEST CASE STEPS MODIFIED ON 09/19/2023 REGARDING CAPACITY RULE CHANGE AND APLUS DATA REPORTING ISSUE

@regression @mtr590 @ho3regression 
Feature: MTR-590--HO3, Standard Agent, NB 2 or more losses, UW approval required

  Scenario: Validate Underwriting Approval required due to loss history
    Given User login to Spin as Automation Test Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr590>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr590>
    And User enters all required information on HO3 dwelling screen <mtr590>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr590>
    And User takes note of the application for <mtr590>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the application <mtr590>
    And User takes ownership of the application 
    And User validates loss claim status labels are visible and attaches screenshot
    And User clicks Dwelling Tab and updates construction year of the building
    And User transfer application back to producer
    And User signs out
    And User login to Spin as Automation Test Agent
    And User searches for the application <mtr590>
    And User clicks Policy Tab and validates 'Underwriting approval required prior to binding due to loss history' 'Risks with open losses are ineligible for coverage' texts are visible
    And User clicks Finalize button <mtr590>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr590>
    And User validates 'Underwriting approval required prior to binding due to loss history' 'Risks with open losses are ineligible for coverage' texts are visible
    And User approves application
    And User signs out
    Then User login to Spin as Automation Test Agent
    And User searches for the application <mtr590>
    And User scrolls to preview output field and attaches screenshot
    And User issues policy and completes test <mtr590>
    
    
    
    
    
    
    
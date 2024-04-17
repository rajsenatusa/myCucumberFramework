##created on 04/3/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR-297--HO3, Underwriter should be able to Reject an application if it is not meeting AIIG policy issuance guidelines
## PRECONDITIONS (IF ANY): APLUS Data - 2 or more losses Use Emily Watson DOB- 10/09/1989 18584 Tampa Rd Fort Myers, FL 33967
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  Create NB HO3 policy where APLUS pulls in 2 or more losses 
   
## EXPECTED RESULTS: As an Underwriter, Reject an Application which doesn’t meet our standards for Prior Losses
  
## User: AG0376

## TEST CASE STEPS MODIFIED REGARDING CAPACITY RULE CHANGE 

@regression @mtr297 @ho3regression @gu 
Feature: MTR-297--HO3, Underwriter should be able to Reject an application if it is not meeting AIIG policy issuance guidelines

  Scenario: Validate As an Underwriter, Reject an Application which doesn’t meet our standards for Prior Losses
    Given User login to Spin as Automation Test Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr297>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr297>
    And User enters all required information on HO3 dwelling screen <mtr297>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr297>
    And User takes note of the application for <mtr297>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the application <mtr297>
    And User takes ownership of the application 
    And User validates loss claim status labels are visible and attaches screenshot <mtr297>
    And User clicks Dwelling Tab and updates construction year of the building <mtr297>
    And User transfer application back to producer
    And User signs out
    And User login to Spin as Automation Test Agent
    And User searches for the application <mtr297>
    And User clicks Policy Tab and validates 'Underwriting approval required prior to binding due to loss history' 'Risks with open losses are ineligible for coverage' texts are visible <mtr297>
    And User clicks Finalize button <mtr297>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr297>
    And User validates 'Underwriting approval required prior to binding due to loss history' 'Risks with open losses are ineligible for coverage' texts are visible <mtr297>
    And User rejects application
    And User signs out
    And User login to Spin as Automation Test Agent
    And User searches for the application <mtr297>
    And User validates 'Underwriting approval required prior to binding due to loss history' 'Risks with open losses are ineligible for coverage' texts are visible <mtr297>
    Then User validates 'Issue New Business' is not visible on closeout screen and completes test <mtr297>
    
    
    
    
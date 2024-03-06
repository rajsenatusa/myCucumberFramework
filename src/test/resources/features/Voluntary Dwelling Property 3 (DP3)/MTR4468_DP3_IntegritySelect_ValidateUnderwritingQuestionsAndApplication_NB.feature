##created on 09/21/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 38492--Validate Owner Occupied NB Endorsement- NB INTEGRITY SELECT Text Builder
## PRECONDITIONS (IF ANY)
## HIGH LEVEL STEPS OF TEST SCRIPT: Create Integrity Select Policy effective 1/20/2022, once issued, endorse to 
## change to Basic Policy, validate coverages revert and validate Text Builder
  
## EXPECTED RESULTS: NB Integrity Select DP3 Policy- Owner Occupied Endorse to change to Basic. Coverages default as 
## expected per requirements Text Builder is working as expected 
   
## User: AG1730

@regression @tc38492 @MTR4468 @dp3regression 
Feature: MTR4468-Validate Owner Occupied NB Endorsement- NB INTEGRITY SELECT Text Builder

  Scenario: Validate that NB Integrity Select DP3 Policy Owner Occupied Endorse to change to Basic and Coverages default as expected per requirements Text Builder is working as expected 
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc38492>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <tc38492>
    And User enters all required information on DP3 dwelling screen <tc38492> and selects integrity select
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3 sets vacant unoccupied and known sinkhole loss as yes
    And User finalizes transaction for <tc38492>
    And User selects Payment Type <tc38492>
    And User takes note of the application for <tc38492>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc38492>
    And User clicks submit for approval button without popup
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc38492>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc38492>
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <tc38492>
    And User clicks Policy File Chevron <tc38492>
    Then User clicks Application Form and saves it to the local and do validations UW question answers are matching with actual
    
    
    
    
    
    
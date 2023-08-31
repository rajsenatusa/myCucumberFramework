#Author: Can Yavas
##created on 08/31/2023

## TEST CASE NUMBER & TITLE: MTR377--TOHO3, Agent, END TX, Increase CovA, Change Deductible, Additional Interests, UW Approval
## PRECONDITIONS (IF ANY):Active TOHO3  Policy 
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an agent, Endorse the policy to Increase CovA, change Deductibles and Update current Mortgagee 
## EXPECTED RESULTS: Underwriting Manager  approval is required Appraval messages trigger on CloseOut screen
## Agent must Submit for Approval 
  
## User: AG1730

## The test cases is pending resolution with defect IS 578

@regression @mtr377
Feature: MTR377--TOHO3, Agent, END TX, Increase CovA, Change Deductible, Additional Interests, UW Approval

  Scenario: Validate Underwriting Manager approval is required Approval messages trigger on CloseOut screen

    Given User login to Spin as Admin Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr377>
    And User enters product selection information for TOHO3 and sets effective date as current date
    And User enters all required information on TOHO3 quote screen <mtr377>
    And User enters all required information on TOHO3 dwelling screen <mtr377>
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects dwelling type and roof material
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr377>
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the policy number <mtr377>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr377>
    And User clicks Dwelling Chevron for <mtr377>
    And User increases CovA dwellings
    And User adds additional interests for first mortgagee <mtr377>
    And User finalizes transaction and verify changes are visible on closeout screen and clicks submit for approval
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr377>
    And User validates approval request texts have been displayed
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <mtr377>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <mtr377>
    And User validates 'Endorse Policy' label is visible and process endorsement and finishes test <mtr377>
    
    
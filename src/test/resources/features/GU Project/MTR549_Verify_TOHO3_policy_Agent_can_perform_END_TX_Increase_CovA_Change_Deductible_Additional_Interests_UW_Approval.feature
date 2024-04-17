##created on 03/20/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR549--Verify TOHO3 policy, Agent can perform END TX, Increase CovA, Change Deductible, Additional Interests, UW Approval
## PRECONDITIONS (IF ANY): Active TOHO3 policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Login as Sales Agent,
## 2. Retrieve policy from preconditions
## 3. Start endorsement with date of current date plus 30 days, change deductibles, add additional interest
## 4. Submit for approval as agent, validate issue messages
## 5. Log in as Underwriter, search application and approve
## 6. Log in as Standard Sales Agent, and endorse policy


  
## EXPECTED RESULTS: Validate As a Sales Agent, I would like the ability to update/endorse a policy
  
## User: Admin, Standard Sales Agent (AG1730A1), Underwriter


@regression @mtr549 @toho3regression @gu 
Feature: MTR549--Verify TOHO3 policy, Agent can perform END TX, Increase CovA, Change Deductible, Additional Interests, UW Approval

  Scenario: Validate Agent can perform END TX, Increase CovA, Change Deductible, Additional Interests with the help of UW Approval
    Given User login to Spin as Admin Agent
    And User changes system date to current date <mtr549>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr549>
    And User enters product selection information for TOHO3 and sets effective date as current date
    And User enters all required information on TOHO3 quote screen <mtr549>
    And User enters all required information on TOHO3 dwelling screen <mtr549>
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects dwelling type and roof material
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr549>
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to current date <mtr549>
    And User searches for the policy number <mtr549>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date plus 30 days and starts endorsement <mtr549>
    And User clicks Dwelling Chevron for <mtr549>
    And User increases CovA dwellings <mtr549>
    And User adds additional interests for first mortgagee <mtr549>
    And User finalizes transaction and verify changes are visible on closeout screen and clicks submit for approval <mtr549>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date <mtr549>
    And User searches for the application <mtr549>
    And User validates approval request texts have been displayed <mtr549>
    And User clicks submit for approval button <mtr549>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <mtr549>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to current date <mtr549>
    And User searches for the application <mtr549>
    And User validates 'Endorse Policy' label is visible and process endorsement and finishes test <mtr549>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
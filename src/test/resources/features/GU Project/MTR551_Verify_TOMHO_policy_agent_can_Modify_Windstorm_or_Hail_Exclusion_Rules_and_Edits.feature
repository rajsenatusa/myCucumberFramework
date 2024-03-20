##created on 03/18/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR551--Verify TOMHO policy agent can Modify Windstorm or Hail Exclusion Rules and Edits
## PRECONDITIONS (IF ANY): Create TOMHO policy with an effective with current effective date With Wind Hail Exclusion Checked
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create TOMHO policy with an effective with current effective date With Wind Hail Exclusion Checked
## 2. Advance Date to Policy Effective Date -1 day. Do Endorsement, observe Windstorm or Hail Exclusion check box is greyed out and uneditible
## 3. Click Cancel Transaction, Advance Date to Policy Effective Date, observe Windstorm or Hail Exclusion check box is greyed out and uneditible
## 4. Advance Date to Policy Effective Date +1, The following message displays on the UI; The effective date must not be older than 0 days from today. fix?
## 5. Log in as Underwriter, Advance System Date to Policy Effective date +1 day, search for application
## 6. Uncheck e Windstorm or Hail Exclusion check box
## 7. Hurricane* defaults to 2%
## 8. Click Finalize Transaction, Endorsement is successful

  
## EXPECTED RESULTS: Validate As a Sales Agent, I would like the ability to update/endorse a policy
  
## User: Admin, Standard Sales Agent (AG1730A1), Underwriter


@regression @mtr551 @tomhoregression @gu
Feature: MTR551--Verify TOMHO policy agent can Modify Windstorm or Hail Exclusion Rules and Edits

  Scenario: Validate As a Sales Agent, I would like the ability to update endorse a policy
    Given User login to Spin as Admin Agent
    And User changes system date to current date <mtr551>
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr551>
    And User enters product selection information for TOMHO and current date as effective date
    And User enters all required information on TOMHO quote screen <mtr551>
    And User enters all required information on TOMHO dwelling screen <mtr551>
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron <mtr551>
    And User completes required information on dwelling screen <mtr551>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHO policy has been created successfully and takes note of the policy number <mtr551>
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to current date minus 1 day <mtr551>
    And User searches for the policy number <mtr551>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr551>
    And User clicks dwelling chevron <mtr551>
    And User validates wind hail exclusion radio button has been disabled
    And User deletes application <mtr551>
    And User changes system date to current date <mtr551>
    And User searches for the policy number <mtr551>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr551>
    And User clicks dwelling chevron <mtr551>
    And User validates wind hail exclusion radio button has been disabled
    And User deletes application <mtr551>
    And User changes system date to current date plus 1 day <mtr551>
    And User searches for the policy number <mtr551>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date plus 1 day and starts endorsement <mtr551>
    And User clicks dwelling chevron <mtr551>
    And User validates wind hail exclusion radio button has been disabled
    And User takes note of the application number <mtr551>
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date plus 1 day <mtr551>
    And User searches previously created application <mtr551>
    And User takes ownership of the application
    And User clicks dwelling chevron <mtr551>
    And User unchecks wind hail exclusion button and validates hurricane defaulted %2 
    Then User finalizes transaction and endorses policy and completes test <mtr551>
    
    
    
    
    
    
    
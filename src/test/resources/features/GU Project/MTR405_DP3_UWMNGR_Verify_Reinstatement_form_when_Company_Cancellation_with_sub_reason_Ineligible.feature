##created on 03/15/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR405--DP3 - UWMNGR - Verify Reinstatement form when Company Cancellation with sub reason Ineligible
## PRECONDITIONS (IF ANY): Active DP3 Policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Retrieve VOL DP3 Policy with 
## 									 2. Do Cancellation
## 									 3. Do Reinstatement
##									 4. Click Forms Chevron
## 									 4. Click Policy File Chevron
  
## EXPECTED RESULTS: Policy is Cancelled & and reinstated and correct Reinstatement form is attaching to Policy File and Forms Chevron  
  
## User: UW Manager(jbarnes), Standard Agent (AG1730A1)


@regression @mtr405 @dp3regression @gu 
Feature: MTR405--DP3 - UWMNGR - Verify Reinstatement form when Company Cancellation with sub reason Ineligible

  Scenario: Validate that Policy is Cancelled & and reinstated and correct Reinstatement form is attaching to Policy File and Forms Chevron     
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr405>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr405>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr405>
    And User enters all required information on DP3 dwelling screen <mtr405>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that DP3 policy has been created successfully and closes unnecessary tabs <mtr405>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to current date <mtr405>
    And User searches for the policy number <mtr405>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr405>
    And User makes payment with Credit Card for <mtr405>
    And User searches for the policy number <mtr405>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Company
    And User selects Property Ineligible as reason <mtr405>
    And User selects Built on landfill or refuse as subreason <mtr405>
    And User selects effective date as cancel date 'current date' <mtr405>
    And User process cancellation <mtr405>
    And User completes cancellation transaction and validates policy transaction status as cancelled <mtr405>
    And User clicks Start Transaction
    And User selects Reinstatement
    And User completes and process reinstatement transaction <mtr405>
    And User clicks Forms Chevron <mtr405>
    And User validates <AIIC RI 11 14> form is visible on <mtr405>
    #And User clicks Rein Notice Form and validates form details as expected <mtr405>    
    And User clicks Policy File Chevron <mtr405>
    Then User clicks Continuation of Coverage link and validates AIIC RI 11 14 form version listed in the package <mtr405>
    
    
    
    
    
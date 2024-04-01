##created on 03/27/2024 by Can Yavas
## TEST CASE NUMBER & TITLE: MTR435_DP3-As an Underwriter, I would like the ability to process rewrite-Renewal on Cancelled RNEWAL policy
## PRECONDITIONS (IF ANY): Create DP3 Policy with Full payment Plan and Cancelled flat with effective date as cancellation date
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Change System date and book date same as Renewl effective date
## 2. Open the policy mentioned in precondition
## 3. Click Start Transaction > Select Rewrite-Renewal
## 4. Increase Dwelling-A by 10,000
## 5. Click on Process button
## 6. Click on Forms Link on left pane, Renewal Greeting Letter form is generated
## 7. Click on Dwelling link on left panel, New Coverage like Dwellling -A with updated value is displayed

## EXPECTED RESULTS: Validate that Dp3 Policy is cancelled and UW can able to rewrite-renewal the cancelled Policy
## User: Standard Agent, jbarnes(UW)

@regression @mtr435 @dp3regression @gu
Feature: MTR435_DP3-As an Underwriter, I would like the ability to process rewrite-Renewal on Cancelled RNEWAL policy

  Scenario: Validate that Dp3 Policy is cancelled and UW can able to rewrite-renewal the cancelled Policy
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr435>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr435>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr435>
    And User enters all required information on DP3 dwelling screen <mtr435>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that DP3 policy has been created successfully and closes unnecessary tabs <mtr435>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Coverage not needed as reason <mtr435>
    And User selects effective date as cancel date 'current date' <mtr435>
    And User process cancellation transaction <mtr435>
    And User completes cancellation transaction and validates policy transaction status as cancelled <mtr435>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to current date <mtr435>
    And User searches for the policy number <mtr435>
    And User clicks Start Transaction
    And User select Rewrite Renewal <mtr435>
    And User clicks Dwelling Chevron <mtr435>
    And User increases Coverage A by 10000 <mtr435>
    And User clicks Review Chevron and select full payment plan and finalize rewrite renewal transaction
    And User completes rewrite renewal transaction and validates policy transaction status <mtr435>
    Then User clicks Forms Chevron
    And User validates "Renewal Greeting Letter" form is visible and completes test
    
    
    
    
    
    
    
    
    
    
    
    
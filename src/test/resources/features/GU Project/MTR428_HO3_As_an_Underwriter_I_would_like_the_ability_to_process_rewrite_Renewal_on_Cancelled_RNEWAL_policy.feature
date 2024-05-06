##created on 03/28/2024 by Can Yavas
## TEST CASE NUMBER & TITLE: MTR428_HO3-As an Underwriter, I would like the ability to process rewrite-Renewal on Cancelled RNEWAL policy
## PRECONDITIONS (IF ANY): Create HO3 Policy with Full payment Plan and Cancelled flat with effective date as cancellation date
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Change System date and book date same as Renewl effective date
## 2. Open the policy mentioned in precondition
## 3. Click Start Transaction > Select Rewrite-Renewal
## 4. Increase Dwelling-A by 10,000
## 5. Click on Process button
## 6. Click on Forms Link on left pane, Renewal Greeting Letter form is generated
## 7. Click on Dwelling link on left panel, New Coverage like Dwellling -A with updated value is displayed

## EXPECTED RESULTS: Validate that HO3 Policy is cancelled and UW can able to rewrite-renewal the cancelled Policy
## User: Standard Agent, jbarnes(UW)

@regression @mtr428 @ho3regression @gu 
Feature: MTR428_HO3-As an Underwriter, I would like the ability to process rewrite-Renewal on Cancelled RNEWAL policy

  Scenario: Validate that HO3 Policy is cancelled and UW can able to rewrite-renewal the cancelled Policy
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr428>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr428>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr428>
    And User enters all required information on HO3 dwelling screen <mtr428>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr428>
    And User clicks Finalize button <mtr428>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr428>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Coverage not needed as reason <mtr428>
    And User selects effective date as cancel date 'current date' <mtr428>
    And User process cancellation transaction <mtr428>
    And User completes cancellation transaction and validates policy transaction status as cancelled <mtr428>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to current date <mtr428>
    And User searches for the policy number <mtr428>
    And User clicks Start Transaction
    And User select Rewrite Renewal <mtr428>
    And User clicks Dwelling Chevron <mtr428>
    And User increases Coverage A by 10000 <mtr428>
    And User clicks Review Chevron and select full payment plan and finalize rewrite renewal transaction <mtr428>
    And User completes rewrite renewal transaction and validates policy transaction status <mtr428>
    Then User clicks Policy File Chevron <mtr428>
    And User validates "Renewal Declaration" form is visible and completes test <mtr428>
    
    
    
    
    
    
    
    
    
    
    
    
    
##created on 03/28/2024 by Can Yavas
## TEST CASE NUMBER & TITLE: MTR431_HO6-As an Underwriter, I would like the ability to process rewrite-Renewal on Cancelled RNEWAL policy
## PRECONDITIONS (IF ANY): Create HO6 Policy with Full payment Plan and Cancelled flat with effective date as cancellation date
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Change System date and book date same as Renewl effective date
## 2. Open the policy mentioned in precondition
## 3. Click Start Transaction > Select Rewrite-Renewal
## 4. Increase Dwelling-A by 10,000
## 5. Click on Process button
## 6. Click on Forms Link on left pane, Renewal Greeting Letter form is generated
## 7. Click on Dwelling link on left panel, New Coverage like Dwellling -A with updated value is displayed

## EXPECTED RESULTS: Validate that HO6 Policy is cancelled and UW can able to rewrite-renewal the cancelled Policy
## User: Standard Agent, jbarnes(UW)

@regression @mtr431 @ho6regression @gu
Feature: MTR431_HO6-As an Underwriter, I would like the ability to process rewrite-Renewal on Cancelled RNEWAL policy

  Scenario: Validate that HO6 Policy is cancelled and UW can able to rewrite-renewal the cancelled Policy
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr431>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr431>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <mtr431>
    And User enters all required information on HO6 dwelling screen and enters <15.000> for CovC <mtr431>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <mtr431>
    And User checks application dwelling screen and finalizes transaction <mtr431>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number <mtr431>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Coverage not needed as reason <mtr431>
    And User selects effective date as cancel date 'current date' <mtr431>
    And User process cancellation transaction <mtr431>
    And User completes cancellation transaction and validates policy transaction status as cancelled <mtr431>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to current date <mtr431>
    And User searches for the policy number <mtr431>
    And User clicks Start Transaction
    And User select Rewrite Renewal <mtr431>
    And User clicks Dwelling Chevron <mtr431>
    And User increases Coverage A by 10000 <mtr431>
    And User clicks Review Chevron and select full payment plan and finalize rewrite renewal transaction <mtr431>
    And User completes rewrite renewal transaction and validates policy transaction status <mtr431>
    Then User clicks Forms Chevron
    And User validates "Renewal Greeting Letter" form is visible and completes test <mtr431>
    
    
    
    
    
    
    
    
    
    
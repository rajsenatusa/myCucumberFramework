#Author: Can Yavas
##created on 08/18/2023

## TEST CASE NUMBER & TITLE: TC 35186--MHO Agent NB END - Validate Backdating WInd/Hail Deductible Changes Prior to, 
## On, and After RN Effective Date
## PRECONDITIONS (IF ANY): As Agent Create MHO3 Family Park  policy effective on or after 8/21/2020
## With Wind/Hail Deductible Exclusion checked
## Agent and Underwriter must have Change Date Roles
## Park - Shadow Hills Mobile Home Community, Address - 8403 Millinockett Ln  32825
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
## After RN Effective Date & UW Approval
 
## EXPECTED RESULTS: Validate a change to coverage(s) with an Effective Date in the past fires the error
## Validate a change to coverage(s) with an Effective Date = todays date is allowed to Process
## Validate the UW can override and allow the Endorsement when submitted for approval    
## User: AG1730

@regression @mtr370 @mho3regression
Feature: TC 35186--MHO Agent NB END - Validate Backdating WInd/Hail Deductible Changes Prior to On, and After RN Effective Date

  Scenario: Validate a change to coverage(s) with an Effective Date in the past fires the error
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address for <mtr370>
    And User enters MHO3 product selection information and effective date as current date
    And User enters Producer <mtr370>
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <mtr370>
    And User enters all required information on MHO3 dwelling screen and sets covA as <65000>, checks wind exlusion button
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr370>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr370>
    And User makes payment with Credit Card for <mtr370>
    And User does auto renewal throught batch jobs <mtr370>
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to prior renewal date
    And User search for the renewed policy term
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal date and starts endorsement
    And User clicks Dwelling Chevron for <mtr370>
    And User unchecks wind exclusion
    And User finalizes transaction and validates updated changes messages on closeout screen for <mtr370>
    And User clicks process and close unnecessary tabs
    And User changes system date to renewal date
    And User search for the renewed policy term
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal date and starts endorsement
    And User clicks Dwelling Chevron for <mtr370>
    And User checks wind exclusion
    And User finalizes transaction and validates second updated changes messages on closeout screen for <mtr370>
    And User clicks process and close unnecessary tabs
    And User changes system date to after renewal date
    And User search for the renewed policy term
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal date and starts endorsement
    And User valites 'The effective date must not be older than 0 days from today' message has been displayed
    And User clicks Dwelling Chevron for <mtr370>
    And User unchecks wind exclusion
    And User finalizes transaction and validates third updated changes messages on closeout screen for <mtr370>
    And User takes note of the application for <mtr370>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to after renewal date
    And User searches for the application <mtr370>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User changes system date to after renewal date
    And User searches for the application <mtr370>
    And User process and completes endorsement and finishes test <mtr370>
    
    

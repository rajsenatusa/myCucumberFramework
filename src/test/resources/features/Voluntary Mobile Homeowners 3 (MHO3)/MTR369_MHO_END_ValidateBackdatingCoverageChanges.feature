#Author: Can Yavas
##created on 08/17/2023

## TEST CASE NUMBER & TITLE: TC 35185--MHO Agent NB END - Validate Backdating Coverage Changes Prior to, On, and Afer NB Effective Date
## PRECONDITIONS (IF ANY): Create MHO3 Subdivison Park policy effective on 08/21/21 E - Personal Liability* = $500,000
## Use Park - Sanctuary Cove, address 2308 Gold Finch Pl  32084 
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent endorse the policy prior to NB effective Date, On NB Effective Date, After NB Effective Date & UW Approval 
## EXPECTED RESULTS: Validate a change to coverage(s) with an Effective Date in the past fires the error
## Validate a change to coverage(s) with an Effective Date = todays date is allowed to Process
## Validate the UW can override and allow the Endorsement when submitted for approval    
## User: AG1730

@regression @mtr369 @mho3regression
Feature: TC 35185--MHO Agent NB END - Validate Backdating Coverage Changes Prior to, On, and Afer NB Effective Date

  Scenario: Validate a change to coverage(s) with an Effective Date in the past fires the error
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address for <mtr369>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <mtr369>
    And User enters all required information on MHO3 dwelling screen and sets covA as <65000>, personal liability <500000>
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr369>
    And User changes system date to current date minus <1> day
    And User searches for the policy <mtr369>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement
    And User clicks Dwelling Chevron for <mtr369>
    And User updates personal liability as <300000>
    And User finalizes transaction and validates updated changes messages on closeout screen for <mtr369>
    And User clicks process and close unnecessary tabs
    And User changes system date to current date
    And User searches for the policy <mtr369>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement
    And User clicks Dwelling Chevron for <mtr369>
    And User updates personal property rate as <%55>
    And User finalizes transaction and validates second updated changes messages on closeout screen <mtr369>
    And User clicks process and close unnecessary tabs
    And User changes system date to current date plus <1> day
    And User searches for the policy <mtr369>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement
    And User validates 'The effective date must not be older than 0 days from today' message has been displayed
    And User clicks Dwelling Chevron for <mtr369>
    And User updates personal liability as <500000> and completes test
    
    
    
    
    
    
    
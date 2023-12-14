#Author: Can Yavas
##created on 08/17/2023

##  TEST CASE NUMBER & TITLE: TC 35184--MHO Agent NB END - Validate Backdating Deductible Changes Prior to, On, and After NB Effective Date
## PRECONDITIONS (IF ANY): Change system date to 7/21/2021 then as Agent Create MHO3 - Adult Park policy effective on or after 8/21/2021 With AOP 
## Deductible at 2,500, HURR is 10%
## Agent and Underwriting Manager must have Change Date Roles
## Verify Underwriting Manager attribute "Allow Backdated Endorsement" = Yes
## Use Park - American Condominium Park(Zip 33541) 36323 Arbor Oaks Dr  33541
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent endorse the policy prior to NB effective Date, On NB Effective Date, 
## After NB Effective Date & UW Approval
  
## EXPECTED RESULTS: Validate a change to coverage(s) with an Effective Date in the past fires the error
## Validate a change to coverage(s) with an Effective Date = todays date is allowed to Process
## Validate the UW can override and allow the Endorsement when submitted for approval   
  
## User: AG1730

@regression @mtr368 @mho3regression
Feature: TC 35184--MHO Agent NB END - Validate Backdating Deductible Changes Prior to, On, and After NB Effective Date

  Scenario: Validate a change to coverage(s) with an Effective Date in the past fires the error
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type
    And User enters all required information on MHO3 dwelling screen and sets covA as <65000>, ded.perils as <2500>, ded.hurricane as <%10>
		And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr368>
    And User changes system date to current date minus <1> day
    And User searches for the policy <mtr368>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement
    And User clicks Dwelling Chevron for <mtr368>
    And User updates deductible perils as <1500> and ded hurricane as <%2>
    And User finalizes transaction and validates updated changes messages on closeout screen
    And User clicks process and close unnecessary tabs
    And User changes system date to current date
    And User searches for the policy <mtr368>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement
    And User clicks Dwelling Chevron for <mtr368>
    And User updates deductible perils as <2000> and ded hurricane as <%5>
    And User finalizes transaction and validates updated changes messages on closeout screen <2000> and <%5>
    And User clicks process and close unnecessary tabs
    And User changes system date to current date plus <1> day
    And User searches for the policy <mtr368>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement
    And User validates 'The effective date must not be older than 0 days from today' message has been displayed
    And User clicks Dwelling Chevron for <mtr368>
    And User updates deductible perils as <1500> and ded hurricane as <%2>
    And User clicks Policy Chevron and validates error messages
    And User finalizes transaction and validates updated changes messages on closeout screen for third endorsement
    And User takes note of the application for <mtr368>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to current date plus <1> day
    And User searches for the application <mtr368>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User changes system date to current date plus <1> day
    And User searches for the application <mtr368>
    And User process and completes endorsement and finishes test
    
    
    
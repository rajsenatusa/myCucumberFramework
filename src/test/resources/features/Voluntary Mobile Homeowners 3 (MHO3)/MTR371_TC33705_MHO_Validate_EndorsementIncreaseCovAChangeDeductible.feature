#Author: Can Yavas
##created on 08/18/2023

## TEST CASE NUMBER & TITLE: MTR-371--MHO Agent, END TX, Increase CovA, Change Deductible, UW Approval
## PRECONDITIONS (IF ANY): Active MHO Policy, Private Property, A-Dwelling Limit of $75000, AOP Deductible 2500, Deductible HURR 10%
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent, Endorse the policy to Increase CovA and change Deductibles   
## EXPECTED RESULTS: Underwriter  approval is required Approval messages trigger on CloseOut screen. Agent  must Submit for Approval
## User: AG1730

@regression @mtr371 @mho3regression
Feature: MTR-371--MHO Agent, END TX, Increase CovA, Change Deductible, UW Approval

  Scenario: Validate Underwriter approval is required Approval messages trigger on CloseOut screen and Agent  must Submit for Approval
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr371>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date <mtr371>
    And User enters all required information on MHO3 dwelling screen and sets covA as <75000>, ded.perils as <2500>, ded.hurricane as <%10>
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr371>
    And User changes system date to current date plus 31 days
    And User searches for the policy number <mtr371>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as currend date plus 31 days and starts endorsement
    And User clicks Policy Chevron
    And User changes entity type as joint and enters required information
    And User clicks Dwelling Chevron <mtr371>
    And User updates MHO3 dwelling screen and sets covA as <175000>, ded.perils as <500>, ded.hurricane as <500>
    And User finalizes transaction and validates updated changes messages on closeout screen for <mtr371>
    And User takes note of the application for <mtr371>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date plus 31 days
    And User searches for the last application number
    And User validates 'Change of Insured Name Must Be Approved' and 'Change to Coverage A Limit requires underwriting approval.' texts have been displayed
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User changes system date to current date plus 31 days
    And User searches for the last application number
    And User process and completes endorsement <mtr371>
    And User clicks Expand button and validates actual messages have been matched with expected and completes test 
    
    
    
    
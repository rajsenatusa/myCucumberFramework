#Author: Can Yavas
##created on 01/15/2024

## TEST CASE NUMBER & TITLE: MTR392--TO DP1: Validate Direct Bill Policy without Payment cancels on day 20
## PRECONDITIONS (IF ANY): Create TODP1 policy with following: System date = Current date NB effective date = current date - 10 days pay plan type = Direct bill/ Full pay
## Do not make payment on the policy
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  Login as Admin and search for the policy created in pre-condition
## Advance system date to match the next Action Date
## Run the daily jobs on a the policy
## Advance system date to match the next Action Date
## Run the daily jobs on a the policy 
  
## EXPECTED RESULTS: Cancellation of the policy occurs, 35 days after the policy effective date 
  
## User: Admin

@regression @mtr392 @todp1regression @gu
Feature: MTR392--TO DP1: Validate Direct Bill Policy without Payment cancels on day 20

  Scenario: Validate Direct Bill Policy without Payment cancels on day 20
 					
    Given User login to Spin as Admin Agent
    And User changes system date to current date <mtr392>
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr392>
		And User enters product selection information for TODP1 and effective date as current date minus 10 days <mtr392>
		And User enters all required information on TODP1 quote screen <mtr392>
		And User enters all required information on TODP1 dwelling screen <mtr392> and sets all perils ded <$2500>, hurricane ded <%10>, fire ded <$2500>
		And User enters all required information on TODP1 review screen
		And User creates TODP1 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks Dwelling Chevron for <mtr392>
    And User sets roof material as <3 Tab Composition Shingle>
    And User clicks review Chevron and selects payment plan
		And User finalizes transaction and issues takeout policy
    And User validates that TODP1 policy has been created successfully and takes note of the policy number <mtr392>
		And User clicks Billing Chevron
    And User validates Due Date, next action date and payment plan values
    And User run daily jobs forward policy <mtr392>
    And User searches for Policy Number for <mtr392>
    And User clicks History Chevron
    And User validates Cancellation notice has been generated
    And User clicks Billing Chevron
    And User validates Due Date, next action date and payment plan values after cancellation notice generated
    And User run daily jobs to second next action date and forward policy <mtr392>
    And User searches for Policy Number for <mtr392>
    And User clicks History Chevron
    Then User validates Cancellation has been generated and completes test
    
    
    
    
    
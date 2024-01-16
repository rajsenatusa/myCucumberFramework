#Author: Can Yavas
##created on 01/16/2024

## TEST CASE NUMBER & TITLE: MTR391--UMB Validate Direct Bill Full Payment Plan policy without payment, effective date is current date, cancels after 20 days
## PRECONDITIONS (IF ANY): Create a HO3 policy that is active 
## Create UMB - Umbrella Policy
## NB Policy current date =  effective date 
## Booked date/transaction date: Current date
## Inception date/Effective date: current date
## Direct Bill Full Pay
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  Login as Admin and search for the policy created in pre-condition
## Advance system date to match the next Action Date
## Run the daily jobs on a the policy
## Advance system date to match the next Action Date
## Run the daily jobs on a the policy 
  
## EXPECTED RESULTS: Cancellation Notice is generated, 20 days after the policy effective date
  
## User: Admin

@regression @mtr391 @umbregression @gu
Feature: MTR391--UMB Validate Direct Bill Full Payment Plan policy without payment, effective date is current date, cancels after 20 days

  Scenario: Validate Direct Bill Policy without Payment cancels on day 20
 					
    Given User login to Spin as Admin Agent
    And User changes system date to current date <mtr391>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr391>
		And User enters HO3 product selection information and current date as effective date
		And User enters all required information on HO3 quote screen <mtr391>
    And User enters all required information on HO3 dwelling screen <mtr391>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr391>
    And User clicks Finalize button <mtr391>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr391>
    And User clicks New Quote button and selects current date as effective date
    And User enters UMB product selection information
    And User enters producer code and answers previous policy written with AIIG questions
    And User enters all required information on UMB personal liability screen <mtr391>
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User adds underlying policy in personal liability chevron <mtr391>
    And User finalizes transaction 
    And User issues policy
    And User validates that UMB policy has been created successfully and takes note of the policy number <mtr391>
    And User clicks Billing Chevron
    And User validates Due Date, next action date and payment plan values <mtr391>
    And User run daily jobs forward policy <mtr391>
    And User searches for Policy Number for <mtr391>
    And User clicks History Chevron
    And User validates Cancellation notice has been generated <mtr391>
    And User clicks Billing Chevron
    And User validates Due Date, next action date and payment plan values after cancellation notice generated <mtr391>
    And User run daily jobs to second next action date and forward policy <mtr391>
    And User searches for Policy Number for <mtr391>
    And User clicks History Chevron
    Then User validates Cancellation has been generated and completes test <mtr391>
    
    
    
    
    
    
    
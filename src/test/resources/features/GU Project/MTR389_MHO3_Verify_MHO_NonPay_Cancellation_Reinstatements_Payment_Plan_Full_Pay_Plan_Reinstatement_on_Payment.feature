#Author: Can Yavas
##created on 01/17/2024

## TEST CASE NUMBER & TITLE: MTR389--VOL MHO3 Verify MHO- NonPay Cancellation/Reinstatements - Payment Plan - Full Pay Plan - Reinstatement on Payment
## PRECONDITIONS (IF ANY): Active MHO Policy created by the agent with Full Pay Plan
## Create UMB - Umbrella Policy
## NB Policy current date =  effective date 

  
## HIGH LEVEL STEPS OF TEST SCRIPT:  Login as Admin and search for the policy created in pre-condition
## Advance system date to match the next Action Date
## Run the daily jobs on a the policy
## Advance system date to match the next Action Date
## Run the daily jobs on a the policy 
  
## EXPECTED RESULTS: Reinstatement form is seen from the Forms List: Area = None Name = REINNOTICE Date = 11/14 Description = Reinstatement Notice Attached By = Mandatory
  
## User: Admin

@regression @mtr389 @mho3regression @gu 
Feature: MTR389--VOL MHO3 Verify MHO- NonPay Cancellation/Reinstatements - Payment Plan - Full Pay Plan - Reinstatement on Payment

  Scenario: Validate Reinstatement form is seen from the Forms List
 					
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr389>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address <mtr389>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type <mtr389>
    And User enters all required information on MHO3 dwelling screen and sets covA as <65000>, ded.perils as <2500>, ded.hurricane as <%10> <mtr389>
		And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <mtr389>
    And User signs out
    And User login to Spin as Admin Agent
    And User changes system date to current date <mtr389>
    And User searches for Policy Number for <mtr389>
    And User clicks Billing Chevron
    And User gets next action date and forward policy to next action date <mtr389>
    And User searches for Policy Number for <mtr389>
    And User clicks History Chevron
    And User validates Cancellation notice has been generated <mtr389>
   	And User clicks Billing Chevron
    And User takes note of the minimum amount to reinstate 
    And User clicks Make Payment and selects credit card and enters due amount for <mtr389>
    And User makes payment with Credit Card for <mtr389>
    And User searches for Policy Number for <mtr389>
    And User clicks Billing Chevron
    And User gets second next action date and forward policy to next action date <mtr389>
    And User searches for Policy Number for <mtr389>
    And User clicks History Chevron
    And User validates Reinstatement has been generated <mtr389>
    And User clicks Policy File Chevron <mtr389>
    Then User clicks Continuation of Coverage Link and validates form version and completes test <mtr389>
    
    
    
    
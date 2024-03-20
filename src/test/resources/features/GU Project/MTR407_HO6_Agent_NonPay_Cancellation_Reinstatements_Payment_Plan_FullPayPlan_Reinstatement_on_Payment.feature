##created on 03/14/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR407--HO6- Agent - NonPay Cancellation/Reinstatements - Payment Plan - Full Pay Plan - Reinstatement on Payment
## PRECONDITIONS (IF ANY): Active HO6  Policy - Non Payment
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create HO6 NB Policy with no pay
## 									 2. Renew policy to next term through batch jobs
## 									 3. After policy cancellation, renew one more term through batch jobs
##									 4. Validate policy reinstatement has been created	
## 									 4. Validate the correct Reinstatement form is attaching. 
  
## EXPECTED RESULTS: Policy is Cancelled & and reinstated and correct Reinstatement form is attaching to Policy File  
  
## User: Admin, Standard Agent (AG1730A1)


@regression @mtr407 @ho6regression @gu
Feature: MTR407--HO6- Agent - NonPay Cancellation/Reinstatements - Payment Plan - Full Pay Plan - Reinstatement on Payment

  Scenario: Validate that Policy is Cancelled & and reinstated and correct Reinstatement form is attaching to Policy File   
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr407>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr407>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <mtr407>
    And User enters all required information on HO6 dwelling screen and enters <15.000> for CovC <mtr407>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <mtr407>
    And User checks application dwelling screen and finalizes transaction <mtr407>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number <mtr407>
    And User signs out
    And User login to Spin as Admin Agent
    And User changes system date to current date <mtr407>
    And User searches for Policy Number for <mtr407>
    And User clicks Billing Chevron
    And User takes note of the next action date and run daily jobs <mtr407>
    And User searches for Policy Number for <mtr407>
    And User clicks History Chevron
    And User validates Cancellation notice has been generated <mtr407>
    And User clicks Billing Chevron
    And User takes note of the second next action date and changes system date to second next action date and run daily jobs <mtr407>
    And User searches for Policy Number for <mtr407>
    And User validates Cancellation has been generated <mtr407>
    And User clicks Billing Chevron
    And User takes note of the minimum amount to reinstate <mtr407>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr407>
    And User makes payment with Credit Card for <mtr407>
    And User searches for Policy Number for <mtr407>
    And User clicks Billing Chevron
    And User forward policy to second next action date <mtr407>
    And User searches for Policy Number for <mtr407>
    And User clicks History Chevron
    And User validates Reinstatement has been generated <mtr407>
    And User clicks Policy File Chevron <mtr407>
    Then User clicks Continuation of Coverage Link and validates form version and completes test <mtr407>
    
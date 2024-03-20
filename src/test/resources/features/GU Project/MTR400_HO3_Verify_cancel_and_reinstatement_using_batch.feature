##created on 03/18/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR400--HO3- Verify cancel and reinstatement using batch
## PRECONDITIONS (IF ANY): Active HO3  Policy - Non Payment
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create HO3 NB Policy with no pay
## 									 2. Navigate to Billing Tab of the policy and note down the Next Action Date.
##									 3. Run Daily Manual Jobs and observe cancellation notice
##									 4. Navigate to Billing Tab of the policy and note down the Next Action Date.
##									 5. Run Daily Manual Jobs and observe cancellation
## 									 6. After policy cancellation, note minimum amount to reinstate, make payment that amount
##									 7. Run Daily Manual Jobs and observe reinstatment
##									 8. Validate policy reinstatement has been created	
## 									 9. Validate the correct Reinstatement form is attaching. 
  
## EXPECTED RESULTS: Policy is Cancelled & and reinstated and correct Reinstatement form is attaching to Policy File  
  
## User: Admin, Standard Agent (AG1730A1)


@regression @mtr400 @ho3regression @gu
Feature: MTR400--HO3- Verify cancel and reinstatement using batch

  Scenario: Validate that Policy is Cancelled & and reinstated and correct Reinstatement form is attaching to Policy File   
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr400>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr400>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr400>
    And User enters all required information on HO3 dwelling screen <mtr400>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr400>
    And User clicks Finalize button <mtr400>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr400>
    And User signs out
    And User login to Spin as Admin Agent
    And User changes system date to current date <mtr400>
    And User searches for the policy number <mtr400>
    And User clicks Billing Chevron
    And User takes note of the next action date and run daily jobs <mtr400>
    And User searches for the policy number <mtr400>
    And User clicks History Chevron
    And User validates Cancellation notice has been generated <mtr400>
    And User clicks Billing Chevron
    And User takes note of the second next action date and changes system date to second next action date and run daily jobs <mtr400>
    And User searches for the policy number <mtr400>
    And User validates Cancellation has been generated <mtr400>
    And User clicks Billing Chevron
    And User takes note of the minimum amount to reinstate <mtr400>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr400>
    And User makes payment with Credit Card for <mtr400>
    And User searches for the policy number <mtr400>
    And User clicks Billing Chevron
    And User forward policy to second next action date <mtr400>
    And User searches for the policy number <mtr400>
    And User clicks History Chevron
    And User validates Reinstatement has been generated <mtr400>
    And User clicks Policy File Chevron <mtr400>
    Then User clicks Continuation of Coverage Link and validates form version and completes test <mtr400>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
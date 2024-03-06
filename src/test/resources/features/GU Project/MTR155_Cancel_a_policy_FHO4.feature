## Author: Can Yavas
## created on 02/14/2024

## TEST CASE NUMBER & TITLE: MTR155--VOL HO4, Verify Underwriter is able to Cancel policy  Non-Pay & Pro-rate
## PRECONDITIONS (IF ANY): VOL HO4 NB 
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into SPIN as Underwriter
## 2.Enter policy number in Search field
## 3.Select Start Transaction from Actions tile
## 4.Select Cancellation
## EXPECTED RESULTS: Cancellation should process  

## User: jbarnes, AG1730A1 


@regression @mtr155 @gu
Feature: MTR155--VOL HO4, Verify Underwriter is able to Cancel policy  Non-Pay & Pro-rate

  Scenario: Validate Cancellation should process with UW user

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr155>
    And User enters HO4 product selection information and effective date as current date
    And User enters all required information on HO4 quote screen with current date as prior policy date <mtr155>
    And User enters all required information on HO4 dwelling screen <mtr155>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that HO4 policy has been created successfully
    And User takes note of the policy number for <mtr155>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for Policy Number for <mtr155>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Non-Pay <mtr155>
    And User selects Non-Payment of Premium as reason <mtr155>
    And User sets eff date current date minus 1 day and validates error message <mtr155>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Non-Pay <mtr155>
    And User selects Non-Payment of Premium as reason <mtr155>
    And User selects pro rate as cancel type and process transaction <mtr155>
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User validates Policy Status displayed as Cancelled <mtr155>
    And User clicks Policy File Chevron <mtr155>
    Then User validates Cancellation Confirmation form listed and validates form <mtr155>
    
    
    
    
    
    
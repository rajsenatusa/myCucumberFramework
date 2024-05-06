## Author: Can Yavas
## created on 02/12/2024

## TEST CASE NUMBER & TITLE: MTR167--SC HO3, Verify Underwriter is able to Cancel policy Non-Pay & Flat rate
## PRECONDITIONS (IF ANY): VOL SC HO3 NB 
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into SPIN as Underwriter
## 2.Enter policy number in Search field
## 3.Select Start Transaction from Actions tile
## 4.Select Cancellation
## EXPECTED RESULTS: Cancellation should process  

## User: Admin, AG1777A1 


@regression @mtr167 @scregression @gu 
Feature: MTR167--SC HO3, Verify Underwriter is able to Cancel policy Non-Pay & Flat rate

  Scenario: Validate Cancellation should process with UW user

    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen <mtr167>
    And User enters SC HO3 product selection information and current date as effective date <mtr167>
    And User enters all required information on SC HO3 quote screen <mtr167>
    And User enters all required information on SC HO3 dwelling screen <mtr167>
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr167>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr167>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Non-Pay <mtr167>
    And User selects Non-Payment of Premium due to NSF as reason <mtr167>
    And User sets eff date current date minus 1 day and validates error message <mtr167>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Non-Pay <mtr167>
    And User selects Non-Payment of Premium due to NSF as reason <mtr167> 
    And User selects flat as cancel type and process transaction <mtr167>
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User validates Policy Status displayed as Cancelled <mtr167>
    And User clicks Policy File Chevron <mtr167>
    Then User validates Cancellation Confirmation form listed and validates form <mtr167>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
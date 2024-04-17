## Author: Can Yavas
## created on 01/08/2024

## TEST CASE NUMBER & TITLE: MTR583--SC HO3, Verify Underwriter is able to Non-Renew policy
## PRECONDITIONS (IF ANY): VOL SC HO3 NB 
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into SPIN as Underwriter
## 2.Enter policy number in Search field
## 3.Select Start Transaction from Actions tile
## 4.Select Non-Renewal
## EXPECTED RESULTS: Non-Renewal should process  

## User: Admin 


@regression @mtr583 @scregression @gu 
Feature: MTR583--SC HO3, Verify Underwriter is able to Non-Renew policy

  Scenario: Validate Non-Renewal should process with UW user

    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen <mtr583>
    And User enters SC HO3 product selection information and current date as effective date
    And User enters all required information on SC HO3 quote screen <mtr583>
    And User enters all required information on SC HO3 dwelling screen <mtr583>
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr583>
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the policy number <mtr583>
    And User clicks Start Transaction
    And User selects Non Renewal
    And User selects Roof Disrepair as reason and starts non renewal
    Then User process transaction and clicks plus sign and validates UW reason message has been displayed and completes test
    
    
    
    
    
    
    
    
    
    
    
    
    
    
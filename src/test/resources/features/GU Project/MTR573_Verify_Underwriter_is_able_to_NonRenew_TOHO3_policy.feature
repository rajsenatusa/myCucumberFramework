## Author: Can Yavas
## created on 02/15/2024

## TEST CASE NUMBER & TITLE: MTR573--TO HO3, Verify Underwriter is able to Non-Renew policy
## MTR574-Verify Non-Renewal Notice is available in Policy File
## PRECONDITIONS (IF ANY): TO HO3 NB 
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into SPIN as Underwriter
## 2.Enter policy number in Search field
## 3.Select Start Transaction from Actions tile
## 4.Select Non Renewal
## EXPECTED RESULTS: Non Renewal should process  

## User: underwriter1, Admin 
## This test covers MTR-573 and MTR-574


@regression @mtr573
Feature: MTR573-MTR574-TO HO3, Verify Underwriter is able to Non-Renew policy

  Scenario: Validate Non Renewal should process with UW user

    Given User login to Spin as Admin Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr573>
    And User enters product selection information for TOHO3 and sets effective date as current date
    And User enters all required information on TOHO3 quote screen <mtr573>
    And User enters all required information on TOHO3 dwelling screen <mtr573>
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects dwelling type and roof material
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr573>
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date plus 1 day <mtr573>
    And User searches for the policy number <mtr573>
    And User clicks Start Transaction
    And User selects Non Renewal 
    And User selects Material misrepresentation in obtaining the policy as Reason
    And User completes non renewal transaction <mtr573>
    And User validates Policy Status displayed as Non Renewed <mtr573>
    And User clicks Policy File Chevron <mtr573>
    Then User validates Non Renewal Notice form listed and validates form <mtr573>
    
    
    
    
    
    
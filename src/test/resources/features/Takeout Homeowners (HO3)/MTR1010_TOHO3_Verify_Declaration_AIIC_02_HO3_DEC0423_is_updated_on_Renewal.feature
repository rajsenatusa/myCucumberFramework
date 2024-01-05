## Author: Can Yavas
## created on 01/03/2024

## TEST CASE NUMBER & TITLE: MTR1010--TOHO3, Verify Declaration AIIC 02 HO3 DEC 04 23 is updated on - Renewal Effective on 06/18/2023
## PRECONDITIONS (IF ANY): TOHO3 policy effective 06/18/2022;add additional interest
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into the Spin as an Admin and search for policy from Pre-ConditionsRenew to next  term
## 2.Verify the Flood language on Page 3
## 3.Validate counter signature is added
## 4.Open the Additional Interest Dec Package and verify the new flood language and counter signature is matching with the clean copy
## 5.Declaration should be present and FORM content and formatting match clean copies attached to the US 
## EXPECTED RESULTS: FORM content and formatting match clean copies attached to the AIIC 02 HO3 DEC 04 23 displays on  bottom of all pages
## counter signature should be  added and should match with clean copy
  
## User: Admin


@regression @mtr1010 @toho3regression @gwu
Feature: MTR1010--TOHO3, Verify Declaration AIIC 02 HO3 DEC 04 23 is updated on - Renewal Effective on 06/18/2023

  Scenario: Validate FORM content and formatting match clean copies attached to the AIIC 02 HO3 DEC 04 23 displays on  bottom of all pages

    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr1010>
    And User enters TOHO3 product selection information and effective date as current date minus 1 year
    And User enters all required information on TOHO3 quote screen <mtr1010>
    And User enters all required information on TOHO3 dwelling screen <mtr1010>
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks Additional Interest Chevron
    And User clicks Add Additional Interest button
    And User completes required information on add additional interests screen and add additional insured <mtr1010>
    And User clicks dwelling chevron and selects dwelling type and roof material
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr1010>
    And User searches for the policy number <mtr1010>
    And User clicks Start Transaction
    And User selects Renewal
    And User does manual renewal on the policy <mtr1010>
    And User clicks Policy File Chevron
    And User clicks Renewal Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package
    And User validates Counter Signature has been added on Renewal Declaration Package
    And User validates correct Additional Interest Information has been added on Renewal Declaration Package
    And User searches for Renewed Policy Number for <mtr1010>
    And User clicks Start Transaction
    And User selects Renewal
    And User does second manual renewal on the policy <mtr1010>
    And User clicks Policy File Chevron
    Then User clicks Second Renewal Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package and completes test
    
    
    
    
    
    
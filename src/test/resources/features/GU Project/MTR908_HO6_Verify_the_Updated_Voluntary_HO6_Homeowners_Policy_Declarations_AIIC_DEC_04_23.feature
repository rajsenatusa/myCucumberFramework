## Author: Can Yavas
## created on 01/03/2024

## TEST CASE NUMBER & TITLE: MTR908--HO6, Verify Declaration AIIC 02 HO3 DEC 04 23 is updated on - Renewal Effective on 06/18/2023
## PRECONDITIONS (IF ANY): VOL HO6 NB eff  06/18/2022 and no flood insurance
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into the Spin as an Admin and search for policy from Pre-Conditions
## 2.Renew to 02 term
## 3.Pull up the policy and go to the Policy file
## 4.View the Renewal Declaration page
## EXPECTED RESULTS: AIIC DEC 04 23 displays on bottom of all pages  
##FORM content and formatting match clean copies attached to the US
##Form prints in the correct order as per FL HO6 Forms Matrix
  
## User: Admin 


@regression @mtr908 @ho6regression @gu
Feature: MTR908--HO6, Verify Declaration AIIC 02 HO3 DEC 04 23 is updated on - Renewal Effective on 06/18/2023

  Scenario: Validate FORM content and formatting match clean copies attached to the US AIIC 02 HO3 DEC 04 23 displays on  bottom of all pages

    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr908>
    And User enters HO6 product selection information and current date minus 1 year as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <mtr908>
    And User enters all required information on HO6 dwelling screen and enters <35.000> for CovC <mtr908>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <mtr908>
    And User checks application dwelling screen and finalizes transaction <mtr908>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number <mtr908>
    And User searches for the policy number <mtr908>
    And User clicks Start Transaction
    And User selects Renewal
    And User does manual renewal on the policy <mtr908>
    And User clicks Policy File Chevron <mtr908>
    Then User clicks Renewal Declaration Link and validates AIIC 02 HO3 DEC 04 23 form version listed in the package <mtr908> and completes test
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
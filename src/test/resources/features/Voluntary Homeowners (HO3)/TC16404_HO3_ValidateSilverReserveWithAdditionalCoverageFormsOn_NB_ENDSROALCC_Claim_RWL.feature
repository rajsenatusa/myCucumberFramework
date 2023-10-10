## created on 10/10/2023 by Can Yavas
 
## TEST CASE NUMBER & TITLE: TC 16404--HO3 UW NB END (SRO & ALCC) Claim RN(2) Forms Silver Reserve with all additional Optional coverages
## PRECONDITIONS (IF ANY)
## HIGH LEVEL STEPS OF TEST SCRIPT:  Select Silver reserve coverage on new business by including all additional/ optional coverages,
##  								add Assisting living care & Structured rented to others coverages over endorsement transaction, 
## 									Create a claim on the policy and perform renewal
## EXPECTED RESULTS: All forms will be verified in the following states: 
## New Business
## Endorsement
## Claims
## Renewal transactions
  
## User: JLOWE

@regression @tc16404
Feature: TC 16404--HO3 UW NB END (SRO & ALCC) Claim RN(2) Forms Silver Reserve with all additional Optional coverages

  Scenario: Validate All forms will be verified in the following states
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16404>
    And User enters HO3 product selection information and new business date as effective date <tc16404>
		And User enters all required information on HO3 quote screen <tc16404>
		And User enters all required information on HO3 dwelling screen and selects silver reserve and add additional coverages <tc16404>
    And User enters all required information on HO3 review screen
    And User clicks Print button on quote and validates quote form version
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron and updates years updated sections <tc16404>
    And User clicks Finalize button <tc16404>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <tc16404>
    And User clicks Forms Chevron <tc16404>
    And User validates all expected forms to be listed 
    
    
    
    
## Author: Can Yavas
## created on 01/10/2024

## TEST CASE NUMBER & TITLE: MTR398--SC HO3, Verify the SC-HO3-NB Policy is cancelled (Transaction) and reinstate after cancellation
## PRECONDITIONS (IF ANY): SC-HO3 policy with Full pay and proper Email id
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Search for Policy from Preconditions
## 2.Select "Cancellation" as Transaction
## 3.Finalize transaction & Process
## 4.Start Transaction to Reinstate
## 5.1.Navigate to Forms tab & validate Reinstatement Notice form(REINNOTICE) is displayed.2.Click View form link.

## EXPECTED RESULTS: 1.Correct Reinstatement form is attached and Form number displays correctly -AIIC RI 11 14 
## 2.Verify that form content displays 
## Date of Reinstatment.
## "Your policy has been reinstated as of the Reinstatement Date shown above without interruption of coverage since underwriting reason(s) met.

## User: Standard Agent 


@regression @mtr398 @scregression @gu
Feature: MTR398--SC HO3, Verify the SC-HO3-NB Policy is cancelled (Transaction) and reinstate after cancellation

  Scenario: Validate Correct Reinstatement form is attached and Form number displays correctly AIIC RI 11 14 

    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen <mtr398>
    And User enters SC HO3 product selection information and current date as effective date
    And User enters all required information on SC HO3 quote screen <mtr398>
    And User enters all required information on SC HO3 dwelling screen <mtr398>
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy and makes payment with credit card
    And User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr398>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr398>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Company
    And User selects Other in risk as reason <mtr398>
    And User selects effective date as cancel date 'current date plus 30 days' <mtr398>
    And User selects pro rate as cancel type and process transaction <mtr398>
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User clicks Start Transaction
    And User selects Reinstatement
    And User completes and process reinstatement transaction
    And User clicks Forms Chevron
    And User validates <AIIC RI 11 14> form is visible on <mtr398>
		Then User clicks Rein Notice Form and validates form details as expected
    And User clicks Policy File Chevron <mtr398>
    And User clicks Continuation of Coverage link and validates AIIC RI 11 14 form version listed in the package <mtr398>
    
    
    
    
    
     
    
    
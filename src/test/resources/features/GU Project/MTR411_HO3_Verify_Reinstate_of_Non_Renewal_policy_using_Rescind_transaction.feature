#Author: Can Yavas
##created on 03/15/2024

##TEST CASE NUMBER & TITLE: MTR411--HO3 Verify Reinstate of Non Renewal policy using Rescind transaction
##PRECONDITIONS (IF ANY): Active HO3 NB Policy 
## HIGH LEVEL STEPS OF TEST SCRIPT:  1.Search Renewed GOC NB Policy as UW Manager.
									 ## 2.Do Endorsement
									 ## 3.Do Non Renewal 
									 ## 4.Do Non RenewalRequest Stop
									 ## 5.Validate Rescission of Non Renewal form is generated
									 
## EXPECTED RESULTS: Policy showing new transaction as Non Renewal Request Stop tx


@regression @mtr411 @ho3cregression @gu
Feature: MTR411--HO3 Verify Reinstate of Non Renewal policy using Rescind transaction

  Scenario: Validate Policy showing new transaction as Non Renewal Request Stop tx
  
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr411>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr411>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr411>
    And User enters all required information on HO3 dwelling screen <mtr411>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr411>
    And User clicks Finalize button <mtr411>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr411>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to current date <mtr411>
    And User searches for the policy number <mtr411>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr411>
    And User makes payment with Credit Card for <mtr411>
    And User searches for the policy number <mtr411>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr411>
    And User clicks Dwelling Chevron and change reserve package from basic to silver <mtr411>
    And User finalizes transaction and completes endorsement and close unnecessary tabs <mtr411>
    And User clicks Start Transaction
    And User selects Non Renewal
    And User selects 'Failure to comply with underwriting requirements' as reason and 'An acceptable 4 point inspection was not provided' as a sub reason <mtr411>
    And User clicks Process
    And User validates Non_Renewal transaction for HO3 policy has been created successfully <mtr411>
    And User clicks Start Transaction
    And User selects Non Renewal Rescind
    And User clicks Start button and process non renewal rescind transaction <mtr411>
    Then User validates Non_Renewal Rescind transaction for HO3 policy has been created successfully <mtr411>
    And User clicks Policy File Chevron <mtr411>
    And User clicks Rescission of Non-Renewal Notice Link and validates form version and completes test <mtr411>
    
    
    
    
    
    
    
    
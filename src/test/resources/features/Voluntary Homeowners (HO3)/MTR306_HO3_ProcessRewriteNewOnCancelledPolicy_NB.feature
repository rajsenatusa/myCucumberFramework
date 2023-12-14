##created on 09/19/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR-306 : HO3-As an Client Service Agent I would like the ability to process a rewrite-New on Cancelled NB policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## EXPECTED RESULTS: HO3 NB Policy is cancelled and UW can able to rewrite the cancelled Policy
  
## User:AG1730

@regression @mtr306 @ho3regression
Feature: MTR-306 : HO3-As an Client Service Agent I would like the ability to process a rewrite-New on Cancelled NB policy

  Scenario: Validate HO3 NB Policy is cancelled and UW can able to rewrite the cancelled Policy
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr306>
		And User enters HO3 product selection information and current date as effective date
		And User enters all required information on HO3 quote screen <mtr306>
    And User enters all required information on HO3 dwelling screen <mtr306>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr306>
    And User clicks Finalize button <mtr306>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr306>
    And User clicks Start Transaction
    And User clicks Cancellation Transaction Selection
    And User selects Cancellation Type as Insured
    And User selects Cancel Rewrite as reason
    And User selects effective date as cancel date as current date
    And User process cancellation transaction
    And User completes cancellation transaction and validates policy transaction status as cancelled <mtr306>
    And User clicks Start Transaction
    And User clicks Rewrite New Transaction Selection
    And User clicks Dwelling Chevron <mtr306>
    And User sets cyber home protection as <25000>
    And User clicks Review Chevron
    And User enters all required information on HO3 review screen
    And User clicks Finalize button <mtr306>
    And User completes rewrite new transaction
    And User clicks Forms Chevron <mtr306>
    And User validates greeting letter in the forms 
    And User clicks Dwelling Chevron <mtr306>
    Then User validates Home Cyber Protection field is disabled and completes test
    
    
    
    
    
    
    
    
    
    
    
    
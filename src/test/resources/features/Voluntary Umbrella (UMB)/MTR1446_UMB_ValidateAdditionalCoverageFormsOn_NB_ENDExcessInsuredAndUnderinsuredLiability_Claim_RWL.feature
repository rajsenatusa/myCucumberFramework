#Author: Can Yavas
##created on 08/23/2023

## TEST CASE NUMBER & TITLE: TC 16602--UMB UWMgr NB End (add Excess Uninsured and Underinsured Liability Limit) RN (2) and Claim Forms
## PRECONDITIONS (IF ANY)
## HIGH LEVEL STEPS OF TEST SCRIPT:  Create Umbrella new business by including all additional/ optional coverages,
##  								add Excess Uninsured and Underinsured Liability Limit coverage over endorsement transaction, 
## 									Create a claim on the policy and perform renewal
## EXPECTED RESULTS: All forms will be verified in the following states: 
## New Business
## Endorsement
## Claims
## Renewal transactions

@regression @mtr1446
Feature: TC 16602--UMB UWMgr NB End (add Excess Uninsured and Underinsured Liability Limit) RN (2) and Claim Forms

  Scenario: Validate All forms will be verified in the following states: New Business, Endorsement, Claims, Renewal transactions
  
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO4 product selection information and current date as effective date
    And User enters all required information on HO4 quote screen
    And User enters all required information on HO4 dwelling screen
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy and makes payment
    And User validates that HO4 policy has been created successfully and takes note of the policy number
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr1446>
    And User clicks New Quote button and selects current date as effective date
    And User enters UMB product selection information
    And User enters producer code and answers previous policy written with AIIG questions
    And User enters all required information on UMB personal liability screen <mtr1446>
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User adds underlying policy in personal liability chevron
    And User finalizes transaction 
    And User issues policy
    And User validates that UMB policy has been created successfully and takes note of the policy number
    And User searches for the umbrella policy number <mtr1446>
    And User clicks Forms Chevron and validates all expected forms has been displayed
    And User clicks every link of the forms and validates all forms content have been as expected
    And User clicks Policy File Chevron <mtr1446>
    And User clicks Personal Umbrella Application Link and validates form versions
    And User clicks Policy File Chevron <mtr1446>
    And User clicks Declaration Link and validates form versions
    And User clicks Policy File Chevron <mtr1446>
    And User clicks NB Package Link and validates form versions
    And User searches for the umbrella policy number <mtr1446>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date plus <30> days and starts endorsement
    And User clicks Personal Umbrella Liability Chevron
    And User selects Excess Uninsured Liability Limit as <1.000.000>
    And User finalizes transaction and completes endorsement and close unnecessary tabs
    And User clicks Forms Chevron and validates all expected forms has been displayed
    And User clicks every link of the endorsement forms and validates all forms content have been as expected
    And User clicks Policy File Chevron <mtr1446>
    And User clicks Endorsement Package Link and validates form versions
    And User signs out
    And User login to Spin as Claim CSR
    And User changes system date to claim date 'current date plus 60 days'
    And User searches for the umbrella policy number <mtr1446>
    And User clicks Report Loss
    And User sets loss date as claim date
    And User selects loss cause as 'Bodily Injury' and clicks Save
    And User completes all required information on claim chevron <mtr1446>
    And User clicks New Claimant And adds required information <mtr1446>
    And User clicks More button and Starts Transaction
    And User clicks newly added claimant and adjusts reserves
    And User finalizes claim and process transaction
    And User clicks Forms Chevron and validates all expected forms has been displayed
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the umbrella policy number <mtr1446>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr1446>
    And User makes payment with Credit Card for <mtr1446>
    And User searches for the umbrella policy number <mtr1446>
    And User clicks Start Transaction
    And User selects Renewal
    And User does manual renewal on the policy
    And User searches renewed policy
    And User clicks Forms Chevron and validates all expected forms has been displayed
    And User clicks every link of the renewal forms and validates all forms content have been as expected
    And User clicks Policy File Chevron <mtr1446>
    And User clicks Renewal Declaration Link and validates form versions
    And User clicks Make Payment second time and selects credit card and enters due amount for <mtr1446>
    And User makes payment with Credit Card second time for <mtr1446>
    And User searches renewed policy
    And User clicks Start Transaction
    And User selects Renewal
    And User does second manual renewal on the policy
    And User searches secondly renewed policy
    And User clicks Forms Chevron and validates all expected forms has been displayed
    And User clicks every link of the second renewal forms and validates all forms content have been as expected
    And User clicks Policy File Chevron <mtr1446>
    Then User clicks second Renewal Declaration Link and validates form versions and completes test
    
    
    
    
    
    
    
    
    

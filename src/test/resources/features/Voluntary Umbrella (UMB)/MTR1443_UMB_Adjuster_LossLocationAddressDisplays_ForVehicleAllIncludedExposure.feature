#Author: Can Yavas
##created on 08/28/2023

## HIGH LEVEL STEPS OF TEST SCRIPT:  Confirm that when the loss location is Watercraft and that that Umbrella dwelling address 
## prefills in the  Property Information Description, City State and Zip
  
## EXPECTED RESULTS: Loss location address populated with umbrella policy address 
 
## User: Tbrean
  
@regression @mtr1443 @umbregression 
Feature: TC 35144--UMB Validate Adjuster can create Claim for loss location as 'Vehicle and all included exposures'

  Scenario: Validate Loss location address populated with umbrella policy address
    Given User login to Spin as Admin Agent
  	When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr1443>
		And User enters UMB product selection information and current date as effective date
    And User enters producer code and answers previous policy written with AIIG questions <mtr1443>
    And User enters all required information on UMB personal liability screen <mtr1443>
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User adds underlying policy in personal liability chevron <mtr1443>
    And User clicks Personal Umbrella Liability Chevron
    And User adds exposure to underlying auto policy
    And User clicks Personal Umbrella Liability Chevron
    And User clicks Next button and add driver information
    And User finalizes transaction 
    And User issues policy
    And User validates that UMB policy has been created successfully and takes note of the policy number <mtr1443>
    And User signs out
    And User login to Spin as Adjuster
    And User changes system date to loss date 'current date plus 10 days' <mtr1443>
    And User searches for the umbrella policy number <mtr1443>
    And User clicks Report Loss
    And User sets loss date as loss date <mtr1443>
    And User selects loss cause as 'Bodily Injury' and clicks Save
    And User completes all required information on claim chevron <mtr1443>
    And User scrolls Property Information Field and validates entered information on UMB policy has been displayed
    And User clicks New Claimant And adds required information <mtr1443>
    And User clicks More button and Starts Transaction
    And User clicks newly added claimant and adjusts reserves <mtr1443>
    And User finalizes claim and process transaction
    And User clicks Policy File Chevron <mtr1443>
    Then User clicks 'Acknowledment Letter' and validates form version <mtr1443>
    And User clicks Claim Tab
    And User clicks More button and Starts Transaction
    And User clicks Financial Actions Button
    And User clicks Deny
    And User checks Deny Personal Umbrella Liability selection and enters loss date <mtr1443>
    And User clicks Deny button and validates 'Open - Denied' label is visible 
    And User finalizes transaction and process and complete test
    
    
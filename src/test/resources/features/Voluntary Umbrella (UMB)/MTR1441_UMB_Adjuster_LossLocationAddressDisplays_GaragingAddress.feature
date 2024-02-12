#Author: Can Yavas
##created on 08/25/2023

## TEST CASE NUMBER & TITLE: TC 35148--UMB Validate Adjuster can create Claim for loss location as 'Recreational vehicle' for different garaging address   
## PRECONDITIONS (IF ANY): Active GOC policy 
## HIGH LEVEL STEPS OF TEST SCRIPT:  Confirm that when the loss location is Watercraft and that that Umbrella dwelling address 
## prefills in the  Property Information Description, City State and Zip
  
## EXPECTED RESULTS: Loss location address populated garaging address 

@regression @mtr1441 @umbregression
Feature: TC 35148--UMB Validate Adjuster can create Claim for loss location as 'Recreational vehicle' for different garaging address

  Scenario: Validate All forms will be verified in the following states: New Business, Endorsement, Claims, Renewal transactions
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr1441>
    And User enters GOC product selection information and current date as effective date <mtr1441>
    And User enters Producer
    And User enters all required information on GOC quote screen
    And User enters all required information on GOC golfcart screen for <mtr1441>
    And User enters driver information on driver screen <mtr1441>
    And User enters vehicles information on vehicles screen <mtr1441>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User issues policy and makes payment <mtr1441>
    And User validates that GOC policy has been created successfully and takes note of the policy number <mtr1441>
    And User clicks New Quote button and selects current date as effective date
    And User enters UMB product selection information
    And User enters producer code and answers previous policy written with AIIG questions
    And User enters all required information on UMB personal liability screen <mtr1441>
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User adds underlying policy in personal liability chevron <mtr1441>
    And User finalizes transaction 
    And User issues policy
    And User validates that UMB policy has been created successfully and takes note of the policy number <mtr1441>
    And User signs out
    And User login to Spin as Adjuster
    And User changes system date to loss date 'current date plus 10 days'
    And User searches for the umbrella policy number <mtr1441>
    And User clicks Report Loss
    And User sets loss date as loss date
    And User selects loss cause as 'Bodily Injury' and clicks Save
    And User completes all required information on claim chevron <mtr1441>
    And User scrolls Property Information Field and validates entered information on GOC policy has been displayed
    And User clicks New Claimant And adds required information <mtr1441>
    And User clicks More button and Starts Transaction
    And User clicks newly added claimant and adjusts reserves
    And User finalizes claim and process transaction
    And User clicks Policy File Chevron <mtr1441>
    Then User clicks 'Acknowledment Letter' and validates form version
    And User clicks Claim Tab
    And User clicks More button and Starts Transaction
    And User clicks Financial Actions Button
    And User clicks Deny
    And User checks Deny Personal Umbrella Liability selection and enters loss date
    And User clicks Deny button and validates 'Open - Denied' label is visible 
    And User finalizes transaction and process and complete test
    
    
    
    
    
    

##created on 10/06/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR2467--GOC Adj NB, Claims UI Validations 'Vendor Preferred Payment Method Prefills on Payments"
## PRECONDITIONS (IF ANY): 1. Active GOC policy with an open claim 
## 2. Known Vendor#1 with Vendor payment Preference  = Check
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## EXPECTED RESULTS: 1. Confirm that when a payment is made to only a Vendor that the Payment Method prefills with the Vendors Payment Preference.
## 2. Confirm that no users can update the Payment Method on the claim payment screen
## 3. Confirm that if the Vendors payment method is updated in the provider profile it reflects correctly the next time a claim payment is made to that provider. 
## 4. Confirm that when the payment was to a vendor only and a Claimant or a Interest is added to the Payee Select the Payment Method is no longer pre-selected and greyed
## 5. Confirm that when the payment was to a Insured and a vendor is added the Payment Method remains selectable.
## 6. Confirm that when any of the other Payment Types are used and a Vendor is selected that the Payment Method does not grey out Return Indemnity, Return Expense, Return Recovery
 
## User: Gallopadmin


@regression @mtr2467
Feature: MTR2467--GOC Adj NB, Claims UI Validations 'Vendor Preferred Payment Method Prefills on Payments'

  Scenario: Validate that when a payment is made to only a Vendor that the Payment Method prefills with the Vendors Payment Preference
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr2467>
    And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen <mtr2467>
    And User enters all required information on GOC golfcart screen for <mtr2467>
    And User enters driver information on driver screen <mtr2467>
    And User enters vehicles information on vehicles screen <mtr2467>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that GOC policy has been created successfully and takes note of the policy number <mtr2467>
    And User changes system date to current date plus 10 days
    And User searches for Policy Number for <mtr2467>
    And User clicks Report Loss
    And User sets loss date as current date plus <10> days
    And User selects loss cause as Collapse and clicks Save
    And User selects vehicle, purpose of use and all required information on claim screen
    And User clicks Complete and takes note of the claim number <mtr2467>
    And User starts transaction
    And User clicks Financial Actions button and clicks Adjust Reserves
    And User fills Indemnity and Adjust text boxes
    And User finalizes adjust transaction and process
    And User starts transaction
    And User clicks Financial Actions button and clicks Make Payment
    And User selects Indemnity payment and do necessary validations
    And User selects Adjustment payment and do necessary validations
    And User selects Return Indemnity payment and do necessary validations
    And User selects Return Recovery payment and do necessary validations
    Then User selects Return Adjustment payment and do necessary validations
    
    
    
    
    
    
    
    
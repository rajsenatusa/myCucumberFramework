## created on 04/25/2024 by Can Yavas
 
## Title: MTR347-GOC Underwriter to Override the vendor data - Golf Cart
## Preconditions: -

## High Level Steps -
## 1. Login as UW
## 2. Create New Quote
## 3. Order Data Reports
  
## User - underwriter1

@regression @mtr347 @gocregression @gu
Feature: MTR347-GOC Underwriter to Override the vendor data - Golf Cart

  Scenario: Validate UW to Overide data from ordered  reports in Quote
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr347>
    And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen <mtr347>
    And User enters all required information on GOC golfcart screen for <mtr347>
    And User enters driver information on driver screen <mtr347>
    And User enters vehicles information on vehicles screen <mtr347>
    And User enters all required information on GOC review screen <mtr347>
    And User clicks Data Reports Chevron
    And User clicks Order Data Report and validates Dropdown Selections
    And User selects Insurance Score Data Report and orders
    And User clicks Data Reports Chevron
    And User validates A new report generated and added in Data Reports In Process Data Reports
    And User clicks Golf Cart Policy Chevron
    And User should be able to see the data received from Report on quote
    And User creates GOC application <mtr347>
    And User clicks Data Reports Chevron
    And User validates application should be able to see the data received from Report. In Process Data Reports
    And User answers all underwriting questions for GOC <mtr347>
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that GOC policy has been created successfully and completes test <mtr347>
    
    
    
    
    
    
    
    
## created on 04/25/2024 by Can Yavas
 
## Title: MTR344-VOL MHO3 Underwriter to Override the vendor data
## Preconditions: -

## High Level Steps -
## 1. Login as UW
## 2. Create New Quote
## 3. Order Data Reports
  
## User - underwriter1

@regression @mtr344 @mho3regression @gu
Feature: MTR344-VOL MHO3 Underwriter to Override the vendor data

  Scenario: Validate UW to Overide data from ordered  reports in Quote
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr344>
    And User enters MHO3 product selection information and effective date as current date
    And User enters Producer Code <mtr344>
		And User enters all required information on MHO3 quote screen with prior exp date as current date <mtr344>
		And User enters all required information on MHO3 dwelling screen <mtr344>
		And User enters all required information on MHO3 review screen
		And User clicks Data Reports Chevron
		And User clicks Order Data Report and validates Dropdown Selections <mtr344>
		And User selects CLUE Property Report and click order
		And User clicks Data Reports Chevron
    And User validates A new report generated and added in Data Reports In Process Data Reports <mtr344>
		And User clicks Policy Chevron
		And User should be able to see the data received from Report on quote <mtr344>
		And User creates MHO3 application
		And User clicks Data Reports Chevron
		And User validates application should be able to see the data received from Report. In Process Data Reports <mtr344>
		And User answers all underwriting questions for MHO3 <mtr344>
		And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User verifies NB MHO3 policy has been created successfully and completes test <mtr344>
		
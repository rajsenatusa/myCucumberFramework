## created on 04/26/2024 by Can Yavas
 
## Title: MTR343-VOL DP1 Underwriter to Override the vendor data
## Preconditions: -

## High Level Steps -
## 1. Login as UW
## 2. Create New Quote
## 3. Order Data Reports
  
## User - underwriter1

@regression @mtr343 @dp1regression @gu
Feature: MTR343-VOL DP1 Underwriter to Override the vendor data

  Scenario: Validate UW to Overide data from ordered  reports in Quote
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr343>
    And User enters DP1 product selection information and current date as effective date
    And User enters Producer Code <mtr343>
    And User enters all required information on DP1 quote screen with current date as prior policy date <mtr343>
		And User enters all required information on DP1 dwelling screen <mtr343>
		And User enters all required information on DP1 review screen
    And User clicks Data Reports Chevron
    And User clicks Order Data Report and validates Dropdown Selections <mtr343>
		And User selects Insurance Score Report and click order <mtr343>
		And User clicks Data Reports Chevron
    And User validates A new report generated and added in Data Reports In Process Data Reports <mtr343>
		And User clicks Policy Chevron
		And User should be able to see the data received from Report on quote <mtr343>
    And User creates DP1 application <mtr343>
    And User clicks Data Reports Chevron
		And User validates application should be able to see the data received from Report. In Process Data Reports <mtr343>  
    And User answers all underwriting questions for DP1 <mtr343>
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that DP1 policy has been created successfully and completes test <mtr343>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
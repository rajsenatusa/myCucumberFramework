## created on 04/26/2024 by Can Yavas
 
## Title: MTR342-VOL HO3 Underwriter to Override the vendor data
## Preconditions: -

## High Level Steps -
## 1. Login as UW
## 2. Create New Quote
## 3. Order Data Reports
  
## User - underwriter1

@regression @mtr342 @ho3regression @gu
Feature: MTR342-VOL HO3 Underwriter to Override the vendor data

  Scenario: Validate UW to Overide data from ordered  reports in Quote
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr342>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr342>
		And User enters all required information on HO3 dwelling screen <mtr342>
		And User enters all required information on HO3 review screen
    And User clicks Data Reports Chevron
    And User clicks Order Data Report and validates Dropdown Selections <mtr342>
		And User selects Insurance Score Report and click order <mtr342>
		And User clicks Data Reports Chevron
    And User validates A new report generated and added in Data Reports In Process Data Reports <mtr342>
		And User clicks Policy Chevron
		And User should be able to see the data received from Report on quote <mtr342>
    And User creates HO3 application <mtr342>
    And User clicks Data Reports Chevron
		And User validates application should be able to see the data received from Report. In Process Data Reports <mtr342>  
    And User answers all underwriting questions for VOL HO3 <mtr342>
    And User completes required information on dwelling chevron <mtr342>
    And User finalizes transaction for VOL HO3 <mtr1430>
    And User issues policy
    Then User validates that HO3 policy has been created successfully and completes test <mtr342>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
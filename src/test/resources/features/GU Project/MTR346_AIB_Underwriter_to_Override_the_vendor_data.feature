## created on 04/25/2024 by Can Yavas
 
## Title: MTR346-AIB Underwriter to Override the vendor data
## Preconditions: -

## High Level Steps -
## 1. Login as UW
## 2. Create New Quote
## 3. Order Data Reports
  
## User - underwriter1

@regression @mtr346 @aibregression @gu
Feature: MTR346-AIB Underwriter to Override the vendor data

  Scenario: Validate UW to Overide data from ordered  reports in Quote
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr346>
		And User enters AIB product selection information and current date as effective date
		And User enters Producer <mtr346>
		And User enters all required information on AIB quote screen for <mtr346>
		And User selects liability coverage on quote screen for <mtr346>
		And User adds operator information on quote screen <mtr346>
		And User enters all required information on AIB boat dwelling screen for <mtr346>
		And User enters all required information on AIB review screen
		And User clicks Data Reports Chevron
		And User clicks Order Data Report and validates Dropdown Selections <mtr346>
		And User selects Insurance Score Report and click order <mtr346>
		And User clicks Data Reports Chevron
    And User validates A new report generated and added in Data Reports In Process Data Reports <mtr346>
		And User clicks Policy Chevron
		And User should be able to see the data received from Report on quote <mtr346>
		And User creates AIB application
		And User clicks Data Reports Chevron
		And User validates application should be able to see the data received from Report. In Process Data Reports <mtr346>
		And User answers all underwriting questions for AIB <mtr346>
		And User checks application dwelling screen and finalizes transaction
		Then User issues policy and close unnecessary tabs and completes test <mtr346>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
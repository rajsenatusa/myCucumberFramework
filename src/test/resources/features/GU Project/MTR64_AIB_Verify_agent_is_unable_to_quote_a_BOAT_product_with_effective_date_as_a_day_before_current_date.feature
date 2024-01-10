## Author: Can Yavas
## created on 01/09/2024

## TEST CASE NUMBER & TITLE: MTR64--VOL AIB, Verify agent is unable to quote a BOAT product with effective date as a day before current date
## PRECONDITIONS (IF ANY): VOL AIB 
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Log into SPIN as Agent
## 2.Select or Enter Effective Date as day before current date
## 3.Enter the required Policy General and  insured Information

## EXPECTED RESULTS: Verify Hardstop is displayed "	The effective date must not be older than 0 days from today. fix  

## User: Standard Agent 


@regression @mtr64 @aibregression @gu
Feature: MTR64--VOL AIB, Verify agent is unable to quote a BOAT product with effective date as a day before current date

  Scenario: Validate Verify Hardstop is displayed "	Policies back dated greater than 0 days Must Be Approved "

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr64>
		And User enters AIB product selection information and current date minus 1 day as effective date <mtr64>
		And User enters all required information on AIB quote screen for <mtr64>
		And User selects liability coverage on quote screen for <mtr64>
		And User validates hardstop message 'Policies back dated greater than 0 days Must Be Approved' has been displayed
		And User clicks Review Chevron and validates basic premium equals zero
		And User takes note of the quote number for <mtr64>
		Then User clicks Home button and validates created quote listed there and completes test
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
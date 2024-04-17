##created on 09/26/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 38471--DP1 NB Validate Flood coverage edit messages generated when Flood Cov-A > Dwelling Cov-A and UW mngr can issue the policy
## PRECONDITIONS (IF ANY
## HIGH LEVEL STEPS OF TEST SCRIPT:  Validate agent cannot issue NB policy when Flood Cov-A greater than dwelling
## Cov-A and the following error message displays: Flood Coverage A cannot be greater than Dwelling Coverage A fix�
## EXPECTED RESULTS: Agent cannot issue policy
## User: AG1730, Jbarnes


@regression @mtr3171 @dp1regression 
Feature: TC 38471--DP1 NB Validate Flood coverage edit messages generated when Flood Cov-A larger than Dwelling Cov-A and UW mngr can issue the policy

  Scenario: Validate agent cannot issue NB policy when Flood Cov-A greater than dwelling
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr3171>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date <mtr3171>
	 	And User enters all required information on DP1 dwelling screen <mtr3171>
   	And User enters Flood CovA larger than Dwelling CovA and validates error message
   	And User enters Flood CovA smaller than Dwelling CovA and validates no error message displayed
   	And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User clicks Dwelling Chevron <mtr3171>
    And User enters Flood CovA larger than Dwelling CovA and validates error message displayed
    And User checks application dwelling screen and finalizes transaction
    And User validates error message displayed on closeout screen
    And User takes note of the application number <mtr3171>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for application number <mtr3171>
    And User takes ownership of the application
    And User clicks Finalize button
    And User validates 'Flood Coverage A cannot be greater than Dwelling Coverage A' message displayed  
    Then User issues policy and completes test <mtr3171>
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
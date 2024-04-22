#Author: Can Yavas
#created on 04/19/2024
#TEST CASE NUMBER & TITLE: MTR-5846 TH-1303 : DP1 NB Validate Agent cannot issue DP1 Owner occupied policy with prior water losses with more than 3 years
#Precondition: Create a VOL DP1 quote application
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validate Agent cannot issue DP1 Owner occupied policy with prior water losses with more than 3 years
#User: Standard Agent, underwriter1

@regression @mtr5846 @im @dp1regression
Feature: MTR-5846 TH-1303 : DP1 NB Validate Agent cannot issue DP1 Owner occupied policy with prior water losses with more than 3 years

  Scenario: Validate Agent cannot issue DP1 Owner occupied policy with prior water losses with more than 3 years
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr5846>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date <mtr5846>
   	And User enters all required information on DP1 dwelling screen and enters CoverageA is higher than 1million and validate issue message <mtr5846>
   	And User changes CoverageA to lower than 250k and validate issue message
   	And User enters all required information on DP1 review screen
   	And User creates DP1 application
    And User answers all underwriting questions for DP1
	 	And User clicks Dwelling Chevron <mtr5846>
   	And User changes CoverageA larger than 250k and validates previous error message disappeared
   	And User clicks Loss History Chevron and validates prior losses displayed 
   	And User checks application dwelling screen and finalizes transaction
   	And User validates issue new business button Not visible, submit for approval button and loss history error message visible on closeout screen <mtr5846>
   	And User takes note of the application number <mtr5846>
   	And User clicks submit for approval button
    And User signs out
	 	And User login to Spin as Underwriter
	 	And User searches for application number <mtr5846>
   	And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
   	And User searches for application number <mtr5846>
   	And User issues policy and completes test <mtr5846>
   	
   	
#Author: Can Yavas
#created on 04/19/2024
#TEST CASE NUMBER & TITLE: MTR-5845 TH-1303 : DP1 NB Validate Agent requires UW approval required If lapse in coverage greater than zero day for Owner occupancy
#Precondition: Create a VOL DP1 quote application
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validate Agent requires UW approval required If lapse in coverage greater than zero day for Owner occupancy
#User: Standard Agent, underwriter1

@regression @mtr5845 @im @dp1regression
Feature: MTR-5845 TH-1303 : DP1 NB Validate Agent requires UW approval required If lapse in coverage greater than zero day for Owner occupancy

  Scenario: Validate Agent requires UW approval required If lapse in coverage greater than zero day for Owner occupancy
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr5845>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date minus 1 day as prior policy date <mtr5845>
	 	And User enters all required information on DP1 dwelling screen and validates error message related to lapse in policy <mtr5845>
	 	And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
	 	And User clicks Policy Chevron
	 	And User validates error message 'Length of lapse is ineligible for this policy form: application may be submitted for exception review through SPIN by finalizing the application and submitting for approval' has been displayed <mtr5845>
	 	And User checks application dwelling screen and finalizes transaction
	 	And User validates issue new business not visible and submit for approval button and lapse error message visible on closeout screen <mtr5845>
    And User takes note of the application number <mtr5845>
    And User clicks submit for approval button
    And User signs out
	 	And User login to Spin as Underwriter
	 	And User searches for application number <mtr5845>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for application number <mtr5845>
	 	And User issues policy and completes test <mtr5845>
	 	
	 	
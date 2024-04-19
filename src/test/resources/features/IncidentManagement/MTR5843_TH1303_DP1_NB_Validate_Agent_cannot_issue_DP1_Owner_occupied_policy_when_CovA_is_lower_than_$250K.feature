#Author: Can Yavas
#created on 04/18/2024
#TEST CASE NUMBER & TITLE: MTR-5843 TH-1303 : DP1 NB Validate Agent cannot issue DP1 Owner occupied policy when CovA is lover than $250K
#Precondition: Create a VOL DP1 quote application
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validate Agent cannot issue DP1 Owner occupied policy when CovA is lover than $250K
#User: Standard Agent, underwriter1

@regression @mtr5843 @im @dp1regression
Feature: MTR-5843 TH-1303 : DP1 NB Validate Agent cannot issue DP1 Owner occupied policy when CovA is lover than $250K

  Scenario: Validate Agent cannot issue DP1 Owner occupied policy when CovA is lover than $250K
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr5843>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date <mtr5843>
	 	And User enters all required information on DP1 dwelling screen and enters CoverageA is lower than 250k <mtr5843>
	 	And User validates error message 'Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ' has been displayed <mtr5843>
	 	And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
	 	And User clicks Dwelling Chevron <mtr5843>
	 	And User validates error message 'Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ' has been displayed <mtr5843>
	 	And User checks application dwelling screen and finalizes transaction
	 	And User validates issue new business and submit for approval buttons not visible on closeout screen <mtr5843>
    And User takes note of the application number <mtr5843>
    And User signs out
	 	And User login to Spin as Underwriter
	 	And User searches for application number <mtr5843>
    And User takes ownership of the application
    And User clicks Dwelling Chevron <mtr5843>
    And User validates error message 'Cannot issue due to limited catastrophic capacity [Coverage A Minimum which exceeds a minimum of $250,000 requires underwriting review] ' has been displayed <mtr5843>  
    And User clicks Finalize button
	 	And User validates error message is visible and issue new business button is visible <mtr5843>
	 	Then User issues policy and completes test <mtr5843>
	 	
	 	
	 	
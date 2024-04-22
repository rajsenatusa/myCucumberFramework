#Author: Can Yavas
#created on 04/22/2024
#TEST CASE NUMBER & TITLE: MTR-5853 TH-1303 : DP1 END Validate Agent can process endorsement for Owner occupied policy with CovA < $250K
#Precondition: Create a VOL DP1 quote application
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validating that the following changes do not impact Endorsement on existing policies: Coverage A is < $250,000
#User: Standard Agent, underwriter1

@regression @mtr5853 @im @dp1regression
Feature: MTR-5853 TH-1303 : DP1 END Validate Agent can process endorsement for Owner occupied policy with CovA is lower than $250K

  Scenario: Validating that the following changes do not impact Endorsement on existing policies: Coverage A is lower than 250k
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr5853>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date <mtr5853>
	 	And User enters all required information on DP1 dwelling screen and enters CoverageA is as 250k <mtr5853>
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr5853>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as current date <mtr5853>
    And User clicks Dwelling Chevron for <mtr5853>
    And User decreases Coverage A below 250k and validate issue message did not display
    And User clicks finalize transaction
    And User validates issue message did not display on closeout screen either
    Then User endorses policy and completes test case <mtr5853>
    
    
    
    
    
    
    
    
    
    
    
    
    
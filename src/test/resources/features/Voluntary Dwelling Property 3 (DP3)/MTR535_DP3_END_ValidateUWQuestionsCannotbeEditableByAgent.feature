#Author: C.Yavas
##created on 07/28/2023

@regression @tc35179
Feature: TC 35179--DP3, Agent, END TX Validate No Longer Allowing Underwriter Questions to be Modified by Agent in END

 
  Scenario Outline: As an Agent - Validate that once the risk is bound at NB, every UW question is locked down and cannot be modified
    Given User signin Spin with username "<username>" and password "<password>"
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date
    And User enters all required information on DP3 dwelling screen
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP3 policy has been created successfully
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date
		And User clicks Underwriting Questions Chevron
		And User validates that UW Questions is not editable
		And User takes note of the policy number
		And User cancels transaction
		And User signs out
		And User login to Spin as Underwriter
		And User searches previously created policy
	 	And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date
		And User clicks Underwriting Questions Chevron
		And User validates that UW Questions is editable
		
    Examples: 
      | username | password |
      |  AG0376  | password |
     
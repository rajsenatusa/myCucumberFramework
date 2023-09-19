#Author: Can Yavas
##created on 08/03/2023

@regression @mtr471
Feature: US8684 - U/I Mandatory Mediation-Arbitration Coverage discount on and require UW Approval when adding on END with 30 days
 NB for Owner Occupied; Basic Policy and END to Change discount

  Scenario: User creates NB policy and change the date from 30 days and Change Arbitration as Yes then it require UW approval
    Occupancy=Owner Occupied and will not display for Package=Basic Policy on END

    Given User login to Spin as Standard Agent
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
    Then User validates that DP3 policy has been created successfully and closes unnecessary tabs
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date plus <30>days
		And User clicks dwelling tab and validates MMA selected as No and switches MMA as Yes
		And User validates <Mediation Arbitration Change requires Underwriting Approval> message has been displayed
		And User takes note of the application number
		And User finalizes transaction and submits for approval
		And User signs out
		And User login to Spin as Underwriter
		And User searches previously created application
		And UW User approves application
		And User signs out
		And User login to Spin as Standard Agent
		And User searches previously created application
		And User completes endorsement 
		And User validates that Endorsement transaction has been completed successfully
		
		
		
		
		
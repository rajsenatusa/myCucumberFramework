#Author: Can Yavas
##created on 08/03/2023

@regression @tc38733 @mtr367 @dp3regression
Feature: TC 38733-MTR367-US8828 - Integrity Select - Form - Owner Occupied Endorsement 
 AIIC DP3 OO 04 23- DP3 -Owner Occupied and Endorse to Integrity Select

  Scenario: As an Agent, validate Owner Occupied Endorsement AIIC DP3 OO 04 23 form displays on Endorsement

    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr367>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr367>
    And User enters all required information on DP3 dwelling screen <mtr367>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User clicks Forms Chevron
    And User validates <AIIC DP3 OO 04 23> form is not visible on basic policy 
    And User finalizes transaction and issues policy
    And User validates that DP3 policy has been created successfully and closes unnecessary tabs
    And User clicks Forms Chevron
    And User validates <AIIC DP3 OO 04 23> form is not visible on basic policy
    And User clicks more button and starts transaction
    And User clicks EN Transaction Selection
		And User selects endorsement date as current date
		And User navigates dwelling tab and selects integrity select package
		And User finalizes transaction and completes endorsement
		And User validates that Endorsement transaction has been completed successfully
		And User clicks Forms Chevron
		And User validates <AIIC DP3 OO 04 23> form is visible on integrity policy
		And User clicks Sample Form and validates form details as expected
		And User clicks Policy File Tab
		Then User validates form details on endorsement package
		
		
		
		
		
		
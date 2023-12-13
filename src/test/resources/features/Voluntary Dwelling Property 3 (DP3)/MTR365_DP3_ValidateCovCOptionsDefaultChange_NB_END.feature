#Author: Can Yavas
#created on 08/03/2023

@regression @tc38508 @mtr365 @dp3regression
Feature: TC 38508-MTR365-US8830 - DP3 U/I - Owner Occupied Package - Coverage C default change - Endorse (Change Occupancy)

  Scenario: Validate Cov-C options list will display on NB for Integrity Select package when 
  Occupancy=Owner Occupied and will not display for Package=Basic Policy on END
  
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr365>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr365>
    And User enters all required information on DP3 dwelling screen and selects integrity select package <mtr365>
    And User validates Coverage C defaults to %25 on integrity select package
		And User validates Cov C drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% <mtr365>
		And User changes Coverage A to <300.000> and validates text box for Cov C should display the value amount that equates to the percentage selected of Cov-A and should be disabled <mtr365>
		And User enters all required information on DP3 review screen
		And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User clicks Dwelling tab and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and Coverage C limit defaulted %25 and Cov C limit $75.000 is disabled
    And User issues policy
    And User validates that DP3 policy has been created successfully and closes unnecessary tabs
    Then User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date
		And User clicks Policy General Chevron and changes Occupancy to Tenant
		And User clicks dwelling tab and verifies message <Occupancy has been updated which would impact the prior coverages selected. Please review the coverages on the Dwelling page>
		And User sets Cov C personal Property amount as <17.000>
		And User finalizes transaction and completes endorsement
		And User validates that Endorsement transaction has been completed successfully and completes test <mtr365>
    
    
    
    
    
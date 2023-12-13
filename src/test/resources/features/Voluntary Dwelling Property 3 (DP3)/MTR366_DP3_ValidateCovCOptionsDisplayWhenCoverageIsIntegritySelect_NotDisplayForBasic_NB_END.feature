#Author: Can Yavas
#created on 08/01/2023

@regression @tc38486 @mtr366 @dp3regression
Feature: TC 38486-MTR366-DP3, Update Cov C selection list - NB Owner Occupied ; after Integrity Select

  Scenario: As an Agent, validate Cov-C options list will display on NB for Integrity Select package when
    Occupancy=Owner Occupied and will not display for Package=Basic Policy on END

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr366>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr366>
    And User enters all required information on DP3 dwelling screen and selects integrity select package
		And User validates Coverage C defaults to %25 on integrity select package
		And User validates Cov C drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70%
		And User changes Coverage A to <300.000> and validates text box for Cov C should display the value amount that equates to the percentage selected of Cov-A and should be disabled
		And User selects C-Personal Property <70%> and validates text box for C-Personal Property should display the value amount that equates to the <70%> percentage selected of Cov-A and should be disabled
		And User enters all required information on DP3 review screen
		And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User clicks Dwelling tab and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and The free form text box for C-Personal Property should display the value amount that equates to the 70% percentage selected of Cov-A and should be disabled
    And User issues policy
    And User validates that DP3 policy has been created successfully and closes unnecessary tabs
    And User clicks dwelling chevron and validates C-Personal Property defaults to <70%> and should display the value amount that equates to the <70%> percentage selected of Cov-A
    And User clicks more button and starts transaction
    And User clicks EN Transaction Selection
		And User selects endorsement date as current date
		And User clicks Dwelling tab on endorsement level and validates C-Personal Property drop down contains the following options:10%, 15%, 20%, 25%, 30%, 35%, 40%, 45%, 50%, 55%, 60%, 65%, 70% and The free form text box for C-Personal Property should display the value amount that equates to the 70% percentage selected of Cov-A and should be disabled
		And User endorses policy to basic policy
		And User enters <170.000> for Coverage C value
		And User finalizes transaction and completes endorsement
		Then User validates that Endorsement transaction has been completed successfully and completes test <mtr366>
		
		
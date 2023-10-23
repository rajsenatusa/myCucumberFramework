#Author: Can Yavas
##created on 10/23/2023

# TEST CASE NUMBER & TITLE: TC 16598--DP3 UWMgr NB End (FLOOD) RN (2) and Claim Forms Basic w/ ALL additional/optional coverages
# PRECONDITIONS (IF ANY)
# HIGH LEVEL STEPS OF TEST SCRIPT:  Create new business by including all additional/ optional coverages,
#  								add Flood coverage over endorsement transaction, 
# 									Create a claim on the policy and perform renewal
# EXPECTED RESULTS: All forms will be verified in the following states: 
# New Business
# Endorsement
# Claims
# Renewal transactions
 
# User: Lrallo

@regression @tc16598 @mtr2490
Feature: TC 16598--DP3 UWMgr NB End (FLOOD) RN (2) and Claim Forms Basic w/ ALL additional/optional coverages

  Scenario: All forms will be verified in the following states
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr2490>
    And User enters DP3 product selection information and effective date as current date plus 30 days <mtr2490>
    And User enters all required information on DP3 quote screen with current date plus 30days as prior policy date <mtr2490>
    And User enters all required information on DP3 dwelling screen <mtr2490> and selects additional coverages and adds additional options
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User updates roof material on dwelling screen
    And User finalizes transaction for <mtr2490>
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <mtr2490>
    And User clicks Forms Chevron <mtr2490>
    And User validates all expected forms is visible on forms screen <mtr2490>
    And User validates greeting letter form version <mtr2490>
    And User validates privacy statement form version <mtr2490>
    And User validates Limitations on Roof Coverage form version <mtr2490>
    
    
    
    
    
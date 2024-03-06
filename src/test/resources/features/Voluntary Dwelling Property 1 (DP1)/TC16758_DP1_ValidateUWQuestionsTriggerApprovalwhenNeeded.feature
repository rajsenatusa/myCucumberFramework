# Author: Can Yavas
# created on 12/21/2023

# TEST CASE KNUMBER & TITLE: TC 16758--DP1 Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'
# PRECONDITIONS (IF ANY):
# HIGH LEVEL STEPS OF TEST SCRIPT:  Selecting "Yes" for all Underwriting Questions
#
# EXPECTED RESULTS: Selecting "Yes" to Underwriting Questions will produce the following...
#						1. Child Questions are generated
#						2. Underwriting Approval referral is triggered
#						3. Agent cannot bind NB without Underwriting Approval

# User: AG1730

@regression @tc16758 @dp1regression @AIIdp1
Feature:  TC 16758--DP1 Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'
  
  Scenario: TC16758_DP1_ValidateUWQuestionsTriggerApprovalwhenNeeded
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16758>
    And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen <tc16758>
    And User enters all required information on DP1 dwelling screen <tc16758>
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all DP1 UW questions as no and validates 'Risk is ineligible for coverage due to occupancy' message
    And User answers DP1 UW Question 1 as Yes and validates expected issue messages
    And User answers DP1 UW Question 2 as Yes and validates expected issue messages
    And User answers DP1 UW Question 3 as Yes and validates expected issue messages
    And User answers DP1 UW Question 4 as Yes and validates expected issue messages
    And User answers DP1 UW Question 5 as Yes and validates expected issue messages
    And User answers DP1 UW Question 6 as Yes and validates expected issue messages
    And User answers DP1 UW Question 7 as Yes and validates expected issue messages
    And User answers DP1 UW Question 8 as Yes and validates expected issue messages
    And User answers DP1 UW Question 9 as Yes and validates expected issue messages
    And User answers DP1 UW Question 10 as Yes and validates expected issue messages
    And User answers DP1 UW Question 11 as Yes and validates expected issue messages
    And User answers DP1 UW Question 12 as Yes and validates expected issue messages
    And User answers DP1 UW Question 13 as Yes and validates expected issue messages
    And User answers DP1 UW Question 14 as Yes and validates expected issue messages
    And User answers DP1 UW Question 15 as Yes and validates expected issue messages
    And User answers DP1 UW Question 16 as Yes and validates expected issue messages
    And User answers DP1 UW Question 17 as Yes and validates expected issue messages
    And User answers DP1 UW Question 18 as Yes and validates expected issue messages
    And User answers DP1 UW Question 19 as Yes and validates expected issue messages
    And User answers DP1 UW Question 20 as Yes and validates expected issue messages
    And User answers DP1 UW Question 21 as Yes and validates expected issue messages
    And User answers DP1 UW Question 22 as Yes and validates expected issue messages
    And User answers DP1 UW Question 23 as Yes and validates expected issue messages
    And User answers DP1 UW Question 24 as Yes and validates expected issue messages
    And User answers DP1 UW Question 25 as Yes and validates expected issue messages
    And User answers DP1 UW Question 26 as Yes and validates expected issue messages
    And User answers DP1 UW Question 27 as Yes and validates expected issue messages
    And User answers DP1 UW Question 28 as Yes and validates expected issue messages
    And User answers DP1 all UW Questions as Yes and validates expected issue messages
    And User sets roof material finalizes transactions and validates expected issue messages
    And User takes note of the application for <tc16758>
    And User clicks submit for approval button for <tc16758>
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16758>
    And User validates all expected issue messages <tc16758>
    And User submits for approval as UW <tc16758>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc16758>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <tc16758>
    And User issues policy and close unnecessary tabs and completes test <tc16758>
# Author: Mustafa Cemek
# created on 12/18/2023
#TEST CASE NUMBER & TITLE: TC 16759--DP3 Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'
#PRECONDITIONS (IF ANY):
#HIGH LEVEL STEPS OF TEST SCRIPT:  Selecting "Yes" for all Underwriting Questions
#EXPECTED RESULTS: Selecting "Yes" to Underwriting Questions will produce the following...
#1. Child Questions are generated
#2. Underwriting Approval referral is triggered
#3. Agent cannot bind NB without Underwriting Approval
#User: AG1730, jlowe, Underwriter Clerk

@regression @tc16759 @dp3regression
Feature: TC 16759--DP3 Agent Basic Policy App Validations

  Scenario: TC16759_DP3_ValidateUWQuestionsTriggerApprovalwhenNeeded
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen for <tc16759>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen for <tc16759>
    And User enters all required information on DP3 dwelling screen for <tc16759>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all UW questions as No and validates messages for <tc16759>
    And User checks error messages when DP3 Underwriting Questions are answered one by one as Yes and validates particular error messages for all questions
    And User answers all UW questions as Yes and validates messages for <tc16759>
    And User clicks Finalize button
    And User verifies messages for <tc16759>
    And User takes note of the application for <tc16759>
    And User clicks submit for approval button for <tc16759>
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16759>
    And User verifies messages on Issues tile for <tc16759>
    And User verifies messages on Submitter Issues tile for <tc16759>
    And User clicks submit for approval as underwriter
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc16759>
    And User verifies Underwriter Clerk messages on Issues tile for <tc16759>
    And User verifies Underwriter Clerk messages on Submitter Issues tile for <tc16759>
    And User approves application
    And User signs out
    Given User login to Spin as Standard Agent
    And User searches for the application <tc16759>
    And User verifies Standard Agent messages on Submitter Issues tile for <tc16759>
    Then User issues policy and close unnecessary tabs and completes test <tc16759>

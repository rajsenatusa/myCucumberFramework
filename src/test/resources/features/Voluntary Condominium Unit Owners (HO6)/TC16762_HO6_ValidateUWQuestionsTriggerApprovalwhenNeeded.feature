# Author: Mustafa Cemek
# created on 12/14/2023
#TEST CASE NUMBER & TITLE: TC 16762--HO6 Agent App Validations "Validate UW questions trigger approval when needed"
#PRECONDITIONS (IF ANY):
#HIGH LEVEL STEPS OF TEST SCRIPT:  Selecting "Yes" for all Underwriting Questions
#
#EXPECTED RESULTS: Selecting "Yes" to Underwriting Questions will produce the following...
#						1. Child Questions are generated
#						2. Underwriting Approval referral is triggered
#						3. Agent cannot bind NB without Underwriting Approval
#User: AG1730


@regression @tc16762 @ho6regression @AIIho6
Feature: TC 16762--HO6 Agent App Validations "Validate UW questions trigger approval when needed"

  Scenario: TC16762_HO6_ValidateUWQuestionsTriggerApprovalwhenNeeded
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16762>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <tc16762>
    And User enters all required information on HO6 dwelling screen for <tc16762>
    And User enters all required information on HO6 review screen
    And User validates Quote Made for <tc16762>
    And User creates HO6 application
    And User checks error messages when HO6 Underwriting Questions are answered one by one as Yes and validates particular error messages for all questions
    And User answers as Yes all UW questions for <tc16762>
    And User validates error messages in Policy chevron for <tc16762>
    And User checks application dwelling screen and finalizes transaction for <tc16762>
    And User validates error messages in Issues for <tc16762>
    And User takes note of the application for <tc16762>
    And User clicks submit for approval button for <tc16762>
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16762>
    And User verifies messages on issues tile for <tc16762>
    And User verifies messages on Submitter Issues tile for <tc16762>
    And User clicks submit for approval as underwriter
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc16762>
    And User verifies Underwriter Clerk messages on Issues tile for <tc16762>
    And User verifies Underwriter Clerk messages on Submitter Issues tile for <tc16762>
    And User approves application
    And User signs out
    Given User login to Spin as Standard Agent
    And User searches for the application <tc16762>
    And User verifies Standard Agent messages on Submitter Issues tile for <tc16762>
    Then User issues policy and close unnecessary tabs and completes test <tc16762>

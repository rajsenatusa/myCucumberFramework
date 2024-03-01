# Author: Mustafa Cemek
# created on 02/15/2024
#TEST CASE NUMBER & TITLE: JA-147-MTR-4877-HO6 -Submit for approval > UW Approve > Agent Issue-2 referral
#Precondition: Create a HO6 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: UW referral should be displayed by Agant
#User: Standard Agent, Underwriter
@regression @mtr4877 @ja
Feature: MTR4877_HO6_Verify_Notes are displayed correctly by Agent

  Scenario: Verify_Underwriter_approvals the application_and_referrals are displayed correctly by the agent
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen <mtr4877>
    And User enters all required information on HO6 dwelling screen
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User takes note of the application number <mtr4877>
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    Then User validates the Submit for Approval messages
    And User submits the application for UW approval
    Then User validates the Application is submitted for approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr4877>
    Then User validates the Submitter Issues
    And User approves the application or transaction
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Application Number for <mtr4877>
    And User clicks View Workflow Comments
    Then User validates a New Note has been created successfully in Notes List <mtr4877>
    And User issues policy
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date <mtr4877>
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN HO6 policy has been created successfully <mtr4877>
    And User clicks History Chevron
    And User clicks Notes Chevron
    Then User verifies persisted referral notes are displayed in Notes List
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date <mtr4877>
    And User clicks Dwelling chevron
    And User selects Sinkhole Loss
    And User clicks Finalize button
    And User takes note of the second application number <mtr4877>
    And User submits the application for UW approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Second Application Number for <mtr4877>
    Then User verifies the Change in Sinkhole Deductible <mtr4877>
    And User approves the application or transaction
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Second Application Number for <mtr4877>
    And User clicks Endorse Policy button
    Then User verifies EN HO6 policy has been created successfully
    And User clicks Notes Chevron
    Then User verifies third persisted referral notes are displayed in Notes List

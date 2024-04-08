# Author: Mustafa Cemek
# created on 02/15/2024
#TEST CASE NUMBER & TITLE: JA-147-MTR-4934-HO3-Rule that has authority amount populated in the text of the rule-Multi referral
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: The referrals were approved by UW and UW manager. UW referral should be displayed by Agent
#User: Standard Agent, Underwriter, UW Manager
@regression @mtr4934 @ja2 @ja
Feature: MTR4934_HO3_Verify_Multi referral_can_display_by_Agent

  Scenario: Verify_Underwriter_and_UW_Manager_approved_the referrals_than_Agent_can_display_the_referrals
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr4934>
    And User enters all required information on HO3 dwelling screen <mtr4934>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User click issues new business and verifies the NB policy
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date <mtr4934>
    And User changes Months Occupied as 0 to 3 Months
    And User clicks Dwelling chevron
    And User changes Coverage A Dwelling as 600000 <mtr4934>
    And User clicks Finalize button
    And User takes note of the application number <mtr4934>
    Then User validates the Submit for Approval messages <mtr4934>
    And User submits the application for UW approval
    Then User validates the Application is submitted for approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr4934>
    Then User validates the Submitter Issues <mtr4934>
    And User clicks approve button <mtr4934>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User Searchs for Application Number for <mtr4934>
    And User approves the application or transaction
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Application Number for <mtr4934>
    And User clicks Endorse Policy button <mtr4934>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date <mtr4934>
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN HO3 policy has been created successfully <mtr4934>
    And User clicks Notes Chevron
    Then User verifies third persisted referral notes are displayed in Notes List <mtr4877>

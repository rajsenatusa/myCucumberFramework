# Author: Mustafa Cemek
# created on 04/01/2024
#TEST CASE NUMBER & TITLE: MTR-4589-JA-145-HO3 -Submit for approval > UW Approve > Agent Issue-1 referral
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: The referrals were approved by UW. UW referral should be displayed by Agent
#User: Standard Agent, Underwriter
@regression @mtr4589 @ja
Feature: MTR4589_HO3_Verify_one_referral_can_display_by_Agent

  Scenario: Verify_Underwriter_approved_the referral_than_Agent_can_display_the_referral
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr4589>
    And User enters all required information on HO3 dwelling screen <mtr4589>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User takes note of the application number <mtr4589>
    Then User validates the Submit for Approval messages <mtr4589>
    And User submits the application for UW approval
    Then User validates the Application is submitted for approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr4589>
    Then User validates the Submitter Issues <mtr4589>
    And User clicks approve button <mtr4589>
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Application Number for <mtr4589>
    And User clicks View Notes
    And User clicks plus sign View Notes
    Then User validates View Notes
    And User click issues new business and verifies the NB policy <mtr4589>
    And User clicks Tasks chevron
    Then User validates System tasks for renewal
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User selects endorsement date as system date plus 3 days
    And User clicks Notes Chevron
    Then User verifies persisted referral note is displayed in Notes List <mtr4589>
    And User clicks Policy Chevron
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN HO3 policy has been created successfully <mtr4589>

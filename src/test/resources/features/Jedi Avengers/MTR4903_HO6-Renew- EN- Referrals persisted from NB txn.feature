# Author: Mustafa Cemek
# created on 03/13/2024
#TEST CASE NUMBER & TITLE: JA-147-MTR-4903-HO6-Renew- EN- Referrals persisted from NB txn
#Precondition: Create a HO6 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: The referrals were approved by UW and UW manager. UW referral should be displayed by Agent on RN
#User: Standard Agent
@regression @mtr4903 @ja2 @ja
Feature: MTR4903_HO6-Renew- EN- Referrals persisted from NB txn

  Scenario: Verify_Underwriter_and_UW_Manager_approved_the referrals_than_Agent_can_display_the_referrals on RN
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr316>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <mtr316>
    And User enters all required information on HO6 dwelling screen and enters <35.000> for CovC <mtr316>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <mtr316>
    And User checks application dwelling screen and finalizes transaction <mtr316>
    And User issues policy
    Then User validates that HO6 policy has been created successfully
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date <mtr4934>
    And User changes Months Occupied as 0 to 3 Months
    And User clicks Dwelling chevron
    And User changes Coverage A Dwelling as 600000 <mtr4903>
    And User clicks Finalize button
    And User takes note of the application number <mtr4934>
    Then User validates the Submit for Approval messages <mtr4934>
    And User submits the application for UW approval
    Then User validates the Application is submitted for approval
    And User signs out for <mtr4903>
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr4934>
    Then User validates the Submitter Issues <mtr4903>
    And User clicks approve button <mtr4934>
    And User signs out for <mtr4903>
    And User login to Spin as Underwriter Clerk
    And User Searchs for Application Number for <mtr4934>
    And User approves the application or transaction
    And User signs out for <mtr4903>
    Given User login to Spin as Admin Agent
    And User Searchs for Application Number for <mtr4934>
    And User clicks More button then Take Ownership
    And User clicks Finalize for <mtr4903>
    And User takes note of the policy number for <mtr4903>
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize for <mtr4903>
    And User clicks Notes Chevron
    Then User verifies third persisted referral notes are displayed in Notes List <mtr4903>
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date <mtr4903>
    And User clicks Finalize button
    And User clicks Endorse Policy button
    Then User verifies EN HO6 policy has been created successfully <mtr4903>
    And User clicks Notes Chevron
    Then User verifies third persisted referral notes are displayed in Notes List <mtr4903>

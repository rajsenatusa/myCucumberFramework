# Author: Mustafa Cemek
# created on 04/05/2024
#TEST CASE NUMBER & TITLE: MTR-4607-JA-145-HO3-Submit for approval > UW Submit for approval > UW Manager approves > Agent modifies (no additional rules triggered)
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: The referrals were approved by UW and UW manager. All referral should be displayed by Agent
#User: Standard Agent, Underwriter, UW Manager
@regression @mtr4607 @ja4 @ja
Feature: MTR4607_HO3_Verify_Multi referral_can_display_by_Agent

  Scenario: Verify_Underwriter_and_UW_Manager_approved_the referrals_than_Agent_can_display_the_referrals
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr4607>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr4607>
    And User enters all required information on HO3 dwelling screen <mtr4607>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User click issues new business and verifies the NB policy
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User selects endorsement date as system date plus 3 days
    And User changes Months Occupied as 0 to 3 Months
    And User clicks Dwelling chevron
    And User changes Coverage A Dwelling as 600000 <mtr4607>
    And User clicks Structures Rented to Others link
    And User selects Limited Fungi, Mold, Wet or Dry Rot, or Bacteria
    And User clicks Flood Coverage as Yes and enters required fields <mtr4607>
    And User clicks Finalize button
    And User takes note of the application number <mtr4607>
    Then User validates the Submit for Approval messages <mtr4607>
    And User submits the application for UW approval
    Then User validates the Application is submitted for approval
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Application Number for <mtr4607>
    Then User validates the Submitter Issues and Issues <mtr4607>
    And User submits the application for UW manager approval
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User Searchs for Application Number for <mtr4607>
    And User clicks approve button <mtr4607>
    Then User validates the Application has been approved by UW manager <mtr4607>
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Application Number for <mtr4607>
    And User clicks View Notes
    And User clicks plus sign View Notes
    Then User validates View Notes <mtr4607>
    And User clicks Endorse Policy <mtr4607>
    And User clicks Notes Chevron
    Then User verifies all referrals are displayed in Notes List <mtr4607>

# Author: Mustafa Cemek
# created on 03/28/2024
#TEST CASE NUMBER & TITLE: MTR-432-DP1-As an Underwriter I would like the ability to process a rewrite-New on Cancelled NB policy
#Precondition-Create  DP1 Policy with Full payment Plan and Cancelled flat with effective date as cancellation date
#HIGH LEVEL STEPS OF TEST SCRIPT:  In the Scenario Below
#EXPECTED RESULTS: UW can able to Rewrite - New the cancelled Policy and add new coverage
#User:UW
@regression @mtr432 @gu
Feature: UW can able to Rewrite - New the cancelled Policy, add new coverage and see Greeting Letter

  Scenario: Verify DP1 NB Policy is cancelled and UW can able to rewrite the cancelled Policy
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen <mtr432>
    And User enters all required information on DP1 dwelling screen
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates NB DP1 policy has been created successfully and takes note of the policy number for <mtr432>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr432>
    And User selects Property Sold as reason <mtr432>
    And User sets the effective date as after 1 month from the current date and validates error message <mtr432>
    And User clicks Start Transaction
    And User selects Rewrite-New
    And User clicks Start button
    And User clicks Dwelling chevron
    And User enters Coverage A Dwelling as 350000
    And User clicks Review Chevron
    And User enters all required information on HO4 review screen <mtr432>
    Then User validates Rewrite - New Business <mtr432>
    And User clicks Forms chevron
    Then User validates Greeting Letter form is generated
    And User clicks Dwelling chevron
    Then User validates Coverage A Dwelling is 350000

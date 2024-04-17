# Author: Mustafa Cemek
# created on 03/27/2024
#TEST CASE NUMBER & TITLE: MTR-429-HO4-As an Underwriter I would like the ability to process a rewrite-New on Cancelled NB policy
#Precondition-Create  HO4 Policy with Full payment Plan and Cancelled flat with effective date as cancellation date
#HIGH LEVEL STEPS OF TEST SCRIPT:  In the Scenario Below
#EXPECTED RESULTS: UW can able to Rewrite - New the cancelled Policy and add new coverage
#User:UW
@regression @mtr429 @gu 
Feature: UW can able to Rewrite - New the cancelled Policy, add new coverage and see Greeting Letter

  Scenario: Verify HO4 NB Policy is cancelled and UW can able to rewrite the cancelled Policy
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr429>
    And User enters product selection information for HO4 and current effective date <mtr429>
    And User enters all required information on HO4 quote screen <mtr429>
    And User enters all required information on HO4 dwelling screen <mtr429>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO4 policy has been created successfully and takes note of the policy number <mtr429>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr429>
    And User selects Property Sold as reason <mtr429>
    And User sets the effective date as after 1 month from the current date and validates error message <mtr429>
    And User clicks Start Transaction
    And User selects Rewrite-New
    And User clicks Start button
    And User clicks Dwelling chevron
    And User clicks Home Cyber Protection
    And User clicks Review Chevron
    And User enters all required information on HO4 review screen <mtr429>
    Then User validates Rewrite - New Business <mtr429>
    And User clicks Forms chevron
    Then User validates Greeting Letter form is generated
    And User clicks Dwelling chevron
    Then User validates new coverage is added and displayed

# Author: Mustafa Cemek
# created on 03/29/2024
#TEST CASE NUMBER & TITLE: MTR-430-SC-HO3 -As an Underwriter, I would like the ability to process rewrite-Renewal on Cancelled RNEWAL policy
#Precondition-Create  SC-HO3 Policy with Full payment Plan and Cancelled flat with effective date as cancellation date
#HIGH LEVEL STEPS OF TEST SCRIPT:  In the Scenario Below
#EXPECTED RESULTS: UW can able to Rewrite-Renewal the cancelled Policy and add new coverage
#User:UW
@regression @mtr430 @gu 
Feature: UW can able to Rewrite-Renewal the cancelled Policy, add new coverage and see Greeting Letter

  Scenario: Verify SC-HO3 NB Policy is cancelled and UW can able to Rewrite-Renewal the cancelled Policy
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen <mtr430>
    And User enters SC HO3 product selection information and current date as effective date
    And User enters all required information on SC HO3 quote screen <mtr430>
    And User enters all required information on SC HO3 dwelling screen <mtr430>
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr430>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr430>
    And User selects Property Sold as reason <mtr430>
    And User sets the effective date as after 1 month from the current date and validates error message <mtr430>
    And User clicks Start Transaction
    And User selects Rewrite-Renewal
    And User clicks Start button
    And User clicks Dwelling chevron
    And User enters Coverage A Dwelling as 350000 <mtr430>
    And User clicks Review Chevron
    And User enters all required information on SC HO3 review screen <mtr430>
    Then User validates Rewrite-Renewal created <mtr430>
    And User clicks Forms chevron
    Then User validates Greeting Letter form is generated <mtr430>
    And User clicks Dwelling chevron
    Then User validates Coverage A Dwelling is 350000 <mtr430>

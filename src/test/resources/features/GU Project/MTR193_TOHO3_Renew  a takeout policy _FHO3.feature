# Author: Mustafa Cemek
# created on 04/24/2024
#TEST CASE NUMBER & TITLE: MTR `193-Renew  a takeout policy _FHO3
#Precondition: Create a HO6 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Revised RN policy should be displayed by UW
#User: Standard Agent, Underwriter
@regression @mtr193 @gu
Feature: MTR193_TOHO3_Validate Renew a TOHO3 policy

  Scenario Outline: Validate Renew a TOHO3 policy
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters TOHO3 product selection information and effective date <mtr193>
    And User enters all required information on TOHO3 quote screen <mtr193>
    And User enters all required information on TOHO3 dwelling screen
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects dwelling type
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TOHO3 policy has been created successfully and takes note of the policy number <mtr193>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User Searchs for Policy Number for <mtr193>
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User changes insured information
    Then User verifies RN HO6 policy has been created successfully

# Author: Mustafa Cemek
# created on 04/24/2024
#TEST CASE NUMBER & TITLE: MTR 192-Renew a policy _FHO6
#Precondition: Create a HO6 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Revised RN policy should be displayed by UW
#User: Standard Agent, Underwriter
@regression @mtr192 @gu
Feature: MTR192_HO6_Validate Renew a HO6 policy

  Scenario Outline: Validate Renew a HO6 policy
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO6 product selection information and effective date <mtr192>
    And User enters all required information on HO6 quote screen <mtr192>
    And User enters all required information on HO6 dwelling screen
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully and takes note of the policy number <mtr192>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User Searchs for Policy Number for <mtr192>
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User changes insured information
    Then User verifies RN HO6 policy has been created successfully

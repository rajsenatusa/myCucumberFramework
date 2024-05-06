# Author: Mustafa Cemek
# created on 03/15/2024
#TEST CASE NUMBER & TITLE: MTR222_Reinstate a policy _ FHO4
#Precondition-Need FHO4 Pro Rata or Flat Cancelled Policy
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validate, System should process the Reinstatement without any  lapse
#User:admin, underwriter
@regression @mtr222 @gu  
Feature: MTR-222_Reinstate a policy _ HO4

  Scenario: Validate, Underwriter can process the Reinstatement
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for HO4 and current effective date <222>
    And User enters all required information on HO4 quote screen
    And User enters all required information on HO4 dwelling screen
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO4 policy has been created successfully and takes note of the policy number for <mtr222>
    And User clicks Start Transaction <mtr219>
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr219>
    And User selects Property Sold as reason <mtr154>
    And User sets the effective date as after 2 months from the current date
    And User clicks Process <mtr219>
    Then User validates that HO4 policy has been canceled successfully
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr222>
    Then User validates that HO4 policy has been canceled successfully
    And User clicks Start Transaction
    And User selects Reinstatement and validates <mtr219>

# Author: Mustafa Cemek
# created on 03/15/2024
#TEST CASE NUMBER & TITLE: MTR219_Reinstate a policy _ Takeout FMHPD
#Precondition-Need Takeout FMHPD Pro Rata or Flat Cancelled Policy
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validate, System should process the Reinstatement without any  lapse
#User:admin, underwriter
@regression @mtr219 @gu  
Feature: MTR-219_Reinstate a policy _ Takeout FMHPD

  Scenario: Validate, Underwriter can process the Reinstatement
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHPD and current effective date <219>
    And User enters all required information on TOMHPD quote screen
    And User enters all required information on TOMHPD dwelling screen
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TOMHPD policy has been created successfully and takes note of the policy number for <mtr219>
    And User clicks Start Transaction <mtr219>
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr219>
    And User selects Property Sold as reason <mtr154>
    And User sets the effective date as after 2 months from the current date
    And User clicks Process <mtr219>
    Then User validates that TOMHPD policy has been canceled successfully
    And User signs out
    Given User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr219>
    Then User validates that TOMHPD policy has been canceled successfully
    And User clicks Start Transaction
    And User selects Reinstatement and validates <mtr219>

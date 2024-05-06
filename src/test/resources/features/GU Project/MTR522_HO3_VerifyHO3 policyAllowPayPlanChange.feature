# Author: Mustafa Cemek
# created on 03/20/2024
#TEST CASE NUMBER & TITLE: MTR-522-Verify HO3 policy AllowPayPlanChange
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validating As a Sales Agent, I would like the ability to update/endorse a policy
#User: Standard Agent, Admin
@regression @mtr522 @gu
Feature: MTR522_HO3_Verify_AllowPayPlanChange

  Scenario: Validate Agent is able to change bill plan within 5 days of policy effective date up to maximum 2 times
    Given User login to Spin as Admin Agent
    And User clicks Admin Tab
    And User clicks User Management Tab
    And User searches Agent <AG0376>
    And User clicks Search button
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard
    And User sets Number Days From Effective Date Allowed Pay Plan to <5> days
    And User sets Number of Allowed Pay Plan to <2> and validates numbers display
    And User clicks save
    And User signs out
    When User login to Spin as Automation Test Agent
    And User changes system date to current date <mtr522>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr553>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr553>
    And User enters all required information on HO3 dwelling screen <mtr553>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr553>
    And User clicks Finalize button <mtr553>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr522>
    And User clicks Billing Chevron
    And User clicks Change Pay Plan
    And User changes Pay Plan to <8 Payment Plan> <mtr522>
    And User gets next action date and changes system date as next 3 days <mtr522>
    And User searches policy for <mtr522>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User selects endorsement date as system date plus 3 days
    And User clicks Review Chevron
    And User clicks Change Pay Plan <mtr522>
    And User selects Pay Plan Type as Automated Credit Card
    And User changes Pay Plan to <4 Payment Plan> <mtr522>
    And User enters Pay Plan Information
    And User clicks Finalize button
    And User clicks Endore Policy button
    And User clicks Billing Chevron
    Then User validates 'Change Pay Plan' hyperlink is not longer visable to Agent
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User selects endorsement date as system date plus 3 days
    And User clicks Review Chevron
    Then User validates 'Payment Plan' cannot be edited to Agent
    And User signs out
    Given User login to Spin as Admin Agent
    And User clicks Admin Tab
    And User clicks User Management Tab
    And User searches Agent <AG0376>
    And User clicks Search button
    And User scrolls to User Roles List
    And User clicks Override Link on Policy Agent Standard
    And User sets Number Days From Effective Date Allowed Pay Plan to <0> days <mtr522>
    And User sets Number of Allowed Pay Plan to <0> and validates numbers display <mtr522>
    And User clicks save
    And User signs out

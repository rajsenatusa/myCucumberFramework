## Author: Mustafa Cemek
## created on 02/13/2024
## TEST CASE NUMBER & TITLE: MTR153--VOL HO3, Cancel  a policy _FHO3
## PRECONDITIONS (IF ANY): VOL HO3 NB
## HIGH LEVEL STEPS OF TEST SCRIPT:  In the Scenario Below
## EXPECTED RESULTS: Cancellation should process
## User: Underwriter
@regression @mtr153 @gu 
Feature: MTR153-VOL HO3, Verify Underwriter is able to Cancel policy 

  Scenario: Validate Cancellation should process with UW user
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO3 product selection information and current date as effective date <mtr153>
    And User enters all required information on HO3 quote screen <mtr153>
    And User enters all required information on HO3 dwelling screen
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO3 policy has been created successfully and take note of the policy number <mtr153>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr153>
    And User clicks Start Transaction
    And User selects Cancellation Notice
    And User selects Cancellation Type as Company
    And User selects Roof Disrepair as reason <mtr153>
    And User sets the effective date as before 1 day from the current date and validates error message
    And User searches for the policy number <mtr153>
    And User clicks Start Transaction
    And User selects Cancellation Notice
    And User selects Cancellation Type as Company
    And User selects Roof Disrepair as reason <mtr153>
    And User sets the effective date as after 30 days from the current date and validates messages
    And User validates Policy Status displayed as Cancel Notice <mtr153>
    And User clicks Policy File Chevron <mtr153>
    Then User validates Cancellation Notice Confirmation form listed and validates form <mtr153>

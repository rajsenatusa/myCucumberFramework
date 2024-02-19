## Author: Mustafa Cemek
## created on 02/14/2024
## TEST CASE NUMBER & TITLE: MTR154--VOL HO6, Cancel  a policy _FHO6
## PRECONDITIONS (IF ANY): VOL HO6 NB
## HIGH LEVEL STEPS OF TEST SCRIPT:  In the Scenario Below
## EXPECTED RESULTS: Cancellation should process
## User: Underwriter
@regression @mtr154
Feature: MTR154-VOL HO6, Verify Underwriter is able to Cancel policy

  Scenario: Validate Cancellation should process with UW user
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO3 product selection information and current date as effective date <mtr154>
    And User enters all required information on HO6 quote screen <mtr154>
    And User enters all required information on HO6 dwelling screen
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO6 policy has been created successfully and take note of the policy number <mtr154>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr154>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Insured <mtr154>
    And User selects Property Sold as reason <mtr154>
    And User sets the effective date as before 1 day from the current date and validates error message <mtr154>
    And User searches for the policy number <mtr154>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Insured
    And User selects Property Sold as reason <mtr154>
    And User sets the effective date as after 30 days from the current date and validates messages
    And User clicks Policy File Chevron <mtr154>
    Then User validates Cancellation Confirmation form listed and validates form <mtr154>

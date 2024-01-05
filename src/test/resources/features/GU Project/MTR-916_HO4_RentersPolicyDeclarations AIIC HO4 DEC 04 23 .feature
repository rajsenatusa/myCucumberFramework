# Author: Mustafa Cemek
# created on 01/05/2024
#TEST CASE NUMBER & TITLE: GU-1525_MTR-916: Verify the updated  Voluntary HO4: Renters Policy Declarations AIIC HO4 DEC 04 23
#Precondition-Policy Eff 04/21/2023, Update wording  and version changes to Vol HO4 Renters Policy Declarations (NB). Renters Policy Declarations AIIC HO4 DEC 04 23
#HIGH LEVEL STEPS OF TEST SCRIPT:
#EXPECTED RESULTS: FORM content and formatting match clean copies attached to the AIIC HO4 DEC 04 23 displays on  bottom of all pages. Validate AIIC HO4 DEC 04 23 form is as expected.
#User:admin
@regression @mtr916 @gu
Feature: MTR-916_HO4_Renters Policy Declarations AIIC HO4 DEC 04 23

  Scenario: Validate AIIC HO4 DEC 04 23 form content and formatting match clean copies
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr916>
    And User enters HO4 product selection information and effective date as 04.21.2023
    And User enters all required information on HO4 quote screen <mtr916>
    And User enters all required information on HO4 dwelling screen <mtr916>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that HO4 policy has been created successfully and takes note of the policy number <mtr916>
    And User clicks Policy File Chevron for <mtr916>
    And User clicks HO4 Decleration link
    And User validates AIIC HO4 DEC 04 23 form version listed in the declaration package
    And User clicks HO4 New Business package link
    And User validates AIIC HO4 DEC 04 23 form version listed in the New Business package
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User validates that HO4 policy has been created successfully and takes note of the policy number <mtr916>
    And User clicks Policy File Chevron for <mtr916>
    And User clicks HO4 Decleration link
    And User validates AIIC HO4 DEC 04 23 form version listed in the declaration package
    And User clicks HO4 New Business package link
    And User validates AIIC HO4 DEC 04 23 form version listed in the New Business package

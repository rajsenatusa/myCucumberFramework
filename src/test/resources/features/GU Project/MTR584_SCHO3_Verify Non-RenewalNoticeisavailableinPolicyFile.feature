## Author: Mustafa Cemek
## created on 01/08/2024
## TEST CASE NUMBER & TITLE: MTR584--SC HO3, Verify Non-Renewal Notice is available in Policy File
## PRECONDITIONS (IF ANY): Non-Renewal SC HO3 policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  In the Scenario Below
## EXPECTED RESULTS: Non-Renewal Notice displays
## User: Underwriter
@regression @mtr584 @gu
Feature: MTR584--SC HO3, Verify Non-Renewal Notice in Policy File

  Scenario: Verify Non-Renewal Notice
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen
    And User enters SC HO3 product selection information and 01 01 2024 date for <mtr584>
    And User enters all required information on SC HO3 quote screen
    And User enters all required information on SC HO3 dwelling screen
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates SC HO3 policy has been created successfully and takes note of the policy number for <mtr584>
    And User clicks Start Transaction
    And User clicks Non-Renewal Transaction Selection
    And User selects 'Failure to comply with underwriting requirements' as reason
    And User clicks Process
    Then User validates Non_Renewal HO3 policy has been created successfully and takes note of the policy number for <mtr584>
    And User signs out
    And User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr584>
    And User clicks Policy File Chevron <mtr584>
    And User clicks Non Renewal Notice Hyperlink and validates Non renewal Notice displays

# Author: Mustafa Cemek
# created on 01/12/2024
#TEST CASE NUMBER & TITLE: GU-1171_MTR-458: DP1 Verify as an Underwriter has the ability to create Inspection notes but does not have Edit or Delete access
#Precondition: Create a DP1 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter has the ability to create Inspection notes but does not have Edit or Delete
#User:Underwriter
@regression @mtr458 @gu
Feature: MTR458_DP1_Verify_Underwriter_creates_Inspection_notes_but_does_not_have_Edit_or_Delete

  Scenario: Verify_Underwriter_creates_Inspection_notes_but_does_not_have_Edit_or_Delete
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen
    And User enters all required information on DP1 dwelling screen
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates NB DP1 policy has been created successfully and takes note of the policy number for <mtr458>
    And User signs out
    And User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr458>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a New Note for <mtr458>
    And User validates a New Note has been created successfully in Notes List <mtr458>
    Then User verifies that no Edit or Delete links are displayed

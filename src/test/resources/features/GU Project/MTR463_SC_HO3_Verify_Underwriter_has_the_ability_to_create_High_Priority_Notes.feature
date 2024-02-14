# Author: Mustafa Cemek
# created on 02/12/2024
#TEST CASE NUMBER & TITLE: GU-1171_MTR-463: SC HO3 Verify Underwriter has the ability to create High Priority Notes
#Precondition: Create a SC HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter can create Inspection Note & Priviliged Note with Agent Task with Urgent Priority SC HO3. Agent. UW manager can edit the Inspection Note.
#User: Underwriter, SC Standard Agent, Underwriter Clerk

@regression @mtr463 @scregression @gu

Feature: MTR463-SC HO3, Verify Underwriter has the ability to create High Priority Notes

  Scenario: Verify Inspection Note & Priviliged Note notes created by Underwriter. Agent is not able to see Company Privileged Note. UW manager can edit the Inspection Note
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen
    And User enters SC HO3 product selection information and current date as effective date for <mtr463>
    And User enters all required information on SC HO3 quote screen
    And User enters all required information on SC HO3 dwelling screen
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr463>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates an Inspection Note for <mtr463>
    Then User validates a New Inspection Note has been created successfully in Notes List <mtr463>
    Then User verifies that no Edit or Delete links are displayed
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a New Priviliged Note for <mtr463>
    Then User validates a New Priviliged Note has been created successfully in Notes List <mtr463>
    And User signs out
    Given User login to Spin as SC Standard Agent
    And User Searchs for Policy Number for <mtr463>
    And User clicks Notes Chevron
    Then User verifies that Agent cannot see Company Privileged Note
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User Searchs for Policy Number for <mtr463>
    And User clicks Notes Chevron
    Then User verifies that Underwriter Manager can Edit and Save Inspection Note for <mtr463>

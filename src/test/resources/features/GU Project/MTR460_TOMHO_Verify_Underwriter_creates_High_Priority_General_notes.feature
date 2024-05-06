# Author: Mustafa Cemek
# created on 01/16/2024
#TEST CASE NUMBER & TITLE: GU-1171_MTR-460: TOMHO Verify as an Underwriter has the ability to create low priority Company Priviledged Notes
#Precondition: Create a TOMHO policy. Underwriter creates High Priority General notes.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter can create and see the High Priority General notes. Agent is not able to see Company Privileged Note
#User:Underwriter
@regression @mtr460 @gu
Feature: MTR-460 TOMHO_Verify Underwriter creates High Priority General notes

  Scenario: Verify High Priority General notes created by Underwriter. Agent is not able to see Company Privileged Note
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHO and current date
    And User enters all required information on TOMHO quote screen
    And User enters all required information on TOMHO dwelling screen <mtr460>
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates TOMHO policy has been created successfully and takes note of the policy number for <mtr460>
    And User signs out
    And User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr460>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a New Note for <mtr460>
    Then User validates a New Note has been created successfully in Notes List
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Policy Number for <mtr460>
    And User clicks Notes Chevron
    Then User validates Agent is not able to see Company Privileged Note that was created by Underwriter

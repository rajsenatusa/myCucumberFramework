# Author: Mustafa Cemek
# created on 01/17/2024
#TEST CASE NUMBER & TITLE: GU-1171_MTR-461: TODP1 Verify as an Underwriter has the ability to create High Priority Inspection Note
#Precondition: Create a TODP1 policy. Underwriter creates General and Inspection notes.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter can create and see the Inspection and General notes. Edit or Delete buttons not displays for UW user. Agent is  able to see Inspection & General Note that was created. System allows UW Manager to Edit and Delete the note
#User:Underwriter
@regression @mtr461 @gu
Feature: MTR-461 TODP1_Verify_Underwriter_creates_High_Priority_Inspection_notes

  Scenario: Verify Inspection and General notes created by Underwriter. Agent is able to see them. UW manager can delete the General Note
    Given User login to Spin as Admin Agent
    And User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP1 and current date for <mtr461>
    And User enters all required information on TODP1 quote screen
    And User enters all required information on TODP1 dwelling screen
    And User enters all required information on TODP1 review screen
    And User creates TODP1 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates TODP1 policy has been created successfully and takes note of the policy number for <mtr461>
    And User signs out
    And User login to Spin as Underwriter
    And User Searchs for Policy Number for <mtr461>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a General Note
    And User clicks Add Note button
    And User creates an Inspection Note
    Then User validates Inspection and General Notes have been created successfully in Notes List
    Then User verifies that no Edit or Delete links are displayed
    And User signs out
    And User login to Spin as Standard Agent
    And User Searchs for Policy Number for <mtr461>
    And User clicks Notes Chevron
    Then User verifies that Agent can see Inspection and General Notes
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User Searchs for Policy Number for <mtr461>
    And User clicks Notes Chevron
    Then User verifies that Edit or Delete links are displayed
    Then User verifies that Underwriter Manager can Delete and Save General Note
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

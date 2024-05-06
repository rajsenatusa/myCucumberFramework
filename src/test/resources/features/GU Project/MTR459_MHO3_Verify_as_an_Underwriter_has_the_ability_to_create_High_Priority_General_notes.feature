# Author: Mustafa Cemek
# created on 01/10/2024
#TEST CASE NUMBER & TITLE: GU-1171_MTR-459: MHO3 Verify as an Underwriter has the ability to create High Priority General notes
#Precondition: Create a MHO3 policy. Underwriter creates High Priority General notes.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter can create and see the High Priority General notes. Agent is not able to see Company Privileged Note
#User:Underwriter
@regression @mtr459 @gu 
Feature: MTR-459 MHO3_Verify Underwriter creates High Priority General notes

  Scenario: Verify High Priority General notes created by Underwriter
    Given User navigates to Model
    And User login to Spin as Standard Agent
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters current date
    And User enters state
    And User clicks VOL MHO3 policy
    And User clicks MHO3 Prior Carrier
    And User enters Prior Policy Expiration Date
    And User clicks Property Type as Private Property
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy 
    And User enters Months Occupied for MHO3   
    And User clicks Next Page
    And User enters Year of Construction  
    And User enters Coverage A Dwelling
    And User clicks Save
    And User clicks Review button
    And User enters MHO3 Pay Plan Type
    And User answers all underwriting questions for MHO3
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    Then User validates NB MHO3 policy has been created successfully and takes note of the policy number for <mtr459>
    And User signs out
    And User login to Spin as Underwriter
    And User Searchs for Policy Number
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a New Note
    And User validates a New Note has been created successfully in Notes List
    And User signs out
    Given User login to Spin as Standard Agent
    And User Searchs for Policy Number
    And User clicks Notes Chevron
    Then User validates Agent is not able to see Company Privileged Note that was created by Underwriter

    
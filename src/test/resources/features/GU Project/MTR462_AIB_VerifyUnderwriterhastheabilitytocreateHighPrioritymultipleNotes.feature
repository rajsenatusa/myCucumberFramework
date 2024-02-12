# Author: Mustafa Cemek
# created on 02/12/2024
#TEST CASE NUMBER & TITLE: GU-1171_MTR-462: AIB Verify Underwriter has the ability to create High Priority multiple Notes
#Precondition: Create a AIB policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Underwriter can create and see the High Priority General notes. Agent is not able to see Company Privileged Note. But can see General Note
#User: Underwriter
@regression @mtr462 @gu
Feature: MTR-462 AIB_Verify Underwriter creates High Priority General notes

  Scenario: Verify High Priority General & Company Priviliged notes created by Underwriter. Agent is not able to see Company Privileged Note But can see General Note
    Given User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters AIB product selection information and current date as effective date for <mtr462>
    And User enters all required information on AIB quote screen
    And User selects liability coverage on quote screen
    And User adds operator information on quote screen
    And User enters all required information on AIB boat dwelling screen
    And User enters all required information on AIB review screen
    And User creates AIB application
    And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates AIB policy has been created successfully and takes note of the policy number for <mtr462>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a General Note
    Then User validates a General Note has been created successfully in Notes List <mtr462>
    And User clicks Notes Chevron
    And User clicks Add Note button
    And User creates a New Priviliged Note for <mtr462>
    Then User validates a New Priviliged Note has been created successfully in Notes List <mtr462>
    And User signs out
    And User login to Spin as Standard Agent
    And User Searchs for Policy Number for <mtr462>
    And User clicks Notes Chevron
    Then User verifies that Agent can see General Note
    Then User verifies that Agent cannot see Company Privileged Note

#Author: Can Yavas
##created on 08/21/2023

@regression @tc37260 @mtr373
Feature: TC 37260-MTR373-US1616- AIB - Change Mailing address twice for Endorsement

  Scenario: Validate Endorsement package should show new mailing address under section INSURED NAME AND MAIL ADDRESS
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen
		And User enters AIB product selection information and current date as effective date
		And User enters all required information on AIB quote screen for <tc37260>
		And User selects liability coverage on quote screen for <tc37260>
		And User adds operator information on quote screen
		And User enters all required information on AIB boat dwelling screen for <tc37260>
		And User enters all required information on AIB review screen
		And User creates AIB application
		And User answers all underwriting questions for AIB
		And User checks application dwelling screen and finalizes transaction
		And User takes note of the application for <tc37260>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc37260>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc37260>
    And User issues policy and close unnecessary tabs and taking note of the policy number
    And User clicks Policy File Chevron <tc37260>
    And User clicks Small Boat Application link and validates form version of Application
    And User clicks Small Boat Declaration link and validates form version of Declaration
    And User clicks New Business Package link and validates form version of NB
    And User clicks Policy Chevron
    And User clicks more button and starts endorsement and selects current date plus <5> days as eff date and starts
  	And User changes mailing address and finalizes endorsement
    And User clicks Policy File Chevron <tc37260>
    And User clicks Endorsement Package link and validates form version of Endorsement
    And User clicks Policy Chevron
    And User clicks more button and starts endorsement and selects current date plus <5> days as eff date and starts
    And User changes mailing address second time and finalizes endorsement
    And User clicks Policy File Chevron <tc37260>
    And User clicks Endorsement Package link and validates form version of Endorsement with new address and completes test
    
    
    
    
    
    
    
    
    
    
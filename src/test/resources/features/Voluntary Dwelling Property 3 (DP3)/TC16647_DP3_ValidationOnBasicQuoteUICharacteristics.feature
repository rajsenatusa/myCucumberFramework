# Author: Can Yavas
# created on 11/16/2023

 # TEST CASE NUMBER & TITLE: TC 16647--DP3 Agent NB UI Basic Quote Mode 
 # PRECONDITIONS (IF ANY)
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Create DP3 basic quote as an agent with validating all mandatory and subtiles on each chevron
  
 # EXPECTED RESULTS: Quote is created while validating UI.  
  
 # User: AG1730

@regression @tc16647
Feature: TC 16647--DP3 Agent NB UI Basic Quote Mode UI Validations

  Scenario: Validate Quote is created while validating UI
    Given User login to Spin as Admin Agent
    And User clicks Admin Tab 
    When User clicks User Management Tab
    And User searches Agent <Ag1730> tc16647
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Override Link on Policy Agent Standard
    And User sets Question Matching Limit and Question Unusual Liability as Yes
    And User clicks save
		And User signs out
    And User login to Spin as Underwriter
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16647>
    And User enters DP3 product selection information and effective date as current date and do UI validations <tc16647>
    And User enters all required information on DP3 quote screen and do UI validations <tc16647>
    And User enters all required information on DP3 dwelling screen and do UI validations <tc16647>
    
    
    
    
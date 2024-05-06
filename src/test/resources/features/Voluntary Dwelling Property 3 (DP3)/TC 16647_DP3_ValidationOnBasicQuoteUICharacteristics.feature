# Author: Can Yavas
# created on 11/16/2023

 # TEST CASE NUMBER & TITLE: TC 16647--DP3 Agent NB UI Basic Quote Mode 
 # PRECONDITIONS (IF ANY)
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Create DP3 basic quote as an agent with validating all mandatory and subtiles on each chevron
  
 # EXPECTED RESULTS: Quote is created while validating UI.  
  
 # User: AG1730

@regression @tc16647 @dp3regression
Feature: TC16647 DP3 Agent NB UI Basic Quote Mode UI Validations

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
    And User login to Spin as Standard Agent
    And User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16647>
    And User enters DP3 product selection information and effective date as current date and do UI validations <tc16647>
    And User enters all required information on DP3 quote screen and do UI validations <tc16647>
    And User enters all required information on DP3 dwelling screen and do UI validations <tc16647>
    And User validates fields on Replacement cost estimator tile
    And User validates hurricane deductible populated value
    And User validates coverages and additional options and selections on UI
    And User selects flood coverage as Yes and validates fields on UI
    And User validates coverage list tile on UI
    Then User enters all required information on DP3 review screen sets Order Insurance Score as Yes do validations with different pay plan selection
    
    
    
    
    
    
    
    
    
    
    
    
    
#Author: Can Yavas
##created on 10/20/2023

# TEST CASE NUMBER & TITLE: TC 35177--MHO Park AGENT UW NB - Validate Policy Agent cannot issue Roof Material Composition Shingle- NB Roof >16 but UW can issue
# PRECONDITIONS (IF ANY): Agent being used has the default set for attribute 'Allow Rolled/Butimen Roof with Age>= 16 years' (default = No)
# Agent and Underwriter must have Change Date Role
 
# HIGH LEVEL STEPS OF TEST SCRIPT:  Validate the new attribute will not allow an agent to issue a policy with 
# Roof Material=Composition Shingle, Year Roof Material Updated > 16 years old, regardless of Roof Settlement
 
# EXPECTED RESULTS: Hard Stop Message displays "Risk is ineligible due to roof material and roof age."  
 
# User: AG1730


@regression @tc35177 @MTR4506 @mho3regression
Feature: MTR4506-MHO Park AGENT UW NB - Validate Policy Agent cannot issue Roof Material Composition Shingle- NB Roof >16 but UW can issue

  Scenario: Validate the new attribute will not allow an agent to issue a policy with Roof Material is Composition Shingle, Year Roof Material Updated over 16 years old, regardless of Roof Settlement
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address <tc35177>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen and selects park as property type <tc35177>
    And User enters all required information on MHO3 dwelling screen and sets covA as <65000> <tc35177>
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen, validates 'Risk is ineligible based upon roof material and roof age' message displayed and finalizes transaction
    And User takes note of the application number for <tc35177>
    And User validates 'Issue New Business' and 'Submit For Approval' buttons are not visible and premium amount equals to zero on closeout screen
    And User signs out
    And User login to Spin as Underwriter
		And User searches previously created application for <tc35177>
    And User takes ownership of the application
    And User finalizes transaction
    And User validates 'Risk is ineligible based upon roof material and roof age' message has been displayed
    And User issues policy
    Then User verifies NB MHO3 policy has been created successfully and comppletes test <tc35177>
    
    
    
    
    
    
    
    
    
#Author: Can Yavas
##created on 10/19/2023

# TEST CASE NUMBER & TITLE: TC38507: US 8918: DP1 RULE - Metal/Tile roof material age change - NB = 25 years
# Precondition-Issue NB effective 07/01/2022,MMA =No
# HIGH LEVEL STEPS OF TEST SCRIPT:  

# EXPECTED RESULTS:Agent can issue DP1 policy without referral
 
# User:AG1730


@regression @tc38507 @MTR4371
Feature: TC38507: MTR4371 US 8918: DP1 RULE - Metal/Tile roof material age change - NB = 25 years

  Scenario: Validating that Agent can issue DP1 policy without referral
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc38507>
    And User enters DP1 product selection information and current date as effective date
    And User enters all required information on DP1 quote screen <tc38507>
    And User enters all required information on DP1 dwelling screen <tc38507>
    And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen, select number of stories, plumbing, electrical and hvac updated dates and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and completes test <tc38507>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
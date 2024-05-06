#Author: Can Yavas
##created on 10/31/2023

# TEST CASE NUMBER & TITLE: TC 33769--TO MHO AF: RULES - Modify Deductible Rules and Edits
# PRECONDITIONS (IF ANY): Change date to 30 days prior to Creating TOMHO policy with an effective on or after 
# 7/24/2021 (remove hard coded date after go live) With AOP,Fire, and VM&M  Deductibles at 2,500, HURR is 10%
# Agent and Underwriter must have Change Date Roles

# HIGH LEVEL STEPS OF TEST SCRIPT: As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
# After RN Effective Date & UW Approval 
 
# EXPECTED RESULTS:  
  
# User: Admin, Agent

@regression @tc33769 @MTR4459 @tomhoregression @tomhoregressionFEB @AIItomho
Feature: MTR4459-TO MHO AF: RULES - Modify Deductible Rules and Edits

  Scenario: As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, After RN Effective Date UW Approval 
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc33769>
    And User enters product selection information for TOMHO and current date as effective date
    And User enters all required information on TOMHO quote screen <tc33769>
    And User enters all required information on TOMHO dwelling screen <tc33769>
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron <tc33769>
    And User completes required information on dwelling screen <tc33769>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHO policy has been created successfully and takes note of the policy number <tc33769>
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to current date minus 1 day <tc33769>
    And User searches for the policy number <tc33769>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33769>
    And User clicks dwelling chevron <tc33769>
    And User decrease deductibles <tc33769>
    And User finalizes transaction and validates ded changes are visible on closeout screen and completes endorsement <tc33769>
    And User changes system date to current date <tc33769>
    And User searches for the policy number <tc33769>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33769>
    And User clicks dwelling chevron <tc33769>
    And User increases deductibles <tc33769>
    And User finalizes transaction and validates ded changes are visible on closeout screen and completes second endorsement <tc33769>
    And User changes system date to current date plus 1 day <tc33769>
    And User searches for the policy number <tc33769>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33769>
    And User clicks dwelling chevron <tc33769>
    And User decrease deductibles <tc33769>
    And User clicks Policy Chevron <tc33769>
    And User validates expected validation messages on policy chevron <tc33769>
    And User finalizes transaction and validates expected messages on closeout screen <tc33769>
    And User takes note of the application number for <tc33769>
    And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for application number <tc33769>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for application number <tc33769>
    And User process and completes endorsement and finishes test <tc33769>
    
    
    
    
    
    
    
    
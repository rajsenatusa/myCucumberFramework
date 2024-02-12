#Author: Can Yavas
##created on 11/27/2023

 # TEST CASE NUMBER & TITLE: TC 33726-MTR4727-TO MHPD AF: RULES - Modify Deductible Rules and Edits
 # PRECONDITIONS (IF ANY): Change date to 30 days prior to Creating TOMHPD policy with an effective on or after 
 # 7/24/2021 (remove hard coded date after go live) With AOP,Fire, and VM&M  Deductibles at 2,500, HURR is 10%
 # Agent and Underwriter must have Change Date Roles

 # HIGH LEVEL STEPS OF TEST SCRIPT: As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
 # After RN Effective Date & UW Approval 
  
 # EXPECTED RESULTS:  
  
 # User: Admin, Agent


@regression @tc33726 @tomhpdregression @mtr4727 @tomhpdregressionFEB
Feature: MTR4727-TO MHPD AF: RULES - Modify Deductible Rules and Edits

  Scenario: Validate As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, After RN Effective Date & UW Approval
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc33726>
    And User enters product selection information for TOMHPD and current date as effective date
    And User enters all required information on TOMHPD quote screen <tc33726>
    And User enters all required information and sets deductibles on TOMHPD dwelling screen <tc33726>
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks Dwelling Chevron and completes required information <tc33726>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHPD policy has been created successfully and takes note of the policy number <tc33726>
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to current date minus 1 day
    And User searches for the policy number <tc33726>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33726>
    And User clicks Dwelling Chevron for <tc33726>
    And User decrease deductibles <tc33726>
    And User finalizes transaction and validates deductible change messages has been displayed and process transaction <tc33726>
    And User changes system date to current date <tc33726>
    And User searches for the policy number <tc33726>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33726>
    And User clicks Dwelling Chevron for <tc33726>
    And User increase deductibles <tc33726>
    And User finalizes transaction and validates increased deductible change messages has been displayed and process transaction <tc33726>
    And User changes system date to current date plus 1 day <tc33726>
    And User searches for the policy number <tc33726>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33726>
    And User clicks Dwelling Chevron for <tc33726>
    And User decrease deductibles <tc33726>
    And User clicks Policy Chevron
    And User validates expected issue messages <tc33726>
    And User finalizes transaction and validates second time increased deductible change messages has been displayed and takes note of the application number <tc33726>
    And User clicks submit for approval with popup <tc33726>
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc33726>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <tc33726>
    And User process and completes endorsement and finishes test <tc33726>
    
    
    
    
    
    
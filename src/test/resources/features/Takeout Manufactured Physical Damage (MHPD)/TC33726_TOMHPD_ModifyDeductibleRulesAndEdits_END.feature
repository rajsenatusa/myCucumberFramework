#Author: Can Yavas
##created on 11/27/2023

 # TEST CASE NUMBER & TITLE: TC 33726--TO MHPD AF: RULES - Modify Deductible Rules and Edits
 # PRECONDITIONS (IF ANY): Change date to 30 days prior to Creating TOMHPD policy with an effective on or after 
 # 7/24/2021 (remove hard coded date after go live) With AOP,Fire, and VM&M  Deductibles at 2,500, HURR is 10%
 # Agent and Underwriter must have Change Date Roles

 # HIGH LEVEL STEPS OF TEST SCRIPT: As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
 # After RN Effective Date & UW Approval 
  
 # EXPECTED RESULTS:  
  
 # User: Admin, Agent


@regression @tc33726
Feature: TC 33726--TO MHPD AF: RULES - Modify Deductible Rules and Edits

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
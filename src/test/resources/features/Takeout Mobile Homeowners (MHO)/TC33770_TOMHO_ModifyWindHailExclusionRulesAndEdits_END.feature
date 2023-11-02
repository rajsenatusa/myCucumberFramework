#Author: Can Yavas
##created on 10/30/2023

 # TEST CASE NUMBER & TITLE: TC 33770--TO MHO AF: RULES - Modify Windstorm or Hail Exclusion Rules and Edits
 # PRECONDITIONS (IF ANY): Change date to 30 days prior to Creating TOMHO policy with an effective on or after 
 # 7/24/2021 (remove hard coded date after go live) With WInd Hail Exclusion Checked
 # Agent and Underwriter must have Change Date Roles

 # HIGH LEVEL STEPS OF TEST SCRIPT: As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
 # After RN Effective Date & UW Approval 
  
 # EXPECTED RESULTS:  
 # xxx Test Is Ineffective due to rule change 
 # User: Admin, Agent

 @tc33770
Feature: TC 33770--TO MHO AF: RULES - Modify Windstorm or Hail Exclusion Rules and Edits

  Scenario: As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, After RN Effective Date UW Approval 
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc33770>
    And User enters product selection information for TOMHO and current date as effective date
    And User enters all required information on TOMHO quote screen <tc33770>
    And User enters all required information on TOMHO dwelling screen <tc33770>
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron <tc33770>
    And User completes required information on dwelling screen <tc33770>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHO policy has been created successfully and takes note of the policy number <tc33770>
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to current date minus 1 day <tc33770>
    And User searches for the policy number <tc33770>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33770>
    And User clicks dwelling chevron <tc33770>
    And User validates Windhail Exclusion Selection is disabled
    And User cancels transaction
    And User changes system date to current date <tc33770>
    And User searches for the policy number <tc33770>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33770>
    And User clicks dwelling chevron <tc33770>
    And User validates Windhail Exclusion Selection is disabled
    And User cancels transaction
    And User changes system date to current date plus 1 day <tc33770>
    And User searches for the policy number <tc33770>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc33770>
    And User clicks dwelling chevron <tc33770>
    And User validates Windhail Exclusion Selection is disabled
    And User clicks Policy Chevron <tc33770>
    And User validates 'The effective date must not be older than 0 days from today' message has been displayed
    And User takes note of the application number for <tc33770>
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date plus 1 day <tc33770>
    And User searches for the application <tc33770>
    And User takes ownership of the application
    And User clicks dwelling chevron <tc33770>
    And User validates Windhail Exclusion Selection is enabled
    And User unchecks WindHail Exclusion
    And User validates Hurricane Deductible defaulted to <%2>
    Then User finalizes transaction and endorses policy and completes test <tc33770>
    
    
    
    
    
    
    
    
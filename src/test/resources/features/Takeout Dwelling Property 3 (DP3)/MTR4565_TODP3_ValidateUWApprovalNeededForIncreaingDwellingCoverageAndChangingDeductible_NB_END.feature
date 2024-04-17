#Author: Can Yavas
##created on 10/27/2023

 # TEST CASE NUMBER & TITLE: TC 16781--TODP3, Agent, END TX, Increase CovA, Change Deductible, UW MGR Approval
 # PRECONDITIONS (IF ANY):Active TODP3  Policy 
 # HIGH LEVEL STEPS OF TEST SCRIPT:  As an agent, Endorse the policy to Increase CovA, change Deductibles.
 # EXPECTED RESULTS: Underwriter approval is required Approval messages trigger on CloseOut screen
 # Agent must Submit for Approval 
  
 # User: AG1730

@regression @tc16781 @MTR4565 @todp3regression @AIItodp3
Feature: MTR4565-TODP3, Agent, END TX, Increase CovA, Change Deductible, UW MGR Approval

  Scenario: Validate that Underwriter approval is required Approval messages trigger on CloseOut screen
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16781>
    And User enters product selection information for TODP3 and current date as effective date <tc16781>
    And User enters all required information on TODP3 quote screen <tc16781>
    And User enters all required information on TODP3 dwelling screen <tc16781>
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material <tc16781>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TODP3 policy has been created successfully and take note of policy number <tc16781>
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the policy number <tc16781>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 30 days and starts endorsement <tc16781>
    And User clicks Dwelling Chevron for <tc16781>
    And User increases CovA Dwelling and add other coverages <tc16781>
    And User clicks Finalize button, validates changes are visible on closeout screen <tc16781>
    And User takes note of the application for <tc16781>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter 
    And User searches for the application <tc16781>
    And User validates expected following messages on issue tile <tc16781>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc16781>
    Then User process and completes endorsement and finishes test <tc16781>
    
    
    
    
    
    
    
    
    
    
    
    
#Author: Can Yavas
##created on 10/27/2023

 # TEST CASE NUMBER & TITLE: TC 16777--TODP1, Agent, END TX, Increase CovA, Change Deductible, UW MGR Approval
 # PRECONDITIONS (IF ANY):Active TODP1  Policy 
 # HIGH LEVEL STEPS OF TEST SCRIPT:  As an agent, Endorse the policy to Increase CovA, change Deductibles
 # EXPECTED RESULTS: Underwriting Manager  approval is required Appraval messages trigger on CloseOut screen
 # UW  must Submit for Approval
 # Agent  must Submit for Approval 
  
 # User: AG1730

@regression @tc16777 @MTR4564 @todp1regression 
Feature: MTR4564-TODP1, Agent, END TX, Increase CovA, Change Deductible, UW MGR Approval

  Scenario: Validate Underwriting Manager  approval is required Appraval messages trigger on CloseOut screen
 					
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc16777>
    And User enters product selection information for TODP1 and effective date as current date <tc16777>
    And User enters all required information on TODP1 quote screen <tc16777>
    And User enters all required information on TODP1 dwelling screen <tc16777> and sets sinkhole loss ded <10% Ded of Cov A>
    And User enters all required information on TODP1 review screen
		And User creates TODP1 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks Dwelling Chevron for <tc16777>
    And User sets roof material as <3 Tab Composition Shingle>
    And User clicks review Chevron and selects 8 Pay payment plan
		And User finalizes transaction and issues takeout policy
    And User validates that TODP1 policy has been created successfully and takes note of the policy number <tc16777>
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the policy number <tc16777>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 30 days and starts endorsement <tc16777>
    And User clicks Dwelling Chevron for <tc16777>
    And User increases CovA Dwelling and add other coverages <tc16777>
    And User clicks Finalize button, validates changes are visible on closeout screen <tc16777>
    And User takes note of the application for <tc16777>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter 
    And User searches for the application <tc16777>
    And User validates expected following messages on issue tile <tc16777>
    And User clicks submit for approval button with underwriter
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc16777>
    And User validates 'Coverage A change cannot exceed $100,000 Must be Approved' message
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <tc16777>
    And User process and completes endorsement and finishes test <tc16777>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
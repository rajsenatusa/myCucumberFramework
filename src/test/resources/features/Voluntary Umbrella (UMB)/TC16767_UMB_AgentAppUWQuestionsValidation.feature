##created on 12/04/2023 by Can Yavas

# TEST CASE NUMBER & TITLE: TC 16767--UMB Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'
# PRECONDITIONS (IF ANY) - Current Active HO3 Policy
# HIGH LEVEL STEPS OF TEST SCRIPT:  UMB Application,Selecting ineligible answers for all Underwriting Questions
  
# EXPECTED RESULTS: EXPECTED RESULTS: Selecting ineligible answers to Underwriting Questions will produce the following-
#	1. Child Questions / sub-questions are generated 
#	2. Underwriting Approval referral is triggered
#	3. Agent cannot bind NB without Underwriting Approval
	
# User: AG1730


@regression @tc16767 @umbregression @AIIumb
Feature: TC 16767--UMB Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'

  Scenario: Validate Selecting Yes to ineligible questions to Underwriting Questions will require Underwriting Approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO4 product selection information and current date as effective date
    And User enters all required information on HO4 quote screen
    And User enters all required information on HO4 dwelling screen
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy and makes payment
    And User validates that HO4 policy has been created successfully and takes note of the policy number <tc16767>
    And User searches for the policy number <tc16767>
    And User clicks New Quote button and selects current date as effective date
    And User enters UMB product selection information
    And User answers previous policy written with AIIG questions <tc16767>
    And User enters all required information on UMB personal liability screen <tc16767>
    And User creates UMB application <tc16767>
    And User adds underlying policy in personal liability chevron <tc16767>
    And User adds underlying auto policy in personal liability chevron <tc16767>
    And User adds exposure in personal liability chevron <tc16767>
    And User adds driver and do UI validations 
    And User clicks add non-driver list
    And User enters all required information on UMB review screen
    And User answers all underwriting questions as NO for UMB <tc16767>
    And User answers UW Question 1 as Yes and validates error messages
    And User answers UW Question 2 as Yes and validates error messages
    And User answers UW Question 3 as Yes and validates error messages
    And User answers UW Question 4 as Yes and validates error messages
    And User answers UW Question 5 as Yes and validates error messages
    And User answers UW Question 6 as Yes and validates error messages
    And User answers UW Question 7 as Yes and validates error messages
    And User answers UW Question 8 as Yes and validates error messages
    And User answers UW Question 9 as Yes and validates error messages
    And User answers UW Question 10 as Yes and validates error messages
    And User answers UW Question 11 as Yes and validates error messages
    And User answers UW Question 12 as Yes and validates error messages
    And User answers UW Question 13 as Yes and validates error messages
    And User answers UW Question 14 as Yes and validates error messages
    And User answers UW Question 15 as Yes and validates error messages
    And User answers UW Question 16 as Yes and validates error messages
    And User answers UW Question 17 as Yes and validates error messages
    And User answers UW Question 18 as Yes and validates error messages
    And User answers all UW Questions as Yes and validates error messages
    And User finalizes transaction 
    And User validates UW error messages on issues tile
    And User sets payment type and takes note of the application for <tc16767>
    And User clicks submit for approval button <tc16767>
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16767>
    And User validates expected error messages on policy tile and submitter issues tile
    And User clicks submit for approval as underwriter <tc16767>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the application <tc16767>
    And User validates expected error messages on policy tile and submitter issues tile with UW manager role
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc16767>
    And User validates issue messages under submitter issues tile
    Then User issues policy and close unnecessary tabs and completes test <tc16767>
    
    
    
    
    
    
    
    
    
    
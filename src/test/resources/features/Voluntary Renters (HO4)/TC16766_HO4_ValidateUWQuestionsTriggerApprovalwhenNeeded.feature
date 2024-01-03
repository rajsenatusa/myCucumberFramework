# Author: Can Yavas
# created on 12/22/2023

# TEST CASE KNUMBER & TITLE: TC 16766--HO4 Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'
# PRECONDITIONS (IF ANY)
# HIGH LEVEL STEPS OF TEST SCRIPT:  HO4 Application,Selecting ineligible answers for all Underwriting Questions
 
# EXPECTED RESULTS: Selecting ineligible answers to Underwriting Questions will produce the following-
#	1. Child Questions / sub-questions are generated 
#	2. Underwriting Approval referral is triggered
#	3. Agent cannot bind NB without Underwriting Approval
  
# User: AG1730

@regression @tc16766 @ho4regression
Feature:  TC 16766--HO4 Agent Basic Policy App Validations 'Validate UW Questions trigger approval when needed'

  Scenario: TC16766_HO4_ValidateUWQuestionsTriggerApprovalwhenNeeded
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16766>
    And User enters HO4 product selection information and effective date as current date
    And User enters all required information on HO4 quote screen <tc16766>
    And User enters all required information on HO4 dwelling screen <tc16766>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions as NO except Question 9
    And User answers HO4 UW Question 1 as Yes and validates expected issue messages
    And User answers HO4 UW Question 2 as Yes and validates expected issue messages
    And User answers HO4 UW Question 3 as Yes and validates expected issue messages
    And User answers HO4 UW Question 4 as Yes and validates expected issue messages
    And User answers HO4 UW Question 5 as Yes and validates 'Underwriting referral required due to prior carrier cancellation' NOT visible
    And User answers HO4 UW Question 6 as Yes and validates expected issue messages
    And User answers HO4 UW Question 7 as Yes and validates expected issue messages
    And User answers HO4 UW Question 8 as Yes and validates expected issue messages
    And User answers HO4 UW Question 9 as Yes and validates expected issue messages
    And User answers HO4 UW Question 10 as Yes and validates expected issue messages
    And User answers HO4 UW Question 11 as Yes and validates expected issue messages
    And User answers HO4 UW Question 12 as Yes and validates expected issue messages
    And User answers HO4 UW Question 13 as Yes and validates expected issue messages
    And User answers HO4 UW Question 14 as Yes and validates expected issue messages
    And User answers all HO4 Questions as Yes except Question 9 and validates expected issue messages
    And User finalizes transaction and validates expected issue messages on closeout screen
    And User takes note of the application number <tc16766>
    And User clicks Submit for Approval button <tc16766>
    And User signs out
    And User login to Spin as Underwriter
    And User searches application <tc16766>
    And User validates expected messages on submitter issues tile <tc16766>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches application <tc16766>
    Then User sets payment type and validates expected messages
    And User process tx and validates expected messages and finishes test <tc16766>
    
    
    
    
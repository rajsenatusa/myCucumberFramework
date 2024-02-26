##created on 10/30/2023 by Can Yavas

# TEST CASE NUMBER & TITLE: TC 34595--TODP3, Standard Agent, 'Allow Number of Stories Endorsement Edit'
  
# PRECONDITIONS (IF ANY): Create TODP3 NB policy with producer as AG1730A1
# HIGH LEVEL STEPS OF TEST SCRIPT:  For agent, Number of stories will not be editable on endorsement when 
# 'Allow Number of Stories Endorsement Edit' attribute overrides to No
  
# EXPECTED RESULTS: 
# 1.  As an agent, if the number of stories field is pre-populated,  I should be able to change the number of 
# stories on the dwelling tab to a numeric value between 1 and "4 or more"
# 2.  If the # of Stories field is blank, I should be able to enter a value between 1 and 4 
 
# User: AG1730

@regression @tc34595 @mtr4584 @todp3regression @AIItodp3
Feature: MTR4584-TODP3, Standard Agent, 'Allow Number of Stories Endorsement Edit'

  Scenario: Validate Agent Allow Number of Stories Endorsement Edit
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc34595>
    And User enters product selection information for TODP3 and current date as effective date <tc34595>
    And User enters all required information on TODP3 quote screen <tc34595>
    And User enters all required information on TODP3 dwelling screen <tc34595>
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material <tc34595>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TODP3 policy has been created successfully and take note of policy number <tc34595>
    And User signs out
    And User login to Spin as Admin Agent
		And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG1730
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Override Link on Policy Agent Standard
    And User switches as no for the attribute of 'Allow Number of Stories Endorsement Edit'
    And User clicks save
		And User signs out
    And User login to Spin as Standard Agent
		And User searches for the policy number <tc34595>
		And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 10 days and starts endorsement <tc34595>
		And User cancels transactions and delete application
		And User signs out
    And User login to Spin as Admin Agent
		And User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG1730
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Override Link on Policy Agent Standard
    And User switches as yes for the attribute of 'Allow Number of Stories Endorsement Edit'
    And User clicks save
		And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the policy number <tc34595>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 10 days and starts endorsement <tc34595>
    And User clicks Dwelling Chevron <tc34595>
		And User validates Number of Stories dropdown is enabled
		And User gets all possible dd values for number of stories field and selects '4 or more' from selections and takes screenshot
		And User clicks Finalize button <tc34595>
		And User process and completes endorsement <tc34595>
    And User clicks Dwelling Chevron <tc34595>
    And User validates 'Number of Stories' field is disabled and completes test
    
    
    
    
    
##created on 09/14/2023 by Can Yavas

 ## TEST CASE NUMBER & TITLE: TC 34437--HO3, Agent, 'Allow Number of Stories Endorsement Edit'
 
 ## PRECONDITIONS (IF ANY): Create HO3 NB policy with producer as AG1730A1
 ## HIGH LEVEL STEPS OF TEST SCRIPT:  For agent, Number of stories will not be editable on endorsement when 
 ## 'Allow Number of Stories Endorsement Edit' attribute overrides to No
  
 ## EXPECTED RESULTS: 
 ## 1.  As an agent, if the number of stories field is pre-populated,  I should be able to change the number of 
 ## stories on the dwelling tab to a numeric value between 1 and "4 or more"
 ## 2.  If the # of Stories field is blank, I should be able to enter a value between 1 and 4 
  
 ## User: AG1730

@regression @mtr354 @ho3regression
Feature: TC 34437--HO3, Agent, 'Allow Number of Stories Endorsement Edit'

  Scenario: Validate Agent Allow Number of Stories Endorsement Edit
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr354>
		And User enters HO3 product selection information and current date as effective date
		And User enters all required information on HO3 quote screen <mtr354>
		And User enters all required information on HO3 dwelling screen <mtr354>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
		And User completes required information on dwelling chevron <mtr354>
		And User clicks Finalize button <mtr354>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr354>
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
		And User searches for the policy number <mtr354>
		And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 10 days and starts endorsement <mtr354>
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
		And User searches for the policy number <mtr354>
		And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 10 days and starts endorsement <mtr354>
		And User clicks Dwelling Chevron <mtr354>
		And User validates Number of Stories dropdown is enabled
		And User gets all possible dd values for number of stories field and selects '4 or more' from selections and takes screenshot
		And User clicks Finalize button <mtr354>
		And User process and completes endorsement <mtr354>
		And User clicks Dwelling Chevron <mtr354>
		And User validates 'Number of Stories' field is disabled and completes test
		
		
		
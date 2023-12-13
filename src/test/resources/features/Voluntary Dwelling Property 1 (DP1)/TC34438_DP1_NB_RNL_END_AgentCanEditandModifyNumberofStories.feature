##created on 11/09/2023 by Can Yavas

# TEST CASE NUMBER & TITLE: TC 34438--DP1 NB RNL END Validate Standard Agent can edit and modify Number of Stories field
 
# PRECONDITIONS (IF ANY): Validate 'Allow Number of Stories Endorsement Edit' attribute defaulted to Yes
# HIGH LEVEL STEPS OF TEST SCRIPT:  Validate that standard agent allowed to edit and modify the Number of stories 
# field on New business and on endorsement.
  
# EXPECTED RESULTS: 
# 1.  As an agent, if the number of stories field is pre-populated,  I should be able to change the number of 
# stories on the dwelling tab to a numeric value between 1 and "4 or more"
# 2.  If the # of Stories field is blank, I should be able to enter a value between 1 and 4 
  
# User: AG1730
 
@tc34438 @regression @dp1regression
Feature: TC 34438--DP1 NB RNL END Validate Standard Agent can edit and modify Number of Stories field

  Scenario: Validate that standard agent allowed to edit and modify the Number of stories field on New business and on endorsement
    
    Given User login to Spin as Admin Agent
    When User clicks Admin Tab 
    And User clicks User Management Tab
    And User searches Agent AG1730
    And User clicks Search button
    And User scrolls to User Roles List 
    And User clicks Override Link on Policy Agent Standard
    And User confirms for the attribute of 'Allow Number of Stories Endorsement Edit' selected as Yes
    And User clicks save
		And User signs out
		And User login to Spin as Standard Agent
		And User starts transaction as a new customer
   	And User enters all required information on policy information screen <tc34438>
    And User enters DP1 product selection information and current date as effective date
		And User enters all required information on DP1 quote screen <tc34438>
		And User enters all required information on DP1 dwelling screen and validates Number of Stories field is enabled and gets all values <tc34438>
		And User enters all required information on DP1 review screen
		And User creates DP1 application
		And User answers all underwriting questions for DP1
		And User sets number of stories as 3 confirm value through RCE , validates number of stories defaulted as 3 and finalizes transaction <tc34438>
		And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <tc34438>
		And User signs out
		And User login to Spin as Admin Agent
		And User searches for the policy <tc34438>
		And User clicks Make Payment and selects credit card and enters due amount <tc34438>
    And User makes payment with Credit Card <tc34438>
		And User does Auto Renewal for the policy with batch jobs <tc34438>
		And User clicks Task Tab
		And User takes note of the pre auto renew date and auto renew date
		And User completes Auto Renewal through batch jobs <tc34438>
		And User searches for renewed policy <tc34438>
		And User takes note of the renewal effective date <tc34438>
		And User clicks Dwelling Chevron <tc34438>
		And User validates Number of Stories Field is disabled
		And User signs out
		And User login to Spin as Standard Agent
		And User changes system date to renewal effective date <tc34438>
		And User searches for renewed policy <tc34438>
		And User clicks Start Transaction <tc34438>
    And User clicks EN Transaction Selection <tc34438>
    And User sets new effective date as renewal effective date and starts endorsement <tc34438>
		And User clicks Dwelling Chevron <tc34438>
		And User validates Building Number of Stories field is enabled and gets all populated values and select 4 or more
		And User clicks Finalize button <tc34438>
		And User process and completes endorsement <tc34438>
		And User clicks Dwelling Chevron <tc34438>
		Then User validates Building Number of Stories field is disabled and completes test
		
		
		
		
		
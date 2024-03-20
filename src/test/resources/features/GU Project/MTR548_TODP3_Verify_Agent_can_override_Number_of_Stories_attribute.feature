##created on 03/20/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR548--TODP3 Verify Agent can override Number of Stories attribute
## PRECONDITIONS (IF ANY): 1. Issue TODP3 policy with producer code as AG1730A1 
## (sales Agent)Validate 'Allow Number of Stories Endorsement Edit' attribute defaulted to Yes
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Login as Admin,
## 2. Navigate to User Roles List and change allow number of stories edit as NO
## 3. Login with Standard Sales Agent and retrieve policy from preconditions
## 4. Do endorsement, click dwelling chevron and validate number of stories field is not editable 
## 5. Log in as Admin Navigate to User Roles List and change allow number of stories edit as Yes
## 6. Log in as Standard Sales Agent, and retrieve policy from preconditions
## 7. Do endorsement, click dwelling chevron and validate number of stories field is editable 
## 8. Finalize transaction and complete endorsement 
  
## EXPECTED RESULTS: Validate As a Sales Agent, I would like the ability to update/endorse a policy
  
## User: Admin, Standard Sales Agent (AG1730A1)


@regression @mtr548 @todp3regression @gu
Feature: MTR548--TODP3 Verify Agent can override Number of Stories attribute

  Scenario: Validate As a Sales Agent, I would like the ability to update/endorse a policy
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr548>
    And User enters product selection information for TODP3 and current date as effective date <mtr548>
    And User enters all required information on TODP3 quote screen <mtr548>
    And User enters all required information on TODP3 dwelling screen <mtr548>
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material <mtr548>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TODP3 policy has been created successfully and take note of policy number <mtr548>
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
		And User searches for the policy number <mtr548>
		And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 30 days and starts endorsement <mtr548>
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
    And User searches for the policy number <mtr548>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 30 days and starts endorsement <mtr548>
    And User clicks Dwelling Chevron <mtr548>
		And User validates Number of Stories dropdown is enabled
		And User gets all possible dd values for number of stories field and selects '4 or more' from selections and takes screenshot
		And User clicks Finalize button <mtr548>
		And User process and completes endorsement <mtr548>
    And User clicks Dwelling Chevron <mtr548>
    And User validates 'Number of Stories' field is disabled and completes test
    
    
    
    
    
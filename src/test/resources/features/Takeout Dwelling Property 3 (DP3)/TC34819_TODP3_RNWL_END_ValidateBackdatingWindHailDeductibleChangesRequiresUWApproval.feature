#Author: Can Yavas
##created on 09/01/2023

 ## TEST CASE NUMBER & TITLE: TC 34819--TODP3: RULES - Backdating Wind/Hail Deductible Changes Prior to, On, and After RN Effective Date
 ## PRECONDITIONS (IF ANY):Active TODP3  Policy 
 ## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
 ## After RN Effective Date & UW Approva
 ## EXPECTED RESULTS: Ensure that the agent can still refer a deductible change for approva
  
 ## User: AG1730

@regression @tc34819
Feature: TC 34819--TODP3: RULES - Backdating Wind/Hail Deductible Changes Prior to, On, and After RN Effective Date

  Scenario: Validate that the agent can still refer a deductible change for approval 
    Given User login to Spin as Admin Agent
    And User changes system date to effective date 'current date minus 1 year' <tc34819>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc34819>
    And User enters product selection information for TODP3 and current date minus 1 year as effective date
    And User enters all required information on TODP3 quote screen <tc34819>
    And User enters all required information on TODP3 dwelling screen <tc34819>
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User clicks dwelling chevron and selects roof material <tc34819>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TODP3 policy has been created successfully and take note of policy number <tc34819>
    And User clicks Make Payment and selects credit card and enters due amount for <tc34819>
    And User makes payment with Credit Card for <tc34819>
    And User does auto renewal through batch jobs <tc34819>
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to renewal date minus 1 day <tc34819>
    And User searches for the renewed policy number <tc34819>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <tc34819>
    And User clicks dwelling chevron <tc34819>
    And User unchecks wind hail exclusion
    And User finalizes transaction and validates expected text messages on closeout screen
    And User endorses policy and close tabs
    And User changes system date to renewal date <tc34819>
    And User searches for the renewed policy number <tc34819>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <tc34819>
    And User clicks dwelling chevron <tc34819>
    And User checks wind hail exclusion
    And User finalizes second transaction and validates expected text messages on closeout screen
    And User endorses policy and close tabs
    And User changes system date to renewal date plus 1 day <tc34819>
    And User searches for the renewed policy number <tc34819>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <tc34819>
    And User validates 'The effective date must not be older than 0 days from today' message has been displayed
    And User clicks dwelling chevron <tc34819>
    And User unchecks wind hail exclusion
    And User finalizes third transaction and validates expected text messages on closeout screen
    And User takes note of the application number for <tc34819>
    And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to renewal date plus 1 day <tc34819>
    And User searches for the application <tc34819>    
		And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to renewal date plus 1 day <tc34819>
    And User searches for the application <tc34819>
    And User process transaction and completes test <tc34819>
    
    
    
    
    
    
    
    
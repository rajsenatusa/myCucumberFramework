#Author: Can Yavas
##created on 08/28/2023

 ## TEST CASE NUMBER & TITLE: MTR374--TO MHPD AF: RULES - Modify Windstorm or Hail Exclusion Rules and Edits
 ## PRECONDITIONS (IF ANY): Change date to 30 days prior to Creating TOMHPD policy with an effective on or after 
 ## 7/24/2021 (remove hard coded date after go live) With With WInd Hail Exclusion Checked 
 ## Agent and Underwriter must have Change Date Roles

 ## HIGH LEVEL STEPS OF TEST SCRIPT: As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
 ## After RN Effective Date & UW Approval 
  
 ## EXPECTED RESULTS:  
  
 ## User: Admin, Agent


@regression @mtr374
Feature: MTR374--TO MHPD AF: RULES - Modify Windstorm or Hail Exclusion Rules and Edits

  Scenario: Validate As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, After RN Effective Date & UW Approval
    Given User login to Spin as Admin Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr374>
    And User enters product selection information for TOMHPD and current date as effective date
    And User enters all required information on TOMHPD quote screen <mtr374>
    And User enters all required information on TOMHPD dwelling screen <mtr374>
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks Dwelling Chevron and completes required information
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHPD policy has been created successfully and takes note of the policy number
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to current date minus 1 day
    And User searches for the policy number <mtr374>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr374>
    And User clicks Dwelling Chevron for <mtr374>
    And User validates Wind Hail exclusion is disabled
    And User cancels transaction
    And User changes system date to current date <mtr374>
    And User searches for the policy number <mtr374>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr374>
    And User clicks Dwelling Chevron for <mtr374>
    And User validates Wind Hail exclusion is disabled
    And User cancels transaction
    And User changes system date to current date plus 1 day <mtr374>
    And User searches for the policy number <mtr374>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr374>
    And User validates 'The effective date must not be older than 0 days from today' text has been displayed
    And User clicks Dwelling Chevron for <mtr374>
    And User validates Wind Hail exclusion is disabled
    And User takes note of the application for <mtr374>
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date plus 1 day <mtr374>
    And User searches for the application <mtr374>
    And User clicks more button and take ownership of the application
    And User clicks Dwelling Chevron for <mtr374>
    And User validates Wind Hail exclusion is enabled
    And User unchecks Wind Hail Exclusion radio button
    And User validates Building Hurricane deductible defaulted to <%2>
    And User finalizes transaction and validates 'Deductible Change: Hurricane Changed From Not Applicable to 2%' text has been displayed and process and completes test
    
    
    
    
    
    
    
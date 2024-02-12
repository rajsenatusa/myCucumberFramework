#Author: Can Yavas
##created on 08/29/2023

## TEST CASE NUMBER & TITLE: TC 34821--TO DP1: RULES - Backdating Deductible Changes Prior to, On, and After RN Effective Date
## PRECONDITIONS (IF ANY): Create TO DP1 policy effective on or after 08/20/2020
## With AOP Deductibles at 2,500, HURR is 10%, Fire @2,500,
## Agent (AG3986) and Underwriter must have Change Date Roles
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent endorse the policy prior to RN effective Date, On RN Effective Date, 
## After RN Effective Date & UW Approval 
  
## EXPECTED RESULTS: Validate a change to coverage(s) with an Effective Date in the past fires the error
## Validate a change to coverage(s) with an Effective Date = todays date is allowed to Process
## Validate the UW can override and allow the Endorsement when submitted for approval   
  
## User: AG1730

@regression @mtr375 @todp1regression 
Feature: TC 34821--TO DP1: RULES - Backdating Deductible Changes Prior to, On, and After RN Effective Date

  Scenario: Validate a change to coverage(s) with an Effective Date in the past fires the error
 					, Validate a change to coverage(s) with an Effective Date = todays date is allowed to Process
 					, Validate the UW can override and allow the Endorsement when submitted for approval
 					
    Given User login to Spin as Admin Agent
		And User changes system date to current date minus 1 year
		When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr375>
		And User enters product selection information for TODP1 and effective date as current date minus 1 year
		And User enters all required information on TODP1 quote screen <mtr375>
		And User enters all required information on TODP1 dwelling screen <mtr375> and sets all perils ded <$2500>, hurricane ded <%10>, fire ded <$2500>
		And User enters all required information on TODP1 review screen
		And User creates TODP1 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks Dwelling Chevron for <mtr375>
    And User sets roof material as <3 Tab Composition Shingle>
    And User clicks review Chevron and selects 8 Pay payment plan
		And User finalizes transaction and issues takeout policy
    And User validates that TODP1 policy has been created successfully and takes note of the policy number <mtr375>
		And User clicks Make Payment and selects credit card and enters due amount for <mtr375>
    And User makes payment with Credit Card for <mtr375>
    And User does auto renewal through batch jobs
		And User signs out
    And User login to Spin as Standard Agent
		And User changes system date to renewal date minus 1 day
		And User searches for the renewal term policy number <mtr375>
		And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <mtr375>
		And User clicks Dwelling Chevron for <mtr375>
		And User decrease deductibles
		And User finalizes transaction and verify changes are visible on closeout screen and endorses policy and close tabs
		And User changes system date to renewal date <mtr375>
		And User searches for the renewal term policy number <mtr375>
		And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <mtr375>
		And User clicks Dwelling Chevron for <mtr375>
		And User increase deductibles
		And User finalizes transaction and verify second changes are visible on closeout screen and endorses policy and close tabs
		And User changes system date to renewal date plus 1 day
		And User searches for the renewal term policy number <mtr375>
		And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <mtr375>
    And User validates 'The effective date must not be older than 0 days from today' text message has been displayed
		And User clicks Dwelling Chevron for <mtr375>
		And User decrease deductibles
		And User finalizes transaction and verify changes are visible on closeout screen and clicks submit for approval and takes note of app number
		And User clicks submit for approval button 
		And User signs out    
		And User login to Spin as Underwriter    
		And User changes system date to renewal date plus 1 day    
		And User searches for the application <mtr375>    
		And User approves application    
		And User signs out    
		Then User login to Spin as Standard Agent    
		And User changes system date to renewal date plus 1 day    
		And User searches for the application <mtr375>    
		And User process transaction and completes test    
		    
		
		
		
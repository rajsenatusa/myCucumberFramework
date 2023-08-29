#Author: Can Yavas
##created on 08/29/2023

## TEST CASE NUMBER & TITLE: TC 33703--TO MHPD - UI / RULES: Add Rolled/Bitumen roof material
## PRECONDITIONS (IF ANY): Create TOMHPD policy with an effective date today's date - 1 year 
## Use the following lookup address: 15330 Searobbin Drive, Lakewood Ranch, FL 34202
## Make Payment so it doesn't cancel when Renewing
## HIGH LEVEL STEPS OF TEST SCRIPT: As limited Agent, Endorse policy identified in Preconditions to add Rolled/Bitumen Roof 
  
## EXPECTED RESULTS: Verify Rolled/Bitumen is added to the Roof Material selection and displays in order indicated 
  
## User: Admin, Agent
 
@regression @mtr1414
Feature: TC 33703--TO MHPD - UI / RULES: Add Rolled/Bitumen roof material

  Scenario: Validate Rolled/Bitumen is added to the Roof Material selection and displays in order indicated 
  
    Given User login to Spin as Admin Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr1414>
    And User enters product selection information for TOMHPD and current date as effective date
    And User enters all required information on TOMHPD quote screen <mtr1414>
    And User enters all required information on TOMHPD dwelling screen <mtr1414>
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks Dwelling Chevron and completes required information <mtr1414>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHPD policy has been created successfully and takes note of the policy number <mtr1414>
    And User searches for the policy number <mtr1414>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr1414>
    And User clicks Dwelling Chevron for <mtr1414>
    And User validates roof material dropdown options
    And User cancels transaction
    And User searches for the policy number <mtr1414>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr1414>
    And User makes payment with Credit Card for <mtr1414>
    And User does auto renewal through batch jobs and takes note of the renewed effective date
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to renewal effective date
    And User searches for the renewal term policy number <mtr1414>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <mtr1414>
    And User clicks Dwelling Chevron for <mtr1414>
    And User validates roof material dropdown options
    And User sets roof update as <2022>
    And User finalizes transaction and endorses policy and close tabs
    And User signs out
    And User login to Spin as Admin Agent
    And User changes system date to renewal effective date
    And User searches for the renewal term policy number <mtr1414>
    And User clicks Make Payment second time and selects credit card and enters due amount for <mtr1414>
    And User makes payment with Credit Card for <mtr1414>
    And User does second auto renewal through batch jobs and completes test
    
    
    
    
    
    
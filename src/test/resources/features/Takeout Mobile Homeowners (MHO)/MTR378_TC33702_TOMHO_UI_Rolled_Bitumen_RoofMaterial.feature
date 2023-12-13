#Author: Can Yavas
##created on 09/01/2023

 ## TEST CASE NUMBER & TITLE: MTR378--TO MHO AF - UI / RULES:Add Rolled/Bitumen roof material
 ## PRECONDITIONS (IF ANY): Create TOMHPD policy with an effective date today's date - 1 year 
 ## Use the following lookup address: 8690 Lake George Cir, Macclenny FL, 32063
 ## Make Payment so it doesn't cancel when Renewing
 ## HIGH LEVEL STEPS OF TEST SCRIPT: As limited Agent, Endorse policy identified in Preconditions to add Rolled/Bitumen Roof 
 ## EXPECTED RESULTS: Verify Rolled/Bitumen is added to the Roof Material selection and displays in order indicated 
  
 ## User: Admin, Agent

@regression @mtr378 @tomhoregression
Feature: MTR378--TO MHO AF - UI / RULES:Add Rolled/Bitumen roof material

  Scenario: Validate Rolled/Bitumen is added to the Roof Material selection and displays in order indicated 
    Given User login to Spin as Admin Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr378>
    And User enters product selection information for TOMHO and current date as effective date
    And User enters all required information on TOMHO quote screen <mtr378>
    And User enters all required information on TOMHO dwelling screen <mtr378>
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron <mtr378>
    And User completes required information on dwelling screen <mtr378>
    And User clicks review Chevron and selects 8 Pay payment plan
    And User finalizes transaction and issues takeout policy
    And User validates that TOMHO policy has been created successfully and takes note of the policy number
    And User searches for the policy number <mtr378>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr378>
    And User clicks dwelling chevron <mtr378>
    And User validates roof material dropdown options <mtr378>
    And User cancels transaction
    And User searches for the policy number <mtr378>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr378>
    And User makes payment with Credit Card for <mtr378>
    And User does auto renewal through batch jobs <mtr378>
    And User searches for the renewed policy number <mtr378>
    And User gets transaction effective date
    And User signs out
    And User login to Spin as Standard Agent
    And User changes system date to renewal effective date <mtr378>
    And User searches for the renewed policy number <mtr378>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as renewal effective date and starts endorsement <mtr378>
    And User clicks dwelling chevron <mtr378>
    And User validates roof material dropdown options <mtr378>
    And User sets roof update as <2022>
    And User finalizes transaction and endorses policy and close tabs
    And User signs out
    And User login to Spin as Admin Agent
    And User changes system date to renewal effective date <mtr378>
    And User searches for the renewed policy number <mtr378>
    And User clicks Make Payment second time and selects credit card and enters due amount for <mtr378>
    And User makes payment with Credit Card for the second time <mtr378>
    Then User does second auto renewal through batch jobs and completes test <mtr378>
    
    
    
    
# Author: Can Yavas
# created on 11/16/2023

# TEST CASE NUMBER & TITLE: TC 15288--Vol DP3 - Creating DP3 Application Trust w/eSignature
# PRECONDITIONS (IF ANY): None 
  
# HIGH LEVEL STEPS OF TEST SCRIPT:  As a valid user role, create a DP3 NB (Trust) with selecting Esignature on CloseOut Screen 
  
# EXPECTED RESULTS: DP3 policy is created using eSignature feature.
 
# User: AG1529

@regression @tc15288
Feature: TC 15288--Vol DP3 - Creating DP3 Application Trust w/eSignature

  Scenario: Validate DP3 policy is created using eSignature feature
    Given User login to Spin as Diamond Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc15288>
    And User enters DP3 product selection information and effective date as current date <tc15288>
    And User enters all required information on DP3 quote screen <tc15288>
    And User enters all required information on DP3 dwelling screen <tc15288>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User updates plumbing,electrical,hvac years as current year and validates roof material <tc15288>
    And User finalizes transaction for <tc15288>
    And User sets payment type and sets E-signature and do validations <tc15288>
    And User enters Agent Details for E-signature
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <tc15288>
    Then User clicks eSignature Chevron 
  	And User validates Cancel label and Refresh and Sent button is visible
    
    
    
    
    
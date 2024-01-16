# Author: Can Yavas
# created on 11/21/2023

 # TEST CASE NUMBER & TITLE: TC 35559--Validate User Story 6625:Loss Assessment
 # HIGH LEVEL STEPS OF TEST SCRIPT:
 # Validate Coverage "Loss Assessment is added with coverage"
  
 # Expected results- Loss Assessment should listed in the forms

@regression @tc35559 @mtr4583 @dp3regression
Feature: MTR4583-Validate User Story 6625:Loss Assessment

  Scenario: Validate Loss Assessment should listed in the forms
    Given User login to Spin as Standard Agent
    And User starts transaction as a new customer
    And User enters all required information on policy information screen <tc35559>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <tc35559>
    And User enters all required information on DP3 dwelling screen <tc35559> adds coverages and validates loss assessment selections
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User checks dwelling screen and updates HVAC, roof, plumbing, electrical year to current year and selects loss assessment as <10.000>
    And User prints quote for loss assessment validation
    And User finalizes transaction for <tc35559>
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <tc35559>
    And User clicks Policy File Chevron <tc35559>
    And User validates loss assessment form version in Application
    And User clicks Policy File Chevron <tc35559>
    Then User validates loss assessment form version in Declaration and completes test
    
    
    
    
    
    
    
    
## created on 10/12/2023 by Can Yavas
 
## TEST CASE NUMBER & TITLE: TC36657 : User Story 8585:RULE: Roof Material - Roof Letter Rules - NB Metal Roof Policy File
## Precondition-
## 
## EXPECTED RESULTS:Confirm that when a NB policy is issued, with a roof type of Metal, that the NB Packet includes
##  the AIIC RWT letter
  
## User: AG1730

@regression @tc36657 @MTR4504 @ho3regression @ho3APRIL
Feature: MTR4504 User Story 8585:RULE: Roof Material - Roof Letter Rules - NB Metal Roof Policy File

  Scenario: Validate that when a NB policy is issued, with a roof type of Metal, that the NB Packet includes the AIIC RWT letter
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc36657>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <tc36657>
    And User enters all required information on HO3 dwelling screen <tc36657>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <tc36657>
    And User clicks Finalize button <tc36657>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <tc36657>
    And User clicks Policy File Chevron <tc36657>
    And User clicks New Business Package Link and validates roof form versions and completes test
    
    
    
    
    
    
    
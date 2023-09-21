##created on 09/21/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 36013--Validate User Story 6249:Forms Matrix
## PRECONDITIONS (IF ANY)
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## Add coverages - Animal Liability, Home Computer Coverage, Personal Injury, Refrigerated Property, 
## Water Back Up and Sump Discharge or Overflow, Loss Assessment
## Add Additional Interest and Additional Insured both
  
## EXPECTED RESULTS: Verify the forms are as per the sequence of the Forms Matrix 
   
## User: Jbarnes

@regression @mtr138
Feature: TC 36013--Validate User Story 6249:Forms Matrix

  Scenario: Validate the forms are as per the sequence of the Forms Matrix
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr138>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr138>
    And User enters all required information on DP3 dwelling screen <mtr138> and selects integrity select and adds coverages
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User clicks Additional Interest Chevron
    And User clicks Add Additional Interest button
    And User completes required information on add additional interests screen and add additional insured <mtr138>
    And User adds another Additional Interest
    And User finalizes transaction for <mtr138>
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <mtr138>
    And User clicks Forms Chevron <mtr138>
    And User validates all expected forms is visible on forms screen
    And User clicks Policy File Chevron <mtr138>
    And User clicks New Business Package Link and validates all expected forms listed in the package
    And User validates greeting letter form version as expected
    And User validates privacy statement form version
    And User validates roof limitation form version
    And User validates deductible notification form version
    And User validates assignment form version
    And User validates policy jacket form version
    And User validates AIIC DP3 IDX 07 15 form version
    And User validates DP 00 03 07 88 form version
    And User validates AIIC DP DPL 07 15 form version
    And User validates AIIC 01 DP3 SP 04 23 form version
    And User validates AIIC DP HD 07 15 form version
    And User validates actual cash value loss settlement form version
    And User validates additional insured form version
    And User validates AIIC INST 11 14 form version
    And User validates Limited Carport, Pool Cage and Screen Enclosure Coverage form version
    And User validates Animal Liability Coverage form version
    And User validates Home Computer Coverage form version
    And User validates AIIC DP LFC 07 15 form version
    And User validates loss assessment form version
    And User validates ordinance or law coverage form version
    And User validates owner occupied endorsement form version
    And User validates personal injury coverage form version
    And User validates refrigerated property coverage form version
    And User validates water backup and sump discharge form version
    And User validates outline of your dwelling policy form version
    And User validates checklist form version
    And User validates Notice Hurricane mitigation form version
    Then User validates Consumer reports form version and completes test
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
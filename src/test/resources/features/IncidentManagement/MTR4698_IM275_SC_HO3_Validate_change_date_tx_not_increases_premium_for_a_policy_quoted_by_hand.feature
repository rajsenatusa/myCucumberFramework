##created on 04/5/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR-4698--SC HO3, IM-275 : SC HO3 Validate change date tx not increases premium for a policy quoted by hand
## PRECONDITIONS (IF ANY): Create SC HO3 policy with the following:Effective date on current date
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create SC HO3 policy with the following:Effective date on current date
## 2. Log into SPIN as UW, Search for policy from pre-condition
## 2. change system date to current date plus 10 days
## 3. Click process button
## 4. Verify the premium not increased after change date transaction
   
## EXPECTED RESULTS: As an Underwriter, Verify the premium not increased after change date transaction
  
## User: underwriter, AG1777A1



@regression @mtr4698 @scho3regression @im
Feature: MTR-4698--SC HO3, IM-275 : SC HO3 Validate change date tx not increases premium for a policy quoted by hand

  Scenario: Validate As an Underwriter, Verify the premium not increased after change date transaction
    Given User login to Spin as South Carolina Agent
    And User changes system date to current date <mtr4698>
    When User starts transaction as a new customer
    And User enters all required information on SC policy information screen <mtr4698>
    And User enters SC HO3 product selection information and current date as effective date
    And User enters all required information on SC HO3 quote screen <mtr4698>
    And User enters all required information on SC HO3 dwelling screen <mtr4698>
    And User enters all required information on HO3 review screen
    And User creates SC HO3 application
    And User answers all underwriting questions for SC HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that SC HO3 policy has been created successfully and take note of the policy number <mtr4698>
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date <mtr4698>
    And User searches for Policy Number for <mtr4698>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 10 days as new effective date <mtr4698>
    And User process transaction <mtr4698>
    And User searches for Policy Number for <mtr4698>
    And User clicks History Chevron
    Then User validates the premium not increased after change date transaction and completes test
    
    
    
    
    
    
    
    
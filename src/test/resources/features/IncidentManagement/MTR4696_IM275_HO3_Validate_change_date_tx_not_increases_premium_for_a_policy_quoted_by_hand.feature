##created on 04/5/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR-4696--IM-275 : HO3 Validate change date tx not increases premium for a policy quoted by hand
## PRECONDITIONS (IF ANY): Create HO3 policy with the following: Effective date on current date
## Address: 3429 Ringtail Ct. , Green Cove Springs, Clay County, Fl, 32043
  
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create HO3 policy with the following:Effective date on current date Address: 3429 Ringtail Ct. , Green Cove Springs, Clay County, Fl, 32043
## 2. Log into SPIN as UW, Search for policy from pre-condition
## 2. change system date to current date plus 10 days
## 3. Click process button
## 4. Verify the premium not increased after change date transaction
   
## EXPECTED RESULTS: As an Underwriter, Verify the premium not increased after change date transaction
  
## User: underwriter, AG1730A1



@regression @mtr4696 @ho3regression @im
Feature: MTR-4696--IM-275 : HO3 Validate change date tx not increases premium for a policy quoted by hand

  Scenario: Validate As an Underwriter, Verify the premium not increased after change date transaction
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr4696>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr4696>
    And User enters HO3 product selection information and current date as effective date <mtr4696>
		And User enters all required information on HO3 quote screen <mtr4696>
		And User enters all required information on HO3 dwelling screen <mtr4696>
		And User enters all required information on HO3 review screen
		And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron and updates dwelling type <mtr4696>
    And User clicks Finalize button <mtr4696>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr4696>
    And User signs out
    And User login to Spin as Underwriter
    And User changes system date to current date <mtr4696>
    And User searches for Policy Number for <mtr4696>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 10 days as new effective date <mtr4696>
    And User process transaction <mtr4696>
    And User searches for Policy Number for <mtr4696>
    And User clicks History Chevron
    Then User validates the premium not increased after change date transaction and completes test <mtr4696>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
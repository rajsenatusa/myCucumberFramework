 ##created on 09/19/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 16763--HO3, Agent, END TX, Change Reserve Package, Increase CovA, Change Deductible, Change 1st Mortgagee, UW Approval
## PRECONDITIONS (IF ANY): Active HO3 Basic Reserve Policy with first mortgagee
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent, Endorse the policy to change Basic Reserve Package to Gold, Increase CovA, 
## 									change Deductibles 
## 									and change Mortgagee
##  EXPECTED RESULTS: Underwriting approval is required Appraval messages trigger on CloseOut screen Agent must Submit for Approval 
  
## User: AG1730

@regression @mtr359
Feature: TC 16763--HO3, Agent, END TX, Change Reserve Package, Increase CovA, Change Deductible, Change 1st Mortgagee, UW Approval

  Scenario: Validate Underwriting approval is required Approval messages trigger on CloseOut screen Agent must Submit for Approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr359>
		And User enters HO3 product selection information and current date as effective date
		And User enters all required information on HO3 quote screen <mtr359>
		And User enters all required information on HO3 dwelling screen <mtr359>
		And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr359>
    And User adds additional interests for first mortgagee <mtr359>
    And User clicks Finalize button <mtr359>
    And User issues policy
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr359>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as current date plus 5 days and starts endorsement <mtr359>
    And User clicks Dwelling Chevron <mtr359>
    And User selects Gold Reserve and increases CovA Dwelling
    And User adds another additional interests for first mortgagee <mtr359>
    And User clicks Finalize button <mtr359>
    And User validates expected messages have been generated
    And User takes note of the application for <mtr359>
    And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for application number <mtr359>
    And User validates expected messages on issue tile
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for application number <mtr359>
    And User process and completes endorsement and finishes test <mtr359>
    
    
    
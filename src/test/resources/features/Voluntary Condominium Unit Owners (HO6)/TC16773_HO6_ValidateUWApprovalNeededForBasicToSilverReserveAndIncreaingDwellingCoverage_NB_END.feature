##created on 09/22/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 16773--HO6, Agent, END TX, Change Reserve Package, Increase CovA, Change Deductible, Add 1st Mortgagee, UW Approval
## PRECONDITIONS (IF ANY): Active HO6 Basic Reserve Policy
## HIGH LEVEL STEPS OF TEST SCRIPT:  As an Agent, Endorse the policy to change Basic Reserve Package to Silver, Increase CovA, 
## 									change Deductibles 
## 									and Add Mortgagee
## EXPECTED RESULTS: Underwriting approval is required Approval messages trigger on Closeout screen Agent must Submit for Approval 
  
## User: AG1730

@regression @tc16773 @mtr4576
Feature: TC 16773-mtr4576-HO6, Agent, END TX, Change Reserve Package, Increase CovA, Change Deductible, Add 1st Mortgagee, UW Approval

  Scenario: Validate that Underwriting approval is required Approval messages trigger on Closeout screen Agent must Submit for Approval 
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc16773>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <tc16773>
    And User enters all required information on HO6 dwelling screen and enters <25.000> for CovC <tc16773>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6 <tc16773>
    And User checks application dwelling screen and finalizes transaction <tc16773>
    And User issues policy
    And User validates that HO6 policy has been created successfully and takes note of the policy number <tc16773>
    And User changes system date to current date plus 30 days <tc16773>
    And User searches for the policy number <tc16773>
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User sets new effective date as endorsement date and starts endorsement <tc16773>
    And User clicks Dwelling Chevron <tc16773>
    And User selects Silver Reserve Package, increase CovA Dwelling and add other coverages
    And User clicks Additional Interest Chevron
    And User clicks Add Additional Interest button
    And User completes required information on add additional interests screen and add additional insured <tc16773>   
		And User clicks Finalize button, validates changes are visible on closeout screen <tc16773>
    And User takes note of the application for <tc16773>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter 
    And User changes system date to endorsement date <tc16773>
    And User searches for the application <tc16773>
    And User validates expected following messages on issue tile
    And User clicks submit for approval button with underwriter
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to endorsement date <tc16773>
    And User searches for the application <tc16773>
    And User validates 'Coverage A - Dwelling + Coverage C - Personal Property Limits that are increased above $100,000 require Underwriting Approval' message
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User changes system date to endorsement date <tc16773>
    And User searches for the application <tc16773>
    And User process and completes endorsement and finishes test <tc16773>
    
    
    
    
    
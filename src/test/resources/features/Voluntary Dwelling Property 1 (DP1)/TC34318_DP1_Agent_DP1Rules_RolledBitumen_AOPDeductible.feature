##created on 11/08/2023 by Can Yavas

 # TEST CASE NUMBER & TITLE: TC 34318--DP1 RULES, UI Agent Rolled BItumen, AOP Deductible
 # PRECONDITIONS (IF ANY)
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Create NB Policy effective today's date +45 days 
 # Roof Material Rolled/Bitumen
 # New AOP deductibles and Form
  
 # EXPECTED RESULTS: 
 # User: AG1730
 
@tc34318 @regression @dp1regression 
Feature: TC 34318--DP1 RULES, UI Agent Rolled BItumen, AOP Deductible

  Scenario: Validating DP1 rule on UI with Rolled Bitumen Roof Type and AOP deductible
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
   	And User enters all required information on policy information screen <tc34318>
    And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen <tc34318>
    And User enters all required information on DP1 dwelling screen <tc34318>
    And User enters all required information on DP1 review screen
    And User creates DP1 application <tc34318>
    And User validates 'Risk is ineligible due to age of HVAC' and 'Risk is ineligible due to age of Electrical' messages are visible
    And User answers all underwriting questions for DP1 <tc34318>
    And User validates 'Risk is ineligible due to age of HVAC' and 'Risk is ineligible due to age of Electrical' messages are visible
    And User clicks Dwelling Chevron <tc34318>
    And User updates Roof, HVAC, Electrical, Plumbing to current year
    And User validates All Peril Deductible dropdown options are correct and visible
    And User changes CoverageA as <499.999> tc34318
    And User validates All Peril Deductible dropdown options with new CoverageA amount are correct and visible
    And User changes CoverageA as <500.000> tc34318
    And User validates All Peril Deductible dropdown options with new CoverageA 500.000 amount are correct and visible
    And User selects All Other Perils Deductible as <$25.000> and validates 'Deductible for All Other Perils Cannot Exceed Deductible for Hurricane' message
    And User selects Hurricane Deductible and validates same issue message not displayed
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <tc34318>
    And User clicks Forms Chevron <tc34318>
    And User validates 'AIIC DP DO 06 23' and 'Deductible Notification Options' forms are visible in forms 
    And User clicks Deductible Notification Options and validates form version <tc34318>
    And User clicks Policy File Chevron <tc34318>
    Then User clicks New Business Package Link and validates necessary form versions <tc34318>
    
    
    
    
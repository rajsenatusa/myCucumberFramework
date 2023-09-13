##created on 09/12/2023 by Can Yavas

 ## TEST CASE NUMBER & TITLE: MTR-591--HO3, Standard Agent, NB Water Loss>5,000 , WDE, WDL, UW approval required
 ## PRECONDITIONS (IF ANY): APLUS Data - Water Loss >5,000 Use Divine Briggs 11/15/1995 8802 Minnow Creek Dr, Tallahassee, FL 32312
 ## HIGH LEVEL STEPS OF TEST SCRIPT:  Watr Damage Exlusion is required when water loss is >5,000 if not selectedd UW approval is required 
 ## EXPECTED RESULTS: Due to loss history, water damage exclusion must be applied. 
 
 ## User: AG1730
  
 ## PreSetup - Remove loss cause under Capacity Maintenance for county Leon and add after execution
 

@regression @mtr591
Feature: MTR-591--HO3, Standard Agent, NB Water Loss over than 5,000 , WDE, WDL, UW approval required

  Scenario: Validate Water Damage Exlusion is required when water loss is over than 5,000 if not selected UW approval is required
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr591>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr591>
    And User enters all required information on HO3 dwelling screen <mtr591>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User validates 'Risk is ineligible due to age of HVAC' message has been displayed
    And User completes required information on dwelling chevron <mtr591>
    And User validates 'Due to loss history, water damage exclusion must be applied' message has been displayed
    And User clicks Dwelling Chevron <mtr591>
    And User clicks check water damage exclusion and water damage limited
    And User validates 'Due to Loss History, Selection of Limited Water Requires Underwriting Approval' message has been displayed
    And User clicks Dwelling Chevron <mtr591>
    And User deselects water damage exclusion and water damage limited
    And User validates 'Due to loss history, water damage exclusion must be applied' message has been displayed
    And User clicks Finalize button <mtr591>
    And User validates 'Submit For Approval' button is not visible
    And User clicks modify application and clicks check water damage exclusion and water damage limited
    And User clicks Loss History Chevron and validates 'Due to Loss History, Selection of Limited Water Requires Underwriting Approval' text has been displayed
    And User clicks Finalize button <mtr591>
    And User takes note of the application for <mtr591>
    And User validates labels on closeout screen with expected ones
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr591>
    And User validates 'Due to Loss History, Selection of Limited Water Requires Underwriting Approval' message has been displayed
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <mtr591>
    And User validates 'Due to Loss History, Selection of Limited Water Requires Underwriting Approval' label is visible
    And User issues policy and completes test
    
    
    
    
    
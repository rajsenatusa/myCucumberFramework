##created on 09/13/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR589--HO3, Standard Agent, NB Water Loss>5,000 , WDE, WDL, UW approval required
## PRECONDITIONS (IF ANY): APLUS data -Open Water Loss $3,200.00 Michelle Saunders, 110/05/1984 506 Shepard AVe Dundee, FL 33838
## HIGH LEVEL STEPS OF TEST SCRIPT:  Create NB HO3 policy APLUS pulls in an Open Water Loss 
## EXPECTED RESULTS: Agent is not able to bind without Underwriting approval due to open water loss
## "Risks with open losses are ineligible for coverage" Validation message displays.
  
## User: AG1529
  
## Note: Please login with gallopadmin and remove Catestropic threashold limit and add it after execution
## TEST CASE STEPS MODIFIED ON 09/19/2023 REGARDING CAPACITY RULE CHANGE AND APLUS DATA REPORTING ISSUE 

@regression @mtr589 @ho3regression
Feature: MTR589--HO3, Standard Agent, NB Water Loss over 5,000 , WDE, WDL, UW approval required

  Scenario: Validate Agent is not able to bind without Underwriting approval due to open water loss
    Given User login to Spin as Diamond Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr589>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr589>
    And User enters all required information on HO3 dwelling screen <mtr589>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for VOL HO3
    And User completes required information on dwelling chevron <mtr589>
    And User takes note of the application for <mtr589>
    And User signs out
    And User login to Spin as Admin Agent
    And User searches for the application <mtr589>
    And User takes ownership of the application 
    And User validates losses have been displayed and attaches screenshot
    And User clicks Dwelling Tab and updates construction year of the building <mtr589>
    And User transfer application back to producer
    And User signs out
    And User login to Spin as Diamond Agent
    And User searches for the application <mtr589>
    And User clicks Dwelling Chevron <mtr589>
    And User navigates loss history chevron and validates loss claim status labels are visible and attaches screenshot
    And User clicks policy tab and validates 'Risks with open losses are ineligible for coverage' message is visible
    And User clicks Finalize button <mtr589>
    And User validates 'Risks with open losses are ineligible for coverage' text is visible
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr589>
    And User approves application
    And User signs out
    Then User login to Spin as Diamond Agent
    And User searches for the application <mtr589>
    And User scrolls to preview output field and attaches screenshot <mtr589>
    And User issues policy and completes test <mtr589>
    
    
    
    
    
    
    
    
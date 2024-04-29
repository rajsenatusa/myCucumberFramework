#Author: Can Yavas
#created on 04/24/2024
#TEST CASE NUMBER & TITLE: MTR-5523 IM-400 : GOC Verify Agent User able to see Dosto county after clicking on Verify address and agent can issue policy for Desoto county
#Precondition: 
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validating that that a new quote for a policy in DeSoto county is created then Dosto county is populated in drop down after clicking on Verify address link and  without clicking save button
#User: Standard Agent

@regression @mtr5523 @im @gocregression
Feature: MTR-5523 IM-400 : GOC Verify Agent User able to see Dosto county after clicking on Verify address and agent can issue policy for Desoto county

  Scenario: Validating that that a new quote for a policy in DeSoto county is created then Dosto county is populated in drop down after clicking on Verify address link and  without clicking save button
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen and validates Desoto County displayed on county tab <mtr5523>
		And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen <mtr5523>
    And User enters all required information on GOC golfcart screen for <mtr5523>
    And User enters driver information on driver screen <mtr5523>
    And User enters vehicles information on vehicles screen <mtr5523>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User takes note of the application number <mtr5523>
		And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
		And User searches application <mtr5523>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches application <mtr5523>
    And User issues policy
    And User validates that GOC policy has been created successfully and completes test <mtr5523>
    
    
    
    
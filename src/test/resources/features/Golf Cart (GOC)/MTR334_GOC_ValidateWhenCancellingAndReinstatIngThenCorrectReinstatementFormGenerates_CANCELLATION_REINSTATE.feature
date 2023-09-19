#Author: Can Yavas
##created on 08/23/2023

##TEST CASE NUMBER & TITLE: TC 16872--GOC - UWMGR - Company Cancellation - Reason -Substantial change in risk - Reinstatement form_AIIC GOC RI 12 16
##PRECONDITIONS (IF ANY): Active GOC  Policy - Use New Business UWMGR Reports
## HIGH LEVEL STEPS OF TEST SCRIPT:  1.Create GOC NB Policy.
									 ## 2.For company canellation. Start Transaction, click Cancel then select a reason, Finalize
									 ## 3.Reinstate the same way, change date to a future date, then Start Transaction to Reinstate.  
									 ## 4.Validate the correct Reinstatement form is attaching.
## EXPECTED RESULTS: Policy is Cancelled & on reinstatement correct Reinstatement form is attaching to Policy File


@regression @mtr334 @gocregression
Feature: TC 16872--GOC - UWMGR - Company Cancellation - Reason -Substantial change in risk - Reinstatement form AIIC GOC RI 12 16

  Scenario: Validate Policy is Cancelled on reinstatement correct Reinstatement form is attaching to Policy File
  
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr334>
    And User enters GOC product selection information and current date minus <91> days as effective date
    And User enters Producer
    And User enters all required information on GOC quote screen
    And User enters all required information on GOC golfcart screen for <mtr334>
    And User enters driver information on driver screen <mtr334>
    And User enters vehicles information on vehicles screen <mtr334>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that GOC policy has been created successfully and takes note of the policy number <mtr334>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <mtr334>
    And User clicks Start Transaction
    And User selects Cancellation
    And User selects Cancellation Type as Company
    And User selects Substantial change in risk as reason
    And User selects Loss meets policy limits as subreason
    And User selects effective date as cancel date 'current date'
    And User selects pro rate as cancel type and process transaction <mtr334>
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User clicks Start Transaction
    And User clicks Reinstatement Transaction Selection
    And User clicks Start button and process transaction
    And User clicks Policy File Chevron <mtr334>
    And User validates 'Continuation of Coverage' text has been displayed
    Then User clicks 'Continuation of Coverage' link and validates form version 'AIIC GOC RI 12 16' and completes test
    
    
    
    
    
    
    
    
    
    
    

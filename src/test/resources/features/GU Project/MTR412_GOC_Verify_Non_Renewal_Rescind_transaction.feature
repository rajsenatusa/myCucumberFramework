#Author: Can Yavas
##created on 03/14/2024

##TEST CASE NUMBER & TITLE: MTR412--GOC - GOC Verify Non Renewal Rescind transaction
##PRECONDITIONS (IF ANY): Active Renewed GOC  Policy 
## HIGH LEVEL STEPS OF TEST SCRIPT:  1.Search Renewed GOC NB Policy as UW Manager.
									 ## 2.Do Endorsement
									 ## 3.Do Non Renewal 
									 ## 4.Do Non RenewalRequest Stop
## EXPECTED RESULTS: Policy showing new transaction as Non Renewal Request Stop tx


@regression @mtr412 @gocregression @gu
Feature: MTR412--GOC - GOC Verify Non Renewal Rescind transaction

  Scenario: Validate Policy showing new transaction as Non Renewal Request Stop tx
  
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr412>
    And User enters GOC product selection information and current date minus 1 year as effective date <mtr412>
    And User enters all required information on GOC quote screen <mtr412>
    And User enters all required information on GOC golfcart screen for <mtr412>
    And User enters driver information on driver screen <mtr412>
    And User enters vehicles information on vehicles screen <mtr412>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that GOC policy has been created successfully and takes note of the policy number <mtr412>
    And User searches for the policy number <mtr412>
    And User clicks Make Payment and selects credit card and enters due amount for <mtr412>
    And User makes payment with Credit Card for <mtr412>
    And User searches for the policy number <mtr412>
    And User clicks Start Transaction
    And User selects Renewal <mtr412>
    And User does manual renewal on the policy <mtr412>
    And User searches renewed policy <mtr412>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <mtr412>
    And User clicks Golf Cart Chevron and changes changes golf cart coverage from basic to gold
    And User finalizes transaction and completes endorsement and close unnecessary tabs <mtr412>
    And User clicks Start Transaction
    And User selects Non Renewal
    And User selects 'Failure to comply with underwriting requirements' as reason and 'Signed application was not provided' as a sub reason <mtr412>
    And User clicks Process
    And User validates Non_Renewal transaction for GOC policy has been created successfully <mtr412>
    And User clicks Start Transaction
    And User selects Non Renewal Rescind
    And User clicks Start button and process non renewal rescind transaction
    Then User validates Non_Renewal Rescind transaction for GOC policy has been created successfully <mtr412>
    
    
    
    
    
    
    
    
    
    
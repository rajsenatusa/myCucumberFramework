##created on 10/05/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 16854--Golf, Agent, NB, Loss History - 2 or more Loss, UW Approval
## PRECONDITIONS (IF ANY): Use the following data,Clue data 
##Name - MISTY P TROMBLE JR
##DOB -03/27/1950
##Address - 4066 ARTESA DR, 3343, Florida DL - T600421602600

## HIGH LEVEL STEPS OF TEST SCRIPT:  Agent needs UW approval for GOC policy with 2 or more losses.
## EXPECTED RESULTS: Agent cannot Issue New Business until UW Approval is obtained 
  
## User: AG1730


@regression @tc16854 @MTR4507
Feature: TC 16854--MTR4507 Golf, Agent, NB, Loss History - 2 or more Loss, UW Approval 

  Scenario: Validate Agent needs UW approval for GOC policy binding with 2 or more losses
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc16854>
		And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen <tc16854>
    And User enters all required information on GOC golfcart screen for <tc16854>
    And User enters driver information on driver screen <tc16854>
    And User enters vehicles information on vehicles screen <tc16854>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User clicks Policy Chevron and validates 'Underwriting approval required prior to binding due to loss history' error message displayed
    And User clicks Loss History Chevron and validates previous losses displayed and edit driver information on the losses
    And User clicks Policy Chevron and validates 'Underwriting approval required prior to binding due to loss history' and 'Underwriting referral required due to number of accidents' messages displayed
    And User finalizes transaction and validates same error messages displayed on closeout screen
    And User takes note of the application number <tc16854>
		And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
		And User searches application <tc16854>
    And User validates 'Underwriting approval required prior to binding due to loss history' and 'Underwriting referral required due to number of accidents' messages displayed
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches application <tc16854>
    And User process tx and finishes test tc16854
    
    
    
    
    
    
    
    
    
    
    
    
    
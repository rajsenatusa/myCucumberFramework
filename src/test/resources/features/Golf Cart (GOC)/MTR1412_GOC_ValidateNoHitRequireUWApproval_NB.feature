#Author: Can Yavas
##created on 08/22/2023

## PRECONDITIONS (IF ANY): Clue Data to produce No Hit on Driver 
## HIGH LEVEL STEPS OF TEST SCRIPT: Agent needs does not need for UW approval for GOC policy with No Hit on Clue Report 
## EXPECTED RESULTS: Driver received a No HIt on their MVR. This policy will require Underwriting approval.
## Agent can't Issue New Business without UW approval  
## User: AG1730
 
@regression @mtr1412
Feature: TC 16852--Golf Agent, NB, No HIT, UW Approval needed

  Scenario: Validate Agent cant Issue New Business without UW approval
    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr1412>
    And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen
    And User enters all required information on GOC golfcart screen for <mtr1412>
    And User enters driver information on driver screen <mtr1412>
    And User enters vehicles information on vehicles screen <mtr1412>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User validates 'Driver received a No Hit on their MVR. This policy will require Underwriting approval' message has been displayed and 'Submit For Approval' 'Modify Application' labels are visible
    And User takes note of the application number <mtr1412>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <mtr1412>
    And UW User validates 'Driver received a No Hit on their MVR. This policy will require Underwriting approval' message has been displayed and approves transaction
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <mtr1412>
    And User issues policy
    And User validates that GOC policy has been created successfully and complete test
    
    
    
    
    
    
    
    
    
    
    
    
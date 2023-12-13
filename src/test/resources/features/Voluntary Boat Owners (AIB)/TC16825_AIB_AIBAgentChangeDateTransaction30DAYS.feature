##created on 09/26/2023 by Can Yavas

## TEST CASE NUMBER & TITLE: TC 16825--AIB, Agent, Change Date Transaction- 30 DAYS

## PRECONDITIONS (IF ANY): Active AIB policy
## HIGH LEVEL STEPS OF TEST SCRIPT: As an Agent, change Policy Effective Date to 30 days Future Date
  
## EXPECTED RESULTS: UW no approval required for agent while Change Date Transaction 


@regression @tc16825 @MTR4462 @aibregression
Feature: TC 16825-MTR4462-AIB, Agent, Change Date Transaction- 30 DAYS

  Scenario: Validate agent can issue NB policy without UW approval when changing date to 30 days
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc16825>
		And User enters AIB product selection information and current date as effective date
    And User enters all required information on AIB quote screen for <tc16825>
    And User selects liability coverage on quote screen for <tc16825>
    And User adds operator information on quote screen <tc16825>
    And User enters all required information on AIB boat dwelling screen for <tc16825>
    And User enters all required information on AIB review screen
		And User creates AIB application
		And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User takes note of the application for <tc16825>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16825>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc16825>
    And User issues policy and close unnecessary tabs and taking note of the policy number <tc16825>
    And User searches for Policy Number for <tc16825>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 31 days as new effective date <tc16825>
    And User validates 'Requested effective date change requires underwriting review' text is visible <tc16825>
    And User deletes Application <tc16825>
    And User searches for Policy Number for <tc16825>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 30 days as new effective date <tc16825>
    And User validates 'Requested effective date change requires Underwriting review' text is not visible
    Then User process tx and validates expected messages and finishes test <tc16825>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
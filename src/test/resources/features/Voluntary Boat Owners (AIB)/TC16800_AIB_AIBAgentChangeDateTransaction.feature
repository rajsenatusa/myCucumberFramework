##created on 09/26/2023 by Can Yavas

## Title: AIB, Agent, Change Date Transaction 
  
## Preconditions: Active AIB policy
  
## 1. Login a s Agent
## 2. Start change date transaction
## 3. Change effective date to 61 days in the future
## 4. Submit for approval
## 5. Issue NB as Agent


@regression @tc16800 @MTR4463
Feature: TC 16800-MTR4463-AIB, Agent, Change Date Transaction 

  Scenario: Validate agent cannot issue NB policy without UW approval when changing date over 60 days
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <tc16800>
		And User enters AIB product selection information and current date as effective date
    And User enters all required information on AIB quote screen for <tc16800>
    And User selects liability coverage on quote screen for <tc16800>
    And User adds operator information on quote screen <tc16800>
    And User enters all required information on AIB boat dwelling screen for <tc16800>
    And User enters all required information on AIB review screen
		And User creates AIB application
		And User answers all underwriting questions for AIB
    And User checks application dwelling screen and finalizes transaction
    And User takes note of the application for <tc16800>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16800>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the application <tc16800>
    And User issues policy and close unnecessary tabs and taking note of the policy number <tc16800>
    And User searches for Policy Number for <tc16800>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 61 days as new effective date <tc16800>
    And User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' error message visible
    And User clicks Cancel button
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 60 days as new effective date <tc16800>
    And User validates 'Requested effective date change requires underwriting review' text is visible <tc16800>
    And User takes note of the second application number <tc16800>
    And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the latest application <tc16800>
    And User validates 'Requested effective date change requires underwriting review' text is visible <tc16800>
    And User clicks Submit for Approval as Underwriter
    And User signs out
    Then User login to Spin as Underwriter Clerk
    And User searches for the latest application <tc16800>
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the latest application <tc16800>
    And User process tx and validates expected messages and finishes test <tc16800>
    
    
    
    
    
    
    
    
    
    
    
    
    
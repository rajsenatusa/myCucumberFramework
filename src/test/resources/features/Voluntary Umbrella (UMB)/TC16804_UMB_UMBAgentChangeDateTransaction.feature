##created on 10/02/2023 by Can Yavas

## Title: UMB, Agent, Change Date Transaction 
  
## Preconditions: Active UMB policy
  
##  Scenario: As an Agent, change Policy Effective Date to 60 days Future Date
## Change Date transaction not trigger UW Approval
  
## Expected result: UW no approval required for agent while Change Date Transaction
  
## User: AG1730


@regression @tc16804
Feature: TC16804: UMB, Agent, Change Date Transaction 

  Scenario: Validate Agent is able to complete change date transaction to 60 days without UW approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO4 product selection information and current date as effective date
    And User enters all required information on HO4 quote screen
    And User enters all required information on HO4 dwelling screen
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy and makes payment
    And User validates that HO4 policy has been created successfully and takes note of the policy number <tc16804>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <tc16804>
    And User clicks New Quote button and selects current date as effective date
    And User enters UMB product selection information
    And User enters producer code and answers previous policy written with AIIG questions <tc16804>
    And User enters all required information on UMB personal liability screen <tc16804>
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User adds underlying policy in personal liability chevron <tc16804>
    And User finalizes transaction 
    And User issues policy
    And User validates that UMB policy has been created successfully and takes note of the policy number <tc16804>
    And User signs out
    And User login to Spin as Standard Agent
    And User searches for the umbrella policy number <tc16804>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 61 days as new effective date <tc16804>
    And User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' label is visible <tc16804>
    And User clicks Cancel button
		And User searches for the umbrella policy number <tc16804>
		And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 60 days as new effective date <tc16804>
    Then User process tx and validates expected messages and finishes test <tc16804>
    
    
    
    
    
    
    
    
    
    
    
    
    
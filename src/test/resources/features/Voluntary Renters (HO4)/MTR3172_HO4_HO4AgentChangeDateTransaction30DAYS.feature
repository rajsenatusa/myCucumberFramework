##created on 09/25/2023 by Can Yavas

## Title: HO4, Agent, Change Date Transaction 
  
## Preconditions: Active HO4 policy
  
## 1. Login a s Agent
## 2. Start change date transaction
## 3. Change effective date to 31 days in the future
## 4. Submit for approval
## 5. Issue NB as Agent

@regression @mtr3172 @ho4regression @AIIho4
Feature: MTR3172 HO4 HO4 Agent Change Date Transaction 30 DAYS

  Scenario: Validate Agent is not able to complete change date transaction after 30 days without UW approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr3172>
    And User enters HO4 product selection information and effective date as current date
    And User enters all required information on HO4 quote screen with current date as prior policy date <mtr3172>
    And User enters all required information on HO4 dwelling screen <mtr3172>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that HO4 policy has been created successfully
    And User takes note of the policy number for <mtr3172>
    And User searches for Policy Number for <mtr3172>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 31 days as new effective date
    And User validates 'Requested effective date change requires underwriting review' text is visible 
    And User clicks Modify Application and cancels transaction
    And User searches for Policy Number for <mtr3172>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 30 days as new effective date
    Then User process transaction and clicks plus sign and completes test
    
    
    
    
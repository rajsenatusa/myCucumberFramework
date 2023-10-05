##created on 10/5/2023 by Can Yavas

## Title: UMB, Agent, Change Date Transaction 
  
## Preconditions: Active UMB policy
  
## 1. Login a s Agent
## 2. Start change date transaction
## 3. Change effective date to 61 days in the future
## 4. Submit for approval
## 5. Issue NB as Agent

## Test ineffective due to rule change. This change date over 60 days rule is not effective anymore !!! Will not be used in regression

@tc16827
Feature: TC 16827 UMB, Agent, Change Date Transaction 60 days

  Scenario: Validate Agent is not able to complete change date transaction after 60 days without UW approval
    Given User login to Spin as Standard Agent 2
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
    And User validates that HO4 policy has been created successfully and takes note of the policy number <tc16827>
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User searches for the policy number <tc16827>
    And User clicks New Quote button and selects current date as effective date
    And User enters UMB product selection information
    And User enters producer code and answers previous policy written with AIIG questions tc16827
    And User enters all required information on UMB personal liability screen <tc16827>
    And User enters all required information on UMB review screen
    And User creates UMB application
    And User answers all underwriting questions for UMB
    And User adds underlying policy in personal liability chevron tc16827
    And User finalizes transaction 
    And User issues policy
    And User validates that UMB policy has been created successfully and takes note of the policy number <tc16827>
    And User signs out
    And User login to Spin as Standard Agent 2
    And User searches for the umbrella policy number <tc16827>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 61 days as new effective date <tc16827>
    And User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' label is visible <tc16827>
    And User clicks Cancel button
		And User searches for the umbrella policy number <tc16827>
		And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 60 days as new effective date <tc16827>
    And User validates 'Requested effective date change requires Underwriting review' label is visible <tc16827>
    And User takes note of the application for <tc16827>
    And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches application <tc16827>
    And User validates 'Requested effective date change requires underwriting review' text is visible tc16827
    And User clicks Submit for Approval as Underwriter
    And User signs out
    Then User login to Spin as Underwriter Clerk
    And User searches application <tc16827>
    And User validates 'Requested effective date change requires underwriting review' text is visible tc16827
    And User approves application
    And User signs out
    And User login to Spin as Standard Agent
    And User searches application <tc16827>
    And User validates 'Requested effective date change requires underwriting review' text is visible tc16827
    And User process tx and validates expected messages and finishes test tc16827
    
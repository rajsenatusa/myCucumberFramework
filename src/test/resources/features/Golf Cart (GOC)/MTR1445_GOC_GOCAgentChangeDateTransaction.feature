##created on 10/02/2023 by Can Yavas

## Title: GOC, Agent, Change Date Transaction 
  
## Preconditions: Active GOC policy
  
## 1. Login a s Agent
## 2. Start change date transaction
## 3. Change effective date to 61 days in the future
## 4. Submit for approval
## 5. Issue NB as Agent


@regression @mtr1445 @gocregression 
Feature: MTR1445: GOC, Agent, Change Date Transaction 

  Scenario: Validate Agent is not able to complete change date transaction after 60 days without UW approval
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr1445>
		And User enters GOC product selection information and current date as effective date
    And User enters all required information on GOC quote screen
    And User enters all required information on GOC golfcart screen for <mtr1445>
    And User enters driver information on driver screen <mtr1445>
    And User enters vehicles information on vehicles screen <mtr1445>
    And User enters all required information on GOC review screen
    And User creates GOC application
    And User answers all underwriting questions for GOC
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that GOC policy has been created successfully and takes note of the policy number <mtr1445>
		And User searches for Policy Number for <mtr1445>
    And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 61 days as new effective date mtr1445
		And User validates 'Maximum change date allowed is 60 days. You will need to rewrite this policy.' text is visible mtr1445
		And User clicks Cancel button
		And User searches for Policy Number for <mtr1445>
		And User clicks Start Transaction
		And User clicks Change Date Transaction Selection
    And User selects current date plus 60 days as new effective date mtr1445
		And User validates 'Requested effective date change requires underwriting review' text is visible and previous text not visible mtr1445
    And User takes note of the application number <mtr1445>
		And User clicks Submit for Approval button
    And User signs out
    And User login to Spin as Underwriter
		And User searches application <mtr1445>
    And User validates 'Requested effective date change requires underwriting review' text is visible mtr1445
    And User clicks Submit for Approval as Underwriter
    And User signs out
    Then User login to Spin as Underwriter Clerk
		And User searches application <mtr1445>
		And User validates 'Requested effective date change requires underwriting review' text is visible mtr1445
		And User approves application
    And User signs out
    And User login to Spin as Standard Agent
		And User searches application <mtr1445>
		And User validates 'Requested effective date change requires underwriting review' text is visible mtr1445
		And User process tx and validates expected messages and finishes test mtr1445
		
		
		
		
		
		
		
		
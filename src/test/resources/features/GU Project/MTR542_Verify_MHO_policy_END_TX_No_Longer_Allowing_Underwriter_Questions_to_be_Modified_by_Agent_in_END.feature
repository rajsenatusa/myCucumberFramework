##created on 03/20/2024 by Can Yavas

## TEST CASE NUMBER & TITLE: MTR542--Verify MHO policy END TX No Longer Allowing Underwriter Questions to be Modified by Agent in END
## PRECONDITIONS (IF ANY): 1. Issue VOL MHO3 policy 
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Start Endorsement with policy eff.date,
## 2. Navigate to Underwriting Question Chevron and validate questions are greyed out
## 3. Cancel Transaction and start new end with policy eff.date + 10 days
## 4. Navigate to Underwriting Question Chevron and validate questions are greyed out
## 5. Cancel Transaction, Log out as Agent, log in as Underwriter
## 6. Start Endorsement with policy eff.date
## 7. Navigate to Underwriting Question Chevron and validate questions are NOT greyed out and editable
## 8. Cancel Transaction and start new end with policy eff.date + 10 days
## 9. Navigate to Underwriting Question Chevron and validate questions are NOT greyed out and editable, Select No for Questions 12 & 17
## 10. Click Finalize and Endorse policy
  
## EXPECTED RESULTS: Verify MHO policy END TX No Longer Allowing Underwriter Questions to be Modified by Agent in END
  
## User: Underwriter, Standard Sales Agent (AG1730A1)


@regression @mtr542 @mho3regression @gu
Feature: MTR542--Verify MHO policy END TX No Longer Allowing Underwriter Questions to be Modified by Agent in END

  Scenario: Verify MHO policy END TX No Longer Allowing Underwriter Questions to be Modified by Agent in END
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr542>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr542>
    And User enters MHO3 product selection information and effective date as current date
		And User enters all required information on MHO3 quote screen with prior exp date as current date <mtr542>
		And User enters all required information on MHO3 dwelling screen <mtr542>
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers underwriting questions 7,13,24,25 as Yes others NO for MHO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number <mtr542>
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date <mtr542>
    And User clicks Underwriting Questions Chevron
		And User validates that UW Questions is not editable <mtr542>
    And User cancels transaction
    And User searches previously created policy <mtr542>
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date plus 10 days <mtr542>
    And User clicks Underwriting Questions Chevron
    And User validates that UW Questions is not editable <mtr542>
    And User cancels transaction
    And User signs out
		And User login to Spin as Underwriter
		And User changes system date to current date <mtr542>
		And User searches previously created policy <mtr542>
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
    And User selects endorsement date as current date <mtr542>
    And User clicks Underwriting Questions Chevron
    And User validates that UW Questions is editable <mtr542>
    And User cancels transaction
    And User searches previously created policy <mtr542>
    And User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date plus 10 days <mtr542>
    And User clicks Underwriting Questions Chevron
    And User validates that UW Questions is editable <mtr542>
    And User changes answers for UW questions 12 and 17 as No <mtr542>
    Then User finalizes transaction and endorses policy and completes test <mtr542>
    
    
    
    
    
    
    
    
    
    
    
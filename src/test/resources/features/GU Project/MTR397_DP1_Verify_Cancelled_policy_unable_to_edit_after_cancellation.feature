## Author: Can Yavas
## created on 01/11/2024

## TEST CASE NUMBER & TITLE: MTR397--VOL DP1, Verify Cancelled policy unable to edit after cancellation
## PRECONDITIONS (IF ANY): Create  Vol DP1 policy with Full pay and proper Email id
## HIGH LEVEL STEPS OF TEST SCRIPT:  
## 1.Login to Spin application as Agent
## 2.Change System date and book date same as Renewl effective date
## 3.Open the policy mentioned in precondition
## 4.Click Start Transaction > Select Cancellation
## 5.Click on Policy File Tab
## 6.Click More> Start Transaction> Endorsement button

## EXPECTED RESULTS: 1.User able to see Refund Statement
## 2.User able to see  Cancellation Confirmation form
## 3.User able to see an error message saying that The current transaction is out of sequence. Processing it will unapply the prior transactionand Policy not able to edit

## User: Standard Agent 


@regression @mtr397 @dp1regression @gu 
Feature: MTR397--VOL DP1, Verify Cancelled policy unable to edit after cancellation

  Scenario: Validate User able to see an error message saying that The current transaction is out of sequence

    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr397>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date <mtr397>
	 	And User enters all required information on DP1 dwelling screen <mtr397>
		And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy and makes payment with credit card
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number <mtr397>
    And User takes note of the renewal effective date from to tasks tab
    And User signs out
    And User login to Spin as Underwriter Clerk
    And User changes system date to renewal date <mtr397>
    And User searches for the policy number <mtr397>
    And User clicks Start Transaction
    And User selects Cancellation 
    And User selects Cancellation Type as Insured <mtr397>
    And User selects Property Sold in risk as reason <mtr397>
    And User selects pro rate as cancel type and process transaction <mtr397>
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User validates Policy Status displayed as Cancelled 
    And User clicks Policy File Chevron <mtr397>
    And User validates Cancellation Confirmation form listed and validates form
    And User changes system date to current date <mtr397>
    And User searches for the policy number <mtr397>
    And User clicks Start Transaction
    And User selects Endorsement
    And User selects endorsement date as current date <mtr397>
    Then User validates 'The current transaction is out of sequence. Processing it will unapply the prior transaction.' message displayed and completes test
    
    
    
    
    
    
    
    
    
    
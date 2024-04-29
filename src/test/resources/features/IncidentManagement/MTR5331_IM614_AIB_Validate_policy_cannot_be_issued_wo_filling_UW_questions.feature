##created on 03/26/2024 by Can Yavas
## TEST CASE NUMBER & TITLE: MTR5331--IM-614 : AIB Validate policy cannot be issued w/o filling UW questions
## PRECONDITIONS (IF ANY): 
## HIGH LEVEL STEPS OF TEST SCRIPT:  1. Create a NB AIB Policy with system/effective date = current date 
## 2. After creating application, modify insured address
## 3. Click on copy to mailing address link, Click on copy to billing address link
## 4. Complete all required Underwriting Questions with an asterisk (*). fix.. message displays
## 5. Click modify application button
## 6. Answer all UW questions 
## 7. Click finalize and issue policy

## EXPECTED RESULTS: 1. Verifying that when a user clicks on �Copy to Mailing Address� while on the application that the Location address is copied to the Mailing Address
## 2. Confirming that users are not allowed to proceed without answering the UW questions. 
## User: Standard Agent


@regression @mtr5331 @aibregression @im
Feature: MTR5331--IM-614 : AIB Validate policy cannot be issued w/o filling UW questions

  Scenario: Validate that AIB Validate policy cannot be issued w/o filling UW questions
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr5331>
    When User starts transaction as a new customer
		And User enters all required information on policy information screen <mtr5331>
		And User enters AIB product selection information and current date as effective date
		And User enters all required information on AIB quote screen for <mtr5331>
		And User selects liability coverage on quote screen for <mtr5331>
		And User adds operator information on quote screen <mtr5331>
		And User enters all required information on AIB boat dwelling screen for <mtr5331>
		And User enters all required information on AIB review screen <mtr5331>
		And User creates AIB application
		And User clicks Policy Chevron <mtr5331>
		And User modify address and copies to mailing and billing address fields
		And User finalizes transaction and validates 'Complete all required Underwriting Questions with an asterisk. fix...' message <mtr5331>
		And User clicks Modify Application button
		And User clicks Underwriting Questions Chevron
		And User answers all underwriting questions for AIB
		And User checks application dwelling screen and finalizes transaction
		Then User issues policy and close unnecessary tabs and completes test <mtr5331>
		
		
		
		
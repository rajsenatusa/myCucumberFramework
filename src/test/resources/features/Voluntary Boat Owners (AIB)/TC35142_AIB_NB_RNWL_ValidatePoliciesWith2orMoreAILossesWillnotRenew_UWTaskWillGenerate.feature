#Author: Can Yavas
##created on 08/21/2023

@regression @tc35142
Feature: TC 35142--AIB Validate boat policies with 2 or more AI claims will not renew and UW task will be generated

  Scenario: Validating boat policies with 2 or more AI Claims do not renew and UW task will be created
  
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
		And User enters all required information on policy information screen
		And User enters AIB product selection information and current date as effective date
		And User enters Producer
		And User enters all required information on AIB quote screen for <tc35142>
		And User selects liability coverage on quote screen for <tc35142>
		And User adds operator information on quote screen
		And User enters all required information on AIB boat dwelling screen for <tc35142>
		And User enters all required information on AIB review screen
		And User creates AIB application
		And User answers all underwriting questions for AIB
		And User checks application dwelling screen and finalizes transaction
		And User issues policy and close unnecessary tabs and taking note of the policy number <tc35142>
		And User signs out
		And User login to Spin as Adjuster 2
		And User searches for the policy <tc35142>
		And User clicks Report Loss
		And User sets loss date as current date
		And User selects collision as loss cause, police department as authority contacted and validates authority name and case number labels are visible
		And User selects all required information on loss notice creation screen
		And User clicks complete button and takes note of the claim number
		And User searches for the policy <tc35142>
		And User clicks Report Loss
		And User sets loss date as current date second time
		And User selects cracking as loss cause, police department as authority contacted and validates authority name and case number labels are visible
		And User selects all required information on loss notice creation screen
		And User clicks complete button and takes note of the second claim number
		And User signs out
		And User login to Spin as Admin Agent
		And User searches for the policy <tc35142>
		And User clicks Make Payment for <tc35142> and selects credit card and enters due amount
		And User searches for the policy <tc35142>
		And User clicks Task Tab
		And User checks show system task and take note preautorenew date
		And User changes system date to preautorenewal date and run pre-automated batch job
		And User searches for the policy <tc35142>
		And User clicks Task Tab
		Then User validates UW task generated and completes the test
		
		
		
		
		
		
		
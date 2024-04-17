#Author: Can Yavas
##created on 08/11/2023

@regression @mtr557 @ho4regression @Aprilho4
Feature: TC 16891--HO4 - UW - Non-Renewals and Rescind Non-Renewal ( 124 & 125 Days from Expiration), Continuation of Coverage form

  Scenario: Validate that UW can Non Renew a policy upto 125 day from Policy Expiration Date
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr557>
    And User enters HO4 product selection information and effective date as current date
    And User enters all required information on HO4 quote screen with current date as prior policy date <mtr557>
    And User enters all required information on HO4 dwelling screen <mtr557>
    And User enters all required information on HO4 review screen
    And User creates HO4 application
    And User answers all underwriting questions for HO4
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that HO4 policy has been created successfully
    And User takes note of the policy number for <mtr557>
    And User signs out
    And User login to Spin as Underwriter 
    And User clicks Admin Tab and does change date transaction to exp.date minus <125> days
		And User searches for Policy Number for <mtr557>
		And User clicks Start Transaction
		And User clicks Non-Renewal Transaction Selection
		And User selects 'Failure to comply with underwriting requirements' as reason
		And User process transaction and clicks plus sign and validates UW reason message has been displayed
		And User clicks Start Transaction
		And User clicks Non-Renewal Rescind Transaction Selection
		And User validates 'Failure to comply with underwriting requirements;  additional information required for underwriting review not provided.' message has been displayed
		And User clicks Start and process transaction
		And User clicks Policy File Tab
		And User clicks Expand Button for Rescission of Non-Renewal Notice
		And User clicks 'Rescission of Non-Renewal Notice' form
		And User switches the form, saves form and does comparision with expected texts
		And User clicks Admin Tab and does change date transaction to exp.date minus <124> days
		And User searches for Policy Number for <mtr557>
		And User clicks Start Transaction
		And User clicks Non-Renewal Transaction Selection
		And User selects 'Failure to comply with underwriting requirements' as reason
		And User validates 'Transaction must occur within the allowed Non-Renewal Request date range' label has been displayed
		
		
		
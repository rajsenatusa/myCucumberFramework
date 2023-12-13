#Author: Can Yavas
##created on 08/08/2023

@regression @tc15212 @ho6regression
Feature: TC 15212--Vol HO6 - Creating HO6 Application LLC w/eSignature

  Scenario: Validate that valid user role, create a HO6 NB (LLC) with selecting Esignature on CloseOut Screen
    Given User login to Spin as Standard Agent
 		When User starts transaction as a new customer
    And User enters all required information on policy information screen <tc15212>
    And User enters HO6 product selection information and current date as effective date
    And User enters all required information on HO6 quote screen with current date as prior policy date <tc15212>
    And User enters all required information on HO6 dwelling screen <tc15212>
    And User enters all required information on HO6 review screen
    And User creates HO6 application
    And User answers all underwriting questions for HO6
    And User checks application dwelling screen and finalizes transaction
    And User sets payment type and sets E-signature
    And User validates <Missing Required Information> error message has been displayed
  	And User enters only agent first name for E-Signature and clicks issue new business button and validates error message
  	And User enters only agent last name for E-Signature and clicks issue new business button and validates error message
  	And User enters same email address for Agent and validates <Email address must be different for each Signer. Please update email address> error message
  	And User enters Agent Email address and clicks issue new business button and validates error message
  	And User enters Agent License Number and issues policy
  	Then User clicks eSignature Chevron 
  	And User validates Cancel label and Refresh button is visible
  	And User validates status has been displayed as Sent for Agent and Insured
  	And User validates Insured and Agent Email addresses have been displayed
  	
  	
  	
  	
  	
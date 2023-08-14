#Author: Can Yavas
##created on 08/14/2023

@regression @mtr404
Feature: TC 16870--DP1 - UWMNGR - Company Cancellation - Reason Property Ineligible - Reinstatement form_AIIC RI 11 14

  Scenario: Validate Policy is Cancelled & on reinstatement correct Reinstatement form is attaching to Policy File
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters DP1 product selection information and current date as effective date
    And User enters Producer Code
    And User enters all required information on DP1 quote screen with current date as prior policy date
		And User enters all required information on DP1 dwelling screen
		And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs
    And User clicks Start Transaction
    And User clicks Cancellation Transaction Selection
    And User selects Cancellation Type as Company
    And User selects Property ineligible as reason
    And User selects Constructed over water as subreason
    And User selects effective date as cancel date 'current date plus 30 days'
    And User selects pro rate as cancel type and process transaction
    And User completes cancellation transaction and validates policy transaction status as cancelled
    And User clicks Start Transaction
    And User clicks Reinstatement Transaction Selection
    And User clicks Start button and process transaction
    And User clicks Forms Chevron
    And User verifies AIIC RI 11 14 generated on Forms chevron
    And User searches for Policy Number for <MTR404>
    And User clicks Policy File Chevron for <MTR404>
    And User validates Continuation of Coverage form has been displayed
    And User clicks Continuation of Coverage form, saves it to local and do comparisions and validations
    				##Validated texts on the form : AIIC RI 11 14  /  "Your policy has been reinstated as of the Reinstatement Date shown above without interruption of coverage since"
    																		##: "underwriting reason(s) met."	
    
    
    
    
    
#Author: Can Yavas
##created on 08/15/2023

@regression @mtr253 @dp1regression
Feature: TC 35197--VOL DP1 Claims UI: Tracking for claims in which customer was alerted to roof loss by a contractor/roofer

  Scenario: Create a claim that is reported by Insured/Contractor to validate screen flow
   functionality and data warehouse results
   
   	Given User login to Spin as Standard Agent
	 	When User starts transaction as a new customer
   	And User enters all required information on policy information screen <mtr253>
   	And User enters DP1 product selection information and current date as effective date
   	And User enters all required information on DP1 quote screen with current date as prior policy date <mtr253>
	 	And User enters all required information on DP1 dwelling screen <mtr253>
		And User enters all required information on DP1 review screen
    And User creates DP1 application
    And User answers all underwriting questions for DP1
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    And User validates that DP1 policy has been created successfully and close tabs and takes note of the policy number
    And User signs out
    And User login to Spin as Adjuster
    And User changes system date to current date plus <60> days
    And User searches for the policy <mtr253>
    And User clicks Report Loss
    And User sets loss date as current date plus <60> days
    And User validates reported by dropdown options is visible
    And User selects reported by as Insured Contractor
    And User validates Contractor Name Label is visible
    And User selects loss cause and clicks Save
    And User completes all required information on claim chevron
    And User changes reported by as Agent and validates Contractor Name text is not visible anymore
    And User selects Insured Contractor as reported by and validates Contractor Name label is visible
    And User clicks Save and validates <Missing Required Information> message has been displayed
    And User changes reported by as Attorney and validates Contractor Name text is not visible anymore
    And User clicks save and takes note of the loss number
    And User clicks Complete and takes note of the claim number
    And User changes system date to current date plus <90> days
    And User searches claim number for <mtr253>
    And User clicks start transaction
    And User clicks Summary Chevron
    And User selects Insured Contractor as reported by and validates Contractor Name label is visible
    And User clicks Save and validates <Missing Required Information> message has been displayed
    And User sets contractor name and clicks save and finalizes transaction
    
    
    
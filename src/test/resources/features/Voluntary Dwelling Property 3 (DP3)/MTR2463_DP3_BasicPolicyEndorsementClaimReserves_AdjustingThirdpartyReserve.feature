# Author: Can Yavas
# created on 11/13/2023

# TEST CASE NUMBER & TITLE: MTR2463--Apply Prior Losses Concession: Validate Apply Prior Losses = Yes on NB; Age of home 0-5 years; Water Factors will apply
    
# EXPECTED RESULTS: Prior Carrier Claims Surcharge displays Number of Claims as number of 
# water losses from Loss history tab in Worksheet 
    
# User: Gallopadmin

@regression @mtr2463 @dp3regression
Feature: MTR2463--Apply Prior Losses Concession: Validate Apply Prior Losses = Yes on NB; Age of home 0-5 years; Water Factors will apply

  Scenario: Validate Prior Carrier Claims Surcharge displays Number of Claims as number of water losses from Loss history tab in Worksheet
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr2463>
    And User enters DP3 product selection information and effective date as current date <mtr2463>
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr2463>
    And User enters all required information on DP3 dwelling screen <mtr2463>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3 <mtr2463>
    And User updates plumbing,electrical,hvac years as current year minus 1 year and sets CovC as <100.000>, CovL as <300.000>
    And User finalizes transaction for <mtr2463>
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <mtr2463>
    And User signs out
    And User login to Spin as Adjuster
    And User changes system date to current date plus <10> days <mtr2463>
    And User searches for the policy <mtr2463>
    And User clicks Report Loss
    And User sets loss date as current date plus <10> days <mtr2463>
    And User selects loss cause as Liability BI Non Pollution and validate the following fields
    And User selects sub loss cause as All Other Non-Pollution and selects examiner clicks notice and validates 'This loss notice is incomplete until you click the Complete action followed by the Submit button' message
    And User clicks Complete and takes note of the claim number <mtr2463>
    And User clicks Claimants Tab
    And User Adds New Claimant as Third Party Employee
    And User starts Transaction and clicks Detail Chevron
    And User clicks Financial Actions Tab
    And User adjust reserves and do UI validations <mtr2463>
    And User sets Personal Liability Reserves as <5000> Medical Payment to Others as <1000> and finalize and process transaction
    And User starts Transaction and clicks Detail Chevron
    And User clicks Financial Actions Tab
    Then User adjust recoveries and do UI validations and completes test<mtr2463>
    
    
    
    
    
    
    
    
    
    
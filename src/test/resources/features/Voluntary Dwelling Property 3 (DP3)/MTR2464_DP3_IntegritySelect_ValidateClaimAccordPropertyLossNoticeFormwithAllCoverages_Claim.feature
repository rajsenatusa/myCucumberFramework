# Author: Can Yavas
# created on 11/14/2023

# TEST CASE NUMBER & TITLE: MTR2464 --Claim Acord Property Loss Notice Form; with all coverages Integrity Select on 01/21/2022
# PRECONDITIONS (IF ANY): Create DP3 policy effective 01/21/2022 with occupancy = Owner occupied, Integrity Select with the following coverages:
# 1. Water Damage Exclusion and Water Damage Limited coverages both should be included
# 2. Water Back Up and Sump Overflow = $5,000
# 3. L-Personal Liability = $300,000
# 4. C-Personal Property = $10,000
# 5. Animal Liability = $100,000
# 6. Include Personal Injury coverage

# HIGH LEVEL STEPS OF TEST SCRIPT:  
  
# EXPECTED RESULTS: The following coverage reserves will display under the mentioned coverages accordingly in 
# alphabet order: and will be included in Claim Property Loss notice form:
# 1. Water Back Up and Sump Overflow displays under A-Dwelling
# 2. Animal Liability and Personal Injury will display under L-Personal Liability
# 3. C-Personal Property will display with limit selected
  
# User: adjuster1

@regression @mtr2464
Feature: MTR2464 --Claim Acord Property Loss Notice Form; with all coverages Integrity Select on 01/21/2022

  Scenario: Validate following coverage reserves will display under the mentioned coverages accordingly in alphabet order
    Given User login to Spin as Underwriter Clerk
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr2464>
    And User enters DP3 product selection information and effective date as current date <mtr2464>
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr2464>
    And User enters all required information on DP3 dwelling screen <mtr2463>
    And User enters all required information on DP3 review screen
    And User creates DP3 application
    And User answers all underwriting questions for DP3 <mtr2464>
    And User updates plumbing,electrical,hvac,roof years as current year <mtr2464>
    And User finalizes transaction for <mtr2464>
    And User issues policy
    And User validates that DP3 policy has been created successfully and takes note of policy number <mtr2464>
    And User signs out
    And User login to Spin as Claim CSR
    And User changes system date to current date plus <10> days <mtr2464>
    And User searches for the policy <mtr2464>
    And User clicks Report Loss
    And User sets loss date as current date plus <10> days <mtr2464>
    And User selects loss cause as Water Damage <mtr2464>
    And User selects sub loss cause as Sewer Back Up and completes required information <mtr2464>
    And User clicks Complete and takes note of the claim number <mtr2464>
    
    
    
    
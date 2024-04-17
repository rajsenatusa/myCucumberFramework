#Author: Can Yavas
##created on 08/02/2023

@regression @tc35721 @mtr537 @dp3regression 
Feature: TC 35721-MTR537-DP3, Validate Owner Occupied NB Endorsement- NB INTEGRITY SELECT Text Builder

  Scenario: As an Agent, Create Integrity Select Policy, once issued, endorse to 
   change to Basic Policy, validate coverages revert and validate Text Builder

    Given User login to Spin as Standard Agent
		When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr537>
    And User enters DP3 product selection information and effective date as current date
    And User enters all required information on DP3 quote screen with current date as prior policy date <mtr537>
    And User enters all required information on DP3 dwelling screen and validates New Line Item Displays Package Basic Policy and Integrity Select with Radio buttons display on the Dwelling Detail tile
    And User selects Integrity Select Package
    And User sets CoverageA <400.000> and validates Cov-C defaults to <25%> Home Computer defaults to <$2,500> L-Personal Liability defaults to <$100,000>
    And User enters all required information on DP3 review screen
    And User navigates back to Policy General and changes the occupancy to Tenant
    And User validates <Occupancy has been updated which would impact the prior coverages selected> is displayed
    And User validates Cov C will be updated to <$0> where the user will need to update, Home Computer defaults to <None>, L-Personal Liability defaults to <$0>
    And User navigates back to Policy General and changes the occupancy to Owner
    And User selects Integrity Select Package
    And User creates DP3 application
    And User answers all underwriting questions for DP3
    And User finalizes transaction and issues policy for DP3
    And User validates that DP3 policy has been created successfully and closes unnecessary tabs
    Then User clicks Start Transaction
		And User clicks EN Transaction Selection
		And User selects endorsement date as current date
		And User clicks Dwelling Chevron and Coverage added: Animal Liability, Coverage Modified: C - Personal Property Limit Changed From $200,000 to $100,000, Coverage Modified: L - Personal Liability Limit Changed From $100,000 to $300,000, Coverage Modified: Home Computer Limit Changed From $2,500 to $7,000
		And User finalizes transaction and verifies added coverage texts have been displayed on closeout screen
		And User endorses policy
		Then User expands  endorsement on transaction history tab and verifies changes made
		
		
		
    
    
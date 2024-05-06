# Author: Mustafa Cemek
# created on 04/17/2024
#TEST CASE NUMBER & TITLE: MTR-5913-LFM2-202 Validation of Base Letter Template - Restitution Letter to Law Enforcement on a VOHO3 - Basic-Approved
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: User should be able to create, view, Edit/Enter to the Restitution Letter to Law Enforcement Form
#User: Standard Agent, 		Adjuster1
@regression @mtr5913 @lfm
Feature: MTR5913_Verify User is able to create "Restitution Letter to Law Enforcement" on a VOL HO3 claim and submitted Claim File

  Scenario: Verify User is able to edit the fields and see the Restitution Letter to Law Enforcement letter as pdf in Claim File
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5913>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr5913>
    And User enters all required information on HO3 dwelling screen <mtr5913>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5913>
    And User signs out
    Given User login to Spin as Adjuster
    And User Searchs for Policy Number <mtr5913>
    And User clicks Report Loss
    And User sets Loss Date as current date
    And User enters all required Loss Notice Information for Hail
    And User clicks Complete button
    Then User verifies the loss location is set to insured location
    Then User verifies the Authority information
    And Use enters Assigned Adjuster as Shannan Triplett
    And User clicks Correspondence
    And User selecks Correspondence Form as 'Restitution Letter to Law Enforcement'
    Then User verifies the fields can Edit and Enter
    And User clicks Process Correspondence
    And User clicks Claim File
    Then User verifies 'Interactive Restitution Law Enforcement Letter' in Claim File
    And User clicks on 'Interactive Restitution Law Enforcement Letter'
    Then User verifies 'Interactive Restitution Law Enforcement Letter' displays

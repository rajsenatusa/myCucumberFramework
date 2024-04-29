# Author: Mustafa Cemek
# created on 04/19/2024
#TEST CASE NUMBER & TITLE: MTR-5891-LFM2-12 Validation of Base Letter Template - Request for Information Letter on a VOHO3 - Basic-RE Sec
#Precondition: Create a HO3 policy.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: User should be able to create, view, Edit/Enter to the Request for Information Letter
#User: Standard Agent, 		Adjuster1
@regression @mtr5891 @lfm
Feature: MTR5891_Verify User is able to create 'Request for Information Letter' on a VOL HO3 claim and submitted Claim File

  Scenario: Verify User is able to edit the fields and see the Request for Information Letter as pdf in Claim File
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5891>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr5891>
    And User enters all required information on HO3 dwelling screen <mtr5891>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5891>
    And User signs out
    Given User login to Spin as Adjuster
    And User Searchs for Policy Number <mtr5891>
    And User clicks Report Loss
    And User sets Loss Date as current date
    And User enters all required Loss Notice Information for Hail
    And User clicks Complete button
    Then User verifies the loss location is set to insured location
    Then User verifies the Authority information
    And Use enters Assigned Adjuster as Shannan Triplett
    And User clicks Correspondence
    And User selecks Correspondence Form as 'Request for Information Letter'
    Then User verifies the fields can Edit and Enter
    And User clicks Process Correspondence
    And User clicks Claim File
    Then User verifies 'Request for Information Letter' in Claim File
    And User clicks on 'Request for Information Letter'
    Then User verifies 'Request for Information Letter' displays

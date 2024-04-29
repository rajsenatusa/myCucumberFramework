#Author: Can Yavas
#created on 04/18/2024
#TEST CASE NUMBER & TITLE: MTR-5887 HO3 LFM2-12 Validation of Base Letter Template - Request for Information Letter on a VOHO3 - Basic-Approved
#Precondition: Create a HO3 policy
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Verify User is able to create "Request for Information Letter" on a VOHO3 claim and submitted Claim File
#User: Standard Agent, Adjuster1

@regression @mtr5887 @lfm
Feature: MTR-5887 HO3 LFM2-12 Validation of Base Letter Template - Request for Information Letter on a VOHO3 - Basic-Approved

  Scenario: Verify User is able to create Request for Information Letter on a VOHO3 claim and submitted Claim File
    Given User login to Spin as Standard Agent
    And User changes system date to current date <mtr5887>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen <mtr5887>
    And User enters HO3 product selection information and current date as effective date
    And User enters all required information on HO3 quote screen <mtr5887>
    And User enters all required information on HO3 dwelling screen <mtr5887>
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User validates that HO3 policy has been created successfully and takes note of the policy number <mtr5887>
    And User signs out
    And User login to Spin as Adjuster
    And User changes system date to current date <mtr5887>
    And User Searchs for Policy Number <mtr5887>
    And User clicks Report Loss
    And User sets Loss Date as current date <mtr5887>
    And User fills all required information on claim notice screen and selects freezing as loss cause <mtr5887> 
    And User clicks Claim Overview Chevron <mtr5887>
    And User clicks More and starts transaction <mtr5887> 
    And User clicks first claimant and selects assigned adjuster
    And User clicks Finalize button 
    And User process transaction <mtr5887>
    And User clicks Correspondence Tab <mtr5887> 
    And User selects Request for Information Letter <mtr5887>
    And User validates Request for Information Letter displayed on Draft Editor, takes screenshot and validate editable and non editable fields
    And User clicks Process Correspondence button <mtr5887> 
    And User clicks Claim File Chevron <mtr5887>
    Then User clicks Request for Information Letter and validates form version and completes test
    
    
    
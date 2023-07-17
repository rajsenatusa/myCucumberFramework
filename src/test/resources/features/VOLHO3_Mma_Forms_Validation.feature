#Author: Kalesha
##updated on 07/17/2023 by Can Yavas
Feature: HO3 MMA scenario

  @smoke @regression @ho3mma
  Scenario Outline: MTR 355 Validate HO3 MMA AcknowledgmentFrom on NB and END
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters HO3 product selection information and effective date
    And User enters all required information on HO3 quote screen
    And User enters all required information on HO3 dwelling screen with MMA
    And User enters all required information on HO3 review screen
    And User creates HO3 application
    And User answers all underwriting questions for HO3
    And User checks application dwelling screen and finalizes transaction
    And User issues policy
    Then User validates that HO3 policy has been created successfully
    And User navigates to policyfile screen
    And User clicks on on the application and validate the MMA acknowledge form "AIIC HO3 MMAA 03 22" attached in the application form
    And User returns to main page
    And User searches policy number before starting transaction
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    And User navigates to policyfile screen
    Then User clicks on the application and validate HO3 MMA acknowledge form not attached in the endorsement package
    
    Examples: Test Data
      | EndorsementEffectiveDate | 
      | 07/28/2023               |
    

  
  Scenario: LoginStepsTestEnvironments.feature
  
  Scenario: VOLHO3policy.feature
  
  Scenario: VOLDP1policy.feature
  
  Scenario: VOLDP3policy.feature

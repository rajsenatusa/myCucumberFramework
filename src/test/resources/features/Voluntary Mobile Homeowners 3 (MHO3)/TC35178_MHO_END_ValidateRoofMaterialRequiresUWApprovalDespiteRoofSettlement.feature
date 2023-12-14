#Author: Can Yavas
##created on 10/20/2023

 # TEST CASE NUMBER & TITLE: TC 35178--MHO Park AGENT UW NB END - Validate Other for Roof Material can be selected on endorsement and a referral will be received, despite Roof Settlement.
 # PRECONDITIONS (IF ANY): 
 # HIGH LEVEL STEPS OF TEST SCRIPT:  Validate Other for Roof Material  can be selected on endorsement and a referral will be 
 # received, despite Roof Settlement.
  
 # EXPECTED RESULTS: Other can be selected and there is a referral to underwriting for Roof Settlement 
 # "Requires underwriting approval due to roof material." 
  
 # User: AG1730


@regression @tc35178 @MTR4505 @mho3regression
Feature: TC 35178-MTR4505-MHO Park AGENT UW NB END - Validate Other for Roof Material can be selected on endorsement and a referral will be received, despite Roof Settlement

  Scenario: Validate Other for Roof Material  can be selected on endorsement and a referral will be received, despite Roof Settlement
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address <tc35178>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen and selects private as property type <tc35178>
    And User enters all required information on MHO3 dwelling screen and sets covA as <275000> <tc35178>
    And User enters all required information on MHO3 review screen
    And User creates MHO3 application
    And User answers all underwriting questions for MHO3
    And User checks application dwelling screen and finalizes transaction <tc35178>
    And User issues policy
    And User verifies NB MHO3 policy has been created successfully and takes note of the policy number for <tc35178>
    And User searches for the policy <tc35178>
    And User clicks Start Transaction
    And User selects Endorsement
    And User sets new effective date as current date and starts endorsement <tc35178>
    And User clicks Dwelling Chevron for <tc35178>
    And User sets roof material as Other and roof update year to current year
    And User finalizes transaction
    And User validates 'Requires underwriting approval due to roof material' 'Roof Material Changed From Composition Shingle to Other' messages are visible
    And User takes note of the application number for <tc35178>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc35178>
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <tc35178>
    And User process and completes endorsement and finishes test
    
    
    
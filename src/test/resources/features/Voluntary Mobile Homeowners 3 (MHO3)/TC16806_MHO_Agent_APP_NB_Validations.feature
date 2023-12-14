# Author: Mustafa Cemek
# created on 12/05/2023
#TEST CASE NUMBER & TITLE: TC 16806--MHO Agent, APP, NB Validations "Validate error messages for MHO Characteristics_Property Type*=Park(Adult/family)
#PRECONDITIONS (IF ANY)
#HIGH LEVEL STEPS OF TEST SCRIPT:  Create an MHO Application to verify if error and edit messages trigger and that the Agent cannot bind NB policy.  Agent must submit to UW for approval before agent can bind Policy
#EXPECTED RESULTS: Agent cannot bind policy and must Submit for Approval.
#User: AG1730

@regression @tc16806 @mho3regression
Feature: TC16806_MHO_Agent_APP_NB_Validations

  Scenario: MHO_Agent_APP_NB_Validations
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address for <tc16746>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc16806>
    And User verifies messages as Owner Occupied for <tc16806>
    And User creates MHO3 application
    And User clicks Dwelling chevron
    And User enters all required information on MobileHomeowners General Information for <tc16806>
    And User verifies messages in Policy and Dwelling Chevron
    And User answers all underwriting questions for MHO3 <tc16746>
    And User checks application dwelling screen and finalizes transaction for <tc16806>
    And User verifies messages in Issues for <tc16806>
    And User updates Year Roof Material Completely Updated
    And User verifies messages for <tc16806>
    And User takes note of the application for <tc16806>
    And User clicks submit for approval button
    And User signs out
    And User login to Spin as Underwriter
    And User searches for the application <tc16806>
    And User verifies messages on issues tile
    And User approves application
    And User signs out
    Then User login to Spin as Standard Agent
    And User searches for the application <tc16806>
    And User issues new business with payment type "None"
    And User verifies policy created

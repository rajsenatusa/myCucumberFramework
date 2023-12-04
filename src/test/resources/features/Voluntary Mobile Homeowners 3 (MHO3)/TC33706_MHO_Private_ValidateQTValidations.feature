# Author: Mustafa Cemek
# created on 11/29/2023
#TEST CASE NUMBER & TITLE: TC 33706--MHO Agent, Private Property- QT Validate error messages for MHO Characteristics Property Type
#PRECONDITIONS (IF ANY)
#HIGH LEVEL STEPS OF TEST SCRIPT:  Validating the edit and error messages trigger in quote status.
#EXPECTED RESULTS: Edits, error or hard stops triggerd in Quote status
#User: AG1730
@regression @tc33706
Feature: TC33706_MHO_Private_ValidateQTValidations

  Scenario: MHO Family Private Validation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address for <tc33706>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc33706>
    And User validates error messages and delete quote for <tc33706>
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address again for <tc33706> second quote
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type again for <tc33706> second quote
    And User validates error messages and delete for <tc33706> second quote
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address again for <tc33706> third quote
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type again for <tc33706> third quote
    And User validates error messages and delete for <tc33706> third quote
    And User updates General Informations and Dwelling Details for <tc33706>
    And User validates error messages in Policy and Dwelling Cheveron for <tc33706>
    And User updates Coverage A as <1000000>
    And User validates error messages for <tc33706>
    And User updates Year of Manufacture as <2000> and Limited Fungi as <50000>
    And User validates error messages
    And User updates Attached Structures
    And User validates error messages
    And User validates that MHO3 Quote has been created successfully and takes note of the Quote number for <tc33706>

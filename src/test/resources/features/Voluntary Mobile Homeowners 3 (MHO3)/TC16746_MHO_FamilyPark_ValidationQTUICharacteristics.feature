# Author: Mustafa Cemek
# created on 12/04/2023
#TEST CASE NUMBER & TITLE: TC 16746--MHO Agent Basic Policy QT Validations - Validate error messages for MHO Characteristics Property Type-family park
#PRECONDITIONS (IF ANY)
#HIGH LEVEL STEPS OF TEST SCRIPT:  Validating that edit and error messages trigger for the following in quote status..
#EXPECTED RESULTS: Edits, error or hard stops triggerd in Quote status
#User: AG1730
@regression @tc16746 @mho3regression
Feature: TC16746_MHO_FamilyPark_ValidationQTUICharacteristics

  Scenario: MHO Family Park Validation
    Given User login to Spin as Standard Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen and enters mobile park address for <tc16746>
    And User enters MHO3 product selection information and effective date as current date
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc16746>
    And User selects Occupancy as Tenant Occupied for <tc16746>
    And User verifies error message as Tenant Occupied homes are not eligible
    And User selects Occupancy as Owner Occupied for <tc16746>
    And User updates Dwelling Chevron
    And User verifies error messages in Issues
    And User updates Coverage A and Windstorm or Hail Exclusion
    And User verifies error messages
    And User updates Coverage A as <100,000> and Windstorm or Hail Exclusion
    And User verifies Windstorm or Hail exclusion message
    And User enters all required information on MHO3 quote screen with prior exp date as current date and selects park as property type for <tc16746> second quote
    And User verifies messages in Issues
    And User updates Coverage A as <1,000,000>
    And User verifies messages
    And User updates Coverage A as <10,000>
    And User verifies messages for Coverage A
    And User updates Coverage A as <500,000>
    And User verifies messages
    And User validates that MHO3 Quote has been created successfully and takes note of the Quote number for <tc16746>
    Then User submits the application for UW approval
#Author:Mustafa Cemek
@RN_Policy_TOMHO
Feature: Renewal Policy TOMHO

  @RN_Policy_TOMHO-1
  Scenario Outline: Valid RN TOMHO policy creation with Scenario Outline
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHO and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User selects Building Territory List "<TerritoryList>"
    And User selects Attached Structures "<AttachedStructures>"
    And User enters Coverage A value "<CoverageA>"
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TOMHO review screen
    #And User creates TOMHO application
    #And User clicks special options chevron
    #And User selects treat as renewal
    #And User clicks review Chevron and selects payment plan
    #And User finalizes transaction and issues takeout policy
    #And User returns to main page
    #And User clicks Start Transaction
    #And User clicks RN Transaction Selection
    #And User clicks Finalize
    #Then User verifies RN TOMHO policy has been created successfully

    Examples: Test Data
      | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 12/24/2023    | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |    120000 |

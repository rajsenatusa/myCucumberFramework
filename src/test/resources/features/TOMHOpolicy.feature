#Author: Can Yavas
#updated on 07/18/2023 by C.Yavas
Feature: Issuing TOMHO policy

  @tomho @smoke
  Scenario: Valid TOMHO policy creation
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHO and effective date
    And User enters all required information on TOMHO quote screen
    And User enters all required information on TOMHO dwelling screen
    And User enters all required information on TOMHO review screen
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TOMHO policy has been created successfully

  @tomhoso
  Scenario Outline: Valid TOMHO policy creation with Scenario Outline
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
    And User creates TOMHO application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    Then User validates that TOMHO policy has been created successfully

    Examples: Test Data
      | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 07/25/2023    | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |    120000 |

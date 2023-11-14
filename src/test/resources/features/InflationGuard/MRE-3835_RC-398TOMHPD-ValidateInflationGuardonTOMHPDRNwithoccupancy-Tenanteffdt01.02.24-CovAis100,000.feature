#Author:Mustafa Cemek
@RN_Policy_TOMHPDInflationGuard
Feature: RC-398: 2024 Rate Changes- Inflation Guard: TO MHPD- 01/01/2024

  @RN_Policy_TOMHPDInflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3835: RC-398 TO MHPD - Validate Inflation Guard on TO MHPD RN with occupancy - Tenant eff dt 01/02/24 - Cov A is 100,000
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOMHPD and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User selects Building Territory List "<TerritoryList>"
    And User clicks CoverageA tab and enters Coverage A value "<CoverageA>"
    And User selects Attached Structures "<AttachedStructures>"
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TOMHPD review screen
    And User creates TOMHPD application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize

    Examples: Test Data
      | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 01/02/2023    | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |    100000 |

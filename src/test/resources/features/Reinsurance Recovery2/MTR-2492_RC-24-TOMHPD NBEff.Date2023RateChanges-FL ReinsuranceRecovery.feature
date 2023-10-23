#Author:Mustafa Cemek
@RN_Policy_TOMHPDReinsurance
Feature: RC-24: 2023 Rate Changes- FL Reinsurance Recovery: TO MHPD

  @RN_Policy_TOMHPDReinsurance-1 @ReinsuranceRecovery
  Scenario Outline: MTR-2492: RC-24 TO MHPD : NB > Eff. Date : 2023 Rate Changes- FL Reinsurance Recovery
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
    And User clicks Worksheets chevron
    And User clicks EC Flat Premium in Extended Coverage Building
    Then User validates TOMHPD EC Key Premium in Worksheets
    Then User validates TOMHPD EC Flat Premium in Worksheets

    Examples: Test Data
      | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 09/20/2023    | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |    120000 |

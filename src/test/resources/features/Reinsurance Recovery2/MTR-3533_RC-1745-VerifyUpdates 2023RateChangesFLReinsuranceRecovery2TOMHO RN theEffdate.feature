#Author:Mustafa Cemek
@RN_Policy_TOMHOReinsurance
Feature: RC-1745: 2023 Rate Changes- FL Reinsurance Recovery 2: TO MHO

  @RN_Policy_TOMHOReinsurance-1
  Scenario Outline: MTR-3533: RC-1745-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery 2: TO MHO - RN on the Eff date
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
    #And User clicks Windstorm or Hail Exclusion box
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
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates TOMHO base rate in Worksheets
    Then User validates TOMHO wind exclusion base rate in Worksheets

    Examples: Test Data
      | EffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 12/24/2023    | Owner Occupied | 9 to 12 Months |               2021 |            90 | No                 |    120000 |

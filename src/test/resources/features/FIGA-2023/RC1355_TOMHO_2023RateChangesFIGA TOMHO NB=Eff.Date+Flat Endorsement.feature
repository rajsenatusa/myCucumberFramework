#Author:Mustafa Cemek
@FIGA-TOMHO @FIGA
Feature: RC-1094: 2023 Rate Changes- FIGA: TO MHO- 10/01/2023

  @FIGA-TOMHO-1
  Scenario Outline: RC-1355: RC-1094 - 2023 Rate Changes: FIGA - TO MHO - NB = Eff. Date+ Flat Endorsement
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
    And User clicks Worksheets chevron
    Then User validates New FIGA TO MHO rate
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates New FIGA TO MHO rate after Endorsement

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 10/01/2023    | 10/02/2023               | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |    120000 |

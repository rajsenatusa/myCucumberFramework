#Author:Mustafa Cemek
@FIGA-TOMHO 
Feature: RC-1879: 2024 Rate Changes - FIGA: TO MHO - 1/1/2024

  @FIGA2024-TOMHO-1 @FIGA2024 @regressionFEB
  Scenario Outline: MTR-3718: RC-1879 - 2024 Rate Changes - FIGA: TO MHO - RN on the Eff date
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
    Then User validates 2024 FIGA TOMHO rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA TOMHO rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA TOMHO rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA TOMHO rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA TOMHO rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA TOMHO rate in Review

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | Occupancy      | MonthsOccupied | YearOfConstruction | TerritoryList | AttachedStructures | CoverageA |
      | 01/01/2024    | 01/02/2024               | Owner Occupied | 9 to 12 Months |               2021 |             5 | No                 |    120000 |

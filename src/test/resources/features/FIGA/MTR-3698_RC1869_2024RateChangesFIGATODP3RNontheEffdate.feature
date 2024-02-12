#Author:Mustafa Cemek
@FIGA-TODP3 
Feature: RC-1869: 2024 Rate Changes- FIGA: TO DP3 - 1/1/2024

  @FIGA2024-TODP3-1 @FIGA2024 @regressionFEB
  Scenario Outline: MTR-3698: RC-1869 - 2024 Rate Changes - FIGA: TO DP3 - RN on the Eff date
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP3 and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User selects Distance to Hydrant "<DistanceHydrant>"
    And User selects Protection Class "<ProtectionClass>"
    And User selects Dwelling Type "<DwellingType>"
    And User selects Number of Units "<NumberOfUnits>"
    And User selects Building Territory List "<TerritoryList>"
    And User clicks Save
    And User selects Quality Grade "<QualityGrade>"
    And User clicks Calculate Button
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User clicks Worksheets chevron
   Then User validates 2024 FIGA TODP3  rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA TODP3  rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA TODP3  rate in Review
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA TODP3  rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA TODP3  rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA TODP3  rate in Review

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | DistanceHydrant | ProtectionClass | DwellingType  | NumberOfUnits | TerritoryList | QualityGrade |
      | 01/01/2024    | 01/02/2024               | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 | <= 1,000 Feet   |              04 | Single Family |             2 |             5 | Economy      |

#Author:Mustafa Cemek
@RN_Policy_TODP1Reinsurance
Feature: RC-23: 2023 Rate Changes- FL Reinsurance Recovery: TO DP1

  @RN_Policy_VOLHO3Reinsurance-1
  Scenario Outline: MTR-2553: RC-23-2023 Rate Changes- FL Reinsurance Recovery: TO DP1 - RN = RN. Eff. Date
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP1 and "<EffectiveDate>"
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
    And User selects Building Territory List "<TerritoryList>"
    And User clicks Save
    And User selects Quality Grade "<QualityGrade>"
    And User clicks Calculate Button
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TODP1 review screen
    And User creates TODP1 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    And User returns to main page
    And User clicks Worksheets chevron
    And User clicks EC Key Premium in Extended Coverage
    Then User validates SeasonalBuilding TODP1 premium in Worksheets
    Then User validates WindExclusionCreditBuilding TODP1 rate in Worksheets

    Examples: Test Data
      | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | DistanceHydrant | ProtectionClass | DwellingType  | TerritoryList | QualityGrade |
      | 09/17/2022    | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 | <= 1,000 Feet   |              04 | Single Family |           492 | Economy      |

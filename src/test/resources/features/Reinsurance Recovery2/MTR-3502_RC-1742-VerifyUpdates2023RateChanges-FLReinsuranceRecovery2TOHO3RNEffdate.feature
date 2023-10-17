#Author:Mustafa Cemek
@RN_Policy_VOLHO4Reinsurance
Feature: 2023 Rate Changes- FL Reinsurance Recovery 2: TO HO3

  @RN_Policy_TOHO3Reinsurance-1
  Scenario Outline: MTR-3502: RC-1742-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery 2: TO HO3  - RN on the Eff date
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TOHO3 and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User selects Building Territory List "<TerritoryList>"
    And User clicks Windstorm or Hail Exclusion box
    And User selects Structure Rented to Others "<StructureRentedOthers>"
    And User clicks Save
    And User selects Quality Grade "<QualityGrade>"
    And User clicks Calculate Button
    And User clicks Save
    And User clicks next page button
    And User enters all required information on TOHO3 review screen
    And User creates TOHO3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects dwelling type
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User returns to main page
    And User clicks Worksheets chevron
    And User clicks Key Wind Rate
    Then User validates TOHO3 base rate in Worksheets
    Then User validates TOHO3 wind exclusion base rate in Worksheets

    Examples: Test Data
      | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | TerritoryList | StructureRentedOthers | QualityGrade | HurricaneDeductible |
      | 12/24/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |             5 | No                    | Economy      | 2%                  |

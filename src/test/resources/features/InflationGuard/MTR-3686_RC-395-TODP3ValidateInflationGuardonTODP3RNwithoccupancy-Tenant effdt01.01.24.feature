#Author:Mustafa Cemek
@RN_Policy_TODP3InflationGuard
Feature: RC-395: 2024 Rate Changes- Inflation Guard: TO DP3- 01/01/2024

  @RN_Policy_TODP3InflationGuard-1 @InflationGuard2024 @AII-Inflation
  Scenario Outline: MTR-3686: RC-395 -TO DP3 Validate Inflation Guard on TO DP3 RN with occupancy - Tenant  eff dt 01/01/24
    Given User login to Spin as Admin Agent
    When User starts transaction as a new customer
    And User enters all required information on policy information screen
    And User enters product selection information for TODP3 and "<EffectiveDate>"
    And User enters Producer Code
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
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
    And User selects Personal Liability limit
    And User selects Sinkhole Loss
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User clicks next page button
    And User enters all required information on TODP3 review screen
    And User creates TODP3 application
    And User clicks special options chevron
    And User selects treat as renewal
    And User clicks dwelling chevron and selects roof material
    And User clicks review Chevron and selects payment plan
    And User finalizes transaction and issues takeout policy
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates TODP3 Coverage A increases by 10 percent
    Then User validates TODP3 Coverage B increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TODP3 Coverage D increases by 10 percent
    Then User validates TODP3 Hurricane Coverage A Deductible percentage
    Then User validates TODP3 Sinkhole Loss
    Then User validates TODP3 Coverage A on Coverages List
    Then User validates TODP3 Coverage B on Coverages List
    Then User validates TODP3 Coverage D on Coverages List
    Then User validates CovA TODP3 Inflation Guard is 10 percent
    Then User validates CovC TODP3 Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates TODP3 10 percentage in RN Declaration Package
    Then User validates TODP3 inflated values on Dec page for first RN
    Then User validates TODP3 inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    Then User validates TODP3 Coverage A is 10 percente under Inflation Guard
    And User clicks Policy File Chevron
    And User clicks Endorsement Package link
    Then User validates TODP3 10 percentage in EN Declaration Package
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates TODP3 Coverage A increases by 10 percentage after next term RN

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy       | MonthsOccupied | YearOfConstruction | SquareFeet | DistanceHydrant | ProtectionClass | DwellingType  | NumberOfUnits | TerritoryList | QualityGrade | FireAlarm   | SprinklerSystem                                          |
      | 1/1/2023      | 1/1/2024                 | Frame            | Tenant Occupied | 9 to 12 Months |               2021 |       3000 | <= 1,000 Feet   |              04 | Single Family |             2 |             5 | Economy      | Local Alarm | Excludes attic, bathroom, closet and attached structures |

#Author:Mustafa Cemek
@RN_Policy_TODP1InflationGuard
Feature: RC-384: 2024 Rate Changes- Inflation Guard: TO DP1- 01/01/2024

  @RN_Policy_TODP1InflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3674: RC-384 TO DP1 - Validate Inflation Guard on TO DP1 RN with occupancy - Owner eff dt 01/01/24
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
    And User enters Personal Property limit
    And User selects Personal Liability limit
    And User selects Hurricane Deductible as 5 percent
    And User selects Sinkhole Loss
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
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
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates TODP1 Coverage A increases by 10 percent
    Then User validates TODP1 Coverage B increases off of Coverage A inflated limit amount of 10 percent
    Then User validates TODP1 Coverage C increases by 10 percentage
    Then User validates TODP1 Hurricane Coverage A Deductible percentage
    Then User validates TODP1 Sinkhole Loss
    Then User validates TODP1 Coverage A on Coverages List
    Then User validates TODP1 Coverage B on Coverages List
    Then User validates TODP1 Coverage C on Coverages List
    Then User validates CovA TODP1 Inflation Guard is 10 percent
    Then User validates CovC TODP1 Inflation Guard is 10 percent
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates TODP1 10 percentage in RN Declaration Package
    Then User validates TODP1 inflated values on Dec page for first RN
    Then User validates TODP1 inflated values on OIR B1 1670 form for first RN
    And User returns to main page
    And User clicks History Chevron
    And User clicks Start Transaction
    
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Dwelling chevron
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    
    
    
    Then User validates TODP1 Coverage A is 10 percente under Inflation Guard
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    
    
    
    

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | DistanceHydrant | ProtectionClass | DwellingType  | TerritoryList | QualityGrade | FireAlarm   | SprinklerSystem                                          |
      | 01/01/2023    | 01/01/2024               | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 | <= 1,000 Feet   |              04 | Single Family |             5 | Economy      | Local Alarm | Excludes attic, bathroom, closet and attached structures |

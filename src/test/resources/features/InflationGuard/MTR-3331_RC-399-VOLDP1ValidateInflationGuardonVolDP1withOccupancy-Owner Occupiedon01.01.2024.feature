#Author:Mustafa Cemek
@RN_Policy_VOLDP1InflationGuard
Feature: RC-399: 2024 Rate Changes- Inflation Guard: VOL DP1- 01/01/2024

  @RN_Policy_VOLDP1InflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3331: RC-399- VOL DP1:Validate Inflation Guard on Vol DP1 with Occupancy-Owner Occupied on 01/01/2024
    Given User navigates to QA2
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters effective date "<EffectiveDate>"
    And User enters state
    And User clicks VOL DP1 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User enters Building Code Effectiveness Grade "<BuildingCodeEffectivenessGrade>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Roof Material "<RoofMaterial>"
    And User enters DP1 Mandatory Mediation Arbitration
    And User enters Dwelling Type
    And User calculates DP1 replacement cost
    And User selects Sinkhole Loss
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User enters Roof Shape "<RoofShape>"
    And User enters SWR "<SWR>"
    And User clicks save and next page button
    And User enters DP1 Pay Plan Type
    And User enters DP1 Underwritting Questions
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates Coverage A increases by 10 percent
    Then User validates Coverage B increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates Coverage C increases by 10 percentage
    Then User validates Sinkhole Loss
    Then User validates Coverage A on Coverages List
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates 10 percentage in RN Declaration Package
    Then User validates inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Dwelling chevron
    And User enters Coverage C in Dwelling
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    Then User validates Coverage A increases by 10 percent
    Then User validates Coverage B increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates Coverage C increases by 10 percentage
    Then User validates Coverage A on Coverages List
    And User clicks Policy File Chevron
    And User clicks Endorsement Package link
    Then User validates 10 percentage in EN Package
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates Coverage A increases by 10 percent
    Then User validates Coverage C increases by 10 percentage
    Then User validates Sinkhole Loss
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates 10 percentage in RN Declaration Package for second RN 
    Then User validates inflated values on OIR B1 1670 form for second RN

    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mcemek   | Nov@2023! | 01/01/2023    | 01/01/2024               | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $2,000                  |                 20000 | Basement            | X                 | Yes                 | No           | Yes                  |

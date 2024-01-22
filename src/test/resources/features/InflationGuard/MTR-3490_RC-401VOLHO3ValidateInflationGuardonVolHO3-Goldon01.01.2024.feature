#Author:Mustafa Cemek
@RN_Policy_VOLHO3InflationGuard
Feature: RC-401: 2024 Rate Changes- Inflation Guard: VOL HO3- 01/01/2024

  @RN_Policy_VOLHO3InflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3490: RC-401 -VOL HO3 Validate Inflation Guard on Vol HO3 -Gold on 01/01/2024
    Given User navigates to Model
    And User login to Spin as Admin Agent
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters effective date "<EffectiveDate>"
    And User enters state
    And User clicks VOL HO3 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User enters Building Code Effectiveness Grade "<BuildingCodeEffectivenessGrade>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Roof Material "<RoofMaterial>"
    And User enters Fireplace "<Fireplace>"
    And User enters Exterior Walls "<ExteriorWalls>"
    And User clicks Gold Reserve Package
    And User enters Coverage A Dwelling as 230k
    And User selects Hurricane Deductible as $500
    And User enters Ordinance or Law as 50 percentage
    And User selects Sinkhole Loss
    And User enters Mandatory Mediation Arbitration
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Secured Community and Bldg "<SecuredCommunityBldg>"
    And User enters Military Discount "<MilitaryDiscount>"
    And User enters Roof Shape "<RoofShape>"
    And User enters SWR "<SWR>"
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User clicks Next Page
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User clicks Dwelling chevron
    And User clicks Finalize
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    And User clicks Dwelling chevron
    Then User validates HO3 Coverage A increases by 10 percentage
    Then User validates HO3 Coverage B increases by 10 percentage
    Then User validates HO3 Coverage C increases by 10 percentage
    Then User validates HO3 Coverage D increases by 10 percentage
    Then User validates HO3 Hurricane Deductible 2 percentage
    Then User validates HO3 Ordinance or Law increases by 10 percentage
    Then User validates Sinkhole Loss
    Then User validates HO3 Coverage A on Coverages List
    Then User validates HO3 Coverage B on Coverages List
    Then User validates HO3 Coverage C on Coverages List
    Then User validates HO3 Coverage D on Coverages List
    Then User validates HO3 Ordinance or Law on Coverages List
    Then User validates 10 percentage Inflation guard for Cov A
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL HO3 10 percentage in RN Declaration Package
    Then User validates VOL HO3 inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates HO3 Coverage A increases by 10 percentage after second RN
    Then User validates HO3 Coverage B increases by 10 percentage after second RN
    Then User validates HO3 Coverage C increases by 10 percentage after second RN
    Then User validates HO3 Coverage D increases by 10 percentage after second RN
    Then User validates HO3 Hurricane Deductible 2 percentage
    Then User validates HO3 Ordinance or Law increases by 10 percentage after second RN
    Then User validates Sinkhole Loss
    Then User validates HO3 Coverage A on Coverages List after second RN
    Then User validates HO3 Coverage B on Coverages List after second RN
    Then User validates HO3 Coverage C on Coverages List after second RN
    Then User validates HO3 Coverage D on Coverages List after second RN
    Then User validates HO3 Ordinance or Law on Coverages List after second RN
    Then User validates 10 percentage Inflation guard for Cov A after second RN
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL HO3 10 percentage in RN Declaration Package for second RN
    Then User validates VOL HO3 inflated values on OIR B1 1670 form for second RN

    Examples: Test Data
      | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial              | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm   | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | OpeningProtection> | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | 01/01/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2020 |       3000 |                              3 |               2 | 3 Tab Composition Shingle | No        | Stone         | Unknown | $50,000         | Local Alarm | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | A-Hurricane Impact | Gable     | No  | No            | $5,000                  | Slab                | D                 | Yes                 | Yes          | Yes                  |

#Author:Mustafa Cemek
@FIGA-VOLHO3
Feature: RC-1822: 2024 Rate Changes- FIGA: VOL HO3- 01/01/2024

  @FIGA2024-VOLHO3-1 @FIGA2024 @regressionFEB
  Scenario Outline: MTR-3045: RC-1822, 2024 Rate Changes - VOL HO3 - NB = Eff. Date + Flat Endorsement
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
    And User calculates replacement cost
    And User clicks Save
    And User clicks Review button
    And User selects HO3 Pay Plan Type
    And User clicks save
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User enters Number of stories
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL HO3 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL HO3 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL HO3 rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL HO3 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL HO3 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL HO3 rate in Review

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | 01/01/2024    | 01/02/2024               | Frame            | Owner Occupied | 9 to 12 Months |               2023 |       3000 |                              7 |               3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes | Yes           | $5,000                  | Basement            | X                 | Yes                 | No           | Yes                  |

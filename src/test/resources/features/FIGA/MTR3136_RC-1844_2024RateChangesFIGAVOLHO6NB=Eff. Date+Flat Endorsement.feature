#Author:Mustafa Cemek
@FIGA-VOLHO6
Feature: RC-1844: 2024 Rate Changes- FIGA: VOL HO6 - 1/1/2024

  @FIGA2024-VOLHO6-1 @FIGA2024
  Scenario Outline: MTR-3136: RC-1844, 2024 Rate Changes: FL Annual FIGA Rate Changes - VOL HO6 - NB = Eff. Date+ Flat Endorsement
    Given User navigates to Model
    And User login to Spin as Admin Agent
    When User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters effective date "<EffectiveDate>"
    And User enters state
    And User clicks VOL HO6 policy
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
    And User enters Floor number of unit location "<FloorNumber>"
    And User clicks Flood Coverage "<FloodCoverage>"
    And User clicks Flood Flood Personal Property "<FloodPersonalProperty>"
    And User selects Flood Coverage Deductible "<FloodCoverageDeductible>"
    And User selects Flood Foundation Type "<FloodFoundationType>"
    And User selects Flood Zone Override "<FloodZoneOverride>"
    And User selects Preferred Risk Status "<PreferredRiskStatus>"
    And User selects SFHA Override "<SFHAOverride>"
    And User selects Elevated Risk Discount "<ElevatedRiskDiscount>"
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User enters HO6 Underwritting Questions
    And User enters Roof Material "<RoofMaterial>"
    And User calculates replacement cost
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL HO6 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL HO6 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL HO6 rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL HO6 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL HO6 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL HO6 rate in Review

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | FloorNumber | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | 1/1/2024      | 01/02/2024               | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |                              7 |               3 |           3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes | Yes           | $5,000                  | Basement            | X                 | Yes                 | No           | Yes                  |

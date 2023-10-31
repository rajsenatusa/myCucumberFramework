#Author:Mustafa Cemek
@RN_Policy_VOLHO6InflationGuard
Feature: RC-403: 2024 Rate Changes- Inflation Guard: VOL HO6- 01/01/2024

  @RN_Policy_VOLHO6InflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3477: RC-403 -VOL HO6 Validate Inflation Guard on Vol HO6 -Silver after  01/01/2024-Owner occupied
    Given User navigates to QA2
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
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
    And User clicks Silver Reserve Package
    And User selects Hurricane Deductible as $500
    And User enters Ordinance or Law as 50 percentage
    And User selects Sinkhole Loss
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Military Discount "<MilitaryDiscount>"
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User enters HO6 Underwritting Questions
    And User enters Roof Material "<RoofMaterial>"
    And User calculates replacement cost
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize

    Examples: Test Data
      | username | password  | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | FloorNumber | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mcemek   | Nov@2023! | 01/01/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |                              7 |               3 |           3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes | Yes           | $5,000                  | Basement            | X                 | Yes                 | No           | Yes                  |

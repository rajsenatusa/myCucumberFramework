#Author:Mustafa Cemek
@RateChangeReinsuranceRecoveryHO6
Feature: RC-19: 2023 Rate Changes- FL Reinsurance Recovery: VOL HO6

  @RateChangeReinsuranceRecoveryHO6-1
  Scenario Outline: RC-1642: RC-19-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery: VOL HO6 - NB on the Eff date
    Given User navigates to QA5
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
   Then User verifies HO6 Elevation Certificate rate

    Examples: Test Data
      | username | password  | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | FloorNumber | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | jlowe    | Aug@2023! | 7/21/2023     | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |                              7 |               3 |           3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes | Yes           | $5,000                  | Basement            | X                 | Yes                 | No           | Yes                  |

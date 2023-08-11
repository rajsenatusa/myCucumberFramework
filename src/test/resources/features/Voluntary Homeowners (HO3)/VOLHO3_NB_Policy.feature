#Author:Mustafa Cemek
@NB_Policy_VOLHO3
Feature: New Business Policy VOL HO3

  @NB_Policy_VOLHO3-1
  Scenario Outline: NB VOL HO3
    Given User navigates to QA7
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
    And User clicks Reserve Package
    And User enters Coverage A Dwelling
    And User enters Animal Liability "<AnimalLiability>"
    And User enters Mandatory Mediation Arbitration
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Secured Community and Bldg "<SecuredCommunityBldg>"
    And User enters Military Discount "<MilitaryDiscount>"
    And User enters Roof Shape "<RoofShape>"
    And User enters SWR "<SWR>"
    And User clicks Flood Coverage "<FloodCoverage>"
    And User selects Flood Coverage Deductible "<FloodCoverageDeductible>"
    And User selects Flood Foundation Type "<FloodFoundationType>"
    And User selects Flood Zone Override "<FloodZoneOverride>"
    And User selects Preferred Risk Status "<PreferredRiskStatus>"
    And User selects SFHA Override "<SFHAOverride>"
    And User selects Elevated Risk Discount "<ElevatedRiskDiscount>"
    And User clicks Save
    And User clicks Review button
    And User enters Pay Plan Type
    And User clicks Next Page
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User enters Number of stories
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    Then User verifies NB HO3 policy has been created successfully

    Examples: Test Data
      | username | password  | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mkoziel  | Aug@2023! | 7/21/2023     | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |                              7 |               3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes | Yes           | $5,000                  | Basement            | X                 | Yes                 | No           | Yes                  |

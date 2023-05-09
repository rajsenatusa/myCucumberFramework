#Author:Mustafa Cemek
@RN_Policy_VOLHO3
Feature: Renewal Policy VOL HO3

  @RN_Policy_VOLHO3-1
  Scenario Outline: RN VOL HO3
    Given User navigates to QA7
    And User enters a valid user name "<username>"
    And User enters a valid password "<password>"
    And User clicks on the login button
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters New Product Version effective date "<NewProductVersionEffectiveDate>"
    And User enters state
    And User clicks VOL HO3 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User enters Email
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
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User returns to main page
    And User clicks Start Transaction
    And User clicks Transaction Selection
    And User clicks Finalize
    Then User verifies RN HO3 policy has been created successfully
    

    Examples: Test Data
      | username | password | NewProductVersionEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial              | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm   | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | OpeningProtection> | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | Jlowe    | password | 06/18/2022                     | Masonry          | Owner Occupied | 4 to 8 Months  |               2016 |       2500 |                              3 |               2 | 3 Tab Composition Shingle | No        | Stone         | Unknown | $50,000         | Local Alarm | Full            | Local Alarm  | 24 Hour Security Patrol | No               | A-Hurricane Impact | Gable     | No  | Yes           | $5,000                  | Slab                | D                 | Yes                 | Yes          | Yes                  |

  
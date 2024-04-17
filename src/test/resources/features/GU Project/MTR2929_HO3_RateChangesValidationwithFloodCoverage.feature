# Author: Mustafa Cemek
# created on 01/03/2024
#TEST CASE NUMBER & TITLE: GU-1525_MTR-2929: 2023 Rate Changes- FL Annual Filings: VOL HO3 - NB = NB. Eff. Date (04/21/2023) with Flood Coverage
#Precondition-Create a NB policy with effective date = Inception Date (04/21/2023). Add Flood coverage on the policy with the details in test steps. Validate Generated rates are as expected.
#HIGH LEVEL STEPS OF TEST SCRIPT: In the Scenario Below
#EXPECTED RESULTS: Validate Generated rates are as expected.
#User:admin
@regression @mtr2929 @gu 
Feature: MTR-2929_HO3_RateChangesValidationwithFloodCoverage

  Scenario Outline: Rate Changes Validation with Flood Coverage
    Given User navigates to Model
    And User login to Spin as Admin Agent
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    #And User enters Dwelling Address
    And User enters HO3 Dwelling Address "<DwellingAddress>"
    And User enters HO3 Dwelling Zip "<DwellingZip>"
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
    #And User enters Coverage A Dwelling
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
    And User enters Distance to Hydrant_Accredited Water Source
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User clicks Worksheets chevron
    Then User verifies Water NonWeather Base Rate <mtr2929>
    Then User verifies Fire or Lightning Base Rate <mtr2929>
    Then User verifies Other Base Rate <mtr2929>
    Then User verifies Weather Base Rate <mtr2929>
    Then User verifies Hurricane Base Rate <mtr2929>

    #Then User verifies Building Flood Rate Zone X and Foundation Basement
    #Then User verifies Personal Property Flood Rate Zone X and Foundation Basement
    #And User clicks Dwelling chevron
    #And User clicks Finalize button
    Examples: Test Data
      | EffectiveDate | DwellingAddress | DwellingZip | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | 04/21/2023    | 13405 83rd ST   |       32948 | Frame            | Owner Occupied | 9 to 12 Months |               2005 |       2000 |                              5 |               3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes | Yes           | $500                    | Slab                | A                 | Yes                 | No           | Yes                  |

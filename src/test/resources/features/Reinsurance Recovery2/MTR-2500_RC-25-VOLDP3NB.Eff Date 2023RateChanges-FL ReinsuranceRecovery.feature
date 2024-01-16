#Author:Mustafa Cemek
@NB_Policy_VOLDP3Reinsurance
Feature: RC-25: 2023 Rate Changes- FL Reinsurance Recovery: VOL DP3

  @NB_Policy_VOLDP3Reinsurance-1 @ReinsuranceRecovery
  Scenario Outline: MTR-2500: RC-25 VOL DP3 - NB = NB. Eff. Date : 2023 Rate Changes- FL Reinsurance Recovery
    Given User navigates to Model
    And User login to Spin as Admin Agent
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters effective date "<EffectiveDate>"
    And User enters state
    And User clicks VOL DP3 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Insurance Score
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User enters Short Term Rental
    And User enters Has Insured resided at the risk address
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User enters Building Code Effectiveness Grade "<BuildingCodeEffectivenessGrade>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Roof Material "<RoofMaterial>"
    And User enters DP3 Mandatory Mediation Arbitration
    And User enters Dwelling Type
    And User calculates DP3 replacement cost
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User enters Roof Shape "<RoofShape>"
    And User enters SWR "<SWR>"
    And User clicks save and next page button
    And User enters DP3 Pay Plan Type
    And User enters DP3 Underwritting Questions
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    And User clicks Hurricane Building Coverage A Base Premium in Hurricane Building
    Then User validates VOL DP3 Hurricane Coverage A Base Rate in Worksheets

    Examples: Test Data
      | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | 07/21/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2015 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $500                    |                 20000 | Basement            | X                 | Yes                 | Yes          | Yes                  |

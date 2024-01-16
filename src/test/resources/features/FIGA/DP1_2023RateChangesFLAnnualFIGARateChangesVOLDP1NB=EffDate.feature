#Author:Mustafa Cemek
@FIGA-VOLDP1
Feature: RC-1102: 2023 Rate Changes- FIGA: VOL DP1- 10/01/2023

  @FIGA-VOLDP1-1 @FIGA
  Scenario Outline: RC-1486: RC-1102 2023 Rate Changes: FL Annual FIGA Rate Changes - VOL DP1 - NB = Eff. Date+ Flat Endorsement
    Given User navigates to QA5
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
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User enters Building Code Effectiveness Grade "<BuildingCodeEffectivenessGrade>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Roof Material "<RoofMaterial>"
    And User enters DP1 Mandatory Mediation Arbitration
    And User enters Dwelling Type
    And User calculates DP1 replacement cost
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
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
    And User enters DP1 Pay Plan Type
    And User enters DP1 Underwritting Questions
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates New FIGA DP1 rate
    And User clicks History chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User clicks Worksheets chevron
    Then User validates New FIGA DP1 rate after Endorsement

    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mcemek   | Oct@2023! | 01/01/2024    | 10/02/2023               | Frame            | Vacant    | 9 to 12 Months |               2021 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $5,000                  |                 20000 | Basement            | X                 | Yes                 | No           | Yes                  |

  @FIGA-VOLDP1-2
  Scenario Outline: FIGA VOL DP1-10/01/2023: NB before Effective Date
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
    And User clicks VOL DP1 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User clicks next page button
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User enters Building Code Effectiveness Grade "<BuildingCodeEffectivenessGrade>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Roof Material "<RoofMaterial>"
    And User enters DP1 Mandatory Mediation Arbitration
    And User enters Dwelling Type
    And User calculates DP1 replacement cost
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
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
    And User enters DP1 Pay Plan Type
    And User enters DP1 Underwritting Questions
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates Previous FIGA DP1 rate

    Examples: Test Data
      | username | password   | EffectiveDate | ConstructionType | Occupancy | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mkoziel  | July@2023! | 09/30/2023    | Frame            | Vacant    | 9 to 12 Months |               2021 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $5,000                  |                 20000 | Basement            | X                 | Yes                 | No           | Yes                  |

  @FIGA-VOLDP1-3
  Scenario Outline: FIGA VOL DP1-10/01/2023: RN on Effective Date
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
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
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
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates New FIGA DP1 rate

    Examples: Test Data
      | username | password   | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mkoziel  | July@2023! | 10/01/2022    | Frame            | Owner Occupied | 9 to 12 Months |               2021 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $5,000                  |                 20000 | Basement            | X                 | Yes                 | No           | Yes                  |

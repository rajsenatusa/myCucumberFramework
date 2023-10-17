#Author:Mustafa Cemek
@FIGA-VOLDP1
Feature: RC-1834: 2024 Rate Changes- FIGA: VOL DP1 - 1/1/2024

  @FIGA2024-VOLDP1-1 @FIGA2024
  Scenario Outline: MTR-3073: RC-1834: 2024 Rate Changes- FIGA: VOL DP1 - NB = Eff. Date+ Flat Endorsement
    Given User navigates to Model
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
    Then User validates 2024 FIGA VOL DP1 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL DP1 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL DP1 rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL DP1 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL DP1 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL DP1 rate in Review

    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mcemek   | Oct@2023! | 01/01/2024    | 10/02/2024               | Frame            | Vacant    | 9 to 12 Months |               2021 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $5,000                  |                 20000 | Basement            | X                 | Yes                 | No           | Yes                  |

  
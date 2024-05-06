#Author:Mustafa Cemek
@RN_Policy_VOLDP3InflationGuard
Feature: RC-400: 2024 Rate Changes- Inflation Guard: VOL DP3- 01/01/2024

  @RN_Policy_VOLDP3InflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3425: RC-400-VOL DP3:Validate Inflation Guard on Vol DP3 with Occupancy-Owner Occupied on 01/02/2024-Integrity Select
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
    And User clicks Integrity Select in Dwelling Detail
    And User selects Hurricane Deductible as 10 percent
    And User selects Sinkhole Loss
    And User enters DP3 Mandatory Mediation Arbitration
    And User enters Dwelling Type
    And User calculates DP3 replacement cost
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
    And User enters DP3 Pay Plan Type
    And User enters DP3 Underwritting Questions
    And User clicks Next Page
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates DP3 Coverage A increases by 10 percentage
    Then User validates DP3 Coverage B increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates DP3 Coverage C increases by 10 percentage
    Then User validates DP3 Coverage E increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates DP3 Hurricane Coverage A Deductible percentage
    Then User validates Sinkhole Loss
    #Then User validates DP3 Coverage A on Coverages List
    #Then User validates DP3 Coverage B on Coverages List
    #Then User validates DP3 Coverage C on Coverages List
    #Then User validates DP3 Coverage E on Coverages List
    Then User validates DP3 A Dwelling Flood on Coverages List
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL DP3 10 percentage in RN Declaration Package
    Then User validates VOL DP3 inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    Then User validates DP3 Coverage A increases by 10 percentage
    Then User validates DP3 Coverage B increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates DP3 Coverage C increases by 10 percentage
    Then User validates DP3 Coverage E increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates DP3 Hurricane Coverage A Deductible percentage
    Then User validates Sinkhole Loss
    #Then User validates DP3 Coverage A on Coverages List
    #Then User validates DP3 Coverage B on Coverages List
    #Then User validates DP3 Coverage C on Coverages List
    #Then User validates DP3 Coverage E on Coverages List
    Then User validates DP3 A Dwelling Flood on Coverages List
    And User clicks Policy File Chevron
    And User clicks Endorsement Package link
    Then User validates VOL DP3 10 percentage in EN Package
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates DP3 Coverage A increases by 10 percentage
    Then User validates DP3 Coverage B increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates DP3 Coverage C increases by 10 percentage
    Then User validates DP3 Coverage E increases off of Coverage A inflated limit amount of 10 percentage
    Then User validates DP3 Hurricane Coverage A Deductible percentage
    Then User validates Sinkhole Loss
    #Then User validates DP3 Coverage A after second RN on Coverages List
    #Then User validates DP3 Coverage B after second RN on Coverages List
    #Then User validates DP3 Coverage C after second RN on Coverages List
    #Then User validates DP3 Coverage E after second RN on Coverages List
    Then User validates DP3 A Dwelling Flood after second RN on Coverages List
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL DP3 10 percentage in RN Declaration Package for second RN
    Then User validates VOL DP3 inflated values on OIR B1 1670 form for second RN

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | 01/02/2023    | 01/02/2024               | Frame            | Owner Occupied | 9 to 12 Months |               2018 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $500                    |                 20000 | Basement            | X                 | Yes                 | Yes          | Yes                  |

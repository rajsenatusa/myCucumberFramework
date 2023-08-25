#Author:Mustafa Cemek
@UnderwritingChanges&Enhancements
Feature: RC-2025: 2023 Underwriting Changes/Enhancements: Task Timings- YOC 4-point follow up

  @UnderwritingChanges-TaskTimings
  Scenario Outline: RC-2079: RC-2025 2023 Underwriting ChangesEnhancements Task Timings- YOC 4-point follow up - Year of Construction 21-30 years
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
    And User clicks Dwelling chevron
    And User calculates replacement cost
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User takes issued policy number
    And User clicks Tasks chevron
    Then User verifies Warning Message in Description
    And User hovers over Admin 
    And User clicks Changes Date
    And User clicks Home
    And User clicks Inbox
    Then User clicks Ctrl+F
    Then User verifies Warning Message in Inbox
    
    

    Examples: Test Data
      | username | password   | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | FireAlarm    | SprinklerSystem | RoofShape | SWR | FloodCoverage | FloodCoverageDeductible | FloodPersonalProperty | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mkoziel    | July@2023! | 09/23/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2000 |       3000 |                              7 |               3 | Architectural Composition Shingle | Fire Station | Full            | HIP       | Yes | Yes           | $500                    |                 20000 | Basement            | X                 | Yes                 | Yes          | Yes                  |

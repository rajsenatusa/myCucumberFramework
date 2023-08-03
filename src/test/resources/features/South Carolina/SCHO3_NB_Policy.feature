#Author:Mustafa Cemek
@NB_Policy_VOLHO3
Feature: New Business Policy VOL SCHO3

  @NB_Policy_SCHO3-1
  Scenario Outline: NB VOL SCHO3
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
    And User enters SC state
    And User clicks Continue button
    And User enters SC Producer Code
    And User clicks SC Prior Carrier
    And User enters SC Prior Policy Expiration Date
    And User selects New Purchase
    And User selects SC Marital Status
    And User enters Primary Phone
    And User clicks No Email
    And User clicks SC Prior Carrier
    And User selects Are any residents within the household smokers
    And User selects New Purchase
    And User selects Number of residents aged 18 and over
    And User selects Number of residents aged 17 and under
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks Save
    And User clicks Next Page
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Square Feet "<SquareFeet>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Roof Material "<RoofMaterial>"
    And User enters Fireplace "<Fireplace>"
    And User enters Exterior Walls "<ExteriorWalls>"
    And User selects Wood Burning Stove
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Secured Community and Bldg "<SecuredCommunity>"
    And User selects Opening Protection
    And User clicks Save
    And User calculates replacement cost
    And User clicks Create Application
    And User clicks Next Page
    And User answers all underwriting questions for SC HO3

    #And User enters Roof Shape "<RoofShape>"
    #And User enters Insurance Score
    #And User clicks Reserve Package
    #And User enters Coverage A Dwelling
    #And User enters Animal Liability "<AnimalLiability>"
    #And User enters Mandatory Mediation Arbitration
    #And User enters Sprinkler System "<SprinklerSystem>"
    #And User enters Military Discount "<MilitaryDiscount>"
    #And User enters SWR "<SWR>"
    #And User clicks Flood Coverage "<FloodCoverage>"
    #And User selects Flood Coverage Deductible "<FloodCoverageDeductible>"
    #And User selects Flood Foundation Type "<FloodFoundationType>"
    #And User selects Flood Zone Override "<FloodZoneOverride>"
    #And User selects Preferred Risk Status "<PreferredRiskStatus>"
    #And User selects SFHA Override "<SFHAOverride>"
    #And User selects Elevated Risk Discount "<ElevatedRiskDiscount>"
    #And User clicks Save
    #And User clicks Review button
    #And User enters MHO3 Pay Plan Type
    #And User clicks Next Page
    #And User enters HO3 Underwritting Questions
    #And User enters Dwelling Type
    #And User enters Number of stories
    #And User clicks Finalize button
    #And User selects Payment Type
    #And User clicks Issue New Business
    #Then User verifies NB HO3 policy has been created successfully
    Examples: Test Data
      | username | password   | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial           | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm   | SprinklerSystem | BurglarAlarm | SecuredCommunity        | MilitaryDiscount | RoofShape     | SWR | FloodCoverage | FloodCoverageDeductible | FloodFoundationType | FloodZoneOverride | PreferredRiskStatus | SFHAOverride | ElevatedRiskDiscount |
      | mcemek   | Aug@2023! | 08/05/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2023 |       3000 |                              7 |               3 | Architectural Shingles | Yes       | Brick         | Yes     | $100,000        | Smoke Alarm | Full            | Smart Alarm  | 24 Hour Security Patrol | Yes              | Hip roof only | Yes | Yes           | $5,000                  | Basement            | X                 | Yes                 | No           | Yes                  |

#Author:Mustafa Cemek
@RateChange2HO3
Feature: RC-28:2 2023 Rate Changes- FL Reinsurance Recovery 2 VOL HO3

  @RateChange2HO3-1
  Scenario Outline: RC-2031: RC-28-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery 2: VOL HO3 - NB on the Eff date (BaseRate - Construction Year greater than 1 year)
    Given User navigates to QA2
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
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User clicks Save
    And User clicks Next Page
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User verifies Fire or Lightning Base Rate 2
    Then User verifies Weather Base Rate 2
    Then User verifies Hurricane Base Rate 2

    Examples: Test Data
      | username | password  | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR |
      | Jlowe    | Aug@2023! | 8/25/2023     | Frame            | Owner Occupied | 0 to 3 Months  |               2015 |       2000 |                              7 |               3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes |

  @RateChange2HO3-2
  Scenario Outline: RC-28-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery 2: VOL HO3 - NB on the Eff date (BaseRateBuilders - Construction Year 0-1 year)
    Given User navigates to QA2
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
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User clicks Save
    And User clicks Next Page
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    Then User verifies Fire or Lightning Base Rate 2
    Then User verifies Weather Base Rate 2
    Then User verifies Hurricane Base Rate 2

    Examples: Test Data
      | username | password  | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR |
      | Jlowe    | Aug@2023! | 8/25/2023     | Frame            | Owner Occupied | 0 to 3 Months  |               2023 |       3000 |                              7 |               3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes |

      @RateChange2HO3-3
  Scenario Outline: RC-28-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery 2: VOL HO3 - RN on the Eff date (BaseRate - Construction Year greater than 1 year)
    Given User navigates to QA2
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
    And User clicks save and next page button
    And User enters Pay Plan Type
    And User clicks Save
    And User clicks Next Page
    And User enters HO3 Underwritting Questions
    And User enters Dwelling Type
    And User clicks Dwelling chevron
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    And User clicks Worksheets chevron
    Then User verifies Fire or Lightning Base Rate 2
    Then User verifies Weather Base Rate 2
    Then User verifies Hurricane Base Rate 2

    Examples: Test Data
      | username | password  | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | SquareFeet | BuildingCodeEffectivenessGrade | NumberOfStories | RoofMaterial                      | Fireplace | ExteriorWalls | PoolSpa | AnimalLiability | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR |
      | mcemek    | Aug@2023! | 10/22/2022     | Frame            | Owner Occupied | 0 to 3 Months  |               2021 |       3000 |                              7 |               3 | Architectural Composition Shingle | Yes       | Brick         | Yes     | $100,000        | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes |
      
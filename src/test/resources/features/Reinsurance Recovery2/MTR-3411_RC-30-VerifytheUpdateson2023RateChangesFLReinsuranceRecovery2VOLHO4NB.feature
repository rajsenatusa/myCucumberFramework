#Author:Mustafa Cemek
@NB_Policy_VOLHO4Reinsurance
Feature: RC-30: 2023 Rate Changes- FL Reinsurance Recovery 2: VOL HO4

  @NB_Policy_VOLHO3Reinsurance-1 @ReinsuranceRecovery
  Scenario Outline: MTR-3411: RC-30-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery2: VOL HO4 - NB on the Eff date
    Given User navigates to Model
    And User login to Spin as Admin Agent
    And User hovers over quote and policy
    And User clicks new custemer and quote
    And User clicks Entity Type
    And User enters Customer Informations
    And User enters Dwelling Address
    And User enters effective date "<EffectiveDate>"
    And User enters state
    And User clicks VOL HO4 policy
    And User enters Producer Code
    And User clicks Prior Carrier
    And User enters Prior Policy Expiration Date
    And User selects Mobile Home
    And User enters Primary Phone
    And User clicks No Email
    And User enters Construction Type "<ConstructionType>"
    And User enters Occupancy "<Occupancy>"
    And User enters Months Occupied "<MonthsOccupied>"
    And User clicks Next Page
    And User enters Year of Construction "<YearOfConstruction>"
    And User enters Building Code Effectiveness Grade "<BuildingCodeEffectivenessGrade>"
    And User enters Number of stories "<NumberOfStories>"
    And User enters Personal Property
    And User enters Fire Alarm "<FireAlarm>"
    And User enters Sprinkler System "<SprinklerSystem>"
    And User enters Burglar Alarm "<BurglarAlarm>"
    And User enters Roof Shape "<RoofShape>"
    And User enters SWR "<SWR>"
    And User clicks Save
    And User clicks Review button
    And User enters Pay Plan Type for HO4
    And User answers all underwriting questions for HO4
    And User enters Dwelling Type
    And User enters Number of stories
    And User clicks Finalize button
    And User selects Payment Type
    And User clicks Issue New Business
    And User returns to main page
    And User clicks Worksheets chevron
    And User clicks NonHurricane Base Premium
    Then User validates NonHurricane VOL HO4 base rate in Worksheets
    And User clicks Hurricane Base Premium
    Then User validates Hurricane VOL HO4 base rate in Worksheets

    Examples: Test Data
      | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | BuildingCodeEffectivenessGrade | NumberOfStories | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR |
      | 10/27/2023    | Frame            | Owner Occupied | 9 to 12 Months |               2021 |                              7 |               3 | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes |

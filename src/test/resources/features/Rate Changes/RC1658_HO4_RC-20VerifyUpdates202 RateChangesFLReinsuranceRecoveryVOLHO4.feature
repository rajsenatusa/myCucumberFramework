#Author:Mustafa Cemek
@RateChangeReinsuranceRecoveryHO4
Feature: RC-20: 2023 Rate Changes- FL Reinsurance Recovery: VOL HO4

  @RateChangeReinsuranceRecoveryHO4-1
  Scenario Outline: RC-1658: RC-20-Verify the Updates on 2023 Rate Changes- FL Reinsurance Recovery: VOL HO4 - NB on the Eff date
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
    And User clicks Worksheets chevron
    And User clicks Hurricane Base Premium
    Then User verifies VOL HO4 Hurricane Base Rate

    Examples: Test Data
      | username | password  | EffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | BuildingCodeEffectivenessGrade | NumberOfStories | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR |
      | jlowe    | Aug@2023! | 7/21/2023     | Frame            | Owner Occupied | 9 to 12 Months |               2021 |                              7 |               3 | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes |

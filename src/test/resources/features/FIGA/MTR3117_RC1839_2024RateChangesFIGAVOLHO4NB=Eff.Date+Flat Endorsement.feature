#Author:Mustafa Cemek
@FIGA-VOLHO4
Feature: RC-1839: 2024 Rate Changes- FIGA: VOL HO4 - 1/1/2024

  @FIGA2024-VOLHO4-1 @FIGA2024
  Scenario Outline: MTR-3117: RC-1839 2024 Rate Changes- FIGA: VOL HO4 - NB = Eff. Date+ Flat Endorsement
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
    Then User validates 2024 FIGA VOL HO4 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL HO4 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL HO4 rate in Review
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Finalize button
    And User clicks Endorse Policy button
    And User returns to main page
    And User clicks Worksheets chevron
    Then User validates 2024 FIGA VOL HO4 rate in Worksheets
    And User clicks Premium Info Chevron
    Then User validates 2024 FIGA VOL HO4 rate in Premium Info
    And User clicks Review Chevron
    Then User validates 2024 FIGA VOL HO4 rate in Review

    Examples: Test Data
      | username | password  | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy      | MonthsOccupied | YearOfConstruction | BuildingCodeEffectivenessGrade | NumberOfStories | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR |
      | mcemek   | Oct@2023! | 1/1/2024      | 1/2/2024                 | Frame            | Owner Occupied | 9 to 12 Months |               2021 |                              7 |               3 | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes |

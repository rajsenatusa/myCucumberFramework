#Author:Mustafa Cemek
@RN_Policy_VOLHO4InflationGuard
Feature: RC-402: 2024 Rate Changes- Inflation Guard: VOL HO4- 01/01/2024

  @RN_Policy_VOLHO4InflationGuard-1 @InflationGuard2024
  Scenario Outline: MTR-3440: RC-402-VOL HO4:Validate Inflation Guard on Vol HO4 with Occupancy-Tenant Occupied after  01/01/2024
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
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Finalize
    And User clicks Dwelling chevron
    Then User validates HO4 Coverage C increases by 10 percentage
    Then User validates HO4 Coverage D increases by 10 percentage
    Then User validates HO4 Coverage C on Coverages List
    Then User validates HO4 Coverage D on Coverages List
    Then User validates 10 percentage Inflation guard for Cov C
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL HO4 10 percentage in RN Declaration Package
    Then User validates VOL HO4 inflated values on OIR B1 1670 form for first RN
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks EN Transaction Selection
    And User enters EN Effective Date "<EndorsementEffectiveDate>"
    And User clicks Endorse Policy button
    And User clicks Dwelling chevron
    Then User validates 10 percentage Inflation guard for Cov C
    And User clicks Policy File Chevron
    And User clicks Endorsement Package link
    Then User validates VOL HO4 10 percentage in EN Package
    And User clicks History Chevron
    And User clicks Start Transaction
    And User clicks RN Transaction Selection
    And User clicks Save
    And User clicks Finalize button
    And User clicks Process
    And User clicks Dwelling chevron
    Then User validates HO4 Coverage C increases by 10 percentage after second RN
    Then User validates HO4 Coverage D increases by 10 percentage after second RN
    Then User validates HO4 Coverage C on Coverages List after second RN
    Then User validates HO4 Coverage D on Coverages List after second RN
    Then User validates 10 percentage Inflation guard for Cov C
    And User clicks Policy File Chevron
    And User clicks Renewal Decleration link
    Then User validates VOL HO4 10 percentage in RN Declaration Package
    Then User validates VOL HO4 inflated values on OIR B1 1670 form for first RN

    Examples: Test Data
      | EffectiveDate | EndorsementEffectiveDate | ConstructionType | Occupancy       | MonthsOccupied | YearOfConstruction | BuildingCodeEffectivenessGrade | NumberOfStories | FireAlarm    | SprinklerSystem | BurglarAlarm | SecuredCommunityBldg    | MilitaryDiscount | RoofShape | SWR |
      | 01/01/2023    | 01/01/2024               | Frame            | Tenant Occupied | 9 to 12 Months |               2021 |                              7 |               3 | Fire Station | Full            | Local Alarm  | 24 Hour Security Patrol | Yes              | HIP       | Yes |
